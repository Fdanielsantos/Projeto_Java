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
 * @author flavi
 */
public class AlunoDAO  extends DataBaseDAO{
        public AlunoDAO() throws Exception{}
    
    public ArrayList<Aluno> getLista() throws Exception{
        
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        String SQL = "SELECT * FROM aluno";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(SQL);
        while(rs.next()){
            Aluno a = new Aluno();
            a.setId(rs.getInt("id"));
            a.setMatr(rs.getString("matr"));
            a.setNome(rs.getString("nome"));
            lista.add(a);
        }
        this.desconectar();
        return lista;
    
    }
    
    public boolean gravar (Aluno a){
    
        try{
          String sql;
          this.conectar();
          if(a.getId()==0){
              sql = "INSERT INTO aluno (matr,nome) VALUES (?,?)";
          }else{
              sql = "UPDATE aluno SET matr=?, nome=? WHERE id=?";
          }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, a.getMatr());
            pstm.setString(2, a.getNome());
            if(a.getId()>0){
                pstm.setInt(3,a.getId());
            }
            pstm.execute();
            this.desconectar();
            return true;            
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    
    }
    
    public Aluno getCarregaPorID(int id) throws Exception{
        Aluno a = new Aluno();
        String sql = "SELECT * FROM aluno WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            a.setId(id);
            a.setMatr(rs.getString("matr"));
            a.setNome(rs.getString("nome"));   
        }
        this.desconectar();
        return a;
    
    }
    
    public boolean deletar(Aluno a){
        
        try{
            this.conectar();
            String SQL = "DELETE FROM aluno WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, a.getId());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
}
