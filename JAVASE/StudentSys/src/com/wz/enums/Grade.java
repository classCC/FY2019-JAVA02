package com.wz.enums;

public enum Grade {

	MAX_GRADE("高级"),
	MID_GRADE("中级"),
	MIN_GRADE("低级")
	;
	public String grade;
	Grade(String grade) {		
		this.grade= grade;		 
	} 
	 public String getGrade() {
		 return this.grade;
	 }  
}
