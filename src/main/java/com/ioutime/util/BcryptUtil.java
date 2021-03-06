package com.ioutime.util;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Random;

/**
 * @author ioutime
 * @version 1.0
 * @date 2021/8/16 15:42
 */

public class BcryptUtil {
    /**
     * bcrypt加密明文
     */
    public static String ciphertext(String password){
        //生成随机盐
        String gensalt = BCrypt.gensalt();
        //加密
        return BCrypt.hashpw(password, gensalt);
    }

    /**
     * 验证密码
     */
    public static boolean verify(String plaintext,String ciphertext){
        return BCrypt.checkpw(plaintext, ciphertext);
    }

    /**
     * 生成8位随机密码
     */
    public static String charArray(){
        int i = 1234567890;
        String s ="qwertyuiopasdfghjklzxcvbnm";
        String S=s.toUpperCase();
        String word=s+S+i;
        char[] c=word.toCharArray();
        Random rd = new Random();
        StringBuilder plaintext = new StringBuilder();
        for (int k = 0; k <= 7; k++) {
            int index = rd.nextInt(c.length);//随机获取数组长度作为索引
            plaintext.append(c[index]);//循环添加到字符串后面
        }
        return plaintext.toString();
    }

}
