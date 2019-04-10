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
		//定义字节码，防止乱码
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			//创建会话
			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(10);
			System.out.println("首次创建会话id"+session.getId());
				
			PrintWriter pw=response.getWriter();
			String operation=request.getParameter("operation");
			if(operation==null) {
				//返回客户端，operation参数必须传递  -》 json 
				//{"status":3,"msg":"operation参数必须传递 "}
				//String responseText="{\"status\":3,\"msg\":\"operation参数必须传递 \"}";
					
				String responseText=ServerResponse.createServerResponseByFail(3, "参数必传").obj2str();
				pw.write(responseText);
				pw.close();
			}
				
			//string-int 
			try {
				int _operation=Integer.parseInt(operation);
					
				if(_operation==OperationEnum.ADMIN_LOGIN.getOperation_type()) {//登录 
				    	
				//获取用户名
				String username= request.getParameter("username");
				//获取密码
				String password=request.getParameter("password");
				    	
				//调用login方法
				ILoginService service=LoginServiceImpl.getInstance();
				ServerResponse<Admin> serverResponse=service.login(username, password);
				    	
				//七天免登陆
				if(serverResponse.isSucess()) {
				    //登陆成功
				    session.setAttribute("user", true);
				    //创建cooke
				    Cookie username_cookie=new Cookie("username",username);
				    //设置cookie的过期时间
				    username_cookie.setMaxAge(7*24*3600);
				    //将cookie写到客户端浏览器
				    response.addCookie(username_cookie);
				    		
				    		
				    Cookie password_cookie=new Cookie("password",password);
				    password_cookie.setMaxAge(7*24*3600);
				    response.addCookie(password_cookie);
				    		
				   }
				 pw.write(serverResponse.obj2str());
				    	
			}else if(_operation==OperationEnum.ADMIN_REGISTER.getOperation_type()) {//注册
				    	
				    	
				    }
			}catch(NumberFormatException e) {
				 //返回客户单，operation必须是数字
					
				//{"status":4,"msg":"operation必须是数字"}
					
				String responseText="{\"status\":4,\"msg\":\"operation参数必须是数字 \"}";
				pw.write(responseText);
					pw.close();
				
			}		
	}
}
