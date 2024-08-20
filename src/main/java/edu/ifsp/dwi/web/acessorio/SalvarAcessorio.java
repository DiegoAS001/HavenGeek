package edu.ifsp.dwi.web.acessorio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ifsp.dwi.persistencia.AcessorioDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.modelo.Acessorio;
import edu.ifsp.dwi.web.templates.Template;

@WebServlet("/SalvarAcessorio")

public class SalvarAcessorio implements Command {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Acessorio acessorio = new Acessorio();
		/*if (!validate(request)) {
			request.setAttribute("acessorio", acessorio);
			Template.render("acessorio/editarAcessorio", request, response);
			return;
		}*/
				
		
		if (request.getParameter("id") != null) {
			acessorio.setId(Integer.parseInt(request.getParameter("id")));
		}
		acessorio.setDescricao(request.getParameter("descricao"));
		acessorio.setPreco(Double.parseDouble(request.getParameter("preco")));
		
		AcessorioDAO dao = new AcessorioDAO();
		dao.salvar(acessorio);
		response.sendRedirect("recuperar?id=" + acessorio.getId());	
		
		Template.render("acessorio/listarAcessorio", request, response);	
	}
  

}
