package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author shudp
 * @create 2017/12/17.
 */
public class ValidateCodeException extends AuthenticationException{

    public  static final long serialVersionUID = 8848687408293611636L;

    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
