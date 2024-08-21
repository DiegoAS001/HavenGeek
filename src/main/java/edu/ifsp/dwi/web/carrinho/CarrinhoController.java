package edu.ifsp.dwi.web.carrinho;

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
import edu.ifsp.dwi.web.jogo.EditarJogo;
import edu.ifsp.dwi.web.jogo.ListarJogo;
import edu.ifsp.dwi.web.jogo.RecuperarJogo;
import edu.ifsp.dwi.web.jogo.SalvarJogo;

/**
 * Servlet implementation class CarrinhoController
 */
@WebServlet("/CarrinhoController")
public class CarrinhoController extends HttpServlet {
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
			case "/jogo/listarJogo":
				cmd = new ListarCarrinho();
				break;
				
		}
		
		return cmd;
	}

}