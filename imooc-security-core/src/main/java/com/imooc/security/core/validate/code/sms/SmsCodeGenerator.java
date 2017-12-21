package com.imooc.security.core.validate.code.sms;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validate.code.ValidateCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author shudp
 * @create 2017/12/20.
 */
@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    @Override
    public ValidateCode generate(ServletWebRequest request) {


        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());

        ValidateCode validateCode = new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());

        return validateCode;


    }
}
