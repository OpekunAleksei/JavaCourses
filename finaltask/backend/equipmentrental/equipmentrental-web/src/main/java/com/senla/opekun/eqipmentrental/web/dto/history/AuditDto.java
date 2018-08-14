package com.senla.opekun.eqipmentrental.web.dto.history;

import com.senla.opekun.eqipmentrental.model.enums.ActionNames;
import java.util.Date;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class AuditDto {

    private Date actionDate;

    private Long entityId;

    private ActionNames actionName;

    public Date getActionDate() {
	return actionDate;
    }

    public ActionNames getActionName() {
	return actionName;
    }

    public Long getEntityId() {
	return entityId;
    }

    public void setActionDate(Date actionDate) {
	this.actionDate = actionDate;
    }

    public void setActionName(ActionNames actionName) {
	this.actionName = actionName;
    }

    public void setEntityId(Long entityId) {
	this.entityId = entityId;
    }

}
