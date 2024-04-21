
package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

public class ApplicationView {
    private Janela janela;
    private TelaCliente telaCliente;
    private TelaClienteAdicionar telaClienteAdicionar;
    private TelaClienteAlterar telaClienteAlterar;
    private TelaLogin telaInicial;
    private TelaInstrutor telaInstrutor;
    private TelaInstrutorAdicionar telaInstrutorAdicionar;
    private TelaInstrutorAlterar telaInstrutorAlterar;
    private TelaModalidade telaModalidade;
    private TelaModalidadeAdicionar telaModalidadeAdicionar;
    private TelaModalidadeDeletar telaModalidadeDeletar;
    private TelaPlano telaPlano;
    private TelaPlanoAdicionar telaPlanoAdicionar;
    private TelaPlanoAlterar telaPlanoAlterar;
    private TelaTreino telaTreino;
    private TelaTreinoAdicionar telaTreinoAdicionar;
    private TelaTreinoAlterar telaTreinoAlterar;
    private TelaExercicio telaExercicio;
    private TelaExercicioAdicionar telaExercicioAdicionar;
    private TelaExercicioDeletar telaExercicioDeletar;
    
    

    public ApplicationView() {
        this.janela = new Janela();
        this.janela.setLocationRelativeTo(null); //Posiciona no meio da tela
        this.janela.setVisible(true); 
    }
    
    public void mostraTela(JPanel tela){
        this.janela.setPreferredSize(new Dimension(1280, 720));
        this.janela.getContentPane().removeAll();       //Remove o conteúdo atual do frame.
        this.janela.add(tela, BorderLayout.CENTER);     //Adiciona o novo painel ao frame.
        this.janela.setVisible(true);
        this.janela.pack();
        
        //Redimensiona o frame.
    }
    
    public void fechaJanela(){
        this.janela.dispose(); //Fecha o frame.
    }
    

    public Janela getJanela() {
        return janela;
    }

    public void setJanela(Janela janela) {
        this.janela = janela;
    }

    public TelaCliente getTelaCliente() {
        return telaCliente;
    }

    public void setTelaCliente(TelaCliente telaCliente) {
        this.telaCliente = telaCliente;
    }

    public TelaClienteAdicionar getTelaClienteAdicionar() {
        return telaClienteAdicionar;
    }

    public void setTelaClienteAdicionar(TelaClienteAdicionar telaClienteAdicionar) {
        this.telaClienteAdicionar = telaClienteAdicionar;
    }

    public TelaClienteAlterar getTelaClienteAlterar() {
        return telaClienteAlterar;
    }

    public void setTelaClienteAlterar(TelaClienteAlterar telaClienteAlterar) {
        this.telaClienteAlterar = telaClienteAlterar;
    }

    public TelaLogin getTelaLogin() {
        return telaInicial;
    }

    public void setTelaLogin(TelaLogin telaInicial) {
        this.telaInicial = telaInicial;
    }

    public TelaInstrutor getTelaInstrutor() {
        return telaInstrutor;
    }

    public void setTelaInstrutor(TelaInstrutor telaInstrutor) {
        this.telaInstrutor = telaInstrutor;
    }

    public TelaInstrutorAdicionar getTelaInstrutorAdicionar() {
        return telaInstrutorAdicionar;
    }

    public void setTelaInstrutorAdicionar(TelaInstrutorAdicionar telaInstrutorAdicionar) {
        this.telaInstrutorAdicionar = telaInstrutorAdicionar;
    }

    public TelaInstrutorAlterar getTelaInstrutorAlterar() {
        return telaInstrutorAlterar;
    }

    public void setTelaInstrutorAlterar(TelaInstrutorAlterar telaInstrutorAlterar) {
        this.telaInstrutorAlterar = telaInstrutorAlterar;
    }

    public TelaModalidade getTelaModalidade() {
        return telaModalidade;
    }

    public void setTelaModalidade(TelaModalidade telaModalidade) {
        this.telaModalidade = telaModalidade;
    }

    public TelaPlano getTelaPlano() {
        return telaPlano;
    }

    public void setTelaPlano(TelaPlano telaPlano) {
        this.telaPlano = telaPlano;
    }

    public TelaPlanoAdicionar getTelaPlanoAdicionar() {
        return telaPlanoAdicionar;
    }

    public void setTelaPlanoAdicionar(TelaPlanoAdicionar telaPlanoAdicionar) {
        this.telaPlanoAdicionar = telaPlanoAdicionar;
    }

    public TelaTreino getTelaTreino() {
        return telaTreino;
    }

    public void setTelaTreino(TelaTreino telaTreino) {
        this.telaTreino = telaTreino;
    }

    public TelaLogin getTelaInicial() {
        return telaInicial;
    }

    public void setTelaInicial(TelaLogin telaInicial) {
        this.telaInicial = telaInicial;
    }

    public TelaModalidadeAdicionar getTelaModalidadeAdicionar() {
        return telaModalidadeAdicionar;
    }

    public void setTelaModalidadeAdicionar(TelaModalidadeAdicionar telaModalidadeAdicionar) {
        this.telaModalidadeAdicionar = telaModalidadeAdicionar;
    }

    public TelaModalidadeDeletar getTelaModalidadeDeletar() {
        return telaModalidadeDeletar;
    }

    public void setTelaModalidadeDeletar(TelaModalidadeDeletar telaModalidadeDeletar) {
        this.telaModalidadeDeletar = telaModalidadeDeletar;
    }

    public TelaPlanoAlterar getTelaPlanoAlterar() {
        return telaPlanoAlterar;
    }

    public void setTelaPlanoAlterar(TelaPlanoAlterar telaPlanoAlterar) {
        this.telaPlanoAlterar = telaPlanoAlterar;
    }

    public TelaTreinoAdicionar getTelaTreinoAdicionar() {
        return telaTreinoAdicionar;
    }

    public void setTelaTreinoAdicionar(TelaTreinoAdicionar telaTreinoAdicionar) {
        this.telaTreinoAdicionar = telaTreinoAdicionar;
    }

    public TelaTreinoAlterar getTelaTreinoAlterar() {
        return telaTreinoAlterar;
    }

    public void setTelaTreinoAlterar(TelaTreinoAlterar telaTreinoAlterar) {
        this.telaTreinoAlterar = telaTreinoAlterar;
    }

    public TelaExercicio getTelaExercicio() {
        return telaExercicio;
    }

    public void setTelaExercicio(TelaExercicio telaExercicio) {
        this.telaExercicio = telaExercicio;
    }

    public TelaExercicioAdicionar getTelaExercicioAdicionar() {
        return telaExercicioAdicionar;
    }

    public void setTelaExercicioAdicionar(TelaExercicioAdicionar telaExercicioAdicionar) {
        this.telaExercicioAdicionar = telaExercicioAdicionar;
    }

    public TelaExercicioDeletar getTelaExercicioDeletar() {
        return telaExercicioDeletar;
    }

    public void setTelaExercicioDeletar(TelaExercicioDeletar telaExercicioDeletar) {
        this.telaExercicioDeletar = telaExercicioDeletar;
    }
    
    
}
