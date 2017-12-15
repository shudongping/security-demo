package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shudp
 * @create 2017/12/14.
 */
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
