package com.cloud.murphy.util;

import java.util.Random;

public class TokenUtil {
    public static String makeToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        return MD5Util.md5(token);
    }

    public static void main(String[] args) {
        System.out.println(makeToken());
    }
}
