package com.wz.controller.front;


import com.wz.common.ResponseCode;
import com.wz.common.ServerResponse;
import com.wz.pojo.User;
import com.wz.service.ICartService;
import com.wz.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    ICartService cartService;
    /**
     * 添加商品到购物车
     * */

    @RequestMapping("add/{productId}/{count}")
    public ServerResponse addCart(@PathVariable("productId") Integer productId,
                                  @PathVariable("count") Integer count,
                                  HttpSession session){

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.serverResponseByError(ResponseCode.NOT_LOGIN, "未登录");
        }

        return cartService.addProductToCart(user.getId(),productId,count);
    }

}
