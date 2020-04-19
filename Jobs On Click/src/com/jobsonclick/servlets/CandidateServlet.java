package com.jobsonclick.servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jobsonclick.dao.ApplicationDao;
import com.jobsonclick.dao.CandidateDao;
import com.jobsonclick.dao.CompanyDao;
import com.jobsonclick.dao.JobsDao;
import com.jobsonclick.dao.MessageDao;
import com.jobsonclick.models.Application;
import com.jobsonclick.models.Candidate;
import com.jobsonclick.models.Jobs;


@WebServlet(urlPatterns = {"/CandidateHome","/SearchJobs","/RegisterCandidate","/UpdateCandidateProfile","/CandidateViewJob",
						"/CandidateApplyJob","/CandidateApplicationHistory"
						})
@MultipartConfig
public class CandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private MessageDao messageDao;
	private CompanyDao companyDao;
	private CandidateDao candidateDao;
	private JobsDao jobsDao;
	private ApplicationDao applicationDao;

    public CandidateServlet() {
    	this.messageDao = new MessageDao();
    	this.companyDao = new CompanyDao();
    	this.candidateDao = new CandidateDao();
    	this.jobsDao = new JobsDao();
    	this.applicationDao = new ApplicationDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		int candidateId = (int)session.getAttribute("candidateId");
		//int candidateId=1;
		if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/CandidateHome")) {
			System.out.println("In CandidateHome");
			Candidate candidate = candidateDao.getCandidate(candidateId);
			session.setAttribute("candidate", candidate);
			
			int applicationCount = applicationDao.totalJobApplicationApplied(candidateId);
			int companyCount = companyDao.totalCompanyCounts();
			int jobCount = jobsDao.totalJobCounts();
			
			
			session.setAttribute("candidate", candidate);			
			request.setAttribute("applicationCount", applicationCount);
			request.setAttribute("companyCount", companyCount);
			request.setAttribute("jobCount", jobCount);

			request.getRequestDispatcher("candidatehomepage.jsp").forward(request, response);
		}
		
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/CandidateViewJob")) {
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			
			Jobs job = jobsDao.getJob(jobId);			
			boolean alreadyApplied = applicationDao.applicationAlreadyApplied(jobId, candidateId);
			
			request.setAttribute("job", job);			
			request.setAttribute("alreadyApplied", alreadyApplied);
			
			request.getRequestDispatcher("viewjob.jsp").forward(request, response);
		}
		
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/CandidateApplicationHistory")) {
			
			List<Application> applicationList = applicationDao.getApplicationsForCandidate(candidateId);
			
			request.setAttribute("applicationList", applicationList);
			
			request.getRequestDispatcher("candidateapplicationhistory.jsp").forward(request, response);
		}
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int candidateId=1;
		//int candidateId = (int)session.getAttribute("candidateId");
		
		if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/SearchJobs")) {
			List<Jobs> jobsList = jobsDao.searchJobs(request.getParameter("skills"));
			request.setAttribute("jobsList", jobsList);
			
			request.getRequestDispatcher("candidatesearchjobs.jsp?searched=true").forward(request, response);
		}
		
		// RegisterCandidate
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/RegisterCandidate")) {
			
			// Reading Profile picture
			
			//******** Get the image ************
			Part filePartProfile = request.getPart("profile");
			int docLength1 = (int)filePartProfile.getSize();
			InputStream inputProfile = filePartProfile.getInputStream();
			ByteArrayOutputStream profileOutput = new ByteArrayOutputStream();
			byte[] bufferProfile = new byte[docLength1 * 1024];
			for (int length = 0; (length = inputProfile.read(bufferProfile)) > 0;) profileOutput.write(bufferProfile, 0, length);
			// ************ Set as output.toByteArray()***************
			
			// Reading resume
			
			//******** Get the image ************
			Part filePartResume = request.getPart("resume");
			int docLength2 = (int)filePartResume.getSize();
			InputStream inputResume = filePartResume.getInputStream();
			ByteArrayOutputStream resumeOutput = new ByteArrayOutputStream();
			byte[] bufferResume = new byte[docLength2 * 1024];
			for (int length = 0; (length = inputResume.read(bufferResume)) > 0;) resumeOutput.write(bufferResume, 0, length);
			// ************ Set as output.toByteArray()***************
			
			Candidate candidate = new Candidate(
					request.getParameter("candidateEmail"), 
					request.getParameter("candidateName"), 
					request.getParameter("candidatePassword"), 
					request.getParameter("candidateSummary"), 
					request.getParameter("candidateExperience"), 
					request.getParameter("candidateSkills"), 
					request.getParameter("candidateContact"), 
					resumeOutput.toByteArray(),
					profileOutput.toByteArray()
					);
			
			boolean isNotError = candidateDao.saveCandidate(candidate);
			
		//*********** Save the profile to Project folder as well***************
			ServletContext context = getServletContext();
			String appPath = context.getRealPath("/");
			File file = new File(appPath+"images\\test\\candidate"+request.getParameter("candidateEmail")+"logo.jpg");
			byte[] bFile = candidate.getProfile();			
			OutputStream os = new FileOutputStream(file);
			os.write(bFile);
			System.out.println("File inserted!");
			os.close();
		//*******************************************************************
			
		//*********** Save the resume to Project folder as well***************
			
			
			File file2 = new File(appPath+"images\\test\\candidate"+request.getParameter("candidateEmail")+"resume.pdf");
			byte[] bFile2 = candidate.getResume();			
			OutputStream os2 = new FileOutputStream(file2);
			os2.write(bFile2);
			System.out.println("File inserted!");
			os2.close();
		//*******************************************************************
			
			if(isNotError) {
				request.setAttribute("message", "Candidate Created successfully");
			}
			request.getRequestDispatcher("candidatelogin.jsp").forward(request, response);
		}
		
		// EditCandidate
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/UpdateCandidateProfile")) {
			
			Candidate sessioncandidate = (Candidate) session.getAttribute("candidate");
			byte[] profile = sessioncandidate.getProfile();
			byte[] resume = sessioncandidate.getResume();
			
			// Reading Profile picture
			
			if(request.getPart("profile").getSize()!=0) {
			
			//******** Get the image ************
			Part filePartProfile = request.getPart("profile");
			int docLength1 = (int)filePartProfile.getSize();
			InputStream inputProfile = filePartProfile.getInputStream();
			ByteArrayOutputStream profileOutput = new ByteArrayOutputStream();
			byte[] bufferProfile = new byte[docLength1 * 1024];
			System.out.println("profile length:---------"+docLength1);
			for (int length = 0; (length = inputProfile.read(bufferProfile)) > 0;) profileOutput.write(bufferProfile, 0, length);
			// ************ Set as output.toByteArray()***************
			profile = profileOutput.toByteArray();
			}
			// Reading resume
			
			if(request.getPart("resume").getSize()!=0) {
			//******** Get the resume ************
			Part filePartResume = request.getPart("resume");
			int docLength2 = (int)filePartResume.getSize();
			System.out.println("resume length:---------"+docLength2);
			InputStream inputResume = filePartResume.getInputStream();
			ByteArrayOutputStream resumeOutput = new ByteArrayOutputStream();
			byte[] bufferResume = new byte[docLength2 * 1024];
			for (int length = 0; (length = inputResume.read(bufferResume)) > 0;) resumeOutput.write(bufferResume, 0, length);
			// ************ Set as output.toByteArray()***************
			resume = resumeOutput.toByteArray();
			}
			
			
			Candidate candidate = new Candidate(
					sessioncandidate.getCandidateEmail(), 
					sessioncandidate.getCandidateName(), 
					sessioncandidate.getCandidatePassword(), 
					request.getParameter("candidateSummary"), 
					request.getParameter("candidateExperience"), 
					request.getParameter("candidateSkills"), 
					request.getParameter("candidateContact"), 
					resume,
					profile
					);
			candidate.setCandidateId(candidateId);
			
			boolean isNotError = candidateDao.saveCandidate(candidate);
			
		//*********** Save the profile to Project folder as well***************
			ServletContext context = getServletContext();
			String appPath = context.getRealPath("/");
			File file = new File(appPath+"images\\test\\candidate"+request.getParameter("candidateEmail")+"logo.jpg");
			byte[] bFile = candidate.getProfile();			
			OutputStream os = new FileOutputStream(file);
			os.write(bFile);
			System.out.println("File inserted!");
			os.close();
		//*******************************************************************
			
		//*********** Save the resume to Project folder as well***************
			
			
			File file2 = new File(appPath+"images\\test\\candidate"+request.getParameter("candidateEmail")+"resume.pdf");
			byte[] bFile2 = candidate.getResume();			
			OutputStream os2 = new FileOutputStream(file2);
			os2.write(bFile2);
			System.out.println("File inserted!");
			os2.close();
		//*******************************************************************
			
			if(isNotError) {
				request.setAttribute("message", "Candidate Updated successfully");
				session.setAttribute("candidate", candidateDao.getCandidate(candidateId));
			}
			request.getRequestDispatcher("candidateupdateprofile.jsp").forward(request, response);
		}
		
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/CandidateApplyJob")) {
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			
			Application application = new Application(
					jobId,
					candidateId, 
					"new");
			boolean isNotError = applicationDao.applyJobApplication(application);
			
			if(isNotError) {
				request.setAttribute("message", "Job Applied successfully!");
			}
			request.getRequestDispatcher("/CandidateViewJob").forward(request, response);
		}
		
		
		
		// ***************************************Get calls **********************************************************
		
				else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/CandidateViewJob")) {			
					doGet(request,response);
				}
				else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/CandidateHome")) {			
					doGet(request,response);
				}
	}

}
