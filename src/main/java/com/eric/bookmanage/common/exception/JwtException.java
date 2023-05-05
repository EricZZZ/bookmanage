package com.eric.bookmanage.common.exception;

/**
 * jwt异常
 */
public class JwtException extends BaseException {

    public JwtException(SystemErrorType errorType) {
        super(errorType);
    }

}
