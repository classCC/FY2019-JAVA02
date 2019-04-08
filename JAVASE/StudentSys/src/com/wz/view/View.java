package com.wz.view;

import java.util.List;
import java.util.Map;

import com.wz.pojo.Admin;
import com.wz.pojo.Student;

public interface View {

	void welcome();
	void choicelogin();
	void login(Admin[] admin);
	void mainmenu(/*List<Student> student*/);
	
}
