
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Modalidade;
import models.Plano;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class PlanoAdicionarController {

    public PlanoAdicionarController() {
    }
    
    /**
     * retorna a lsita de modalides
     * @return lista de modalidades
     */
    public List<Modalidade> retornaListaModadalidade(){
        return Main.controllerManager.getApplicationModel().getModalidadeDAO().selectModalidadeSql();
    }
    
    /**
     * retorna lista de modalidades selecionadas nos checkbox
     * @param vetorCheckBox modalidades selecionadas
     * @param lista lista de modalidades
     * @return retorna a lista de modalidades selecionadas
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
     * valida todos os campos
     * @param nome nome plano
     * @param vetorCheckBox checkboxes das modalidades
     * @param valor valor plano
     * @param meses qntd de meses plano
     * @return booleano, true se todos os campos forem preenchidos corretamente
     */
    public boolean validaCamposGerais(String nome, boolean [] vetorCheckBox, String valor, String meses){
        boolean resultado = false;
        
        if(validaCampoNome(nome) && validaCheckBox(vetorCheckBox) && isInteger(meses) && isFloat(valor)){
            resultado = true;
        }
            
        return resultado;
    }
    
    /**
     * validador do campo nome
     * @param str nome escrito
     * @return retorna true se tiver correto a forma de preenchimento
     */
    public boolean validaCampoNome(String str){
        boolean resultado = false;
        if(!str.isBlank()){
            resultado = true;
        }
        return resultado;
    }
    
    /**
     * validador checkbox
     * @param vetorCheckBox check box selecionada
     * @return retorna true se tiver correto a forma de preenchimento
     */
    public boolean validaCheckBox(boolean [] vetorCheckBox){
        boolean resultado = false;
        
        for(int i=0; i<8; i++){
            if(vetorCheckBox[i] == true){
                resultado = true;
            }
        }
        return resultado;
    }
    
    /**
     * verifica se a String enviada é um número inteiro
     * @param str string a ser avaliada
     * @return true se for int, senão false
     */
    public boolean isInteger(String str){
        return str.matches("^\\d+$");
    }
    /**
     * Verifica se a String é um número de ponto flutuante
     * @param str String a ser avaliada
     * @return true se for float, senão false
     */
    public boolean isFloat(String str){
        return str.matches("^\\d*\\.?\\d+$");
    }
    
    /**
     * Verifica se a lista de modalidades está vazia
     * @param lista lista de modalidades
     * @return true se não estiver vazia, senão false
     */
    public boolean verificaModalidadesvazias(List<Modalidade> lista){
        boolean vazia = false;
        if(!lista.isEmpty()){
            vazia = true;
        }
        return vazia;
    }
    
    /**
     * botao que adiciona plano com todas as informaçoess
     * @param plano objeto plano
     * @param lista lista modalidade
     * @return retorna true se tiver adicionado com sucesso
     */
    public boolean btAddPlano(Plano plano, List<Modalidade> lista){
        boolean resultado = false;
        int idPlano = Main.controllerManager.getApplicationModel().getPlanoDAO().insertPlanoSql(plano);
        
        if(Main.controllerManager.getApplicationModel().getPlanoDAO().insertPlanoHasModalidade(idPlano, lista)){
            resultado = true;
        }
        return resultado;
    }
    
    
    
}
