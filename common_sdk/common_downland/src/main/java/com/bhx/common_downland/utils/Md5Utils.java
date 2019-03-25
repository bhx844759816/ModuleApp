package com.bhx.common_downland.utils;

import android.text.TextUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 将字符串MD5编解码
 */
public class Md5Utils {

    /**
     * 将字符串转成MD5
     *
     * @param content
     * @return
     */
    public static String md5(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }
        try {
            byte[] secretBytes = MessageDigest.getInstance("md5").digest(
                    content.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : secretBytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    builder.append("0").append(temp);
                }
                builder.append(temp);
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
