package com.wz.controller.front;

import com.wz.common.ResponseCode;
import com.wz.common.ServerResponse;
import com.wz.pojo.User;
import com.wz.service.impl.UserServiceImpl;
import com.wz.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 注册接口
     *
     * */
    @RequestMapping(value = "register")
    public ServerResponse register(User user){
        return userService.register(user);
    }
    /**
     * 登陆接口
     *
     * */
    @RequestMapping(value = "login/{username}/{password}")
    public ServerResponse login(@PathVariable("username") String username,
                                @PathVariable("password") String password,
                                HttpSession session){
        ServerResponse serverResponse= userService.login(username,password,1);
        if(serverResponse.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,serverResponse.getData());
        }
        return serverResponse;
    }
    /**
     * 根据用户名找回密保问题接口
     *
     * */
    @RequestMapping(value = "forget_get_question/{username}")
    public ServerResponse forget_get_question(@PathVariable("username") String username){

        return userService.forget_get_question(username);
    }

    /**
     * 提交问题答案接口
     *
     * */
    @RequestMapping(value = "forget_check_answer")
    public ServerResponse forget_check_answer(String username,
                                              String question,
                                              String answer){
        return userService.forget_check_answer(username,question,answer);
    }

    /**
     * 重置用户密码(未登陆状态下)
     *
     * */
    @RequestMapping(value = "forget_reset_password")
    public ServerResponse forget_reset_password(String username,
                                              String newpassword,
                                              String forgettoken
                                              ){
        return userService.forget_reset_password(username,newpassword,forgettoken);
    }

    /**
     * 修改用户信息
     *
     * */
    @RequestMapping(value = "updateUserByActive")
    public ServerResponse update_information(User user,HttpSession session){
    User loginuser=(User)session.getAttribute(Const.CURRENT_USER);
    if(loginuser==null){
        return ServerResponse.serverResponseByError(ResponseCode.NOT_LOGIN,"未登陆");
    }
        user.setId(loginuser.getId());
        return userService.update_information(user);
    }

    /**
     * 获取登陆用户信息
     *
     * */
    @RequestMapping(value = "get_user_info")
    public ServerResponse get_user_info(HttpSession session){
        User loginuser=(User)session.getAttribute(Const.CURRENT_USER);
        if(loginuser==null){
            return ServerResponse.serverResponseByError(ResponseCode.ERROR,"未登陆");
        }
        return ServerResponse.serverResponseBySuccess();
    }

    /**
     * 登陆状态下重置用户密码
     *
     * */
    /*@RequestMapping(value = "reset_password")
    public ServerResponse reset_password(String oldpassword,String newpassword,HttpSession session){
        User loginuser=(User)session.getAttribute(Const.CURRENT_USER);
        if(loginuser==null){
            return ServerResponse.serverResponseByError(Constant.NOT_LOGIN,"未登陆");
        }
        int id=loginuser.getId();
       return userService.reset_password(oldpassword,newpassword,id);
    }*/

    /**
     * 获取当前登陆用户的详细信息
     *
     * */

    /*@RequestMapping(value = "get_inforamtion")
    public ServerResponse get_inforamtion(HttpSession session){
        User loginuser=(User)session.getAttribute(Const.CURRENT_USER);
        if(loginuser==null){
            return ServerResponse.serverResponseByError(Constant.NOT_LOGIN,"未登陆");
        }
        int id=loginuser.getId();
        return userService.get_inforamtion(id);
    }*/

    /**
     * 退出登录
     *
     * */

   /* @RequestMapping(value = "logout")
    public ServerResponse logout(HttpSession session){
        User loginuser=(User)session.getAttribute(Const.CURRENT_USER);
        if(loginuser==null){
            return ServerResponse.serverResponseByError(Constant.NOT_LOGIN,"未登陆");
        }
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.serverResponseBySuccess("退出成功");
    }*/





}
