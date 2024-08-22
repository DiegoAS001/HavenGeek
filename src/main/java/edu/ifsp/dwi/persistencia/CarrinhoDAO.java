package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.ifsp.dwi.modelo.Carrinho;
import edu.ifsp.dwi.modelo.Jogo;

public class CarrinhoDAO {
	
	public Carrinho save(Carrinho carrinho) {
        try (Connection conn = DatabaseConnector.connect()) {
            try {

                // Deletar itens existentes do carrinho
                PreparedStatement ps = conn.prepareStatement("DELETE FROM CARRINHO WHERE ID_CLIENTE = ?;");
                ps.setInt(1, carrinho.getCliente().getId());
                ps.executeUpdate();

                // Inserir itens do carrinho
                ps = conn.prepareStatement("INSERT INTO CARRINHO (ID_CLIENTE, ID_JOGO) VALUES (?, ?);");
                for (Jogo jogo : carrinho.getJogos()) {
                    ps.setInt(1, carrinho.getCliente().getId());
                    ps.setInt(2, jogo.getId());
                    ps.executeUpdate();
                }

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException e) {
        	 e.printStackTrace();
        }

        return carrinho;
    }
	
	public List<Carrinho> listarTodos(){
		List<Carrinho> carrinhos = new ArrayList<Carrinho>();
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT id, id_cliente, id_jogo FROM carrinho;");
			
			while(rs.next()) {
				Carrinho carrinho = mapearLinha(rs);
				carrinhos.add(carrinho);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return carrinhos;
	}
	
	
	private Carrinho mapearLinha(ResultSet rs) throws SQLException {
		Carrinho carrinho = new Carrinho();
		
		carrinho.setId(rs.getInt("id"));
		
		return carrinho;		
	}	
}
