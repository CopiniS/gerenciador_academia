
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.Exercicio;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class TreinoAdicionarController {

    public TreinoAdicionarController() {
    }
    
    /**
     * retorna a lista de exercicios com todas as informaçoes
     * @return retorna lista de exercicios completa
     */
    public List<Exercicio> retornaListaExerciciosCompleta(){
        return Main.controllerManager.getApplicationModel().getExercicioDAO().selectExerciciosSql();
    }
    
    public List<Exercicio> retornaListaExerciciosPeloMusculo(String musculo, List<Exercicio> lista){
        List<Exercicio> listaEspecifica = new ArrayList<>();
        
        for(Exercicio e : lista){
            if(e.getMusculaturaAfetada().equals(musculo)){
                listaEspecifica.add(e);
            }
        }
        return listaEspecifica;
    }
    
    /**
     * retorna se tiver validado a seleção dos treinos
     * @param vetorCheckBox checkbox com os exericios
     * @return retorna booleano, true se tiver validado a seleção
     */
    public boolean validaCheckBox(boolean [] vetorCheckBox){
        boolean resultado = false;
        
        for(int i=0; i<20; i++){
            if(vetorCheckBox[i] == true){
                resultado = true;
            }
        }
        return resultado;
    }
    
    /**
     * retorna a lista com os exercicios selecionados na checkbox
     * @param vetorCheckBox checkbox selecionados
     * @param lista lista de exercicios
     * @return retorna a lista com os exercicios selecionados na checkbox
     */
    public List<Exercicio> retornaExerciciosSelecionados(boolean [] vetorCheckBox, List<Exercicio> lista){
        List<Exercicio> selecionados = new ArrayList<>();
        for(int i=0; i<20; i++){
            if(vetorCheckBox[i]){
                selecionados.add(lista.get(i));
            }
        }
        return selecionados;
    }
    
    /**
     * valida nome e descricao do treino, nao podem estar empty
     * @param nome nome do treino
     * @param descricao descricao do treino
     * @return retorna booleano, true se tiver validado a nome e descricao
     */
    public boolean validaNomeEdescricao(String nome, String descricao){
        return !nome.isBlank() && !descricao.isBlank();
    }
    
    /**
     * valida dias dos exercicios
     * @param diasAdd lista de dias
     * @return retorna booleano, true se tiver os dias nao tiverem vazios
     */
    public boolean validaExercicios(List<String> diasAdd){
        return !diasAdd.isEmpty();
    }
    
    /**
     * valida se o treino pode ser adicionado
     * @param map lista de exercicio conforme dia da semana
     * @param nome nome do treino
     * @param descricao descricao do treino
     * @param diasAdd lista de dias da semana
     * @return retorna booleano, true se tiver adicionado treino
     */
    public boolean btAddtreino(Map<String, List<Exercicio>> map, String nome, String descricao, List<String> diasAdd){
        boolean resultado = false;
        
        int idTreino = Main.controllerManager.getApplicationModel().getTreinoDAO().insertTreinoSql(nome, descricao);
        
        if(addExercicios(map, diasAdd, idTreino)){
                resultado = true;
        }
        return resultado;
    }
    
    /**
     * adiciona exercicio
     * @param map lista de exercicio conforme dia da semana
     * @param diasAdd lista de dias da semana
     * @param idTreino treino selecionado
     * @return retorna booleano, true se tiver adicionado treino
     */
    public boolean addExercicios(Map<String, List<Exercicio>> map, List<String> diasAdd, int idTreino){
        int contador = 0;
        for(String dia : diasAdd){
            if(addExerciciosPorDiaSemana(map, idTreino, dia)){
                contador++;
            }
        }
        return contador == diasAdd.size();
    }
    
    /**
     * adiciona exercicio pelo dia da semana
     * @param map lista de exercicio conforme dia da semana
     * @param dia lista de dias da semana
     * @param idTreino treino selecionado
     * @return retorna booleano, true se tiver adicionado exercicio pelo dia da semana
     */
    public boolean addExerciciosPorDiaSemana(Map<String, List<Exercicio>> map, int idTreino, String dia){
        boolean resultado = false;
        int contador = 0;
        if(!map.get(dia).isEmpty()){
            for(Exercicio e : map.get(dia)){
                if(Main.controllerManager.getApplicationModel().getTreinoDAO().insertTreinoHasExercicioSql(idTreino, e.getId(), dia)){
                    contador++;
                }
            }
            if(map.get(dia).size() == contador){
                resultado = true;
            }
        }
        return resultado;
    }
}
