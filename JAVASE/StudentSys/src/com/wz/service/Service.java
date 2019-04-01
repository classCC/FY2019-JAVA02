package com.wz.service;

import com.wz.pojo.Student;

public interface Service {

	void checkmsg(Student[] student);
	void addmsg(Student[] student);
	void deletemsg(Student[] student,Student[] student1);
	void changemsg(Student[] student);
	void changeall(Student[] student);
	void changesome(Student[] student);
	
}
