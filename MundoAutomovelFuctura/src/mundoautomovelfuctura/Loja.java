package mundoautomovelfuctura;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja extends Carros {
//variáveis , métodos.

    private int quantidade;
    Pessoa dono = new Pessoa();
    ArrayList<Carros> carrosCadastrados = new ArrayList();
    Scanner scan = new Scanner(System.in);

    public Loja() {
    }
//Informações sobre a loja

    public void InforLoja() {
        System.out.println("""
               Mundo dos Automóveis - CNPJ: 00.394.460/0058-87
              Endereço: Rua do Sol, Nº14, São José / Recife-PE,              
                      Site: mundodoscarros.com.br 
                Email: mundodosautomoveis@contato.com
                          SAC: 3300-0001
                           
                           """);

    }

//obter lista de menu
    protected static int menu(Scanner scan) {
        boolean entradaValida = false;
        int opcao = 0;
        String entrada;
        while (!entradaValida) {
            System.out.println("""
                               BEM VINDOS AO MUNDO DOS AUTOMÓVEIS!\n ); 
                               1 - Cadastrar novo carro
                               2 - Pesquisar Carro
                               3 - Listar todos os Carros
                               4 - Alterar dados cadastrais
                               5 - Informações da Loja
                               6 - Finalizar
                               """);
            try {
                entrada = scan.nextLine();
                opcao = Integer.parseInt(entrada);
                if (opcao > 0 && opcao <= 6) {
                    entradaValida = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, digite uma opção!\n");
            }
        }
        return opcao;
    }
//UpdateDados

    protected void UpdateDados(ArrayList<Carros> carrosCadastrados) {

//        Verifica se existem carros cadastrados  no sistema
        if (this.getQuantidade() > 0) {

            //pedir o número da placa para pesquisa
            System.out.println("*========ATUALIZAÇÃO DADOS=========*");
            System.out.println("Digite a Placa: ");
            String placa = scan.next();
            System.out.println("*====== INFORMAÇÕES PARA ATUALIZAÇÃO DE DADOS ======*");
            
            for (int i = 0; i < carrosCadastrados.size(); i++) {
                if (carrosCadastrados.get(i).getPlaca().equals(placa)) {

                    //remover informações a partir placa
                    carrosCadastrados.remove(i);

                    //atualização de informações cadastrais:
                    System.out.print("Nome: ");
                    dono.setNome(scan.next());
                    System.out.print("CPF: ");
                    dono.setCpf(scan.next());
                    System.out.print("Telefone: ");
                    dono.setTelefone(scan.next());

                    System.out.print("Marca: ");
                    setMarca(scan.next());

                    System.out.print("Modelo: ");
                    setModelo(scan.next());

                    System.out.print("Placa: ");
                    setPlaca(scan.next());

                    System.out.print("Ano: ");
                    setAno(scan.nextInt());

                    System.out.print("Valor: ");
                    setValorAproximado(scan.nextDouble());

                    //novo arraylist para guardar as novas informações da atualização
                    //dados do carro
                    carrosCadastrados.add(new Carros(getMarca(), getModelo(), getPlaca(),
                            getAno(), getValorAproximado(),
                            //dados pessoa
                            new Pessoa(dono.getNome(), dono.getCpf(), dono.getTelefone())));
                    System.out.println("Deseja consultar os dados do update? Responda [S/N]: ");
                    String resposta = scan.next();
                    if (resposta.equalsIgnoreCase("S")) {
                        //Listando dados caso a resposta seja 'S'
                        System.out.print("CONSULTA DE DADOS ATUALIZADOS...\n");
                        System.out.println("Nome: " + dono.getNome());
                        System.out.println("CPF: " + dono.getCpf());
                        System.out.println("Telefone: " + dono.getTelefone());
                        System.out.println("Marca: " + getMarca());
                        System.out.println("Modelo: " + getModelo());
                        System.out.println("Placa: " + getPlaca());
                        System.out.println("Ano: " + getAno());
                        System.out.println("Valor: " + getValorAproximado());
                    } else {
                        System.out.println("*===============================================*");
                        System.out.println(" Update do carro realizado com sucesso!! ");
                    }
                }
             
            }

        } else {
            System.out.println("Não existem carros cadastrados no sistema.");
        }

    }
    //Pesquisa de Dados através da placa

    protected void PesquisarDados(ArrayList<Carros> carrosCadastrados) {
        System.out.println("*======= PESQUISAR CARRO =======*");
        System.out.println("Digite a placa do carro que deseja procurar: ");
        String placa = scan.next();
        System.out.println("*========== RESULTADOS ===========*");
        for (int i = 0; i < carrosCadastrados.size(); i++) {
            if (carrosCadastrados.get(i).getPlaca().equals(placa)) {
                System.out.println("Marca: " + carrosCadastrados.get(i).getMarca());
                System.out.println("Modelo: " + carrosCadastrados.get(i).getModelo());
                System.out.println("Placa: " + carrosCadastrados.get(i).getPlaca());
                System.out.println("Ano: " + carrosCadastrados.get(i).getAno());
                System.out.println("Valor: " + carrosCadastrados.get(i).getValorAproximado());
                System.out.println("Nome do dono: " + carrosCadastrados.get(i).getDono().getNome());
                System.out.println("CPF: " + carrosCadastrados.get(i).getDono().getCpf());
                System.out.println("Telefone: " + carrosCadastrados.get(i).getDono().getTelefone());
            }
        }
    }
//Listar dados

    protected void ListarDados(ArrayList<Carros> carrosCadastrados) {
        System.out.println("*========== LISTA DE CARROS ===========*");
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("======================================");
        for (Carros i : carrosCadastrados) { // for each para listar
            System.out.println("Marca: " + i.getMarca());
            System.out.println("Modelo: " + i.getModelo());
            System.out.println("Placa: " + i.getPlaca());
            System.out.println("Ano: " + i.getAno());
            System.out.println("Valor: " + i.getValorAproximado());
            System.out.println("Nome do dono: " + i.getDono().getNome());
            System.out.println("CPF: " + i.getDono().getCpf());
            System.out.println("Telefone: " + i.getDono().getTelefone());
            System.out.println("=======================================");
        }
    }
//Adicionando dados ao sistema

    protected void adicionarDados(ArrayList<Carros> carrosCadastrados, Scanner scan) {
        try {

            System.out.print("BEM VINDO(A)! \n");

            System.out.print("Digite quantos carros deseja cadastrar: ");
            setQuantidade(scan.nextInt()); // entrada e soma de quantidade

            System.out.println("\n ==============================");
        } catch (Exception e) {
            System.out.println("Entrada inválida, digite a quantidade de carros a cadastrar. \n");
        }
        for (int i = 0; i < getQuantidade(); i++) { // percorrendo arraylist 
            System.out.println("CADASTRE O " + (i + 1) + "° CARRO: ");
            System.out.print("Marca: ");
            setMarca(scan.next());
            System.out.print("Modelo: ");
            setModelo(scan.next());
            System.out.print("Placa: ");
            setPlaca(scan.next());
            System.out.print("Ano: ");
            setAno(scan.nextInt());
            System.out.print("Valor: ");
            setValorAproximado(scan.nextDouble());
            System.out.println(" *==== CADASTRO DO PROPRIETÁRIO DO CARRO ====*");
            System.out.print("Nome do dono:");
            dono.setNome(scan.next());
            System.out.print("Cpf do dono: ");
            dono.setCpf(scan.next());
            System.out.print("Telefone do dono: ");
            dono.setTelefone(scan.next());
            System.out.println("==============================================");

            //nova instância para guardar informações de cadastro
            //Chamada do arraylist carro
            carrosCadastrados.add(new Carros(getMarca(), getModelo(), getPlaca(), getAno(), getValorAproximado(),
                    // Objeto Pessoa.
                    new Pessoa(dono.getCpf(), dono.getNome(), dono.getTelefone())));

        }

    }

//método auxiliar : getter ou get
    protected int getQuantidade() {
        return quantidade;
    }
//método modificador : setter ou set

    protected void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
