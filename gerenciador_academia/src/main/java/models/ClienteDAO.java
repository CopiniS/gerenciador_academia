
package models;

import DB.Banco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cuida da conecção da classe cliente ao banco de dados
 * @author gabri
 */

public class ClienteDAO{
    Banco banco = new Banco();
    
    /**
     * Faz um select no banco de dados
     * @return lista de todos os cliente cadastrados no banco
     */
    public List mostraClientes(){
        Connection conexao = this.banco.getConexao();
        List<Cliente> lista = new ArrayList();
        ResultSet resultados = null;
        Cliente cliente = new Cliente();
        Plano plano = new Plano();
        Treino treino = new Treino();
        
        
        String sql = "SELECT c.nome, c.cpf, c.dataNascimento, e.rua, e.cep, e.bairro, e.numero, p.idPlano, p.nome, t.idTreino, t.nome FROM cliente AS c " +
                 "LEFT JOIN enderecoCliente AS e ON e.idEnderecoCliente = c.idendereco " +
                 "LEFT JOIN plano AS p ON p.idPlano = c.idPlano " +
                 "LEFT JOIN treino AS t ON t.idTreino = c.idTreino ";
        
    try {
        resultados = conexao.createStatement().executeQuery(sql);
        
        while(resultados.next()) {
            cliente.setNome(resultados.getString("c.nome"));
            cliente.setCpf(resultados.getString("c.cpf"));
            cliente.setDataNascimento(resultados.getDate("c.dataNascimento"));
            cliente.setCep(resultados.getString("e.cep"));
            cliente.setRua(resultados.getString("e.rua"));
            cliente.setBairro(resultados.getString("e.bairro"));
            cliente.setNumero(resultados.getString("e.numero"));
            
            plano.setId(resultados.getInt("p.idPlano"));
            plano.setNome(resultados.getString("p.nome"));
            cliente.setPlano(plano);
            
            treino.setId(resultados.getInt("t.idTreino"));
            treino.setNome(resultados.getString("t.nome"));
            cliente.setTreino(treino);
            
            lista.add(cliente);
        }
    } catch (SQLException ex) {
        System.out.println("Erro na consulta ao Banco de dados: " + ex.getMessage());
        } 
    return lista;
    }
    
    /**
     * Insere cliente no BD
     * @param cliente Cliente que deseja inserir 
     * @param idEndereco chave do enderecoCliente que será usado assossiar o Endereco com o cliente
     * @return retorna resultado = true se a inserção foi feita corretamente
     */
    public boolean insertClienteSql(Cliente cliente, String idEndereco){
        boolean resultado = false;
        Connection conexao = this.banco.getConexao();
        
            String sql = "INSERT INTO cliente(nome, cpf, dataNascimento, idEndereco, idPlano, dataInicioPlano, idTreino) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta;
            LocalDate dataHoje = LocalDate.now();
            String idPlano = String.valueOf(cliente.getPlano().getId());
            
            try {
                consulta = conexao.prepareStatement(sql);
                consulta.setString(1, cliente.getNome());
                consulta.setString(2, cliente.getCpf());
                consulta.setDate(3, cliente.getDataNascimento());
                consulta.setObject(4, idEndereco);
                consulta.setObject(5, idPlano);
                if(idPlano != null){
                    consulta.setDate(6, Date.valueOf(dataHoje));
                }
                else{
                    consulta.setObject(6, null);
                }
                consulta.setObject(7, cliente.getTreino().getId());
                consulta.execute();
                resultado = true;

            } catch (SQLException ex) {
                System.out.println("Erro ao cadastrar cliente: " + ex.getMessage());
                resultado = false;
            }
            return resultado;
    }
    
    
    /**
     * Insere endereço do cliente no BD
     * @param cliente cliente que terá o endereço inserido
     * @return id do Endereço que acabou de ser adicionado
     */
    public String insertEnderecoClienteSql(Cliente cliente){
        String idEndereco = null;
        
        Connection conexao = this.banco.getConexao();
        String sql = "INSERT INTO enderecoCliente(cep, rua, bairro, numero) VALUES(?, ?, ?, ?)";
        PreparedStatement consulta;
        
        try {
            consulta = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            consulta.setObject(1, cliente.getCep());
            consulta.setObject(2, cliente.getRua());
            consulta.setObject(3, cliente.getBairro());
            consulta.setObject(4, cliente.getNumero());
            consulta.execute();
            ResultSet key = consulta.getGeneratedKeys();
            if (key.next()) { // Mova o cursor para a primeira linha do ResultSet
                idEndereco = key.getString(1);
            } 
            else {
                System.out.println("Nenhuma chave gerada após a execução da consulta.");
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar cliente: " + ex.getMessage());
            
        }
        return idEndereco;
    }
    
    
    /**
     * Faz a alteração do idEndereço do cliente selecionado no BD
     * @param idCliente id do cliente que deseja alterar o endereço
     * @param idEndereco id do endereço atualizado
     * @return atualzado = true se o update foi feito corretamente
     */
    public boolean updateIdEnderecoNoCliente(int idCliente, int idEndereco){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE cliente SET idEndereco = ? WHERE idCliente = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try { 
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idEndereco);
            consulta.setInt(2, idCliente);
            
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel fazer a atualização dos dados" + ex.getMessage());
        }
        return atualizado;
    }
    
    
    /**
     * Faz a alteração do endereço no BD
     * @param cliente cliente que terá o endereço alterado
     * @param idEndereco endereço que será atualizado
     * @return atualizado = true se a alteração for feita corretamente
     */
    public boolean updateEnderecoClienteSql(Cliente cliente, int idEndereco){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE enderecoCliente SET cep = ?, rua = ?, bairro = ?, numero = ? WHERE idEnderecoCliente = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try { 
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, cliente.getCep());
            consulta.setString(2, cliente.getRua());
            consulta.setString(3, cliente.getBairro());
            consulta.setString(4, cliente.getNumero());
            consulta.setInt(5, idEndereco);
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel fazer a atualização dos dados" + ex.getMessage());
        }
        return atualizado;
    }
   
    /**
     * Faz a busca e mostra o idEndereco do Cliente selecionado
     * @param idCliente id do cliente selecionado
     * @return retorna idEndereco do cliente como uma string porque pode ser null
     */
    public String selectIdEnderecoCliente(int idCliente){
        Connection conexao = this.banco.getConexao();
        PreparedStatement consulta = null;
        String idEnderecoCliente = null;
        String sql = "SELECT idEndereco FROM cliente WHERE idCliente = ?";
        ResultSet resultados;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idCliente);
            resultados = consulta.executeQuery();
        
             Cliente objeto;
            while(resultados.next()){
                idEnderecoCliente = resultados.getString("idEnderecoCliente");
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro na consulta ao Banco de dados" + ex.getMessage());
        }
        return idEnderecoCliente;
    }
    
    
    /**
     * Faz a atualização do idPlano 
     * @param cliente 
     * @return 
     */
    public boolean updateClienteIdPlano(Cliente cliente){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE Cliente SET idPlano = ?, dataInicioPlano = ? WHERE idCliente = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        LocalDate dataHoje = LocalDate.now();
        
        
        try {
            consulta = conexao.prepareStatement(sql);
            if(cliente.getPlano() != null){
                consulta.setInt(1, cliente.getPlano().getId());
            }
            else{
                consulta.setObject(1, null);
            }
            if(cliente.getPlano() != null){
                consulta.setDate(2, Date.valueOf(dataHoje));
            }
            else{
                consulta.setObject(2, null);
            }
            consulta.setInt(3, cliente.getId());
 
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel adicionar o plano ao cliente" + ex.getMessage());
        }
        return atualizado;
    }
    
       /**
     * Faz a atualização do idTreino do cliente
     * @param cliente
     * @return booleano confirmando se o treino do cliente foi atualizado
     */   
    public boolean updateClienteIdTreino(Cliente cliente){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE Cliente SET idTreino = ? WHERE idCliente = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            if(cliente.getTreino() != null){
                consulta.setInt(1, cliente.getTreino().getId());
            }
            else{
                consulta.setObject(1, null);
            }
            consulta.setInt(2, cliente.getId());
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel adicionar o treino ao cliente" + ex.getMessage());
        }
        return atualizado;
    }
        
    /**
     * Deleta o idTreino do cliente selecionado
     * @param idCliente - id do Cliente selecionado
     * @return booleano confirmando, true se o treino do cliente foi deletado
     */
    public boolean deleteClienteIdTreino(int idCliente){
        Connection conexao = this.banco.getConexao();
        String sql = "UPDATE Cliente SET idTreino = ? WHERE idCliente = ?";
        PreparedStatement consulta;
        boolean atualizado = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, null);
            consulta.setInt(2, idCliente);
 
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) atualizado = true;
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não foi possivel remover o treino do cliente" + ex.getMessage());
        }
        return atualizado;
    }
    
      /**
     * Deleta o clietne selecionado do banco de dados
     * @param idCliente - id do Cliente selecionado
     * @return booleano confirmando, true se o cliente foi deletado do banco de dados
     */
    public boolean deletaClienteSql(int idCliente){
        Connection conexao = this.banco.getConexao();
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        PreparedStatement consulta;
        boolean excluido = false;
        
        try {
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, idCliente);
 
            
            int linhasAtualizadas = consulta.executeUpdate();
            if(linhasAtualizadas > 0) excluido = true;
        } catch (SQLException ex) {
            excluido = false;
            System.out.println("Não foi possivel remover o treino do cliente" + ex.getMessage());
        }
        return excluido;
    }
       /**
     * Retorna a lista completa de todos os CPFs dos clientes adicionados
     * @return retorna a lista de todos os cpfs contidos no sistema
     */
    public List retonaListaDeCPFS(){
        Connection conexao = this.banco.getConexao();
        List lista = new ArrayList();
        
        String sql = "SELECT cpf FROM cliente";
        ResultSet resultados;
        
        try {
            resultados = conexao.createStatement().executeQuery(sql);
            
            while(resultados.next()){
                String cpfCliente = resultados.getString("cpf");

                lista.add(cpfCliente);
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro na consulta ao Banco de dados" + ex.getMessage());
        }
        return lista;
    }
     
    /**
     * Busca através do CPF algum cliente, ou seja,
     * faz a comparação do CPF selecionado com todos do Banco de Dados até encontrar o Cliente pertencente ao CPF.
     * @param cpf - cpf selecionado na ComboBox
     * @return retorna o cliente encontrado pelo cpf selecionado
     * @throws ParseException
     * @throws SQLException 
     */
    public Cliente retornaClientePeloCpf(String cpf) throws ParseException, SQLException {
    Connection conexao = this.banco.getConexao();
    PreparedStatement consulta = null;
    ResultSet resultados = null;
    Cliente cliente = new Cliente();
    Plano plano = new Plano();
    Treino treino = new Treino();
    
    String sql = "SELECT c.idCliente, c.nome, c.dataNascimento, c.dataInicioPlano, e.rua, e.cep, e.bairro, e.numero, p.idPlano, p.nome, t.idTreino, t.nome FROM cliente AS c " +
                 "LEFT JOIN enderecoCliente AS e ON e.idEnderecoCliente = c.idendereco " +
                 "LEFT JOIN plano AS p ON p.idPlano = c.idPlano " +
                 "LEFT JOIN treino AS t ON t.idTreino = c.idTreino " +
                 "WHERE c.cpf = ?";
    
    try {
        consulta = conexao.prepareStatement(sql);
        consulta.setString(1, cpf);
        resultados = consulta.executeQuery();
        
        if (resultados.next()) {
            cliente.setId(resultados.getInt("c.idCliente"));
            cliente.setNome(resultados.getString("c.nome"));
            cliente.setCpf(cpf);
            if(resultados.getString("c.dataInicioPlano") != null){
                cliente.setDataInicioPlano(resultados.getDate("c.dataInicioPlano").toLocalDate());
            }
            cliente.setDataNascimento(resultados.getDate("c.dataNascimento"));
            cliente.setCep(resultados.getString("e.cep"));
            cliente.setRua(resultados.getString("e.rua"));
            cliente.setBairro(resultados.getString("e.bairro"));
            cliente.setNumero(resultados.getString("e.numero"));
            
            plano.setId(resultados.getInt("p.idPlano"));
            plano.setNome(resultados.getString("p.nome"));
            cliente.setPlano(plano);
            
            treino.setId(resultados.getInt("t.idTreino"));
            treino.setNome(resultados.getString("t.nome"));
            cliente.setTreino(treino);
            
        }
    } catch (SQLException ex) {
        System.out.println("Erro na consulta ao Banco de dados: " + ex.getMessage());
        }
    return cliente;
}

        
}
