package com.citic.payment.util;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

public class HashUtils {
    //Gava加密
    private static final HashFunction FUNCTION=Hashing.md5();
    //定义一个盐
    private static String SALT="citic";

    public static String encryPassword(String password){
        HashCode hashCode = FUNCTION.hashString(password + SALT, Charset.forName("UTF-8"));
        return hashCode.toString();
    }
}
