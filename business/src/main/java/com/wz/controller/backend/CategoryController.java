package com.wz.controller.backend;

import com.wz.common.ResponseCode;
import com.wz.common.RoleEnum;
import com.wz.common.ServerResponse;
import com.wz.pojo.Category;
import com.wz.pojo.User;
import com.wz.service.ICategoryService;
import com.wz.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/manage/category/")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;
    /**
     *
     * 添加类别
     * */
    @RequestMapping("/add_category")
    public ServerResponse addCategory(Category Category, HttpSession session){
        User user=(User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.serverResponseByError(ResponseCode.NOT_LOGIN,"未登录");
        }
        int role=user.getRole();
        if (role== RoleEnum.ROLE_USER.getRole()){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"权限不足");
        }
        return categoryService.addCategory(Category);
    }

    /**
     *
     * 修改类别
     * categoryId
     * category
     * cat
     * */
    @RequestMapping("/set_category")
    public ServerResponse updateCategory(Category Category,HttpSession session){

        User user=(User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.serverResponseByError(ResponseCode.NOT_LOGIN,"未登录");
        }
        int role=user.getRole();
        if (role== RoleEnum.ROLE_USER.getRole()){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"权限不足");
        }
        return categoryService.updateCategory(Category);
    }

    /**
     *
     * 查看平级类别
     * categoryId
     * */
    @RequestMapping("/{categoryId}")
    public ServerResponse getCategoryById(@PathVariable("categoryId") Integer categoryId ,HttpSession session){

        User user=(User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.serverResponseByError(ResponseCode.NOT_LOGIN,"未登录");
        }
        int role=user.getRole();
        if (role== RoleEnum.ROLE_USER.getRole()){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"权限不足");
        }
        return categoryService.getCategoryById(categoryId);
    }

    /**
     *
     * 递归查看平级类别
     * categoryId
     * */
    @RequestMapping("/deep/{categoryId}")
    public ServerResponse deepCategory(@PathVariable("categoryId") Integer categoryId,HttpSession session){

        User user=(User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.serverResponseByError(ResponseCode.NOT_LOGIN,"未登录");
        }
        int role=user.getRole();
        if (role== RoleEnum.ROLE_USER.getRole()){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"权限不足");
        }
        return categoryService.deepCategory(categoryId);
    }

}
