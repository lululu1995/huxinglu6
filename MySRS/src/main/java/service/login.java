package service;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		UserDao dao=new UserDao();
		String pwd="";
		try {
			pwd = dao.selectUser(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ( password.equals(pwd)&& password!=null) {
			//login successfully
			HttpSession hs = request.getSession();
			hs.setAttribute("Name", username);
			hs.setAttribute("logined", true);
			
			String isRemberPwd =  request.getParameter("isRemberPwd");
			Cookie cookie1 = new Cookie("username",username);
			Cookie cookie2 = new Cookie("password",password);
			
			if(isRemberPwd!=null&&isRemberPwd.equals("isRemberPwd")){
				cookie1.setMaxAge(60*2);
				cookie2.setMaxAge(60*2);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			else{
				cookie1.setMaxAge(0);
				cookie2.setMaxAge(0);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				}

		
			response.sendRedirect("index.jsp");
			}else{
				response.sendRedirect("loginf.jsp");
			}
	
	}

}
