package com.jt.manage.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.manage.pojo.ItemCat;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 庄致科小菜：调试redis的demo
 */
public class zzk {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
      String nodes ="192.168.227.200:6379";
      Integer maxIdle=8;
      Integer minIdle=0;
      Integer maxTotal=8;//对应配置文件时max-active
        Integer maxWait=5000;
        Integer timeout=1000000;
        JedisPoolConfig config=new JedisPoolConfig();
        //设定参数
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setMaxTotal(maxTotal);
        config.setMaxWaitMillis(maxWait);

        //获取infoList
        List<JedisShardInfo> infoList=
                new ArrayList<>();
        //处理字符串nodes
        if(!("null".equals(nodes))) {
            String[] hostAndPorts = nodes.split(",");
            for (String node : hostAndPorts) {
                //每个node格式192.168.198.40:6379
                String[] hostAndPort = node.split(":");
                //生成一个info对象,添加到list中
                JedisShardInfo info =
                        new JedisShardInfo(hostAndPort[0],
                                Integer.parseInt(hostAndPort[1]), timeout);
                infoList.add(info);
            }
            //用config对象和list对象生产jedis分片连接池
            ShardedJedisPool pool = new ShardedJedisPool(config, infoList);

            ShardedJedis jedis = pool.getResource();
            System.out.println(jedis);
            String json = jedis.get("ITEM_CAT_LIST_0");
            System.out.println(json );
            List<ItemCat> itemCatList = new ArrayList<>();
            ItemCat[] itemCats =objectMapper.readValue(json,ItemCat[].class);
            for(ItemCat itemCat:itemCats){
                itemCatList.add(itemCat);
            }

            System.out.println(itemCatList.toArray());

        }
    }
}
