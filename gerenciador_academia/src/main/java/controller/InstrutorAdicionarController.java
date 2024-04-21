
package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Instrutor;
import models.Modalidade;
import models.Plano;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class InstrutorAdicionarController {

    public InstrutorAdicionarController() {
    }
    
    /**
     * valida o cpf digitado, correto e existente
     * @param cpf cpf digitado
     * @return retorna true se o cpf foi digitado corretamente
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
     * valida se o cpf digitado nao existe ainda na lista 
     * @param cpf cpf digitado
     * @return retorna true se o cpf digitado existir e for diferente
     */
    public boolean verificaCPFrepetido(String cpf){
        List<String> lista = Main.controllerManager.getApplicationModel().getInstrutorDAO().retonaListaDeCPFS();
        
        return lista.contains(cpf);
    }
    
    /**
     * retorna a lista de modalidades
     * @return lista de modalidades
     */
    public List retornaModalidades(){
        return Main.controllerManager.getApplicationModel().getModalidadeDAO().selectModalidadeSql();
    }
    
    /**
     * valida os campos obrigatorios
     * @param nome nome digitado
     * @param cpf cpf digitado
     * @return booleano, true se os campos estiverem corretos
     */
    public boolean validaCamposObrigatorios(String nome, String cpf){
         if(cpf.isBlank() || nome.isBlank()){
             return false;
         }
         return true;
    }
    
    /**
     * retorna as modalidades selecionadas
     * @param vetorCheckBox checkbox selecionados
     * @param lista lista de modalidades
     * @return retorna a lista com as modalidades selecionadas
     */
    public List<Modalidade> retornaModalidadesSelecionadas(boolean [] vetorCheckBox, List<Modalidade> lista){
        List<Modalidade> selecionados = new ArrayList<>();
        
        for(int i=0; i<8; i++){
            if(vetorCheckBox[i]){
                selecionados.add(lista.get(i));
            }
        }
        
        return selecionados;
    }
    
    /**
     * adiciona o instrutor
     * @param instrutor objeto instrutor
     * @param listaModalidade lista de modalidades
     * @return retorna true se tiver adicionado
     */
    public boolean btAddInstrutor(Instrutor instrutor, List<Modalidade> listaModalidade){
        boolean resultado = false;
        int idInstrutor = Main.controllerManager.getApplicationModel().getInstrutorDAO().insertInstrutor(instrutor.getNome(), instrutor.getCpf());
       
        if(Main.controllerManager.getApplicationModel().getInstrutorDAO().insertInstrutorHasModalidade(idInstrutor, listaModalidade)){
            resultado = true;
        }
        return resultado;
    }

    
}
