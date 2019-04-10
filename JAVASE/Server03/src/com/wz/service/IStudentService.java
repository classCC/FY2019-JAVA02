package com.wz.service;

import com.wz.common.ServerResponse;
import com.wz.pojo.Student;

public interface IStudentService {

	public ServerResponse<Student> checkmsg();
	public ServerResponse<Student> checkone(int id);
	public ServerResponse<Student> addmsg();
	public ServerResponse<Student> deletemsg(int id);
	public ServerResponse<Student> changemsg(int id);
}
