package com.wz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wz.common.ServerResponse;
import com.wz.common.OperationEnum;
import com.wz.pojo.Admin;
import com.wz.service.ILoginService;
import com.wz.service.impl.LoginServiceImpl;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����ֽ��룬��ֹ����
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			//�����Ự
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(10);
			System.out.println("�״δ����Ựid"+session.getId());
				
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
					
				if(_operation==OperationEnum.ADMIN_LOGIN.getOperation_type()) {//��¼ 
				    	
				//��ȡ�û���
				String username= request.getParameter("username");
				//��ȡ����
				String password=request.getParameter("password");
				    	
				//����login����
				ILoginService service=LoginServiceImpl.getInstance();
				ServerResponse<Admin> serverResponse=service.login(username, password);
				    	
				//�������½
				if(serverResponse.isSucess()) {
				    //��½�ɹ�
				    session.setAttribute("user", true);
				    //����cooke
				    Cookie username_cookie=new Cookie("username",username);
				    //����cookie�Ĺ���ʱ��
				    username_cookie.setMaxAge(7*24*3600);
				    //��cookieд���ͻ��������
				    response.addCookie(username_cookie);
				    		
				    		
				    Cookie password_cookie=new Cookie("password",password);
				    password_cookie.setMaxAge(7*24*3600);
				    response.addCookie(password_cookie);
				    		
				   }
				 pw.write(serverResponse.obj2str());
				    	
			}else if(_operation==OperationEnum.ADMIN_REGISTER.getOperation_type()) {//ע��
				    	
				    	
				    }
			}catch(NumberFormatException e) {
				 //���ؿͻ�����operation����������
					
				//{"status":4,"msg":"operation����������"}
					
				String responseText="{\"status\":4,\"msg\":\"operation�������������� \"}";
				pw.write(responseText);
					pw.close();
				
			}		
	}
}
