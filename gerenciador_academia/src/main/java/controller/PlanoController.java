
package controller;

import views.TelaPlanoAdicionar;
import views.TelaPlanoAlterar;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class PlanoController {

    public PlanoController() {
    }

    /**
     * leva da tela principal do plano para a tela de adicionar plano
     */
    public void btAdicionarPlano(){
        Main.controllerManager.getApplicationView().setTelaPlanoAdicionar(new TelaPlanoAdicionar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaPlanoAdicionar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * leva da tela principal do plano para a tela de alterar plano
     */
    public void btAlterarPlano(){
        Main.controllerManager.getApplicationView().setTelaPlanoAlterar(new TelaPlanoAlterar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaPlanoAlterar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
}   
        