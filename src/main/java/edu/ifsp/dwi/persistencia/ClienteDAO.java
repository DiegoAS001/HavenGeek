package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.ifsp.dwi.modelo.Cliente;

public class ClienteDAO {
	
	public List<Cliente> listarTodos(){
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id, nome, email, endereco, username FROM cliente;");
			
			while(rs.next()) {
				Cliente cliente = mapearLinha(rs);
				clientes.add(cliente);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public Cliente buscarPeloId(int id) {
		Cliente cliente = null;
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT id, nome, email, endereco, username FROM cliente where id = ?;");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cliente = mapearLinha(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public Cliente salvar(Cliente cliente) {
		
		if(cliente.isNew()) {
			insert(cliente);
		} else {
			update(cliente);
		}
		
		return cliente;
	}
	
	public void delete(Cliente cliente) {
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"DELETE FROM cliente WHERE id = ?;");
			ps.setInt(1, cliente.getId());
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void insert(Cliente cliente) {
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO cliente(nome, email, endereco, username) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getEndereco());
			ps.setString(4, cliente.getUsername());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (!rs.next()) {
				throw new IllegalStateException("Expected key missing.");
			}
			
			int id = rs.getInt(1);
			cliente.setId(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void update(Cliente cliente) {
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE cliente SET nome = ?, email = ?, endereco = ?, username = ? WHERE id = ?;");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getEndereco());
			ps.setString(4, cliente.getUsername());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private Cliente mapearLinha(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		
		cliente.setId(rs.getInt("id"));
		cliente.setNome(rs.getString("nome"));
		cliente.setEmail(rs.getString("email"));
		cliente.setEndereco(rs.getString("endereco"));
		cliente.setUsername(rs.getString("username"));
		
		return cliente;
	}
	
}
