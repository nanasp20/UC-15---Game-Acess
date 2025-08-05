
package br.com.senac.gameacess.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JogoDAO {
     public boolean atualizarDisponibilidade(int idJogo, int disponibilidade) {
        String sql = "UPDATE jogo SET disponibilidade = ? WHERE id_jogo = ?";

        try (Connection conn = Conexao.conectar(); // AQUI FOI CORRIGIDO
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, disponibilidade);
            stmt.setInt(2, idJogo);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
