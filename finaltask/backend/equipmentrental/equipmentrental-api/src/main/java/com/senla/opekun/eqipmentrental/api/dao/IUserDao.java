package com.senla.opekun.eqipmentrental.api.dao;

import com.senla.opekun.eqipmentrental.model.Role;
import com.senla.opekun.eqipmentrental.model.User;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IUserDao extends IGenericDao<User> {

    public User getUserWithPerson(Long id);

    public List<User> getDebtorUsers();

    public List<User> getUsersByRole(Role role);

    public User getUserByLogin(String login);

    public User getUserByNickname(String nickname);

}
