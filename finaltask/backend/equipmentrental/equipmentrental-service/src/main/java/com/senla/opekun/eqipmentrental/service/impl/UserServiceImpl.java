package com.senla.opekun.eqipmentrental.service.impl;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.senla.opekun.eqipmentrental.api.dao.IRoleDao;
import com.senla.opekun.eqipmentrental.api.dao.IUserDao;
import com.senla.opekun.eqipmentrental.api.service.IUserService;
import com.senla.opekun.eqipmentrental.exceptions.LoginExist;
import com.senla.opekun.eqipmentrental.exceptions.SignInException;
import com.senla.opekun.eqipmentrental.model.Person;
import com.senla.opekun.eqipmentrental.model.Role;
import com.senla.opekun.eqipmentrental.model.User;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation = Isolation.SERIALIZABLE)
public class UserServiceImpl implements IUserService {

    private final static String DEFAULT_ROLE = "default_role";

    @Resource(name = "serviceConfiguration")
    private Properties properties;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<User> getUsersByRole(Role role) {
        return this.userDao.getUsersByRole(role);
    }

    @Override
    public List<User> getUsers() {
        return this.userDao.getAll();
    }

    @Override
    public List<User> getDebtorUsers() {
        return this.userDao.getDebtorUsers();
    }

    @Override
    public User updateUser(User user) {
        if (user.getPassword() != null) {
            user.setPassword(encryptionPassword(user));

        } else {
            user.setPassword(this.userDao.getById(user.getId()).getPassword());
        }
        this.userDao.update(user);
        return this.userDao.getUserWithPerson(user.getId());
    }

    @Override
    public void deleteUser(Long id) {
        this.userDao.delete(id);
    }

    @Override
    public void chekUserLogin(String login) throws LoginExist {
        if (this.userDao.getUserByLogin(login) != null) {
            throw new LoginExist();
        }
    }

    @Override
    public void checkUserNickname(String nickName) throws LoginExist {
        if (this.userDao.getUserByNickname(nickName) != null) {
            throw new LoginExist();
        }
    }

    @Override

    public User createUser(User user) {
        user.setRole(roleDao.getRoleByName(properties.getProperty(DEFAULT_ROLE)));
        user.setPassword(encryptionPassword(user));
        return this.userDao.save(user);

    }

    @Override
    public User getUserWithPerson(Long id) {
        return this.userDao.getUserWithPerson(id);
    }

    @Override
    public User getUserForSignIn(User user) throws SignInException {

        User persistentUser = this.userDao.getUserByLogin(user.getLogin());
        if (persistentUser != null && persistentUser.getPassword().equals(encryptionPassword(user))) {
            return persistentUser;
        } else {
            throw new SignInException();
        }
    }

    @Override
    public User getUserById(Long id) {
        return this.userDao.getById(id);
    }

    private String encryptionPassword(User user) {
        
        Integer password = user.getPassword().hashCode();
        return password.toString();
    }
}
