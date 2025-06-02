/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOMySQL;

import DAO.DAOException;
import DAO.ICancionCompositorDAO;
import Modelo.CancionCompositor;
import Modelo.Canciones;
import Modelo.Compositor;
import MySQLConexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class MySQLCancionCompositorDAO implements ICancionCompositorDAO {
    
    //Propiedades para el acceso a datos
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;

    //consultas sql
    private final String INSERT = "INSERT INTO cancioncompositor (idcancion, idcompositor) VALUES (?, ?)";
    private final String DELETE = "DELETE FROM cancioncompositor WHERE idcompositor = ? AND idcancion = ?";
    private final String GETALLSONGSBYCOMPOSER = "SELECT canciones.idcancion, nombre, fechaCreacion, duracion "
            + " FROM canciones INNER JOIN cancioncompositor ON canciones.idcancion = cancioncompositor.idcancion "
            + " INNER JOIN compositores ON cancioncompositor.idCompositor = compositores.idCompositor"
            + " WHERE compositores.idCompositor = ?";
    
    
    //cerrar conexion con la bd
    private void cerrarConexiones(PreparedStatement ps, ResultSet rs, Connection conn) throws DAOException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    

    @Override
    public List<Compositor> obtenerCompositoresPorCancion(int idCancion) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Canciones> obtenerCancionesPorCompositor(int idCompositor) throws DAOException {
        List<Canciones> misCanciones = null;
        try{
            misCanciones = new ArrayList<Canciones>();
            
            conn = Conectar.realizarConexion();
            
            ps = conn.prepareStatement(GETALLSONGSBYCOMPOSER);
            ps.setInt(1, idCompositor);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Canciones miCancion = new Canciones();
                miCancion.setIdCancion(rs.getInt("canciones.idcancion"));
                miCancion.setNombre(rs.getString("nombre"));
                miCancion.setFechaCreacion(rs.getString("fechacreacion"));
                miCancion.setDuracion(rs.getInt("duracion"));
                misCanciones.add(miCancion);
            }
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }finally{
            cerrarConexiones(ps,rs,conn);
        }
        return misCanciones;
    }    
        

    @Override
    public void eliminar(CancionCompositor a) throws DAOException {
        try{
            conn = Conectar.realizarConexion();
            
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, a.getIdCancion());
            ps.setInt(2, a.getIdCompositor());
            
            if(ps.executeUpdate() == 0){
                throw new DAOException("Hubro un problema y no se pudo eliminar el registro");
            }
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }finally{
            cerrarConexiones(ps,rs,conn);
        }
    }

    @Override
    public void insertar(CancionCompositor a) throws DAOException {
        try {

            //creamos la conexion con la base de datos
            conn = Conectar.realizarConexion();

            //preparamos la consulta
            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, a.getIdCancion());
            ps.setInt(2, a.getIdCompositor());

            if (ps.executeUpdate() == 0) {
                throw new DAOException("No se pudo guardar la relacion entre compositor y cancion");
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        }
    }

    @Override
    public void modificar(CancionCompositor a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(Integer a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CancionCompositor> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CancionCompositor obtener(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
