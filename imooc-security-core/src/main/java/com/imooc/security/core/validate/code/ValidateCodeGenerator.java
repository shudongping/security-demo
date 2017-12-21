package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shudp
 * @create 2017/12/18.
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);

}
