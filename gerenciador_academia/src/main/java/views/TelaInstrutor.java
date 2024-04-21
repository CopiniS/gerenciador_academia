
package views;

import controller.Main;


public class TelaInstrutor extends javax.swing.JPanel {

    public TelaInstrutor() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_treino = new javax.swing.JLabel();
        lb_modalidade = new javax.swing.JLabel();
        lb_exercicio = new javax.swing.JLabel();
        lb_plano = new javax.swing.JLabel();
        lb_instrutor = new javax.swing.JLabel();
        lb_cliente = new javax.swing.JLabel();
        lb_txtMostrar = new javax.swing.JLabel();
        lb_botaoMostrar = new javax.swing.JLabel();
        lb_txtAlterar = new javax.swing.JLabel();
        lb_botaoAlterar = new javax.swing.JLabel();
        lb_txtAdd = new javax.swing.JLabel();
        lb_botaoAdd = new javax.swing.JLabel();
        lb_logo = new javax.swing.JLabel();
        lb_bkg = new javax.swing.JLabel();

        setLayout(null);

        lb_treino.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_treino.setForeground(new java.awt.Color(255, 255, 255));
        lb_treino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_treino.setText("Treino");
        lb_treino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_treino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_treinoMouseClicked(evt);
            }
        });
        add(lb_treino);
        lb_treino.setBounds(0, 500, 260, 40);

        lb_modalidade.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_modalidade.setForeground(new java.awt.Color(255, 255, 255));
        lb_modalidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_modalidade.setText("Modalidade");
        lb_modalidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_modalidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_modalidadeMouseClicked(evt);
            }
        });
        add(lb_modalidade);
        lb_modalidade.setBounds(0, 440, 260, 40);

        lb_exercicio.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_exercicio.setForeground(new java.awt.Color(255, 255, 255));
        lb_exercicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_exercicio.setText("Exercício");
        lb_exercicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_exercicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_exercicioMouseClicked(evt);
            }
        });
        add(lb_exercicio);
        lb_exercicio.setBounds(0, 380, 260, 40);

        lb_plano.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_plano.setForeground(new java.awt.Color(255, 255, 255));
        lb_plano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_plano.setText("Plano");
        lb_plano.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_plano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_planoMouseClicked(evt);
            }
        });
        add(lb_plano);
        lb_plano.setBounds(0, 320, 260, 40);

        lb_instrutor.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lb_instrutor.setForeground(new java.awt.Color(255, 255, 255));
        lb_instrutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_instrutor.setText("Instrutor");
        lb_instrutor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lb_instrutor);
        lb_instrutor.setBounds(0, 260, 260, 40);

        lb_cliente.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lb_cliente.setForeground(new java.awt.Color(255, 255, 255));
        lb_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_cliente.setText("Cliente");
        lb_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_clienteMouseClicked(evt);
            }
        });
        add(lb_cliente);
        lb_cliente.setBounds(0, 200, 260, 40);

        lb_txtMostrar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_txtMostrar.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtMostrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtMostrar.setText("MOSTRAR INSTRUTORES");
        lb_txtMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_txtMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtMostrarMouseClicked(evt);
            }
        });
        add(lb_txtMostrar);
        lb_txtMostrar.setBounds(960, 350, 260, 30);

        lb_botaoMostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-cinza.png"))); // NOI18N
        lb_botaoMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_botaoMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_botaoMostrarMouseClicked(evt);
            }
        });
        add(lb_botaoMostrar);
        lb_botaoMostrar.setBounds(960, 330, 260, 70);

        lb_txtAlterar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_txtAlterar.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtAlterar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtAlterar.setText("ALTERAR INSTRUTOR");
        lb_txtAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_txtAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtAlterarMouseClicked(evt);
            }
        });
        add(lb_txtAlterar);
        lb_txtAlterar.setBounds(660, 350, 260, 30);

        lb_botaoAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-cinza.png"))); // NOI18N
        lb_botaoAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_botaoAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_botaoAlterarMouseClicked(evt);
            }
        });
        add(lb_botaoAlterar);
        lb_botaoAlterar.setBounds(660, 330, 260, 70);

        lb_txtAdd.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_txtAdd.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtAdd.setText("ADICIONAR INSTRUTOR");
        lb_txtAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_txtAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtAddMouseClicked(evt);
            }
        });
        add(lb_txtAdd);
        lb_txtAdd.setBounds(350, 350, 260, 30);

        lb_botaoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-cinza.png"))); // NOI18N
        lb_botaoAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_botaoAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_botaoAddMouseClicked(evt);
            }
        });
        add(lb_botaoAdd);
        lb_botaoAdd.setBounds(350, 330, 260, 70);

        lb_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/branco.png"))); // NOI18N
        add(lb_logo);
        lb_logo.setBounds(30, 40, 200, 120);

        lb_bkg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bkg-telainstrutor.png"))); // NOI18N
        add(lb_bkg);
        lb_bkg.setBounds(0, 0, 1280, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void lb_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_clienteMouseClicked
        Main.controllerManager.btAcessarTelaCliente();
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

    private void lb_txtAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtAddMouseClicked
        Main.controllerManager.getInstrutorController().btAdd();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_txtAddMouseClicked

    private void lb_botaoAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_botaoAddMouseClicked
        Main.controllerManager.getInstrutorController().btAdd();  
    }//GEN-LAST:event_lb_botaoAddMouseClicked

    private void lb_txtAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtAlterarMouseClicked
        Main.controllerManager.getInstrutorController().btAlterar();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_txtAlterarMouseClicked

    private void lb_botaoAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_botaoAlterarMouseClicked
        Main.controllerManager.getInstrutorController().btAlterar();         // TODO add your handling code here:
    }//GEN-LAST:event_lb_botaoAlterarMouseClicked

    private void lb_txtMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtMostrarMouseClicked
        Main.controllerManager.getInstrutorController().btMostrar();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_txtMostrarMouseClicked

    private void lb_botaoMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_botaoMostrarMouseClicked
        Main.controllerManager.getInstrutorController().btMostrar();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_botaoMostrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_bkg;
    private javax.swing.JLabel lb_botaoAdd;
    private javax.swing.JLabel lb_botaoAlterar;
    private javax.swing.JLabel lb_botaoMostrar;
    private javax.swing.JLabel lb_cliente;
    private javax.swing.JLabel lb_exercicio;
    private javax.swing.JLabel lb_instrutor;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_modalidade;
    private javax.swing.JLabel lb_plano;
    private javax.swing.JLabel lb_treino;
    private javax.swing.JLabel lb_txtAdd;
    private javax.swing.JLabel lb_txtAlterar;
    private javax.swing.JLabel lb_txtMostrar;
    // End of variables declaration//GEN-END:variables
}
