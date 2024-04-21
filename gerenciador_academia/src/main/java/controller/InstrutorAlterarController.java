
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Instrutor;
import models.Modalidade;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class InstrutorAlterarController {

    public InstrutorAlterarController() {
    }
    
    /**
     * retorna a lista de instrutores
     * @return retorna a lista de instrutores
     */
    public List<Instrutor> retornaListaInstrutores(){
        return Main.controllerManager.getApplicationModel().getInstrutorDAO().selectInstrutor();
    }
    
   /**
    * retorna a lista de modalidades
    * @return retorna a lista de modalidades
    */
    public List<Modalidade> retornaTodasModalidades(){
        return Main.controllerManager.getApplicationModel().getModalidadeDAO().selectModalidadeSql();
    }
    
    /**
     * procura o instrutor atraves do spc
     * @param cpf cpf selecionado
     * @param lista lista de instrutores 
     * @return retorna o instrutor que tem o cpf selecionado
     */
    public Instrutor retornaInstrutorPeloCPf(String cpf, List<Instrutor> lista){
        for(Instrutor i : lista){
            if(i.getCpf().equals(cpf)){
                return i;
            }
        }
        return null;
    }
    
    /**
     * retorna a lista de modalides do instrutor
     * @param idInstrutor instrutor selecionado
     * @return lista de modalides do instrutor
     * @throws SQLException 
     */
    public List<Modalidade> retornaModalidadesDoInstrutor(int idInstrutor) throws SQLException{
        return Main.controllerManager.getApplicationModel().getInstrutorDAO().retornaListaDeModalidadesDoInstrutor(idInstrutor);
    }
    
    /**
     * valida o campo do nome
     * @param nome nome digitado
     * @return retorna true se o campo nao estiver vazio
     */
    public boolean validaCampoNome(String nome){
        return !nome.isBlank();
    }    
    
    /**
     * altera as modalidade do instrutor
     * @param instrutor objeto instrutor
     * @param antigas modalidades antigas
     * @param novas modalidades novas
     * @return retorna true se as modalidades foram alteradas
     */
    public boolean alteraModalidades(Instrutor instrutor, List<Modalidade> antigas, List<Modalidade> novas){

        boolean resultado = false;
        boolean insercoes = false;
        boolean remocoes = false;
        if(!antigas.isEmpty()){
            if(Main.controllerManager.getApplicationModel().getInstrutorDAO().deleteInstrutorHasModalidade(instrutor.getId(), antigas)){
                remocoes = true;
            }
        }
        else{
            remocoes = true;
        }
        
        if(!novas.isEmpty()){
            if(Main.controllerManager.getApplicationModel().getInstrutorDAO().insertInstrutorHasModalidade(instrutor.getId(), novas)){
                insercoes = true;
            }
        }
        else{
            insercoes = true;
        }
        
        if(insercoes && remocoes){
            resultado = true;
        }

        return resultado;
    }
    
    /**
     * retorna as modalidades selecionadas
     * @param vetorCheckBox modalidades selcionadas
     * @param lista lista de modalidades
     * @return retorna a lista de modalidades
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
     * deleta o instrutor selecionado
     * @param idInstrutor instruto selecionado
     * @return booleano true se for delatado com sucesso
     */
    public boolean deletaInstrutor(int idInstrutor){
        return Main.controllerManager.getApplicationModel().getInstrutorDAO().deleteInstrutorSql(idInstrutor);
    }
}
