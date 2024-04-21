
package controller;

import javax.swing.JOptionPane;
import views.TelaCliente;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class LoginController {

    public LoginController() {

    }
    
    /**
     * sai da tela de login para a cliente após validar se está correto as informacoes de acesso
     * @param usuario usuario digitado
     * @param senha senha digitada
     */
    public void btEntrar(String usuario, String senha){
       Main.controllerManager.getApplicationModel().startDAOModels();
       if(Main.controllerManager.getApplicationModel().getLoginDAO().SelectSenhaDoUsuarioSQL(usuario, senha)){
             Main.controllerManager.getApplicationView().setTelaCliente(new TelaCliente());
             Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaCliente());
             Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
       }
       else{
           JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
       }
    }
}
