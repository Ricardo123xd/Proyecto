/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOMySQL;

import DAO.DAOException;
import DAO.ICompositorDAO;
import Modelo.Compositor;
import MySQLConexion.Conectar;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class MySQLCompositorDAO implements ICompositorDAO {
    
    
    //propiedades para manipular la base de datos
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    /**
     * metodo que cierra la conexion con la bd
     * @param preparedstatement 
     * @param resultset
     * @param connection
     * @throws DAOException 
     */
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
    private final String INSERT = "INSERT INTO compositores (nombrecompleto, edad) VALUES (?, ?)";

    private final String UPDATE = "UPDATE compositores SET nombrecompleto = ?, edad = ? WHERE idcompositor = ?";
    
    private final String DELETE = "DELETE FROM compositores WHERE idcompositor = ?";
    
    private final String GETALL = "SELECT idcompositor, nombrecompleto, edad FROM compositores";
    
    private final String GETONE = "SELECT idcompositor, nombrecompleto, edad FROM compositores WHERE idcompositor = ?";
    
    
    @Override
    public void insertar(Compositor compositor) throws DAOException {
        try{
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();

            //preparamos la consulta y especificamos los parametos de entrada
            ps = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, compositor.getNombre());
            ps.setInt(2, compositor.getEdad());

            //ejecutamos la consulta y verificamos el resultado
            if (ps.executeUpdate() == 0) {//if 1.0
                throw new DAOException("No se pudo guardar el nuevo compositor");
            } else {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {//if 1.1
                    compositor.setIdCompositor(rs.getInt(1));
                } else {
                    throw new DAOException("No se pudo asignar el id a este autor");
                }//fin if 1.1
            }//fin if 1.0
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage(), ex);
        } finally {
            cerrarConexiones(ps, rs, conn);
        
        }
    }

    @Override
    public void modificar(Compositor compositor) throws DAOException {
        try{
            //creamos la conexion a la base de datos
            conn = Conectar.realizarConexion();
            //preparamos la consulta y especificamos los parametros de entrada
            ps = conn.prepareStatement(UPDATE);
                ps.setString(1, compositor.getNombre());
                ps.setInt(2, compositor.getEdad());
                ps.setInt(3, compositor.getIdCompositor());
                
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
    public List<Compositor> obtenerTodos() throws DAOException {
        //lista de canciones a retornar
        List<Compositor> misCompositores = new ArrayList<Compositor>();
        try{
            //crear conexion con la bd
            conn = Conectar.realizarConexion();
            //preparamos la consulta
            ps = conn.prepareStatement(GETALL);
            
            //ejecutamos la consulta y almacenamos el resultado en un objeto ResultSet
            rs = ps.executeQuery();
            
            //recorremos el ResultSet y agregamos cada item el arraylist
            while(rs.next()){
                Compositor miCompositor = new Compositor();
                miCompositor.setIdCompositor(rs.getInt("idcompositor"));
                miCompositor.setNombre(rs.getString("nombrecompleto"));
                miCompositor.setEdad(rs.getInt("edad"));
                misCompositores.add(miCompositor);
            }//fin del while
        }catch(SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }finally{
            cerrarConexiones(ps,rs,conn);
        }//fin del finally
        return misCompositores;
    }

    @Override
    public Compositor obtener(Integer id) throws DAOException {
        //lista de canciones a retornar
        Compositor miCompositor = null;
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
                miCompositor = new Compositor();
                miCompositor.setIdCompositor(rs.getInt("idcompositor"));
                miCompositor.setNombre(rs.getString("nombrecompleto"));
                miCompositor.setEdad(rs.getInt("edad"));
            }else{
                throw new DAOException ("No se encontró el elemento");
            }
        }catch (SQLException ex){
            throw new DAOException(ex.getMessage(), ex);
        }finally{
            cerrarConexiones(ps,rs,conn);
        }
        return miCompositor;
    }
    
}
