
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import models.Exercicio;
import models.Treino;

/**
 * Faz o controle entre as telas e back-end
 * @author tiovi
 */
public class TreinoAlterarController {

    public TreinoAlterarController() {
    }
    
    /**
     * retorna lista com todos os treinos
     * @return lista de treinos
     */
    public List<Treino> retornaListaTreinos(){
        return Main.controllerManager.getApplicationModel().getTreinoDAO().selectTreinos();
    }
    
    /**
     * retorna todos os exercicios do treino selecionado
     * @param idTreino treino selecionado
     * @param musc nome do musculo
     * @return retorna uma lista de exercicios do treino selecionado
     */
    public List<Exercicio> retornaListaExercicios(int idTreino, String musc){
        List<Exercicio> lista =  Main.controllerManager.getApplicationModel().getTreinoDAO().selectTreinoHasExercicioSql(idTreino);
        List<Exercicio> listaAux = new ArrayList();
        
        for(Exercicio e : lista){
            if(e.getMusculaturaAfetada().equals(musc)){
                listaAux.add(e);
            }
        }
        return listaAux;
    } 
    
    /**
     * atraves do musculo selecionado retorna a lista de exercicios para ele
     * @param musculo musculo selecionado
     * @param lista lista de exercicios
     * @return retorna a lista de exercicios para o musculo selecionado
     */
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
     * remove o exercicio do treino
     * @param idTreino treino selecionado
     * @return retorna booleano, true se o exercicio foi removido
     */
    public boolean removeExerciciosAntigos(int idTreino){
        boolean resultado = false;
        
        if(Main.controllerManager.getApplicationModel().getTreinoDAO().deleteTreinoHasExercicioSql(idTreino)){
            resultado = true;
        }
        return resultado;
    }
    
    /**
     * adiciona o treino com todas as informacoes
     * @param map lista de exercicios separados pelo dia da semana
     * @param descricao descricao treino
     * @param diasAdd dias do treino
     * @param idTreino treino selecionado
     * @return retorna booleano, true se o treino foi adicionado
     */
    public boolean btAddtreino(Map<String, List<Exercicio>> map, String descricao, List<String> diasAdd, int idTreino){
        boolean resultado = false;
        Main.controllerManager.getApplicationModel().getTreinoDAO().updateTreinoSql(idTreino, descricao);
        
        if(removeExerciciosAntigos(idTreino) && addExercicios(map, diasAdd, idTreino)){
                resultado = true;
        }
         
        return resultado;
    }
    
    /**
     * adiciona os exercicios ao dia da semana
     * @param map lista de exercicios separados pelo dia da semana
     * @param diasAdd dias do treino
     * @param idTreino treino selecionado
     * @return retorna booleano, true se os exercicios foi adicionado
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
     * adiciona exercicios nos dias da semana
     * @param map lista de exercicios separados pelo dia da semana
     * @param idTreino treino selecionado
     * @param dia 
     * @return retorna booleano, true se os exercicios foi adicionado no dia da semana
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
    
    /**
     * retorna lista com todos os exercicios selecionados
     * @param vetorCheckBox checkbox selecionados
     * @param lista lista de exercicios selecionados
     * @return retorna lista com todos os exercicios selecionados
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
     * retorna o treino pelo nome
     * @param nome nome do treino
     * @param listaTreinos lista de treino
     * @return retorna o treino selecionado com todas as informacoes
     */
    public Treino retornaTreinoPeloNome(String nome, List<Treino> listaTreinos){
        for(Treino t : listaTreinos){
            if(t.getNome().equals(nome)){
                return t;
            }
        }
        return null;
    }
    
    /**
     * remove treino
     * @param idTreino treino selecionado
     * @return retorna booleano, true se remove treino
    */
    public boolean removerTreino(int idTreino){
       return Main.controllerManager.getApplicationModel().getTreinoDAO().deleteTreinoSql(idTreino);
    }
    
    /**
     * valida a descricao, nao pode estar vazia
     * @param descricao descricao feita
     * @return retorna booleano, true se tiver algo na descricao
     */
    public boolean validaDescricao(String descricao){
        return !descricao.isBlank();
    }
    
    /**
     * valida exercicios pela lista de dias
     * @param diasAdd lista dias adicionados
     * @return retorna booleano, true se tiver validado a lista de dias
     */
    public boolean validaExercicios(List<String> diasAdd){
        return !diasAdd.isEmpty();
    }
}
