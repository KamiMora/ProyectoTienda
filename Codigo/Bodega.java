import java.util.ArrayList;

public class Bodega 
{
    private ArrayList<Producto> listaProductos;

    public Bodega() 
    {
        ArchivoProductos a = new ArchivoProductos();
        this.listaProductos = a.cargarProductos(); //ya no necesitamos new ArrayList<Producto>
    }
    
    public ArrayList<Producto> getListaProductos() //creamos un array para que reciba listaProductos
    {
        return this.listaProductos;
    }

    public void agregarProducto(Producto p) 
    {
        this.listaProductos.add(p);
        ArchivoProductos a = new ArchivoProductos();
        a.guardarProducto(p.toCSV());
    }

    public Producto getProducto(int id) 
    {
        for (Producto p: this.listaProductos)
        {
            if (p.getId() == id)
            {
                return p;
            }
        }
        return null;
    }
    
    public void eliminarProducto(int id) 
    {
        Producto prodEliminar = this.getProducto(id);
        if (prodEliminar != null)
        {
            this.listaProductos.remove(prodEliminar);
        }
    }

    public void aumentarProducto(int id, int cant) 
    {
        Producto prodAument = this.getProducto(id);
        if (prodAument != null)
        {
            int index = this.listaProductos.indexOf(prodAument); //busca el indice del producto
            this.listaProductos.get(index).setCantidad(prodAument.getCantidad() + cant);
        }
        ArchivoProductos a = new ArchivoProductos();
        a.actualizarLista(this.listaProductos);
    }

    public void reducirProducto(int id, int cant) 
    {
        Producto prodDisminuir = this.getProducto(id);
        if (prodDisminuir != null)
        {
            int index = this.listaProductos.indexOf(prodDisminuir);
            if (prodDisminuir.getCantidad() >= cant)
            {
                this.listaProductos.get(index).setCantidad(prodDisminuir.getCantidad() - cant);
            }
        }
    }

    public void modificarPrecio(int id, int precio) 
    {
        Producto prodModif = this.getProducto(id);
        if (prodModif != null)
        {
            int index = this.listaProductos.indexOf(prodModif);
            this.listaProductos.get(index).setPrecio(precio);
        }
    }
    
    public ArrayList<Producto> buscarProductos(String criterio)
    {
        ArrayList<Producto> productosEncontrados = new ArrayList<Producto>();
        for (Producto p: this.listaProductos)
        {
            if ((p.getId()+"").equals(criterio) || p.getTipo().equals(criterio) || p.getNombre().equals(criterio) || p.getMarca().equals(criterio) || p.getPresentacion().equals(criterio))            
            {   //id es int y para convertirlo fácil a texto se concatena con un ""texto vacío
                productosEncontrados.add(p);
            }
        }
        return productosEncontrados;
    }
}

/** 
 * Bodega es la Clase contenedora
 * Acá van todos los procesos
*/

/** 07-12-2022: buen resúmen */

/** java api => encontramos las librerías y métodos */

/** Persistencia
 * 
 */
