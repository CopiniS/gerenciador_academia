
package models;

import java.util.ArrayList;

public class Modalidade {
    private int id;
    private String nome;

    public Modalidade() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Modalidade{" + "id=" + id + ", nome=" + nome + ", horarios=";
    }
    
    
}
