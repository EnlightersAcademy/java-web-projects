package com.jobsonclick.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jobsonclick.models.Candidate;
import com.jobsonclick.models.Company;
import com.jobsonclick.models.Message;
import com.jobsonclick.utils.HibernateUtils;

public class MessageDao {
	public boolean sendMessage(Message message) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try{
			  	System.out.println("***message is - "+message.toString());
			  	
			  	message.setMessageTo(message.getMessageTo().toLowerCase());
			  	message.setMessageFrom(message.getMessageFrom().toLowerCase());
	            // start a transaction
	            session.beginTransaction();
	            // save the student object
	            /*
	            String pattern = "yyyy-MM-dd";
	            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	            String mysqlDateString = formatter.format(message.getDate());
	            message.setDate(formatter.parse(mysqlDateString));
	            */
	            System.out.println("message is new---"+message.isStatus());
	            session.saveOrUpdate(message);
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
	
	public boolean deleteMessage(int messageId) {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		boolean flag;
		  try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	            Message message = session.get(Message.class, messageId);
	            //Query query;
	            if(message!=null) {
	            	message.setDeleted(true);
	            	session.update(message);
	            	System.out.println("Message deleted");
	            	flag = true;
	            }else {
	            	flag = false;
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
		return flag;
	}
	
	public Message getMessage(int messageId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		  try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	            Message message = session.get(Message.class, messageId);
	            Query  query= session.createQuery("update Message set status=:status where messageId=:messageId");
	            query.setParameter("status", false);
	            query.setParameter("messageId", messageId);
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return message;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();	            
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
	public List<Message> getAllMessagesInbox(int id, String role) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		String messageTo="";
		Query query;
		  try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	            if(role.equalsIgnoreCase("company")) {
	            	Company company = session.get(Company.class, id);
	            	messageTo = company.getCompanyEmail();
	            }
	            else if(role.equalsIgnoreCase("candidate")) {
	            	Candidate candidate = session.get(Candidate.class, id);
	            	messageTo = candidate.getCandidateEmail();
	            }
	           query= session.createQuery("from Message where messageTo=:messageTo order by date DESC");
	           query.setParameter("messageTo", messageTo);
	           List<Message> messageList= query.getResultList();
	           
	           
	           
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return messageList;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
	public List<Message> getAllMessagesOutbox(int id, String role) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		String messageFrom="";
		Query query;
		  try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	            if(role.equalsIgnoreCase("company")) {
	            	Company company = session.get(Company.class, id);
	            	messageFrom = company.getCompanyEmail().toLowerCase();
	            }
	            else if(role.equalsIgnoreCase("candidate")) {
	            	Candidate candidate = session.get(Candidate.class, id);
	            	messageFrom = candidate.getCandidateEmail().toLowerCase();
	            }
	           query= session.createQuery("from Message where messageFrom=:messageFrom order by date DESC");
	           query.setParameter("messageFrom", messageFrom);
	           List<Message> messageList= query.getResultList();
	  
	            // commit transaction
	            session.getTransaction().commit();
	            session.close();
	            return messageList;
	            
	        } catch (Exception e) {
	            session.getTransaction().rollback();
	            e.printStackTrace();
	            session.close();
	            return null;
	        }
		
	}
	
	public int unreadMessagesCount(String messageTo) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Query query;
		 try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	           // Message message = session.get(Message.class, messageId);
	            // fetch unread messages
	            String sql = "select count(*) from Message where messageTo=:messageTo and status=:status";
	            query = session.createQuery(sql);
	            query.setParameter("messageTo", messageTo);
	            query.setParameter("status", true);
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

	public void readMessage(int messageId) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Query query;
		 try {
	            // start a transaction
	            session.beginTransaction();
	            // get the company object
	           // Message message = session.get(Message.class, messageId);
	            // fetch unread messages
	            String sql = "update Message set status=:status where messageId=:messageId";
	            query = session.createQuery(sql);	            
	            query.setParameter("status", false);
	            query.setParameter("messageId", messageId);
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
}
