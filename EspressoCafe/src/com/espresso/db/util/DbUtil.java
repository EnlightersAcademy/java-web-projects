package com.espresso.db.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;

import com.espresso.common.JPAUtil;
import com.espresso.dto.CafeOrder;
import com.espresso.dto.Category;
import com.espresso.dto.Customer;
import com.espresso.dto.Item;
import com.espresso.dto.OrderItem;
import com.espresso.dto.PurchaseItem;
import com.espresso.dto.Staff;
import com.mysql.jdbc.Connection;

public class DbUtil<T> {

	private static Connection conn = null;

	static {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch(Exception exe) {
			System.out.println("RegisterDriver error : " +  exe.getMessage());
			exe.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		try {
			if (conn == null || conn.isClosed()) {
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/espresso_cafe", "root", "root");
			}
		} catch (Exception e) {
			System.out.println(" database error:" + e.getMessage());
			throw e;
		}
		return conn;

	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStatementAndResultSets(Statement statement, ResultSet resultSet) {
		try {
		if(statement != null) {
			statement.close();
		}
		if(resultSet != null) {
			resultSet.close();
		}
		} catch(Exception exe) {
			System.out.println("Error while closing statement and resultset");
			exe.printStackTrace();
		}
	}
	
	public static List<Category> getAllCategories() {
		Statement statement = null;
		ResultSet results = null;
		Connection conn = null;
		List<Category> categories = new ArrayList<>();
		try {
			conn = getConnection();
			statement = conn.createStatement();
			results = statement.executeQuery("select category_id, category_name from Category");

			while (results.next()) {
				Category cat = new Category();
				cat.setCategoryId(results.getInt("categoryid"));
				cat.setCategoryName(results.getString("category_name"));
				categories.add(cat);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return categories;

	}
	
	public static List<Customer> getAllCustomers() {
		Statement statement = null;
		ResultSet results = null;
		List<Customer> customers = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.createStatement();
			results = statement.executeQuery("select customer_id, name, email_id, phone_no from Customer");

			while (results.next()) {
				Customer cus = new Customer();
				cus.setCustomerId(results.getInt("customer_id"));
				cus.setEmailId("email_id");
				cus.setName("name");
				cus.setPhoneNo("phone_no");
				
				customers.add(cus);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return customers;
	}
	
	public static List<Item> getAllAvailableItems() {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Item> items = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select it.item_id, it.item_name, it.category_id, description, status, cat.category_name from Item as it left join Category as cat on it.category_id = cat.category_id where status=?");
			statement.setBoolean(1, true);
			results = statement.executeQuery();
			
			while (results.next()) {
				Item item = new Item();
				item.setItemId(results.getInt("item_id"));
				item.setItemName(results.getString("item_name"));
				item.setDescription("description");
				item.setPrice(results.getInt("price"));
				item.setPhoto(results.getBytes("photo"));
				
				Category cat = new Category();
				cat.setCategoryId(results.getInt("category_id"));
				cat.setCategoryName(results.getString("category_name"));
				item.setCategory(cat);
				items.add(item);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return items;
	}
	
	public static List<Item> getAllItems() {
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Item> items = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select it.item_id, it.item_name, it.category_id, description, status, cat.category_name from Item as it left join Category as cat on it.category_id = cat.category_id");
			results = statement.executeQuery();
			
			while (results.next()) {
				Item item = new Item();
				item.setItemId(results.getInt("item_id"));
				item.setItemName(results.getString("item_name"));
				item.setDescription("description");
				item.setPrice(results.getInt("price"));
				item.setPhoto(results.getBytes("photo"));
				
				Category cat = new Category();
				cat.setCategoryId(results.getInt("category_id"));
				cat.setCategoryName(results.getString("category_name"));
				item.setCategory(cat);
				items.add(item);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return items;
	}
	
	public static List<CafeOrder> getAllOrders() {
		PreparedStatement statement = null;
		ResultSet results = null;
		List<CafeOrder> cafeOrders = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Cafe_Order as co inner join Order_Item as oi on co.id = oi.cafe_order_id");
			results = statement.executeQuery();
			
			Map<Integer, List<OrderItem>> orderItems = new HashMap<Integer, List<OrderItem>>();
			while (results.next()) {
				CafeOrder cafeOrder = new CafeOrder();
				int orderId = results.getInt("id");
				cafeOrder.setId(orderId);
				cafeOrder.setCustomerEmailId(results.getString("customer_email_id"));
				cafeOrder.setDateOfOrder(results.getString("date_of_order"));
				cafeOrder.setStaffId(results.getInt("staff_id"));
				cafeOrder.setStatus(results.getInt("staff_id"));
				cafeOrder.setTotalAmount(results.getInt("total_amount"));
				
				OrderItem orderItem = new OrderItem();
				orderItem.setCafeOrder(cafeOrder);
				orderItem.setItemId(results.getInt("item_id"));
				orderItem.setOrderId(results.getInt("cafe_order_id"));
				orderItem.setQuantity(results.getInt("quantity"));
				orderItem.setOrderItemId(results.getInt("order_item_id"));
				if(orderItems.containsKey(orderId)) {
					List<OrderItem> items = orderItems.get(orderId);
					items.add(orderItem);
					
				} else {
					List<OrderItem> newOrderItems = new ArrayList<>();
					newOrderItems.add(orderItem);
					orderItems.put(orderId, newOrderItems);
					cafeOrder.setItems(newOrderItems);
				}	
				cafeOrders.add(cafeOrder);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return cafeOrders;
	}
	
	public static List<CafeOrder> getAllCompletedOrders() {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		List<CafeOrder> cafeOrders = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Cafe_Order as co inner join Order_Item as oi on co.id = oi.cafe_order_id where co.status = 1");
			results = statement.executeQuery();
			
			Map<Integer, List<OrderItem>> orderItems = new HashMap<Integer, List<OrderItem>>();
			while (results.next()) {
				CafeOrder cafeOrder = new CafeOrder();
				int orderId = results.getInt("id");
				cafeOrder.setId(orderId);
				cafeOrder.setCustomerEmailId(results.getString("customer_email_id"));
				cafeOrder.setDateOfOrder(results.getString("date_of_order"));
				cafeOrder.setStaffId(results.getInt("staff_id"));
				cafeOrder.setStatus(results.getInt("staff_id"));
				cafeOrder.setTotalAmount(results.getInt("total_amount"));
				
				OrderItem orderItem = new OrderItem();
				orderItem.setCafeOrder(cafeOrder);
				orderItem.setItemId(results.getInt("item_id"));
				orderItem.setOrderId(results.getInt("cafe_order_id"));
				orderItem.setQuantity(results.getInt("quantity"));
				orderItem.setOrderItemId(results.getInt("order_item_id"));
				if(orderItems.containsKey(orderId)) {
					List<OrderItem> items = orderItems.get(orderId);
					items.add(orderItem);
					
				} else {
					List<OrderItem> newOrderItems = new ArrayList<>();
					newOrderItems.add(orderItem);
					orderItems.put(orderId, newOrderItems);
					cafeOrder.setItems(newOrderItems);
				}	
				cafeOrders.add(cafeOrder);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return cafeOrders;

	}
	
	public static List<PurchaseItem> getAllPurchases() {
		Statement statement = null;
		ResultSet results = null;
		List<PurchaseItem> purchases = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.createStatement();
			results = statement.executeQuery("select * from Purchase_Item");

			while (results.next()) {
				PurchaseItem purchaseItem = new PurchaseItem();
				purchaseItem.setId(results.getInt("id"));
				purchaseItem.setDescription(results.getString("description"));
				purchaseItem.setDate(results.getString("date"));
				purchaseItem.setName(results.getString("name"));
				purchaseItem.setQuantity(results.getString("quantity"));
				purchaseItem.setTotalCost(results.getInt("total_cost"));
				purchases.add(purchaseItem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return purchases;
	}
	
	public static List<Staff> getAllStaffs() {
		Statement statement = null;
		ResultSet results = null;
		List<Staff> staffs = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.createStatement();
			results = statement.executeQuery("select * from Staff");

			while (results.next()) {
				Staff staff = new Staff();
				staff.setStaffId(results.getInt("staff_id"));
				staff.setPhoneNo(results.getString("phone_no"));
				staff.setAddress(results.getString("address"));
				staff.setDob(results.getString("dob"));
				staff.setEmailId(results.getString("email_id"));
				staff.setGender(results.getString("gender"));
				staff.setIdType(results.getString("id_type"));
				staff.setIdentification(results.getString("identification"));
				staff.setActive(results.getBoolean("is_active"));
				staff.setPassword(results.getString("password"));
				staff.setName(results.getString("name"));
				staffs.add(staff);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return staffs;
	}
	
	public static List<Staff> getAllActiveStaffs() {
		Statement statement = null;
		ResultSet results = null;
		List<Staff> staffs = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.createStatement();
			results = statement.executeQuery("select * from Staff as st where st.is_active =true");

			while (results.next()) {
				Staff staff = new Staff();
				staff.setStaffId(results.getInt("staff_id"));
				staff.setPhoneNo(results.getString("phone_no"));
				staff.setAddress(results.getString("address"));
				staff.setDob(results.getString("dob"));
				staff.setEmailId(results.getString("email_id"));
				staff.setGender(results.getString("gender"));
				staff.setIdType(results.getString("id_type"));
				staff.setIdentification(results.getString("identification"));
				staff.setActive(results.getBoolean("is_active"));
				staff.setPassword(results.getString("password"));
				staff.setName(results.getString("name"));
				staffs.add(staff);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return staffs;
	}

	
	public void insertStaffEntry(Staff staff) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "insert into Staff (staff_id, name, gender, email_id, dob, phone_no, address, id_type, is_active) values (?,?,?,?,?,?,?,?,?)";
		try {
			conn = getConnection();
			int value = ThreadLocalRandom.current().nextInt(1, 199);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, value);
			statement.setString(2, staff.getName());
			statement.setString(3, staff.getGender());
			statement.setString(4, staff.getEmailId());
			statement.setString(5, staff.getDob());
			statement.setString(6, staff.getPhoneNo());
			statement.setString(7, staff.getAddress());
			statement.setString(8, staff.getIdType());
			statement.setBoolean(9,  staff.isActive());
			statement.execute();
		} catch (Exception exe) {
			exe.printStackTrace();
			throw exe;
		} finally {
			closeStatementAndResultSets(statement, results);
		}
	}
	
	public void insertCustomerEntry(Customer cus) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "insert into Customer (customer_id, name, email_id, phone_no) values (?,?,?,?)";
		try {
			conn = getConnection();
			int value = ThreadLocalRandom.current().nextInt(200, 399);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, value);
			statement.setString(2, cus.getName());
			statement.setString(3, cus.getEmailId());
			statement.setString(4, cus.getPhoneNo());
			
			statement.execute();
		} catch (Exception exe) {
			exe.printStackTrace();
			throw exe;
		} finally {
			closeStatementAndResultSets(statement, results);
		}
	}
	
	public void insertCategoryEntry(Category cat) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "insert into Category (category_id, category_name) values (?,?)";
		try {
			conn = getConnection();
			int value = ThreadLocalRandom.current().nextInt(400, 599);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, value);
			statement.setString(2, cat.getCategoryName());
			
			statement.execute();
		} catch (Exception exe) {
			exe.printStackTrace();
			throw exe;
		} finally {
			closeStatementAndResultSets(statement, results);
		}
	}
	
	public void insertItemEntry(Item item) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "insert into Item (item_id, item_name, category_id, description, status, price, photo) values (?,?,?,?,?,?,?)";
		try {
			conn = getConnection();
			int value = ThreadLocalRandom.current().nextInt(600, 799);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, value);
			statement.setString(2, item.getItemName());
			statement.setInt(3, item.getCategory().getCategoryId());
			statement.setString(4, item.getDescription());
			statement.setBoolean(5, item.isAvailable());
			statement.setInt(6, item.getPrice());
			statement.setBytes(7, item.getPhoto());

			statement.execute();
		} catch (Exception exe) {
			exe.printStackTrace();
			throw exe;
		} finally {
			closeStatementAndResultSets(statement, results);
		}
	}
	
	public void insertCafeOrderEntry(CafeOrder cafeOrder) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "insert into Cafe_Order (id, customer_email_id, date_of_order, staff_id, status, total_amount) values (?,?,?,?,?,?)";
		try {
			conn = getConnection();
			int value = ThreadLocalRandom.current().nextInt(800, 999);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, value);
			statement.setString(2, cafeOrder.getCustomerEmailId());
			statement.setString(3, cafeOrder.getDateOfOrder());
			statement.setInt(4, cafeOrder.getStaffId());
			statement.setInt(5, cafeOrder.getStatus());
			statement.setInt(6, cafeOrder.getTotalAmount());

			statement.execute();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
	}
	
	public void insertOrderItemEntry(OrderItem orderItem) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "insert into Order_Item (order_item_id, item_id, quantity, cafe_order_id) values (?,?,?,?)";
		try {
			conn = getConnection();
			int value = ThreadLocalRandom.current().nextInt(1000, 3000);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, value);
			statement.setInt(2, orderItem.getItemId());
			statement.setInt(3, orderItem.getQuantity());
			statement.setInt(4, orderItem.getCafeOrder().getId());

			statement.execute();
		} catch (Exception exe) {
			exe.printStackTrace();
			throw exe;
		} finally {
			closeStatementAndResultSets(statement, results);
		}
	}
	
	public void insertPurchaseItemEntry(PurchaseItem purchaseItem) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "insert into Purchase_Item (id, date, description, name, quantity, total_cost) values (?,?,?,?,?,?)";
		try {
			conn = getConnection();
			int value = ThreadLocalRandom.current().nextInt(3001, 4000);
			statement = conn.prepareStatement(sql);
			statement.setInt(1, value);
			statement.setString(2, purchaseItem.getDate());
			statement.setString(3, purchaseItem.getDescription());
			statement.setString(4, purchaseItem.getName());
			statement.setString(5,  purchaseItem.getQuantity());
			statement.setInt(7,  purchaseItem.getTotalCost());

			statement.execute();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
	}

	public static Staff getStaffByEmailId(String emailId) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Staff staff = null;

		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Staff as st where where st.email_id =?");
			statement.setString(1, emailId);
			results = statement.executeQuery();
			while (results.next()) {
				staff = new Staff();
				staff.setStaffId(results.getInt("staff_id"));
				staff.setPhoneNo(results.getString("phone_no"));
				staff.setAddress(results.getString("address"));
				staff.setDob(results.getString("dob"));
				staff.setEmailId(results.getString("email_id"));
				staff.setGender(results.getString("gender"));
				staff.setIdType(results.getString("id_type"));
				staff.setIdentification(results.getString("identification"));
				staff.setActive(results.getBoolean("is_active"));
				staff.setPassword(results.getString("password"));
				staff.setName(results.getString("name"));
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return staff;
		
	}
	
	public static Staff getStaffByStaffId(int staffId) {
		PreparedStatement statement = null;
		ResultSet results = null;
		Staff staff = null;

		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Staff as st where where st.id =?");
			statement.setInt(1, staffId);
			results = statement.executeQuery();
			while (results.next()) {
				staff = new Staff();
				staff.setStaffId(results.getInt("staff_id"));
				staff.setPhoneNo(results.getString("phone_no"));
				staff.setAddress(results.getString("address"));
				staff.setDob(results.getString("dob"));
				staff.setEmailId(results.getString("email_id"));
				staff.setGender(results.getString("gender"));
				staff.setIdType(results.getString("id_type"));
				staff.setIdentification(results.getString("identification"));
				staff.setActive(results.getBoolean("is_active"));
				staff.setPassword(results.getString("password"));
				staff.setName(results.getString("name"));
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return staff;
	}
	
	public static List<CafeOrder> getAllOrdersByStaffId(int staffId) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		List<CafeOrder> cafeOrders = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Cafe_Order as co inner join Order_Item as oi on co.id = oi.cafe_order_id where co.staff_id = ?");
			statement.setInt(1, staffId);
			results = statement.executeQuery();
			
			Map<Integer, List<OrderItem>> orderItems = new HashMap<Integer, List<OrderItem>>();
			while (results.next()) {
				CafeOrder cafeOrder = new CafeOrder();
				int orderId = results.getInt("id");
				cafeOrder.setId(orderId);
				cafeOrder.setCustomerEmailId(results.getString("customer_email_id"));
				cafeOrder.setDateOfOrder(results.getString("date_of_order"));
				cafeOrder.setStaffId(results.getInt("staff_id"));
				cafeOrder.setStatus(results.getInt("staff_id"));
				cafeOrder.setTotalAmount(results.getInt("total_amount"));
				
				OrderItem orderItem = new OrderItem();
				orderItem.setCafeOrder(cafeOrder);
				orderItem.setItemId(results.getInt("item_id"));
				orderItem.setOrderId(results.getInt("cafe_order_id"));
				orderItem.setQuantity(results.getInt("quantity"));
				orderItem.setOrderItemId(results.getInt("order_item_id"));
				if(orderItems.containsKey(orderId)) {
					List<OrderItem> items = orderItems.get(orderId);
					items.add(orderItem);
					
				} else {
					List<OrderItem> newOrderItems = new ArrayList<>();
					newOrderItems.add(orderItem);
					orderItems.put(orderId, newOrderItems);
					cafeOrder.setItems(newOrderItems);
				}	
				cafeOrders.add(cafeOrder);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return cafeOrders;
	}
	
	public static CafeOrder getOngoingOrdersByCustomerEmail(String email) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		CafeOrder cafeOrder = null;
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Cafe_Order as co inner join Order_Item as oi on co.id = oi.cafe_order_id where co.customer_email_id = ? and co.status = 2");
			statement.setString(1, email);
			results = statement.executeQuery();
			
			Map<Integer, List<OrderItem>> orderItems = new HashMap<Integer, List<OrderItem>>();
			while (results.next()) {
				cafeOrder = new CafeOrder();
				int orderId = results.getInt("id");
				cafeOrder.setId(orderId);
				cafeOrder.setCustomerEmailId(results.getString("customer_email_id"));
				cafeOrder.setDateOfOrder(results.getString("date_of_order"));
				cafeOrder.setStaffId(results.getInt("staff_id"));
				cafeOrder.setStatus(results.getInt("status"));
				cafeOrder.setTotalAmount(results.getInt("total_amount"));
				
				OrderItem orderItem = new OrderItem();
				orderItem.setCafeOrder(cafeOrder);
				orderItem.setItemId(results.getInt("item_id"));
				orderItem.setOrderId(results.getInt("cafe_order_id"));
				orderItem.setQuantity(results.getInt("quantity"));
				orderItem.setOrderItemId(results.getInt("order_item_id"));
				if(orderItems.containsKey(orderId)) {
					List<OrderItem> items = orderItems.get(orderId);
					items.add(orderItem);
					
				} else {
					List<OrderItem> newOrderItems = new ArrayList<>();
					newOrderItems.add(orderItem);
					orderItems.put(orderId, newOrderItems);
					cafeOrder.setItems(newOrderItems);
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return cafeOrder;
	}
	
	public static List<CafeOrder> getOngoingOrdersByStaffId(int staffId) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		List<CafeOrder> cafeOrders = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Cafe_Order as co inner join Order_Item as oi on co.id = oi.cafe_order_id where co.staff_id = ? and co.status = 2");
			statement.setInt(1, staffId);
			results = statement.executeQuery();
			
			Map<Integer, List<OrderItem>> orderItems = new HashMap<Integer, List<OrderItem>>();
			while (results.next()) {
				CafeOrder cafeOrder = new CafeOrder();
				int orderId = results.getInt("id");
				cafeOrder.setId(orderId);
				cafeOrder.setCustomerEmailId(results.getString("customer_email_id"));
				cafeOrder.setDateOfOrder(results.getString("date_of_order"));
				cafeOrder.setStaffId(results.getInt("staff_id"));
				cafeOrder.setStatus(results.getInt("staff_id"));
				cafeOrder.setTotalAmount(results.getInt("total_amount"));
				
				OrderItem orderItem = new OrderItem();
				orderItem.setCafeOrder(cafeOrder);
				orderItem.setItemId(results.getInt("item_id"));
				orderItem.setOrderId(results.getInt("cafe_order_id"));
				orderItem.setQuantity(results.getInt("quantity"));
				orderItem.setOrderItemId(results.getInt("order_item_id"));
				if(orderItems.containsKey(orderId)) {
					List<OrderItem> items = orderItems.get(orderId);
					items.add(orderItem);
					
				} else {
					List<OrderItem> newOrderItems = new ArrayList<>();
					newOrderItems.add(orderItem);
					orderItems.put(orderId, newOrderItems);
					cafeOrder.setItems(newOrderItems);
				}	
				cafeOrders.add(cafeOrder);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return cafeOrders;
	}
	
	public static CafeOrder getOngoingOrdersByStaffIdAndCustomerEmail(int staffId, String customerEmail) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		CafeOrder cafeOrder = null;
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Cafe_Order as co inner join Order_Item as oi on co.id = oi.cafe_order_id where co.customer_email_id = ? and co.staff_id = ? and co.status = 2");
			statement.setString(1, customerEmail);
			statement.setInt(2,  staffId);
			results = statement.executeQuery();
			
			Map<Integer, List<OrderItem>> orderItems = new HashMap<Integer, List<OrderItem>>();
			while (results.next()) {
				cafeOrder = new CafeOrder();
				int orderId = results.getInt("id");
				cafeOrder.setId(orderId);
				cafeOrder.setCustomerEmailId(results.getString("customer_email_id"));
				cafeOrder.setDateOfOrder(results.getString("date_of_order"));
				cafeOrder.setStaffId(results.getInt("staff_id"));
				cafeOrder.setStatus(results.getInt("status"));
				cafeOrder.setTotalAmount(results.getInt("total_amount"));
				
				OrderItem orderItem = new OrderItem();
				orderItem.setCafeOrder(cafeOrder);
				orderItem.setItemId(results.getInt("item_id"));
				orderItem.setOrderId(results.getInt("cafe_order_id"));
				orderItem.setQuantity(results.getInt("quantity"));
				orderItem.setOrderItemId(results.getInt("order_item_id"));
				if(orderItems.containsKey(orderId)) {
					List<OrderItem> items = orderItems.get(orderId);
					items.add(orderItem);
					
				} else {
					List<OrderItem> newOrderItems = new ArrayList<>();
					newOrderItems.add(orderItem);
					orderItems.put(orderId, newOrderItems);
					cafeOrder.setItems(newOrderItems);
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return cafeOrder;
	}
	
	public static List<Item> getAllItemsByCategory(Category cat) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Item> items = new ArrayList<>();
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select it.item_id, it.item_name, it.category_id, description, status, cat.category_name from Item as it left join Category as cat on it.category_id = cat.category_id where it.category_id = ?");
			statement.setInt(1, cat.getCategoryId());
			results = statement.executeQuery();
			
			while (results.next()) {
				Item item = new Item();
				item.setItemId(results.getInt("item_id"));
				item.setItemName(results.getString("item_name"));
				item.setDescription("description");
				item.setPrice(results.getInt("price"));
				item.setPhoto(results.getBytes("photo"));
				
				cat.setCategoryId(results.getInt("category_id"));
				cat.setCategoryName(results.getString("category_name"));
				item.setCategory(cat);
				items.add(item);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return items;
	}
	
	public static Item getItemByName(String name) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Item item = null;
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select it.item_id, it.item_name, it.category_id, description, status, cat.category_name from Item as it left join Category as cat on it.category_id = cat.category_id where it.item_name = ?");
			statement.setString(1, name);
			results = statement.executeQuery();
			
			if (results.next()) {
				item = new Item();
				item.setItemId(results.getInt("item_id"));
				item.setItemName(results.getString("item_name"));
				item.setDescription("description");
				item.setPrice(results.getInt("price"));
				item.setPhoto(results.getBytes("photo"));
				
				Category cat = new Category();
				cat.setCategoryId(results.getInt("category_id"));
				cat.setCategoryName(results.getString("category_name"));
				item.setCategory(cat);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return item;
	}
	
	public static Item getItemById(int id) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Item item = null;
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select it.item_id, it.item_name, it.category_id, description, status, cat.category_name from Item as it left join Category as cat on it.category_id = cat.category_id where it.item_id = ?");
			statement.setInt(1, id);
			results = statement.executeQuery();
			
			if (results.next()) {
				item = new Item();
				item.setItemId(results.getInt("item_id"));
				item.setItemName(results.getString("item_name"));
				item.setDescription("description");
				item.setPrice(results.getInt("price"));
				item.setPhoto(results.getBytes("photo"));
				
				Category cat = new Category();
				cat.setCategoryId(results.getInt("category_id"));
				cat.setCategoryName(results.getString("category_name"));
				item.setCategory(cat);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return item;
	}
	
	public static CafeOrder getCafeOrderById(int id) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		CafeOrder cafeOrder = null;
		try {
			Connection conn = getConnection();
			statement = conn.prepareStatement("select * from Cafe_Order as co inner join Order_Item as oi on co.id = oi.cafe_order_id where co.id=?");
			statement.setInt(1,  id);
			results = statement.executeQuery();
			
			Map<Integer, List<OrderItem>> orderItems = new HashMap<Integer, List<OrderItem>>();
			while (results.next()) {
				cafeOrder = new CafeOrder();
				int orderId = results.getInt("id");
				cafeOrder.setId(orderId);
				cafeOrder.setCustomerEmailId(results.getString("customer_email_id"));
				cafeOrder.setDateOfOrder(results.getString("date_of_order"));
				cafeOrder.setStaffId(results.getInt("staff_id"));
				cafeOrder.setStatus(results.getInt("status"));
				cafeOrder.setTotalAmount(results.getInt("total_amount"));
				
				OrderItem orderItem = new OrderItem();
				orderItem.setCafeOrder(cafeOrder);
				orderItem.setItemId(results.getInt("item_id"));
				orderItem.setOrderId(results.getInt("cafe_order_id"));
				orderItem.setQuantity(results.getInt("quantity"));
				orderItem.setOrderItemId(results.getInt("order_item_id"));
				if(orderItems.containsKey(orderId)) {
					List<OrderItem> items = orderItems.get(orderId);
					items.add(orderItem);
					
				} else {
					List<OrderItem> newOrderItems = new ArrayList<>();
					newOrderItems.add(orderItem);
					orderItems.put(orderId, newOrderItems);
					cafeOrder.setItems(newOrderItems);
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		return cafeOrder;		
	}
	
	public static Category getCategoryByName(String name) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		Category cat = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement("select category_id, category_name from Category as cat where cat.category_name = ?");
			statement.setString(1, name);
			results = statement.executeQuery();

			if (results.next()) {
				cat = new Category();
				cat.setCategoryId(results.getInt("categoryid"));
				cat.setCategoryName(results.getString("category_name"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return cat;
	}
	
	public static Customer getCustomerByEmailId(String emailId) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		Customer cus = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement("select * from Customer as cus where cus.email_id = ?");
			statement.setString(1, emailId);
			results = statement.executeQuery();

			if (results.next()) {
				cus = new Customer();
				cus.setCustomerId(results.getInt("customer_id"));
				cus.setEmailId(results.getString("email_id"));
				cus.setName(results.getString("name"));
				cus.setPhoneNo(results.getString("phone_no"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return cus;
	}
	
	public void updateStaffDetails(Staff staff) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "update Staff as staff set name =?, gender=?, email_id=?,dob=?,identification=?, phone_no=?, address=?, id_type=? where staff.email_id = ?";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, staff.getName());
			statement.setString(2, staff.getGender());
			statement.setString(3, staff.getEmailId());
			statement.setString(4, staff.getDob());
			statement.setString(5, staff.getPhoneNo());
			statement.setString(6, staff.getAddress());
			statement.setString(7, staff.getIdType());
			statement.setString(8, staff.getEmailId());
			statement.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}	
	}
	
	public static void updateStaffPassword(Staff staff, String newPassword) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "update Staff as staff set password=? where staff.email_id = ?";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, staff.getPassword());
			statement.setString(2, staff.getEmailId());
			statement.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}	
	}
	
	public static void updateCafeOrder(CafeOrder cafeOrder) throws Exception {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "update Cafe_Order as co set co.customer_email_id=?, co.staff_id=?, co.total_amount=?, co.date_of_order=?, co.status=? where co.id = ?";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, cafeOrder.getCustomerEmailId());
			statement.setInt(2, cafeOrder.getStaffId());
			statement.setInt(3, cafeOrder.getTotalAmount());
			statement.setString(4, cafeOrder.getDateOfOrder());
			statement.setInt(5, cafeOrder.getStatus());
			statement.setInt(6, cafeOrder.getId());
			statement.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
		
	}
	
	public static void udateCafeOrderSimple(CafeOrder cafeOrder) throws Exception {
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "update Cafe_Order as co set co.customer_email_id=?, co.staff_id=?, co.total_amount=?, co.date_of_order=?, co.status=? where co.id = ?";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, cafeOrder.getCustomerEmailId());
			statement.setInt(2, cafeOrder.getStaffId());
			statement.setInt(3, cafeOrder.getTotalAmount());
			statement.setString(4, cafeOrder.getDateOfOrder());
			statement.setInt(5, cafeOrder.getStatus());
			statement.setInt(6, cafeOrder.getId());
			statement.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		
	}
	
	public static boolean updateItemStatus(int itemId, boolean isAvailable) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "update Item as it set it.status=? where it.item_id = ?";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setBoolean(1, isAvailable);
			statement.setInt(2, itemId);

			statement.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
			return false;
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return true;
	}
	
	public static boolean updateStaffStatus(int staffId, boolean isActive) {
		
		PreparedStatement statement = null;
		ResultSet results = null;
		Connection conn = null;
		String sql = "update Staff as st set st.is_active=? where st.staff_id = ?";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			statement.setBoolean(1, isActive);
			statement.setInt(2, staffId);

			statement.executeUpdate();
		} catch (Exception exe) {
			exe.printStackTrace();
			return false;
		} finally {
			closeStatementAndResultSets(statement, results);
		}
		return true;
	}
}
