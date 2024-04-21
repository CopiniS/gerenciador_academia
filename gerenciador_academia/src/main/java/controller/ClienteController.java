
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import models.Cliente;
import views.TelaClienteAdicionar;
import views.TelaClienteAlterar;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class ClienteController {
  
    /**
     * muda da tela principal pra do adicionar cliente
     */
    public void btAdicionarCliente(){
        Main.controllerManager.getApplicationView().setTelaClienteAdicionar(new TelaClienteAdicionar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaClienteAdicionar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * muda da tela principal pra do alterar cliente
     */
    public void btAlterarCliente(){
        Main.controllerManager.getApplicationView().setTelaClienteAlterar(new TelaClienteAlterar());
        Main.controllerManager.getApplicationView().mostraTela(Main.controllerManager.getApplicationView().getTelaClienteAlterar());
        Main.controllerManager.getApplicationView().getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * mostra o sout de clientes
     */
    public void btMostrarCliente(){
        List<Cliente> lista = Main.controllerManager.getApplicationModel().getClienteDAO().mostraClientes();
        String listaStr = "";
        for(Cliente c : lista){
            listaStr = listaStr + "nome: " + c.getNome() + "  -- CPF: " + c.getCpf() + "  --  Data nascimento: " + c.getDataNascimento() + 
                    "  --  CEP: " + c.getCep() + "  --  Plano: " + c.getPlano().getNome() + "\n";
        }
        
        JOptionPane.showMessageDialog(null, listaStr);
    }
}
    
