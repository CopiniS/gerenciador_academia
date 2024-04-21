
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Modalidade;
import models.Plano;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class PlanoAlterarController {
    
    /**
     * retorna lista com todos os planos
     * @return retorna lista com todos os planos
     */
    public List<Plano> retornaListaPlanos(){
        return Main.controllerManager.getApplicationModel().getPlanoDAO().selectPlanoSql();
    }
    
    /**
     * retorna lista dos planos atraves do nome selecionado
     * @param nome nome plano
     * @param planos lista de planos
     * @return retorna lista dos planos atraves do nome selecionado
     */
    public Plano retornaPlanoPeloNome(String nome, List<Plano> planos){
        Plano plano = new Plano();
        for(Plano p : planos){
            if(p.getNome().equals(nome)){
                plano = p;
            }
        }
            
        return plano;
    }
    
    /**
     * retorna lista de modalidades pertencentes ao plano
     * @param plano classe plano
     * @return retorna lista de modalidades pertencentes ao plano
     * @throws SQLException 
     */
    public List retornaModalidadesDoPlano(Plano plano) throws SQLException{
        return Main.controllerManager.getApplicationModel().getPlanoDAO().retornaListaDeModalidadesDoPlano(plano.getId());
    }
    
    /**
     * retorna todas as modalidades
     * @return retorna a lista de modalidades
     */
    public List<Modalidade> retornaTodasModalidades(){
        return Main.controllerManager.getApplicationModel().getModalidadeDAO().selectModalidadeSql();
    }
    
    /**
     * checa e valida se todos os campos estão nas preenchidos corretamente
     * @param vetorCheckBox checkbox das modalidades
     * @param valor
     * @param meses
     * @return retorna booleando, true se todos os campos estiverem preenchidos corretamente
     */
    public boolean validaCamposGerais(boolean [] vetorCheckBox, String valor, String meses){
        boolean resultado = false;
        
        if(validaCheckBox(vetorCheckBox) && isInteger(meses) && isFloat(valor)){
            resultado = true;
        }
            
        return resultado;
    }    
    
    /**
     * valida o checkbox
     * @param vetorCheckBox
     * @return retorna booleano se o checkbox estiverem preenchido corretamente
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
    
    public boolean isInteger(String str){
        return str.matches("^\\d+$");
    }
    
    public boolean isFloat(String str){
        return str.matches("^\\d*\\.?\\d+$");
    }
    
    /**
     * altera a modalidade selecionada
     * @param plano plano que esta a modalidade
     * @param antigas modalidades antigas
     * @param novas novas modalidades
     * @return booleano, true se a modalidade foi alterada
     */
    public boolean alteraModalidades(Plano plano, List<Modalidade> antigas, List<Modalidade> novas){

        boolean resultado = false;
        for (int i = 0; i < novas.size(); i++) {
            for (int j = 0; j < antigas.size(); j++) {
                if (novas.get(i).getId() == antigas.get(j).getId()) {
                    novas.remove(i);
                    antigas.remove(j);
                    i--; // Decrementa i para ajustar após a remoção de um elemento de novas
                    break; // Sai do loop interno para evitar ConcurrentModificationException
                }
            }
        }
       
        boolean insercoes = false;
        boolean remocoes = false;
        if(Main.controllerManager.getApplicationModel().getPlanoDAO().insertPlanoHasModalidade(plano.getId(), novas)){
            insercoes = true;
        }
        
        if(Main.controllerManager.getApplicationModel().getPlanoDAO().deletePlanohasModalidade(plano.getId(), antigas)){
            remocoes = true;
        }
        
        if(insercoes && remocoes){
            resultado = true;
        }

        return resultado;
    }
    
    /**
     * altera o valor e mes do plano
     * @param plano
     * @return booleano, true se tiver alterado
     */
    public boolean alteraValorEMeses(Plano plano){
        boolean resultado = false;
        
        if(Main.controllerManager.getApplicationModel().getPlanoDAO().updatePlanoSql(plano)){
            resultado = true;
        }
        return resultado;
    }
    
    /**
     * retorna a lista de modalidades selecionadas
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
     * deleta o plano selecionado
     * @param plano objeto plano
     * @return booleano, true se tiver deletado o plano
     */
    public boolean deletarPlano(Plano plano){
        boolean resultado = false;
        
        if(Main.controllerManager.getApplicationModel().getPlanoDAO().deletePlanoSql(plano.getId())){
            resultado = true;
        }
        return resultado;
    }
}
