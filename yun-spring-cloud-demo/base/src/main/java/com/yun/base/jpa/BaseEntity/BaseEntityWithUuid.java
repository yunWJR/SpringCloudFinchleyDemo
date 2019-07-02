package com.yun.base.jpa.BaseEntity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The itemType Base entity with uuid.
 */
@MappedSuperclass // 实体是一个超类，保证不会被 Spring 实例化
public abstract class BaseEntityWithUuid {
    @Id
    @GenericGenerator(name = "UuidGenerator", strategy = "org.hibernate.id.UUIDGenerator") //这个是hibernate的注解->生成32位UUID
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