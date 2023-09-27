package com.media.porjetocrud;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.media.porjetocrud.models.Veiculo;


/**
 *
 * @author samue
 */
public class Application {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Veiculo> veiculos;
    static int contador = 0;

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        veiculos = Dao.resgatarVeiculos(contador);
        int opcao;
        do{
            opcao = menuPrincipal();
            funcoes(opcao);
        }while (opcao != 0);

    }

    public static int menuPrincipal() throws InterruptedException, IOException{
        LimpaConsole.limpar();
        exibeVeiculos();
        
        System.out.println("""
                1 - Cadastrar novo veículo
                2 - Editar veículo cadastrado
                3 - Excluir veículo cadastrado
                0 - Sair
                """);
        int opcao = pegaOpcao(0,3);

        return opcao;
    }

    private static void exibeVeiculos() {
        System.out.println("---------------------------------------------|| Lista de veículos ||---------------------------------------------");
        if (veiculos.isEmpty()){
            System.out.println("Não há veículos para exibir");
            System.out.println("Cadastre novos veículos e eles aparecerão aqui");
        }else{
            for (Veiculo veiculo : veiculos) {
                System.out.println("\n" + veiculo.toString());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------");
    }

    public static void funcoes(int opcao) throws InterruptedException, IOException, SQLException{
        LimpaConsole.limpar();
        switch (opcao) {
            //Cadastrar novo veiculo
            case 1:
            System.out.println("Cadastro de novo veículo");

            System.out.println("Informe a marca:"); 
            String marca = scan.nextLine();

            System.out.println("Informe o modelo");
            String modelo = scan.nextLine();

            System.out.println("Informe o ano do veículo:");
            int ano = pegaInteiro();

            System.out.println("Informe a placa");
            String placa = scan.nextLine();

            System.out.println("Informe a cor");
            String cor = scan.nextLine();

            System.out.println("Informe o id do proprietário");
            int IdProprietario = pegaInteiro();

            System.out.println("Informe o id da vaga");
            int IdVaga = pegaInteiro();
            
            try {
                Dao.inserirVeiculo(marca, modelo, ano, placa, cor, IdProprietario, IdVaga);
                Veiculo carro = new Veiculo(contador, marca, modelo, ano, placa, cor, IdProprietario, IdVaga);
                contador++;
                veiculos.add(carro);


                
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Houve um erro na inserção do registro");
                System.out.println(e);
                System.out.println("Tente novamente");
                System.out.println("Pressione enter para continuar");
                scan.nextLine();
            }
                


            break;
            //Editar veiculo
            case 2:
            if (veiculos.isEmpty()) {
                System.out.println("Não há veículos para alterar");
                System.out.println("Cadastre veículos para poder utilizar esta função");
                System.out.println("Pressione enter para voltar");
                scan.nextLine();

                
            }else{
                exibeVeiculos();

                System.out.println("Informe o id do veículo que deseja editar");
                int selecionaIdCarro = pegaInteiro();

                Veiculo manipulaCarro = null;

            boolean find = false;
            for (Veiculo veiculo : veiculos) {
                    if (veiculo.getId() == selecionaIdCarro){
                    find = true;         
                    manipulaCarro = veiculo;        
                    }

                }
                if (!find){
                    System.out.println("Veículo não encontrado");
                    break;
                }

                LimpaConsole.limpar();

            System.out.println("""
                Selecione o que deseja alterar:

                1 - marca
                2 - modelo
                3 - ano
                4 - placa
                5 - cor
                6 - ID do Proprietário
                7 - ID da vaga

                    """);

            int alteracao = pegaOpcao(1, 7);

            System.out.println("Informe o novo valor");
            String novoValor = scan.nextLine();

            String opcao1 = "null";
            

            switch (alteracao) {
                case 1:
                    opcao1 = "marca";
                    manipulaCarro.setMarca(novoValor);

                    break;

                case 2:
                opcao1 = "modelo";
                manipulaCarro.setModelo(novoValor);
                
                    break;
                case 3:
                opcao1 = "ano";
                manipulaCarro.setAno(Integer.parseInt(novoValor));
                
                    break;
                case 4:
                opcao1 = "placa";
                manipulaCarro.setPlaca(novoValor);
                
                    break;
                case 5:
                opcao1 = "cor";
                manipulaCarro.setCor(novoValor);
                
                    break;

                    case 6:
                    opcao1 = "id_proprietario";
                manipulaCarro.setIdProprietario(Integer.parseInt(novoValor));
                
                    break;

                    case 7:
                    opcao1 = "id_vaga";
                manipulaCarro.setIdVaga(Integer.parseInt(novoValor));
                
                    break;
            
                default:
                System.out.println("Selecione uma opção válida");
                    break;
            }

            if(alteracao > 0 && alteracao <= 7){

            if (alteracao != 3 && alteracao!= 6 && alteracao != 7){
                Dao.atualizaVeiculo(opcao1, novoValor, selecionaIdCarro);
            }else{
                Dao.atualizaVeiculo(opcao1, Integer.parseInt(novoValor), selecionaIdCarro);
            }
        }
            }

                break;
            case 3:
            if (veiculos.isEmpty()) {
                System.out.println("Não há veículos para excluir");
                System.out.println("Cadastre veículos para poder utilizar esta função");
                System.out.println("Pressione enter para voltar");
                scan.nextLine();

                
            }else{
                exibeVeiculos();

                System.out.println("Informe o id do veículo que deseja excluir");
                int selecionaIdCarro = pegaInteiro();

                LimpaConsole.limpar();

                System.out.println("Tem certeza? o registro será excluido pra sempre (Bastante tempo)");
                System.out.println("1 - Sim/0 - Não");
                if (scan.nextLine().equals("1")){
                    Dao.removeVeiculo(selecionaIdCarro);
                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getId() == selecionaIdCarro){
                            veiculos.remove(veiculo);
                            break;
                        }
                    }
                }
            }
            
                break;

            case 0:
            
                break;
    
            default:
            System.out.println("Informe um valor válido");
                break;
        }
    }

    public static int pegaOpcao(int min, int max){
        /*if (opcao.equals("")){
            System.out.println("Informe um valor");
        }*/
        
        boolean valido = false;
        int intOpcao = 0;
        
        do{
            String opcao = scan.nextLine();
            try{
        intOpcao = Integer.parseInt(opcao);
        if (intOpcao < min || intOpcao > max){
            System.out.println("Informe uma opção válida");
        }else{
            valido = true;
        }

    }catch(Exception e) {
        System.out.println("Informe uma opção válida");
    }
    }while (!valido);

    return intOpcao;

}

public static int pegaInteiro(){
        /*if (opcao.equals("")){
            System.out.println("Informe um valor");
        }*/
        
        boolean valido = false;
        int inteiro = 0;
        
        do{
            String entrada = scan.nextLine();
            try{
                inteiro = Integer.parseInt(entrada);
                valido = true;

            }catch(Exception e) {
                System.out.println("Informe um número válido");
            }
        }while (!valido);

    return inteiro;

}
}


