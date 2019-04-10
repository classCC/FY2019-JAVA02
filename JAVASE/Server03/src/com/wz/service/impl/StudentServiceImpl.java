package com.wz.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.wz.common.Const;
import com.wz.common.ServerResponse;
import com.wz.pojo.Student;
import com.wz.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	//单例
	private static StudentServiceImpl instance;
	public static synchronized StudentServiceImpl getInstance() {
		if(instance==null) {
			instance=new StudentServiceImpl();
		}
		return instance;
	}
	
	//创建学生集合
	Map<Integer,Student> students=new HashMap<Integer,Student>();
	
	private StudentServiceImpl() {
		//int id,String name,int age,String sex,String grade,String address,int phone,String email,int score
		Student student1=new Student(1,"zhangsan",21,"男","高级","天津",1234567,"12345@qq.com",88);
		Student student2=new Student(2,"lixi",20,"男","中级","北京",1234444,"32145@qq.com",78);
		students.put(student1.getId(), student1);
		students.put(student2.getId(), student2);
	}
	
	@Override
	public ServerResponse<Student> checkmsg() {
		// TODO Auto-generated method stub
		
			/*System.out.println("-----------------------------------学生信息如下---------------------------------------");
			System.out.println("丨学号"+"\t" +"丨姓名"+"\t"+"丨性别"+"\t"+"丨年龄"+"\t"+"丨年级"+"\t"+"丨住址"+"\t"+"丨联系方式"+"\t"+"丨邮箱"+"\t"+"丨成绩"+"\t"+"丨上次修改时间");	    	
			Collections.sort(student);
				for(int i=0;i<student.size();i++) {
			    	if(student.get(i)!=null) {
						System.out.println("丨"+student.get(i).getId()+"\t" +"丨"+student.get(i).getName()
								+"\t"+"丨"+student.get(i).getSex()+"\t"+"丨"+student.get(i).getAge()+"\t"+"丨"
								+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddress()+"\t"+"丨"
								+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail()+"\t"+"丨"
								+student.get(i).getScore()+"\t"+"丨"+date);	
			    	}continue;
			    }
			    System.out.println("----------------------------------------------------------------------------------");	
			    checkmsg();
	    
	    else if(n==3) {
	    	Scanner sc= new Scanner(System.in);
			System.out.print("输入学生ID:");
		    int f=sc.nextInt();	
	    	Student s5=testFind(f);
	    	if(s5!=null) {
	    	System.out.println("您要查询的学生信息如下:");	
			System.out.println("\n"+"丨"+s5.getId()+"\t" +"丨"+s5.getName()+"\t"+"丨"+s5.getSex()+"\t"+"丨"+s5.getScore()+"\t"+"丨"+s5.getAge()+"\t"+"丨"+s5.getGrade()+"\t"+"丨"+s5.getAddress()+"\t"+"丨"+s5.getPhone()+"\t"+"丨"+s5.getEmail()+"\n");
			System.out.println("自动返回上一级......");
	    }else if(n==4) {
	        //返回上一级
	    }else {
	    	System.out.println("请重新输入");
	    	checkmsg(student);
	    }*/
		
		return null;
	}

	@Override
	public ServerResponse<Student> checkone(int id) {
		// TODO Auto-generated method stub
		/*Student ids=checkone(1);
		if(id==0) {
			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_NULL, "用户名不能为空");
		}*/
		
		return null;
	}

	@Override
	public ServerResponse<Student> addmsg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse<Student> deletemsg(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse<Student> changemsg(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
