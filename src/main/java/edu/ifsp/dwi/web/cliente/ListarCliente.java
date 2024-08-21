package edu.ifsp.dwi.web.cliente;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Cliente;
import edu.ifsp.dwi.persistencia.ClienteDAO;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;

@WebServlet("/ListarCliente")
public class ListarCliente implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> clientes = dao.listarTodos();
		request.setAttribute("clientes", clientes);
		Template.render("cliente/listarCliente", request, response);		

	}

}
