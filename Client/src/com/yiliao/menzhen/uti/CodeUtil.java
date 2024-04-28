package com.yiliao.menzhen.uti;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    //获得一个五位随机验证码
    public static String getCode() {
        String resuult = "";

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
            list.add((char) ('A' + i));
        }

        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex = r.nextInt(list.size());
            char c = list.get(randomIndex);
            resuult = resuult + c;
        }
        int number = r.nextInt(10);
        resuult = resuult + number;
        char[] charArray = resuult.toCharArray();
        int index = r.nextInt(charArray.length);
        char temp = charArray[4];
        charArray[4] = charArray[index];
        charArray[index] = temp;
        String code = new String(charArray);
        return code;
    }
}
