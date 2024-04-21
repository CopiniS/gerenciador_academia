
package controller;

import java.sql.SQLException;
import views.TelaTreinoAdicionar;
import views.TelaTreinoAlterar;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class TreinoController {

    public TreinoController() {
    }

    /**
     * Muda da tela cliente para tela adicionar cliente
     */
    public void btAdicionarTreino(){
        Main.controllerManager.getApplicationView().setTelaTreinoAdicionar(new TelaTreinoAdicionar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaTreinoAdicionar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * Muda da tela cliente para tela alterar cliente
     * @throws SQLException 
     */
    public void btAlterarTreino() throws SQLException{
        Main.controllerManager.getApplicationView().setTelaTreinoAlterar(new TelaTreinoAlterar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaTreinoAlterar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }

}
