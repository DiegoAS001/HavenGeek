package edu.ifsp.dwi.web.acessorio;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.ControllerHelper;

/**
 * Servlet implementation class AcessorioController
 */
@WebServlet("/acessorio/*")

public class AcessorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		try {
			
			Command cmd = getCommand(request);
			cmd.execute(request, response);
			
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, e.getMessage(), e);
			throw new ServletException(e);
		}

	}
	
	private Command getCommand(HttpServletRequest request) {
		String operation = ControllerHelper.extractOperation(request);
		
		Command cmd = null;
		switch (operation) {
			case "/acessorio/listarAcessorio":
				cmd = new ListarAcessorio();
				break;
				
			case "/acessorio/editarAcessorio":
				cmd = new EditarAcessorio();
				break;
		}
		
		return cmd;
	}

}
