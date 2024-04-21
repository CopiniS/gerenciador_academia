
package controller;

import views.TelaExercicioAdicionar;
import views.TelaExercicioDeletar;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class ExercicioController {

    public ExercicioController() {
    }
    
    /**
     * muda da tela de exercicio para a tela de adicionar exercicio
     */
    public void btAdicionarExercicio(){
        Main.controllerManager.getApplicationView().setTelaExercicioAdicionar(new TelaExercicioAdicionar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaExercicioAdicionar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * muda da tela de exercicio para a tela de alterar exercicio
     */
    public void btDeletarExercicio(){
        Main.controllerManager.getApplicationView().setTelaExercicioDeletar(new TelaExercicioDeletar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaExercicioDeletar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
}
