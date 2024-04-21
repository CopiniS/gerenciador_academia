
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Exercicio;


/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class ExercicioAdicionarController {

    public ExercicioAdicionarController() {
    }
    /**
     * adiciona o exercicio
     * @param exercicio objeto exercicio
     */
    public void bt_addExercicio(Exercicio exercicio){
        if(Main.controllerManager.getApplicationModel().getExercicioDAO().insertExercicioSql(exercicio)){
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso");
        }
    }
    
    /**
     * verifica se tem mais de 20 exercícios de um musculo especifico
     * @param musc msuculo a ser verificado
     * @return retorna true se tiver menos de 20 ou 20
     */
    public boolean verificaSetemMaisDe20(String musc){
        List<Exercicio> lista = Main.controllerManager.getApplicationModel().getExercicioDAO().selectExerciciosSql();
        List<Exercicio> listaAux = new ArrayList();
        for(Exercicio e : lista){
            if(e.getMusculaturaAfetada().equals(musc)){
                listaAux.add(e);
            }
        }
        
        if(listaAux.size() > 20){
            return false;
        }
        return true;
    }
    
    /**
     * Verifica se o exercicio com esse nome ja foi cadastrado
     * @param nome nome do exercicio a ser cadastrado
     * @return true se o nome passado, não estiver no banco de dados, e false se já estiver cadastrado
     */
    public boolean verificaSeNomerepetido(String nome){
        List<Exercicio> lista = Main.controllerManager.getApplicationModel().getExercicioDAO().selectExerciciosSql();
        
        for(Exercicio e : lista){
            if(e.getNome().equals(nome)){
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * verifica se o nome do exercicio não está em branco
     * @param str nome do exercício
     * @return return true se for diferente de branco, e false se for branco
     */
    public boolean validaCampo(String str){
        boolean resultado = false;
        if(!str.isBlank()){
            resultado = true;
        }
        return resultado;
    }
}
