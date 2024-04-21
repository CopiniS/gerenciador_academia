
package controller;

import views.TelaModalidadeAdicionar;
import views.TelaModalidadeDeletar;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class ModalidadeController {

    public ModalidadeController() {
    }

    /**
     * leva da tela principal da modalidade para a tela de adicionar modalidade
     */
    public void btAdicionarModalidade(){
        Main.controllerManager.getApplicationView().setTelaModalidadeAdicionar(new TelaModalidadeAdicionar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaModalidadeAdicionar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * leva da tela principal da modalidade para a tela de alterar modalidade
     */
    public void btDeletarModalidade(){
        Main.controllerManager.getApplicationView().setTelaModalidadeDeletar(new TelaModalidadeDeletar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaModalidadeDeletar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);        
    }
}
