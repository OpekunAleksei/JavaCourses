package com.senla.opekun.eqipmentrental.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.senla.opekun.eqipmentrental.api.service.IRoleService;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.web.dto.user.RoleDto;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResponseBuilder responseBuilder;
    @Autowired
    private DozerBeanMapper mapper;

    @RequestMapping(path = "/roles", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getRoles() {

	List<RoleDto> responseRoles = new ArrayList<RoleDto>();
	this.roleService.getRoles().forEach((role) -> {
	    responseRoles.add(mapper.map(role, RoleDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, responseRoles);
    }
}
