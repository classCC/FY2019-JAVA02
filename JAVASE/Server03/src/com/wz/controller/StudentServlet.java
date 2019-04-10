package com.wz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wz.common.OperationEnum;
import com.wz.common.ServerResponse;
import com.wz.common.StudentOperationEnum;
import com.wz.pojo.Admin;
import com.wz.service.IStudentService;
import com.wz.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		PrintWriter pw=response.getWriter();
		String operation=request.getParameter("operation");
		if(operation==null) {
			//���ؿͻ��ˣ�operation�������봫��  -�� json 
			//{"status":3,"msg":"operation�������봫�� "}
			//String responseText="{\"status\":3,\"msg\":\"operation�������봫�� \"}";
				
			String responseText=ServerResponse.createServerResponseByFail(3, "�����ش�").obj2str();
			pw.write(responseText);
			pw.close();
		}
			
		//string-int 
		try {
			int _operation=Integer.parseInt(operation);
				
			if(_operation==StudentOperationEnum.STUDENT_ADDMSG.getOperation_type()) {//���
		    	
		    	
		    }else if(_operation==StudentOperationEnum.STUDENT_CHECKMSG.getOperation_type()) {//�鿴ȫ��
		    	
		    	
		    }else if(_operation==StudentOperationEnum.STUDENT_CHECKONE.getOperation_type()) {//�鿴����
		    	//��ȡѧ��id
		    	String id= request.getParameter("id");
		    	//���÷���
		    	IStudentService service=StudentServiceImpl.getInstance();
				ServerResponse<Admin> serverResponse=service.checkone("id");
		    	
		    }else if(_operation==StudentOperationEnum.STUDENT_DELETEMSG.getOperation_type()) {//ɾ��
		    	//��ȡѧ��id
		    	String id= request.getParameter("id");
		    	
		    }else if(_operation==StudentOperationEnum.STUDENT_CHANGEMSG.getOperation_type()) {//�޸�
		    	//��ȡѧ��id
		    	String id= request.getParameter("id");
		    	
		    }
			 pw.write(serverResponse.obj2str());
			    	
		}catch(NumberFormatException e) {
			 //���ؿͻ�����operation����������
				
			//{"status":4,"msg":"operation����������"}
				
			String responseText="{\"status\":4,\"msg\":\"operation�������������� \"}";
			pw.write(responseText);
				pw.close();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
