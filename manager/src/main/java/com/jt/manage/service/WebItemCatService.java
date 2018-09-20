package com.jt.manage.service;

import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;
import com.jt.manage.pojo.ItemCatData;
import com.jt.manage.pojo.ItemCatResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WebItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    public ItemCatResult queryItemCatAll() {

        //获取数据
        List<ItemCat> itemCatList=itemCatMapper.selectAll();
        //利用map做三层封装
        Map<Long,List<ItemCat>> mapList=new HashMap<Long,List<ItemCat>>();
        for (ItemCat itemCat:itemCatList){
            //从当前itemcat对象中获取parentId
            Long parentId=itemCat.getParentId();
            //如果map的key不存在这个parentId，那么就直接存入map
            if(!mapList.containsKey(parentId)){
                    //不存在key值
                    mapList.put(parentId,new ArrayList<ItemCat>());

            }
            //把对应的对象存储到maplist里面
            mapList.get(parentId).add(itemCat);
        }

        //定义一级菜单list集合
        List<ItemCatData>  itemCatDataList1=new ArrayList<ItemCatData>();

        //循环遍历一级菜单
        for(ItemCat itemCat:mapList.get(0L)){
            ItemCatData itemCatData1 = new ItemCatData();
            itemCatData1.setUrl("/products/"+itemCat.getId()+".html");
            itemCatData1.setName("<a href='"+itemCatData1.getUrl()+"'>"+itemCat.getName()+"</a>");
            //准备当前菜单下的二级菜单,定义二级菜单list集合
            List<ItemCatData>  itemCatDataList2 =new ArrayList<ItemCatData>();
            //获取二级菜单的list并执行遍历
            for (ItemCat  itemCat2:mapList.get(itemCat.getId())){
                    ItemCatData itemCatData2 =new ItemCatData();
                    itemCatData2.setUrl("/products/"+itemCat2.getId()+".html");
                    itemCatData2.setName("<a href='"+itemCatData2.getUrl()+"'>"+itemCat2.getName()+"</a>");
                 //定义三级菜单list集合
                List<String>  itemCatDataList3 =new ArrayList<String>();
                //准备三级菜单
                    for (ItemCat itemCat3:mapList.get(itemCat2.getId())){
                            itemCatDataList3.add("/products/"+itemCat3.getId()+"|"+itemCat3.getName());
                    }
                    //把数据准备完毕，准备封装二级菜单
                itemCatData2.setItems(itemCatDataList3);
//                    if(itemCatDataList2.size()>7){
//                        break;
//                    }
                itemCatDataList2.add(itemCatData2);
            }
            //把数据准备完毕，准备封装一级菜单
            itemCatData1.setItems(itemCatDataList2);
//            if(itemCatDataList1.size()>7){
//                break;
//            }
            itemCatDataList1.add(itemCatData1);
        }
        //封装完毕，直接放到ItemCatResult中
        ItemCatResult itemCatResult =new ItemCatResult();
        itemCatResult.setItemCats(itemCatDataList1);
        return itemCatResult;



    }
}
