
package models;

import java.util.ArrayList;

public class Instrutor {
    private int id;
    private String nome;
    private String cpf;
    private ArrayList<Modalidade> modalidadesEnsinadas;

    public Instrutor() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Modalidade> getModalidadesEnsinadas() {
        return modalidadesEnsinadas;
    }

    public void setModalidadesEnsinadas(ArrayList<Modalidade> modalidadesEnsinadas) {
        this.modalidadesEnsinadas = modalidadesEnsinadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Instrutor{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", modalidadesEnsinadas=" + modalidadesEnsinadas + '}';
    }
    
    
    
}
