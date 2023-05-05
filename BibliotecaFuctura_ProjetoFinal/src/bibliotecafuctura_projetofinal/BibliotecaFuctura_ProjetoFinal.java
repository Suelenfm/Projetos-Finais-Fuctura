package bibliotecafuctura_projetofinal;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaFuctura_ProjetoFinal  {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList <Livros> livros = new ArrayList();
    Livros l = new Livros();
    Biblioteca ver = new Biblioteca();
    int opcao = 1;
    while (opcao!=14){
    opcao = l.menu(scan);
    switch(opcao){
        case 1:
        l.cadastrarLivro();
        break;
        
        case 2:
        l.listarTitulos();
        break;
        
        case 3:
        l.listarLivros();
        break;
        
        case 4:
        l.pesquisarLivro();
        break;
        
        case 5:
        l.pesquisarIBSN();
        break;
    
        case 6:
        l.updateLivroISBN();
        break;
    
        case 7:
        l.updateLivroTitulo();
        break;
    
        case 8:
        l.removerLivroTitulo();
        break;
        
        case 9:
        l.removerLivroAutor();
        break;
        
        case 10:
        l.removerLivroIsbn();
        break;
    
        case 11:
        l.detalhes();
        break;
        
        case 12:
        l.leitura();
        break;
        
        case 13:                  
        System.out.println(ver);
        break;
        
        case 14:                  
        System.out.println("Adeus!");
        break;
        
        default:                  
        System.out.println("Opção inválida!");
        break;
                 }
    
    
         }
    }
}