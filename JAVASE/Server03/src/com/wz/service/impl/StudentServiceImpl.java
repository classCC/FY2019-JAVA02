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

	//����
	private static StudentServiceImpl instance;
	public static synchronized StudentServiceImpl getInstance() {
		if(instance==null) {
			instance=new StudentServiceImpl();
		}
		return instance;
	}
	
	//����ѧ������
	Map<Integer,Student> students=new HashMap<Integer,Student>();
	
	private StudentServiceImpl() {
		//int id,String name,int age,String sex,String grade,String address,int phone,String email,int score
		Student student1=new Student(1,"zhangsan",21,"��","�߼�","���",1234567,"12345@qq.com",88);
		Student student2=new Student(2,"lixi",20,"��","�м�","����",1234444,"32145@qq.com",78);
		students.put(student1.getId(), student1);
		students.put(student2.getId(), student2);
	}
	
	@Override
	public ServerResponse<Student> checkmsg() {
		// TODO Auto-generated method stub
		
			/*System.out.println("-----------------------------------ѧ����Ϣ����---------------------------------------");
			System.out.println("حѧ��"+"\t" +"ح����"+"\t"+"ح�Ա�"+"\t"+"ح����"+"\t"+"ح�꼶"+"\t"+"حסַ"+"\t"+"ح��ϵ��ʽ"+"\t"+"ح����"+"\t"+"ح�ɼ�"+"\t"+"ح�ϴ��޸�ʱ��");	    	
			Collections.sort(student);
				for(int i=0;i<student.size();i++) {
			    	if(student.get(i)!=null) {
						System.out.println("ح"+student.get(i).getId()+"\t" +"ح"+student.get(i).getName()
								+"\t"+"ح"+student.get(i).getSex()+"\t"+"ح"+student.get(i).getAge()+"\t"+"ح"
								+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddress()+"\t"+"ح"
								+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail()+"\t"+"ح"
								+student.get(i).getScore()+"\t"+"ح"+date);	
			    	}continue;
			    }
			    System.out.println("----------------------------------------------------------------------------------");	
			    checkmsg();
	    
	    else if(n==3) {
	    	Scanner sc= new Scanner(System.in);
			System.out.print("����ѧ��ID:");
		    int f=sc.nextInt();	
	    	Student s5=testFind(f);
	    	if(s5!=null) {
	    	System.out.println("��Ҫ��ѯ��ѧ����Ϣ����:");	
			System.out.println("\n"+"ح"+s5.getId()+"\t" +"ح"+s5.getName()+"\t"+"ح"+s5.getSex()+"\t"+"ح"+s5.getScore()+"\t"+"ح"+s5.getAge()+"\t"+"ح"+s5.getGrade()+"\t"+"ح"+s5.getAddress()+"\t"+"ح"+s5.getPhone()+"\t"+"ح"+s5.getEmail()+"\n");
			System.out.println("�Զ�������һ��......");
	    }else if(n==4) {
	        //������һ��
	    }else {
	    	System.out.println("����������");
	    	checkmsg(student);
	    }*/
		
		return null;
	}

	@Override
	public ServerResponse<Student> checkone(int id) {
		// TODO Auto-generated method stub
		/*Student ids=checkone(1);
		if(id==0) {
			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_NULL, "�û�������Ϊ��");
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
