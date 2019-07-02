package com.yun.base.jpa.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The itemType Base entity with auto id.
 *
 * @Description: userservice auto id
 * @Author: yun
 * @CreatedOn: 2018 /5/28 09:51.
 */
@MappedSuperclass
public abstract class BaseEntityWithAutoId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id
     *         the id
     */
    public void setId(Long id) {
        this.id = id;
    }
}