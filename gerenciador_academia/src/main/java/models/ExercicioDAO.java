
package models;

import DB.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cuida da conexão da classe exercicio ao banco de dados
 * @author tiovi
 */
public class ExercicioDAO {
    Banco banco = new Banco();
 
    /**
     * Mostra a lista de todos os exercicios adicionados
     */
    public void mostraExercicios()  {
        List<Exercicio> lista = selectExerciciosSql();
        for(Exercicio exercicio : lista){
            System.out.println(exercicio.toString());
        }
    }
    
    //------------------------------------------------- SQL ----------------------------------------------------------------------//
    
    /**
     * Insere nome e musculo aos exercicios no banco de dados
     * @param exercicio - classe do exercicio com nome e musculo a ser adicionado
     * @return retorna booleano, true se o exercicio foi inserido
     */
    public boolean insertExercicioSql(Exercicio exercicio){
        boolean resultado = false;
        
        Connection conexao = this.banco.getConexao();
        String sql = "INSERT INTO exercicio(nome, musculaturaAfetada) VALUES(?, ?)";
        PreparedStatement consulta;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, exercicio.getNome());
            consulta.setString(2, exercicio.getMusculaturaAfetada());
            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar cliente: " + ex.getMessage());
            resultado = false;
        }
        
        return resultado;
    }
    
    /**
     * Retorna a lista completa de exercicios
     * @return retorna a lista de todos os exercicios contido no banco de dados com todas as informações
     */
    public List selectExerciciosSql(){
        Connection conexao = this.banco.getConexao();
        List<Exercicio> lista = new ArrayList();
        
        String sql = "SELECT * FROM exercicio";
        ResultSet resultados;
        
        try {
            resultados = conexao.createStatement().executeQuery(sql);
        
            Exercicio objeto;
            while(resultados.next()){
                int idExercicio = resultados.getInt("idExercicio");
                String nomeExercicio = resultados.getString("nome");
                String musculaturaAfetadaExercicio = resultados.getString("musculaturaAfetada");
                objeto = new Exercicio();
                objeto.setNome(nomeExercicio);
                objeto.setMusculaturaAfetada(musculaturaAfetadaExercicio);
                objeto.setId(idExercicio);
                lista.add(objeto);
            }
    }
        catch (SQLException ex) {
            System.out.println("Erro na consulta ao Banco de dados" + ex.getMessage());
        }
        return lista;
    }
    
    /**
     * atualiza/altera o exercicio selecionado
     * @param idExercicio id do exercicio selecionado
     * @param nome nome do exercicio
     * @param musculaturaAfetada musculo do exercicio
     * @return retorna booleano, true se o exercicio foi alterado
     */
    public boolean updateExercicioSql(int idExercicio, String nome, String musculaturaAfetada){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE exercicio SET nome = ?, musculaturaAfetada = ? WHERE idExercicio = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, nome);
            consulta.setString(2, musculaturaAfetada);
            consulta.setInt(3, idExercicio);
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel fazer a atualização dos dados" + ex.getMessage());
        }
        return atualizado; 
    }
    
    /**
     * deleta o exercicio selecionado do banco de dados
     * @param idExercicio id do exercicio selecionado
     * @return retorna booleano, true se o exercicio foi deletado
     */
    public boolean delteExercicioSql(int idExercicio){
        Connection conexao = this.banco.getConexao();
        String sql = "DELETE FROM exercicio WHERE idExercicio = ?";
        PreparedStatement consulta;
        boolean excluido = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idExercicio);
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) excluido = true;
            
        } catch (SQLException ex) {
            excluido = false;
            System.out.println("Não foi possivel remover o exercicio" + ex.getMessage());
        }
        return excluido;
    }
}
