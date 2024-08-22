package edu.ifsp.dwi.web.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Cliente;
import edu.ifsp.dwi.persistencia.ClienteDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;

public class RecuperarCliente implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int id = Integer.parseInt(request.getParameter("id"));
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = dao.buscarPeloId(id);
		request.setAttribute("cliente", cliente);
		Template.render("cliente/detalharCliente", request, response);
		
	}

}
