
package models;

import DB.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cuida da conexão da classe modalidade ao banco de dados
 * @author tiovi
 */
public class ModalidadeDAO {
    Banco banco = new Banco();
    

    //--------------------------------------------------------------------------------------------------------------------//
    
     /**
     * insere modalidade no banco de dados
     * @param modalidade lista modalidade
     * @return retorna booleano, true se a modalidade foi inserida
     */
    public boolean insertModalidadeSql(Modalidade modalidade){
        boolean resultado = false;
        
        Connection conexao = this.banco.getConexao();
        String sql = "INSERT INTO modalidade(nome) VALUES(?)";
        PreparedStatement consulta;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, modalidade.getNome());
            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar modalidade: " + ex.getMessage());
            resultado = false;
        }
        
        return resultado;
    }
    
    /**
     * atualiza o bando de dados da modalidade
     * @param idModalidade modalidade selecionada
     * @param nome nome modalidade
     * @param horarios horario modalidade
     * @return retorna booleano, true se a modalidade foi alterada/atualizada
     */
    public boolean updateModalidadeSql(int idModalidade, String nome, String horarios){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE modalidade SET nome= ?, horarios = ? WHERE idModalidade = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, nome);
            consulta.setString(2, horarios);
            consulta.setInt(3, idModalidade);
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel fazer a atualização dos dados" + ex.getMessage());
        }
        return atualizado; 
    }
    
    /**
     * lista todas as modalidades do banco de dados
     * @return retorna a lista de todas as modalidades presentes no banco de dados
     */
    public List selectModalidadeSql(){
        Connection conexao = this.banco.getConexao();
        List<Modalidade> lista = new ArrayList();
        
        String sql = "SELECT * FROM modalidade";
        ResultSet resultados;
        
        try {
            resultados = conexao.createStatement().executeQuery(sql);
        
            Modalidade objeto;
            while(resultados.next()){
                int idModalidade = Integer.parseInt(resultados.getString("idModalidade"));
                String nomeModalidade = resultados.getString("nome");
                objeto = new Modalidade();
                objeto.setNome(nomeModalidade);
                objeto.setId(idModalidade);
                lista.add(objeto);
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro na consulta ao Banco de dados" + ex.getMessage());
        }
        return lista;
    }
    
    /**
     * deleta a modalidade selecionada
     * @param idModalidade modalidade selecionada
     * @return retorna booleano, true se a modalidade foi deletada
     */
    public boolean deleteModalidadeSql(int idModalidade){
        Connection conexao = this.banco.getConexao();
        String sql = "DELETE FROM modalidade WHERE idModalidade = ?";
        PreparedStatement consulta;
        boolean excluido = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idModalidade);
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) excluido = true;
            
        } catch (SQLException ex) {
            excluido = false;
            System.out.println("Não foi possivel remover a modalidade" + ex.getMessage());
        }
        return excluido;
    }
    
    
    /**
     * Adiciona o instrutor a modalidade no banco de dados
     * @param idModalidade modalidade selecionada
     * @param idInstrutor instrutor selecionadao
     * @return retorna booleano, true se o instrutor foi adicionado a modalidade
     */
    public boolean insertInstrutorModalidadeSql(int idModalidade, int idInstrutor){
        boolean resultado = false;
        
        Connection conexao = this.banco.getConexao();
        String sql = "INSERT INTO modalidade_has_instrutor(idModalidade, idInstrutor) VALUES(?, ?)";
        PreparedStatement consulta;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idInstrutor);
            consulta.setInt(2, idModalidade);

            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            System.out.println("Erro ao adicionar o instrutor: " + ex.getMessage());
            resultado = false;
        }
        
        return resultado;
    }
    
    
    /**
     * atualiza o isntrutor e a modalidade no banco de dados
     * @param idModalidade modalidade selecionada
     * @param idInstrutor instrutor selecionado
     * @return retorna booleano, true se o instrutor e a modalidade foram atualizados
     */
    public boolean updateInstrutorModalidadeSql(int idModalidade, int idInstrutor){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE modalidade_has_instrutor SET idInstrutor= ? WHERE idModalidade= ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idInstrutor);
            consulta.setInt(2, idModalidade);
            
 
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel alterar o instrutor na modalidade: " + ex.getMessage());
        }
        return atualizado;
    }
    
    
     /**
     * 
     * @param idModalidade modalidade selecionada
     * @return retorna booleano, true se a modalidade foi deletada
     */
    public boolean deleteInstrutorModalidadeSql(int idModalidade){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE modalidade_has_instrutor SET idInstrutor= null WHERE idModalidade= ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(2, idModalidade);
            
 
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel remover o instrutor: " + ex.getMessage());
        }
        return atualizado;
    }
    
}
