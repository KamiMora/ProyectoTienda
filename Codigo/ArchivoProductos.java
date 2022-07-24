import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.nio.charset.Charset;

public class ArchivoProductos
{
    private File archivo;
    
    public ArchivoProductos()
    {
        this.archivo = new File("productos.csv");
    }
    
    public void guardarProducto(String texto) //guardamos un producto al final del archivo .CSV
    {
        /*try
        {
            FileWriter writer = new FileWriter(this.archivo, true); // true, para añadir el contenido al final del .CSV
            PrintWriter cursor = new PrintWriter(writer);
            cursor.println(texto);
            cursor.flush();
            cursor.close();
            writer.close();
        }
        catch(Exception e)
        {
            
        }*/
        
        this.guardar(texto, true); //true, para añadir un producto al final del .CSV
    }
    
    public void actualizarLista(ArrayList<Producto> lista) //para guardar toda la lista actualizada en el .CSV
    {
        String texto = "";
        for (int i = 0; i<lista.size(); i++)//(Producto p: lista) lo cambiamos para evitar que agregue un espacio innecesario en .CSV
        {
            if (i!=0)
            {
                texto = texto + "\n";
            }
            texto = texto + lista.get(i).toCSV();
        }
        this.guardar(texto, false); //false, para reemplazar todo el contenido en .CSV por el nuevo al ejecutar guardarLista()
    }
    
    private void guardar(String texto, boolean agregar) //boolean entre guardarProducto() y actualizarLista(...)
    {
        try
        {
            FileWriter writer = new FileWriter(this.archivo, Charset.forName("UTF-8") , agregar); //charset para usar un set de caracteres especial
            PrintWriter cursor = new PrintWriter(writer);
            cursor.println(texto);
            cursor.flush();
            cursor.close();
            writer.close();
        }
        catch(Exception e)
        {
            
        }
    }
    
    public ArrayList<Producto> cargarProductos()
    {
        ArrayList<Producto> listaCargada = new ArrayList<Producto>(); //lista vacía para que reciba la información de listaCargada
        try
        {
            FileReader reader = new FileReader(this.archivo); 
            BufferedReader cursor = new BufferedReader(reader);
            while(cursor.ready())
            {
                String linea = cursor.readLine();
                String [] datoProducto = linea.split(";");
                int id = Integer.parseInt(datoProducto[0]);
                String tipo = datoProducto[1];
                String nombre = datoProducto[2];
                String marca = datoProducto[3];
                String presentacion = datoProducto[4];
                int precio = Integer.parseInt(datoProducto[5]);
                int cantidad = Integer.parseInt(datoProducto[6]);
                
                Producto p = new Producto(id, tipo, nombre, marca, presentacion, cantidad, precio);
                listaCargada.add(p);
            }
        }
        catch(Exception e)
        {
            
        }
        return listaCargada;
    }
}    

/** ALMACENAR INFORMACIÓN
 * Ideal que esto se maneje a través de una clase aparte.
 * Se debe generar un archivo a través de un objeto de tipo File.
 * se determina su capacidad de lectura, escritura: 
 * FileWriter: PrintWriter = cursor de escritura.
 * FileReader: BufferReader = cursor de lectura.
 * cada función tiene su propio cursor para trabajr la información.
 * 
 */

/** TryCatch: monitor de error/control de excepciones.
 * es una estructura en la cual se monitorea si hay un fallo/error/exepción al momento de ejecutar un archivo.
 */