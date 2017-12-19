package com.imooc.security.core.validate.code;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shudp
 * @create 2017/12/18.
 */
public interface ValidateCodeGenerator {

    ImageCode generate(HttpServletRequest request);

}
