
package controller;

import java.util.ResourceBundle;
import models.ApplicationModel;
import views.ApplicationView;
import views.TelaCliente;
import views.TelaExercicio;
import views.TelaInstrutor;
import views.TelaLogin;
import views.TelaModalidade;
import views.TelaPlano;
import views.TelaTreino;


/**
 * Faz o gerenciamento de todos os controllers na aplicação
 * @author gabri
 */

public class ControllerManager {
    private ApplicationModel applicationModel;
    private ApplicationView applicationView;
    
    private ClienteController clienteController;
    private ClienteAdicionarController clienteAdicionarController;
    private ClienteAlterarController clienteAlterarController;
    private ExercicioController exercicioController;
    private ExercicioAdicionarController exercicioAdicionarController;
    private ExercicioAlterarController exercicioAlterarController;
    private InstrutorController instrutorController;
    private InstrutorAdicionarController instrutorAdicionarController;
    private InstrutorAlterarController instrutorAlterarController;
    private ModalidadeController modalidadeController;
    private ModalidadeAdicionarController modalidadeAdicionarController;
    private ModalidadeAlterarController modalidadeAlterarController;
    private PlanoController planoController;
    private PlanoAdicionarController planoAdicionarController;
    private PlanoAlterarController planoAlterarController;
    private TreinoController treinoController;
    private TreinoAdicionarController treinoAdicionarController;
    private TreinoAlterarController treinoAlterarController;
    private LoginController loginController;
    private ResourceBundle traducoes;
    

    public ControllerManager(ApplicationModel applicationModel, ApplicationView applicationView, ResourceBundle traducoes) {
        this.applicationModel = applicationModel;
        this.applicationView = applicationView;
        
        this.clienteController = new ClienteController();
        this.clienteAdicionarController = new ClienteAdicionarController();
        this.clienteAlterarController = new ClienteAlterarController();
        this.exercicioController = new ExercicioController();
        this.exercicioAdicionarController = new ExercicioAdicionarController();
        this.exercicioAlterarController = new ExercicioAlterarController();
        this.instrutorController = new InstrutorController();
        this.instrutorAdicionarController = new InstrutorAdicionarController();
        this.instrutorAlterarController = new InstrutorAlterarController();
        this.modalidadeController = new ModalidadeController();
        this.modalidadeAdicionarController = new ModalidadeAdicionarController();
        this.modalidadeAlterarController = new ModalidadeAlterarController();
        this.planoController = new PlanoController();
        this.planoAdicionarController = new PlanoAdicionarController();
        this.planoAlterarController = new PlanoAlterarController();
        this.treinoController = new TreinoController();
        this.treinoAdicionarController = new TreinoAdicionarController();
        this.treinoAlterarController = new TreinoAlterarController();
        this.loginController = new LoginController();
        this.traducoes = traducoes;

    }
    
    /**
     * Inicia a primeira tela da aplicação. Tela de Login.
     */
    public void start(){
        this.applicationView.setTelaLogin(new TelaLogin());
        this.applicationView.mostraTela(this.applicationView.getTelaLogin());      //Mostra a tela de cadastro.
        this.applicationView.getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * Redireciona pra tela do cliente
     */
    public void btAcessarTelaCliente(){
        this.applicationView.setTelaCliente(new TelaCliente());
        this.applicationView.mostraTela(this.applicationView.getTelaCliente());
        this.applicationView.getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * redireciona pra tela do instrutor
     */
    public void btAcessarTelaInstrutor(){
        this.applicationView.setTelaInstrutor(new TelaInstrutor());
        this.applicationView.mostraTela(this.applicationView.getTelaInstrutor());
        this.applicationView.getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * redireciona pra tela do plano
     */
    public void btAcessarTelaPlano(){
        this.applicationView.setTelaPlano(new TelaPlano());
        this.applicationView.mostraTela(this.applicationView.getTelaPlano());
        this.applicationView.getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * redireciona pra tela da modalidade
     */
    public void btAcessarTelaModalidade(){
        this.applicationView.setTelaModalidade(new TelaModalidade());
        this.applicationView.mostraTela(this.applicationView.getTelaModalidade());
        this.applicationView.getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * redireciona pra tela do treino
     */
    public void btAcessarTelaTreino(){
        this.applicationView.setTelaTreino(new TelaTreino());
        this.applicationView.mostraTela(this.applicationView.getTelaTreino());
        this.applicationView.getJanela().setLocationRelativeTo(null);
    }
    
    /**
     * redireciona pra tela do exercício
     */
    public void btAcessartelaExercicio(){
        this.applicationView.setTelaExercicio(new TelaExercicio());
        this.applicationView.mostraTela(this.applicationView.getTelaExercicio());
        this.applicationView.getJanela().setLocationRelativeTo(null);
    }
    
    public ApplicationModel getApplicationModel() {
        return applicationModel;
    }

    public void setApplicationModel(ApplicationModel applicationModel) {
        this.applicationModel = applicationModel;
    }

    public ApplicationView getApplicationView() {
        return applicationView;
    }

    public void setApplicationView(ApplicationView applicationView) {
        this.applicationView = applicationView;
    }

    public ClienteController getClienteController() {
        return clienteController;
    }

    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
    }

    public ExercicioController getExercicioController() {
        return exercicioController;
    }

    public void setExercicioController(ExercicioController exercicioController) {
        this.exercicioController = exercicioController;
    }

    public InstrutorController getInstrutorController() {
        return instrutorController;
    }

    public void setInstrutorController(InstrutorController instrutorController) {
        this.instrutorController = instrutorController;
    }

    public ModalidadeController getModalidadeController() {
        return modalidadeController;
    }

    public void setModalidadeController(ModalidadeController modalidadeController) {
        this.modalidadeController = modalidadeController;
    }

    public PlanoController getPlanoController() {
        return planoController;
    }

    public void setPlanoController(PlanoController planoController) {
        this.planoController = planoController;
    }

    public TreinoController getTreinoController() {
        return treinoController;
    }

    public void setTreinoController(TreinoController treinoController) {
        this.treinoController = treinoController;
    }


    public LoginController getLoginController() {
        return loginController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public ClienteAdicionarController getClienteAdicionarController() {
        return clienteAdicionarController;
    }

    public void setClienteAdicionarController(ClienteAdicionarController clienteAdicionarController) {
        this.clienteAdicionarController = clienteAdicionarController;
    }

    public ClienteAlterarController getClienteAlterarController() {
        return clienteAlterarController;
    }

    public void setClienteAlterarController(ClienteAlterarController clienteAlterarController) {
        this.clienteAlterarController = clienteAlterarController;
    }

    public ExercicioAdicionarController getExercicioAdicionarController() {
        return exercicioAdicionarController;
    }

    public void setExercicioAdicionarController(ExercicioAdicionarController exercicioAdicionarController) {
        this.exercicioAdicionarController = exercicioAdicionarController;
    }

    public ExercicioAlterarController getExercicioAlterarController() {
        return exercicioAlterarController;
    }

    public void setExercicioAlterarController(ExercicioAlterarController exercicioAlterarController) {
        this.exercicioAlterarController = exercicioAlterarController;
    }

    public InstrutorAdicionarController getInstrutorAdicionarController() {
        return instrutorAdicionarController;
    }

    public void setInstrutorAdicionarController(InstrutorAdicionarController instrutorAdicionarController) {
        this.instrutorAdicionarController = instrutorAdicionarController;
    }

    public InstrutorAlterarController getInstrutorAlterarController() {
        return instrutorAlterarController;
    }

    public void setInstrutorAlterarController(InstrutorAlterarController instrutorAlterarController) {
        this.instrutorAlterarController = instrutorAlterarController;
    }

    public ModalidadeAdicionarController getModalidadeAdicionarController() {
        return modalidadeAdicionarController;
    }

    public void setModalidadeAdicionarController(ModalidadeAdicionarController modalidadeAdicionarController) {
        this.modalidadeAdicionarController = modalidadeAdicionarController;
    }

    public ModalidadeAlterarController getModalidadeAlterarController() {
        return modalidadeAlterarController;
    }

    public void setModalidadeAlterarController(ModalidadeAlterarController modalidadeAlterarController) {
        this.modalidadeAlterarController = modalidadeAlterarController;
    }

    public PlanoAdicionarController getPlanoAdicionarController() {
        return planoAdicionarController;
    }

    public void setPlanoAdicionarController(PlanoAdicionarController planoAdicionarController) {
        this.planoAdicionarController = planoAdicionarController;
    }

    public PlanoAlterarController getPlanoAlterarController() {
        return planoAlterarController;
    }

    public void setPlanoAlterarController(PlanoAlterarController planoAlterarController) {
        this.planoAlterarController = planoAlterarController;
    }

    public TreinoAdicionarController getTreinoAdicionarController() {
        return treinoAdicionarController;
    }

    public void setTreinoAdicionarController(TreinoAdicionarController treinoAdicionarController) {
        this.treinoAdicionarController = treinoAdicionarController;
    }

    public TreinoAlterarController getTreinoAlterarController() {
        return treinoAlterarController;
    }

    public void setTreinoAlterarController(TreinoAlterarController treinoAlterarController) {
        this.treinoAlterarController = treinoAlterarController;
    }

    public ResourceBundle getTraducoes() {
        return traducoes;
    }

    public void setTraducoes(ResourceBundle traducoes) {
        this.traducoes = traducoes;
    }
    
    
    
}
