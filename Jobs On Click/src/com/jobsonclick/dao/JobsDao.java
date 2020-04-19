package com.jobsonclick.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jobsonclick.models.Company;
import com.jobsonclick.models.Jobs;
import com.jobsonclick.utils.HibernateUtils;

public class JobsDao {
	
	public boolean saveJob(Jobs job, int companyId) {
	//	Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
	           session.beginTransaction();
	            // get the Company and add job to the company object
	            Company company = session.get(Company.class, companyId);
	            company.add(job);
	            
	            // save the job object
	            session.saveOrUpdate(job);
	            
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return true;
	            
	        } catch (Exception e) {	            
	            session.getTransaction().rollback();	          
	            e.printStackTrace();
	            session.close();
	            return false;
	        }
		
	}
	
	public boolean deactivateJob(int jobId) {
		//Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		boolean flag = false;
		  try{
	            // start a transaction
	            session.beginTransaction();
	            System.out.println("in deactivate job method----");
	            // get the company object
	            Jobs job = session.get(Jobs.class, jobId);	            
	           
	            if(job!=null) {
	            	job.setExpired(true);
	            	session.update(job);
	            	System.out.println("Job deactivated");
	            	
	            	Query query = session.createQuery("update Application set status=:status where jobId=:jobId");
	  			  	query.setParameter("status", "rejected");
	  			  	query.setParameter("jobId", jobId);
	  			 
	  			  	flag = query.executeUpdate()==0?false:true;
	            	
	            	
	            }
	            session.getTransaction().commit();
	            session.close();
	            return flag;
	        
		  } catch (Exception e) {	            
	        	session.getTransaction().rollback();	           
	            e.printStackTrace();
	            session.close();
	            return false;
	        }
		
	}
	
	public Jobs getJob(int jobId) {
		//Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try{
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	            Jobs job = session.get(Jobs.class, jobId);
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return job;
	            
	        } catch (Exception e) {	           
	            session.getTransaction().rollback();            
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
	}
	
	public List<Jobs> getAllActiveJobs(int companyId) {
		//Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object and corresponding openings
	           
	            List<Jobs> tempJobList = session.get(Company.class, companyId).getOpenings();
	            List<Jobs> jobList = new ArrayList<Jobs>();
	            System.out.println("In getActive jobs----"+tempJobList.size());
	            
	            if(tempJobList!=null) {
	            for(Jobs job : tempJobList) {
	            	if(!job.isExpired()) {
	            		jobList.add(job);
	            	}
	            }
	            }
	            if(jobList.size()==0) {
	            	jobList = null;
	            }
	            // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return jobList;
	            
	        } catch (Exception e) {	           
	            session.getTransaction().rollback();	            
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
	public List<Jobs> getAllExpiredJobs(int companyId) {
		//Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
	            session.beginTransaction();
	            
	            
	            List<Jobs> tempJobList = session.get(Company.class, companyId).getOpenings();
	            List<Jobs> jobList = new ArrayList<Jobs>();
	            
	            for(Jobs job : tempJobList) {
	            	if(job.isExpired()) {
	            		jobList.add(job);
	            	}
	            }
	            
	            if(jobList.size()==0) {
	            	jobList = null;
	            }
	            // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return jobList;
	            
	        } catch (Exception e) {	           
	            session.getTransaction().rollback();	            
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
	public List<Jobs> getAllJobsAdmin() {
		//Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	           List<Jobs> jobList= session.createQuery("from Jobs where expired=false").getResultList();
	            // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return jobList;
	            
	        } catch (Exception e) {	           
	            session.getTransaction().rollback();	            
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}

	// Search jobs for candidates
	public List<Jobs> searchJobs(String skills) {
		//Transaction transaction = null;
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		List<String> skillList = Arrays.asList(skills.split(","));
		String sqlQuery = "from Jobs where ";
		
		if(skills==null || skills.equals("")) {
			return null;
		}
		else {
			sqlQuery += "jobSkills LIKE '%" +skillList.get(0).trim()+ "%'";
		}
		
		for (int i = 1; i < skillList.size(); i++) {
			String skill = skillList.get(i).trim();

			sqlQuery += " OR jobSkills LIKE '%" + skill + "%'";
		}
		
		try {
	            // start a transaction
	           session.beginTransaction();
	            // get searched Jobs based on jobSkills          
	           List<Jobs> jobList= session.createQuery(sqlQuery+" and expired=false").getResultList();
	          // List<Jobs> jobList= session.createQuery("from Jobs where jobSkills LIKE '%java%' and expired=false").getResultList();
	            // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return jobList;
	            
	      } catch (Exception e) {	           
	            session.getTransaction().rollback();	            
	            e.printStackTrace();
	            session.close();
	            return null;
	      }
		
	}
	
	
	// count of total jobs
	public int totalJobCounts() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
			  // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("select count(*) from Jobs where expired=:expired");
			  query.setParameter("expired", false);
			  int count = (int)(long)query.getResultList().get(0);
			           
			  // commit transaction
	          session.getTransaction().commit();
	           session.close();
	           return count;
			            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return 0;
	        }
		}
	
	
	// count of total jobs for a company
	public int totalCompanyJobCounts(int companyId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
			  // start a transaction
			  session.beginTransaction();
	          int count =0;
			  List<Jobs> jobsList = ((Company)session.get(Company.class, companyId)).getOpenings();
			  for(Jobs job:jobsList) {
				  if(!job.isExpired()) {
					  count++;
				  }
			  }
			  
			  //int count = company.getOpenings().size();
			          
			  // commit transaction
	          session.getTransaction().commit();
	           session.close();
	           return count;
			            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return 0;
	        }
		}

	
}





