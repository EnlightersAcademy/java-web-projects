package com.jobsonclick.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jobsonclick.models.Candidate;
import com.jobsonclick.models.Company;
import com.jobsonclick.utils.HibernateUtils;

public class CandidateDao {

	public boolean saveCandidate(Candidate candidate) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {
			// start a transaction
			session.beginTransaction();
			// save the student object
			session.saveOrUpdate(candidate);
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

	public boolean candidateChangePassword(int candidateId, String newpassword, String oldpassword) {
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {
			// start a transaction
			session.beginTransaction();
			// save the student object
			Query query = session.createQuery("Update Candidate set candidatePassword=:newpassword where candidateId = :candidateId and candidatePassword=:oldpassword");
			 query.setParameter("newpassword", newpassword);
			 query.setParameter("oldpassword", oldpassword);
			 query.setParameter("candidateId", candidateId);
			 
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

	public boolean deleteCandidate(int candidateId) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			// start a transaction
			session.beginTransaction();
			// get the company object
			Candidate candidate = session.get(Candidate.class, candidateId);

			if (candidate != null) {
				session.delete(candidate);
				System.out.println("Candidate deleted");
			} else {
				return false;
			}
			// commit transaction
			session.getTransaction().commit();
			session.close();

		} catch (Exception e) {
			session.getTransaction().rollback();

			e.printStackTrace();
			session.close();
			return false;
		}
		return true;
	}

	public Candidate getCandidate(int candidateId) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			// start a transaction
			session.beginTransaction();
			// get the company object
			Candidate candidate = session.get(Candidate.class, candidateId);

			// commit transaction
			session.getTransaction().commit();
			session.close();
			return candidate;

		} catch (Exception e) {

			session.getTransaction().rollback();

			e.printStackTrace();
			session.close();
			return null;
		}

	}

	public List<Candidate> getAllCandidates() {

		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			// start a transaction
			session.beginTransaction();
			// get the company object
			List<Candidate> candidateList = session.createQuery("from Candidate").getResultList();

			// commit transaction
			session.getTransaction().commit();
			session.close();
			return candidateList;

		} catch (Exception e) {

			session.getTransaction().rollback();

			e.printStackTrace();
			session.close();
			return null;
		}

	}

	// Search candidates based on skills
	public List<Candidate> searchCandidates(String skills) {
		
		List<String> skillList = Arrays.asList(skills.split(","));
		String querySql = "from Candidate where ";
		
		
		if (skills == null || skills.trim() == "") {
			return null;
		} else {
			querySql += "candidateSkills LIKE '%" + skillList.get(0).trim() + "%'";
		}
		
		
		for (int i = 1; i < skillList.size(); i++) {
			String skill = skillList.get(i).trim();

			querySql += " OR candidateSkills LIKE '%" + skill + "%'";
		}

		// run the query
		Session session = HibernateUtils.getSessionFactory().openSession();

		try {
			// start a transaction
			session.beginTransaction();
			// get the candidate list

			List<Candidate> candidateList = session.createQuery(querySql).getResultList();

			// commit transaction
			session.getTransaction().commit();
			session.close();
			return candidateList;

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			session.close();
			return null;
		}

	}
	
	public Candidate authorizeCandidate(String username , String password) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		String message="";
		  try {
	          // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("from Candidate where candidateEmail=:candidateEmail and candidatePassword = :candidatePassword");
			  query.setParameter("candidateEmail", username);
			  query.setParameter("candidatePassword", password);
			  
			  List<Candidate> candidateList = query.getResultList();
			  Candidate candidate = null;
			  if(candidateList!=null) {
				  candidate = (Candidate)query.getResultList().get(0);
			  }
			   
	           // commit transaction
	           session.getTransaction().commit();
	           session.close();
	           return candidate;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
	}
	
	
	// count of total Candidates
	public int totalCandidateCounts() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
			  // start a transaction
			  session.beginTransaction();
	          
			  Query query = session.createQuery("select count(*) from Candidate");
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
