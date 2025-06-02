/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOMySQL;

import DAO.DAOException;
import DAO.ICancionDAO;
import Modelo.Canciones;
import MySQLConexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Ricardo
 */
public class MySQLCancionDAO implements ICancionDAO{
    
    //propiedades para manipular la base de datos
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    private void cerrarConexiones(PreparedStatement ps, ResultSet rs, Connection conn) throws DAOException {
        try{
            if (rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        }
    }
    //consultas sql
    private final String INSERT = "INSERT INTO canciones (nombre, fechaCreacion, duracion) VALUES (?, ?, ?)";

    private final String UPDATE = "UPDATE canciones SET nombre = ?, fechaCreacion = ?, duracion = ? WHERE idCancion = ?";
    
    private final String DELETE = "DELETE FROM canciones WHERE idCancion = ?";
    
    private final String GETALL = "SELECT idCancion, nombre, fechaCreacion, duracion FROM canciones";
    
    private final String GETONE = "SELECT idCancion, nombre, fechaCreacion, duracion FROM canciones WHERE idCancion = ?";
    

    @Override
    public void insertar(Canciones cancion) throws DAOException {
        try{
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();

            //preparamos la consulta y especificamos los parametos de entrada
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, cancion.getNombre());
            ps.setString(2, cancion.getFechaCreacion());
            ps.setInt(3, cancion.getDuracion());

            //ejecutamos la consulta y verificamos el resultado
            if (ps.executeUpdate() == 0) {//if 1.0
                throw new DAOException("No se pudo guardar la nueva cancion");
            } else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {//if 1.1
                    cancion.setIdCancion(rs.getInt(1));
                } else {
                    throw new DAOException("No se pudo asignar el id a esta cancion");
                }//fin if 1.1
            }//fin if 1.0
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        
        }
    }

    @Override
    public void modificar(Canciones cancion) throws DAOException {
        try{
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(UPDATE);
                ps.setString(1, cancion.getNombre());
                ps.setString(2, cancion.getFechaCreacion());
                ps.setInt(3, cancion.getDuracion());
                ps.setInt(4, cancion.getIdCancion());
                
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0){
                throw new DAOException("Hubo un problema y no se guardaron los cambios");
            }
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }finally{
            cerrarConexiones(ps,rs,conn);
        }//fin del finally
    }

    @Override
    public void eliminar(Integer id) throws DAOException {
        try{
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            //preparamos la consulta y especificamos los arametros de entrada
            ps = conn.prepareStatement(DELETE);
                ps.setInt(1, id);
                
            //ejecutamos la consulta y verificamos el resultado
            if(ps.executeUpdate() == 0){
                throw new DAOException("Hubo un problema y no se puedo eliminar el registro");
            }
        }catch (SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }finally{
            cerrarConexiones(ps,rs,conn);
        }//fin del finally
    }

    @Override
    public List<Canciones> obtenerTodos() throws DAOException {
        //lista de canciones a retornar
        List<Canciones> misCanciones = new ArrayList<Canciones>();
        try{
            //crear conexion con la bd
            conn = Conectar.realizarConexion();
            //preparamos la consulta
            ps = conn.prepareStatement(GETALL);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item el arraylist
            while(rs.next()){
                Canciones miCancion = new Canciones();
                miCancion.setIdCancion(rs.getInt("idCancion"));
                miCancion.setNombre(rs.getString("nombre"));
                miCancion.setFechaCreacion(rs.getString("fechaCreacion"));
                miCancion.setDuracion(rs.getInt("duracion"));
                misCanciones.add(miCancion);
            }//fin del while
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }finally{
            cerrarConexiones(ps,rs,conn);
        }//fin del finally
        return misCanciones;
    }

    @Override
    public JasperPrint generarReporte() throws JRException{
        JasperPrint jprint = null;
        
        try {
                    
            conn = Conectar.realizarConexion();
            
            JasperReport reporte = null;
            String file = System.getProperty("user.dir");

            //String archivo = "src\\reportes\\notadeventa3.jasper";
            String path = file + "\\src\\reportes\\report1.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            jprint = JasperFillManager.fillReport(reporte, null,conn);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCancionDAO.class.getName()).log(Level.SEVERE, null, ex);        
        }
        
        return jprint;
    }
    
    @Override
    public Canciones obtener(Integer id) throws DAOException {
        //lista de canciones a retornar
        Canciones misCanciones = null;
        try{
            //conexion a la bd
            conn = Conectar.realizarConexion();
            //preparamos la consulta y definimos sus parametros que recibe la consulta
            ps = conn.prepareStatement(GETONE);
            ps.setInt(1, id);
            
            //ejecutamos la consulta y guardamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
                
            /**
             * verificamos si el resultset obtuvo el resultado y lo asignamos al objeto correspondiente
             */
            if(rs.next()){
                misCanciones = new Canciones();
                misCanciones.setIdCancion(rs.getInt("idCancion"));
                misCanciones.setNombre(rs.getString("nombre"));
                misCanciones.setFechaCreacion(rs.getString("fechaCreacion"));
                misCanciones.setDuracion(rs.getInt("duracion"));
            }else{
                throw new DAOException ("No se encontró el elemento");
            }
        }catch (SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }finally{
            cerrarConexiones(ps,rs,conn);
        }
        return misCanciones;
    }
    
}
