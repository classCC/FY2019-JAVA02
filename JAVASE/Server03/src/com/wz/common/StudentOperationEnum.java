package com.wz.common;

public enum StudentOperationEnum {

	STUDENT_ADDMSG(1,"添加学生信息"),
	STUDENT_CHECKMSG(2,"查看学生信息"),
	STUDENT_CHECKONE(3,"根据ID查看学生信息"),
	STUDENT_DELETEMSG(4,"删除学生信息"),
	STUDENT_CHANGEMSG(5,"修改学生信息"),
	
	
	;
	private  int  operation_type;
	private String operation_desc;
	StudentOperationEnum(int operation_type,String operation_desc) {
		this.operation_type=operation_type;
		this.operation_desc=operation_desc;
	}
	public int getOperation_type() {
		return operation_type;
	}
	public void setOperation_type(int operation_type) {
		this.operation_type = operation_type;
	}
	public String getOperation_desc() {
		return operation_desc;
	}
	public void setOperation_desc(String operation_desc) {
		this.operation_desc = operation_desc;
	}
}
