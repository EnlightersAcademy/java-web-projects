package com.shipwell.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.shipwell.db.connection.DBConnectionProvider;
import com.shipwell.utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/LoginServlet","/CustomerLogin", "/AdminLogin", "/LogisticPartnerLogin","/logout"})
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		if(request.getRequestURI().equalsIgnoreCase("/ShipWell/logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Connection con=null;
		PreparedStatement statement = null;
		ResultSet results = null;
		System.out.println("in login servlet...");
			
			try {
				con = DBConnectionProvider.getConnection();
				String username=request.getParameter("email");
				String password=request.getParameter("password");
				
				if(request.getRequestURI().equalsIgnoreCase("/ShipWell/AdminLogin")) {
					if(username.equalsIgnoreCase("admin")&&password.equals("admin")) {
					session.setAttribute("admin",true);

					//request.setAttribute("username", username);
					request.getRequestDispatcher("adminhome.jsp").forward(request, response);
					}
					else {
						request.setAttribute("message", "Login Falied! Invalid Credentials.");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}
				else if(request.getRequestURI().equalsIgnoreCase("/ShipWell/LogisticPartnerLogin")){
					
					statement=con.prepareStatement("select * from logistic_partner where email_id=? and password=?");
					statement.setString(1, username);
					statement.setString(2, password);
					results=statement.executeQuery();
					
					if(results.next()) {
						System.out.println("in user");
						if(0 == results.getInt("status")) {
							
							request.setAttribute("message", "Your registration is not yet approved by Admin!");
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}
						else if(results.getString("active").equalsIgnoreCase("Deactive")) {
							request.setAttribute("message", "Your account has been deactivated. Please contact the Admin!");
							request.getRequestDispatcher("index.jsp").forward(request, response);
						}
						else
						{session.setAttribute("email", results.getString("email"));
						session.setAttribute("userid", results.getInt("userid"));

						
						request.getRequestDispatcher("userhome.jsp").forward(request, response);}
						
					}
					else {
						System.out.println("Invalid password");
						request.setAttribute("message", "Login Falied! Invalid Credentials.");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}
				else if(request.getRequestURI().equalsIgnoreCase("/ShipWell/CustomerLogin")){
					statement=con.prepareStatement("select * from customer where email_id=? and password=?");
					statement.setString(1, username);
					statement.setString(2, password);
					results=statement.executeQuery();
					
					if(results.next()) {

						request.getRequestDispatcher("userhome.jsp").forward(request, response);
						
					}
					else {
						System.out.println("Invalid password");
						request.setAttribute("message", "Login Falied! Invalid Credentials.");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
				}
				
			} catch(Exception exe) {
				request.setAttribute("isException", "Error logging in");
			}
			finally {
				DBConnectionProvider.closeStatementAndResultSets(statement, results);
			}
					
	}
	
		
}

