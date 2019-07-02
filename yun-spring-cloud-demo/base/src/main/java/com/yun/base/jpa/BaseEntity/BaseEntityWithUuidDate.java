package com.yun.base.jpa.BaseEntity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author: yun
 * @createdOn: 2018/6/7 14:06.
 */

@MappedSuperclass
public class BaseEntityWithUuidDate extends BaseEntityWithDate {

    @Id
    @GenericGenerator(name = "UuidGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UuidGenerator")
    private String id;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id
     *         the id
     */
    public void setId(String id) {
        this.id = id;
    }
}
