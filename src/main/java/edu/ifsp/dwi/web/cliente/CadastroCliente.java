package edu.ifsp.dwi.web.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ifsp.dwi.modelo.Cliente;
import edu.ifsp.dwi.web.Command;
import edu.ifsp.dwi.web.templates.Template;

public class CadastroCliente implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Cliente cliente = new Cliente();
		
		request.setAttribute("cliente", cliente);
		Template.render("cliente/cadastroCliente", request, response);		
	}

}
