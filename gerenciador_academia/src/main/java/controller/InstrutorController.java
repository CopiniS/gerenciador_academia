package controller;

import views.TelaInstrutorAdicionar;
import views.TelaInstrutorAlterar;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class InstrutorController {

    public InstrutorController() {
        
    }
    
    /**
     * muda da tela principal para a tela de adicionar instrutor
     */
    public void btAdd(){
        Main.controllerManager.getApplicationView().setTelaInstrutorAdicionar(new TelaInstrutorAdicionar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaInstrutorAdicionar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * muda da tela principal para a tela de alterar instrutor
     */
    public void btAlterar(){
        Main.controllerManager.getApplicationView().setTelaInstrutorAlterar(new TelaInstrutorAlterar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaInstrutorAlterar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * muda da tela principal para a tela de mostrar
     */
    public void btMostrar(){
        Main.controllerManager.getApplicationModel().getInstrutorDAO().mostraInstrutores();
    }
}
