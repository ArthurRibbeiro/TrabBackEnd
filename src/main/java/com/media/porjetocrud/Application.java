package com.media.porjetocrud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    static int contador = 0;

    public static void main(String[] args) throws InterruptedException, IOException {
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
        int opcao = Integer.parseInt(scan.nextLine());

        return opcao;
    }

    private static void exibeVeiculos() {
        System.out.println("-----------------------------------------");
        if (veiculos.isEmpty()){
            System.out.println("Não há veículos para exibir");
            System.out.println("Cadastre novos veículos e eles aparecerão aqui");
        }else{
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo.toString());
            }
        }
        System.out.println("-----------------------------------------");
    }

    public static void funcoes(int opcao) throws InterruptedException, IOException{
        LimpaConsole.limpar();
        switch (opcao) {
            case 1:
            System.out.println("Cadastro de novo veículo");

            System.out.println("Informe a marca:"); 
            String marca = scan.nextLine();

            System.out.println("Informe o modelo");
            String modelo = scan.nextLine();

            System.out.println("Informe o ano do veículo:");
            int ano = Integer.parseInt(scan.nextLine());

            System.out.println("Informe a placa");
            String placa = scan.nextLine();

            System.out.println("Informe a cor");
            String cor = scan.nextLine();

            System.out.println("Informe o id do proprietário");
            int IdProprietario = Integer.parseInt(scan.nextLine());

            System.out.println("Informe o id da vaga");
            int IdVaga = Integer.parseInt(scan.nextLine());

            Veiculo carro = new Veiculo(contador, marca, modelo, ano, placa, cor, IdProprietario, IdVaga);
            contador++;

            System.out.println();

            veiculos.add(carro);

            break;
            case 2:
            if (veiculos.isEmpty()) {
                System.out.println("Não há veículos para alterar");
                System.out.println("Cadastre veículos para poder utilizar esta função");

                
            }else{
                exibeVeiculos();

                System.out.println("Informe o id do veículo que deseja editar");
                int selecionaIdCarro = Integer.parseInt(scan.nextLine());

                Veiculo manipulaCarro = null;

            boolean find = false;
            for (Veiculo veiculo : veiculos) {
                    if (veiculo.getId() == selecionaIdCarro)
                    find = true;         
                    manipulaCarro = veiculo;        

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

            int alteracao = Integer.parseInt(scan.nextLine()); 

            System.out.println("Informe o novo valor");
            String novoValor = scan.nextLine();
            

            switch (alteracao) {
                case 1:
                    manipulaCarro.setMarca(novoValor);

                    break;

                case 2:
                manipulaCarro.setModelo(novoValor);
                
                    break;
                case 3:
                manipulaCarro.setAno(Integer.parseInt(novoValor));
                
                    break;
                case 4:
                manipulaCarro.setPlaca(novoValor);
                
                    break;
                case 5:
                manipulaCarro.setCor(novoValor);
                
                    break;

                    case 6:
                manipulaCarro.setIdProprietario(Integer.parseInt(novoValor));
                
                    break;

                    case 7:
                manipulaCarro.setIdVaga(Integer.parseInt(novoValor));
                
                    break;
            
                default:
                System.out.println("Selecione uma opção válida");
                    break;
            }
            
            }
                
            
                break;
            case 3:
            if (veiculos.isEmpty()) {
                System.out.println("Não há veículos para excluir");
                System.out.println("Cadastre veículos para poder utilizar esta função");

                
            }else{
                exibeVeiculos();

                System.out.println("Informe o id do veículo que deseja excluir");
                int selecionaIdCarro = Integer.parseInt(scan.nextLine());

                LimpaConsole.limpar();

                System.out.println("Tem certeza? o registro será excluido pra sempre (Bastante tempo)");
                System.out.println("1 - Sim/0 - Não");
                if (scan.nextLine().equals("1")){
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
}