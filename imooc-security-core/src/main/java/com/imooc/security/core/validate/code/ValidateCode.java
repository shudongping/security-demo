package com.imooc.security.core.validate.code;

import java.time.LocalDateTime;

/**
 * @author shudp
 * @create 2017/12/20.
 */
public class ValidateCode {

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }


    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(this.expireTime)) {
            return true;
        } else {
            return false;
        }

    }

}
