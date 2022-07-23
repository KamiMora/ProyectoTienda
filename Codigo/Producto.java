public class Producto 
{
    private int id;
    private String tipo;
    private String nombre;
    private String marca;
    private String presentacion;
    private int cantidad;
    private int precio;
    
    public void Producto() 
    {
        this.tipo = "";
        this.nombre = "";
        this.marca = "";
        this.presentacion = "";
        this.cantidad = 0;
        this.precio = 0;
        this.id = 0;
    }

    public Producto(int id, String tipo, String nombre, String marca, String presentacion, int cantidad, int precio) 
    {
        this.id = id; 
        this.tipo = tipo;
        this.nombre = nombre;
        this.marca = marca;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.precio = precio;      
    }

    public void setCantidad(int cantidad) 
    {
        this.cantidad = cantidad;
    }

    public int getCantidad() 
    {
       return this.cantidad;
    }

    public void setPrecio(int precio) 
    {
        this.precio = precio;
    }

    public int getPrecio() 
    {
        return this.precio;
    }

    public String getTipo() 
    {
        return this.tipo;
    }

    public String getNombre() 
    {
        return this.nombre;
    }

    public String getMarca() 
    {
        return this.marca;
    }

    public String getPresentacion() 
    {
        return this.presentacion;
    }

    public int getId() 
    {
        return this.id;
    }
    
    public String toString()
    {
        return "Id: "+this.id + ", Producto: "+this.nombre + ", Marca: "+this.marca + ", Presentaci�n: "+this.presentacion + ", Precio: "+this.precio + ", Cantidad: "+this.cantidad; 
    }

}