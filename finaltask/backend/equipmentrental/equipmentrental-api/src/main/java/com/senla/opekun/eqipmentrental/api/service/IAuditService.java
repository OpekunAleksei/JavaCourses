package com.senla.opekun.eqipmentrental.api.service;

import com.senla.opekun.eqipmentrental.model.Audit;
import com.senla.opekun.eqipmentrental.model.User;
import com.senla.opekun.eqipmentrental.model.enums.ActionNames;
import com.senla.opekun.eqipmentrental.model.generic.Model;
import java.util.List;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public interface IAuditService {

    /**
     * Получение данных аудит пользовтеля
     *
     * @param user это пользователья для нахождения данных аудита.
     * @return коллекцию данных аудита пользователя
     */
    public List<Audit> getAuditDataOfUser(User user);

    /**
     * Создание аудита пользовтеля включающего в себя
     *
     * @param user это пользователья для нахождения данных аудита.
     * @param actionName дата совершения действия.
     * @param model изменяемые данные.
     */
    public void createAuditData(User user, ActionNames actionName, Model model);

}
