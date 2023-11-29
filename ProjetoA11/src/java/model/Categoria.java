
package model;


public class Categoria {
    
    private int id;
    private String duracao;
    private String nome;

    public Categoria() {
    }

    public Categoria(int id, String duracao, String nome) {
        this.id = id;
        this.duracao = duracao;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "categoria{" + "nome=" + nome + '}';
    }

}
