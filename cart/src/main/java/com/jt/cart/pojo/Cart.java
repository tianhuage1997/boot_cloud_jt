package com.jt.cart.pojo;

import com.jt.common.po.BasePojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_cart")
public class Cart  extends BasePojo {
    /*
      id                   bigint(20) not null auto_increment,
   user_id              bigint(20),
   item_id              bigint(20),
   item_title           varchar(100),
   item_image           varchar(200),
   item_price           bigint(20) comment '单位：分',
   num                  int(10),
   created              datetime,
   updated              datetime,
   primary key (id),
   key AK_user_itemId (user_id, item_id)
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long itemId;
    private String itemTitle;
    private String itemImage;
    private String itemPrice;
    private Integer num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", itemTitle='" + itemTitle + '\'' +
                ", itemImage='" + itemImage + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                ", num=" + num +
                '}';
    }

}
