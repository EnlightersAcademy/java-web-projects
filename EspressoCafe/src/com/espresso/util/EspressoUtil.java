package com.espresso.util;

import javax.servlet.http.HttpServletRequest;

public class EspressoUtil {

	public static boolean isValidSession(HttpServletRequest request) {
		if (request.getSession() != null && request.getSession().getAttribute("sessionId") != null) {
			return true;
		}
		return false;
	}

	public static int isResponseSuccess(HttpServletRequest request) {
		String msg = request.getParameter("msg");
		int response = -1;
		switch (msg) {
		case "success":
			response = 0;
			break;
		case "fail":
			response = 1;
			break;
		case "dup":
			response = 2;
			break;
		}

		return response;
	}
}
