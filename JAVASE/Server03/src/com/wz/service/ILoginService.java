package com.wz.service;

import com.wz.common.ServerResponse;
import com.wz.pojo.Admin;

public interface ILoginService {

	public  ServerResponse<Admin>  login(String username,String password);

	
}
