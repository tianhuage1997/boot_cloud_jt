package com.jt.cart.service.impl;

import com.jt.cart.mapper.CartMapper;
import com.jt.cart.pojo.Cart;
import com.jt.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl  implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> queryCartList(Long userId) {
        Cart cart=new Cart();
        cart.setUserId(userId);
        List<Cart> cartList = cartMapper.select(cart);
        return cartList;
    }

    @Override
    public void saveCart(Cart cart) {
        //传递过来的值,没有id
        //判断档期啊购物车表格是否存在相同的记录;
        //1 判断购物车商品是否存在需要用到userId,cartId
        //2 如果存在,将num添加后更新
        //3 不存在,直接insert
        Cart _cart=new Cart();
        _cart.setUserId(cart.getUserId());
        _cart.setItemId(cart.getItemId());
        Cart exists = cartMapper.selectOne(_cart);
        if(null!=exists) {//说明已经存在
            exists.setUpdated(new Date());
            exists.setNum(cart.getNum()+exists.getNum());
            cartMapper.updateByPrimaryKey(exists);
        }else{
            cart.setCreated(new Date());
            cart.setUpdated(cart.getCreated());
            cartMapper.insert(cart);
        }
    }

    @Override
    public void updateCartNum(Long userId, Long itemId, Integer num) {

    }
}
