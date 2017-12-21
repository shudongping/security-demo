package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author shudp
 * @create 2017/12/20.
 */
public interface ValidateCodeProcessor {

    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    void create(ServletWebRequest request) throws Exception;

}
