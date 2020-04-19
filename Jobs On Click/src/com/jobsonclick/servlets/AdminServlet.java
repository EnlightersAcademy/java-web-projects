package com.jobsonclick.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobsonclick.dao.CandidateDao;
import com.jobsonclick.dao.CompanyDao;
import com.jobsonclick.dao.JobsDao;
import com.jobsonclick.models.Candidate;
import com.jobsonclick.models.Company;
import com.jobsonclick.models.Jobs;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(urlPatterns = {"/ViewAdminCompanies" , "/ViewAdminCompany" , "/ViewAdminCandidates","/AdminHome" ,
			"/ApproveCompany","/RejectCompany" , "/ViewApprovals" , "/DeactivateCompany" , "/ViewAdminJobs"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CompanyDao companyDao;
	private CandidateDao candidateDao;
	private JobsDao jobsDao;
	
    public AdminServlet() {
    	this.companyDao = new CompanyDao();
    	this.candidateDao = new CandidateDao();
    	this.jobsDao = new JobsDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// ViewCompanies Page
		if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewAdminCompanies")) {			

			List<Company> companyList= companyDao.getAllCompanies();
			request.setAttribute("companyList", companyList);

			request.getRequestDispatcher("adminviewcompanies.jsp").forward(request, response);
		}
		
		// ViewCompany Page
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewAdminCompany")) {			
			
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			Company company= companyDao.getCompany(companyId);
			request.setAttribute("company", company);
					
			request.getRequestDispatcher("adminviewcompany.jsp").forward(request, response);
		}
		
		// DeactivateCompany Page
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/DeactivateCompany")) {			
			
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			companyDao.deactivateCompany(companyId);
					
			request.getRequestDispatcher("/ViewAdminCompany").forward(request, response);
		}
		
		//View Approvals
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewApprovals")) {			
			List<Company> companies = companyDao.companyApprovals();
			if(companies==null) {
				request.setAttribute("message", "No Company Approval Requests");
			}
			request.setAttribute("companyList", companies);
			request.getRequestDispatcher("admincompanyapplications.jsp").forward(request, response);
		}

		// Approve Company
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ApproveCompany")) {			
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			companyDao.approveRejectCompany(companyId, "approved");
			request.getRequestDispatcher("/ViewApprovals").forward(request, response);
		}

		// Reject Company
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/RejectCompany")) {			
			int companyId = Integer.parseInt(request.getParameter("companyId"));
			companyDao.approveRejectCompany(companyId, "rejected");
			request.getRequestDispatcher("/ViewApprovals").forward(request, response);
		}
		
		//View Candidates
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewAdminCandidates")) {			
			
			List<Candidate> candidateList = candidateDao.getAllCandidates();
			request.setAttribute("candidateList", candidateList);
			request.getRequestDispatcher("adminviewcandidates.jsp").forward(request, response);
		}
		
		//Admin Home
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/AdminHome")) {			
			
			int jobCount = jobsDao.totalJobCounts();
			int companyCount = companyDao.totalCompanyCounts();
			int applicationCount = companyDao.companyRegistrationRequests();
			
			request.setAttribute("jobCount", jobCount);
			request.setAttribute("companyCount", companyCount);
			request.setAttribute("applicationCount", applicationCount);
			
			request.getRequestDispatcher("adminhomepage.jsp").forward(request, response);
		}
		
		//View Jobs
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewAdminJobs")) {			
			
			List<Jobs> jobList = jobsDao.getAllJobsAdmin();
			request.setAttribute("jobList", jobList);
			request.getRequestDispatcher("adminviewjobs.jsp").forward(request, response);
		}
		
		
	}

// ----------------------------------------------------------------------------------------------------------------------------
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);				
	}

}
