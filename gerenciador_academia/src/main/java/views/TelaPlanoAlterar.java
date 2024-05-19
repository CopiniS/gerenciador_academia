/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import controller.Main;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Modalidade;
import models.Plano;

/**
 *
 * @author alunolages
 */
public class TelaPlanoAlterar extends javax.swing.JPanel {
    List<Plano> planos;
    Plano plano;
    List<Modalidade> modalidadesTotal;
    List<Modalidade> modalidadesAntigas;
    List<Modalidade> modalidadesNovas;
    String []vetorModalidade;
    private ResourceBundle traducoes;
    
    /**
     * Creates new form TelaPlanoAlterar
     */
    public TelaPlanoAlterar() {
        initComponents();
        this.traducoes = Main.controllerManager.getTraducoes();
        this.traduzir();
        inicializaCbBox();
    }
    
    public void traduzir(){
        lb_cliente.setText(this.traducoes.getString("lb_cliente"));
        lb_instrutor.setText(this.traducoes.getString("lb_instrutor"));
        lb_plano.setText(this.traducoes.getString("lb_plano"));
        lb_exercicio.setText(this.traducoes.getString("lb_exercicio"));
        lb_modalidade.setText(this.traducoes.getString("lb_modalidade"));
        lb_treino.setText(this.traducoes.getString("lb_treino"));
        lb_titPlano.setText(this.traducoes.getString("lb_titPlano"));
        lb_SelecionePlan.setText(this.traducoes.getString("lb_SelecionePlan"));
        lb_TempoContrato.setText(this.traducoes.getString("lb_TempoContrato"));
        lb_titModalidade.setText(this.traducoes.getString("lb_titModalidadePlan"));
        lb_titValor.setText(this.traducoes.getString("lb_titValor"));
        lb_txtAddPlano.setText(this.traducoes.getString("lb_txtAlterarPlan"));
        lb_txtDeletar.setText(this.traducoes.getString("lb_txtDeletarPlan"));
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
    
    public void inicializaCbBox(){
        planos = Main.controllerManager.getPlanoAlterarController().retornaListaPlanos();
        
        for(Plano p : planos){
            cb_Plano.addItem(p.getNome());
        }
    }
    
    public void inicializaCheckBoxesNomes(){
        modalidadesTotal = Main.controllerManager.getPlanoAlterarController().retornaTodasModalidades();
        
        vetorModalidade = inicializaVetorModalidades(modalidadesTotal);
        
        if(!vetorModalidade[0].equals("")){
            jCheckBox2.setText(vetorModalidade[0]);
        }
        else{
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
        modalidadesAntigas = Main.controllerManager.getPlanoAlterarController().retornaModalidadesDoPlano(plano);
        boolean []vetor = new boolean[8];
        
        for(int i=0; i<8;i++){
            vetor[i] = false;
        }
        for(int i=0; i<modalidadesAntigas.size(); i++){
            for(int j=0; j<8; j++){
                if(modalidadesAntigas.get(i).getId() == j+1){
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
        tf_TempoContrato.setText(String.valueOf(plano.getTempoAtivacao()));
        tf_Valor.setText(String.valueOf(plano.getValor()));
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

        tf_Valor = new javax.swing.JTextField();
        lb_TempoContrato = new javax.swing.JLabel();
        lb_SelecionePlan = new javax.swing.JLabel();
        lb_titValor = new javax.swing.JLabel();
        lb_titModalidade = new javax.swing.JLabel();
        lb_titPlano = new javax.swing.JLabel();
        lb_logo = new javax.swing.JLabel();
        lb_cliente = new javax.swing.JLabel();
        lb_treino = new javax.swing.JLabel();
        lb_modalidade = new javax.swing.JLabel();
        lb_exercicio = new javax.swing.JLabel();
        lb_instrutor = new javax.swing.JLabel();
        lb_plano = new javax.swing.JLabel();
        lb_sideBar = new javax.swing.JLabel();
        lb_txtAddPlano = new javax.swing.JLabel();
        lb_botaoAddPlano = new javax.swing.JLabel();
        tf_TempoContrato = new javax.swing.JTextField();
        cb_Plano = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        lb_txtDeletar = new javax.swing.JLabel();
        lb_btDeletar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        tf_Valor.setBackground(new java.awt.Color(238, 238, 238));
        tf_Valor.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_Valor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ValorActionPerformed(evt);
            }
        });
        add(tf_Valor);
        tf_Valor.setBounds(330, 550, 320, 40);

        lb_TempoContrato.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_TempoContrato.setText("Tempo Contrato:");
        add(lb_TempoContrato);
        lb_TempoContrato.setBounds(330, 215, 180, 20);

        lb_SelecionePlan.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_SelecionePlan.setText("Selecione o Plano:");
        add(lb_SelecionePlan);
        lb_SelecionePlan.setBounds(330, 130, 180, 30);

        lb_titValor.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titValor.setText("Valor");
        add(lb_titValor);
        lb_titValor.setBounds(330, 530, 170, 20);

        lb_titModalidade.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titModalidade.setText("Modalidades Inclusas");
        add(lb_titModalidade);
        lb_titModalidade.setBounds(330, 320, 320, 20);

        lb_titPlano.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titPlano.setText("Plano");
        add(lb_titPlano);
        lb_titPlano.setBounds(330, 110, 170, 20);

        lb_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/preto.png"))); // NOI18N
        add(lb_logo);
        lb_logo.setBounds(30, 40, 190, 120);

        lb_cliente.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
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

        lb_plano.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
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

        lb_txtAddPlano.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 16)); // NOI18N
        lb_txtAddPlano.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtAddPlano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtAddPlano.setText("Alterar Plano");
        lb_txtAddPlano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtAddPlanoMouseClicked(evt);
            }
        });
        add(lb_txtAddPlano);
        lb_txtAddPlano.setBounds(790, 420, 260, 30);

        lb_botaoAddPlano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-azul.png"))); // NOI18N
        lb_botaoAddPlano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_botaoAddPlanoMouseClicked(evt);
            }
        });
        add(lb_botaoAddPlano);
        lb_botaoAddPlano.setBounds(790, 400, 260, 70);

        tf_TempoContrato.setBackground(new java.awt.Color(238, 238, 238));
        tf_TempoContrato.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_TempoContrato.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_TempoContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_TempoContratoActionPerformed(evt);
            }
        });
        add(tf_TempoContrato);
        tf_TempoContrato.setBounds(330, 240, 320, 40);

        cb_Plano.setBackground(new java.awt.Color(153, 255, 51));
        cb_Plano.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        cb_Plano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_PlanoActionPerformed(evt);
            }
        });
        add(cb_Plano);
        cb_Plano.setBounds(330, 160, 320, 40);

        jCheckBox1.setText("jCheckBox1");
        add(jCheckBox1);
        jCheckBox1.setBounds(0, 0, 85, 20);

        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        add(jCheckBox2);
        jCheckBox2.setBounds(340, 360, 130, 30);
        add(jCheckBox3);
        jCheckBox3.setBounds(510, 360, 140, 30);
        add(jCheckBox4);
        jCheckBox4.setBounds(340, 400, 130, 30);
        add(jCheckBox5);
        jCheckBox5.setBounds(510, 400, 150, 40);
        add(jCheckBox6);
        jCheckBox6.setBounds(340, 440, 140, 30);
        add(jCheckBox7);
        jCheckBox7.setBounds(510, 440, 160, 40);

        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        add(jCheckBox8);
        jCheckBox8.setBounds(340, 480, 150, 30);

        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });
        add(jCheckBox9);
        jCheckBox9.setBounds(510, 480, 160, 30);

        lb_txtDeletar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_txtDeletar.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtDeletar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtDeletar.setText("Deletar Plano");
        lb_txtDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtDeletarMouseClicked(evt);
            }
        });
        add(lb_txtDeletar);
        lb_txtDeletar.setBounds(790, 530, 260, 30);

        lb_btDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-vermelho.png"))); // NOI18N
        lb_btDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_btDeletarMouseClicked(evt);
            }
        });
        add(lb_btDeletar);
        lb_btDeletar.setBounds(790, 510, 260, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ValorActionPerformed

    private void tf_TempoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TempoContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TempoContratoActionPerformed

    private void lb_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_clienteMouseClicked
        Main.controllerManager.btAcessarTelaCliente();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_clienteMouseClicked

    private void lb_instrutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_instrutorMouseClicked
        Main.controllerManager.btAcessarTelaInstrutor();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_instrutorMouseClicked

    private void lb_exercicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exercicioMouseClicked
        Main.controllerManager.btAcessartelaExercicio();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_exercicioMouseClicked

    private void lb_modalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_modalidadeMouseClicked
        Main.controllerManager.btAcessarTelaModalidade();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_modalidadeMouseClicked

    private void lb_treinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_treinoMouseClicked
        Main.controllerManager.btAcessarTelaTreino();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_treinoMouseClicked

    private void lb_planoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_planoMouseClicked
        Main.controllerManager.btAcessarTelaPlano();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_planoMouseClicked

    private void cb_PlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_PlanoActionPerformed
        plano = new Plano();
        plano = Main.controllerManager.getPlanoAlterarController().retornaPlanoPeloNome(cb_Plano.getSelectedItem().toString(), planos);
        iniciaCampos();
    }//GEN-LAST:event_cb_PlanoActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void lb_txtAddPlanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtAddPlanoMouseClicked

        plano.setTempoAtivacao(Integer.parseInt(tf_TempoContrato.getText()));
        plano.setValor(Float.parseFloat(tf_Valor.getText()));
        
        if(Main.controllerManager.getPlanoAlterarController().validaCamposGerais(retornaboleanoCheckBoxs(), tf_Valor.getText(), tf_TempoContrato.getText())){
            modalidadesNovas = Main.controllerManager.getPlanoAlterarController().retornaModalidadesSelecionadas(retornaboleanoCheckBoxs(), modalidadesTotal);

            Main.controllerManager.getPlanoAlterarController().alteraModalidades(plano, modalidadesAntigas, modalidadesNovas);
            Main.controllerManager.getPlanoAlterarController().alteraValorEMeses(plano);
            JOptionPane.showMessageDialog(null, "Alterações feitas com sucesso");
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro: Digite valores validos nos campos e escolha pelo menos uma modalidade");
            iniciaCampos();
        }
    }//GEN-LAST:event_lb_txtAddPlanoMouseClicked

    private void lb_botaoAddPlanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_botaoAddPlanoMouseClicked
        boolean[] vetorBooleano = retornaboleanoCheckBoxs();
        
        if(Main.controllerManager.getPlanoAlterarController().validaCamposGerais(vetorBooleano, tf_Valor.getText(), tf_TempoContrato.getText())){
            modalidadesNovas = Main.controllerManager.getPlanoAlterarController().retornaModalidadesSelecionadas(vetorBooleano, modalidadesTotal);
            if(Main.controllerManager.getPlanoAlterarController().alteraModalidades(plano, modalidadesAntigas, modalidadesNovas) 
                    && Main.controllerManager.getPlanoAlterarController().alteraValorEMeses(plano)){
                JOptionPane.showMessageDialog(null, "Alterações feitas com sucesso");
            }
            else{
                JOptionPane.showMessageDialog(null, "Problema na alteração do plano, tente novamente mais tarde");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro: Digite valores validos nos campos e escolha pelo menos uma modalidade");
            iniciaCampos();
        }
    }//GEN-LAST:event_lb_botaoAddPlanoMouseClicked

    private void lb_txtDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtDeletarMouseClicked
        if(Main.controllerManager.getPlanoAlterarController().deletarPlano(plano)){
            JOptionPane.showMessageDialog(null, "Plano deletado com sucesso");
            Main.controllerManager.getPlanoController().btAlterarPlano();
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro na exclusao do Plano, tente novamente mais tarde");
        }
            
    }//GEN-LAST:event_lb_txtDeletarMouseClicked

    private void lb_btDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_btDeletarMouseClicked
        if(Main.controllerManager.getPlanoAlterarController().deletarPlano(plano)){
            JOptionPane.showMessageDialog(null, "Plano deletado com sucesso");
            Main.controllerManager.getPlanoController().btAlterarPlano();
        }
        else{
            JOptionPane.showMessageDialog(null, "Erro na exclusao do Plano, tente novamente mais tarde");
        }
    }//GEN-LAST:event_lb_btDeletarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_Plano;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel lb_SelecionePlan;
    private javax.swing.JLabel lb_TempoContrato;
    private javax.swing.JLabel lb_botaoAddPlano;
    private javax.swing.JLabel lb_btDeletar;
    private javax.swing.JLabel lb_cliente;
    private javax.swing.JLabel lb_exercicio;
    private javax.swing.JLabel lb_instrutor;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_modalidade;
    private javax.swing.JLabel lb_plano;
    private javax.swing.JLabel lb_sideBar;
    private javax.swing.JLabel lb_titModalidade;
    private javax.swing.JLabel lb_titPlano;
    private javax.swing.JLabel lb_titValor;
    private javax.swing.JLabel lb_treino;
    private javax.swing.JLabel lb_txtAddPlano;
    private javax.swing.JLabel lb_txtDeletar;
    private javax.swing.JTextField tf_TempoContrato;
    private javax.swing.JTextField tf_Valor;
    // End of variables declaration//GEN-END:variables
}
