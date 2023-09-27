/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.media.porjetocrud;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aluno
 */
public class Dao {
    public static void main(String[] args) {
        try {
           Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Driver não encontrado");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(""
                    + "jdbc:mariadb://localhost:3306/basedados?useTimezone=true&serverTimezone=UTC&useBulkStmts=false", 
                    "root", "secret");    
            System.out.println("Conectado!!!");
        }catch(Exception e){
            System.out.println("Desconectado!!!");
        }
    }
}
