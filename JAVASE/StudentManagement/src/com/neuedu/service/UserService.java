package com.neuedu.service;

import com.neuedu.pojo.Admin;

public interface UserService {

	 //���ѧ����Ϣ
	 void addto(int id,String name,String sex,int age,
			 String grade,String address,String email);
	 //�޸�ѧ����Ϣ
	 void change();
}
