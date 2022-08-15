/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Curso;
import java.sql.Connection;
import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Enrico
 */
public class CursoDAO {
    private Conexao conexao;
    private Connection conn;
    
    //construtor da classe
    
    public CursoDAO(){
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
    }
    
    public void inserir (Curso curso){
        String sql = "INSERT INTO cursos(nomecurso, nivel, valor) VALUES " + "(?, ?, ?)";
        try{
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString (1, curso.getNomecurso());
        stmt.setString (2, curso.getNivel());
        stmt.setFloat (3, curso.getValor());
        stmt.execute();
            
        }
        catch (Exception e) {
            System.out.println("Erro ao inserir curso: " + e.getMessage());          
        }    
    }
    public Curso getCurso(int id){
        String sql = "SELECT * FROM cursos WHERE id = ?";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Curso curso = new Curso();
            rs.first();
            curso.setId(id);
            curso.setNomecurso (rs.getString("nomecurso"));
            curso.setNivel(rs.getString("nivel"));
            curso.setValor(rs.getFloat("valor"));
            return curso;
        } catch (Exception e) {
            return null;
        }
    }
}

