package com.jt.web.pojo;

import com.jt.common.po.BasePojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_user")
public class User extends BasePojo {
    /*
     id                   bigint not null auto_increment,
   username             varchar(50),
   password             varchar(32) comment 'MD5加密',
   phone                varchar(20),
   email                varchar(50),
   created              datetime,
   updated              datetime,
   primary key (id)
     */
    /* 用户ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    /* 用户名 */
    private  String username;
    /* 密码 */
    private  String password;
    /* 电话 */
    private  String phone;
    /* 邮件 */
    private  String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
