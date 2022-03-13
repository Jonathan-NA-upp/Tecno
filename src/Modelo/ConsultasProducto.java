
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasProducto extends Conexion{
    
    public boolean registrar(Producto pro)
    {
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO producto (producto, descripcion, cantidad , precioContado, precioMensualidad) VALUES (?,?,?,?,?)";
        
        try{
            
            ps= con.prepareStatement (sql);
            ps.setString(1, pro.getProducto());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getCantidad());
            ps.setInt(4, pro.getPrecioContado());
            ps.setInt(5, pro.getPrecioMensualidad());
            ps.execute();
            
            return true;
            
        }catch (SQLException e)
        {
            System.err.print(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
               System.err.print(e);
            }
        }
    }
    
    public boolean modificar(Producto pro)
    {
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "UPDATE producto SET producto=?, descripcion=?, cantidad=?, precioContado=?, precioMensualidad=? WHERE idProducto=? ";
        
        try{
            ps= con.prepareStatement (sql);
            ps.setString(1, pro.getProducto());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getCantidad());
            ps.setInt(4, pro.getPrecioContado());
            ps.setInt(5, pro.getPrecioMensualidad());
            ps.setInt(6, pro.getIdtbProducto());
            ps.execute();
            
            return true;
            
        }catch (SQLException e)
        {
            System.err.print(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
               System.err.print(e);
            }
        }
    }
    
    public boolean eliminar(Producto pro)
    {
        PreparedStatement ps =null;
        Connection con = getConexion();
        
        String sql = "DELETE from producto WHERE idProducto=? ";
        
        try{
            
            ps= con.prepareStatement (sql);
            ps.setInt(1, pro.getIdtbProducto());
            ps.execute();
            return true;
            
        }catch (SQLException e)
        {
            System.err.print(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
               System.err.print(e);
            }
        }
    }
    
     public boolean buscar(Producto pro)
    {
        PreparedStatement ps =null;
        ResultSet rs= null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM producto WHERE producto=? ";
        
        try{
            
            ps= con.prepareStatement (sql);
            ps.setString(1, pro.getProducto());
            rs= ps.executeQuery();
            
            if(rs.next())
            {
                pro.setIdtbProducto(Integer.parseInt(rs.getString("idProducto")));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                pro.setPrecioContado(Integer.parseInt(rs.getString("precioContado")));
                pro.setPrecioMensualidad(Integer.parseInt(rs.getString("precioMensualidad")));
                pro.setProducto(rs.getString("producto"));
                
                return true;
            }
            return false;
            
        }catch (SQLException e)
        {
            System.err.print(e);
            return false;
        } finally{
            try{
                con.close();
            } catch(SQLException e){
               System.err.print(e);
            }
        }
    }
 }
