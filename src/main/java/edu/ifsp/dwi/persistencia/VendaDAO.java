package edu.ifsp.dwi.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.ifsp.dwi.modelo.Venda;

public class VendaDAO {

        public List<Venda> listarTodas() {
            List<Venda> vendas = new ArrayList<Venda>();

            try (Connection conn = DatabaseConnector.connect()) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT id FROM venda;");

                while (rs.next()) {
                    Venda venda = buscarPeloId(rs.getInt("id"));
                    vendas.add(venda);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return vendas;
        }

        public Venda buscarPeloId(int id) {
            Venda venda = null;

            try (Connection conn = DatabaseConnector.connect()) {

                PreparedStatement ps = conn.prepareStatement(
                        "SELECT id FROM venda WHERE id = ?;");
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    venda = new Venda();
                    venda.setId(rs.getInt("id"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return venda;
        }

        public Venda salvar(Venda venda) {

            if (venda.isNew()) {
                insert(venda);
            } 
            return venda;

        }


        private void insert(Venda venda) {

            try (Connection conn = DatabaseConnector.connect()) {

                PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO venda (ID_CARRINHO) VALUES (?);", Statement.RETURN_GENERATED_KEYS);


                ps.execute();

                ResultSet rs = ps.getGeneratedKeys();
                if (!rs.next()) {
                    throw new IllegalStateException("Expected key missing.");
                }

                int id = rs.getInt(1);
                venda.setId(id);      

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
