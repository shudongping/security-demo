package com.imooc.security.core.validate.code.sms;

import com.imooc.security.core.validate.code.ValidateCode;
import com.imooc.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author shudp
 * @create 2017/12/20.
 */
@Component("smsCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode>{

    @Autowired
    private SmsCodeSender smsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validate) throws Exception {
        smsCodeSender.send(ServletRequestUtils.getRequiredStringParameter(request.getRequest(),"mobile"),validate.getCode());
    }
}
