package com.jt.manage.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 将三级菜单分为
 * 封装数据的pojo：类型1
 *
 * 类型2
 * private String u
 * private String n
 * private List<类型3> i
 *
 *类型3
 * private String u
 * private String n
 * private List<String> i
 *
 * 类型2和类型3-->类型4
 *
 * 三级菜单的类型4（类型2和类型3）
 */
public class ItemCatData   implements Serializable {
     @JsonProperty("u")
     private  String url;
     @JsonProperty("n")
     private  String  name;
     @JsonProperty("i")
     private List<?> items;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getItems() {
        return items;
    }

    public void setItems(List<?> items) {
        this.items = items;
    }


}
