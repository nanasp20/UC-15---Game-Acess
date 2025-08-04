
package br.com.senac.gameacess.util;

import br.com.senac.gameacess.model.Jogo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioJogoBD {
    public static List<Jogo> listarTodos() {
        List<Jogo> jogos = new ArrayList<>();
        String sql = "SELECT * FROM jogo";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id_jogo"));
                jogo.setTitulo(rs.getString("titulo"));
                jogo.setGenero(rs.getString("genero"));
                jogo.setDesenvolvedora(rs.getString("desenvolvedora"));
                jogo.setDistribuidora(rs.getString("distribuidora"));
                jogo.setClassificacao(rs.getString("classificacao"));
                jogo.setDataLancamento(rs.getString("data_lancamento"));
                jogo.setDescricao(rs.getString("descricao"));
                jogo.setImagem(rs.getString("imagem")); 
               
                jogos.add(jogo);
            }

        } catch (Exception e) {
            System.err.println("Erro ao listar jogos: " + e.getMessage());
            e.printStackTrace();
        }

        return jogos;
    }
}
