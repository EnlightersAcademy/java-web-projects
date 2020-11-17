package com.espresso.db.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.espresso.dto.Category;
import com.espresso.dto.Customer;
import com.espresso.dto.Item;
import com.espresso.dto.Order;
import com.espresso.dto.PurchaseItem;
import com.espresso.dto.Staff;
import com.espresso.hibernate.JPAUtil;

public class DbUtil<T> {


//	
//	public static void createItem(Item item) throws Exception {
//		EntityManager manager = JPAUtil.getEMF().createEntityManager();
//		manager.getTransaction().begin();
//		try {
//			manager.persist(item);
//			manager.getTransaction().commit();
//		}catch(Exception e) {
//			manager.getTransaction().rollback();
//			throw e;
//		} finally {
//			manager.close();
//		}
//	}

	public static List<Category> getAllCategories() {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Category> query = manager.createQuery("select cat from Category cat", Category.class);
		return query.getResultList();

	}
	
	public static List<Customer> getAllCustomers() {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Customer> query = manager.createQuery("select cus from Customer cus", Customer.class);
		return query.getResultList();
	}
	
	public static List<Item> getAllItems() {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Item> query = manager.createQuery("select item from Item item", Item.class);
		return query.getResultList();
	}
	
	public static List<Order> getAllOrders() {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Order> query = manager.createQuery("select ord from Order ord", Order.class);
		return query.getResultList();
	}
	
	public static List<PurchaseItem> getAllPurchases() {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<PurchaseItem> query = manager.createQuery("select pur from Purchase_Item pur", PurchaseItem.class);
		return query.getResultList();
	}
	
	public static List<Staff> getAllStaffs() {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Staff> query = manager.createQuery("select staff from Staff staff", Staff.class);
		return query.getResultList();
	}

	public void createEntry(T item) throws Exception {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		manager.getTransaction().begin();
		try {
			manager.persist(item);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}
	}
	

	public static Staff getStaffByEmailId(String emailId) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Staff> query = manager.createQuery("select staff from Staff staff where staff.emailId =:emailId",
				Staff.class);
		query.setParameter("emailId", emailId);
		Staff staff = null;
		try {
		 staff = query.getSingleResult();
		} catch(Exception exe) {
			return null;
		}
		return staff;
	}
	
	public static List<Order> getOrdersByStaffId(int staffId) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Order> query = manager.createQuery("select order from Order order where order.staffId =:staffId",
				Order.class);
		query.setParameter("staffId", staffId);
		return query.getResultList();
	}
	
	
	public static Item getItemByName(String name) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Item> query = manager.createQuery("select item from Item item where item.name = :name",
				Item.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
	public static Category getCategoryByName(String name) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Category> query = manager.createQuery("select cat from Category cat where cat.categoryNname = :name",
				Category.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
	public static Customer getCustomerByEmailId(String emailId) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Customer> query = manager.createQuery("select cus from Customer cus where cus.emailId =:emailId",
				Customer.class);
		query.setParameter("emailId", emailId);
		return query.getSingleResult();
	}
	
	
	public void updateStaffDetails(Staff staff) throws Exception {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		manager.getTransaction().begin();
		try {
			TypedQuery<Staff> query = manager.createQuery(" update Staff s set s.name =:name, s.gender =:gender, s.dob =:dob, s.identification =:identification, s.phoneNo =:phoneNo, s.address =:address, s.idType =:idType  where staff.emailId =:emailId",
					Staff.class);
			query.setParameter("name", staff.getName());
			query.setParameter("gender", staff.getGender());
			query.setParameter("dob", staff.getDob());
			query.setParameter("identification", staff.getIdentification());
			query.setParameter("phoneNo", staff.getPhoneNo());
			query.setParameter("address", staff.getAddress());
			query.setParameter("idType", staff.getIdType());
			query.setParameter("emailId", staff.getEmailId());
			query.executeUpdate();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}
	}
	
	public static void updateStaffPassword(Staff staff, String newPassword) throws Exception {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		manager.getTransaction().begin();
		try {
			staff.setPassword(newPassword);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

}
