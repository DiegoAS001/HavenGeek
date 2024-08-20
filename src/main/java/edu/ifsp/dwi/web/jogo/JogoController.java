package edu.ifsp.dwi.web.jogo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======

>>>>>>> b145587 (Resolveno o erro no JogoController)
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.ControllerHelper;

/**
 * Servlet implementation class AcessorioController
 */
<<<<<<< HEAD
@WebServlet("/acessorio/*")
=======
@WebServlet("/jogo/*")
>>>>>>> b145587 (Resolveno o erro no JogoController)

public class JogoController extends HttpServlet {
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
<<<<<<< HEAD
			case "/acessorio/listarAcessorio":
				cmd = new ListarJogo();
				break;
				
			case "/acessorio/editarAcessorio":
=======
			case "/jogo/listarJogo":
				cmd = new ListarJogo();
				break;
				
			case "/jogo/editarJogo":
>>>>>>> b145587 (Resolveno o erro no JogoController)
				cmd = new EditarJogo();
				break;
		}
		
		return cmd;
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> b145587 (Resolveno o erro no JogoController)
