/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import controller.Main;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Exercicio;
import models.Treino;

/**
 *
 * @author alunolages
 */
public class TelaTreinoAlterar extends javax.swing.JPanel {
    List<Exercicio> listaTodosExercicios;
    List<Exercicio> listaEspecifica;
    List<Treino> listaTreinos;
    String [] vetorExercicio;
    List<String> diasAdd;
    List<Exercicio> exerciciosAntigos;
    Map<String, List<Exercicio>> map;
    /**
     * Creates new form TelaTreinoAlterar
     */
    public TelaTreinoAlterar() throws SQLException {
        initComponents();
        inicializaçãoSistema();
    }

public void InicializaListaExercicios(){
        listaTodosExercicios = Main.controllerManager.getTreinoAdicionarController().retornaListaExerciciosCompleta();
    }
    
    public void InicializaListaEspecifica(String musculo){
        listaEspecifica = Main.controllerManager.getTreinoAlterarController().retornaListaExerciciosPeloMusculo(musculo, listaTodosExercicios);
    }

    public void inicializaVetorExercicios(){
        vetorExercicio = new String [20];
        for(int i=0; i<20; i++){
            vetorExercicio[i] = "";
        }
        
      
        for(int i=0; i<listaEspecifica.size(); i++){
            vetorExercicio[i] = listaEspecifica.get(i).getNome();
        }
        
    }
    
    public void inicializarCheckBoxes(){
        inicializaVetorExercicios();
        
        if(!vetorExercicio[0].equals("")){
            jCheckBox1.setText(vetorExercicio[0]);
        }
        else{
            jCheckBox1.setVisible(false);
        }
        
        if(!vetorExercicio[1].equals("")){
            jCheckBox2.setText(vetorExercicio[1]);
        }
        else{
            jCheckBox2.setVisible(false);
        }
        
        if(!vetorExercicio[2].equals("")){
            jCheckBox3.setText(vetorExercicio[2]);
        }
        else{
            jCheckBox3.setVisible(false);
        }
        
        if(!vetorExercicio[3].equals("")){
            jCheckBox4.setText(vetorExercicio[3]);
        }
        else{
            jCheckBox4.setVisible(false);
        }
        
        if(!vetorExercicio[4].equals("")){
            jCheckBox5.setText(vetorExercicio[4]);
        }
        else{
            jCheckBox5.setVisible(false);
        }
        
        if(!vetorExercicio[5].equals("")){
            jCheckBox6.setText(vetorExercicio[5]);
        }
        else{
            jCheckBox6.setVisible(false);
        }
        
        if(!vetorExercicio[6].equals("")){
            jCheckBox7.setText(vetorExercicio[6]);
        }
        else{
            jCheckBox7.setVisible(false);
        }
        
        if(!vetorExercicio[7].equals("")){
            jCheckBox8.setText(vetorExercicio[7]);
        }
        else{
            jCheckBox8.setVisible(false);
        }
        
        if(!vetorExercicio[8].equals("")){
            jCheckBox9.setText(vetorExercicio[8]);
        }
        else{
            jCheckBox9.setVisible(false);
        }
        
        if(!vetorExercicio[9].equals("")){
            jCheckBox10.setText(vetorExercicio[9]);
        }
        else{
            jCheckBox10.setVisible(false);
        }
        
        if(!vetorExercicio[10].equals("")){
            jCheckBox11.setText(vetorExercicio[10]);
        }
        else{
            jCheckBox11.setVisible(false);
        }
        
        if(!vetorExercicio[11].equals("")){
            jCheckBox12.setText(vetorExercicio[11]);
        }
        else{
            jCheckBox12.setVisible(false);
        }
        
        if(!vetorExercicio[12].equals("")){
            jCheckBox13.setText(vetorExercicio[12]);
        }
        else{
            jCheckBox13.setVisible(false);
        }
        
        if(!vetorExercicio[13].equals("")){
            jCheckBox14.setText(vetorExercicio[13]);
        }
        else{
            jCheckBox14.setVisible(false);
        }
        
        if(!vetorExercicio[14].equals("")){
            jCheckBox15.setText(vetorExercicio[14]);
        }
        else{
            jCheckBox15.setVisible(false);
        }
        
        if(!vetorExercicio[15].equals("")){
            jCheckBox16.setText(vetorExercicio[15]);
        }
        else{
            jCheckBox16.setVisible(false);
        }
        
        if(!vetorExercicio[16].equals("")){
            jCheckBox17.setText(vetorExercicio[16]);
        }
        else{
            jCheckBox17.setVisible(false);
        }
        
        if(!vetorExercicio[17].equals("")){
            jCheckBox18.setText(vetorExercicio[17]);
        }
        else{
            jCheckBox18.setVisible(false);
        }
        
        if(!vetorExercicio[18].equals("")){
            jCheckBox19.setText(vetorExercicio[18]);
        }
        else{
            jCheckBox19.setVisible(false);
        }
        if(!vetorExercicio[19].equals("")){
            jCheckBox20.setText(vetorExercicio[19]);
        }
        else{
            jCheckBox20.setVisible(false);
        }
        
    }
    
    public void inicializaçãoSistema() throws SQLException{
        diasAdd = new ArrayList<>();
        inicializaCbBoxNomes();
        inicializaMap();
        InicializaListaExercicios();
        InicializaListaEspecifica(cb_selecMusc.getSelectedItem().toString());
        if(!listaEspecifica.isEmpty()){
            inicializarCheckBoxes();
            inicializaDadosDoTreino();
        }
        else{
            JOptionPane.showMessageDialog(null, "Adicione pelo menos 1 exercicio dessa musculatura");
        }
    }
        
    public void inicializaMap(){
        map = new HashMap<>();
        map.put("Segunda", new ArrayList<>());
        map.put("Terça", new ArrayList<>());
        map.put("Quarta", new ArrayList<>());
        map.put("Quinta", new ArrayList<>());
        map.put("Sexta", new ArrayList<>());
        map.put("Sabado", new ArrayList<>());
        map.put("Domingo", new ArrayList<>());
        }
        
    public void adicionarExerciciosAoMap(String dia, List<Exercicio> selecionados){
        for(Exercicio e : selecionados){
            map.get(dia).add(e);
        }
    }
    
    public boolean [] retornaboleanoCheckBoxs(){
        boolean [] checkBoxs = new boolean[20];
        
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
        if(jCheckBox9.isSelected()){
            checkBoxs[8] = true;
        }
        else{
            checkBoxs[8] = false;
        }
        if(jCheckBox10.isSelected()){
            checkBoxs[9] = true;
        }
        else{
            checkBoxs[9] = false;
        }
        if(jCheckBox11.isSelected()){
            checkBoxs[10] = true;
        }
        else{
            checkBoxs[10] = false;
        }
        if(jCheckBox12.isSelected()){
            checkBoxs[11] = true;
        }
        else{
            checkBoxs[11] = false;
        }
        if(jCheckBox13.isSelected()){
            checkBoxs[12] = true;
        }
        else{
            checkBoxs[12] = false;
        }
        if(jCheckBox14.isSelected()){
            checkBoxs[13] = true;
        }
        else{
            checkBoxs[13] = false;
        }
        if(jCheckBox15.isSelected()){
            checkBoxs[14] = true;
        }
        else{
            checkBoxs[14] = false;
        }
        if(jCheckBox16.isSelected()){
            checkBoxs[15] = true;
        }
        else{
            checkBoxs[15] = false;
        }
        if(jCheckBox17.isSelected()){
            checkBoxs[16] = true;
        }
        else{
            checkBoxs[16] = false;
        }
        if(jCheckBox18.isSelected()){
            checkBoxs[17] = true;
        }
        else{
            checkBoxs[17] = false;
        }
        if(jCheckBox19.isSelected()){
            checkBoxs[18] = true;
        }
        else{
            checkBoxs[18] = false;
        }
        if(jCheckBox20.isSelected()){
            checkBoxs[19] = true;
        }
        else{
            checkBoxs[19] = false;
        }
        
        return checkBoxs;
    }
    
    public void zerarCheckDasCheckBoxex() {
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox6.setSelected(false);
        jCheckBox7.setSelected(false);
        jCheckBox8.setSelected(false);
        jCheckBox9.setSelected(false);
        jCheckBox10.setSelected(false);
        jCheckBox11.setSelected(false);
        jCheckBox12.setSelected(false);
        jCheckBox13.setSelected(false);
        jCheckBox14.setSelected(false);
        jCheckBox15.setSelected(false);
        jCheckBox16.setSelected(false);
        jCheckBox17.setSelected(false);
        jCheckBox18.setSelected(false);
        jCheckBox19.setSelected(false);
    }    
    
    public void inicializaCbBoxNomes(){
        listaTreinos = Main.controllerManager.getTreinoAlterarController().retornaListaTreinos();
        
        for(Treino t : listaTreinos){
            cb_nomes.addItem(t.getNome());
        }
    }
    
    public void inicializaDadosDoTreino() throws SQLException{
        Treino t = Main.controllerManager.getTreinoAlterarController().retornaTreinoPeloNome(cb_nomes.getSelectedItem().toString(), listaTreinos);
        
        tf_descricao.setText(t.getDescricao());
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
        lb_titDadosPess = new javax.swing.JLabel();
        lb_logo = new javax.swing.JLabel();
        lb_cliente = new javax.swing.JLabel();
        lb_treino = new javax.swing.JLabel();
        lb_modalidade = new javax.swing.JLabel();
        lb_exercicio = new javax.swing.JLabel();
        lb_instrutor = new javax.swing.JLabel();
        lb_plano = new javax.swing.JLabel();
        lb_sideBar = new javax.swing.JLabel();
        lb_txtAddTreino = new javax.swing.JLabel();
        lb_botaoAddtreino = new javax.swing.JLabel();
        lb_Nome1 = new javax.swing.JLabel();
        cb_selecMusc = new javax.swing.JComboBox<>();
        lb_Nome2 = new javax.swing.JLabel();
        cb_nomes = new javax.swing.JComboBox<>();
        cb_selecDia = new javax.swing.JComboBox<>();
        lb_txtDeletar = new javax.swing.JLabel();
        lb_botaoDeletar = new javax.swing.JLabel();
        lb_Nome3 = new javax.swing.JLabel();
        tf_descricao = new javax.swing.JTextField();
        lb_selecDia2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        lb_txtNextDay = new javax.swing.JLabel();
        lb_botaoNextDay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(null);

        lb_Nome.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Nome.setText("Nome Treino:");
        add(lb_Nome);
        lb_Nome.setBounds(320, 120, 180, 30);

        lb_titDadosPess.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 18)); // NOI18N
        lb_titDadosPess.setText("Adicionar Treino");
        add(lb_titDadosPess);
        lb_titDadosPess.setBounds(320, 100, 170, 20);

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

        lb_treino.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
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

        lb_txtAddTreino.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 16)); // NOI18N
        lb_txtAddTreino.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtAddTreino.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtAddTreino.setText("ALTERAR TREINO");
        lb_txtAddTreino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtAddTreinoMouseClicked(evt);
            }
        });
        add(lb_txtAddTreino);
        lb_txtAddTreino.setBounds(920, 230, 260, 30);

        lb_botaoAddtreino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-azul.png"))); // NOI18N
        lb_botaoAddtreino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_botaoAddtreinoMouseClicked(evt);
            }
        });
        add(lb_botaoAddtreino);
        lb_botaoAddtreino.setBounds(920, 210, 260, 70);

        lb_Nome1.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Nome1.setText("Selecione um dia da semana:");
        add(lb_Nome1);
        lb_Nome1.setBounds(320, 200, 250, 30);

        cb_selecMusc.setBackground(new java.awt.Color(153, 255, 51));
        cb_selecMusc.setFont(new java.awt.Font("CommercialScript BT", 1, 14)); // NOI18N
        cb_selecMusc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Peito", "Costas", "Braço", "Perna", "Ombro" }));
        cb_selecMusc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_selecMuscActionPerformed(evt);
            }
        });
        add(cb_selecMusc);
        cb_selecMusc.setBounds(320, 320, 320, 40);

        lb_Nome2.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Nome2.setText("Selecione o musculo");
        add(lb_Nome2);
        lb_Nome2.setBounds(320, 290, 250, 30);

        cb_nomes.setBackground(new java.awt.Color(153, 255, 51));
        cb_nomes.setFont(new java.awt.Font("CommercialScript BT", 1, 14)); // NOI18N
        cb_nomes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nomesActionPerformed(evt);
            }
        });
        add(cb_nomes);
        cb_nomes.setBounds(320, 150, 320, 40);

        cb_selecDia.setBackground(new java.awt.Color(153, 255, 51));
        cb_selecDia.setFont(new java.awt.Font("CommercialScript BT", 1, 14)); // NOI18N
        cb_selecDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo" }));
        add(cb_selecDia);
        cb_selecDia.setBounds(320, 230, 320, 40);

        lb_txtDeletar.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 16)); // NOI18N
        lb_txtDeletar.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtDeletar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtDeletar.setText("DELETAR TREINO");
        lb_txtDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtDeletarMouseClicked(evt);
            }
        });
        add(lb_txtDeletar);
        lb_txtDeletar.setBounds(920, 330, 260, 30);

        lb_botaoDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-vermelho.png"))); // NOI18N
        add(lb_botaoDeletar);
        lb_botaoDeletar.setBounds(920, 310, 260, 70);

        lb_Nome3.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_Nome3.setText("Descrição");
        add(lb_Nome3);
        lb_Nome3.setBounds(680, 120, 180, 30);

        tf_descricao.setBackground(new java.awt.Color(238, 238, 238));
        tf_descricao.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        tf_descricao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tf_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_descricaoActionPerformed(evt);
            }
        });
        add(tf_descricao);
        tf_descricao.setBounds(680, 150, 530, 40);

        lb_selecDia2.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lb_selecDia2.setText("Adicione os exercicios para o dia ");
        add(lb_selecDia2);
        lb_selecDia2.setBounds(320, 380, 270, 30);

        jCheckBox1.setBackground(new java.awt.Color(153, 255, 51));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        add(jCheckBox1);
        jCheckBox1.setBounds(310, 430, 220, 30);

        jCheckBox2.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox2);
        jCheckBox2.setBounds(310, 470, 220, 30);

        jCheckBox3.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox3);
        jCheckBox3.setBounds(310, 510, 220, 30);

        jCheckBox4.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox4);
        jCheckBox4.setBounds(310, 550, 220, 30);

        jCheckBox5.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox5);
        jCheckBox5.setBounds(310, 590, 220, 30);

        jCheckBox6.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox6);
        jCheckBox6.setBounds(540, 430, 260, 30);

        jCheckBox7.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox7);
        jCheckBox7.setBounds(540, 470, 260, 30);

        jCheckBox8.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox8);
        jCheckBox8.setBounds(540, 510, 260, 30);

        jCheckBox9.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox9);
        jCheckBox9.setBounds(540, 550, 260, 30);

        jCheckBox10.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox10);
        jCheckBox10.setBounds(540, 590, 260, 30);

        jCheckBox11.setBackground(new java.awt.Color(153, 255, 51));
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });
        add(jCheckBox11);
        jCheckBox11.setBounds(810, 430, 240, 30);

        jCheckBox12.setBackground(new java.awt.Color(153, 255, 51));
        jCheckBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox12ActionPerformed(evt);
            }
        });
        add(jCheckBox12);
        jCheckBox12.setBounds(810, 470, 240, 30);

        jCheckBox13.setBackground(new java.awt.Color(153, 255, 51));
        jCheckBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox13ActionPerformed(evt);
            }
        });
        add(jCheckBox13);
        jCheckBox13.setBounds(810, 510, 240, 30);

        jCheckBox14.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox14);
        jCheckBox14.setBounds(810, 550, 240, 30);

        jCheckBox15.setBackground(new java.awt.Color(153, 255, 51));
        jCheckBox15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox15ActionPerformed(evt);
            }
        });
        add(jCheckBox15);
        jCheckBox15.setBounds(810, 590, 240, 30);

        jCheckBox16.setBackground(new java.awt.Color(153, 255, 51));
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });
        add(jCheckBox16);
        jCheckBox16.setBounds(1060, 430, 200, 30);

        jCheckBox17.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox17);
        jCheckBox17.setBounds(1060, 470, 200, 30);

        jCheckBox18.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox18);
        jCheckBox18.setBounds(1060, 510, 200, 30);

        jCheckBox19.setBackground(new java.awt.Color(153, 255, 51));
        jCheckBox19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox19ActionPerformed(evt);
            }
        });
        add(jCheckBox19);
        jCheckBox19.setBounds(1060, 550, 200, 30);

        jCheckBox20.setBackground(new java.awt.Color(153, 255, 51));
        add(jCheckBox20);
        jCheckBox20.setBounds(1060, 590, 200, 30);

        lb_txtNextDay.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 16)); // NOI18N
        lb_txtNextDay.setForeground(new java.awt.Color(255, 255, 255));
        lb_txtNextDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_txtNextDay.setText("Salvar dia");
        lb_txtNextDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_txtNextDayMouseClicked(evt);
            }
        });
        add(lb_txtNextDay);
        lb_txtNextDay.setBounds(720, 230, 140, 20);

        lb_botaoNextDay.setBackground(new java.awt.Color(153, 255, 51));
        lb_botaoNextDay.setForeground(new java.awt.Color(153, 255, 51));
        lb_botaoNextDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bt-azul.png"))); // NOI18N
        lb_botaoNextDay.setOpaque(true);
        lb_botaoNextDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_botaoNextDayMouseClicked(evt);
            }
        });
        add(lb_botaoNextDay);
        lb_botaoNextDay.setBounds(710, 220, 160, 40);

        jLabel1.setBackground(new java.awt.Color(153, 255, 51));
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(710, 220, 160, 40);
    }// </editor-fold>//GEN-END:initComponents

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

    private void lb_modalidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_modalidadeMouseClicked
        Main.controllerManager.btAcessarTelaModalidade();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_modalidadeMouseClicked

    private void lb_treinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_treinoMouseClicked
        Main.controllerManager.btAcessarTelaTreino();        // TODO add your handling code here:
    }//GEN-LAST:event_lb_treinoMouseClicked

    private void lb_txtDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtDeletarMouseClicked
        Treino t = Main.controllerManager.getTreinoAlterarController().retornaTreinoPeloNome(cb_nomes.getSelectedItem().toString(), listaTreinos);
        if(Main.controllerManager.getTreinoAlterarController().removerTreino(t.getId())){
            JOptionPane.showMessageDialog(null, "Treino deletado com sucesso");
            cb_nomes.removeItem(cb_nomes.getSelectedItem());
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na exclusão do treino, tente novamente mais tarde");
        }
    }//GEN-LAST:event_lb_txtDeletarMouseClicked

    private void tf_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_descricaoActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jCheckBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox12ActionPerformed

    private void jCheckBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox13ActionPerformed

    private void jCheckBox15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox15ActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jCheckBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox19ActionPerformed

    private void lb_txtNextDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtNextDayMouseClicked
        InicializaListaEspecifica(cb_selecMusc.getSelectedItem().toString());
        List selecionados = Main.controllerManager.getTreinoAlterarController().retornaExerciciosSelecionados(retornaboleanoCheckBoxs(), listaEspecifica);
        
        if(!selecionados.isEmpty()){
            diasAdd.add(cb_selecDia.getSelectedItem().toString());
            adicionarExerciciosAoMap(cb_selecDia.getSelectedItem().toString(), selecionados);
                    
            cb_selecDia.removeItem(cb_selecDia.getSelectedItem());
            zerarCheckDasCheckBoxex();
            
            inicializarCheckBoxes();
        }
        else{
            JOptionPane.showMessageDialog(null, "Adicione pelo menos 1 exercicio dessa musculatura");
        }
    }//GEN-LAST:event_lb_txtNextDayMouseClicked

    private void lb_botaoNextDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_botaoNextDayMouseClicked
        
        InicializaListaEspecifica(cb_selecMusc.getSelectedItem().toString());
        List selecionados = Main.controllerManager.getTreinoAlterarController().retornaExerciciosSelecionados(retornaboleanoCheckBoxs(), listaEspecifica);
        
        if(!selecionados.isEmpty()){
            diasAdd.add(cb_selecDia.getSelectedItem().toString());
            adicionarExerciciosAoMap(cb_selecDia.getSelectedItem().toString(), selecionados);
                    
            cb_selecDia.removeItem(cb_selecDia.getSelectedItem());
            zerarCheckDasCheckBoxex();
            
            inicializarCheckBoxes();
        }
        else{
            JOptionPane.showMessageDialog(null, "Adicione pelo menos 1 exercicio dessa musculatura");
        }
    }//GEN-LAST:event_lb_botaoNextDayMouseClicked

    private void cb_selecMuscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_selecMuscActionPerformed
        InicializaListaEspecifica(cb_selecMusc.getSelectedItem().toString());   
        if(!listaEspecifica.isEmpty()){
            zerarCheckDasCheckBoxex();
            inicializarCheckBoxes();
        }
        else{
            JOptionPane.showMessageDialog(null, "Adicione pelo menos 1 exercicio dessa musculatura no Menu de exercicios");
        }
    }//GEN-LAST:event_cb_selecMuscActionPerformed

    private void cb_nomesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nomesActionPerformed
        try {
            inicializaDadosDoTreino();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(TelaTreinoAlterar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb_nomesActionPerformed

    private void lb_txtAddTreinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_txtAddTreinoMouseClicked
        Treino t = Main.controllerManager.getTreinoAlterarController().retornaTreinoPeloNome(cb_nomes.getSelectedItem().toString(), listaTreinos);
        if(Main.controllerManager.getTreinoAlterarController().validaDescricao(tf_descricao.getText())){
            if(Main.controllerManager.getTreinoAlterarController().validaExercicios(diasAdd)){
                if(Main.controllerManager.getTreinoAlterarController().btAddtreino(map, tf_descricao.getText(), diasAdd, t.getId())){
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocorreu algum erro na alteração dos dados, tente novamente mais tarde");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Selecione pelo menos um exercicio para cadastrar o treino");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        }
    }//GEN-LAST:event_lb_txtAddTreinoMouseClicked

    private void lb_botaoAddtreinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_botaoAddtreinoMouseClicked
        Treino t = Main.controllerManager.getTreinoAlterarController().retornaTreinoPeloNome(cb_nomes.getSelectedItem().toString(), listaTreinos);
        if(Main.controllerManager.getTreinoAlterarController().validaDescricao(tf_descricao.getText())){
            if(Main.controllerManager.getTreinoAlterarController().validaExercicios(diasAdd)){
                if(Main.controllerManager.getTreinoAlterarController().btAddtreino(map, tf_descricao.getText(), diasAdd, t.getId())){
                    JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocorreu algum erro na alteração dos dados, tente novamente mais tarde");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Selecione pelo menos um exercicio para cadastrar o treino");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        }        
    }//GEN-LAST:event_lb_botaoAddtreinoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_nomes;
    private javax.swing.JComboBox<String> cb_selecDia;
    private javax.swing.JComboBox<String> cb_selecMusc;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_Nome;
    private javax.swing.JLabel lb_Nome1;
    private javax.swing.JLabel lb_Nome2;
    private javax.swing.JLabel lb_Nome3;
    private javax.swing.JLabel lb_botaoAddtreino;
    private javax.swing.JLabel lb_botaoDeletar;
    private javax.swing.JLabel lb_botaoNextDay;
    private javax.swing.JLabel lb_cliente;
    private javax.swing.JLabel lb_exercicio;
    private javax.swing.JLabel lb_instrutor;
    private javax.swing.JLabel lb_logo;
    private javax.swing.JLabel lb_modalidade;
    private javax.swing.JLabel lb_plano;
    private javax.swing.JLabel lb_selecDia2;
    private javax.swing.JLabel lb_sideBar;
    private javax.swing.JLabel lb_titDadosPess;
    private javax.swing.JLabel lb_treino;
    private javax.swing.JLabel lb_txtAddTreino;
    private javax.swing.JLabel lb_txtDeletar;
    private javax.swing.JLabel lb_txtNextDay;
    private javax.swing.JTextField tf_descricao;
    // End of variables declaration//GEN-END:variables
}
