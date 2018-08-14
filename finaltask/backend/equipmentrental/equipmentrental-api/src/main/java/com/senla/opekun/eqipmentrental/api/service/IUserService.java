package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.exceptions.LoginExist;
import com.senla.opekun.eqipmentrental.exceptions.SignInException;
import com.senla.opekun.eqipmentrental.model.Role;
import com.senla.opekun.eqipmentrental.model.User;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IUserService {

    public List<User> getUsersByRole(Role role);

    public List<User> getDebtorUsers();

    public User updateUser(User user);

    public void deleteUser(Long id);

    public User getUserWithPerson(Long id);

    public User createUser(User user);

    /**
     * @param user
     *            пользователь который входит в систему
     * @return пользователя если такой существет в базе данных
     * @throws com.senla.opekun.eqipmentrental.exceptions.SignInException
     *             если такого пользователя не существует в базе данных
     */
    public User getUserForSignIn(User user) throws SignInException;

    public List<User> getUsers();

    public User getUserById(Long id);

    /**
     * @param login
     *            содержит логин для регистрации
     * @throws com.senla.opekun.eqipmentrental.exceptions.LoginExist
     *             если логин пользователя существует
     */
    public void chekUserLogin(String login) throws LoginExist;
    
    public void checkUserNickname(String nickName) throws LoginExist;
    
}
