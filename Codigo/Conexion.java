import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion
{
    private String conectorInstalado = "jdbc:sqlite:"; //el driver a usar. revisar documentaci�n del driver
    private String baseDatos = "..\\Basedatos\\ProyectoTienda.db"; //(".." = carpeta est� un nivel fuera del proyecto)(\\ = buscar una carpeta)(Basedatos = nombre carpeta)(ProyectoTienda.db = nombre archivo)
    private Connection conexion;  //CONEXION CON LA BD
    private Statement ejecutorSQL;   //SENTENCIAS SQL
    private ResultSet rs; //ResultSet es un query que funciona como el ArrayList en SQL
    
    public boolean crearConexion()
    {
        try
        {
            conexion = DriverManager.getConnection(conectorInstalado + baseDatos); //crea una conexi�n
            ejecutorSQL = conexion.createStatement();
            ejecutorSQL.setQueryTimeout(30); //setQueryTimeout(30): espere 30 seg por una respuesta antes de generar error
            return true; // para que verifique que la conexi�n se cre�
        }
        catch(Exception e)
        {
            return false; // cuando la conexi�n no se crea
        }
    }
    
    public boolean cerrarConexion()
    {
        try
        {
            conexion.close(); //cierra una conexi�n
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
                rs = ejecutorSQL.getGeneratedKeys(); //pone en "rs" las llaves que encontr� el query
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