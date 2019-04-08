package com.wz.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.wz.enums.Grade;
import com.wz.pojo.Student;
import com.wz.service.Service;

public class ServiceImpl implements Service {

	//ViewImpl start1=new ViewImpl();会出现栈溢出异常
	private static ServiceImpl F1;//单例
	private List<Student> student=new ArrayList<Student>();
	
	private ServiceImpl() {
		Student s0=new Student(1,"1",1,"1","高级","1",1,"1",1);
		Student s1=new Student(3,"3",3,"3","中级","3",3,"3",3);
		Student s2=new Student(2,"2",2,"2","低级","2",2,"2",2);
		student.add(s0);
		student.add(s1);
		student.add(s2);
	}
	
	boolean x=false;
	
	//封装一个静态的ServiceImpl getInstance方法
	public synchronized static ServiceImpl getInstance() {
		if(F1==null) {
			 F1=new ServiceImpl();
		}
			return F1;
	}
	
	//获取当前时间戳
	public static String timeStamp(){  
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);  
        return t;  
    }
	
	//时间戳转成日期格式字符串
	public static String timeStamp2Date(String seconds,String format) {  
		if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
             return "";  
        }  
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }   
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        return sdf.format(new Date(Long.valueOf(seconds+"000")));  
    }
	
	//查看信息
	String date=timeStamp2Date(timeStamp(), "yyyy-MM-dd HH:mm:ss");
	@Override
	public void checkmsg(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("1.成绩升序查看	2.成绩降序查看	3.ID查询学生	4.返回上一级");
		System.out.println("---------------------------------------------------------------------------------");
		Scanner sc= new Scanner(System.in);
		System.out.print("请选择您要查看的方式:");
	    int n=sc.nextInt();
	    if(n==1) {
			System.out.println("-----------------------------------学生信息如下---------------------------------------");
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
	    }else if(n==2) {
	    	System.out.println("-----------------------------------学生信息如下---------------------------------------");
			System.out.println("丨学号"+"\t" +"丨姓名"+"\t"+"丨性别"+"\t"+"丨年龄"+"\t"+"丨年级"+"\t"+"丨住址"+"\t"+"丨联系方式"+"\t"+"丨邮箱"+"\t"+"丨成绩"+"\t"+"丨上次修改时间");	    	
			Collections.sort(student);
			Collections.reverse(student);
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
	    }else if(n==3) {
	    	findStudent() ;
	    }else if(n==4) {
	        //返回上一级
	    }else {
	    	System.out.println("请重新输入");
	    	checkmsg(/*student*/);
	    }
	}
	
	//添加信息
	@Override
	public void addmsg(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		System.out.println("-------------请选择要操作的信息对应数字------------");
		Scanner sc=new Scanner(System.in);
		int studentid;
			System.out.print("请输入学号：");
			studentid=sc.nextInt();
			boolean judge=false;
			for(int i=0;i<student.size();i++) {
				if(student.get(i).getId()==studentid) {		
					judge = true;			
					break;
				}else {
					judge = false;			
					break;
				}
			}
			if(judge) {
				System.out.println("您输入的账号已存在");
				addmsg();
			}else {
				System.out.print("请输入学生姓名：");
				String name1=sc.next();
				sc.nextLine();
				System.out.print("请输入学生性别：");
				String sex1=sc.next();
				sc.nextLine();
				System.out.print("请输入学生年龄：");
				int age1=sc.nextInt();
				sc.nextLine();
				String grade1=gradechoice();
				/*System.out.print("请输入学生班级：");
				String grade1=sc.next();
				sc.nextLine();*/
				System.out.print("请输入学生地址：");
				String address1=sc.next();
				sc.nextLine();
				System.out.print("请输入学生手机号：");
				int phone1=sc.nextInt();
				sc.nextLine();
				System.out.print("请输入学生邮箱：");
				String email1=sc.next();
				sc.nextLine();
				System.out.print("请输入学生成绩：");
				int score1=sc.nextInt();
		
				//创建学生对象
				Student s = new Student();
				s.setId(studentid);
				s.setName(name1);
				s.setSex(sex1);
				s.setAge(age1);
				s.setGrade(grade1);
				s.setAddress(address1);
				s.setPhone(phone1);
				s.setEmail(email1);
				s.setScore(score1);
				
				//把学生对象添加到集合
				/*for(int i=0;i<student.size();i++) {
						student.add(i,s);	
						break;
				}*/
				student.add(s);
				timeStamp();
				System.out.println("添加成功！");
				System.out.println("系统自动返回上一级......");
			}
		
	}

	
	//枚举法
	public String gradechoice() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in); 
		System.out.print("请输入学生年级：(1.高级，2.中级，3.初级)");
    	System.out.print("请选择:"); 
    	int n=sc.nextInt(); 
        switch(n) {
        case 1:
    		System.out.println(Grade.MAX_GRADE.getGrade().toString());
    		return Grade.MAX_GRADE.getGrade();
        case 2:
    		System.out.println(Grade.MID_GRADE.getGrade().toString());
    		return Grade.MID_GRADE.getGrade();
        case 3:
    		System.out.println(Grade.MIN_GRADE.getGrade().toString());
    		return Grade.MIN_GRADE.getGrade();
        default:
    		System.out.println("选择有误，请重新选择");
    		gradechoice();
          }
		return "" ;
		
	}

	//删除信息
	@Override
	public void deletemsg(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入您要删除的学生ID:");
		int nid=sc.nextInt();
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;	
			}
			if(student.get(i).getId()==nid) {
				System.out.println("您要删除的学生信息如下:");	
				System.out.println("丨"+student.get(i).getId()+"\t" +"丨"+student.get(i).getName()
						+"\t"+"丨"+student.get(i).getSex()+"\t"+"丨"+student.get(i).getAge()
						+"\t"+"丨"+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddress()
						+"\t"+"丨"+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail()
						+"\t"+"丨"+student.get(i).getScore());	
				System.out.println("请确认是否删除:1.是	2.否 ");
				System.out.print("请输入:");
				int nid1=sc.nextInt();
				if(nid1==1) {
					/*for(int j=0;j<student.size();j++) {
						if(student.get(j)==null) {
							continue;
						}
						if(student.get(i).getId()!=student.get(j).getId()) {
							Student s=new Student(student.get(j).getId(),student.get(j).getName(),student.get(j).getAge(),
									student.get(j).getSex(),student.get(j).getGrade(),student.get(j).getAddress(),
									student.get(j).getPhone(),student.get(j).getEmail(),student.get(j).getScore());
							for(int k=0;k<student1.length;k++) {
								if(student1[k]==null) {
									student1[k]=s;
									break;
									}
								}
							}
						}*/
					student.remove(i);
					//System.arraycopy(student1, 0, student, 0, student1.length);//student=student1;
					System.out.println("删除成功");	
					break;
				}else if(nid1==2) {
					System.out.println("取消");	
					break;
				}else {
					System.out.println("请重新输入");
					deletemsg(/*student*/); 
					break;
				}
			}else {
				x=true;
			}
		}
		if(x==true) {
			System.out.println("您要删除的学生不存在");	
			deletemsg(/*student*/);
		}
		
	}
				

	//修改信息
	@Override
	public void changemsg(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		System.out.println("---------------请选择要操作的信息对应数字---------------");
		System.out.println("1.修改全部信息          2.修改部分信息          3.返回上级目录          4.系统退出");
		System.out.println("-----------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("请选择：");
		int n=sc.nextInt();
		if(n==1) {					
			//根据ID修改学生全部信息
			changeall(/*student*/);
			}else if(n==2) {
			//根据ID修改学生部分信息
			changesome(/*student*/);
			}else if(n==3) {
			//mainmenu(student);    //返回上级目录
			}else if(n==4){
			System.out.println("系统退出成功！");
			System.exit(0);			//退出
			}else {
				System.out.println("请重新输入");	
				changemsg(/*student*/);
			}
	}

	//修改全部
	@Override
	public void changeall(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入要修改的id：");
		int id=sc.nextInt();
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;
			}
			x=false;
			if(student.get(i).getId()==id) {
				System.out.println("要修改的学生信息如下:");	
				System.out.println("丨"+student.get(i).getId()+"\t" +"丨"+student.get(i).getName()+"\t"+"丨"+student.get(i).getSex()
						+"\t"+"丨"+student.get(i).getAge()+"\t"+"丨"+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddress()
						+"\t"+"丨"+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail()+"\t"+"丨"+student.get(i).getScore());
				System.out.print("请输入修改后的姓名：");
				String name=sc.next();
				student.get(i).setName(name);
				System.out.print("请输入修改后的性别：");
				String sex=sc.next();
				student.get(i).setSex(sex);
				System.out.print("请输入修改后的年龄：");
				int age=sc.nextInt();
				student.get(i).setAge(age);
				System.out.print("请输入修改后的年级：");
				String grade=sc.next();
				student.get(i).setGrade(grade);
				System.out.print("请输入修改后的地址：");
				String address=sc.next();
				student.get(i).setAddress(address);
				System.out.print("请输入修改后的手机号：");
				int phone=sc.nextInt();
				student.get(i).setPhone(phone);
				System.out.print("请输入修改后的邮箱：");
				String email=sc.next();
				student.get(i).setEmail(email);
				System.out.print("请输入修改后的成绩：");
				int score=sc.nextInt();
				student.get(i).setScore(score);
				timeStamp();
				System.out.println("修改成功！自动返回上一级......");
				changemsg(/*student*/);
				break;	
			}else {
				x=true;
			}
		}
		if(x==true) {
			System.out.println("此ID不存在，请重新输入");
			changeall(/*student*/);
		}
	}

	//修改部分
	@Override
	public void changesome(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入要修改的id：");
		int id=sc.nextInt();
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;
			}
			x=false;
			if(student.get(i).getId()==id) {
				System.out.println("您要修改的学生信息如下:");	
				System.out.println("丨"+student.get(i).getId()+"\t" +"丨"+student.get(i).getName()+"\t"+"丨"+student.get(i).getSex()
						+"\t"+"丨"+student.get(i).getAge()+"\t"+"丨"+student.get(i).getGrade()+"\t"+"丨"+student.get(i).getAddress()
						+"\t"+"丨"+student.get(i).getPhone()+"\t"+"丨"+student.get(i).getEmail()+"\t"+"丨"+student.get(i).getScore());
				System.out.println("请输入要修改的属性：");	 
				String t3=sc.next();
				System.out.println("请输入修改后的值：");	 
				String t4=sc.next();
				if(t3.equals("name")) {
					student.get(i).setName(t4);
				}else if(t3.equals("sex")) {
					student.get(i).setSex(t4);
				}else if(t3.equals("age")) {
					student.get(i).setAge(Integer.valueOf(t4));
				}else if(t3.equals("grade")) {
					student.get(i).setGrade(t4);
				}else if(t3.equals("addr")) {
					student.get(i).setAddress(t4);
				}else if(t3.equals("phone")) {
					student.get(i).setPhone(Integer.valueOf(t4));
				}else if(t3.equals("email")) {
					student.get(i).setEmail(t4);
				}else if(t3.equals("score")) {
					student.get(i).setScore(Integer.valueOf(t4));
				}
				timeStamp();
				System.out.println("修改成功！自动返回上一级......");
				changemsg(/*student*/);
				break;	
			}else {
				x=true;
			}
	
		}
		if(x==true) {
		System.out.println("此ID不存在!!!");
		changesome(/*student*/);
		}
	}

	public  Student testFind(int c) {   //用ID二分查找对应学生
		Student s=new Student();
		//System.out.println(student.size());
		for(int i=0;i<student.size();i++) {
			for(int j=0;j<student.size()-i-1;j++) {
				if(student.get(j)!=null&&student.get(j+1)!=null) {
				if(student.get(j).getId()>student.get(j+1).getId()) {
					s=student.get(j);
					student.set(j, student.get(j+1));
					student.set(j+1, s);
				  }
				}
			}
		}	
		int a=0;
		int b=student.size()-1;
		int k=(a+b)/2;
		boolean sf=false;
		while(a<=b) {
		if(c>student.get(k).getId()) {
			a=k+1; 
		   }else if(c<student.get(k).getId()) {
			b=k-1;
		   }else {
			    sf=true;
			    break;
		   }
		 k=(a+b)/2;
		}
		
	    if(!sf) {
	    	System.out.println("您要查找的学生不存在！！");
	    	findStudent();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	
	public void findStudent() {
    	Scanner sc= new Scanner(System.in);
		System.out.print("输入学生ID:");
	    int f=sc.nextInt();	
    	Student s5=testFind(f);
    	if(s5!=null) {
    	System.out.println("您要查询的学生信息如下:");	
		System.out.println("\n"+"丨"+s5.getId()+"\t" +"丨"+s5.getName()+"\t"+"丨"+s5.getSex()+"\t"+"丨"+s5.getScore()+"\t"+"丨"+s5.getAge()+"\t"+"丨"+s5.getGrade()+"\t"+"丨"+s5.getAddress()+"\t"+"丨"+s5.getPhone()+"\t"+"丨"+s5.getEmail()+"\n");
		System.out.println("自动返回上一级......");
		checkmsg(/*student*/);	
        }
    } 

}
