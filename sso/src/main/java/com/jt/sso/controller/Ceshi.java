package com.jt.sso.controller;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 测试加密。使用shiro源码的工具类
 */
public class Ceshi {
    public static void main(String[] args) {
          String hashAlgorithmName = "MD5";
          String name ="123456";
          String password = "password";
          String salt = password;
          int i = 1024;
          Object obj = new SimpleHash(hashAlgorithmName, name, salt, i);
        System.out.println(obj);
        System.out.println(obj.toString());

    }
}
