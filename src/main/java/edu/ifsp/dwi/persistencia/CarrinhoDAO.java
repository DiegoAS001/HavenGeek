package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.ifsp.dwi.modelo.Carrinho;
import edu.ifsp.dwi.modelo.Cliente;
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
	
	public Carrinho buscaCarrinhoParaUsuario(Cliente cliente) throws Exception{
		if ( cliente == null) {
			throw new IllegalArgumentException();
		}
		
		Carrinho carrinho = new Carrinho();
		carrinho.setCliente(cliente);
		
		try (Connection conn = DatabaseConnector.connect()) {
			
			String query = "SELECT c.nome,\r\n"
					+ "       j.nome,\r\n"
					+ "       j.id\r\n"
					+ "FROM   carrinho car,\r\n"
					+ "       jogo j,\r\n"
					+ "       cliente c\r\n"
					+ "WHERE  car.id_jogo = j.id\r\n"
					+ "       AND car.id_cliente = c.id\r\n"
					+ "       AND car.id_cliente = ?;";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, cliente.getId());
			ResultSet rs = ps.executeQuery();
			
			JogoDAO dao = new JogoDAO();
			while(rs.next()) {
				int jogoId = rs.getInt("j.id");
				Jogo jogo = dao.buscarPeloId(jogoId);
				carrinho.adicionarJogo(jogo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return carrinho;
	}
	
}
