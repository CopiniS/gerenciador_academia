
package models;

import DB.Banco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cuida da conexão da classe plano ao banco de dados
 * @author tiovi
 */
public class PlanoDAO {
    Banco banco = new Banco();

    /**
     * mostra a lista com todos os planos
     */
    public void verPlanos(){
        List<Plano> lista = selectPlanoSql();
        for(Plano plano : lista){
            System.out.println(plano.toString());
        }      
    }
    //-------------------------------------------------------------------------------------------------------------------------//
    //SQL
    
    /**
     * insere o plano à lista de planos
     * @param plano lista com todos os planos
     * @return retorna o id do plano inserido
     */
    public int insertPlanoSql(Plano plano){
        int idPlano = -1;
        
        Connection conexao = this.banco.getConexao();
        String sql = "INSERT INTO plano(nome, valor, tempoAtivacao) VALUES(?, ?, ?)";
        PreparedStatement consulta;
        
        try {
            consulta = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            consulta.setString(1, plano.getNome());
            consulta.setFloat(2, plano.getValor());
            consulta.setInt(3, plano.getTempoAtivacao());
            consulta.execute();
            ResultSet key = consulta.getGeneratedKeys();
            if (key.next()) { // Mova o cursor para a primeira linha do ResultSet
                idPlano = key.getInt(1);
            } 
            else {
                System.out.println("Nenhuma chave gerada após a execução da consulta.");
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar plano: " + ex.getMessage());
            
        }
        return idPlano;
    }
    
    /**
     * insere plano na modalidade ao banco de dados
     * @param idPlano plano selecionado
     * @param listaModalidadesSelecionadas lista das modalidades
     * @return retorna booleano, true se o plano for inserido na modalidade
     */
    public boolean insertPlanoHasModalidade(int idPlano, List<Modalidade> listaModalidadesSelecionadas){
        boolean resultado = false;
        Connection conexao = this.banco.getConexao();
        for(Modalidade m : listaModalidadesSelecionadas){
            String sql = "INSERT INTO plano_has_modalidade(idPlano, idModalidade) VALUES(?, ?)";
            PreparedStatement consulta;

            try {
                consulta = conexao.prepareStatement(sql);
                consulta.setInt(1, idPlano);
                consulta.setFloat(2, m.getId());
                consulta.execute();
                resultado = true;

            } catch (SQLException ex) {
                System.out.println("Erro ao cadastrar plano: " + ex.getMessage());
                resultado = false;
            }
        }
        return resultado;
    }
    
    /**
     * deleta o plano selecionado da modalidade
     * @param idPlano plano selecionado
     * @param listaModalidadesAntigas lista das modalidades
     * @return retorna booleano, true se o plano foi deletado da modalidade
     */
    public boolean deletePlanohasModalidade(int idPlano, List<Modalidade> listaModalidadesAntigas){
        boolean excluido = false;
        Connection conexao = this.banco.getConexao();
        
        for(int i=0; i<listaModalidadesAntigas.size(); i++){
            String sql = "DELETE FROM plano_has_modalidade WHERE idPlano = ? AND idModalidade = ?";
            PreparedStatement consulta;


            try {
                consulta = conexao.prepareStatement(sql);
                consulta.setInt(1, idPlano);
                consulta.setInt(2, listaModalidadesAntigas.get(i).getId());

                int linhasAtualizadas = consulta.executeUpdate();
                if(linhasAtualizadas > 0) excluido = true;

            } catch (SQLException ex) {
                excluido = false;
                System.out.println("Não foi possivel excluir o plano" + ex.getMessage());
            }
        }
        return excluido;             
    }
    
    /**
     * atualiza todas as informacoes do plano
     * @param plano 
     * @return retorna booleano, true se o plano foi atualizado
     */
    public boolean updatePlanoSql(Plano plano){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE plano SET valor = ?, tempoAtivacao = ? WHERE idPlano= ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setFloat(1, plano.getValor());
            consulta.setInt(2, plano.getTempoAtivacao());
            consulta.setInt(3, plano.getId());
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel fazer a atualização dos dados" + ex.getMessage());
        }
        return atualizado; 
    }
    
    /**
     * retorna lista com todos os planos presente no banco de dados
     * @return retorna a lista dos planos
     */
    public List selectPlanoSql(){
        Connection conexao = this.banco.getConexao();
        List<Plano> lista = new ArrayList();
        
        String sql = "SELECT * FROM plano";
        ResultSet resultados;
        
        try {
            resultados = conexao.createStatement().executeQuery(sql);
        
            Plano objeto;
            while(resultados.next()){
                int idPlano = resultados.getInt("idPlano");
                String nomePlano = resultados.getString("nome");
                float valorPlano = resultados.getFloat("valor");
                int tempoAtivacaoPlano = resultados.getInt("tempoAtivacao");
                
                objeto = new Plano();
                objeto.setNome(nomePlano);
                objeto.setValor(valorPlano);
                objeto.setTempoAtivacao(tempoAtivacaoPlano);
                objeto.setId(idPlano);
                lista.add(objeto);
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro na consulta ao Banco de dados" + ex.getMessage());
        }
        return lista;
    };
    
    /**
     * deleta o plano selecionado do banco de dados
     * @param idPlano plano selecionado
     * @return retorna booleano, true se o plano foi deletado do banco de dados
     */
    public boolean deletePlanoSql(int idPlano){
        Connection conexao = this.banco.getConexao();
        String sql = "DELETE FROM plano WHERE idPlano = ?";
        PreparedStatement consulta;
        boolean excluido = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idPlano);
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) excluido = true;
            
        } catch (SQLException ex) {
            excluido = false;
            System.out.println("Não foi possivel excluir o plano" + ex.getMessage());
        }
        return excluido;         
    }
    
    /**
     * atualiza o plano ao cliente selecionado
     * @param idPlano plano selecionado
     * @param idCliente cliente selecionado
     * @return retorna booleano, true se o plano foi adicionado ao cliente
     */
    public boolean updateClienteIdPlano(int idPlano, int idCliente){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE Cliente SET idPlano = ?, dataInicioPlano = ? WHERE idCliente = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        LocalDate dataHoje = LocalDate.now();
        
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idPlano);
            consulta.setDate(2, Date.valueOf(dataHoje));
            consulta.setInt(3, idCliente);
 
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel adicionar o plano ao cliente" + ex.getMessage());
        }
        return atualizado;       
    }
    
    /**
    * deleta o plano ao cliente selecionado
    * @param idPlano plano selecionado
    * @param idCliente cliente selecionado
    * @return retorna booleano, true se o plano foi deletado ao cliente
    */
    public boolean updateDeleteClienteIdPlano(int idPlano, int idCliente){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE Cliente SET idPlano = ?, dataInicioPlano = ? WHERE idCliente = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, null);
            consulta.setString(2,  null);
            consulta.setInt(3, idCliente);
 
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel remover o cliente do plano" + ex.getMessage());
        }
        return atualizado;          
    }
    
    /**
     * retorna a lista de modalidade presente no plano selecionado
     * @param idPlano plano selecionado
     * @return retorna a lista com todas as modalidades presente no plano selecionado
     * @throws SQLException 
     */
    public List retornaListaDeModalidadesDoPlano(int idPlano) throws SQLException{
        Connection conexao = this.banco.getConexao();
        List<Modalidade> lista = new ArrayList<>();
        PreparedStatement consulta = null;
        ResultSet resultados;
        String sql = "SELECT m.nome, m.idModalidade FROM plano JOIN plano_has_modalidade AS p ON plano.idPlano = p.idPlano JOIN modalidade AS m ON m.idModalidade = p.idModalidade WHERE plano.idPlano = ?";
        
        consulta = conexao.prepareStatement(sql);
        consulta.setInt(1, idPlano);
        resultados = consulta.executeQuery();
        
        
        try {
        
            Modalidade objeto;
            while(resultados.next()){
                String nomeModalidade = resultados.getString("m.nome");
                int idModalidade = resultados.getInt("m.idModalidade");
                
                objeto = new Modalidade();
                objeto.setNome(nomeModalidade);
                objeto.setId(idModalidade);
                
                System.out.println("modalidade: " + objeto.getNome());
                System.out.println("id: " + objeto.getId());
                
                lista.add(objeto);
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro na consulta ao Banco de dados" + ex.getMessage());
        }
        
        return lista;
    }
    
}
