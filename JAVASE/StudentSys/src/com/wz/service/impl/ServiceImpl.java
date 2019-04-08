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

	//ViewImpl start1=new ViewImpl();�����ջ����쳣
	private static ServiceImpl F1;//����
	private List<Student> student=new ArrayList<Student>();
	
	private ServiceImpl() {
		Student s0=new Student(1,"1",1,"1","�߼�","1",1,"1",1);
		Student s1=new Student(3,"3",3,"3","�м�","3",3,"3",3);
		Student s2=new Student(2,"2",2,"2","�ͼ�","2",2,"2",2);
		student.add(s0);
		student.add(s1);
		student.add(s2);
	}
	
	boolean x=false;
	
	//��װһ����̬��ServiceImpl getInstance����
	public synchronized static ServiceImpl getInstance() {
		if(F1==null) {
			 F1=new ServiceImpl();
		}
			return F1;
	}
	
	//��ȡ��ǰʱ���
	public static String timeStamp(){  
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);  
        return t;  
    }
	
	//ʱ���ת�����ڸ�ʽ�ַ���
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
	
	//�鿴��Ϣ
	String date=timeStamp2Date(timeStamp(), "yyyy-MM-dd HH:mm:ss");
	@Override
	public void checkmsg(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("1.�ɼ�����鿴	2.�ɼ�����鿴	3.ID��ѯѧ��	4.������һ��");
		System.out.println("---------------------------------------------------------------------------------");
		Scanner sc= new Scanner(System.in);
		System.out.print("��ѡ����Ҫ�鿴�ķ�ʽ:");
	    int n=sc.nextInt();
	    if(n==1) {
			System.out.println("-----------------------------------ѧ����Ϣ����---------------------------------------");
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
	    }else if(n==2) {
	    	System.out.println("-----------------------------------ѧ����Ϣ����---------------------------------------");
			System.out.println("حѧ��"+"\t" +"ح����"+"\t"+"ح�Ա�"+"\t"+"ح����"+"\t"+"ح�꼶"+"\t"+"حסַ"+"\t"+"ح��ϵ��ʽ"+"\t"+"ح����"+"\t"+"ح�ɼ�"+"\t"+"ح�ϴ��޸�ʱ��");	    	
			Collections.sort(student);
			Collections.reverse(student);
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
	    }else if(n==3) {
	    	findStudent() ;
	    }else if(n==4) {
	        //������һ��
	    }else {
	    	System.out.println("����������");
	    	checkmsg(/*student*/);
	    }
	}
	
	//�����Ϣ
	@Override
	public void addmsg(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		System.out.println("-------------��ѡ��Ҫ��������Ϣ��Ӧ����------------");
		Scanner sc=new Scanner(System.in);
		int studentid;
			System.out.print("������ѧ�ţ�");
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
				System.out.println("��������˺��Ѵ���");
				addmsg();
			}else {
				System.out.print("������ѧ��������");
				String name1=sc.next();
				sc.nextLine();
				System.out.print("������ѧ���Ա�");
				String sex1=sc.next();
				sc.nextLine();
				System.out.print("������ѧ�����䣺");
				int age1=sc.nextInt();
				sc.nextLine();
				String grade1=gradechoice();
				/*System.out.print("������ѧ���༶��");
				String grade1=sc.next();
				sc.nextLine();*/
				System.out.print("������ѧ����ַ��");
				String address1=sc.next();
				sc.nextLine();
				System.out.print("������ѧ���ֻ��ţ�");
				int phone1=sc.nextInt();
				sc.nextLine();
				System.out.print("������ѧ�����䣺");
				String email1=sc.next();
				sc.nextLine();
				System.out.print("������ѧ���ɼ���");
				int score1=sc.nextInt();
		
				//����ѧ������
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
				
				//��ѧ��������ӵ�����
				/*for(int i=0;i<student.size();i++) {
						student.add(i,s);	
						break;
				}*/
				student.add(s);
				timeStamp();
				System.out.println("��ӳɹ���");
				System.out.println("ϵͳ�Զ�������һ��......");
			}
		
	}

	
	//ö�ٷ�
	public String gradechoice() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in); 
		System.out.print("������ѧ���꼶��(1.�߼���2.�м���3.����)");
    	System.out.print("��ѡ��:"); 
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
    		System.out.println("ѡ������������ѡ��");
    		gradechoice();
          }
		return "" ;
		
	}

	//ɾ����Ϣ
	@Override
	public void deletemsg(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("��������Ҫɾ����ѧ��ID:");
		int nid=sc.nextInt();
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;	
			}
			if(student.get(i).getId()==nid) {
				System.out.println("��Ҫɾ����ѧ����Ϣ����:");	
				System.out.println("ح"+student.get(i).getId()+"\t" +"ح"+student.get(i).getName()
						+"\t"+"ح"+student.get(i).getSex()+"\t"+"ح"+student.get(i).getAge()
						+"\t"+"ح"+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddress()
						+"\t"+"ح"+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail()
						+"\t"+"ح"+student.get(i).getScore());	
				System.out.println("��ȷ���Ƿ�ɾ��:1.��	2.�� ");
				System.out.print("������:");
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
					System.out.println("ɾ���ɹ�");	
					break;
				}else if(nid1==2) {
					System.out.println("ȡ��");	
					break;
				}else {
					System.out.println("����������");
					deletemsg(/*student*/); 
					break;
				}
			}else {
				x=true;
			}
		}
		if(x==true) {
			System.out.println("��Ҫɾ����ѧ��������");	
			deletemsg(/*student*/);
		}
		
	}
				

	//�޸���Ϣ
	@Override
	public void changemsg(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		System.out.println("---------------��ѡ��Ҫ��������Ϣ��Ӧ����---------------");
		System.out.println("1.�޸�ȫ����Ϣ          2.�޸Ĳ�����Ϣ          3.�����ϼ�Ŀ¼          4.ϵͳ�˳�");
		System.out.println("-----------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("��ѡ��");
		int n=sc.nextInt();
		if(n==1) {					
			//����ID�޸�ѧ��ȫ����Ϣ
			changeall(/*student*/);
			}else if(n==2) {
			//����ID�޸�ѧ��������Ϣ
			changesome(/*student*/);
			}else if(n==3) {
			//mainmenu(student);    //�����ϼ�Ŀ¼
			}else if(n==4){
			System.out.println("ϵͳ�˳��ɹ���");
			System.exit(0);			//�˳�
			}else {
				System.out.println("����������");	
				changemsg(/*student*/);
			}
	}

	//�޸�ȫ��
	@Override
	public void changeall(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("������Ҫ�޸ĵ�id��");
		int id=sc.nextInt();
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;
			}
			x=false;
			if(student.get(i).getId()==id) {
				System.out.println("Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("ح"+student.get(i).getId()+"\t" +"ح"+student.get(i).getName()+"\t"+"ح"+student.get(i).getSex()
						+"\t"+"ح"+student.get(i).getAge()+"\t"+"ح"+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddress()
						+"\t"+"ح"+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail()+"\t"+"ح"+student.get(i).getScore());
				System.out.print("�������޸ĺ��������");
				String name=sc.next();
				student.get(i).setName(name);
				System.out.print("�������޸ĺ���Ա�");
				String sex=sc.next();
				student.get(i).setSex(sex);
				System.out.print("�������޸ĺ�����䣺");
				int age=sc.nextInt();
				student.get(i).setAge(age);
				System.out.print("�������޸ĺ���꼶��");
				String grade=sc.next();
				student.get(i).setGrade(grade);
				System.out.print("�������޸ĺ�ĵ�ַ��");
				String address=sc.next();
				student.get(i).setAddress(address);
				System.out.print("�������޸ĺ���ֻ��ţ�");
				int phone=sc.nextInt();
				student.get(i).setPhone(phone);
				System.out.print("�������޸ĺ�����䣺");
				String email=sc.next();
				student.get(i).setEmail(email);
				System.out.print("�������޸ĺ�ĳɼ���");
				int score=sc.nextInt();
				student.get(i).setScore(score);
				timeStamp();
				System.out.println("�޸ĳɹ����Զ�������һ��......");
				changemsg(/*student*/);
				break;	
			}else {
				x=true;
			}
		}
		if(x==true) {
			System.out.println("��ID�����ڣ�����������");
			changeall(/*student*/);
		}
	}

	//�޸Ĳ���
	@Override
	public void changesome(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("������Ҫ�޸ĵ�id��");
		int id=sc.nextInt();
		for(int i=0;i<student.size();i++) {
			if(student.get(i)==null) {
				continue;
			}
			x=false;
			if(student.get(i).getId()==id) {
				System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("ح"+student.get(i).getId()+"\t" +"ح"+student.get(i).getName()+"\t"+"ح"+student.get(i).getSex()
						+"\t"+"ح"+student.get(i).getAge()+"\t"+"ح"+student.get(i).getGrade()+"\t"+"ح"+student.get(i).getAddress()
						+"\t"+"ح"+student.get(i).getPhone()+"\t"+"ح"+student.get(i).getEmail()+"\t"+"ح"+student.get(i).getScore());
				System.out.println("������Ҫ�޸ĵ����ԣ�");	 
				String t3=sc.next();
				System.out.println("�������޸ĺ��ֵ��");	 
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
				System.out.println("�޸ĳɹ����Զ�������һ��......");
				changemsg(/*student*/);
				break;	
			}else {
				x=true;
			}
	
		}
		if(x==true) {
		System.out.println("��ID������!!!");
		changesome(/*student*/);
		}
	}

	public  Student testFind(int c) {   //��ID���ֲ��Ҷ�Ӧѧ��
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
	    	System.out.println("��Ҫ���ҵ�ѧ�������ڣ���");
	    	findStudent();
	    }else {
	    return student.get(k);
	    }
	    Student sempty=new Student();
	    return sempty;
	}
	
	
	public void findStudent() {
    	Scanner sc= new Scanner(System.in);
		System.out.print("����ѧ��ID:");
	    int f=sc.nextInt();	
    	Student s5=testFind(f);
    	if(s5!=null) {
    	System.out.println("��Ҫ��ѯ��ѧ����Ϣ����:");	
		System.out.println("\n"+"ح"+s5.getId()+"\t" +"ح"+s5.getName()+"\t"+"ح"+s5.getSex()+"\t"+"ح"+s5.getScore()+"\t"+"ح"+s5.getAge()+"\t"+"ح"+s5.getGrade()+"\t"+"ح"+s5.getAddress()+"\t"+"ح"+s5.getPhone()+"\t"+"ح"+s5.getEmail()+"\n");
		System.out.println("�Զ�������һ��......");
		checkmsg(/*student*/);	
        }
    } 

}
