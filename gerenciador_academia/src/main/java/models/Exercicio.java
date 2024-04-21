
package models;

public class Exercicio {
    private int id;
    private String nome;
    private String musculaturaAfetada;

    public Exercicio() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMusculaturaAfetada() {
        return musculaturaAfetada;
    }

    public void setMusculaturaAfetada(String musculaturaAfetada) {
        this.musculaturaAfetada = musculaturaAfetada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Exercicio{" + "id=" + id + ", nome=" + nome + ", musculaturaAfetada=" + musculaturaAfetada + '}';
    }
    
    
}
