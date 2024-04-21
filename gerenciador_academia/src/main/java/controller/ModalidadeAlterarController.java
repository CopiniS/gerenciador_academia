
package controller;

import java.util.List;
import models.Modalidade;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class ModalidadeAlterarController {

    public ModalidadeAlterarController() {
    }
    
    /**
     * retorna lista de modalidades presentes no banco
     * @return lista de modalidades presentes no banco
     */
    public List<Modalidade> retornaListaDeModalidade(){
        return Main.controllerManager.getApplicationModel().getModalidadeDAO().selectModalidadeSql();
    }
    
    /**
     * para excluir a modalidade do nome selecionado
     * @param nomeSelecionado nome modalidade selecionado
     * @param lista lista de modalidades
     * @return retorna o numero da modalidade que vamos excluir
     */
    public int retornaIdModalidadeParaExcluir(String nomeSelecionado, List<Modalidade> lista){
        for(Modalidade m : lista){
            if(m.getNome().equals(nomeSelecionado)){
                return m.getId();
            }
        }
        return 0;
    }
    
    /**
     * deleta a modalidade selecionada
     * @param idModalidade modalidade selecionada
     * @return retorna true se foi deletado a modalidade
     */
    public boolean btDeletaModalidade(int idModalidade){
        return Main.controllerManager.getApplicationModel().getModalidadeDAO().deleteModalidadeSql(idModalidade);
    }
    

}
