package com.imooc.security.core.validate.code.sms;

/**
 * @author shudp
 * @create 2017/12/20.
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.printf("向手机 "+mobile+"发送短信验证码: "+code);
    }
}
