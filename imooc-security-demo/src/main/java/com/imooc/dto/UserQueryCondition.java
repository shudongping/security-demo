package com.imooc.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author shudp
 * @create 2017/12/6.
 */
public class UserQueryCondition {
    private String username;
    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "年龄结束")
    private int ageTo;

    private String xx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }
}
