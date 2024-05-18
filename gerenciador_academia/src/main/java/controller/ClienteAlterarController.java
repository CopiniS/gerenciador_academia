
package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Plano;
import models.Treino;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import models.Exercicio;
import models.TreinoDAO;

/**
 * Faz o controle entre a tela clienteAlterar e o backend
 * @author gabri
 */
public class ClienteAlterarController {
    
    
    public ClienteAlterarController() {
    }
    
    /**
     * Chama alteraEndereco, chama alteraTreino, chama alteraPlano e se todos forem true printa "Dados cadastrados com sucesso"
     * @param cliente cliente selecioando para alteração
     */
    public void btAlteraDados(Cliente cliente){
        boolean updatePlano = false;
        boolean updateTreino = false;
        boolean updateEndereco = false;

        if(alteraEnderecoCliente(cliente)){
            updateEndereco = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Problemas na alteração do endereço do cliente");
        }

        if(Main.controllerManager.getApplicationModel().getClienteDAO().updateClienteIdTreino(cliente)){
            updateTreino = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Problemas na alteração do Treino do cliente");
        }

        if(Main.controllerManager.getApplicationModel().getClienteDAO().updateClienteIdPlano(cliente)){
            updatePlano = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Problemas na alteração do plano do cliente");
        }

        if(updatePlano && updateEndereco && updateTreino){
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
        }
    }
    /**
     * Retorna o plano selecionado pelo nome 
     * @param lista lista de plano do banco de dados
     * @param planoSelecionado plano selecionado pela selectBox
     * @return o objeto Plano se encontrar no banco, e null se não encontrar
     */
    public Plano retornaPlano(List<Plano> lista, String planoSelecionado){
        boolean existe = false;
        Plano certo = new Plano();
        for(Plano p : lista){
            if(p.getNome().equals(planoSelecionado)){
                existe = true;
                certo = p;
            }
        }
        
        if(existe == true) { 
            return certo;
        }
        
        return null;
    }
    /**
     * Retorna treino pelo selecioando pelo nome
     * @param lista lista de treinos no banco de dados
     * @param treinoSelecionado nome do treino selecionado pela selectBox
     * @return objeto Treino se encontrar o mesmo no banco, se não retorna null
     */
    public Treino retornaTreino(List<Treino> lista, String treinoSelecionado){
        boolean existe = false;
        Treino certo = new Treino();
        for(Treino t : lista){
            if(t.getNome().equals(treinoSelecionado)){
                existe = true;
                certo = t;
            }
        }
        
        if(existe == true) { 
            return certo;
        }
        
        return null;
    }
    /**
     * Chama o metodo do ClienteDAO 'retornaClientePeloCpf'
     * @param cpf cpf selecionado 
     * @return retorna o método 'retornaClientePeloCpf()' da classe clienteDAO, que vai ser um objeto Cliente
     * @throws ParseException
     * @throws SQLException 
     */
    public Cliente retornaClientePeloCpf(String cpf) throws ParseException, SQLException{
        return Main.controllerManager.getApplicationModel().getClienteDAO().retornaClientePeloCpf(cpf);
    }
    /**
     * Chama o metodo do ClienteDAO 'retornaListaDeCPFS()'
     * @return retorna o método 'retornaListaDeCPFS' da classe clienteDAO, que vai ser uma lista de strings
     */
    public List retornaListaCPFS(){
       return Main.controllerManager.getApplicationModel().getClienteDAO().retonaListaDeCPFS();
    }
    
    /**
     * Chama o metodo do PlanoDAO 'selectPlanoSql()'
     * @return retorna o método 'selectPlanoSql' da classe PlanoDAO, que vai ser uma lista de Planos
     */    
    public List retornaListaPlanos(){
        return Main.controllerManager.getApplicationModel().getPlanoDAO().selectPlanoSql();
    }

    /**
     * Chama o metodo do TreinoDAO 'selectTreinos()'
     * @return retorna o método 'selectTreinos()' da classe TreinoDAO, que vai ser uma lista de Treinos
     */      
    public List retornaListatreinos(){
        return Main.controllerManager.getApplicationModel().getTreinoDAO().selectTreinos();
    }
    
    /**
     * Chama o método da classe ClienteDAO 'selectIdEnderecoCliente()'
     * @param idCliente id do Cliente que deseja obter o endereço
     * @return o método da classe ClienteDAO 'selectIdEnderecoCliente()', que vai ser uma String
     */
    public String retornaIdEnderecoDoCliente(int idCliente){
        return Main.controllerManager.getApplicationModel().getClienteDAO().selectIdEnderecoCliente(idCliente);
    }
    
    /**
     * Altera o endereço do cliente selecionado, se idEndereco do cliente for null ele chama o método da classe ClienteDAO 'insertEnderecoClienteSql()'
     * se idEndereco for diferente de null ele chama o método da classe CLienteDAO 'updateIdEnderecoNoCliente()'
     * @param cliente cliente selecionado para alteração
     * @return true se a inserção ou alteração for feita com sucesso, false se não for
     */
    public boolean alteraEnderecoCliente(Cliente cliente){
        boolean resultado = false;
        String idEndereco = retornaIdEnderecoDoCliente(cliente.getId());
        if(idEndereco == null){
            idEndereco = Main.controllerManager.getApplicationModel().getClienteDAO().insertEnderecoClienteSql(cliente);
            if(idEndereco != null){
                if(Main.controllerManager.getApplicationModel().getClienteDAO().updateIdEnderecoNoCliente(cliente.getId(), Integer.parseInt(idEndereco))){
                    resultado = true;
                }
            }
        }    
        else{
           Main.controllerManager.getApplicationModel().getClienteDAO().updateEnderecoClienteSql(cliente, Integer.parseInt(idEndereco));
        }
            
        return resultado;
    }
    
    
    /**
     * Verifica se o usuario deixou campos em branco, se sim altera o atributo do cliente para null
     * @param cliente cliente selecionado para alteração
     * @return retorna o cliente com os dados de endereço alterados
     */
    public Cliente verificaEnderecoNulo(Cliente cliente){
        if(cliente.getBairro().isBlank()){
            cliente.setBairro(null);
        }
        if(cliente.getCep().isBlank()){
            cliente.setCep(null);
        }
        if(cliente.getRua().isBlank()){
            cliente.setRua(null);
        }
        if(cliente.getNumero().isBlank()){
            cliente.setNumero(null);
        }
        
        
        return cliente;
    }
    
    /**
     * Chama o método da classe clienteDAO 'deletaClienteSql()'
     * @param idCliente id do cliente a ser deletado
     * @return retorna o método da classe clienteDAO 'deletaClienteSql()', que vai ser um booleano
     */
    public boolean deletaCliente(int idCliente){
        return Main.controllerManager.getApplicationModel().getClienteDAO().deletaClienteSql(idCliente);
    }
    
    /**
     * Chama o método da classe TReinoDAO '.retornaMapExerciciosDias()'
     * @param idTreino id do Treino a ser buscado os exercícios
     * @return retorna o método da classe TReinoDAO '.retornaMapExerciciosDias()', que vai ser um Map.
     */
    public Map<String, List<Exercicio>> chamaMapExercicio(int idTreino){
        return Main.controllerManager.getApplicationModel().getTreinoDAO().retornaMapExerciciosDias(idTreino);
    }
    
    /**
     * Gera o pdf dos treinos separado por dias da semana, com musculaturas e exercícios
     * @param cliente cliente que deve ser buscado o treino e gerado o pdf
     */
    public void geraTreinoPdf(Cliente cliente, Map<String, List<Exercicio>> map){
        String dia = obterDayOfWeek();
        if(map != null){
            if(!map.get(dia).isEmpty()){
                CupomTreino cupom = new CupomTreino();
                cupom.configurarGeradorPDF();
                cupom.atualizarMapAndClienteAndDia(cliente, map, dia);
                cupom.imprimirPDF();
            }
        
            else{
                JOptionPane.showMessageDialog(null, "O treino do cliente nao possui exercicios para " + dia + ". Vá no treino para adicionar");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Esse cliente ainda não possui um treino ");
        }
    }
    
        public String obterDayOfWeek(){
        // Obter a data atual
        LocalDate hoje = LocalDate.now();

        // Obter o dia da semana
        DayOfWeek diaDaSemana = hoje.getDayOfWeek();

        // Converter o dia da semana para uma representação de texto
        String nomeDoDia = diaDaSemana.getDisplayName(TextStyle.FULL, Locale.getDefault());
            System.out.println("nome do dia: " + nomeDoDia);
        switch(nomeDoDia){
            case "segunda-feira": 
                nomeDoDia = "Segunda";
                break;
            case "terça-feira": 
                nomeDoDia = "Terça";
                break;
            case "quarta-feira": 
                nomeDoDia = "Quarta";
                break;
            case "quinta-feira": 
                nomeDoDia = "Quinta";
                break;
            case "sexta-feira": 
                nomeDoDia = "Sexta";
                break;
            case "sábado": 
                nomeDoDia = "Sabado";
                break;
            case "domingo": 
                nomeDoDia = "Domingo";
                break;
                
        }
        return nomeDoDia;
    }
   
}
