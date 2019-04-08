package com.wz.pojo;

public class Student implements Comparable<Student>{

	public int id;
	public String name;
	public int age;
	public String sex;
	public String grade;
	public String address;
	public int phone;
	public String email;
	public int score;
	
	//定义Student初始化的输入参数
	public Student(int id,String name,int age,String sex,String grade,
			String address,int phone,String email,int score){
		this.id=id;
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.grade=grade;
		this.address=address;
		this.phone=phone;
		this.email=email;
		this.score=score;
	}
	
	public Student(){
		
	}

	
	public int compareTo(Student o) {
		return this.score-o.score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
