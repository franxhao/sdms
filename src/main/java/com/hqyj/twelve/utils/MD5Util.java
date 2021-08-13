package com.hqyj.twelve.utils;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @description:使用shiro提供的加密相关的工具类做个加密， 明文->暗文
 * @author: GP
 * @date: 2021/8/10-15:46
 */
public class MD5Util {
    /**
     *
     * @param password 原文字符串
     * @param salt    盐，
     * 多次使用散列进行加密，增加破解难度，增加密码强度
     * 加盐    增加破解难度，增加密码强度
     * @return
     */
    public static String Md5Hash(String password, String salt){
        ByteSource slatBytes = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash("MD5", password, slatBytes, 1024);
        //返回加密结果
        return simpleHash.toString();
    }
}
