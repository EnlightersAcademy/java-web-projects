package com.jobsonclick.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobsonclick.dao.CandidateDao;
import com.jobsonclick.dao.CompanyDao;
import com.jobsonclick.models.Application;
import com.jobsonclick.models.Candidate;
import com.jobsonclick.models.Company;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/Login","/Logout","/ChangePassword"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CompanyDao companyDao;
	private CandidateDao candidateDao;

    public LoginServlet() {
    	this.companyDao = new CompanyDao();
    	this.candidateDao = new CandidateDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/Logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String role=request.getParameter("role");
		
		// Change Password candidate and company
		if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ChangePassword")) {
			System.out.println("in change password servlet");
			String newpassword = request.getParameter("newpassword");
			String oldpassword = request.getParameter("oldpassword");
			String reenterpassword = request.getParameter("reenterpassword");
			String message="";
			System.out.println("old pswd---"+oldpassword+"  "+newpassword);
			if(newpassword.equals(reenterpassword)) {

				if(role.equalsIgnoreCase("company")) {
					int id = (int)session.getAttribute("companyId");											
					message=companyDao.companyChangePassword(id, newpassword, oldpassword)?"UpdatedSuccessfully!":"Invalid Credentials!";
				}
				else if(role.equalsIgnoreCase("candidate")) {
					int id = (int)session.getAttribute("candidateId");
					message=candidateDao.candidateChangePassword(id, newpassword, oldpassword)?"UpdatedSuccessfully!":"Invalid Credentials!";
				}
				
			}
			else {
				message = "New and Confirm Password mismatch! Please enter again";
			}
			
			request.setAttribute("message", message);
			request.getRequestDispatcher(role+"changepassword.jsp").forward(request, response);
		}
		
		//Login For Admin, company and candidate
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/Login")) {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
			// Login for Company
			if( role.equalsIgnoreCase("company")) {
				Company company = companyDao.authorizeCompany(username, password);
				String message="";
				
				if(company!=null) {
					if(company.getStatus().equalsIgnoreCase("approved")) {
						session.setAttribute("companyId", company.getCompanyId());
						request.getRequestDispatcher("/CompanyHome").forward(request, response);
					}
					else if(company.getStatus().equalsIgnoreCase("rejected")) {
						message = "Your registration has been rejected. Please contact Admin!";
						request.setAttribute("message", message);
						request.getRequestDispatcher("companylogin.jsp").forward(request, response);
					}
					else if(company.getStatus().equalsIgnoreCase("new")) {
						message = "Your registration request is pending with Admin. Please try later!";
						request.setAttribute("message", message);
						request.getRequestDispatcher("companylogin.jsp").forward(request, response);
					}
						
				}
				else {
					message = "Login Failed! Invalid Username or Password";
					request.setAttribute("message", message);
					request.getRequestDispatcher("companylogin.jsp").forward(request, response);
				}
				
			}
			
			// Login for Candidate
			else if(role.equalsIgnoreCase("candidate")) {
				Candidate candidate = candidateDao.authorizeCandidate(username, password);
				String message="";
				
				if(candidate!=null) {
					session.setAttribute("candidateId", candidate.getCandidateId());
					request.getRequestDispatcher("/CandidateHome").forward(request, response);
				}
				else {
					message = "Login Failed! Invalid Username or Password";
					request.setAttribute("message", message);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
				
			}
			
			// Login for Admin
			else if(role.equalsIgnoreCase("admin")) {
				
				String message="";
					
				if(username.equalsIgnoreCase("admin")&&password.equals("admin")) {
					
					session.setAttribute("admin",true);
					
					request.setAttribute("username", username);
					request.getRequestDispatcher("/AdminHome").forward(request, response);
				}
				else {
					message = "Login Failed! Invalid Username or Password";
				}
				request.setAttribute("message", message);
				request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
							
			}			
		
	}
		
	}

}
