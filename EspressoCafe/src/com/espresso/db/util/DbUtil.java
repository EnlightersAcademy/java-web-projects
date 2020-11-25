package com.espresso.db.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.espresso.dto.Category;
import com.espresso.dto.Customer;
import com.espresso.dto.Item;
import com.espresso.dto.CafeOrder;
import com.espresso.dto.PurchaseItem;
import com.espresso.dto.Staff;
import com.espresso.hibernate.JPAUtil;

public class DbUtil<T> {

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
		TypedQuery<Item> query = manager.createQuery("select item from Item item where item.isAvailable = true", Item.class);
		return query.getResultList();
	}
	
	public static List<CafeOrder> getAllOrders() {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<CafeOrder> query = manager.createQuery("select ord from CafeOrder ord", CafeOrder.class);
		return query.getResultList();
	}
	
	public static List<PurchaseItem> getAllPurchases() {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<PurchaseItem> query = manager.createQuery("select pur from PurchaseItem pur", PurchaseItem.class);
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
	
	public static List<CafeOrder> getOrdersByStaffId(int staffId, String emailId) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();

		Staff staff = getStaffByEmailId(emailId);
		TypedQuery<CafeOrder> query = manager.createQuery("select ord from CafeOrder ord where ord.staff =:staffId",
				CafeOrder.class);
		query.setParameter("staffId", staff);
		return query.getResultList();
	}
	
	public static List<Item> getAllItemsByCategory(Category cat) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Item> query = manager.createQuery("select item from Item item where item.category = :cat", Item.class);
		query.setParameter("cat", cat);
		return query.getResultList();
	}
	
	public static Item getItemByName(String name) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Item> query = manager.createQuery("select item from Item item where item.itemName = :name",
				Item.class);
		query.setParameter("name", name);
		Item item = null;
		try {
		 item = query.getSingleResult();
		} catch(Exception exe) {
			return null;
		}
		return item;
	}
	
	public static Item getItemById(int id) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Item> query = manager.createQuery("select item from Item item where item.itemId = :id",
				Item.class);
		query.setParameter("id", id);
		Item item = null;
		try {
		 item = query.getSingleResult();
		} catch(Exception exe) {
			return null;
		}
		return item;
	}
	
	public static Category getCategoryByName(String name) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Category> query = manager.createQuery("select cat from Category cat where cat.categoryName = :name",
				Category.class);
		query.setParameter("name", name);
		Category cat = null;
		try {
		 cat = query.getSingleResult();
		} catch(Exception exe) {
			return null;
		}
		return cat;
	}
	
	public static Customer getCustomerByEmailId(String emailId) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Customer> query = manager.createQuery("select cus from Customer cus where cus.emailId =:emailId",
				Customer.class);
		query.setParameter("emailId", emailId);
		Customer cus = null;
		try {
		 cus = query.getSingleResult();
		} catch(Exception exe) {
			return null;
		}
		return cus;
	}
	
	public void updateStaffDetails(Staff staff) throws Exception {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		manager.getTransaction().begin();
		try {
			Query query = manager.createQuery(" update Staff s set s.name =:name, s.gender =:gender, s.dob =:dob, s.identification =:identification, s.phoneNo =:phoneNo, s.address =:address, s.idType =:idType  where s.emailId =:emailId");
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
			Query query = manager.createQuery(" update Staff staff set staff.password =:pass");
			query.setParameter("pass", newPassword);
			query.executeUpdate();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}
	
	public static boolean updateItemStatus(int itemId, boolean isAvailable) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		
		manager.getTransaction().begin();
		
		try {
			Query query = manager.createQuery("update Item item set item.isAvailable =:status where item.itemId =:itemId");
			query.setParameter("status", isAvailable);
			query.setParameter("itemId", itemId);
			query.executeUpdate();
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			return false;
		} finally {
			manager.close();
		}
		return true;
	}
	
	public static boolean updateStaffStatus(int staffId, boolean isActive) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		
		manager.getTransaction().begin();
		
		try {
			Query query = manager.createQuery(" update Staff s set s.isActive =:status where s.staffId =:id");
			query.setParameter("status", isActive);
			query.setParameter("id", staffId);
			query.executeUpdate();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
		return true;
	}
}
