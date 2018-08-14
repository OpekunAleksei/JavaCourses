package com.senla.opekun.eqipmentrental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.senla.opekun.eqipmentrental.model.generic.Model;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Entity
@Table(name = "roles")
public class Role extends Model {

    private static final long serialVersionUID = -6327877937115128276L;
    @Column(name = "title", unique = true, nullable = false)
    private String title;
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Role() {
    }

    public Role(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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
