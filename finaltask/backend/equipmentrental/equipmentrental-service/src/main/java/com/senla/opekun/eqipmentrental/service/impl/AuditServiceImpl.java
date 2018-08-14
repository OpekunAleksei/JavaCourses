package com.senla.opekun.eqipmentrental.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.senla.opekun.eqipmentrental.api.dao.IAuditDao;
import com.senla.opekun.eqipmentrental.api.service.IAuditService;
import com.senla.opekun.eqipmentrental.model.Audit;
import com.senla.opekun.eqipmentrental.model.User;
import com.senla.opekun.eqipmentrental.model.enums.ActionNames;
import com.senla.opekun.eqipmentrental.model.generic.Model;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Service
@Transactional(isolation=Isolation.SERIALIZABLE)
public class AuditServiceImpl implements IAuditService {

    @Autowired
    private IAuditDao auditDao;

    @Override
    public List<Audit> getAuditDataOfUser(User user) {
        return this.auditDao.getAuditOfUser(user);
    }

    @Override
    public void createAuditData(User user, ActionNames actionName, Model model) {
        Audit audit = new Audit(new Date(), model.getId(), user, actionName);
        this.auditDao.save(audit);
    }

}
