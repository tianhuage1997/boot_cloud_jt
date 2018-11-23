package com.jt.cart.service;

import com.jt.cart.pojo.Cart;

import java.util.List;

public interface CartService {

    public List<Cart>  queryCartList(Long userId);

    public void saveCart(Cart cart);

    public void updateCartNum(Long userId, Long itemId, Integer num);
}
