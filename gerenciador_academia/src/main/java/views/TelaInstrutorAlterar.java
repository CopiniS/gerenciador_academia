/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import controller.Main;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Instrutor;
import models.Modalidade;
import models.Plano;

/**
 *
 * @author tiovi
 */
public class TelaInstrutorAlterar extends javax.swing.JPanel {
    private List<Instrutor> listaInstrutor;
    private Instrutor instrutor;
    private List<Modalidade> modalidadesTotal;
    private List<Modalidade> modalidadesAntigas;
    private List<Modalidade> modalidadesNovas;
    private String []vetorModalidade;
    private ResourceBundle traducoes;
    
    /**
     * Creates new form TelaAlterarCliente
     */
    public TelaInstrutorAlterar() {
        initComponents();
        this.traducoes = Main.controllerManager.getTraducoes();
        traduzir();
        inicializaCbBoxCpf();
        tf_Nome.setEditable(false);
    }
    
    public void traduzir(){
        lb_cliente.setText(this.traducoes.getString("lb_cliente"));
        lb_instrutor.setText(this.traducoes.getString("lb_instrutor"));
        lb_plano.setText(this.traducoes.getString("lb_plano"));
        lb_exercicio.setText(this.traducoes.getString("lb_exercicio"));
        lb_modalidade.setText(this.traducoes.getString("lb_modalidade"));
        lb_treino.setText(this.traducoes.getString("lb_treino"));
        lb_titCPF.setText(this.traducoes.getString("lb_titCPF"));
        lb_titDadosPess.setText(this.traducoes.getString("lb_titDadosPess"));
        lb_Nome.setText(this.traducoes.getString("lb_Nome"));
        lb_titModalidade.setText(this.traducoes.getString("lb_titModalidade"));
        lb_tipoModalidade.setText(this.traducoes.getString("lb_tipoModalidade"));
        lb_txtAlterar.setText(this.traducoes.getString("lb_txtAlterar"));
        lb_txtDeletar.setText(this.traducoes.getString("lb_txtDeletarIns"));
    }
    
    public void inicializaCbBoxCpf(){
        listaInstrutor = Main.controllerManager.getInstrutorAlterarController().retornaListaInstrutores();
        
        for(Instrutor i : listaInstrutor){
            cb_CPF.addItem(i.getCpf());
        }
    }
    
    public String[] inicializaVetorModalidades(List<Modalidade> modalidades){
        String [] vetorModalidades = new String[8];
        
        vetorModalidades = new String [8];
        for(int i=0; i<8; i++){
            vetorModalidades[i] = ""; 
        }
        
      
        for(int i=0; i<modalidades.size(); i++){
            vetorModalidades[i] = modalidades.get(i).getNome();
        }
        return vetorModalidades;
    }
   
    public void inicializaCheckBoxesNomes(){
        modalidadesTotal = Main.controllerManager.getInstrutorAlterarController().retornaTodasModalidades();
        
        vetorModalidade = inicializaVetorModalidades(modalidadesTotal);
        
        if(!vetorModalidade[0].equals("")){
            jCheckBox2.setText(vetorModalidade[0]);
        }
        else{
            System.out.println("entrou aqui");
            jCheckBox2.setVisible(false);
        }
        
        if(!vetorModalidade[1].equals("")){
            jCheckBox3.setText(vetorModalidade[1]);
        }
        else{
            jCheckBox3.setVisible(false);
        }
        
        if(!vetorModalidade[2].equals("")){
            jCheckBox4.setText(vetorModalidade[2]);
        }
        else{
            jCheckBox4.setVisible(false);
        }
        
        if(!vetorModalidade[3].equals("")){
            jCheckBox5.setText(vetorModalidade[3]);
        }
        else{
            jCheckBox5.setVisible(false);
        }
        
        if(!vetorModalidade[4].equals("")){
            jCheckBox6.setText(vetorModalidade[4]);
        }
        else{
            jCheckBox6.setVisible(false);
        }
        
        if(!vetorModalidade[5].equals("")){
            jCheckBox7.setText(vetorModalidade[5]);
        }
        else{
            jCheckBox7.setVisible(false);
        }
        
        if(!vetorModalidade[6].equals("")){
            jCheckBox8.setText(vetorModalidade[6]);
        }
        else{
            jCheckBox8.setVisible(false);
        }
        
        if(!vetorModalidade[7].equals("")){
            jCheckBox9.setText(vetorModalidade[7]);
        }
        else{
            jCheckBox9.setVisible(false);
        }
    }
       
    public void inicializaCheckBoxesCheck() throws SQLException{
        modalidadesAntigas = Main.controllerManager.getInstrutorAlterarController().retornaModalidadesDoInstrutor(instrutor.getId());
        boolean []vetor = new boolean[8];
        List<Integer> indicesAntigos = new ArrayList();
        
        for(int i=0; i<8;i++){
            vetor[i] = false;
        }
        
        //achar o indice da modalidade antiga
        for(int i=0; i<modalidadesAntigas.size(); i++){
            for(int j=0; j<modalidadesTotal.size(); j++){
                if(modalidadesAntigas.get(i).getId() == modalidadesTotal.get(j).getId()){
                    indicesAntigos.add(j);
                }
            }
        }
        
        
        for(int i=0; i<indicesAntigos.size(); i++){
            for(int j=0; j<8; j++){
                if(indicesAntigos.get(i) == j){
                    vetor[j] = true;
                }
            }
        }
        
        if(vetor[0]){
            jCheckBox2.setSelected(true);
        }
        if(vetor[1]){
            jCheckBox3.setSelected(true);
        }
        if(vetor[2]){
            jCheckBox4.setSelected(true);
        }
        if(vetor[3]){
            jCheckBox5.setSelected(true);
        }
        if(vetor[4]){
            jCheckBox6.setSelected(true);
        }
        if(vetor[5]){
            jCheckBox7.setSelected(true);
        }
        if(vetor[6]){
            jCheckBox8.setSelected(true);
        }
        if(vetor[7]){
            jCheckBox9.setSelected(true);
        }
    }
    
    public void resetarCheckBoxes(){
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
    }
    
    public boolean [] retornaboleanoCheckBoxs(){
        boolean [] checkBoxs = new boolean[8];
        
        if(jCheckBox2.isSelected()){
            checkBoxs[0] = true;
        }
        else{
            checkBoxs[0] = false;
        }
        
        if(jCheckBox3.isSelected()){
            checkBoxs[1] = true;
        }
        else{
            checkBoxs[1] = false;
        }
        
        if(jCheckBox4.isSelected()){
            checkBoxs[2] = true;
        }
        else{
            checkBoxs[2] = false;
        }
        
        if(jCheckBox5.isSelected()){
            checkBoxs[3] = true;
        }
        else{
            checkBoxs[3] = false;
        }
        
        if(jCheckBox6.isSelected()){
            checkBoxs[4] = true;
        }
        else{
            checkBoxs[4] = false;
        }
        
        if(jCheckBox7.isSelected()){
            checkBoxs[5] = true;
        }
        else{
            checkBoxs[5] = false;
        }
        
        if(jCheckBox8.isSelected()){
            checkBoxs[6] = true;
        }
        else{
            checkBoxs[6] = false;
        }
        
        if(jCheckBox9.isSelected()){
            checkBoxs[7] = true;
        }
        else{
            checkBoxs[7] = false;
        }
        
        return checkBoxs;
    }
    
    public void iniciaCampos(){
        tf_Nome.setText(instrutor.getNome());
        inicializaCheckBoxesNomes();
        resetarCheckBoxes();
        try {
            inicializaCheckBoxesCheck();
        } catch (SQLException ex) {
            Logger.getLogger(TelaPlanoAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_Nome = new javax.swing.JLabel();
        lb_titModalidade = new javax.swing.JLabel();
        lb_titDadosPess = new javax.swing.JLabel();
        lb_logo = new javax.swing.JLabel();
        lb_cliente = new javax.swing.JLabel();
        lb_treino = new javax.swing.JLabel();
        lb_modalidade = new javax.swing.JLabel();
        lb_exercicio = new javax.swing.JLabel();
        lb_instrutor = new javax.swing.JLabel();
        lb_plano = new javax.swing.JLabel();
        lb_sideBar = new javax.swing.JLabel();
        tf_Nome = new javax.swing.JTextField();
        lb_titCPF = new javax.swing.JLabel();
        lb_txtDeletar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_btDeletar = new javax.swing.JLabel();
        lb_txtAlterar = new javax.swing.JLabel();
        lb_btAlterar = new javax.swing.JLabel();
        cb_CPF = new javax.swing.JComboBox<>();
        lb_tipoModalidade = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        lb_Nome.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Nome.setText("Nome:");
        add(lb_Nome);
        lb_Nome.setBounds(330, 270, 80, 20);

        lb_titModalidade.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titModalidade.setText("Modalidade");
        add(lb_titModalidade);
        lb_titModalidade.setBounds(330, 350, 170, 20);

        lb_titDadosPess.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titDadosPess.setText("Dados Pessoais:");
        add(lb_titDadosPess);
        lb_titDadosPess.setBounds(330, 240, 190, 20);

        lb_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/preto.png"))); // NOI18N
        add(lb_logo);
        lb_logo.setBounds(30, 40, 190, 120);

        lb_cliente.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lb_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cliente.setText("Cliente");
        lb_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_clienteMouseClicked(evt);
            }
        });
        add(lb_cliente);
        lb_cliente.setBounds(0, 190, 250, 40);

        lb_treino.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_treino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_treino.setText("Treino");
        lb_treino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_treino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_treinoMouseClicked(evt);
            }
        });
        add(lb_treino);
        lb_treino.setBounds(0, 490, 250, 40);

        lb_modalidade.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_modalidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_modalidade.setText("Modalidade");
        lb_modalidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_modalidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_modalidadeMouseClicked(evt);
            }
        });
        add(lb_modalidade);
        lb_modalidade.setBounds(0, 430, 250, 40);

        lb_exercicio.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_exercicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_exercicio.setText("Exercício");
        lb_exercicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_exercicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_exercicioMouseClicked(evt);
            }
        });
        add(lb_exercicio);
        lb_exercicio.setBounds(0, 370, 250, 40);

        lb_instrutor.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_instrutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_instrutor.setText("Instrutor");
        lb_instrutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_instrutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_instrutorMouseClicked(evt);
            }
        });
        add(lb_instrutor);
        lb_instrutor.setBounds(0, 250, 250, 40);

        lb_plano.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_plano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_plano.setText("Plano");
        lb_plano.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_plano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_planoMouseClicked(evt);
            }
        });
        add(lb_plano);
        lb_plano.setBounds(0, 310, 250, 40);

        lb_sideBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sidebar_verde.png"))); // NOI18N
        add(lb_sideBar);
        lb_sideBar.setBounds(0, 0, 254, 720);

        tf_Nome.setBackground(new java.awt.Color(238, 238, 238));
        tf_Nome.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_Nome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NomeActionPerformed(evt);
            }
        });
        add(tf_Nome);
        tf_Nome.setBounds(330, 290, 320, 40);

        lb_titCPF.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titCPF.setText("CPF selecionado");
        add(lb_titCPF);
        lb_titCPF.setBounds(330, 140, 190, 20);

        lb_txtDeletar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_txtDeletar.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtDeletar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtDeletar.setText("DELETAR INSTRUTOR");
        lb_txtDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtDeletarMouseClicked(evt);
            }
        });
        add(lb_txtDeletar);
        lb_txtDeletar.setBounds(980, 600, 260, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linha-div.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(940, 0, 20, 720);

        lb_btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-vermelho.png"))); // NOI18N
        lb_btDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_btDeletarMouseClicked(evt);
            }
        });
        add(lb_btDeletar);
        lb_btDeletar.setBounds(980, 580, 260, 70);

        lb_txtAlterar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_txtAlterar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtAlterar.setText("ALTERAR DADOS");
        lb_txtAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtAlterarMouseClicked(evt);
            }
        });
        add(lb_txtAlterar);
        lb_txtAlterar.setBounds(980, 510, 260, 30);

        lb_btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-verde.png"))); // NOI18N
        lb_btAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_btAlterarMouseClicked(evt);
            }
        });
        add(lb_btAlterar);
        lb_btAlterar.setBounds(980, 490, 260, 70);

        cb_CPF.setBackground(new java.awt.Color(153, 255, 51));
        cb_CPF.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        cb_CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_CPFActionPerformed(evt);
            }
        });
        add(cb_CPF);
        cb_CPF.setBounds(330, 165, 320, 40);

        lb_tipoModalidade.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_tipoModalidade.setText("Modalidade ensinadas:");
        add(lb_tipoModalidade);
        lb_tipoModalidade.setBounds(330, 380, 230, 30);

        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        add(jCheckBox2);
        jCheckBox2.setBounds(330, 420, 190, 30);
        add(jCheckBox3);
        jCheckBox3.setBounds(540, 420, 180, 30);
        add(jCheckBox4);
        jCheckBox4.setBounds(330, 460, 190, 30);
        add(jCheckBox5);
        jCheckBox5.setBounds(540, 460, 180, 30);
        add(jCheckBox6);
        jCheckBox6.setBounds(330, 500, 190, 30);
        add(jCheckBox7);
        jCheckBox7.setBounds(540, 500, 180, 30);

        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        add(jCheckBox8);
        jCheckBox8.setBounds(330, 540, 190, 30);

        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });
        add(jCheckBox9);
        jCheckBox9.setBounds(540, 540, 180, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NomeActionPerformed

    private void lb_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_clienteMouseClicked
        Main.controllerManager.btAcessarTelaCliente();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_clienteMouseClicked

    private void lb_planoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_planoMouseClicked
        Main.controllerManager.btAcessarTelaPlano();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_planoMouseClicked

    private void lb_exercicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exercicioMouseClicked
        Main.controllerManager.btAcessartelaExercicio();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_exercicioMouseClicked

    private void lb_modalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_modalidadeMouseClicked
        Main.controllerManager.btAcessarTelaModalidade();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_modalidadeMouseClicked

    private void lb_treinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_treinoMouseClicked
        Main.controllerManager.btAcessarTelaTreino();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_treinoMouseClicked

    private void lb_instrutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_instrutorMouseClicked
        Main.controllerManager.btAcessarTelaInstrutor();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_instrutorMouseClicked

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void cb_CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_CPFActionPerformed
        instrutor = Main.controllerManager.getInstrutorAlterarController().retornaInstrutorPeloCPf(cb_CPF.getSelectedItem().toString(), listaInstrutor);
        iniciaCampos();       
    }//GEN-LAST:event_cb_CPFActionPerformed

    private void lb_txtAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtAlterarMouseClicked
         modalidadesNovas = Main.controllerManager.getInstrutorAlterarController().retornaModalidadesSelecionadas(retornaboleanoCheckBoxs(), modalidadesTotal);
        if(Main.controllerManager.getInstrutorAlterarController().alteraModalidades(instrutor, modalidadesAntigas, modalidadesNovas)){
            JOptionPane.showMessageDialog(null, "Instrutor alterado com sucesso");
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro na alteração do instrutor, tente novamente mais tarde");
        }
    }//GEN-LAST:event_lb_txtAlterarMouseClicked

    private void lb_btAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_btAlterarMouseClicked
        modalidadesNovas = Main.controllerManager.getInstrutorAlterarController().retornaModalidadesSelecionadas(retornaboleanoCheckBoxs(), modalidadesTotal);
        
        if(Main.controllerManager.getInstrutorAlterarController().alteraModalidades(instrutor, modalidadesAntigas, modalidadesNovas)){
            JOptionPane.showMessageDialog(null, "Instrutor alterado com sucesso");
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro na alteração do instrutor, tente novamente mais tarde");
        }      
    }//GEN-LAST:event_lb_btAlterarMouseClicked

    private void lb_txtDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtDeletarMouseClicked
        if(Main.controllerManager.getInstrutorAlterarController().deletaInstrutor(instrutor.getId())){
            JOptionPane.showMessageDialog(null, "Instrutor excluido com sucesso");
            cb_CPF.removeItem(cb_CPF.getSelectedItem());
        }
        else{
            JOptionPane.showMessageDialog(null, "erro ao excluir o instrutor, tente novamente mais tarde");
        }
    }//GEN-LAST:event_lb_txtDeletarMouseClicked

    private void lb_btDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_btDeletarMouseClicked
        if(Main.controllerManager.getInstrutorAlterarController().deletaInstrutor(instrutor.getId())){
            JOptionPane.showMessageDialog(null, "Instrutor excluido com sucesso");
            cb_CPF.removeItem(cb_CPF.getSelectedItem());
        }
        else{
            JOptionPane.showMessageDialog(null, "erro ao excluir o instrutor, tente novamente mais tarde");
        }        
    }//GEN-LAST:event_lb_btDeletarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_CPF;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_Nome;
    private javax.swing.JLabel lb_btAlterar;
    private javax.swing.JLabel lb_btDeletar;
    private javax.swing.JLabel lb_cliente;
    private javax.swing.JLabel lb_exercicio;
    private javax.swing.JLabel lb_instrutor;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_modalidade;
    private javax.swing.JLabel lb_plano;
    private javax.swing.JLabel lb_sideBar;
    private javax.swing.JLabel lb_tipoModalidade;
    private javax.swing.JLabel lb_titCPF;
    private javax.swing.JLabel lb_titDadosPess;
    private javax.swing.JLabel lb_titModalidade;
    private javax.swing.JLabel lb_treino;
    private javax.swing.JLabel lb_txtAlterar;
    private javax.swing.JLabel lb_txtDeletar;
    private javax.swing.JTextField tf_Nome;
    // End of variables declaration//GEN-END:variables
}
