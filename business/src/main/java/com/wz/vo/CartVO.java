package com.wz.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CartVO implements Serializable{

    private List<CartProductVO> cartProductVOList;//购物信息集合
    private BigDecimal cartTotalPrice; //购物车中商品总价格
    private boolean allChecked;//是否全选

    public List<CartProductVO> getCartProductVOList() {
        return cartProductVOList;
    }

    public void setCartProductVOList(List<CartProductVO> cartProductVOList) {
        this.cartProductVOList = cartProductVOList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public boolean isAllChecked() {
        return allChecked;
    }

    public void setAllChecked(boolean allChecked) {
        this.allChecked = allChecked;
    }
}
