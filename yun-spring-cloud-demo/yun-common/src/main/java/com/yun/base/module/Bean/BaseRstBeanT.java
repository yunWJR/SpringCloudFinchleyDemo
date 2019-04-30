package com.yun.base.module.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author: yun
 * @createdOn: 2018/8/7 10:13.
 */

public class BaseRstBeanT<T> {

    // region --Field

    // 默认内容
    // 1.状态码
    private int code = BaseRstCodeType.None.getCode();

    // 2.错误信息
    private String errorMsg = "";

    // 3.结果数据
    private T data;

    // 模块内容
    // 1.模块标示
    @JsonIgnore // 不格式化
    private int module = BaseRstModuleType.Unknown.getModule();

    // 2.模块数据
    @JsonIgnore() // 不格式化
    private String moduleName;

    // 3.模块数据
    @JsonIgnore // 不格式化
    private Object moduleData;

    // endregion

    /**
     * Instantiates a new Base rst bean.
     */
    // region --Constructor
    public BaseRstBeanT() {
    }

    /**
     * Instantiates a new Base rst bean.
     * @param data the data
     */
    public BaseRstBeanT(T data) {
        this.initForSuc();

        this.data = data;
    }

    /**
     * Instantiates a new Base rst bean.
     * @param type the itemType
     */
    public BaseRstBeanT(BaseRstCodeType type) {
        this.code = type.getCode();
        this.errorMsg = type.getMsg();
    }

    /**
     * Instantiates a new Base rst bean.
     * @param type     the itemType
     * @param errorMsg the error msg
     */
    public BaseRstBeanT(BaseRstCodeType type, String errorMsg) {
        this.code = type.getCode();

        if (errorMsg.length() > 0) {
            this.errorMsg = errorMsg;
        } else {
            this.errorMsg = type.getMsg();
        }
    }

    /**
     * Instantiates a new Base rst bean.
     * @param code     the code
     * @param errorMsg the error msg
     */
    public BaseRstBeanT(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    // endregion

    // region --static method

    /**
     * Sur bean in controller base rst bean.
     * @param data the data
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> SurBeanInController(T data) {
        return SurBeanByModule(data, BaseRstModuleType.Controller);
    }

    /**
     * Com err bean in controller base rst bean.
     * @param errorMsg the error msg
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> ComErrBeanInController(String errorMsg) {
        return ComErrBeanByModule(errorMsg, BaseRstModuleType.Controller);
    }

    /**
     * Sur bean in service base rst bean.
     * @param data the data
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> SurBeanInService(T data) {
        return SurBeanByModule(data, BaseRstModuleType.Service);
    }

    /**
     * Com err bean in service base rst bean.
     * @param errorMsg the error msg
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> ComErrBeanInService(String errorMsg) {
        return ComErrBeanByModule(errorMsg, BaseRstModuleType.Service);
    }

    /**
     * Sur bean in dao base rst bean.
     * @param data the data
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> SurBeanInDao(T data) {
        return SurBeanByModule(data, BaseRstModuleType.Dao);
    }

    /**
     * Com err bean in dao base rst bean.
     * @param errorMsg the error msg
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> ComErrBeanInDao(String errorMsg) {
        return ComErrBeanByModule(errorMsg, BaseRstModuleType.Dao);
    }

    /**
     * Sur bean by module base rst bean.
     * @param data       the data
     * @param moduleType the module itemType
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> SurBeanByModule(T data, BaseRstModuleType moduleType) {
        BaseRstBeanT rst = SurBean(data);
        rst.updateByModuleType(moduleType);

        return rst;
    }

    /**
     * Com err bean by module base rst bean.
     * @param errorMsg   the error msg
     * @param moduleType the module itemType
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> ComErrBeanByModule(String errorMsg, BaseRstModuleType moduleType) {
        BaseRstBeanT rst = ComErrBean(errorMsg);
        rst.updateByModuleType(moduleType);

        return rst;
    }

    /**
     * Sur bean base rst bean.
     * @param data the data
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> SurBean(T data) {
        BaseRstBeanT<T> rst = new BaseRstBeanT<T>(data);

        return rst;
    }

    /**
     * Com err bean base rst bean.
     * @param errorMsg the error msg
     * @return the base rst bean
     */
    public static <T> BaseRstBeanT<T> ComErrBean(String errorMsg) {
        BaseRstBeanT rst = new BaseRstBeanT(BaseRstCodeType.ComErr.getCode(), errorMsg);

        return rst;
    }

    public static <T> BaseRstBeanT<T> ErrBeanByCode(int code) {
        BaseRstBeanT rst = new BaseRstBeanT(code, "");

        return rst;
    }

    // endregion

    // region --Getter and Setter

    /**
     * Gets code.
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Sets code.
     * @param code the code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Gets error msg.
     * @return the error msg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Sets error msg.
     * @param errorMsg the error msg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * Gets data.
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets data.
     * @param data the data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Gets module.
     * @return the module
     */
    public int getModule() {
        return module;
    }

    /**
     * Sets module.
     * @param module the module
     */
    public void setModule(int module) {
        this.module = module;
    }

    /**
     * Gets module data.
     * @return the module data
     */
    public Object getModuleData() {
        return moduleData;
    }

    /**
     * Sets module data.
     * @param moduleData the module data
     */
    public void setModuleData(Object moduleData) {
        this.moduleData = moduleData;
    }

    /**
     * Gets module name.
     * @return the module name
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Sets module name.
     * @param moduleName the module name
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    // endregion

    // region --Public method

    /**
     * Is suc boolean.
     * @return the boolean
     */
    @JsonIgnore // isSuc 会默认为 get 方法，忽略该字段
    public boolean isSuc() {
        if (code == BaseRstCodeType.Suc.getCode() || code == BaseRstCodeType.None.getCode()) {
            return true;
        }

        return false;
    }

    /**
     * Is error boolean.
     * @return the boolean
     */
    @JsonIgnore // isError 会默认为 get 方法，忽略该字段
    public boolean isError() {
        return !this.isSuc();
    }

    /**
     * Sets by code itemType.
     * @param type the itemType
     */
    public void updateByCodeType(BaseRstCodeType type) {
        this.code = type.getCode();
        this.errorMsg = type.getMsg();
    }

    /**
     * Sets by module itemType.
     * @param type the itemType
     */
    public void updateByModuleType(BaseRstModuleType type) {
        this.module = type.getModule();
        this.moduleName = type.getRemark();
    }

    /**
     * Init for suc.
     */
    public void initForSuc() {
        this.updateByCodeType(BaseRstCodeType.Suc);
    }

    /**
     * Init for com err.
     */
    public void initForComErr() {
        this.updateByCodeType(BaseRstCodeType.ComErr);

        this.setData(null);
    }

    public <E> BaseRstBeanT<E> errRst() {
        BaseRstBeanT<E> err = new BaseRstBeanT<E>();
        err.setCode(this.code);
        err.setErrorMsg(this.errorMsg);

        return err;
    }

    // endregion

    // region --private method

    // endregion

    // region --Other

    // endregion
}
