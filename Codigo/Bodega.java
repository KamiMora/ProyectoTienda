import java.util.ArrayList;

public class Bodega 
{
    private ArrayList<Producto> listaProductos;

    public Bodega() 
    {
        this.listaProductos = new ArrayList<Producto>();
    }
    
    public ArrayList<Producto> getListaProductos() //creamos un array para que reciba listaProductos
    {
        return this.listaProductos;
    }

    public void agregarProducto(Producto p) 
    {
        this.listaProductos.add(p);
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
            int index = this.listaProductos.indexOf(prodAument);
            this.listaProductos.get(index).setCantidad(prodAument.getCantidad() + cant);
        }
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

}

/** 
 * Bodega es la Clase contenedora
 * Ac� van todos los procesos
*/

/** 07-12-2022: buen res�men */

/** java api => encontramos las librer�as y m�todos */



