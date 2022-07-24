public class Producto 
{
    private int id;
    private String tipo;
    private String nombre;
    private String marca;
    private String presentacion;
    private int precio;
    private int cantidad;
    
    public void Producto() 
    {
        this.id = 0;
        this.tipo = "";
        this.nombre = "";
        this.marca = "";
        this.presentacion = "";
        this.precio = 0;
        this.cantidad = 0;
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

    public int getId() 
    {
        return this.id;
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

    public String toString()
    {
        return "Cod:" +this.id+ "\nProducto: "+this.nombre +" "+ this.marca + "\nPresentación; " +this.presentacion + "\nPrecio: "+this.precio + "\nStock: "+this.cantidad;
    }
    
    public String mostrarInfo()
    {
        return "Cod:" +this.id+ "\nProducto: "+this.nombre + this.marca + " - " +this.presentacion+"\nPrecio: "+this.precio+"\nStock: "+this.cantidad;
    }
    
    public String toCSV()
    {
        return this.id+ ";" +this.tipo+";"+this.nombre +";"+ this.marca + ";" +this.presentacion+";"+this.precio+";"+this.cantidad;
    }
}


/** ALMACENAR INFORMACIÓN
 * Ideal que esto se maneje a través de una clase aparte.
 * Se debe generar un archivo a través de un objeto de tipo File.
 * se determina su capacidad de lectura, escritura: 
 * FileReader: BufferReader = cursor de lectura.
 * FileWriter: PrintWriter = cursor de escritura.
 * cada función tiene su propio cursor para trabajr la información.
 * 
 */



/*
public String toString() //muestra información de manera rápida
    {
        return "Código: "+this.id+ 
                "\nTipo: "+this.tipo+ 
                "\nProducto: "+this.nombre+" "+this.marca+ 
                " - "+this.presentacion+ 
                "\nPrecio: "+this.precio+ 
                "\nCantidad disponible: "+this.cantidad;
    }
    
    public String mostrarInfo() //muestra información detallada
    {
         return "Código: "+this.id+ 
                "\nTipo: "+this.tipo+ 
                "\nProducto: "+this.nombre+" "+this.marca+ 
                " - "+this.presentacion+ 
                "\nPrecio: "+this.precio+ 
                "\nCantidad disponible: "+this.cantidad;
    }
    
    public String toCSV() //muestra información de manera rápida
    {
        return this.id + ";" + this.tipo + ";" + this.nombre + ";" + this.marca + ";" + this.presentacion + ";" + this.precio + ";" + this.cantidad;
    }

}
 */






