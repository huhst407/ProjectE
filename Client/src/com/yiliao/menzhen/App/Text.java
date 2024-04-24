package com.yiliao.menzhen.App;

import com.yiliao.menzhen.uti.CheckCodeUtil;

public class Text {
    public static void main(String[] args) {
        String str= CheckCodeUtil.generateVerifyCode(5);
        System.out.println(str);
    }
}
