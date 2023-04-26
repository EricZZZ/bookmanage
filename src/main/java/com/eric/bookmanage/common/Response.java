package com.eric.bookmanage.common;

import java.time.Instant;
import java.time.ZonedDateTime;

import com.eric.bookmanage.common.exception.BaseException;
import com.eric.bookmanage.common.exception.ErrorType;
import com.eric.bookmanage.common.exception.SystemErrorType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;

public class Response<T> {
    public static final String SUCCESSFUL_CODE = "000000";
    public static final String SUCCESSFUL_MESG = "处理成功";

    @Schema(title = "处理结果code", required = true)
    private String code;
    @Schema(title = "处理结果描述信息")
    private String mesg;
    @Schema(title = "请求结果生成时间戳")
    private Instant time;
    @Schema(title = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public Response() {
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @param errorType
     */
    public Response(ErrorType errorType) {
        this.code = errorType.getCode();
        this.mesg = errorType.getMesg();
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @param errorType
     * @param data
     */
    public Response(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }

    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param mesg
     * @param data
     */
    private Response(String code, String mesg, T data) {
        this.code = code;
        this.mesg = mesg;
        this.data = data;
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * 快速创建成功结果并返回结果数据
     *
     * @param data
     * @return Response
     */
    public static Response success(Object data) {
        return new Response<>(SUCCESSFUL_CODE, SUCCESSFUL_MESG, data);
    }

    /**
     * 快速创建成功结果
     *
     * @return Response
     */
    public static Response success() {
        return success(null);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @return Response
     */
    public static Response fail() {
        return new Response(SystemErrorType.SYSTEM_ERROR);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @param baseException
     * @return Response
     */
    public static Response fail(BaseException baseException) {
        return fail(baseException, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return Response
     */
    public static Response fail(BaseException baseException, Object data) {
        return new Response<>(baseException.getErrorType(), data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param errorType
     * @param data
     * @return Response
     */
    public static Response fail(ErrorType errorType, Object data) {
        return new Response<>(errorType, data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param errorType
     * @return Response
     */
    public static Response fail(ErrorType errorType) {
        return Response.fail(errorType, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return Response
     */
    public static Response fail(Object data) {
        return new Response<>(SystemErrorType.SYSTEM_ERROR, data);
    }

    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SUCCESSFUL_CODE.equals(this.code);
    }

    /**
     * 失败
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }

    public static String getSuccessfulCode() {
        return SUCCESSFUL_CODE;
    }

    public static String getSuccessfulMesg() {
        return SUCCESSFUL_MESG;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
