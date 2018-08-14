package com.senla.opekun.eqipmentrental.model.generic;

import java.io.Serializable;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public abstract class Model implements Serializable {

    private static final long serialVersionUID = -8159395521414677065L;

    public abstract Long getId();

    public abstract void setId(Long id);

}
