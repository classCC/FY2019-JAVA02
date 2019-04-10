package com.wz.common;

import com.google.gson.Gson;

//封装ServerResponse
public class ServerResponse<T> {

	private int status;
	private String msg;
	private T data;
	
	
	//构造方法
	private  ServerResponse() {}
	
	private ServerResponse(int status) {
		this.status=status;
	}
	
	private ServerResponse(int status,String msg) {
		this.status=status;
		this.msg=msg;
	}
	
	private ServerResponse(int status,T data) {
		this.status=status;
		this.data=data;
	}
	
	private ServerResponse(int status,String msg,T data) {
		this.status=status;
		this.msg=msg;
		this.data=data;
	}
	
	/**
	  * 判断接口是否调用成功
	  * */
	 
	 public   boolean isSucess() {
		 
		 return this.status==0;
	 }
	
	
	//接口调用成功
	/**
	  * status==0,接口调用成功.
	  * {status:0}
	  * 
	  * */
	public static ServerResponse createServerResponseBySuccess() {
		
		return new ServerResponse(0);
	}
	
	/**
	  * {status:0,msg:""}
	  * 成功后输出status为0
	  * */
	public static ServerResponse createServerResponseBySuccess(String msg) {
		
		return new ServerResponse(0,msg);
	}
	
	/**
	  * {status:0,msg:"",data:}
	  * 成功后输出status为0
	  * */
	public static <T> ServerResponse<T> createServerResponseBySuccess(String msg,T data) {
		
		return new ServerResponse<T>(0,msg,data);
	}
	
	//接口调用其他值
	/**
     * status !=0 
     * {status:  } 
     * */
    public  static ServerResponse createServerResponseByFail(int status) {
		 
		 return new ServerResponse(status);
	 }
    /**
	  * {status: ,msg:""}
	  * */
    public static ServerResponse createServerResponseByFail(int status,String msg) {
		 
		 return new ServerResponse(status,msg);
	 }
	
    
    public  String  obj2str() {
   	 
		Gson gson=new Gson();
		String responseText=gson.toJson(this);
	    return responseText;
    }
    
    
	
	//get,set
	public int getStatus() {
		return status;
	}

	public void setStstus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
