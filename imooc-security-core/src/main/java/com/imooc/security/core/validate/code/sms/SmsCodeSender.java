package com.imooc.security.core.validate.code.sms;

/**
 * @author shudp
 * @create 2017/12/20.
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
