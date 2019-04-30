package com.yun.base.jpa.Repository;

import com.yun.base.Util.StringUtil;
import com.yun.base.module.Bean.BaseRstBean;
import com.yun.base.module.Bean.BaseRstBeanHelper;
import com.yun.base.module.Bean.BaseRstModuleType;
import com.yun.base.module.Bean.RstBeanException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * The itemType Repository helper.
 * @param <T> the itemType parameter
 * @author: yun
 * @createdOn: 2018 /5/30 09:44.
 */
@Component
public class RepositoryHelper<T> {

    // region --Field

    private String entityName = "对象";

    private BaseRstBeanHelper rstBeanHelper = new BaseRstBeanHelper(BaseRstModuleType.Dao, "RepositoryHelper");

    // endregion

    // region --Constructor

    public RepositoryHelper() {
    }

    public RepositoryHelper(String entityName) {
        this.entityName = entityName;

        rstBeanHelper.setModuleData(this.entityName);
    }

    // endregion

    // region --static method

    public String checkValidUuid(String id) {
        if (StringUtil.isNullOrEmpty(id)) {
            return "id无效(1)";
        }

        if (id.length() != 32 && id.length() != 36) {
            // 长度不对
            return "id无效(2)";
        }

        return null;
    }

    public boolean isValidUuid(String id) {
        String err = checkValidUuid(id);

        return err == null;
    }

    // endregion

    // region --Getter and Setter

    /**
     * Gets entity name.
     * @return the entity name
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * Sets entity name.
     * @param entityName the entity name
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    // endregion

    // region --Public method

    /**
     * Find by id base rst bean.
     * @param jpa the jpa
     * @param id  the id
     * @return the base rst bean
     */
    public BaseRstBean findById(BaseJpaRepositoryByUuid<T> jpa, String id) {
        if (jpa == null) {
            return rstBeanHelper.ComErrBean("无法获取Rp对象");
        }

        String err = checkValidUuid(id);
        if (err != null) {
            return rstBeanHelper.ComErrBean(err);
        }

        Optional<T> item = jpa.findById(id);
        if (item.isPresent()) {
            return rstBeanHelper.SurBean(item.get());
        } else {
            return rstBeanHelper.ComErrBean(String.format("未找到%s", entityName));
        }
    }

    public T findByGlId(BaseJpaRepositoryByAutoId<T> jpa, Long id) {
        if (jpa == null) {
            throw RstBeanException.RstComErrBean("无法获取Rp对象");
        }

        if (id == null) {
            throw RstBeanException.RstComErrBean("id无效");
        }

        Optional<T> item = jpa.findById(id);
        if (item.isPresent()) {
            return item.get();
        } else {
            throw RstBeanException.RstComErrBean(String.format("未找到%s", entityName));
        }
    }

    // endregion

    // region --private method

    // endregion

    // region --Other

    // endregion
}
