
package controller;

import java.util.List;
import models.Exercicio;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class ExercicioAlterarController {

    public ExercicioAlterarController() {
    }
    
    /**
     * retorna a lista de exercicios
     * @return lista de exercicios
     */
    public List retornaListaexercicios(){
        return Main.controllerManager.getApplicationModel().getExercicioDAO().selectExerciciosSql();
    }
    
    /**
     * procura o id exercicio para excluir
     * @param lista lista de exercicio
     * @param nomeSelecionado nome selecionado
     * @return id do exercicio para excluir
     */
    public int retornaIdExercicioParaExcluir(List<Exercicio> lista, String nomeSelecionado){
        for(Exercicio e : lista){
            if(e.getNome().equals(nomeSelecionado)){
                return e.getId();
            }
        }
        return 0;
    }
    
    /**
     * deletar o exercicio
     * @param idExercicio exercicio selecionado
     * @return true se for deletado
     */
    public boolean btDeleteExercicio(int idExercicio){
        return Main.controllerManager.getApplicationModel().getExercicioDAO().delteExercicioSql(idExercicio);
    }
    
}
