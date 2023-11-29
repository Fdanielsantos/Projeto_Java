/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 342009
 */
public class ProfessorDAO extends DataBaseDAO{
    
    public ProfessorDAO() throws Exception{}
    
    public ArrayList<Professor> getLista() throws Exception{
        
        ArrayList<Professor> lista = new ArrayList<Professor>();
        String SQL = "SELECT * FROM professor";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(SQL);
        while(rs.next()){
            Professor p = new Professor();
            p.setId(rs.getInt("id"));
            p.setMatr(rs.getString("matr"));
            p.setNome(rs.getString("nome"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    
    }
    
    public boolean gravar (Professor p){
    
        try{
          String sql;
          this.conectar();
          if(p.getId()==0){
              sql = "INSERT INTO professor (matr,nome) VALUES (?,?)";
          }else{
              sql = "UPDATE professor SET matr=?, nome=? WHERE id=?";
          }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getMatr());
            pstm.setString(2, p.getNome());
            if(p.getId()>0){
                pstm.setInt(3,p.getId());
            }
            pstm.execute();
            this.desconectar();
            return true;            
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    
    }
    
    public Professor getCarregaPorID(int id) throws Exception{
        Professor p = new Professor();
        String sql = "SELECT * FROM professor WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            p.setId(id);
            p.setMatr(rs.getString("matr"));
            p.setNome(rs.getString("nome"));   
        }
        this.desconectar();
        return p;
    
    }
    
    public boolean deletar(Professor p){
        
        try{
            this.conectar();
            String SQL = "DELETE FROM professor WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, p.getId());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
}
