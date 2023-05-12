package com.eric.bookmanage.common.exception;

public enum SystemErrorType implements ErrorType {

    SYSTEM_ERROR("-1", "系统异常"),
    SYSTEM_BUSY("000001", "系统繁忙,请稍候再试"),

    GATEWAY_NOT_FOUND_SERVICE("010404", "服务未找到"),
    GATEWAY_ERROR("010500", "网关异常"),
    GATEWAY_CONNECT_TIME_OUT("010002", "网关超时"),

    PARAM_VALID_ERROR("020000", "参数校验失败"),
    PARAM_TYPE_ERROR("020001", "请求参数类型错误"),
    PARAM_BIND_ERROR("020002", "请求参数绑定错误"),

    ILLEGA_REQUEST("999999", "非法请求"),

    INVALID_TOKEN("600000", "无效token"),
    UPLOAD_FILE_SIZE_LIMIT("020010", "上传文件大小超过限制"),

    DUPLICATE_PRIMARY_KEY("030000", "唯一键冲突"),

    LOGGIN_NAME_OR_PASSWORD_FAILURE("040000", "用户名或密码错误"),
    TOKEN_EXPIRED("600001", "token过期"),
    TOKEN_VERIFY_FAILURE("600002", "token 验证失败"),
    ;

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String mesg;

    SystemErrorType(String code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMesg() {
        return this.mesg;
    }
}
