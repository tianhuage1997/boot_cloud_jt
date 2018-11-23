package com.jt.cart.controller;


import com.jt.cart.pojo.Cart;
import com.jt.cart.service.CartService;
import com.jt.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("query/{userId}")
    @ResponseBody
    public SysResult queryCartList(@PathVariable Long userId){
        List<Cart> cartList=cartService.queryCartList(userId);
        return  SysResult.oK(cartList);
    }


    //保存购物车数据,保存一条购物车表格记录
    //http://cart.jt.com/cart/save
    @RequestMapping("save")
    @ResponseBody
    public SysResult saveCart(Cart cart) {
        cartService.saveCart(cart);
        return SysResult.oK();
    }

    //更新商品数量
    ///cart/update/num/{userId}/{itemId}/{num}
    @RequestMapping("update/num/{userId}/{itemId}/{num}")
    @ResponseBody
    public SysResult updateCartNum(@PathVariable Long userId,
                                   @PathVariable Long itemId,@PathVariable Integer num) {
        cartService.updateCartNum(userId,itemId,num);
        return SysResult.oK();
    }


}
