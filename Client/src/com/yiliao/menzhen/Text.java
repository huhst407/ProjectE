package com.yiliao.menzhen;

import java.util.Optional;

public class Text {
    public static void main(String[] args) {
        String str=CheckCodeUtil.generateVerifyCode(5);
        System.out.println(str);
    }
}
