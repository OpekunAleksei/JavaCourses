package com.senla.opekun.eqipmentrental.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.senla.opekun.eqipmentrental.model.enums.ActionNames;
import com.senla.opekun.eqipmentrental.model.generic.Model;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Entity
@Table(name = "audit")
public class Audit extends Model {

    private static final long serialVersionUID = 1L;
    @Column(name = "action_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date actionDate;
    @Column(name = "entity_id", nullable = false)
    private Long entityId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(name = "action_name", nullable = false)
    private ActionNames actionName;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Audit() {
    }

    public Audit(Date actionDate, Long entityId, User user, ActionNames actionName) {
        this.actionDate = actionDate;
        this.entityId = entityId;
        this.user = user;
        this.actionName = actionName;

    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public Long getEntityId() {
        return entityId;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public ActionNames getActionName() {
        return actionName;
    }

    public User getUser() {
        return user;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public void setActionName(ActionNames actionName) {
        this.actionName = actionName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
