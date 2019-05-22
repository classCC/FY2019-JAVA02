package com.wz.controller.front;

import com.wz.common.ResponseCode;
import com.wz.common.ServerResponse;
import com.wz.pojo.Shipping;
import com.wz.pojo.User;
import com.wz.service.IShippingService;
import com.wz.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/shipping/")
public class ShippingController {

    @Autowired
    IShippingService shippingService;

    @RequestMapping(value = "add")
    public ServerResponse add(Shipping shipping, HttpSession session){

        User user=(User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.serverResponseByError(ResponseCode.NOT_LOGIN,"未登录");
        }

        shipping.setUserId(user.getId());

        return shippingService.add(shipping);
    }

}
