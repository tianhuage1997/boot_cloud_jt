package com.jt.sso.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.vo.SysResult;
import com.jt.sso.pojo.User;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试加密。使用shiro源码的工具类
 */
public class Ceshi {
    public static void main(String[] args) throws Exception {
          String hashAlgorithmName = "MD5";
          String name ="tianhuage1";
          String password = "zzk521314";
          String salt = password;
          int i = 1024;
          Object obj = new SimpleHash(hashAlgorithmName, name, salt,i);
        System.out.println(obj);
        System.out.println(obj.toString());
        String ticket ="{\"751be3928963bda0102a2e0845398263\":{\"status\":200,\"msg\":\"OK\",\"data\":null,\"ok\":true}}";
        HashMap<String,SysResult> map=new HashMap<String,SysResult>();
        ObjectMapper objectMapper=new ObjectMapper();
        HashMap<String,SysResult> map2=objectMapper.readValue(ticket,HashMap.class);
        System.out.println(map2.toString());
        System.out.println(1);

        String zzk="{\n" +
                "\t\"81b6a5fc173756f8d926aad6dd5e5a83\":{\n" +
                "\t\t\"msg\":\"OK\",\n" +
                "\t\t\"ok\":true,\n" +
                "\t\t\"status\":200\n" +
                "\t}\n" +
                "}";
        Map<String,SysResult> resultMap = (Map<String,SysResult>)JSON.parse(ticket);
        System.out.println("resultMap:"+resultMap);
    }
}
