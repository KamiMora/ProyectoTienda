import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

public class Presentacion
{
    private String [] menuPrincipal;
    private String menuProductos;
    private Bodega bodega;
    
    public Presentacion()
    {
        this.bodega = new Bodega();
        
        String [] opciones = { "Gestionar productos", "Realizar venta", "Salir" };
        this.menuPrincipal = opciones;
        
        this.menuProductos = "PRODUCTOS \n"+
                             "1. Ingresar producto \n" +
                             "2. Mostrar productos \n" +
                             "3. Buscar productos \n" +
                             "4. Surtir producto \n" +
                             "5. Eliminar producto \n" +
                             "0. Volver al menu principal";
    }
    
    
    public void presentarMenuPrincipal() 
    {
        int opcion = 0;
        do
        {
            Object o = JOptionPane.showInputDialog(null, "Seleccione una opción", "PROGRAMA DEL VECINO", JOptionPane.QUESTION_MESSAGE, null, this.menuPrincipal, this.menuPrincipal[0]);
            opcion = Arrays.asList(this.menuPrincipal).indexOf(o);
            switch (opcion) {
                case 0:
                    this.presentarMenuProductos();
                    break;
                case 1:
                    this.realizarVenta();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Muchas gracias", "Salir", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion != 2);
    }
    
        
    public void presentarMenuProductos() 
    {
        int opcion = 0;
        do
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, this.menuProductos));
            switch (opcion)
            {
                case 1:
                    ingresarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3: 
                    buscarProductos();
                    break;
                case 4:
                    surtirProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion != 0);
    }
    
    public void ingresarProducto()
    {
        int codigobarras = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese código de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        String [] tipos = {"Aseo", "Alimento"};
        int tipo = JOptionPane.showOptionDialog(null, "Ingrese tipo de producto", "Nuevo producto", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
        String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String marca = JOptionPane.showInputDialog(null, "Ingrese marca de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        String presentacion = JOptionPane.showInputDialog(null, "Ingrese presentación de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE);
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese precio de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de producto", "Nuevo producto", JOptionPane.QUESTION_MESSAGE));
        
        Producto p = new Producto(0, codigobarras, tipos[tipo], nombre, marca, presentacion, cantidad, precio);
        this.bodega.anadirProducto(p);
        JOptionPane.showMessageDialog(null, "Producto creado y añadido a la lista", "Producto creado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarProductos()
    {
        ArrayList<Producto> lista = this.bodega.getListaProductos();
        String datosProductos = "";
        for (Producto p: lista)
        {
            datosProductos = datosProductos + p.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, datosProductos, "Productos en la bodega", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean buscarProductos()
    {
        String buscar = JOptionPane.showInputDialog(null, "Ingrese texto para buscar producto (nombre, tipo, presentación, codigo)", "Buscar producto", JOptionPane.QUESTION_MESSAGE);
        ArrayList<Producto> lista = this.bodega.buscarProductos(buscar);
        String datosProductos = "";
        for (Producto p: lista)
        {
            datosProductos = datosProductos + p.toString() + "\n";
        }
        if (datosProductos.equals(""))
        {
            JOptionPane.showMessageDialog(null, "No se encontraron productos con ese criterio", "Productos No encontrados", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else 
        {
            JOptionPane.showMessageDialog(null, datosProductos, "Productos encontrados", JOptionPane.INFORMATION_MESSAGE);    
            return true;
        }
    }
    
    public void surtirProducto()
    {
        this.buscarProductos();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite código del producto para surtido", "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad del producto para surtido", "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese nuevo precio del producto para surtido", "Surtir producto", JOptionPane.QUESTION_MESSAGE));
        this.bodega.incrementarProducto(codigo, cantidad, precio);
        Producto p = this.bodega.getProducto(codigo);
        JOptionPane.showMessageDialog(null, p.mostrarInfo(), "Producto surtido", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void eliminarProducto()
    {
        this.buscarProductos();
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite código del producto para eliminar", "Eliminar producto", JOptionPane.QUESTION_MESSAGE));
        Producto p = this.bodega.getProducto(codigo);
        int confirmacion = JOptionPane.showConfirmDialog(null, "Está seguro de eliminar el producto "+p.getNombre()+" "+p.getMarca()+"?", "Eliminar producto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmacion == JOptionPane.YES_OPTION)
        {
            this.bodega.eliminarProducto(codigo);
            JOptionPane.showMessageDialog(null, p.mostrarInfo(), "Producto eliminado", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void realizarVenta()
    {
        Venta v = new Venta();
        boolean continuarVenta = false;
        do
        {
            boolean encontrado = this.buscarProductos();
            if (encontrado)
            {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite código del producto para venta", "Vender producto", JOptionPane.QUESTION_MESSAGE));
                Producto p = this.bodega.getProducto(codigo);
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad del producto para venta", "Vender producto", JOptionPane.QUESTION_MESSAGE));
                if (cantidad > p.getCantidad())
                {
                    JOptionPane.showMessageDialog(null, "No puedo vender esa cantidad", "Producto no añadido", JOptionPane.WARNING_MESSAGE);
                }
                else 
                {
                    v.agregarProductoAlCarrito(p, cantidad);
                    JOptionPane.showMessageDialog(null, p.mostrarInfo(), "Producto añadido al carrito", JOptionPane.INFORMATION_MESSAGE);    
                }
                int confirmacion = JOptionPane.showConfirmDialog(null, "Desea añadir más productos al carrito?", "Continuar venta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                continuarVenta = (confirmacion == JOptionPane.YES_OPTION) ? true : false;
            }
            else
            {
                continuarVenta = true;
            }
        }
        while(continuarVenta);
        int total = v.calcularTotalVenta();
        int confirmaVenta = JOptionPane.showConfirmDialog(null, "El total a pagar es $"+total+"\nDesea pagar?", "Finalizar venta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        if (confirmaVenta == JOptionPane.YES_OPTION)
        {
            v.finalizarVenta();
            JOptionPane.showMessageDialog(null, "Gracias por su compra", "Venta realizada", JOptionPane.INFORMATION_MESSAGE);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Ha anulado su compra", "Venta cancelada", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}



/**15/07/2022
 * Implementación del Carrito de compras
     * Es una lista vacía
     * acumula el producto y la cantidad a reducir de la bodega.
     * la cantidad se debe multiplicar por el precio
     * codicional dependiente del pago
 * 
 *  * Archivo plano
     * las lineas representan un registro/objeto
     * campo = cada casilla representa las características
     * la información se encuentra tabulada en filas y columnas y separada por "," o ";"
 * 
 * Sistemas de Base de Datos
 *  * BDD
     * esctructura conformada por tablas
     * cada campo está definido por columnas con una característica particular
 * 
 * Características de los parámetros de las transacciones en las bases de datos método ACID
     * A: Atomicity = capacidad de apropiarse del archivo = Si cuando una operación consiste en una serie de pasos, de los que o bien se ejecutan todos o ninguno, es decir, las transacciones son completas.
     * C: Consistency = capacidad de verificar la veracidad de la información. asegura que sólo se empieza procesos que se pueden acabar.
     * I: Isolation = propiedad que asegura que una operación no puede afectar a otras.
     * D: Durability = asegura que la información no se pierda aunque falle el sistema.
 * 
 * Elementos para trabajr con BDD
     * Motor de BDD = programa que permite la creación de la BDD
         * Procesos del motor a través de Structured Query Language = SQL = lenguage para acceder y manipular BDD
             * DDL = Data Definition Language => definiciones de datos
             * DML = Data Manipulation Language => manipulación de datos
             
     * Visor de BDD = permite visualizar claramente la información en la BDD(no se hace en Java)
     * Driver = proporciona la conexión entre el código y el motor. Se debe instalar
         * se necesita una clase con un elemento que genere la conexión con BDD
                                     un elemento que genere las sentencias
 * 
 * SQL = https://www.w3schools.com/sql/default.asp
 * 
     * Funciones/elementos del software               SQL
    
     * C reation                                    Insert
     * R etrieve                                    Select
     * U pdate                                      Update
     * D elete                                      Delete
     * 
     * Convención:
         * para nombrar las tablas se puede usar el nombre de la clase con una "T" al comienzo
         * para nombrar las columnas se puede usar el nombre de los atributos
         * para números, sin importar el tipo de dato, se usa NUMERIC de manera genérica
         * para texto, sin importar su tipo, se usa VARCHAR
         * Primary Key = caracteristica única como un código(id)
         * Not NULL = no puede faltar este dato
         * 
 */
 

















