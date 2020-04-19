package com.jobsonclick.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.jobsonclick.models.Application;
import com.jobsonclick.models.Company;
import com.jobsonclick.models.Jobs;
import com.jobsonclick.utils.HibernateUtils;

public class ApplicationDao {

	public List<Application> getApplicationsForJob(int jobId) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			  session.beginTransaction();
	            
			  	// get applications for jobId
			  Query query = session.createQuery("from Application where jobId=:jobId and status=:status");
			  query.setParameter("jobId", jobId);
			  query.setParameter("status", "new");
			  List<Application> applicationsList = query.getResultList();
			  
			  for(int i =0;i<applicationsList.size();i++) {
				  
				  int candidateId = applicationsList.get(i).getCandidateId();
				  CandidateDao dao = new CandidateDao();
				  applicationsList.get(i).setCandidate(dao.getCandidate(candidateId));
			  }
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return applicationsList;
	            
	        } catch (Exception e) {
	           
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
public List<Application> getApplicationsForCandidate(int candidateId) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			  session.beginTransaction();
	            
			  	// get applications for jobId
			  Query query = session.createQuery("from Application where candidateId=:candidateId");
			  query.setParameter("candidateId", candidateId);
			  
			  List<Application> applicationsList = query.getResultList();
			  for(int i =0;i<applicationsList.size();i++) {
				  int jobId = applicationsList.get(i).getJobId();
				  JobsDao dao = new JobsDao();
				  applicationsList.get(i).setJob(dao.getJob(jobId));
				  
			  }
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return applicationsList;
	            
	        } catch (Exception e) {
	           
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
	public boolean applicationAlreadyApplied(int jobId, int candidateId) {
		System.out.println("-------in applicationAlreadyApplied-------");
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			  session.beginTransaction();
	            
			  	// get applications for jobId
			  Query query = session.createQuery("select count(*) from Application where jobId=:jobId and candidateId=:candidateId");
			  query.setParameter("jobId", jobId);
			  query.setParameter("candidateId", candidateId);
			  long count = (long)query.getResultList().get(0);
			  System.out.println("count is ----"+count);
			 // Application application = (Application)query.getResultList().get(0);
			  //System.out.println("application----"+application.getJobId());
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return count==0?false:true;
	            
	        } catch (Exception e) {
	           
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return false;
	        }
		
	}
	
	public boolean applyJobApplication(Application application) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			    session.beginTransaction();
	            
			   // add new application
			   session.saveOrUpdate(application);
			  
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
	
	public boolean approveApplication(int jobId, int candidateId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			  session.beginTransaction();
	            
			  	// get applications for jobId
			  Query query = session.createQuery("update Application set status=:status where jobId=:jobId and candidateId=:candidateId");
			  query.setParameter("status", "approved");
			  query.setParameter("jobId", jobId);
			  query.setParameter("candidateId", candidateId);
			 
			  query.executeUpdate();
			  
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
	
	public boolean rejectApplication(int jobId, int candidateId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			  session.beginTransaction();
	            
			  	// get applications for jobId
			  Query query = session.createQuery("update Application set status=:status where jobId=:jobId and candidateId=:candidateId");
			  query.setParameter("status", "rejected");
			  query.setParameter("jobId", jobId);
			  query.setParameter("candidateId", candidateId);
			 
			  query.executeUpdate();
			  
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
	
	
	// count of total job applications
	public int totalJobApplicationCount(int companyId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
			  // start a transaction
			  session.beginTransaction();
	          
			  List<Jobs> jobs = session.get(Company.class, companyId).getOpenings();
			  int count = 0;
			  for(Jobs job : jobs) {
				  Query query = session.createQuery("select count(*) from Application where jobId=:jobId and status=:status");
				  query.setParameter("jobId", job.getJobId());
				  query.setParameter("status", "new");
				  
				  count+=(int)(long)query.getResultList().get(0);
				  
			  }
			  
			           
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

	
	// count of total job applications
	public int totalJobApplicationApplied(int candidateId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
			  // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("select count(*) from Application where candidateId=:candidateId and status=:status");
			  query.setParameter("candidateId", candidateId);
			  query.setParameter("status", "new");
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
	
}
