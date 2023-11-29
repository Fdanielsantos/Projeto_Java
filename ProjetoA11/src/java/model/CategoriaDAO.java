
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CategoriaDAO extends DataBaseDAO {
    
        public CategoriaDAO() throws Exception{}
    
    public ArrayList<Categoria> getLista() throws Exception{
        
        ArrayList<Categoria> lista = new ArrayList<Categoria>();
        String SQL = "SELECT * FROM categoria";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(SQL);
        while(rs.next()){
            Categoria c = new Categoria();
            c.setId(rs.getInt("id"));
            c.setDuracao(rs.getString("duracao"));
            c.setNome(rs.getString("nome"));
            lista.add(c);
        }
        this.desconectar();
        return lista;
    
    }
    
    public boolean gravar (Categoria c){
    
        try{
          String sql;
          this.conectar();
          if(c.getId()==0){
              sql = "INSERT INTO categoria (duracao,nome) VALUES (?,?)";
          }else{
              sql = "UPDATE categoria SET duracao=?, nome=? WHERE id=?";
          }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, c.getDuracao());
            pstm.setString(2, c.getNome());
            if(c.getId()>0){
                pstm.setInt(3,c.getId());
            }
            pstm.execute();
            this.desconectar();
            return true;            
            
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    
    }
    
    public Categoria getCarregaPorID(int id) throws Exception{
        Categoria c = new Categoria();
        String sql = "SELECT * FROM categoria WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            c.setId(id);
            c.setDuracao(rs.getString("categoria"));
            c.setNome(rs.getString("nome"));   
        }
        this.desconectar();
        return c;
    
    }
    
    public boolean deletar(Categoria c){
        
        try{
            this.conectar();
            String SQL = "DELETE FROM categoria WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, c.getId());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    
    }
}
