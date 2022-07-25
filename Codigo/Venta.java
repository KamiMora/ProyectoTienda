import java.util.List;
import java.util.ArrayList;


public class Venta
{
    private List<Producto> carritoCompras;
    
    public Venta()
    {
        carritoCompras = new ArrayList<Producto>(); //carrito de compras es = a una lista de arreglos de productos
    }
    
    public void agregarProductoAlCarrito(Producto p, int cant)
    {
        p.setCantidad(cant); //la cantidad de productos a agregar al carrito
        this.carritoCompras.add(p); //agregar producto al carrito
    }
    
    public int calcularTotalVenta()
    {
        int valorTotal = 0; //acumulador
        for (Producto p: this.carritoCompras) // para cada producto agregado al carrito...
        {
            valorTotal = valorTotal + (p.getCantidad() * p.getPrecio()); // multiplicar la cantidad por el precio y acumular
        }
        return valorTotal; //devuelve el acumulado de cantidad y precio
    }
    
    public void finalizarVenta()
    {
        Bodega b = new Bodega(); //ejecuta método Bodega en Bodega = abre archivoProductos con los productos en el carrito y los pone en listaProductos
        for (Producto p: this.carritoCompras)
        {
            System.out.println("En venta " + p.mostrarInfo());
            b.reducirProducto(p.getId(), p.getCantidad()); //traemos id y cantidad de productos en carrito y los aparta de la bodega
        }
        b.actualizarListaEnArchivo(); //al finalizar la venta se ejecuta actualizarListaEnArchivo que actualiza listaProductos
    }
}


