/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Enrico
 */
public class Conexao {
    
    public Connection getConexao(){
    try {
    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/projetojava?serverTimezone=UTC", //local
        "root", //login
        "" //senha
    );
    return conn;
    } catch (SQLException e) {
        System.out.println("Erro ao conectar" +e.getMessage());
        return null;
    }
        
    }
            
}
