package com.yiliao.menzhen.domain;

public class User {
    //表示每个用户存储的登录信息
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String toString() {
        return "username=" + username + "&password=" + password;
    }
}
