package bibliotecafuctura_projetofinal;

public class Biblioteca {

    protected String nome = "LIVRARIA FEIJÓ";
    protected String local = "Rua da Matriz";
    protected String capacidade = "52m²";
    protected String secao = "Auto Ajuda";

   

    public Biblioteca() {
    }

    public Biblioteca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getSessao() {
        return secao;
    }

    public void setSessao(String secao) {
        this.secao = secao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nLocal: " + local + "\nCapacidade: " + capacidade + "\nSeçao: " + secao;
    }

}
