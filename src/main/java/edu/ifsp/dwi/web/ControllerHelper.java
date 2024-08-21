package edu.ifsp.dwi.web;

import javax.servlet.http.HttpServletRequest;

public class ControllerHelper {
	public static String extractOperation(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int pos = uri.indexOf(contextPath) + contextPath.length();
		String op = uri.substring(pos);	
		
		System.out.println("URI: " + uri);
		System.out.println("contextPath: " + contextPath);
		System.out.println("URI position: " + op);
		
		return op;
	}
}
