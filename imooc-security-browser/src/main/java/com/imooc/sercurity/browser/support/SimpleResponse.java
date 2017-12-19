package com.imooc.sercurity.browser.support;

/**
 * @author shudp
 * @create 2017/12/14.
 */
public class SimpleResponse {



    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
