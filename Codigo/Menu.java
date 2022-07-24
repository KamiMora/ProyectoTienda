import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Menu
{
    private String menuPrincipal;
    private Bodega bodega; //creamos la bodega para que sea inicializada
    
    public Menu()
    {
        this.bodega = new Bodega(); //inicializa la bodega cuando arranca el menú
        this.menuPrincipal = "MENU PRINCIPAL \n"+
                             "1. Agregar producto \n"+
                             "2. Mostrar productos \n"+
                             "3. Buscar Productos \n"+
                             "0. Salir";
    }
    
    public void presentarMenuPrincipal() //método para crear el menu
    {         
        int opcion = 0; //la variable de arranque
        do //ciclo indefinido do/while para que entre al menu
        {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, this.menuPrincipal)); //preguntamos la opción(estructura se encuentra en el API)
                                                                                              /* null, es para no enviarle información 
                                                                                              sino para esperar a que el usuario escoja la opción*/
            switch (opcion) //determina que hace cada opción
            {    //instrucciones de cada opción
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    buscarProductos();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta luego, Veci!", "Salir", JOptionPane.INFORMATION_MESSAGE); //(estructura se encuentra en el API)
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
        for (Producto p: lista) //recorre lista usando el iterador p de tipo Producto
        {
            JOptionPane.showMessageDialog(null, p.toString(), "Productos en bodega", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void buscarProductos()
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
        } 
        else
        {
        JOptionPane.showMessageDialog(null, datosProductos, "Productos encontrados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}




















