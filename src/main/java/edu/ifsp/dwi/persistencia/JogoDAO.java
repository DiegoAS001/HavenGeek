package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.ifsp.dwi.modelo.Jogo;

public class JogoDAO {

	public List<Jogo> listarTodos(){
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id, nome, tipo_midia, preco, categoria, plataforma FROM jogo;");
			
			while(rs.next()) {
				Jogo jogo = mapearLinha(rs);
				jogos.add(jogo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jogos;
	}
	
	public Jogo buscarPeloId(int id) {
		Jogo jogo = null;
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT id, nome, tipo_midia, preco, categoria, plataforma FROM acessorio WHERE id = ?;");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				jogo = mapearLinha(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jogo;
	}
	
	public Jogo salvar(Jogo jogo){
		
		if (jogo.isNew()) {
			insert(jogo);
		}else {
			update(jogo);
		}
		
		return jogo;
		
	}
	
	public void delete(Jogo jogo)  {
		try (Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM jogo WHERE id = ?;");
			ps.setInt(1, jogo.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}
	}
	
	private void insert(Jogo jogo) {
		
		try(Connection conn = DatabaseConnector.connect()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO jogo(nome, tipo_midia, preco, categoria, plataforma) values (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, jogo.getNome());
			ps.setString(2, jogo.getTipoMidia());
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
				ps.setString(2, jogo.getTipoMidia());
				ps.setDouble(3, jogo.getPreco());
				ps.setString(4, jogo.getCategoria());
				ps.setString(5, jogo.getPlataforma());
				ps.setInt(6, jogo.getId());
				ps.executeUpdate();
				
			} catch (SQLException ex) {
				ex.printStackTrace();
			}		
		
	}
	
	private Jogo mapearLinha(ResultSet rs) throws SQLException {
		Jogo jogo = new Jogo();
		
		jogo.setId(rs.getInt("id"));
		jogo.setNome(rs.getString("nome"));
		jogo.setTipoMidia(rs.getString("tipo_midia"));
		jogo.setPreco(rs.getDouble("preco"));
		jogo.setCategoria(rs.getString("categoria"));
		jogo.setPlataforma(rs.getString("plataforma"));
		
		return jogo;
	}
}
