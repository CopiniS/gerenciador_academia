
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import models.Modalidade;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class ModalidadeAdicionarController {

    public ModalidadeAdicionarController() {
    }
    
    /**
     * cadastra as modalidades
     * @param modalidade 
     */
    public void btAddModalidade(Modalidade modalidade){
        if(Main.controllerManager.getApplicationModel().getModalidadeDAO().insertModalidadeSql(modalidade)){
            JOptionPane.showMessageDialog(null, "Modalidade cadastrada com sucesso");
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar modalidade, tente novamente mais tarde");
        }
    }
    
    /**
     * valida o campo do nome
     * @param str nome
     * @return retorna true se o resultado for diferente de vazio
     */
    public boolean validaCampo(String str){
        List lista = Main.controllerManager.getApplicationModel().getModalidadeDAO().selectModalidadeSql();
        if(lista.contains(str) || str.isBlank()){
            return false;
        }
        return true;
    }
    
    /**
     * Verifica se ja foram cadastradas mais de 7 modalidades no banco de dados
     * @return true se tiver menos de 8, senão false
     */
    public boolean verificaSeListaTem8(){
        List lista = Main.controllerManager.getApplicationModel().getModalidadeDAO().selectModalidadeSql();
        System.out.println(lista.size());    
        if(lista.size() > 7){
                return false;
            }
        return true;
    }
}
