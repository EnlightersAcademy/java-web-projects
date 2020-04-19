package com.jobsonclick.dao;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jobsonclick.models.Company;
import com.jobsonclick.utils.HibernateUtils;

public class CompanyDao {
	
	
	public boolean saveCompany(Company company) {
		
		System.out.println("Inside Save Company");
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			  session.beginTransaction();
	            // save the student object
	            session.saveOrUpdate(company);
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
	
	public boolean companyChangePassword(int companyId, String newpassword, String oldpassword) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {
			// start a transaction
			session.beginTransaction();
			// save the student object
			 Query query = session.createQuery("Update Company set companyPassword=:newpassword where companyId = :companyId and companyPassword=:oldpassword");
			 query.setParameter("newpassword", newpassword);
			 query.setParameter("oldpassword", oldpassword);
			 query.setParameter("companyId", companyId);
			 
			 boolean status = query.executeUpdate()==0?false:true;
			// commit transaction
			session.getTransaction().commit();
			session.close();
			return status;

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			session.close();
			return false;
		}

	}
	
	public boolean updateCompany(Company company, int companyId) {
		
		System.out.println("Inside Save Company");
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query=null;
		  try {
	            // start a transaction
			  session.beginTransaction();
			  
			  query = session.createQuery("update Company set companyDescription=:companyDescription , companyName=:companyName, logo=:logo where companyId=:companyId");
			  
			  query.setParameter("companyDescription", company.getCompanyDescription());
			  query.setParameter("companyName",company.getCompanyName());
			  query.setParameter("logo",company.getLogo());
			  query.setParameter("companyId", companyId);
			  
	            // update the company object
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
	
	public boolean deleteCompany(int companyId) {
		
			System.out.println("in CompanyDAODelete");
			Session session = HibernateUtils.getSessionFactory().openSession();
			boolean flag;
		  try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	            System.out.println("Finding company with Id- "+companyId);
	            Company company = session.get(Company.class, companyId);
	            
	            if(company!=null) {
	            	session.delete(company);
	            	System.out.println("Company deleted");
	            	flag = true;	            	
	            }else	            	 
	            	flag= false;
	            
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	        } catch (Exception e) {	           
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return false;
	        }
		return flag;
	}
	
	public Company getCompany(int companyId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			  session.beginTransaction();
			 
	            // get the company object
	            Company company = session.get(Company.class, companyId);

	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return company;
	            
	        } catch (Exception e) {
	        	session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
	public List<Company> getAllCompanies() {
			System.out.println("get all companies");
			Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
			  session.beginTransaction();
	            // get the company object
	           List<Company> companyList= session.createQuery("from Company where status='approved'").getResultList();
	           System.out.println("get all companies- "+companyList.size());
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return companyList;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
	public void deactivateCompany(int companyId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("update Company set status=:status where companyId=:companyId");
			  query.setParameter("status", "deactivated");
			  query.setParameter("companyId", companyId);
			  query.executeUpdate();
	           
	           // commit transaction
	           session.getTransaction().commit();
	           session.close();
	     
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	        
	        }
	}
	
	public void approveRejectCompany(int companyId, String status) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("update Company set status=:status where companyId=:companyId");
			  query.setParameter("status", status);
			  query.setParameter("companyId", companyId);
			  query.executeUpdate();
	           
	           // commit transaction
	           session.getTransaction().commit();
	           session.close();
	     
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	        
	        }
	}
	
	public List<Company> companyApprovals() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("from Company where status=:status");
			  query.setParameter("status", "new");
			  List<Company> companyList = query.getResultList();
	           
	           // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return companyList;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
	}
	
	public Company authorizeCompany(String username , String password) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		String message="";
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("from Company where companyEmail=:companyEmail and companyPassword =:companyPassword");
			  query.setParameter("companyEmail", username);
			  query.setParameter("companyPassword", password);
			  
			  List<Company> companyList = query.getResultList();
			  Company company = null;
			  if(companyList!=null) {
				  company = (Company)query.getResultList().get(0);
			  }
			  
	          
			  /*
			  for(Company company : companyList) {
				  if(company.getStatus().equalsIgnoreCase("approved"))
					  message = "Approved";
				  else if(company.getStatus().equalsIgnoreCase("rejected"))
					  message = "Your registration has been rejected! Please contact Admin";
				  else if(company.getStatus().equalsIgnoreCase("rejected"))
					  message = " Your Account has been Deactivated! Please contact Admin";
			  }
			  */ 
	           // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return company;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
	}
	
	// count of company registration requests
	public int companyRegistrationRequests() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("select count(*) from Company where status=:status");
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
	
	// count of total companies
		public int totalCompanyCounts() {
			Session session = HibernateUtils.getSessionFactory().openSession();
			  try {
		          // start a transaction
				  session.beginTransaction();
		          
				  Query query = session.createQuery("select count(*) from Company where status=:status");
				  query.setParameter("status", "approved");
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
	

	
	// ************TEST IMAGE ADD RETRIEVE************
	
	
	public void testUploadImage(byte[] resume) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("update Candidate set resume=:resume where candidateId=1");
			  query.setParameter("resume", resume);
			  query.executeUpdate();
	           
	           // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	           
	        }
		
	}
	
	public byte[] downloadResume(int candidateId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("select resume from Candidate where candidateId=:candidateId");
			  query.setParameter("candidateId", candidateId);
			  byte[] resume = (byte[])query.getResultList().get(0);
	           // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return resume;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	           return null;
	        }
		
	}
	
	public byte[] testDownloadImage() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("select logo from Company where companyId=1");
			  byte[] image = (byte[])query.getResultList().get(0);
	           // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return image;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	           return null;
	        }
		
	}

}
