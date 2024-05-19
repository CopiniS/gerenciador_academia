package views;

import controller.Main;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import models.Modalidade;
import models.Plano;

public class TelaPlanoAdicionar extends javax.swing.JPanel {
    List<Modalidade> listaModalidades;
    String []vetorModalidade; 
    Plano plano;
    private ResourceBundle traducoes;
    
    public TelaPlanoAdicionar() {
        initComponents();     
        this.traducoes = Main.controllerManager.getTraducoes();
        this.traduzir();
        inicializaListaModalidade();
        inicializarCheckBoxs();
        verificaModalidadesVazias();
        
    }
    
    public void traduzir(){
        lb_cliente.setText(this.traducoes.getString("lb_cliente"));
        lb_instrutor.setText(this.traducoes.getString("lb_instrutor"));
        lb_plano.setText(this.traducoes.getString("lb_plano"));
        lb_exercicio.setText(this.traducoes.getString("lb_exercicio"));
        lb_modalidade.setText(this.traducoes.getString("lb_modalidade"));
        lb_treino.setText(this.traducoes.getString("lb_treino"));
        lb_titPlano.setText(this.traducoes.getString("lb_titPlano"));
        lb_Nome.setText(this.traducoes.getString("lb_NomePlan"));
        lb_TempoContrato.setText(this.traducoes.getString("lb_TempoContrato"));
        lb_titModalidade.setText((this.traducoes.getString("lb_titModalidadePlan")));
        lb_titValor.setText(this.traducoes.getString("lb_titValor"));
        lb_txtAddPlano.setText(this.traducoes.getString("lb_txtAddPlan"));
    }
    
    public void inicializaListaModalidade(){
        listaModalidades = Main.controllerManager.getPlanoAdicionarController().retornaListaModadalidade();
    }
    
    public void inicializaVetorModalidades(){
        vetorModalidade = new String [8];
        for(int i=0; i<8; i++){
            vetorModalidade[i] = "";
        }
        
      
        for(int i=0; i<listaModalidades.size(); i++){
            vetorModalidade[i] = listaModalidades.get(i).getNome();
        }
        
    }
    
    public void inicializarCheckBoxs(){
        inicializaVetorModalidades();
        
        if(!vetorModalidade[0].equals("")){
            jCheckBox1.setText(vetorModalidade[0]);
        }
        else{
            jCheckBox1.setVisible(false);
        }
        
        if(!vetorModalidade[1].equals("")){
            jCheckBox2.setText(vetorModalidade[1]);
        }
        else{
            jCheckBox2.setVisible(false);
        }
        
        if(!vetorModalidade[2].equals("")){
            jCheckBox3.setText(vetorModalidade[2]);
        }
        else{
            jCheckBox3.setVisible(false);
        }
        
        if(!vetorModalidade[3].equals("")){
            jCheckBox4.setText(vetorModalidade[3]);
        }
        else{
            jCheckBox4.setVisible(false);
        }
        
        if(!vetorModalidade[4].equals("")){
            jCheckBox5.setText(vetorModalidade[4]);
        }
        else{
            jCheckBox5.setVisible(false);
        }
        
        if(!vetorModalidade[5].equals("")){
            jCheckBox6.setText(vetorModalidade[5]);
        }
        else{
            jCheckBox6.setVisible(false);
        }
        
        if(!vetorModalidade[6].equals("")){
            jCheckBox7.setText(vetorModalidade[6]);
        }
        else{
            jCheckBox7.setVisible(false);
        }
        
        if(!vetorModalidade[7].equals("")){
            jCheckBox8.setText(vetorModalidade[7]);
        }
        else{
            jCheckBox8.setVisible(false);
        }
        
    }
    
    public boolean [] retornaboleanoCheckBoxs(){
        boolean [] checkBoxs = new boolean[8];
        
        if(jCheckBox1.isSelected()){
            checkBoxs[0] = true;
        }
        else{
            checkBoxs[0] = false;
        }
        
        if(jCheckBox2.isSelected()){
            checkBoxs[1] = true;
        }
        else{
            checkBoxs[1] = false;
        }
        
        if(jCheckBox3.isSelected()){
            checkBoxs[2] = true;
        }
        else{
            checkBoxs[2] = false;
        }
        
        if(jCheckBox4.isSelected()){
            checkBoxs[3] = true;
        }
        else{
            checkBoxs[3] = false;
        }
        
        if(jCheckBox5.isSelected()){
            checkBoxs[4] = true;
        }
        else{
            checkBoxs[4] = false;
        }
        
        if(jCheckBox6.isSelected()){
            checkBoxs[5] = true;
        }
        else{
            checkBoxs[5] = false;
        }
        
        if(jCheckBox7.isSelected()){
            checkBoxs[6] = true;
        }
        else{
            checkBoxs[6] = false;
        }
        
        if(jCheckBox8.isSelected()){
            checkBoxs[7] = true;
        }
        else{
            checkBoxs[7] = false;
        }
        
        return checkBoxs;
    }
    
    public void resetaCampos(){
        tf_Nome.setText("");
        tf_TempoContrato.setText("");
        tf_Valor.setText("");
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
    }
    
    public void verificaModalidadesVazias(){
        if(!Main.controllerManager.getPlanoAdicionarController().verificaModalidadesvazias(listaModalidades)){
            JOptionPane.showMessageDialog(null, "Cadastre pelo menos uma modalidade para ter acesso ao cadastro de planos");
            Main.controllerManager.btAcessarTelaPlano();
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_TempoContrato = new javax.swing.JLabel();
        lb_Nome = new javax.swing.JLabel();
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
        tf_Valor = new javax.swing.JTextField();
        tf_TempoContrato = new javax.swing.JTextField();
        tf_Nome = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        lb_TempoContrato.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_TempoContrato.setText("Tempo Contrato:");
        add(lb_TempoContrato);
        lb_TempoContrato.setBounds(330, 215, 180, 20);

        lb_Nome.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Nome.setText("Nome Plano: (meses)");
        add(lb_Nome);
        lb_Nome.setBounds(330, 130, 180, 30);

        lb_titValor.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titValor.setText("Valor");
        add(lb_titValor);
        lb_titValor.setBounds(330, 535, 170, 20);

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_planoMouseEntered(evt);
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
        lb_txtAddPlano.setText("ADICIONAR PLANO");
        lb_txtAddPlano.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_txtAddPlano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtAddPlanoMouseClicked(evt);
            }
        });
        add(lb_txtAddPlano);
        lb_txtAddPlano.setBounds(970, 560, 260, 30);

        lb_botaoAddPlano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-azul.png"))); // NOI18N
        lb_botaoAddPlano.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_botaoAddPlano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_botaoAddPlanoMouseClicked(evt);
            }
        });
        add(lb_botaoAddPlano);
        lb_botaoAddPlano.setBounds(970, 540, 260, 70);

        tf_Valor.setBackground(new java.awt.Color(238, 238, 238));
        tf_Valor.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_Valor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ValorActionPerformed(evt);
            }
        });
        add(tf_Valor);
        tf_Valor.setBounds(330, 560, 320, 40);

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

        tf_Nome.setBackground(new java.awt.Color(238, 238, 238));
        tf_Nome.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_Nome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NomeActionPerformed(evt);
            }
        });
        add(tf_Nome);
        tf_Nome.setBounds(330, 160, 320, 40);

        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(340, 360, 130, 30);
        add(jCheckBox2);
        jCheckBox2.setBounds(510, 360, 140, 30);
        add(jCheckBox3);
        jCheckBox3.setBounds(340, 400, 130, 30);
        add(jCheckBox4);
        jCheckBox4.setBounds(510, 400, 140, 30);
        add(jCheckBox5);
        jCheckBox5.setBounds(340, 440, 140, 30);
        add(jCheckBox6);
        jCheckBox6.setBounds(510, 440, 150, 30);

        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        add(jCheckBox7);
        jCheckBox7.setBounds(340, 480, 150, 30);

        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        add(jCheckBox8);
        jCheckBox8.setBounds(510, 480, 160, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ValorActionPerformed

    private void tf_TempoContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_TempoContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_TempoContratoActionPerformed

    private void tf_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NomeActionPerformed

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

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void lb_botaoAddPlanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_botaoAddPlanoMouseClicked
        List<Modalidade> selecionados;
        
        if(Main.controllerManager.getPlanoAdicionarController().validaCamposGerais(tf_Nome.getText(), retornaboleanoCheckBoxs(), tf_Valor.getText(), tf_TempoContrato.getText())){
            plano = new Plano();
            plano.setNome(tf_Nome.getText());
            plano.setValor(Float.parseFloat(tf_Valor.getText()));
            plano.setTempoAtivacao(Integer.parseInt(tf_TempoContrato.getText()));
            
            selecionados = Main.controllerManager.getPlanoAdicionarController().retornaModalidadesSelecionadas(retornaboleanoCheckBoxs(), listaModalidades);
            if(Main.controllerManager.getPlanoAdicionarController().btAddPlano(plano, selecionados)){
                JOptionPane.showMessageDialog(null, "Plano cadastrado com sucesso");
                resetaCampos();
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Erro: Digite valores validos nos campos e escolha pelo menos uma modalidade");
            resetaCampos();
        }
    }//GEN-LAST:event_lb_botaoAddPlanoMouseClicked

    private void lb_planoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_planoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_planoMouseEntered

    private void lb_planoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_planoMouseClicked
        Main.controllerManager.btAcessarTelaPlano();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_planoMouseClicked

    private void lb_txtAddPlanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtAddPlanoMouseClicked
        List<Modalidade> selecionados;
        
        if(Main.controllerManager.getPlanoAdicionarController().validaCamposGerais(tf_Nome.getText(), retornaboleanoCheckBoxs(), tf_Valor.getText(), tf_TempoContrato.getText())){
            plano = new Plano();
            plano.setNome(tf_Nome.getText());
            plano.setValor(Float.parseFloat(tf_Valor.getText()));
            plano.setTempoAtivacao(Integer.parseInt(tf_TempoContrato.getText()));
            
            selecionados = Main.controllerManager.getPlanoAdicionarController().retornaModalidadesSelecionadas(retornaboleanoCheckBoxs(), listaModalidades);
            if(Main.controllerManager.getPlanoAdicionarController().btAddPlano(plano, selecionados)){
                JOptionPane.showMessageDialog(null, "Plano cadastrado com sucesso");
                resetaCampos();
            }
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Erro: Digite valores validos nos campos e escolha pelo menos uma modalidade");
            resetaCampos();
        }
    }//GEN-LAST:event_lb_txtAddPlanoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JLabel lb_Nome;
    private javax.swing.JLabel lb_TempoContrato;
    private javax.swing.JLabel lb_botaoAddPlano;
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
    private javax.swing.JTextField tf_Nome;
    private javax.swing.JTextField tf_TempoContrato;
    private javax.swing.JTextField tf_Valor;
    // End of variables declaration//GEN-END:variables
}
