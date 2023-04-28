package com.eric.bookmanage.common.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.eric.bookmanage.common.Response;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler(value = {
            HttpMediaTypeNotAcceptableException.class,
            HttpMediaTypeNotSupportedException.class,
            HttpRequestMethodNotSupportedException.class,
            MissingServletRequestParameterException.class,
            NoHandlerFoundException.class,
            MissingPathVariableException.class,
            HttpMessageNotReadableException.class
    })
    @ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
    public Response handleIllegalException(Exception e) {
        log.error("{}", e.getMessage(), e);
        return Response.fail(SystemErrorType.ILLEGA_REQUEST, e.getMessage());
    }

    /**
     * 处理 参数类型不匹配 异常
     * 
     * @author EricZhao
     * @date 2022/4/27
     * @since 1.0
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
    public Response handleMethodArgumentNotValidException(MethodArgumentTypeMismatchException e) {
        log.error("{}", e.getMessage(), e);
        return Response.fail(SystemErrorType.PARAM_TYPE_ERROR, e.getMessage());
    }

    /**
     * 参数校验异常
     * 
     * @author EricZhao
     * @date 2022/4/28
     * @since 1.0
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("{}", e.getMessage(), e);
        List<String> list = e.getBindingResult().getFieldErrors().stream()
                .map(t -> "【" + t.getField() + "】" + t.getDefaultMessage()).collect(Collectors.toList());
        return Response.fail(SystemErrorType.PARAM_VALID_ERROR, list.get(0));
    }

    /**
     * 处理 参数校验不通过 异常
     * 
     * @author EricZhao
     * @date 2022/4/28
     * @since 1.0
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.BAD_REQUEST)
    public Response handleConstraintViolationException(ConstraintViolationException e) {
        log.error("{}", e.getMessage(), e);
        return Response.fail(SystemErrorType.PARAM_VALID_ERROR, e.getMessage());
    }

    /**
     * 通用业务 处理异常
     * 
     * @author EricZhao
     * @date 2022/4/27
     * @since 1.0
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleBaseException(BaseException e) {
        log.error("{},{}", e.getMessage(), e);
        return Response.fail(e.getErrorType());
    }

    /**
     * 其他异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleRunTimeException(Exception e) {
        log.error("{},{}", e.getMessage(), e);
        return Response.fail(SystemErrorType.SYSTEM_ERROR);
    }

}