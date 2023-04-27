package mundoautomovelfuctura;

import java.util.ArrayList;
import java.util.Scanner;
import mundoautomovelfuctura.Carros;
public class MundoAutomovelFuctura extends Loja {

    public static void main(String[] args) {
        //métodos e variáveis
        int opcao = 0;
        ArrayList<Carros> carros = new ArrayList();
        Scanner scan = new Scanner(System.in);
        Loja l1 = new Loja();
        
       
        //Menu Principal
        while(opcao != 6){
        opcao = l1.menu(scan);
        switch (opcao){
            case 1:
                l1.adicionarDados(carros,scan);
                break;
            case 2:
                l1.PesquisarDados(carros);
                break;
            case 3:
                l1.ListarDados(carros);
                break;
            case 4:
                l1.UpdateDados(carros);
                break;
            case 5:
                l1.InforLoja();
                break;
            default:
                System.out.println("Escolha uma opção do menu..."); 
                break;
        }
        }
        System.out.println("Obriga pela preferência, volte sempre!");
        }
    
    

}
