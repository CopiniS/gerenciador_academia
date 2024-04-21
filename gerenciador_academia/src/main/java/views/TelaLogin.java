package views;

import controller.Main;
import javax.swing.ImageIcon;

public class TelaLogin extends javax.swing.JPanel {


    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_logo = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        pf_senha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        lb_bkg = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        lb_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/branco.png"))); // NOI18N
        add(lb_logo);
        lb_logo.setBounds(540, 140, 200, 120);

        tf_nome.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        tf_nome.setForeground(new java.awt.Color(51, 51, 51));
        tf_nome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_nome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_nomeMouseClicked(evt);
            }
        });
        tf_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nomeActionPerformed(evt);
            }
        });
        add(tf_nome);
        tf_nome.setBounds(430, 330, 420, 60);

        pf_senha.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        pf_senha.setForeground(new java.awt.Color(51, 51, 51));
        pf_senha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pf_senhaMouseClicked(evt);
            }
        });
        add(pf_senha);
        pf_senha.setBounds(430, 410, 420, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt_entrarInicio.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1);
        jLabel1.setBounds(480, 510, 321, 69);

        lb_bkg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bkg-inicio.png"))); // NOI18N
        add(lb_bkg);
        lb_bkg.setBounds(0, 0, 1280, 720);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nomeActionPerformed
        ImageIcon bkgLogin = new ImageIcon("img/bkg-inicio.png");
        lb_bkg.setIcon(bkgLogin);
    }//GEN-LAST:event_tf_nomeActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Main.controllerManager.getLoginController().btEntrar(tf_nome.getText(), pf_senha.getText());
    }//GEN-LAST:event_jLabel1MouseClicked

    private void pf_senhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pf_senhaMouseClicked
        pf_senha.setText("");
    }//GEN-LAST:event_pf_senhaMouseClicked

    private void tf_nomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_nomeMouseClicked
        tf_nome.setText("");
    }//GEN-LAST:event_tf_nomeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_bkg;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JPasswordField pf_senha;
    private javax.swing.JTextField tf_nome;
    // End of variables declaration//GEN-END:variables
}
