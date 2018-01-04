package com.imooc.security.core.validate.code;

import com.imooc.security.core.properties.SecurityConstants;

/**
 * @author shudp
 * @create 2017/12/27.
 */
public enum ValidateCodeType {

    SMS{
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },

    IMAGE{
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    public abstract String getParamNameOnValidate();



}
