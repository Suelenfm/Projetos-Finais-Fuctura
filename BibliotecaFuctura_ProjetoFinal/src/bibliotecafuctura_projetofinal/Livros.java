package bibliotecafuctura_projetofinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Livros {

    ArrayList<String> autores = new ArrayList();
    ArrayList<Livros> livro = new ArrayList();
    Scanner scan = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    private int codigo;
    private String titulo = "";
    private String autor = "";
    private int isbn;
    private int numeroPaginas;
    private float valorLivro;
    private int edicao;
    private int volume;
    protected int Quantidade;
    protected String entrada;
    protected int entra;
    protected int pagAtual;
    protected boolean aberto;

    public Livros() {
    }

    public Livros(String autor) {
        this.autor = autor;
    }

    public Livros(int codigo, String titulo, String autor, int isbn, int numeroPaginas, float valorLivro, int edicao, int volume) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.valorLivro = valorLivro;
        this.edicao = edicao;
        this.volume = volume;
    }

    public Livros(int codigo, String titulo, int isbn, int numeroPaginas, float valorLivro, int edicao, int volume) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numeroPaginas = numeroPaginas;
        this.valorLivro = valorLivro;
        this.edicao = edicao;
        this.volume = volume;
    }

    public int menu(Scanner scan) {
        boolean entradaValida = false;
        int opcao = 0;
        String entrada;
        while (!entradaValida) {
            System.out.print("BEM VINDOS A "+ biblioteca.getNome() );
            System.out.println("""
                               \n  
                               1 - Cadastrar novo livro
                               2 - Listar títulos
                               3 - Listar Livros descriçao completa
                               4 - Pesquisar Livro título
                               5 - Pesquisar Livro ISBN
                               6 - Update Livro ISBN
                               7 - Update Livro Título
                               8 - Remover Livro por Título
                               9 - Remover Livro por Autor
                               10 - Remover Livro por ISBN
                               11 - Detalhes última leitura
                               12 - Leitura
                               13 - Informações Biblioteca
                               14 - Sair
                               """);
            try {

                entrada = scan.nextLine();
                opcao = Integer.parseInt(entrada);
                if (opcao > 0 && opcao <= 14) {
                    entradaValida = true;
                } else {
                    throw new Exception();
                }

            } catch (Exception e) {

                System.out.println("Entrada inválida, digite novamente\n\n");
            }
        }

        return opcao;
    }
    public void aberto(){
        aberto=true;
    }
    public void fechado(){
        aberto = false;
    }
    public void leitura() {
        System.out.println("Pesquise o título que deseja ler");
        entrada = scan.nextLine();
        for (int i = 0; i < livro.size(); i++) {
            if (livro.get(i).getTitulo().equals(entrada)) {
                System.out.println("\nTítulo: "+livro.get(i).getTitulo());
                System.out.println("Páginas"+livro.get(i).getNumeroPaginas());
                
            }
        }
                
   
                int resposta = 0;
                System.out.println("""
                                    1 - abrir livro
                                    2 - Avançar
                                    3 - Voltar página
                                    4 - fechar livro
                                    5 - detalhes da leitura;
                                    6 - menu principal
                                    """);
                
                while (resposta != 6) {
                
                resposta = scan.nextInt();
                    switch (resposta) {
                        case 1:
                            aberto = true;
                            System.out.println("Livro aberto");
                            break;

                        case 2:
                            if (aberto) {
                                avancarPag();
                                resposta = scan.nextInt();
                            } else {
                                System.out.println("Abra o livro primeiro");
                            }
                            break;

                        case 3:
                            if (aberto) {
                                voltarPag();
                                resposta = scan.nextInt();
                            } else {
                                System.out.println("Abra o livro primeiro");
                            }
                            break;

                        case 4:
                            aberto = false;
                            resposta = scan.nextInt();
                            break;

                        case 5:
                            detalhes();
                            break;
                        case 6:
                            menu(scan);
                            break;

                        default:
                            System.out.println("opção inválida.");
                            break;

                    }
                
        }
    }

    public void listarLivros() {

        for (Livros i : livro) {

            System.out.println(livro.toString().replace("[", "").replace("]", ""));

        }
    }

    public void pesquisarLivro() {
        System.out.println("Digite o título para iniciar sua pesquisa: ");
        entrada = scan.nextLine();
        for (int i = 0; i < livro.size(); i++) {
            if (livro.get(i).getTitulo().equals(entrada)) {
                System.out.println("Livro" + (i + 1) + "º");
                System.out.println("Código: "+livro.get(i).getCodigo());
                System.out.println("Título:"+livro.get(i).getTitulo());
                System.out.println("Autor: "+livro.get(i).getAutor());
                System.out.println("ISBN: "+livro.get(i).getIsbn());
                System.out.println("Páginas: "+livro.get(i).getNumeroPaginas());
                System.out.println("Preço: "+livro.get(i).getValorLivro());
                System.out.println("Edição: "+livro.get(i).getEdicao());
                System.out.println("Volume: "+livro.get(i).getVolume());
                System.out.println("\nPesquisa concluida");

            }
        }

    }

    public void updateLivroISBN() {

        System.out.print("Digite o ISBN do livro para realizar update: ");
        entra = scan.nextInt();
        for (int i = 0; i < livro.size(); i++) {
            if (livro.get(i).getIsbn() == entra) {
                livro.remove(i);
                System.out.print("\nCódigo do livro: ");
                setCodigo(scan.nextInt());
                System.out.print("Título do livro: ");
                setTitulo(scan.next());
                System.out.print("Autor do livro: ");
                setAutor(scan.next());
                System.out.print("ISBN: ");
                setIsbn(scan.nextInt());
                System.out.print("Páginas: ");
                setNumeroPaginas(scan.nextInt());
                System.out.print("Preço: ");
                setValorLivro(scan.nextFloat());
                System.out.print("Edição: ");
                setEdicao(scan.nextInt());
                System.out.print("Volume: ");
                setVolume(scan.nextInt());

                livro.add(new Livros(getCodigo(), getTitulo(), getAutor(), getIsbn(),
                        getNumeroPaginas(), getValorLivro(), getEdicao(), getVolume()));

                System.out.println("Livro atualizado com sucesso!\n");
            }

        }
    }

    public void updateLivroTitulo() {

        System.out.print("Digite o título do livro para realizar update: ");
        String entrada = scan.nextLine();
        for (int i = 0; i < livro.size(); i++) {
            if (livro.get(i).getTitulo().equals(entrada)) {
                livro.remove(i);
                System.out.print("\nCódigo do livro: ");
                setCodigo(scan.nextInt());
                System.out.print("Título do livro: ");
                setTitulo(scan.next());
                System.out.print("Autor do livro: ");
                setAutor(scan.next());
                System.out.print("ISBN: ");
                setIsbn(scan.nextInt());
                System.out.print("Páginas: ");
                setNumeroPaginas(scan.nextInt());
                System.out.print("Preço: ");
                setValorLivro(scan.nextFloat());
                System.out.print("Edição: ");
                setEdicao(scan.nextInt());
                System.out.print("Volume: ");
                setVolume(scan.nextInt());
                livro.add(new Livros(getCodigo(), getTitulo(), getAutor(), getIsbn(),
                        getNumeroPaginas(), getValorLivro(), getEdicao(), getVolume()));

                System.out.println("Livro atualizado com sucesso!\n");

            }

        }
    }

    public void removerLivroTitulo() {

        System.out.print("Digite o título do livro a ser removido: ");
        entrada = scan.nextLine();
        for (int i = 0; i < livro.size(); i++) {
            if (livro.get(i).getTitulo().equals(entrada)) {
                livro.remove(i);

            }
            System.out.print("Livro removido com sucesso!");

        }
    }

    public void removerLivroAutor() {
        System.out.print("Digite o autor do livro para remover todos os livros: ");
        entrada = scan.nextLine();
        for (int i = 0; i < livro.size(); i++) {
            if (livro.get(i).getAutor().equals(entrada)) {
                livro.remove(i).getAutor();
                //  livro.remove(i);

            }
            System.out.print("Livro(s) removido com sucesso!");

        }
    }

    public void removerLivroIsbn() {

        System.out.print("Digite o ISBN do livro a ser removido: ");
        entra = scan.nextInt();
        for (int i = 0; i < livro.size(); i++) {
            if (livro.get(i).getIsbn() == entra) {
                livro.remove(i);

            }
            System.out.print("Livro removido com sucesso!");

        }
    }

    public void pesquisarIBSN() {
        System.out.println("Digite o ISBN para iniciar sua pesquisa: ");
        entra = scan.nextInt();

        for (int i = 0; i < livro.size(); i++) {
            if (livro.get(i).getIsbn() == entra) {
                System.out.println("Livro" + (i + 1) + "º");
                System.out.println("Código: "+livro.get(i).getCodigo());
                System.out.println("Título:"+livro.get(i).getTitulo());
                System.out.println("Autor: "+livro.get(i).getAutor());
                System.out.println("ISBN: "+livro.get(i).getIsbn());
                System.out.println("Páginas: "+livro.get(i).getNumeroPaginas());
                System.out.println("Preço: "+livro.get(i).getValorLivro());
                System.out.println("Edição: "+livro.get(i).getEdicao());
                System.out.println("Volume: "+livro.get(i).getVolume());
                System.out.println("\nPesquisa concluida");
            }
        }
    }

    public void detalhes() {

        int falta = getNumeroPaginas() - getPagAtual();
        System.out.println("Detalhes da última leitura");
        System.out.println("TÍTULO: " + getTitulo());
        System.out.println("TOTAL DE PÁGINAS: " + getNumeroPaginas());
        System.out.println("AUTOR: " + getAutor());
        System.out.println("PAROU LEITURA NA PÁGINA: " + getPagAtual());
        System.out.println("FALTAM " + falta + " PÁGINAS PARA ACABAR A LEITURA DESTE LIVRO");

    }

    public void avancarPag() {

        if (this.getPagAtual() < this.getNumeroPaginas()) {
            this.setPagAtual(this.getPagAtual() + 1);
            System.out.println(this.getPagAtual());

        } else {
            System.out.println("FIM DO LIVRO");
        }

    }

    public void voltarPag() {

        if (this.getPagAtual() <= this.getNumeroPaginas() && this.getPagAtual() != 0) {
            this.setPagAtual(this.getPagAtual() - 1);
            System.out.println(this.getPagAtual());

        } else if (this.getPagAtual() == 0) {
            System.out.println(" VOCÊ JÁ ESTÁ NA PÁGINA 0");

        }

    }

    public void cadastrarLivro() {

        System.out.print("Digite quantos livros deseja cadastrar: ");
        setQuantidade(scan.nextInt()); // entrada e soma de quantidade
        System.out.println("\n ==============================");
        for (int i = 0; i < getQuantidade(); i++) { // percorrendo arraylist 
            System.out.println("Cadastre o " + (i + 1) + "° livro ");
            System.out.print("\nCódigo do livro: ");
            setCodigo(scan.nextInt());
            System.out.print("Título do livro: ");
            setTitulo(scan.nextLine());
            System.out.print("Autor do livro: ");
            setAutor(scan.nextLine());
            System.out.print("ISBN: ");
            setIsbn(scan.nextInt());
            System.out.print("Páginas: ");
            setNumeroPaginas(scan.nextInt());
            System.out.print("Preço: ");
            setValorLivro(scan.nextFloat());
            System.out.print("Edição: ");
            setEdicao(scan.nextInt());
            System.out.print("Volume: ");
            setVolume(scan.nextInt());

            livro.add(new Livros(getCodigo(), getTitulo(), getAutor(), getIsbn(),
                    getNumeroPaginas(), getValorLivro(), getEdicao(), getVolume()));

            System.out.println("Livro(s) adicionado(s) com sucesso!\n");

        }
    }

    public void listarTitulos() {
        for (Livros i : livro) {
            System.out.println(i.getTitulo());
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public float getValorLivro() {
        return valorLivro;
    }

    public void setValorLivro(float valorLivro) {
        this.valorLivro = valorLivro;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAtual = pagAtual;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    @Override
    public String toString() {

        return "\nCódigo do livro: " + getCodigo() + "\nTítulo do Livro: " + getTitulo()
                + "\nISBN: " + getIsbn() + "\nPáginas: " + "\nAutor: " + getAutor()
                + getNumeroPaginas() + "\nPreço: " + getValorLivro() + "\nEdição: " + getEdicao()
                + "\nVolume: " + getVolume() + "\n--------------------------\n";

    }

}
