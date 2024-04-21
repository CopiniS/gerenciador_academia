
package models;
/**
 * Classe que gerencia os models
 * @author gabri
 */
public class ApplicationModel {
    private Cliente cliente;
    private ClienteDAO clienteDAO;
    private Exercicio exercicio;
    private ExercicioDAO exercicioDAO;
    private Instrutor instrutor;
    private InstrutorDAO instrutorDAO;
    private Modalidade modalidade;
    private ModalidadeDAO modalidadeDAO;
    private Pedido pedido;
    private PedidoDAO pedidoDAO;
    private Plano plano;
    private PlanoDAO planoDAO;
    private Treino treino;
    private TreinoDAO treinoDAO;
    private LoginDAO loginDAO;

    public ApplicationModel() {
        startDAOModels();
    }
    
    /**
     * Inicializa as classes DAO do sistema
     */
    public void startDAOModels(){
        clienteDAO = new ClienteDAO();
        exercicioDAO = new ExercicioDAO();
        instrutorDAO = new InstrutorDAO();
        modalidadeDAO = new ModalidadeDAO();
        pedidoDAO = new PedidoDAO();
        planoDAO = new PlanoDAO();
        treinoDAO = new TreinoDAO();
        loginDAO = new LoginDAO();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ClienteDAO getClienteDAO() {
        return clienteDAO;
    }

    public void setClienteDAO(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public ExercicioDAO getExercicioDAO() {
        return exercicioDAO;
    }

    public void setExercicioDAO(ExercicioDAO exercicioDAO) {
        this.exercicioDAO = exercicioDAO;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public InstrutorDAO getInstrutorDAO() {
        return instrutorDAO;
    }

    public void setInstrutorDAO(InstrutorDAO instrutorDAO) {
        this.instrutorDAO = instrutorDAO;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public ModalidadeDAO getModalidadeDAO() {
        return modalidadeDAO;
    }

    public void setModalidadeDAO(ModalidadeDAO modalidadeDAO) {
        this.modalidadeDAO = modalidadeDAO;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PedidoDAO getPedidoDAO() {
        return pedidoDAO;
    }

    public void setPedidoDAO(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public PlanoDAO getPlanoDAO() {
        return planoDAO;
    }

    public void setPlanoDAO(PlanoDAO planoDAO) {
        this.planoDAO = planoDAO;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public TreinoDAO getTreinoDAO() {
        return treinoDAO;
    }

    public void setTreinoDAO(TreinoDAO treinoDAO) {
        this.treinoDAO = treinoDAO;
    }

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
    
    
}
