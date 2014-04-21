package org.koushik.javabrains;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.koushik.javabrains.dto.User;
import org.koushik.javabrains.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userID, password;
		userID = request.getParameter("userID");
		password = request.getParameter("password");
		
		//controller call Login Service
		LoginService loginService = new LoginService();
		boolean result = loginService.authenticate(userID, password);
		
		if (result){
			User user = loginService.getUserDetails(userID);
			//request.getSession().setAttribute("user", user);  //session for jsp page to access
			// at this point, servlet redirect to success page, Pass the original request (with data) will be lost
			// this is the reason to use session to store user information
			//response.sendRedirect("success.jsp");  //but not every information can be stored in session
			// solution: use Request Dispatcher
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");  //we consider, now, the redirect use the same request
			dispatcher.forward(request, response); //this forward happened in the server side, so the browser don't know it is a second request
			
			return;
		}
		else{
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
