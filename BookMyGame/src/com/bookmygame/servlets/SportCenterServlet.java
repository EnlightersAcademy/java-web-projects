package com.bookmygame.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmygame.pojo.Location;
import com.bookmygame.pojo.Sport;
import com.bookmygame.pojo.SportCenter;
import com.bookmygame.services.SportCenterOwnerServices;
import com.bookmygame.services.impl.SportCenterOwnerServicesImpl;

@WebServlet({ "/center-register", "/center-login", "/center-sports", "/center-update-sports", "/center-update" })
public class SportCenterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportCenterOwnerServices services = new SportCenterOwnerServicesImpl();

		if ("/BookMyGame/center-register".equals(request.getRequestURI())) {

			SportCenter sc = new SportCenter();
			sc.setName(request.getParameter("name"));
			sc.setSportCenterEmailId(request.getParameter("email"));
			sc.setSportCenterPhNo(Long.parseLong(request.getParameter("phone")));
			sc.setTwoWheelerparkingAvailability(request.getParameter("twowheeleravailable"));
			sc.setFourWheelerParkingAvailability(request.getParameter("fourwheeleravailable"));
			sc.setIdentificationId(request.getParameter("ownerid"));
			sc.setAddress(request.getParameter("address"));
			sc.setPassword((request.getParameter("password")));
			Location loc = services.getLocationByName(request.getParameter("location"));
			if (loc.getLocationId() <= 0) {
				loc.setLocationName(request.getParameter("location"));
			}
			sc.setLocation(loc);
			sc.setOwnerEmailId(request.getParameter("owneremail"));
			sc.setOwnerName(request.getParameter("ownername"));
			sc.setPhoneNo(request.getParameter("ownerphone"));
			sc.setIsActive(1);
			try {
				services.registerSportCenter(sc);
				request.getRequestDispatcher("centerLogin.jsp?regRequest=success").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("centerLogin.jsp?regRequest=fail").forward(request, response);
			}
		}

		if ("/BookMyGame/center-login".equals(request.getRequestURI())) {
			String userName = request.getParameter("email");
			String password = request.getParameter("password");
			SportCenter center = services.loginSportCenter(userName, password);
			if (center == null) {
				request.getRequestDispatcher("centerLogin.jsp?result=fail").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("centerId", center.getSportCenterId());
				request.getRequestDispatcher("centerHome.jsp").forward(request, response);

			}
		}

		if ("/BookMyGame/center-update-sports".equals(request.getRequestURI())) {
			String sportName = request.getParameter("gamename");
			String sportImage = request.getParameter("gameimage");
			String courts = request.getParameter("NoOfCourts");

			int sportCenterId = request.getSession().getAttribute("centerId") != null
					? (Integer) request.getSession().getAttribute("centerId")
					: -1;
			if (sportCenterId < 0) {
				response.sendRedirect("centerLogin.jsp?sessionExpired=true");
			}
			SportCenter center = services.getSportCenterById(sportCenterId);
			Sport newSport = new Sport();
			newSport.setName(sportName);
			newSport.setImage(sportImage);
			newSport.setCourtOrBoardNames(Arrays.asList(courts.split(",")));

			center.getSports().add(newSport);
			try {
				services.updateSportCenterDetails(center);
				request.getRequestDispatcher("centerAddGame.jsp?result=success").forward(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("centerAddGame.jsp?result=fail").forward(request, response);
			}
		}

		if ("/BookMyGame/center-update".equals(request.getRequestURI())) {

			int centerId = (Integer) request.getSession().getAttribute("centerId");
			SportCenter sc = services.getSportCenterById(centerId);

			sc.setSportCenterEmailId(request.getParameter("email"));
			sc.setSportCenterPhNo(Long.parseLong(request.getParameter("phone")));
			sc.setTwoWheelerparkingAvailability(request.getParameter("twowheeleravailable"));
			sc.setFourWheelerParkingAvailability(request.getParameter("fourwheeleravailable"));
			sc.setIdentificationId(request.getParameter("ownerid"));
			sc.setAddress(request.getParameter("address"));
			sc.setPassword(request.getParameter("password"));
			sc.setOwnerEmailId(request.getParameter("owneremail"));
			sc.setOwnerName(request.getParameter("ownername"));
			sc.setPhoneNo(request.getParameter("ownerphone"));
			try {
				services.updateSportCenterDetails(sc);
				request.getRequestDispatcher("centerAccount.jsp?result=success").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("centerAccount.jsp?result=fail").forward(request, response);
			}
		}

	}
}