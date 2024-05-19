/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import controller.Main;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import models.Modalidade;

/**
 *
 * @author alunolages
 */
public class TelaModalidadeAdicionar extends javax.swing.JPanel {
    Modalidade modalidade;
    private ResourceBundle traducoes;
    /**
     * Creates new form TelaModalidadeAdicionar
     */
    public TelaModalidadeAdicionar() {
        initComponents();
        this.traducoes = Main.controllerManager.getTraducoes();
        traduzir();
        this.modalidade = new Modalidade();
    }
    
    public void traduzir(){
        lb_cliente.setText(this.traducoes.getString("lb_cliente"));
        lb_instrutor.setText(this.traducoes.getString("lb_instrutor"));
        lb_plano.setText(this.traducoes.getString("lb_plano"));
        lb_exercicio.setText(this.traducoes.getString("lb_exercicio"));
        lb_modalidade.setText(this.traducoes.getString("lb_modalidade"));
        lb_treino.setText(this.traducoes.getString("lb_treino"));
        lb_titModalidade.setText(this.traducoes.getString("lb_titModalidade"));
        lb_Nome.setText(this.traducoes.getString("lb_NomeModa"));
        lb_txtAddModalidade.setText(this.traducoes.getString("lb_txtAddModa"));
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
        lb_logo = new javax.swing.JLabel();
        lb_cliente = new javax.swing.JLabel();
        lb_treino = new javax.swing.JLabel();
        lb_modalidade = new javax.swing.JLabel();
        lb_exercicio = new javax.swing.JLabel();
        lb_instrutor = new javax.swing.JLabel();
        lb_plano = new javax.swing.JLabel();
        lb_sideBar = new javax.swing.JLabel();
        lb_txtAddModalidade = new javax.swing.JLabel();
        lb_botaoAddModalidade = new javax.swing.JLabel();
        tf_Nome = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        lb_Nome.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Nome.setText("Nome Modalidade");
        add(lb_Nome);
        lb_Nome.setBounds(640, 270, 180, 30);

        lb_titModalidade.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titModalidade.setText("Modalidade");
        lb_titModalidade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(lb_titModalidade);
        lb_titModalidade.setBounds(640, 240, 150, 20);

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

        lb_modalidade.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
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

        lb_txtAddModalidade.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 16)); // NOI18N
        lb_txtAddModalidade.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtAddModalidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtAddModalidade.setText("ADICIONAR MODALIDADE");
        lb_txtAddModalidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_txtAddModalidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtAddModalidadeMouseClicked(evt);
            }
        });
        add(lb_txtAddModalidade);
        lb_txtAddModalidade.setBounds(640, 390, 260, 30);

        lb_botaoAddModalidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-azul.png"))); // NOI18N
        lb_botaoAddModalidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_botaoAddModalidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_botaoAddModalidadeMouseClicked(evt);
            }
        });
        add(lb_botaoAddModalidade);
        lb_botaoAddModalidade.setBounds(640, 370, 260, 70);

        tf_Nome.setBackground(new java.awt.Color(238, 238, 238));
        tf_Nome.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_Nome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NomeActionPerformed(evt);
            }
        });
        add(tf_Nome);
        tf_Nome.setBounds(640, 300, 340, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NomeActionPerformed

    private void lb_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_clienteMouseClicked
        Main.controllerManager.btAcessarTelaCliente();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_clienteMouseClicked

    private void lb_instrutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_instrutorMouseClicked
        Main.controllerManager.btAcessarTelaInstrutor();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_instrutorMouseClicked

    private void lb_planoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_planoMouseClicked
        Main.controllerManager.btAcessarTelaPlano();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_planoMouseClicked

    private void lb_exercicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exercicioMouseClicked
        Main.controllerManager.btAcessartelaExercicio();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_exercicioMouseClicked

    private void lb_treinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_treinoMouseClicked
        Main.controllerManager.btAcessarTelaTreino();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_treinoMouseClicked

    private void lb_txtAddModalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtAddModalidadeMouseClicked
        if(Main.controllerManager.getModalidadeAdicionarController().verificaSeListaTem8()){
            if(Main.controllerManager.getModalidadeAdicionarController().validaCampo(tf_Nome.getText())){
                this.modalidade.setNome(tf_Nome.getText());
                Main.controllerManager.getModalidadeAdicionarController().btAddModalidade(modalidade);
            }
            else{
                JOptionPane.showMessageDialog(null, "Preencha o campo nome da modalidade");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Você ja tem o limite máximo de modalidades para sua assinatura. Para adicionar mais, remova alguma");
        }
    }//GEN-LAST:event_lb_txtAddModalidadeMouseClicked

    private void lb_botaoAddModalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_botaoAddModalidadeMouseClicked
        if(Main.controllerManager.getModalidadeAdicionarController().verificaSeListaTem8()){
            if(Main.controllerManager.getModalidadeAdicionarController().validaCampo(tf_Nome.getText())){
                this.modalidade.setNome(tf_Nome.getText());
                Main.controllerManager.getModalidadeAdicionarController().btAddModalidade(modalidade);
            }
            else{
                JOptionPane.showMessageDialog(null, "Preencha o campo nome da modalidade");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Você ja tem o limite máximo de modalidades para sua assinatura. Para adicionar mais, remova alguma");
        }
    }//GEN-LAST:event_lb_botaoAddModalidadeMouseClicked

    private void lb_modalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_modalidadeMouseClicked
        Main.controllerManager.btAcessarTelaModalidade();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_modalidadeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_Nome;
    private javax.swing.JLabel lb_botaoAddModalidade;
    private javax.swing.JLabel lb_cliente;
    private javax.swing.JLabel lb_exercicio;
    private javax.swing.JLabel lb_instrutor;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_modalidade;
    private javax.swing.JLabel lb_plano;
    private javax.swing.JLabel lb_sideBar;
    private javax.swing.JLabel lb_titModalidade;
    private javax.swing.JLabel lb_treino;
    private javax.swing.JLabel lb_txtAddModalidade;
    private javax.swing.JTextField tf_Nome;
    // End of variables declaration//GEN-END:variables
}
