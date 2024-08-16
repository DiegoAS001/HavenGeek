package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.ifsp.dwi.modelo.Acessorio;



public class AcessorioDAO {
	
	/*
	 * FALTA FINDBYID
	 * 
	 * */
	
	public List<Acessorio> listarTodos(){
		List<Acessorio> acessorios = new ArrayList<Acessorio>();
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id, descricao, preco FROM acessorio;");
			
			while(rs.next()) {
				Acessorio acessorio = mapearLinha(rs);
				acessorios.add(acessorio);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return acessorios;
	}
	
	public Acessorio buscarPeloId(int id) {
		Acessorio acessorio = null;
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT id, descricao, preco FROM acessorio WHERE id = ?;");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				acessorio = mapearLinha(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return acessorio;
	}
	
	public Acessorio salvar(Acessorio acessorio){
		
		if (acessorio.isNew()) {
			insert(acessorio);
		}else {
			update(acessorio);
		}
		
		return acessorio;
		
	}
	
	private void insert(Acessorio acessorio) {
		
		try(Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO acessorio(descricao, preco) values (?,?);", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, acessorio.getDescricao());
			ps.setDouble(2, acessorio.getPreco());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (!rs.next()) {
				throw new IllegalStateException("Expected key missing.");
			}
			
			int id = rs.getInt(1);
			acessorio.setId(id);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	private void update(Acessorio acessorio) {
		
	try (Connection conn = DatabaseConnector.connect()) {
				
				PreparedStatement ps = conn.prepareStatement("UPDATE acessorio SET descricao = ?, preco = ? WHERE id = ?;");
				ps.setString(1, acessorio.getDescricao());
				ps.setDouble(2, acessorio.getPreco());
				ps.setInt(3, acessorio.getId());
				ps.executeUpdate();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}		
		
	}
	
	private Acessorio mapearLinha(ResultSet rs) throws SQLException {
		Acessorio acessorio = new Acessorio();
		
		acessorio.setId(rs.getInt("id_acessorio"));
		acessorio.setDescricao(rs.getString("descricao"));
		acessorio.setPreco(rs.getDouble("preco"));
		
		return acessorio;		
	}
	
	public void delete(Acessorio acessorio)  {
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM acessorio WHERE id = ?;");
			ps.setInt(1, acessorio.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}
	}
	
	
}
