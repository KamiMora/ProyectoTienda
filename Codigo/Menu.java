import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu
{
    private String[] menuPrincipal;
    private String menuProductos;
    private Bodega bodega; //creamos la bodega para que sea inicializada
    
    public Menu()
    {
        this.bodega = new Bodega(); //inicializa la bodega cuando arranca el menú
        /* implementamos un sistema con sub-menús
        this.menuPrincipal = "MENU PRINCIPAL \n"+
                             "1. Agregar producto \n"+
                             "2. Mostrar productos \n"+
                             "3. Buscar Productos \n"+
                             "0. Salir";
        */
        
        String[] opciones = {"Gestionar productos", "Realizar venta", "Salir"};
        this.menuPrincipal = opciones;
        
        this.menuProductos = "PRODUCTOS \n"+
                             "1. Agregar producto \n"+
                             "2. Mostrar productos \n"+
                             "3. Buscar Productos \n"+
                             "4. Surtir producto \n"+
                             "0. Volver al menú pricipal";
                             
        
    }
    
    public void presentarMenuPrincipal()
    {
        int opcion = 0; //la variable de arranque
        do //ciclo indefinido do/while para que entre al menu
        {
            Object o = (JOptionPane.showInputDialog(null, "Seleccione una opción", "TIENDA EL VECINO", JOptionPane.QUESTION_MESSAGE, null, this.menuPrincipal, this.menuPrincipal[0]));
            opcion = Arrays.asList(this.menuPrincipal).indexOf(o); //convertir un arreglo en una lista para buscar "opcion" usando indexOf()
            //opcion = Integer.parseInt(JOptionPane.showInputDialog(null, this.menuPrincipal)); //preguntamos la opción(estructura se encuentra en el API)
            switch (opcion) //determina que hace cada opción
            {    //instrucciones de cada opción
                case 0:
                    this.presentarMenuProductos();
                    break;
                case 1:
                    this.realizarVenta();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Hasta luego, Veci!", "Salir", JOptionPane.INFORMATION_MESSAGE); //(estructura se encuentra en el API)
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Esa opción no existe, mi Don!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion!=2);
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
                    agregarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    buscarProductos();
                    break;
                case 4:
                    aumentarProducto();
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Esa opción no existe, mi Don!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        while(opcion!=0); //termina el ciclo
    }
    
    public void agregarProducto()
    {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese código del producto", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE)); //(JOption: estructura se encuentra en el API)
        String[] tipos = {"Aseo", "Alimento"}; //arreglo para escoger el tipo de producto con "showOptionDialog"
        int tipo = JOptionPane.showOptionDialog(null, "Ingrese tipo del producto", "Nuevo producto", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);
        //String tipo = (JOptionPane.showInputDialog(null, "Ingrese tipo del producto", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE)); lo cambiamos por el JOptionPane
        String nombre = (JOptionPane.showInputDialog(null, "Ingrese nombre del producto", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE));
        String marca = (JOptionPane.showInputDialog(null, "Ingrese marca del producto", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE));
        String presentacion = (JOptionPane.showInputDialog(null, "Ingrese presentación del producto", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE));
        int precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese precio del producto", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad del producto", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE));
        
        Producto p = new Producto(id, tipos[tipo], nombre, marca, presentacion, cantidad, precio);
        this.bodega.agregarProducto(p);
        JOptionPane.showMessageDialog(null, "Producto creado y agregado a la bodega", "Producto creado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarProductos()
    {
        ArrayList<Producto> lista = this.bodega.getListaProductos(); //creamos un array llamdo lista para que traiga los productos en bodega
        String datosProductos = "";
        for (Producto p: lista) //recorre lista usando el iterador p de tipo Producto
        {
            datosProductos = datosProductos + p.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, datosProductos, "Productos en bodega", JOptionPane.INFORMATION_MESSAGE);        
    }
    
    public boolean buscarProductos()
    {
        String buscar = (JOptionPane.showInputDialog(null, "Ingrese código o nombre o tipo o presentación del producto a buscar", "Buscar producto", JOptionPane.INFORMATION_MESSAGE));
        ArrayList<Producto> lista = this.bodega.buscarProductos(buscar); //el ArrayList lista contiene los productos encontrados en bodega
        String datosProductos = ""; //variable vacía para que muestre los datos en lista
        for (Producto p: lista) //recorre lista usando el iterador p de tipo Producto
        {
            datosProductos = datosProductos + p.toString() + "\n";
        }
        
        if (datosProductos.equals(""))
        {
            JOptionPane.showMessageDialog(null, "No se encontraron productos", "Productos no encontrados", JOptionPane.WARNING_MESSAGE);
            return false;
        } 
        else
        {
            JOptionPane.showMessageDialog(null, datosProductos, "Productos encontrados", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
    
    public void aumentarProducto()
    {
        this.buscarProductos(); //encontrar id producto para poder aumentar su cantidad
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del producto", "Surtir producto", JOptionPane.INFORMATION_MESSAGE));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad a aumentar", "Surtir producto", JOptionPane.INFORMATION_MESSAGE));
        this.bodega.aumentarProducto(codigo, cantidad); //llamamos método para aumentar cantidad
        Producto p = this.bodega.getProducto(codigo);    
        JOptionPane.showMessageDialog(null, p.mostrarInfo(), "Producto surtido", JOptionPane.INFORMATION_MESSAGE); //muestra la info del producto surtido
    }
    
    public void realizarVenta()
    {
        Venta v = new Venta(); //variable Venta para guardar producto p y cantidad
        boolean continuarVenta = false;
        do
        {
            boolean encontrado = this.buscarProductos(); //buscar si hay producto disponible en bodega y devolver id producto para poder aumentar su cantidad
            if (encontrado)
            {
                int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código del producto a comprar", "Compra", JOptionPane.INFORMATION_MESSAGE));
                Producto p = this.bodega.getProducto(codigo);
                //System.out.println("En bodega " + p.mostrarInfo());
                int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad a comprar", "Compra", JOptionPane.INFORMATION_MESSAGE));
                v.agregarProductoAlCarrito(p, cantidad);
                JOptionPane.showMessageDialog(null, p.mostrarInfo(), "Producto agregado al carrito", JOptionPane.INFORMATION_MESSAGE);
                int confirmacion = JOptionPane.showConfirmDialog(null, "Desea gregar más productos?", "Finalizar compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                continuarVenta = (confirmacion == JOptionPane.YES_OPTION) ? true : false; //operador ternario para continuar venta dependiendo de la confirmación
            }
            else
            {
                continuarVenta = true;
            }
        }
        while(continuarVenta);
        int total = v.calcularTotalVenta();
        int confirmarVenta = JOptionPane.showConfirmDialog(null, "El total a pagar es: "+total+"\nDesea confirmar la compra?", "Finalizar compra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirmarVenta == JOptionPane.YES_OPTION)
        {
            v.finalizarVenta();
            JOptionPane.showMessageDialog(null, "Gracias por su compra!", "Finalizar compra", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Compra cancelada!", "Finalizar compra", JOptionPane.WARNING_MESSAGE);
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
     * Funciones/elementos del software               SQL sentences
    
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
 * 
 * 
 * 
 * 
 */

















