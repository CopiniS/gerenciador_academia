/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import controller.Main;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Exercicio;
import models.Plano;
import models.Treino;

/**
 *
 * @author tiovi
 */
public class TelaClienteAlterar extends javax.swing.JPanel {
    List<String> listaCPFS;
    List<Plano> listaPlanos;
    List<Treino> listaTreinos;
    
    Cliente cliente;
        
    
    /**
     * Creates new form TelaClienteAlterar
     */
    public TelaClienteAlterar() {
        initComponents();
        
        tf_Nome.setEditable(false);
        ftf_dataNasc.setEditable(false);
        inicializaComboBoxCpf();
    }
    
    public void inicializaComboBoxCpf(){
        listaCPFS = Main.controllerManager.getClienteAlterarController().retornaListaCPFS();

        for(String cpf : listaCPFS){
            cb_CPF.addItem(cpf);
        }
        

    }
    
    public void inicializaComboBoxPlanoAndTreino(Cliente cliente){
        listaPlanos = Main.controllerManager.getClienteAlterarController().retornaListaPlanos();
        listaTreinos = Main.controllerManager.getClienteAlterarController().retornaListatreinos();
        
        cb_tipoPlano.removeAllItems();
        cb_treino.removeAllItems();
        
        cb_tipoPlano.addItem(null);
        cb_treino.addItem(null);
        
        if(cliente.getPlano() != null){
            for(int i=0; i<listaPlanos.size(); i++){
                cb_tipoPlano.addItem(listaPlanos.get(i).getNome());
                if(listaPlanos.get(i).getNome().equals(cliente.getPlano().getNome())){
                    cb_tipoPlano.setSelectedIndex(i+1);
                }
            }
        }
        if(cliente.getTreino() != null){
            for(int i=0; i<listaTreinos.size(); i++){
                cb_treino.addItem(listaTreinos.get(i).getNome());
                if(listaTreinos.get(i).getNome().equals(cliente.getTreino().getNome())){
                    cb_treino.setSelectedIndex(i+1);
                }
            }
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

        tf_cep = new javax.swing.JTextField();
        ftf_dataInicioPlano = new javax.swing.JFormattedTextField();
        lb_dataNasc = new javax.swing.JLabel();
        lb_Nome = new javax.swing.JLabel();
        lb_titPlano = new javax.swing.JLabel();
        lb_titTreino = new javax.swing.JLabel();
        lb_titEndereco = new javax.swing.JLabel();
        lb_titDadosPess = new javax.swing.JLabel();
        lb_logo = new javax.swing.JLabel();
        lb_cliente = new javax.swing.JLabel();
        lb_treino = new javax.swing.JLabel();
        lb_modalidade = new javax.swing.JLabel();
        lb_exercicio = new javax.swing.JLabel();
        lb_instrutor = new javax.swing.JLabel();
        lb_plano = new javax.swing.JLabel();
        lb_sideBar = new javax.swing.JLabel();
        lb_Rua = new javax.swing.JLabel();
        lb_numero = new javax.swing.JLabel();
        lb_bairro = new javax.swing.JLabel();
        lb_cep = new javax.swing.JLabel();
        lb_tipoPlano = new javax.swing.JLabel();
        lb_dataInicioPlano = new javax.swing.JLabel();
        tf_numero = new javax.swing.JTextField();
        tf_rua = new javax.swing.JTextField();
        cb_treino = new javax.swing.JComboBox<>();
        tf_bairro = new javax.swing.JTextField();
        cb_tipoPlano = new javax.swing.JComboBox<>();
        ftf_dataNasc = new javax.swing.JFormattedTextField();
        tf_Nome = new javax.swing.JTextField();
        lb_titCPF = new javax.swing.JLabel();
        lb_txtDeletar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_btDeletar = new javax.swing.JLabel();
        lb_txtAlterar = new javax.swing.JLabel();
        lb_btAlterar = new javax.swing.JLabel();
        bt_visuTreino = new javax.swing.JButton();
        cb_CPF = new javax.swing.JComboBox<>();

        setLayout(null);

        tf_cep.setBackground(new java.awt.Color(238, 238, 238));
        tf_cep.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_cep.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_cep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_cepActionPerformed(evt);
            }
        });
        add(tf_cep);
        tf_cep.setBounds(620, 385, 260, 40);

        ftf_dataInicioPlano.setBackground(new java.awt.Color(238, 238, 238));
        ftf_dataInicioPlano.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ftf_dataInicioPlano.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        add(ftf_dataInicioPlano);
        ftf_dataInicioPlano.setBounds(660, 510, 220, 40);

        lb_dataNasc.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_dataNasc.setText("Data de Nascimento:");
        add(lb_dataNasc);
        lb_dataNasc.setBounds(670, 180, 200, 20);

        lb_Nome.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Nome.setText("Nome:");
        add(lb_Nome);
        lb_Nome.setBounds(330, 180, 80, 20);

        lb_titPlano.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titPlano.setText("Plano");
        add(lb_titPlano);
        lb_titPlano.setBounds(330, 460, 170, 20);

        lb_titTreino.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titTreino.setText("Treino");
        add(lb_titTreino);
        lb_titTreino.setBounds(330, 580, 170, 30);

        lb_titEndereco.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titEndereco.setText("Endereço");
        add(lb_titEndereco);
        lb_titEndereco.setBounds(330, 255, 170, 30);

        lb_titDadosPess.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titDadosPess.setText("Dados Pessoais:");
        add(lb_titDadosPess);
        lb_titDadosPess.setBounds(330, 150, 190, 20);

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

        lb_Rua.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Rua.setText("Rua:");
        add(lb_Rua);
        lb_Rua.setBounds(330, 290, 80, 20);

        lb_numero.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_numero.setText("Número:");
        add(lb_numero);
        lb_numero.setBounds(670, 290, 120, 20);

        lb_bairro.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_bairro.setText("Bairro:");
        add(lb_bairro);
        lb_bairro.setBounds(330, 365, 120, 20);

        lb_cep.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_cep.setText("CEP:");
        add(lb_cep);
        lb_cep.setBounds(620, 365, 120, 20);

        lb_tipoPlano.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_tipoPlano.setText("Tipo de Plano:");
        add(lb_tipoPlano);
        lb_tipoPlano.setBounds(330, 480, 120, 30);

        lb_dataInicioPlano.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_dataInicioPlano.setText("Data inicio plano:");
        add(lb_dataInicioPlano);
        lb_dataInicioPlano.setBounds(660, 480, 200, 30);

        tf_numero.setBackground(new java.awt.Color(238, 238, 238));
        tf_numero.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_numero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_numeroActionPerformed(evt);
            }
        });
        add(tf_numero);
        tf_numero.setBounds(670, 310, 210, 40);

        tf_rua.setBackground(new java.awt.Color(238, 238, 238));
        tf_rua.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_rua.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_rua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ruaActionPerformed(evt);
            }
        });
        add(tf_rua);
        tf_rua.setBounds(330, 310, 320, 40);

        cb_treino.setBackground(new java.awt.Color(238, 238, 238));
        cb_treino.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        add(cb_treino);
        cb_treino.setBounds(330, 610, 300, 40);

        tf_bairro.setBackground(new java.awt.Color(238, 238, 238));
        tf_bairro.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_bairro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_bairroActionPerformed(evt);
            }
        });
        add(tf_bairro);
        tf_bairro.setBounds(330, 385, 260, 40);

        cb_tipoPlano.setBackground(new java.awt.Color(238, 238, 238));
        cb_tipoPlano.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        add(cb_tipoPlano);
        cb_tipoPlano.setBounds(332, 510, 300, 40);

        ftf_dataNasc.setBackground(new java.awt.Color(238, 238, 238));
        ftf_dataNasc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ftf_dataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        add(ftf_dataNasc);
        ftf_dataNasc.setBounds(670, 200, 210, 40);

        tf_Nome.setBackground(new java.awt.Color(238, 238, 238));
        tf_Nome.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_Nome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_NomeActionPerformed(evt);
            }
        });
        add(tf_Nome);
        tf_Nome.setBounds(330, 200, 320, 40);

        lb_titCPF.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titCPF.setText("CPF selecionado");
        add(lb_titCPF);
        lb_titCPF.setBounds(330, 60, 190, 20);

        lb_txtDeletar.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        lb_txtDeletar.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtDeletar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtDeletar.setText("DELETAR CLIENTE");
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

        bt_visuTreino.setBackground(new java.awt.Color(153, 255, 51));
        bt_visuTreino.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        bt_visuTreino.setText("VISUALIZAR TREINO");
        bt_visuTreino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_visuTreinoMouseClicked(evt);
            }
        });
        bt_visuTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_visuTreinoActionPerformed(evt);
            }
        });
        add(bt_visuTreino);
        bt_visuTreino.setBounds(650, 610, 230, 40);

        cb_CPF.setBackground(new java.awt.Color(153, 255, 51));
        cb_CPF.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        cb_CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_CPFActionPerformed(evt);
            }
        });
        add(cb_CPF);
        cb_CPF.setBounds(330, 80, 320, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_cepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_cepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_cepActionPerformed

    private void tf_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_numeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_numeroActionPerformed

    private void tf_ruaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ruaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ruaActionPerformed

    private void tf_bairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_bairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_bairroActionPerformed

    private void tf_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_NomeActionPerformed

    private void bt_visuTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_visuTreinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_visuTreinoActionPerformed

    private void lb_txtAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtAlterarMouseClicked
        
        cliente.setRua(tf_rua.getText());
        cliente.setBairro(tf_bairro.getText());
        cliente.setCep(tf_cep.getText());
        cliente.setNumero(tf_numero.getText());
        cliente = Main.controllerManager.getClienteAlterarController().verificaEnderecoNulo(cliente);
        
        if(cb_tipoPlano.getSelectedItem() != null){
            cliente.setPlano(Main.controllerManager.getClienteAlterarController().retornaPlano(listaPlanos, cb_tipoPlano.getSelectedItem().toString()));
        }
        else{
            cliente.setPlano(null);
        }
        
        if(cb_treino.getSelectedItem() != null){
            cliente.setTreino(Main.controllerManager.getClienteAlterarController().retornaTreino(listaTreinos, cb_treino.getSelectedItem().toString()));
        }
        else{
            cliente.setTreino(null);
        }
        Main.controllerManager.getClienteAlterarController().btAlteraDados(cliente);
    }//GEN-LAST:event_lb_txtAlterarMouseClicked

    private void cb_CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_CPFActionPerformed
        String cpfSelecionado = cb_CPF.getSelectedItem().toString();
        this.cliente = new Cliente();
        try {
            cliente = Main.controllerManager.getClienteAlterarController().retornaClientePeloCpf(cpfSelecionado);
        } catch (ParseException ex) {
            Logger.getLogger(TelaClienteAlterar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaClienteAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        inicializaComboBoxPlanoAndTreino(cliente);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        tf_Nome.setText(cliente.getNome());
        ftf_dataNasc.setText(formato.format(cliente.getDataNascimento()));
        tf_cep.setText(cliente.getCep());
        tf_rua.setText(cliente.getRua());
        tf_bairro.setText(cliente.getBairro());
        tf_numero.setText(cliente.getNumero());
        if(cliente.getDataInicioPlano() != null){
            ftf_dataInicioPlano.setText(formato.format(Date.valueOf(cliente.getDataInicioPlano())));
        }
        
        
    }//GEN-LAST:event_cb_CPFActionPerformed

    private void lb_instrutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_instrutorMouseClicked
        Main.controllerManager.btAcessarTelaInstrutor();
    }//GEN-LAST:event_lb_instrutorMouseClicked

    private void lb_planoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_planoMouseClicked
       Main.controllerManager.btAcessarTelaPlano();
    }//GEN-LAST:event_lb_planoMouseClicked

    private void lb_exercicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_exercicioMouseClicked
        Main.controllerManager.btAcessartelaExercicio();
    }//GEN-LAST:event_lb_exercicioMouseClicked

    private void lb_modalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_modalidadeMouseClicked
        Main.controllerManager.btAcessarTelaModalidade();
    }//GEN-LAST:event_lb_modalidadeMouseClicked

    private void lb_treinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_treinoMouseClicked
        Main.controllerManager.btAcessarTelaTreino();
    }//GEN-LAST:event_lb_treinoMouseClicked

    private void lb_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_clienteMouseClicked
        Main.controllerManager.btAcessarTelaCliente();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_clienteMouseClicked

    private void lb_btAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_btAlterarMouseClicked
                
        cliente.setRua(tf_rua.getText());
        cliente.setBairro(tf_bairro.getText());
        cliente.setCep(tf_cep.getText());
        cliente.setNumero(tf_numero.getText());
        cliente = Main.controllerManager.getClienteAlterarController().verificaEnderecoNulo(cliente);
        
        if(cb_tipoPlano.getSelectedItem() != null){
            cliente.setPlano(Main.controllerManager.getClienteAlterarController().retornaPlano(listaPlanos, cb_tipoPlano.getSelectedItem().toString()));
        }
        else{
            cliente.setPlano(null);
        }
        
        if(cb_treino.getSelectedItem() != null){
            cliente.setTreino(Main.controllerManager.getClienteAlterarController().retornaTreino(listaTreinos, cb_treino.getSelectedItem().toString()));
        }
        else{
            cliente.setTreino(null);
        }
        Main.controllerManager.getClienteAlterarController().btAlteraDados(cliente);
    }//GEN-LAST:event_lb_btAlterarMouseClicked

    private void lb_txtDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtDeletarMouseClicked
           if(Main.controllerManager.getClienteAlterarController().deletaCliente(cliente.getId())){
               JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
               cb_CPF.removeItem(cb_CPF.getSelectedItem());
               
           }
           else{
               JOptionPane.showMessageDialog(null, "Erro na exclusao do cliente, tente novamente mais tarde");
           }
    }//GEN-LAST:event_lb_txtDeletarMouseClicked

    private void lb_btDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_btDeletarMouseClicked
        if(Main.controllerManager.getClienteAlterarController().deletaCliente(cliente.getId())){
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
            cb_CPF.removeItem(cb_CPF.getSelectedItem());

        }
        else{
            JOptionPane.showMessageDialog(null, "Erro na exclusao do cliente, tente novamente mais tarde");
           }
    }//GEN-LAST:event_lb_btDeletarMouseClicked

    private void bt_visuTreinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_visuTreinoMouseClicked
        try {
            cliente = Main.controllerManager.getClienteAlterarController().retornaClientePeloCpf(cb_CPF.getSelectedItem().toString());
        } catch (ParseException ex) {
            Logger.getLogger(TelaClienteAlterar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaClienteAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
            Map<String, List<Exercicio>> map = new HashMap<>();
            map = Main.controllerManager.getClienteAlterarController().chamaMapExercicio(cliente.getTreino().getId());
            
            if(cliente.getTreino() != null){
                Main.controllerManager.getClienteAlterarController().geraTreinoPdf(cliente, map);
            }
            else{
                JOptionPane.showMessageDialog(null, "Nenhum treino cadastrado");
            }
            
            
    }//GEN-LAST:event_bt_visuTreinoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_visuTreino;
    private javax.swing.JComboBox<String> cb_CPF;
    private javax.swing.JComboBox<String> cb_tipoPlano;
    private javax.swing.JComboBox<String> cb_treino;
    private javax.swing.JFormattedTextField ftf_dataInicioPlano;
    private javax.swing.JFormattedTextField ftf_dataNasc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_Nome;
    private javax.swing.JLabel lb_Rua;
    private javax.swing.JLabel lb_bairro;
    private javax.swing.JLabel lb_btAlterar;
    private javax.swing.JLabel lb_btDeletar;
    private javax.swing.JLabel lb_cep;
    private javax.swing.JLabel lb_cliente;
    private javax.swing.JLabel lb_dataInicioPlano;
    private javax.swing.JLabel lb_dataNasc;
    private javax.swing.JLabel lb_exercicio;
    private javax.swing.JLabel lb_instrutor;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_modalidade;
    private javax.swing.JLabel lb_numero;
    private javax.swing.JLabel lb_plano;
    private javax.swing.JLabel lb_sideBar;
    private javax.swing.JLabel lb_tipoPlano;
    private javax.swing.JLabel lb_titCPF;
    private javax.swing.JLabel lb_titDadosPess;
    private javax.swing.JLabel lb_titEndereco;
    private javax.swing.JLabel lb_titPlano;
    private javax.swing.JLabel lb_titTreino;
    private javax.swing.JLabel lb_treino;
    private javax.swing.JLabel lb_txtAlterar;
    private javax.swing.JLabel lb_txtDeletar;
    private javax.swing.JTextField tf_Nome;
    private javax.swing.JTextField tf_bairro;
    private javax.swing.JTextField tf_cep;
    private javax.swing.JTextField tf_numero;
    private javax.swing.JTextField tf_rua;
    // End of variables declaration//GEN-END:variables
}