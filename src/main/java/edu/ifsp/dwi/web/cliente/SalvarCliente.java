package edu.ifsp.dwi.web.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Cliente;
import edu.ifsp.dwi.persistencia.ClienteDAO;
import edu.ifsp.dwi.web.Command;

public class SalvarCliente implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Cliente cliente = new Cliente();
		
		if(request.getParameter("id") != null) {
			cliente.setId(Integer.parseInt(request.getParameter("id")));
		}
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setUsername(request.getParameter("username"));
		
		ClienteDAO dao = new ClienteDAO();
		dao.salvar(cliente);
		
		//response.sendRedirect("recuperar?id=" + cliente.getId());
	}
	
	
	
}
