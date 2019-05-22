package com.wz.controller.backend;

import com.wz.common.ResponseCode;
import com.wz.common.RoleEnum;
import com.wz.common.ServerResponse;
import com.wz.pojo.Product;
import com.wz.pojo.User;
import com.wz.service.IProductService;
import com.wz.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/manage/product/")
public class ProductController {

    @Autowired
    IProductService ProductService;

    /**
     * 商品添加&更新
     */
    @RequestMapping(value = "save")
    public ServerResponse addOrUpdate(Product product, HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "未登录");
        }
        int role = user.getRole();
        if (role == RoleEnum.ROLE_USER.getRole()) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "权限不足");
        }
        return ProductService.addOrUpdate(product);
    }

    /**
     * s搜索商品
     * productName
     * productId
     * pageNum(default=1)
     * pageSize(default=10)
     * */
    @RequestMapping(value = "search")
    public ServerResponse search(@RequestParam(name="productName",required = false) String productName,
                                 @RequestParam(name="productId",required = false) Integer productId,
                                 @RequestParam(name="pageNum",required = false , defaultValue = "1") Integer pageNum,
                                 @RequestParam(name="pageSize",required = false , defaultValue = "1") Integer pageSize,
                                 HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "未登录");
        }
        int role = user.getRole();
        if (role == RoleEnum.ROLE_USER.getRole()) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "权限不足");
        }

        return ProductService.search(productName,productId,pageNum,pageSize);
    }

    @RequestMapping(value = "/{productId}")
    public ServerResponse detail(@RequestParam("productId") Integer productId,HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "未登录");
        }
        int role = user.getRole();
        if (role == RoleEnum.ROLE_USER.getRole()) {
            return ServerResponse.serverResponseByError(ResponseCode.ERROR, "权限不足");
        }

        return ProductService.detail(productId);
    }

}




