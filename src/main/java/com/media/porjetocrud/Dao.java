/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.media.porjetocrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.media.porjetocrud.models.Veiculo;

/**
 *
 * @author Aluno
 */
public class Dao {
    public static void main(String[] args) throws SQLException {
        //System.out.println(resgatarVeiculos());
        //atualizaVeiculo();
        //removeVeiculo(2);
        //System.out.println(resgatarVeiculos());

        
    }

    public static Connection conectar(){
        try {
           Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Driver não encontrado");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(""
                    + "jdbc:mariadb://localhost:3306/basedados?useTimezone=true&serverTimezone=UTC&useBulkStmts=false", 
                    "root", "secret");    
            System.out.println("Conectado com sucesso");

            return conexao;

            
        }catch(Exception e){
            System.out.println("Falha na conexão");
            return null;
        }
    

    }

    public static void inserirVeiculo(String marca, String modelo, int ano, String placa, String cor, int idProprietario, int idVaga) throws SQLException{
        Connection conexao = conectar();

            String inserir = "INSERT INTO veiculo (marca, modelo, ano, placa, cor, id_proprietario, id_vaga) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = conexao.prepareStatement(inserir);
            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setInt(3, ano);
            ps.setString(4, placa);
            ps.setString(5, cor);
            ps.setInt(6, idProprietario);
            ps.setInt(7, idVaga);

            ps.execute();

            conexao.commit();
    }

    public static ArrayList<Veiculo> resgatarVeiculos(int contador) throws SQLException{
        Connection conexao = conectar();

            String resgatar = "SELECT * FROM veiculo";

            PreparedStatement ps = conexao.prepareStatement(resgatar);
            ResultSet rs = ps.executeQuery();

            ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

            if(rs.first()){
                do{
                    int id = rs.getInt(1);
                    String marca = rs.getString(2);
                    String modelo = rs.getString(3);
                    int ano = rs.getInt(4);
                    String placa = rs.getString(5);
                    String cor = rs.getString(6);
                    int idProprietario = rs.getInt(7);
                    int idVaga = rs.getInt(8);
                    contador = rs.getInt(1) + 1;

                    Veiculo veiculo = new Veiculo(id, marca, modelo, ano, placa, cor, idProprietario, idVaga);
                    veiculos.add(veiculo);
                }while(rs.next());

                return veiculos;
            }else{
                ArrayList<Veiculo> veiculos1 = new ArrayList<Veiculo>();
                return veiculos1;
            }

    }

    public static void atualizaVeiculo(String opcao, int valor, int id) throws SQLException{
        Connection conexao = conectar();

        String sql = "update veiculo set " + opcao + " = ? where id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setInt(1, valor);
        ps.setInt(2, id);

        ps.execute();

    }

    public static void atualizaVeiculo(String opcao, String valor, int id) throws SQLException{
        Connection conexao = conectar();

        String sql = "update veiculo set " + opcao + " = ? where id = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        
        ps.setString(1, valor);
        ps.setInt(2, id);

        ps.execute();

    }


    public static void removeVeiculo(int id) throws SQLException{
        Connection conexao = conectar();

        String sql = "delete v from veiculo v where v.id = ?";

        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setInt(1, id);

        ps.execute();


    }


    
}
