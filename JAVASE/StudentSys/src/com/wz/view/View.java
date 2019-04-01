package com.wz.view;

import com.wz.pojo.Admin;
import com.wz.pojo.Student;

public interface View {

	void welcome();
	void choicelogin();
	void login(Admin[] admin);
	void mainmenu(Student[]student1,Student[]student2);
	
}
