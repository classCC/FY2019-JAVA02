package com.wz.service;

import com.wz.common.ServerResponse;
import com.wz.pojo.Cart;

import java.util.List;

public interface ICartService {

    /**
     * 添加商品到购物车
     * */
    public ServerResponse addProductToCart(Integer userId,Integer productId,Integer count);

    /**
     * 根据用户id查看用户已选的商品
     * */
    public ServerResponse findCartsByUseridAndChecked(Integer userId);

    /**
     * 批量删除购物车商品
     * */
    public ServerResponse deleteBatch(List<Cart> cartList);
}
