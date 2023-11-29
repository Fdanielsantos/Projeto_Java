
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class EsporteDAO  extends DataBaseDAO{
    
       public EsporteDAO()throws Exception{}
    
    public ArrayList<Esporte> getLista() throws Exception{
        
        ArrayList<Esporte> lista = new ArrayList<Esporte>();
        String SQL = "SELECT * FROM esporte";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(SQL);
        while(rs.next()){
            Esporte e = new Esporte();
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            e.setDescricao(rs.getString("descricao"));
            e.setDuracao(rs.getString("duracao"));
            lista.add(e);
        }
        this.desconectar();
        return lista;    
    }
    
    public boolean gravar (Esporte e){
    
        try{
          String sql;
          this.conectar();
          if(e.getId()==0){
              sql = "INSERT INTO esporte (nome,descricao,duracao) VALUES (?,?,?)";
          }else{
              sql = "UPDATE esporte SET nome=?, descricao=?,duracao=? WHERE id=?";
          }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, e.getNome());
            pstm.setString(2, e.getDescricao());            
            pstm.setString(3, e.getDuracao());
            if(e.getId()>0){
                pstm.setInt(4,e.getId());
            }
            pstm.execute();
            this.desconectar();
            return true;            
            
        }catch(Exception ee){
            System.out.println(ee);
            return false;
        }
    }
    
    public Esporte getCarregaPorID(int id) throws Exception{
        Esporte e = new Esporte();
        String sql = "SELECT * FROM esporte WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            e.setId(id);
            e.setNome(rs.getString("nome"));
            e.setDescricao(rs.getString("descricao"));
            e.setDuracao(rs.getString("duracao"));
        }
        this.desconectar();
        return e;
    
    }
    

   
     public boolean deletar(Esporte e){
        
        try{
            this.conectar();
            String SQL = "DELETE FROM esporte WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, e.getId());
            pstm.execute();
            this.desconectar();
            return true;
        }catch(Exception ee){
            System.out.println(ee);
            return false;
        }
    
    }
    
}
