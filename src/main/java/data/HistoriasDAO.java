package data;

import static data.Conexion.close;
import static data.Conexion.getConexion;
import entity.Historias;
import java.sql.*;
import java.util.*;

/**
 *
 * @author lean
 */
public class HistoriasDAO {

    private static final String SQL_CREATE = "insert into historias(titulo,texto) values(?,?)";
    private static final String SQL_READ = "select * from historias";
    private static final String SQL_UPDATE = "update historias set titulo=?,texto=? where id=?";
    private static final String SQL_DELETE = "delete from historias where id=?";
    private static final String SQL_FIND_BY_ID = "select * from historias where id=?";

    public List<Historias> listar() {
        List<Historias> historias = new ArrayList();
        Historias historia= null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_READ);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String titulo = rs.getString(2);
                String texto = rs.getString(3);

                historia = new Historias(id, titulo, texto);
                historias.add(historia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return historias;
    }
    
    public Historias buscarPorId(int id){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs = null;
        Historias historia=null;
        try{
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_FIND_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while(rs.next()){
                //ya que está uso la misma variable :3
                id = rs.getInt(1);
                String titulo = rs.getString(2);
                String texto = rs.getString(3);
                
                historia = new Historias(id,titulo,texto);
                
            }
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            try{
                close(rs);
                close(stmt);
                close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return historia;
    }
    
        public void actualizar(Historias historia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1,historia.getTitulo());
            stmt.setString(2,historia.getTexto());
            stmt.setInt(3, historia.getId());

            stmt.executeUpdate();
            
           } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
    }

    public void eliminar(Historias historia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,historia.getId());
            stmt.executeUpdate();
            
           } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
    
    public void agregar(Historias historia){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConexion();
            stmt = conn.prepareStatement(SQL_CREATE);
            stmt.setString(1,historia.getTitulo());
            stmt.setString(2,historia.getTexto());
            stmt.executeUpdate();            
           } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

}
