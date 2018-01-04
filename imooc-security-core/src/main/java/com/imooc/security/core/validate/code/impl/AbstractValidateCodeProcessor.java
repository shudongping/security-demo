package com.imooc.security.core.validate.code.impl;

import com.imooc.security.core.validate.code.*;
import com.imooc.security.core.validate.code.image.ImageCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @author shudp
 * @create 2017/12/20.
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;


    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }


    private C generate(ServletWebRequest request) {

        String type = getValidateCodeType(request).toString().toLowerCase();

        String name = type + ValidateCodeGenerator.class.getSimpleName();

        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(name);

        if(validateCodeGenerator == null){
            throw new ValidateCodeException("验证码生成器"+name+"不存在");
        }

        return (C) validateCodeGenerator.generate(request);
    }

    protected abstract void send(ServletWebRequest request, C validate) throws Exception;


    protected void save(ServletWebRequest request, C validate) throws Exception {
        String key = getSessionKey(request);
        sessionStrategy.setAttribute(request, key, validate);
    }

    private ValidateCodeType getValidateCodeType(ServletWebRequest request){
        String type = StringUtils.substringBefore(getClass().getSimpleName(),"CodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }

    private String getSessionKey(ServletWebRequest request) {
        return SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
    }

    @Override
    public void validate(ServletWebRequest servletWebRequest){

        ValidateCodeType validateCodeType = getValidateCodeType(servletWebRequest);

        String sessionKey = getSessionKey(servletWebRequest);

        C validateCode = (C) sessionStrategy.getAttribute(servletWebRequest, sessionKey);

        String codeInRequest = null;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), validateCodeType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码值失败");
        }

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码不能为空");
        }

        if (validateCode == null) {
            throw new ValidateCodeException("验证码不存在");
        }
        if (validateCode.isExpired()) {
            sessionStrategy.removeAttribute(servletWebRequest, sessionKey);
            throw new ValidateCodeException("验证码已过期");
        }
        if (!StringUtils.equals(validateCode.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配");
        }
        sessionStrategy.removeAttribute(servletWebRequest, sessionKey);
    }

}
