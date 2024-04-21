
package controller;

import java.text.ParseException;
import java.util.List;
import models.Cliente;
import models.Plano;
import models.Treino;


/**
 * Faz o controle entre a tela ClienteAdicionar e o backend
 * @author gabri
 */
public class ClienteAdicionarController {

    public ClienteAdicionarController() {
    }
    
    /**
     * Verifica se os campos estão vazios ou apenas com espaços
     * @param nome Nome digitado pelo usuário
     * @param cpf CPF digitado pelo usuário
     * @param data Data digitada pelo usuário
     * @return true se nenhum dos parametros for blank e false se pelo menos um estiver for blank
     */
    public boolean validacaoCamposObrigatorios(String nome, String cpf, String data){
         if(nome.isBlank() || cpf.isBlank() || data.isBlank()){
             return false;
         }
         return true;
    }
    
    
    /**
     * Se pelo menos um dos campos do endereço não for blank, ele chama o insertEndereço e depois chama inserertCliente;
     * Se não apenas chama o insertCliente com o idEndereco como null
     * @param cliente cliente a ser inserido
     * @return true se a inserção for feita corretamente
     * @throws ParseException 
     */
    public boolean btAddCliente(Cliente cliente) throws ParseException{
        
        String idEndereco = null;
        if(!cliente.getCep().isBlank() || !cliente.getRua().isBlank() || !cliente.getBairro().isBlank() || !cliente.getNumero().isBlank()){
             idEndereco = Main.controllerManager.getApplicationModel().getClienteDAO().insertEnderecoClienteSql(cliente);
        }
        return Main.controllerManager.getApplicationModel().getClienteDAO().insertClienteSql(cliente, idEndereco);
        
    }
    
    
    /**
     * Valida CPF digitado pelo usuário
     * @param cpf CPF digitado pelo usuário
     * @return true se for um CPF válido
     */
    public boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11)
            return false;
        
        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}"))
            return false;
        
        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) digito1 = 0;
        
        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) digito2 = 0;
        
        // Verificar se os dígitos calculados são iguais aos dígitos do CPF
        return (Character.getNumericValue(cpf.charAt(9)) == digito1) && 
               (Character.getNumericValue(cpf.charAt(10)) == digito2);
    }
    
    
    /**
     * Verifica se o CPF digitado pelo usuário está no BD
     * @param cpf CPF digitado pelo usuário
     * @return true se estiver no BD e false se não estiver
     */
    public boolean verificaCPFrepetido(String cpf){
        List<String> lista = Main.controllerManager.getApplicationModel().getClienteDAO().retonaListaDeCPFS();
        
        return lista.contains(cpf);
    }
    
    
    /**
     * Retorna o plano através do nome do plano
     * @param lista lista de todos os plano cadastrados
     * @param nomePlano nome do plano selecionado
     * @return Plano se existir o nome na lista, e null se não existir
     */
    public Plano retornaPlanoSelecionado(List<Plano> lista, String nomePlano){
        for(Plano p : lista){
            if(p.getNome().equals(nomePlano)){
                return p;
            }
        }
        return null;
    }  
    
    /**
     * Retorna o treino através do nome do treino
     * @param lista lista de todos os treinos cadastrados
     * @param nomeTreino nome do Treino selecionado
     * @return Treino se o nome estiver na lista, e null se não estiver
     */
    public Treino retornaTreinoSelecionado(List<Treino> lista, String nomeTreino){
        for(Treino t : lista){
            if(t.getNome().equals(nomeTreino)){
                return t;
            }
        }
            return null;
    }
    
}

