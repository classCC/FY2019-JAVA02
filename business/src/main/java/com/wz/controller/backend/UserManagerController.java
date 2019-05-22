package com.wz.controller.backend;

import com.wz.common.RoleEnum;
import com.wz.common.ServerResponse;
import com.wz.service.IUserService;
import com.wz.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/manage/")
public class UserManagerController {

    @Autowired
    IUserService userService;
    @RequestMapping(value = "login/{username}/{password}")
    public ServerResponse login(@PathVariable("username") String username,
                                @PathVariable("password") String password,
                                HttpSession session){
        ServerResponse serverResponse= userService.login(username,password, RoleEnum.ROLE_ADMIN.getRole());
        if(serverResponse.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,serverResponse.getData());
        }
        return serverResponse;
    }

}
