package com.eric.bookmanage.common.exception;

public class BaseException extends RuntimeException{

     /**
     * 异常对应的错误类型
     */
    private final ErrorType errorType;

    public ErrorType getErrorType() {
        return errorType;
    }

    /**
     * 默认是系统异常
     */
    public BaseException() {
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }
    
}
