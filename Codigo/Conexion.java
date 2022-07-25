import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion
{
    private String conectorInstalado = "jdbc:sqlite:"; //el driver a usar. revisar documentación del driver
    private String baseDatos = "..\\Basedatos\\ProyectoTienda.db"; //(".." = carpeta está un nivel fuera del proyecto)(\\ = buscar una carpeta)(Basedatos = nombre carpeta)(ProyectoTienda.db = nombre archivo)
    private Connection conexion;  //CONEXION CON LA BD
    private Statement ejecutorSQL;   //SENTENCIAS SQL
    private ResultSet rs; //ResultSet es un query que funciona como el ArrayList en SQL
    
    public boolean crearConexion()
    {
        try
        {
            conexion = DriverManager.getConnection(conectorInstalado + baseDatos); //crea una conexión
            ejecutorSQL = conexion.createStatement();
            ejecutorSQL.setQueryTimeout(30); //setQueryTimeout(30): espere 30 seg por una respuesta antes de generar error
            return true; // para que verifique que la conexión se creó
        }
        catch(Exception e)
        {
            return false; // cuando la conexión no se crea
        }
    }
    
    public boolean cerrarConexion()
    {
        try
        {
            conexion.close(); //cierra una conexión
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    
    public void insertar(String sql)
    {
        try
        {
            int cant = ejecutorSQL.executeUpdate(sql);
            if (cant > 0) 
            {
                rs = ejecutorSQL.getGeneratedKeys(); //pone en "rs" las llaves que encontró el query
            }
        }
        catch (Exception e)
        {
            
        }
    }
    
    public void actualizar(String sql)
    {
        try
        {
            int cant = ejecutorSQL.executeUpdate(sql);
        }
        catch (Exception e)
        {
            
        }
    }
    
    public void consultar(String sql)
    {
        try
        {
            rs = ejecutorSQL.executeQuery(sql);
        }
        catch (Exception e)
        {
            
        }
    }
    
    public void borrar(String sql)
    {
        try
        {
            int cant = ejecutorSQL.executeUpdate(sql);
        }
        catch (Exception e)
        {
            
        }
    }
}    