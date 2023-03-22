package com.shipwell.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shipwell.db.connection.DBConnectionProvider;
import com.shipwell.dto.Complaint;
import com.shipwell.dto.Customer;
import com.shipwell.dto.Employee;
import com.shipwell.dto.Location;
import com.shipwell.dto.LogisticPartner;
import com.shipwell.dto.LogisticPartnerOffice;
import com.shipwell.dto.WayBill;
import com.sun.swing.internal.plaf.synth.resources.synth;

public class DBUtils {

	// ADMIN Operations
	// fetch all rides
	public static synchronized List<LogisticPartner> fetchAllLogisticParners(boolean onlyActive) {
		PreparedStatement statement = null;
		ResultSet results = null;
		List<LogisticPartner> logisticPartnerList = new ArrayList<LogisticPartner>();
		String sql = "select * from logistic_partner";
		if (onlyActive)
			sql = "select * from logistic_partner where status=1 ";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			results = statement.executeQuery();

			while (results.next()) {
				LogisticPartner lp = new LogisticPartner();
				lp.setLogisticPartnerId(results.getInt("logistic_partner_id"));
				lp.setName(results.getString("name"));
				lp.setPassword(results.getString("password"));
				lp.setMainOfficeLocation(results.getString("main_office_location"));
				lp.setPhoneNo(results.getString("phone_no"));
				lp.setEmailId(results.getString("email_id"));
				lp.setOwnerName(results.getString("owner_name"));
				lp.setOwnerEmailId(results.getString("owner_email_id"));
				lp.setOwnerPhoneNo(results.getString("owner_phone_no"));
				lp.setRoadKmRate(results.getInt("road_km_rate"));
				lp.setAirKmRate(results.getInt("air_km_rate"));
				lp.setSeaKmRate(results.getInt("sea_km_rate"));
				lp.setRailKmRate(results.getInt("rail_km_rate"));
				lp.setSecurityQuestion(results.getString("security_question"));
				lp.setSecurityAnswer(results.getString("security_answer"));
				lp.setKgIncreaseRate5(results.getInt("kg_increase_rate_5"));
				lp.setKgIncreaseRate10(results.getInt("kg_increase_rate_10"));
				lp.setKgIncreaseRate20(results.getInt("kg_increase_rate_20"));
				lp.setKgIncreaseRate50(results.getInt("kg_increase_rate_50"));
				lp.setKgIncreaseRate50More(results.getInt("kg_increase_rate_50_more"));
				lp.setStatus(results.getInt("status"));

				logisticPartnerList.add(lp);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return logisticPartnerList;
	}

	public static synchronized List<Location> fetchAllLocations() {

		PreparedStatement statement = null;
		ResultSet results = null;
		List<Location> locationList = new ArrayList<Location>();
		String sql = "select * from location";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			results = statement.executeQuery();

			while (results.next()) {
				Location location = new Location();

				location.setLocationId(results.getInt("location_id"));
				location.setLocationName(results.getString("location_name"));
				location.setStateName(results.getString("state_name"));

				locationList.add(location);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return locationList;
	}

	public static synchronized List<WayBill> fetchAllWayBills() {

		PreparedStatement statement = null;
		ResultSet results = null;
		List<WayBill> wayBills = new ArrayList<WayBill>();
		String sql = "select * from way_bill";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			results = statement.executeQuery();

			while (results.next()) {
				WayBill wayBill = new WayBill();

				wayBill.setAmount(results.getFloat("location_id"));
				wayBill.setComment(results.getString("location_id"));
				wayBill.setCustomerId(results.getInt("customer_id"));
				wayBill.setDeliveryDate(results.getString("delivery_date"));
				wayBill.setLogisticPartnerId(results.getInt("logistic_partner_id"));
				wayBill.setModeOfTransportation(results.getString("mode_transportation"));
				wayBill.setProductDetails(results.getString("product_details"));
				wayBill.setStatus(results.getString("status"));
				wayBill.setWayBillId(results.getInt("waybill_id"));
				wayBill.setWeight(results.getFloat("weight"));

				wayBills.add(wayBill);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return wayBills;
	}

	public static synchronized List<WayBill> fetchWayBillsByCustomerId(int customerId) {

		PreparedStatement statement = null;
		ResultSet results = null;
		List<WayBill> wayBills = new ArrayList<WayBill>();
		String sql = "select * from way_bill where customer_id=?";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, customerId);
			results = statement.executeQuery();

			while (results.next()) {
				WayBill wayBill = new WayBill();

				wayBill.setAmount(results.getFloat("location_id"));
				wayBill.setComment(results.getString("location_id"));
				wayBill.setCustomerId(results.getInt("customer_id"));
				wayBill.setDeliveryDate(results.getString("delivery_date"));
				wayBill.setLogisticPartnerId(results.getInt("logistic_partner_id"));
				wayBill.setModeOfTransportation(results.getString("mode_transportation"));
				wayBill.setProductDetails(results.getString("product_details"));
				wayBill.setStatus(results.getString("status"));
				wayBill.setWayBillId(results.getInt("waybill_id"));
				wayBill.setWeight(results.getFloat("weight"));

				wayBills.add(wayBill);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return wayBills;
	}

	public static synchronized List<WayBill> fetchWayBillsByLogisticPartnerId(int lpId) {

		PreparedStatement statement = null;
		ResultSet results = null;
		List<WayBill> wayBills = new ArrayList<WayBill>();
		String sql = "select * from way_bill where logistic_partner_id=?";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, lpId);
			results = statement.executeQuery();

			while (results.next()) {
				WayBill wayBill = new WayBill();

				wayBill.setAmount(results.getFloat("location_id"));
				wayBill.setComment(results.getString("location_id"));
				wayBill.setCustomerId(results.getInt("customer_id"));
				wayBill.setDeliveryDate(results.getString("delivery_date"));
				wayBill.setLogisticPartnerId(results.getInt("logistic_partner_id"));
				wayBill.setModeOfTransportation(results.getString("mode_transportation"));
				wayBill.setProductDetails(results.getString("product_details"));
				wayBill.setStatus(results.getString("status"));
				wayBill.setWayBillId(results.getInt("waybill_id"));
				wayBill.setWeight(results.getFloat("weight"));

				wayBills.add(wayBill);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return wayBills;
	}

	public static synchronized WayBill fetchWayBillsByWayBillId(int wayBillId) {

		PreparedStatement statement = null;
		ResultSet results = null;
		WayBill wayBill = new WayBill();
		String sql = "select * from way_bill where waybill_id=?";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, wayBillId);
			results = statement.executeQuery();

			while (results.next()) {

				wayBill.setAmount(results.getFloat("location_id"));
				wayBill.setComment(results.getString("location_id"));
				wayBill.setCustomerId(results.getInt("customer_id"));
				wayBill.setDeliveryDate(results.getString("delivery_date"));
				wayBill.setLogisticPartnerId(results.getInt("logistic_partner_id"));
				wayBill.setModeOfTransportation(results.getString("mode_transportation"));
				wayBill.setProductDetails(results.getString("product_details"));
				wayBill.setStatus(results.getString("status"));
				wayBill.setWayBillId(results.getInt("waybill_id"));
				wayBill.setWeight(results.getFloat("weight"));

			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return wayBill;
	}

	// activate Logistic Partner
	public static synchronized boolean changeLogisticParnerStatus(int lpId, int status) {
		PreparedStatement statement = null;
		ResultSet results = null;
		// status 0 -> Yet to approve/Reject the request
		// Status 1 -> Approved/activated
		// Status 2 -> Rejected
		// Status 3 -> Deactivated
		String sql = "update logistic_partner set status=" + status + " where logistic_partner_id=" + lpId;

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.execute();

			statement.close();

		} catch (Exception exe) {
			return false;
		} finally {

			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return true;

	}
	
	// activate Logistic Partner
		public static synchronized boolean changeEmployeeStatus(int employeeId, int status) {
			PreparedStatement statement = null;
			ResultSet results = null;
			// status 0 -> Yet to approve/Reject the request
			// Status 1 -> Approved/activated
			// Status 2 -> Rejected
			// Status 3 -> Deactivated
			String sql = "update employee set status=" + status + " where employee_id=" + employeeId;

			try {
				Connection conn = DBConnectionProvider.getConnection();
				statement = conn.prepareStatement(sql);
				statement.execute();

				statement.close();

			} catch (Exception exe) {
				return false;
			} finally {

				DBConnectionProvider.closeStatementAndResultSets(statement, results);
			}
			return true;

		}

	public static synchronized List<Customer> fetchAllCustomers(boolean isActiveOnly) {
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Customer> customerList = new ArrayList<Customer>();
		String sql = "select * from customer";

		if (isActiveOnly)
			sql = "select * from customer where status=1 ";
		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			results = statement.executeQuery();

			while (results.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(results.getInt("customer_id"));
				customer.setEmailId(results.getString("email_id"));
				customer.setName(results.getString("name"));
				customer.setPassword(results.getString("password"));
				customer.setPhoneNo(results.getString("phone_no"));
				customer.setStatus(results.getInt("status"));

				customerList.add(customer);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return customerList;

	}

	public static synchronized boolean changeCustomerStatus(int customerId, int status) {
		PreparedStatement statement = null;
		ResultSet results = null;
		// status 0 -> Yet to approve/Reject the request
		// Status 1 -> Approved/activated
		// Status 2 -> Rejected
		// Status 3 -> Deactivated
		String sql = "update customer set status=" + status + " where customer_id=" + customerId;

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.execute();

			statement.close();

		} catch (Exception exe) {
			return false;
		} finally {

			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return true;
	}

	public static synchronized List<Complaint> viewAllComplaints() {
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Complaint> complaintList = new ArrayList<Complaint>();
		String sql = "select * from complaint";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			results = statement.executeQuery();

			while (results.next()) {
				Complaint complaint = new Complaint();
				complaint.setComplaintId(results.getInt("complaint_id"));
				complaint.setComplaint(results.getString("complaint"));
				complaint.setCustomerId(results.getInt("customer_id"));
				complaint.setLogisticPartnerId(results.getInt("logistic_partner_id"));
				complaint.setResponse(results.getString("response"));
				complaint.setStatus(results.getString("status"));

				complaintList.add(complaint);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return complaintList;
	}

	public static synchronized List<Complaint> viewComplaintsByCustomerId(int customerId) {
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Complaint> complaintList = new ArrayList<Complaint>();
		String sql = "select * from complaint where customer_id=?";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, customerId);
			results = statement.executeQuery();

			while (results.next()) {
				Complaint complaint = new Complaint();
				complaint.setComplaintId(results.getInt("complaint_id"));
				complaint.setComplaint(results.getString("complaint"));
				complaint.setCustomerId(results.getInt("customer_id"));
				complaint.setLogisticPartnerId(results.getInt("logistic_partner_id"));
				complaint.setResponse(results.getString("response"));
				complaint.setStatus(results.getString("status"));

				complaintList.add(complaint);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return complaintList;
	}

	/**
	 * 
	 * @param complaintId
	 * @param response
	 * @param status
	 * @return
	 */
	public static synchronized boolean updateComplaints(int complaintId, String response, String status) {
		PreparedStatement statement = null;
		ResultSet results = null;
		// status 0 -> Open
		// Status 1 -> Closed
		String sql = "update complaint set response=?,status=? where complaint_id=?";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, response);
			statement.setString(2, status);
			statement.setInt(3, complaintId);
			statement.execute();

			statement.close();

		} catch (Exception exe) {
			return false;
		} finally {

			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return true;
	}

	public static synchronized boolean createCustomer(Customer customer) {
		PreparedStatement statement = null;
		ResultSet results = null;

		String sql = "insert into customer(name,email_id,phone_no,password,status) values(?,?,?,?,?,?)";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getEmailId());
			statement.setString(3, customer.getPhoneNo());
			statement.setString(4, customer.getPassword());
			statement.setInt(5, customer.getStatus());

			return statement.execute();

		} catch (Exception exe) {
			System.out.println("in exception-" + exe.toString());
			return false;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}

	}

	public static synchronized boolean createComplaint(Complaint complaint) {
		PreparedStatement statement = null;
		ResultSet results = null;

		String sql = "insert into complaint(complaint,customer_id,logistic_partner_id) values(?,?,?)";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, complaint.getComplaint());
			statement.setInt(2, complaint.getCustomerId());
			statement.setInt(3, complaint.getLogisticPartnerId());

			return statement.execute();

		} catch (Exception exe) {
			System.out.println("in exception-" + exe.toString());
			return false;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}

	}

	public static synchronized boolean editCustomer(Customer customer) {
		PreparedStatement statement = null;
		ResultSet results = null;

		String sql = "update customer set phone_no=?,password=?,address=? where customer_id=?";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, customer.getPhoneNo());
			statement.setString(2, customer.getPassword());
			statement.setString(3, customer.getHomeAdress());
			statement.setInt(4, customer.getCustomerId());

			return statement.execute();

		} catch (Exception exe) {
			System.out.println("in exception-" + exe.toString());
			return false;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}

	}

	public static synchronized boolean createWayBill(WayBill wayBill) {
		PreparedStatement statement = null;
		ResultSet results = null;

		String sql = "insert into way_bill(waybill_id,customer_id,logistic_partner_id,product_details,amount,weight,mode_transportation,status,delivery_date,comments) values(?,?,?,?,?,?,?,?,?,?)";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			
			int id = getMaxValue("waybill_id", "way_bill");
			statement.setInt(1, id);
			statement.setInt(2, wayBill.getCustomerId());
			statement.setInt(3, wayBill.getLogisticPartnerId());
			statement.setString(4, wayBill.getProductDetails());
			statement.setFloat(5, wayBill.getAmount());
			statement.setFloat(6, wayBill.getWeight());
			statement.setString(7, wayBill.getModeOfTransportation());
			statement.setString(8, wayBill.getStatus());
			statement.setString(9, wayBill.getDeliveryDate());
			statement.setString(10, wayBill.getComment());

			return statement.execute();

		} catch (Exception exe) {
			System.out.println("in exception-" + exe.toString());
			return false;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}

	}
	
	public static synchronized boolean updateWayBill(WayBill wayBill) {
		PreparedStatement statement = null;
		ResultSet results = null;

		String sql = "update way_bill set status=?,delivery_date=?,comments=? where waybill_id=?) values(?,?,?,?)";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);

			statement.setString(1, wayBill.getStatus());
			statement.setString(2, wayBill.getDeliveryDate());
			statement.setString(3, wayBill.getComment());
			statement.setInt(4, wayBill.getWayBillId());

			return statement.execute();

		} catch (Exception exe) {
			System.out.println("in exception-" + exe.toString());
			return false;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}

	}
	
	public static synchronized boolean createLogisticPartner(LogisticPartner lp) {
		PreparedStatement statement = null;
		ResultSet results = null;

		String sql = "insert into logistic_partner(name,password,main_office_location,phone_no,email_id,owner_name,"
				+ "owner_email_id,owner_phone_no,road_km_rate,sea_km_rate,rail_km_rate,security_question,security_answer,kg_increase_rate_5,"
				+ "kg_increase_rate_10,kg_increase_rate_20,kg_increase_rate_50,kg_increase_rate_50_more) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, lp.getName());
			statement.setString(2, lp.getPassword());
			statement.setString(3, lp.getMainOfficeLocation());
			statement.setString(4, lp.getPhoneNo());
			statement.setString(5, lp.getEmailId());
			statement.setString(6, lp.getOwnerName());
			statement.setString(6, lp.getOwnerEmailId());
			statement.setString(6, lp.getOwnerPhoneNo());
			statement.setFloat(6, lp.getRoadKmRate());
			statement.setFloat(6, lp.getSeaKmRate());
			statement.setFloat(6, lp.getRailKmRate());
			statement.setString(6, lp.getSecurityQuestion());
			statement.setString(6, lp.getSecurityAnswer());
			statement.setFloat(6, lp.getKgIncreaseRate5());
			statement.setFloat(6, lp.getKgIncreaseRate10());
			statement.setFloat(6, lp.getKgIncreaseRate20());
			statement.setFloat(6, lp.getKgIncreaseRate50());
			statement.setFloat(6, lp.getKgIncreaseRate50More());

			return statement.execute();

		} catch (Exception exe) {
			System.out.println("in exception-" + exe.toString());
			return false;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}

	}
	
	public static synchronized boolean editLogisticPartner(LogisticPartner lp) {
		PreparedStatement statement = null;
		ResultSet results = null;

		String sql = "update logistic_partner set password=?,main_office_location=?,phone_no=?,owner_name=?,"
				+ "owner_email_id=?,owner_phone_no=?,road_km_rate=?,sea_km_rate=?,rail_km_rate=?,security_question=?,security_answer=?,kg_increase_rate_5=?,"
				+ "kg_increase_rate_10=?,kg_increase_rate_20=?,kg_increase_rate_50=?,kg_increase_rate_50_more=?,air_km_rate=? where logistic_partner_id=?";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, lp.getPassword());
			statement.setString(2, lp.getMainOfficeLocation());
			statement.setString(3, lp.getPhoneNo());
			statement.setString(4, lp.getOwnerName());
			statement.setString(5, lp.getOwnerEmailId());
			statement.setString(6, lp.getOwnerPhoneNo());
			statement.setFloat(7, lp.getRoadKmRate());
			statement.setFloat(8, lp.getSeaKmRate());
			statement.setFloat(9, lp.getRailKmRate());
			statement.setString(10, lp.getSecurityQuestion());
			statement.setString(11, lp.getSecurityAnswer());
			statement.setFloat(12, lp.getKgIncreaseRate5());
			statement.setFloat(13, lp.getKgIncreaseRate10());
			statement.setFloat(14, lp.getKgIncreaseRate20());
			statement.setFloat(15, lp.getKgIncreaseRate50());
			statement.setFloat(16, lp.getKgIncreaseRate50More());
			statement.setFloat(17,  lp.getAirKmRate());
			statement.setInt(18, lp.getLogisticPartnerId());

			return statement.execute();

		} catch (Exception exe) {
			System.out.println("in exception-" + exe.toString());
			return false;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}

	}
	
	public static synchronized boolean createLogisticPartnerOffice(LogisticPartnerOffice office) {
		PreparedStatement statement = null;
		ResultSet results = null;

		String sql = "insert into logistic_partner_office(logistic_partner_id,office_address,phone_no,email_id,location_id,state) values(?,?,?,?,?,?)";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			
			statement.setInt(2, office.getLogisticPartnerId());
			statement.setString(3, office.getOfficeAddress());
			statement.setString(4, office.getPhoneNo());
			statement.setString(5, office.getEmailId());
			statement.setFloat(6, office.getLocationId());
			return statement.execute();

		} catch (Exception exe) {
			System.out.println("in exception-" + exe.toString());
			return false;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}

	}
	
	public static synchronized List<LogisticPartnerOffice> viewLogisticPartnerOfficesByLPId(int lpId) {
		PreparedStatement statement = null;
		ResultSet results = null;
		List<LogisticPartnerOffice> offices = new ArrayList<LogisticPartnerOffice>();
		String sql = "select * from logistic_partner_office where logistic_partner_id=?";

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, lpId);
			results = statement.executeQuery();

			while (results.next()) {
				LogisticPartnerOffice office = new LogisticPartnerOffice();
				office.setEmailId(results.getString("email_id"));
				office.setLocationId(results.getInt("location_id"));
				office.setLogisticPartnerId(results.getInt("logistic_partner_id"));
				office.setLogisticPartnerOfficeId(results.getInt("lp_office_id"));
				office.setOfficeAddress(results.getString("office_address"));
				office.setPhoneNo(results.getString("phone_no"));
				

				offices.add(office);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return offices;
	}
	
	public static synchronized List<Employee> fetchAllEmployees(int lpId, boolean onlyActive) {

		PreparedStatement statement = null;
		ResultSet results = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		String sql = "select * from employee where logistic_partner_id=?";
		if(onlyActive) {
			sql = "select * from employee where logistic_partner_id=? and status=1";
		}

		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			results = statement.executeQuery();

			while (results.next()) {
				Employee employee = new Employee();

				employee.setEmailId(results.getString("email_id"));
				employee.setLogisticPartnerId(lpId);
				employee.setEmployeeId(results.getInt("employee_id"));
				employee.setName(results.getString("name"));
				employee.setPassword(results.getString("password"));
				employee.setPhoneNo(results.getString("phone_no"));
				employee.setStatus(results.getInt("status"));

				employeeList.add(employee);
			}

		} catch (Exception e) {
			return null;
		} finally {
			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return employeeList;
	}

	/*****************************************************************************************************************************/

	public static synchronized int getMaxValue(String column, String table) {
		int value = 0;
		PreparedStatement statement = null;
		ResultSet results = null;
		String sql = "select max(" + column + ") from " + table;

		// int value = ThreadLocalRandom.current().nextInt(100, 299);
		try {
			Connection conn = DBConnectionProvider.getConnection();
			statement = conn.prepareStatement(sql);
			results = statement.executeQuery();
			if (results.next()) {
				value = results.getInt(1) + 1;
			}

		} catch (Exception exe) {

		} finally {

			DBConnectionProvider.closeStatementAndResultSets(statement, results);
		}
		return value;
	}
}
