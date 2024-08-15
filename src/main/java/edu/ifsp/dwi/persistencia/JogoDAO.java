package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.ifsp.dwi.modelo.Jogo;

public class JogoDAO {

	/*
	 * FALTA FINDBYID
	 * FALTA O FINDALL
	 * */
	
	public Jogo salvar(Jogo jogo){
		
		if (jogo.isNew()) {
			insert(jogo);
		}else {
			update(jogo);
		}
		
		return jogo;
		
	}
	
	private void insert(Jogo jogo) {
		
		try(Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO jogo(nome, tipo_midia, preco, categoria, plataforma) values (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, jogo.getNome());
			ps.setString(2, jogo.getMidia());
			ps.setDouble(3, jogo.getPreco());
			ps.setString(4, jogo.getCategoria());
			ps.setString(5, jogo.getPlataforma());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (!rs.next()) {
				throw new IllegalStateException("Expected key missing.");
			}
			
			int id = rs.getInt(1);
			jogo.setId(id);
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	private void update(Jogo jogo) {
		
	try (Connection conn = DatabaseConnector.connect()) {
				
				PreparedStatement ps = conn.prepareStatement("UPDATE jogo SET nome = ?, tipo_midia = ?, preco = ?, categoria = ? , plataforma = ? WHERE id = ?;");
				ps.setString(1, jogo.getNome());
				ps.setString(2, jogo.getMidia());
				ps.setDouble(3, jogo.getPreco());
				ps.setString(4, jogo.getCategoria());
				ps.setString(5, jogo.getPlataforma());
				ps.setInt(6, jogo.getId());
				ps.executeUpdate();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}		
		
	}
	
	public void delete(Jogo jogo)  {
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM jogo WHERE id = ?;");
			ps.setInt(1, jogo.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}
	}
}
