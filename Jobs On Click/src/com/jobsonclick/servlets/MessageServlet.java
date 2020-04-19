package com.jobsonclick.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobsonclick.dao.CandidateDao;
import com.jobsonclick.dao.CompanyDao;
import com.jobsonclick.dao.MessageDao;
import com.jobsonclick.models.Candidate;
import com.jobsonclick.models.Company;
import com.jobsonclick.models.Message;

/**
 * Servlet implementation class Message
 */
@WebServlet(urlPatterns= {"/NewMessage","/SendMessage","/DeleteMessage","/ViewMessage","/ViewMessages","/ReplyMessage"})
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageDao messageDao;
	private CompanyDao companyDao;
	private CandidateDao candidateDao;
	
    public MessageServlet() {
    	this.messageDao = new MessageDao();
    	this.companyDao = new CompanyDao();
    	this.candidateDao = new CandidateDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String role = request.getParameter("role");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewMessages")) {
			String type = request.getParameter("type");
			
			List<Message> messageList=null;
			int id=0;
			
			// get the role
			if(role.equalsIgnoreCase("company")) {
				id =(int)session.getAttribute("companyId");
			}
			else if(role.equalsIgnoreCase("candidate")) {
				id =(int)session.getAttribute("candidateId");
			}
					
			// get the type of list of messages (inbox, outbox)		
			if(type.equalsIgnoreCase("inbox")) {
				messageList= messageDao.getAllMessagesInbox(id,role);
			}
			else if(type.equalsIgnoreCase("outbox")) {
				messageList= messageDao.getAllMessagesOutbox(id,role);
			}
			
			request.setAttribute("messageList", messageList);
			request.getRequestDispatcher(role+"viewmessages.jsp").forward(request, response);
		}
		
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewMessage")) {
			
			int messageId = Integer.parseInt(request.getParameter("messageId"));
			Message message = messageDao.getMessage(messageId);
			if(request.getParameter("type").equalsIgnoreCase("inbox")) {
				messageDao.readMessage(messageId);
			}
			
			request.setAttribute("message", message);
			//request.setAttribute("type", request.getParameter("type"));
			request.getRequestDispatcher(role+"viewmessage.jsp").forward(request, response);
		}
		
		// New message
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/NewMessage")) {
			System.out.println("In New message..... and role is "+role);
			int id;
			String messageFrom=null;
			if(role.equalsIgnoreCase("company")) {
				id =(int)session.getAttribute("companyId");
				Company company = companyDao.getCompany(id);
				messageFrom = company.getCompanyEmail();
			}
			else if(role.equalsIgnoreCase("candidate")) {
				id =(int)session.getAttribute("candidateId");
				Candidate candidate = candidateDao.getCandidate(id);
				messageFrom = candidate.getCandidateEmail();
			}
			
			String messageTo = request.getAttribute("messageTo")!=null?(String)request.getAttribute("messageTo"):"";
			String subject = request.getAttribute("subject")!=null?(String)request.getAttribute("subject"):"";
			
			if(request.getParameter("messageTo")!=null) {
				messageTo = request.getParameter("messageTo");
			}
			if(request.getParameter("subject")!=null) {
				subject = request.getParameter("subject");
			}
			
			request.setAttribute("messageFrom", messageFrom);
			request.setAttribute("messageTo", messageTo);
			request.setAttribute("subject", subject);

			request.getRequestDispatcher(role+"newmessage.jsp").forward(request, response);
		}
		
		
		// Reply message
				else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ReplyMessage")) {
					
					int id;
					String messageFrom=null;
					
					Message message = messageDao.getMessage(Integer.parseInt(request.getParameter("messageId")));
					
					if(role.equalsIgnoreCase("company")) {
						id =(int)session.getAttribute("companyId");
						Company company = companyDao.getCompany(id);
						messageFrom = company.getCompanyEmail();
					}
					else if(role.equalsIgnoreCase("candidate")) {
						id =(int)session.getAttribute("candidateId");
						Candidate candidate = candidateDao.getCandidate(id);
						messageFrom = candidate.getCandidateEmail();
					}
					
					String messageTo = message.getMessageFrom();
					String subject= message.getSubject().startsWith("Re:") ? message.getSubject():"Re: "+message.getSubject();
					
					request.setAttribute("messageFrom", messageFrom);
					request.setAttribute("messageTo", messageTo);
					request.setAttribute("subject", subject);

					request.getRequestDispatcher(role+"newmessage.jsp").forward(request, response);
				}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String role = request.getParameter("role");
		
		// Delete Message
		if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/DeleteMessage")) {
			boolean isNotError = messageDao.deleteMessage(Integer.parseInt(request.getParameter("messageId")));
					
			if(!isNotError) {
				request.setAttribute("error", "Error Occurred, while deleting Message!");		
			}

			request.getRequestDispatcher("/ViewMessages").forward(request, response);
		}
		
		// Send Message
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/SendMessage")) {

			Message message = new Message(
								request.getParameter("messageFrom"),
								request.getParameter("messageTo"),
								request.getParameter("subject"),
								request.getParameter("body"),
								new java.sql.Date(new Date().getTime()),
								true,
								false);
			boolean isNotError = messageDao.sendMessage(message);
			String type= request.getParameter("type");
			if(isNotError) {
				request.setAttribute("message", "Message sent successfully!");												
			}
			else {
				request.setAttribute("message", "Message sending failed!");
			}
			
			request.getRequestDispatcher("/ViewMessages?type="+type).forward(request, response);
		}
		
		
		// Reply Message
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ReplyMessage")) {

			Message message = new Message(
								request.getParameter("messageFrom"),
								request.getParameter("messageTo"),
								"Re: "+request.getParameter("subject"),
								request.getParameter("body"),
								new java.sql.Date(new Date().getTime()),
								true,
								false);
			boolean isNotError = messageDao.sendMessage(message);
			
			if(isNotError) {
				request.setAttribute("message", "Message sent successfully!");												
			}
			else {
				request.setAttribute("message", "Message sending failed!");
			}
			
			request.getRequestDispatcher("/ViewMessages?type=inbox").forward(request, response);
		}
		
		
		// ***************************************Get calls **********************************************************
		
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewMessages")) {			
			doGet(request,response);
		}
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewMessage")) {			
			doGet(request,response);
		}
		
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/testMessage")) {
			System.out.println("lets get name in message as parameter---");
			System.out.println("Name: "+request.getParameter("name"));
			System.out.println("Id: "+request.getParameter("id"));
			System.out.println("JobId: "+request.getParameter("jobId"));
		}
	}

}
