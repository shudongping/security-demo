package com.imooc.security.core.properties;

/**
 * @author shudp
 * @create 2017/12/14.
 */
public class BrowserProperties {

    private String loginPage = "/imooc-signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
