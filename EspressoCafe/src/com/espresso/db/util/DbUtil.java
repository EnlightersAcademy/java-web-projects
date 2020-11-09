package com.espresso.db.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.espresso.dto.Category;
import com.espresso.dto.Item;
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
		TypedQuery<Staff> query = manager.createQuery("select staff from Staff staff where staff.email_id =:emailId",
				Staff.class);
		query.setParameter(1, emailId);
		return query.getSingleResult();
	}
	
	
	public static Item getItemByName(String name) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Item> query = manager.createQuery("select item from Item item where item.name = :name",
				Item.class);
		query.setParameter(1, name);
		return query.getSingleResult();
	}
	
	public static Category getCategoryByName(String name) {
		EntityManager manager = JPAUtil.getEMF().createEntityManager();
		TypedQuery<Category> query = manager.createQuery("select cat from Category cat where cat.category_name = :name",
				Category.class);
		query.setParameter(1, name);
		return query.getSingleResult();
	}

}
