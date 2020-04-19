package com.jobsonclick.servlets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.boot.model.relational.InitCommand;

import com.jobsonclick.dao.ApplicationDao;
import com.jobsonclick.dao.CandidateDao;
import com.jobsonclick.dao.CompanyDao;
import com.jobsonclick.dao.JobsDao;
import com.jobsonclick.dao.MessageDao;
import com.jobsonclick.models.Application;
import com.jobsonclick.models.Candidate;
import com.jobsonclick.models.Company;
import com.jobsonclick.models.Jobs;
import com.jobsonclick.models.Message;


@WebServlet(urlPatterns= {"/AddJob","/SaveUpdateJob","/DeactivateJob","/ViewJobs","/EditJob","/SearchCandidates",
		"/CompanyHome","/ViewCandidate","/UpdateCompanyProfile", "/RegisterCompany","/ViewApplications",
		"/ApproveApplication","/RejectApplication","/ApplicationSendMessage","/DownloadResume", "/TestImage","/TestImageToFile"})
@MultipartConfig
public class CompanyServlet extends HttpServlet{
	private CompanyDao companyDao;
	private JobsDao jobsDao;
	private MessageDao messageDao;
	private CandidateDao candidateDao;
	private ApplicationDao applicationDao;
	
	public CompanyServlet() {
		this.companyDao = new CompanyDao();
		this.jobsDao = new JobsDao();
		this.messageDao = new MessageDao();
		this.candidateDao = new CandidateDao();
		this.applicationDao = new ApplicationDao();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int companyId = (int)session.getAttribute("companyId");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		if(session.getAttribute("companyId")==null) {
			request.getRequestDispatcher("Logout").forward(request, response);
		}
		*/
		if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/AddJob")) {
			request.getRequestDispatcher("companyaddjob.jsp").forward(request, response);
		}
		
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewJobs")) {
			System.out.println("In View Jobs!!!"+companyId);
			
			//int companyId = (int)session.getAttribute("companyId");
			List<Jobs> activeJobsList= jobsDao.getAllActiveJobs(companyId);
			List<Jobs> expiredJobsList= jobsDao.getAllExpiredJobs(companyId);
			request.setAttribute("activeJobsList", activeJobsList);
			
			request.setAttribute("expiredJobsList", expiredJobsList);
			request.getRequestDispatcher("companyviewopenings.jsp").forward(request, response);
		}
		
		/*
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewJob")) {
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			Jobs job= jobsDao.getJob(jobId);
			request.setAttribute("job", job);
					
			request.getRequestDispatcher("viewjob.jsp").forward(request, response);
		}
		*/
		
		// Edit Job Opening page
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/EditJob")) {
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			Jobs job= jobsDao.getJob(jobId);
			request.setAttribute("job", job);		
			System.out.println("In EditJob Servlet...");
			System.out.println("type---"+request.getParameter("type"));
			request.getRequestDispatcher("editjob.jsp").forward(request, response);
		}
		
		// Company Home Page
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/CompanyHome")) {
			System.out.println("in company home");
			//int companyId = (int)session.getAttribute("companyId");
			Company company = companyDao.getCompany(companyId);
			int applicationCount = applicationDao.totalJobApplicationCount(companyId);
			int candidateCount = candidateDao.totalCandidateCounts();
			int jobCount = jobsDao.totalCompanyJobCounts(companyId);
			
			
			session.setAttribute("company", company);			
			request.setAttribute("applicationCount", applicationCount);
			request.setAttribute("candidateCount", candidateCount);
			request.setAttribute("jobCount", jobCount);
			
			request.getRequestDispatcher("companyhomepage.jsp").forward(request, response);
		}
		
		// View Candidate
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewCandidate")) {
			int candidateId = Integer.parseInt(request.getParameter("candidateId"));
			
			Candidate candidate = candidateDao.getCandidate(candidateId);
			request.setAttribute("candidate", candidate);
			request.getRequestDispatcher("viewcandidate.jsp").forward(request, response);
		}
		
		//View Applications
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewApplications")) {
			List<Jobs> jobsList= jobsDao.getAllActiveJobs(companyId);

			if(jobsList!=null) {
			for(int i = 0; i< jobsList.size();i++) {
				List<Application> applicationList = applicationDao.getApplicationsForJob(jobsList.get(i).getJobId());
				jobsList.get(i).setApplications(applicationList);
			}
			}
			request.setAttribute("jobsList", jobsList); // Job will have application lists and candidate details
			request.getRequestDispatcher("companyviewapplications.jsp").forward(request, response);
		}
		
		// Approve Application
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ApproveApplication")) {
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			int candidateId = Integer.parseInt(request.getParameter("candidateId"));
			applicationDao.approveApplication(jobId, candidateId);
			request.setAttribute("messageTo", request.getParameter("candidateEmail"));
			request.setAttribute("subject", "JobId: "+jobId+"- "+request.getParameter("jobTitle"));
			
			// New message servlet and then send to ApplicationSendMessage (button action), then come back to viewApplications page
			request.getRequestDispatcher("/NewMessage?role=company").forward(request, response);
		}
		
		// Reject Application
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/RejectApplication")) {
			int jobId = Integer.parseInt(request.getParameter("jobId"));
			int candidateId = Integer.parseInt(request.getParameter("candidateId"));
			applicationDao.rejectApplication(jobId, candidateId);
			request.getRequestDispatcher("/ViewApplications").forward(request, response);
		}
		
		// Download Resume
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/DownloadResume")) {
			
			ServletContext context = getServletContext();
			System.out.println("in downloadResume context-"+context);
			//Blob blob;
            InputStream inputStream=null;
			int candidateId= Integer.parseInt(request.getParameter("candidateId"));
			byte[] resumeArray = companyDao.downloadResume(candidateId);
			String fileName = request.getParameter("candidateId")+"resume.doc";
			
			// sets MIME type for the file download
            String mimeType = context.getMimeType(fileName);
            
         
            if (mimeType == null) {        
                mimeType = "application/octet-stream";
            }
 			
				//blob = new SerialBlob(resumeArray);
				inputStream = new ByteArrayInputStream(resumeArray);
				
			
            int fileLength = inputStream.available();
          
            // set content properties and header attributes for the response
            response.setContentType(mimeType);
            response.setContentLength(fileLength);
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", fileName);
            response.setHeader(headerKey, headerValue);
			
            // writes the file to the client
            OutputStream outStream = response.getOutputStream();
             
            byte[] buffer = new byte[300 * 1024];
            
            int bytesRead = -1;
            System.out.println("in downloadResume blob is -"+resumeArray);
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
             
            inputStream.close();
            outStream.close(); 
            
           // request.getRequestDispatcher("companyviewapplications.jsp").forward(request, response);
            /*
			String appPath = context.getRealPath("/");
			File file = new File(appPath+"images\\test\\logo.jpg");
			byte[] bFile = companyDao.testDownloadImage();
			
			OutputStream os = new FileOutputStream(file);
			
			os.write(bFile);
			
			System.out.println("File inserted!");
			os.close();
			*/
		}
		
		// Deactivate Job
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/DeactivateJob")) {
			System.out.println("in deactivate job servlet----");
			boolean isNotError = jobsDao.deactivateJob(Integer.parseInt(request.getParameter("jobId")));
			
			if(!isNotError) {
				request.setAttribute("message", "Error Occurred, while DeActivating Job!");		
			}
			
			request.getRequestDispatcher("/ViewJobs").forward(request, response);
		}
		
		/*
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewMessages")) {
			int companyId = (int)session.getAttribute("companyId");
			String type = request.getParameter("type");
			List<Message> messageList=null;
			
			if(type.equalsIgnoreCase("inbox")) {
				messageList= messageDao.getAllMessagesInbox(companyId,"company");
			}
			else if(type.equalsIgnoreCase("outbox")) {
				messageList= messageDao.getAllMessagesOutbox(companyId,"company");
			}
			
			request.setAttribute("messageList", messageList);
			request.getRequestDispatcher("viewmessages.jsp").forward(request, response);
		}
		
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewMessage")) {
			int messageId = Integer.parseInt(request.getParameter("messageId"));
			Message message = messageDao.getMessage(messageId);
			request.setAttribute("message", message);	
			request.getRequestDispatcher("viewmessage.jsp").forward(request, response);
		}
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/NewMessage")) {
			int companyId = (int)session.getAttribute("companyId");
			Company company = companyDao.getCompany(companyId);
			request.setAttribute("companyEmail", company.getCompanyEmail());
			request.getRequestDispatcher("sendmessage.jsp").forward(request, response);
		}
		*/
		
	}

	// ----------------------------------------------------------------------------------------------------------------------------
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		
		// Save update Job
		if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/SaveUpdateJob")) {
			System.out.println("saving!!!");
			
			/*
			Date reqDate = new Date();
			String finalDateString=null;
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date finalDate=null;
			// convert incoming String dateOfPosting to Date type
			try {
				finalDateString = format.format(reqDate);
				finalDate = format.parse(finalDateString);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			*/
			int companyId = (int)session.getAttribute("companyId");
			
			Jobs obj = new Jobs(
					request.getParameter("jobTitle"),
					request.getParameter("jobDescription"),
					request.getParameter("salary"),
					request.getParameter("experienceRequired"),
					request.getParameter("jobSkills"),
					new java.sql.Date(new Date().getTime()),
					false
					);
			
			// set jobId if exists
			if(request.getParameter("jobId")!=null) {
				obj.setJobId(Integer.parseInt(request.getParameter("jobId")));
			}
			

			boolean isNotError = jobsDao.saveJob(obj, companyId);
			
			if(isNotError) {
				request.setAttribute("message", "Job saved successfully!");												
			}
			else {
				request.setAttribute("message", "Error Occurred, while saving Job Opening!");
			}
			
			if(request.getParameter("page").equalsIgnoreCase("add"))
				request.getRequestDispatcher("companyaddjob.jsp").forward(request, response);
			else if(request.getParameter("page").equalsIgnoreCase("edit")) {
				// request.setAttribute("companyId",);				
				request.getRequestDispatcher("/EditJob?type=active").forward(request, response);
			}
		}
		
	
		
		// Search Candidate
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/SearchCandidates")) {
			List<Candidate> candidateList = candidateDao.searchCandidates(request.getParameter("skills"));
			
			request.setAttribute("candidateList", candidateList);
			request.getRequestDispatcher("companysearchcandidates.jsp?searched=true").forward(request, response);
		}
		
		
		// RegisterCompany
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/RegisterCompany")) {
			
			String email = request.getParameter("companyEmail");
			if(companyDao.checkEmailExists(email))
			{
				request.setAttribute("message", "Sorry, Email is already registered!");
				request.getRequestDispatcher("companyregistration.jsp").forward(request, response);
				return;
			}
			
			//******** Get the image ************
			Part filePart = request.getPart("logo");
			int docLength = (int)filePart.getSize();
			InputStream input = filePart.getInputStream();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[docLength * 1024];
			for (int length = 0; (length = input.read(buffer)) > 0;) output.write(buffer, 0, length);
			// ************ Set as output.toByteArray()***************
			
			
			Company company = new Company(
					request.getParameter("companyName"), 
					request.getParameter("companyDescription"),
					request.getParameter("companyEmail"),
					request.getParameter("companyPassword"), 
					output.toByteArray(),
					null,
					"new");
			
			boolean isNotError = companyDao.saveCompany(company);
			
			if(isNotError) {
				request.setAttribute("message", "Request sent to Admin for Registration. You will be able to login once approved!");
			}
			
			request.getRequestDispatcher("companylogin.jsp").forward(request, response);
		}
		
		// Company Approve Send Application Message
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ApplicationSendMessage")) {
			Message message = new Message(
					request.getParameter("messageFrom"),
					request.getParameter("messageTo"),
					request.getParameter("subject"),
					request.getParameter("body"),
					new java.sql.Date(new Date().getTime()),
					true,
					false);
			boolean isNotError = messageDao.sendMessage(message);

			if(isNotError) {
				request.setAttribute("message", "Message sent successfully!");												
			}
			else {
				request.setAttribute("message", "message sending failed!");
			}

			request.getRequestDispatcher("/ViewApplications").forward(request, response);
		}
		
		// UpdateCompanyProfile
		else if(request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/UpdateCompanyProfile")) {
			// company object is already stored in session
			
			Company sessioncompany = (Company) session.getAttribute("company");
			byte[] logo = sessioncompany.getLogo();
			
			Company company = new Company();
			company.setCompanyDescription(request.getParameter("companyDescription"));
			company.setCompanyName(request.getParameter("companyName"));
			
			//******** Get the image ************
			System.out.println("in update company...."+request.getPart("logo").getSize());
			if(request.getPart("logo").getSize()!=0) {
				Part filePart = request.getPart("logo");
				int docLength = (int)filePart.getSize();
				InputStream input = filePart.getInputStream();
			
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				byte[] buffer = new byte[docLength * 1024];
				for (int length = 0; (length = input.read(buffer)) > 0;) output.write(buffer, 0, length);
			// ************ Set as output.toByteArray()***************
				logo = output.toByteArray();
			}
			company.setLogo(logo);
			
			boolean isNotError = companyDao.updateCompany(company, (int)session.getAttribute("companyId"));
			
			String message = isNotError?"Profile Updated successfully":"Error while updating profile";
			request.setAttribute("message", message);
			
			if(isNotError) {
				session.setAttribute("company", companyDao.getCompany((int)session.getAttribute("companyId")));
			}
			request.getRequestDispatcher("companyupdateprofile.jsp").forward(request, response);
		}
		
		
		// ***************************************Get calls **********************************************************
		
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewJobs")) {			
			doGet(request,response);
		}
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/EditJob")) {			
			doGet(request,response);
		}
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/ViewApplications")) {			
			doGet(request,response);
		}
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/CompanyHome")) {			
			doGet(request,response);
		}
		
		else if (request.getRequestURI().equalsIgnoreCase("/Jobs_On_Click/TestImage")) {			
			System.out.println("Company name is: "+request.getParameter("companyName"));
			
			//InputStream filestream = null;
			Part filePart = request.getPart("resume");
			InputStream input = filePart.getInputStream();
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[221184];
			for (int length = 0; (length = input.read(buffer)) > 0;) output.write(buffer, 0, length);
			companyDao.testUploadImage(buffer);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		

		
		
		
	}

}
