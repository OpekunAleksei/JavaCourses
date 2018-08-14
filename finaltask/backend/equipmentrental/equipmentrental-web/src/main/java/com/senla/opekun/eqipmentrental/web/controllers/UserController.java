package com.senla.opekun.eqipmentrental.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.senla.opekun.eqipmentrental.api.service.IUserService;
import com.senla.opekun.eqipmentrental.api.token.ITokenBuilder;
import com.senla.opekun.eqipmentrental.api.token.ITokenRepository;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.exceptions.SignInException;
import com.senla.opekun.eqipmentrental.model.Role;
import com.senla.opekun.eqipmentrental.model.User;
import com.senla.opekun.eqipmentrental.web.dto.user.RequestUserDto;
import com.senla.opekun.eqipmentrental.web.dto.user.RoleDto;
import com.senla.opekun.eqipmentrental.web.dto.user.UserDto;
import com.senla.opekun.eqipmentrental.web.dto.user.UserWithPersonDto;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ITokenBuilder tokenBuilder;
    @Autowired
    private ITokenRepository tokenRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private IResponseBuilder responseBuilder;
    @Autowired
    private DozerBeanMapper mapper;

    @RequestMapping(path = "/chekLogin", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> checkUserLogin(@RequestBody String login) throws Exception {
	this.userService.chekUserLogin(login);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "/chekNick", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> checkUserNickName(@RequestBody String nickName) throws Exception {
	this.userService.checkUserNickname(nickName);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "/createUser", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> createUser(@RequestBody RequestUserDto user) {
	User requestuser = mapper.map(user, User.class);
	userService.createUser(requestuser);

	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "/signIn", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> signIn(@RequestBody RequestUserDto user) throws SignInException {
	User requestUser = mapper.map(user, User.class);
	User userForSignIn = this.userService.getUserForSignIn(requestUser);
	String token = tokenBuilder.createWebToken(userForSignIn);
	tokenRepository.setUserToken(userForSignIn, token);
	List<Object> response = new ArrayList<Object>();
	response.add(mapper.map(userForSignIn, UserDto.class));
	response.add(token);
	return responseBuilder.createResponse(Boolean.TRUE, null, response);
    }

    @RequestMapping(path = "/signOut", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> signOut(@RequestBody String token) {
	tokenRepository.destroyUserToken(token);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getUserWithPerson(@PathVariable(value = "id") Long id) {
	User userWithPerson = this.userService.getUserWithPerson(id);
	UserWithPersonDto responseUser = mapper.map(userWithPerson, UserWithPersonDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseUser);
    }

    @RequestMapping(path = "/changeProfile", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> changUserProfile(@RequestBody RequestUserDto userDto) {
	User requestuser = mapper.map(userDto, User.class);
	User updateUser = this.userService.updateUser(requestuser);
	UserWithPersonDto responseUser = mapper.map(updateUser, UserWithPersonDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseUser);
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getAllUsers() {
	List<UserDto> users = new ArrayList<UserDto>();
	this.userService.getUsers().forEach((user) -> {
	    users.add(mapper.map(user, UserDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, users);
    }

    @RequestMapping(path = "/usersByRole", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getUsersByRole(@RequestBody RoleDto role) {
	List<UserDto> users = new ArrayList<UserDto>();
	this.userService.getUsersByRole(mapper.map(role, Role.class)).forEach((user) -> {
	    users.add(mapper.map(user, UserDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, users);
    }

    @RequestMapping(path = "/debtorUsers", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getDebtorUsers() {
	List<UserDto> users = new ArrayList<UserDto>();
	this.userService.getDebtorUsers().forEach((user) -> {
	    users.add(mapper.map(user, UserDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, users);
    }
}
