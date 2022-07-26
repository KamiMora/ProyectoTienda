import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Pantalla extends JFrame
{
    JLabel labelCodigo, labelNombre, labelMarca, labelPresent, labelTipo, labelCant, labelPrecio; //definimos los labels
    JTextField txtCodigo, txtNombre, txtMarca, txtPresent, txtCant, txtPrecio; //creamos el campo de texto para cada atributo
    JComboBox comboTipo; //usamos un formato diferente para escoger el tipo
    JButton btnAgregar, btnActualizar, btnLimpiar, btnEliminar;
    
    public Pantalla()
    {
        setBounds(100, 100, 800, 600);
        setTitle("ProyectoTienda - V2.0");
        setLayout(null);
        
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setBounds(0, 0, 400, 600);
        panelFormulario.setLayout(null); //layout libre
        getContentPane().add(panelFormulario); //establece un panel general
        //panelFormulario.setBackground(new Color(100, 100, 100)); // para configurar el fondo
        
        
        JPanel panelTabla = new JPanel();
        panelTabla.setBounds(400, 0, 400, 600);
        panelTabla.setLayout(null);
        getContentPane().add(panelTabla); //panel con una tabla
        
        
        //Componentes del panel del formulario
        labelCodigo = new JLabel("Código");
        labelCodigo.setBounds(10, 20, 100, 30);
        panelFormulario.add(labelCodigo); //poner labelCodigo en el panel Formulario
        
        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 20, 200, 30);
        panelFormulario.add(txtCodigo);
        
        labelNombre = new JLabel("Nombre");
        labelNombre.setBounds(10, 70, 100, 30);
        panelFormulario.add(labelNombre); 
        
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 70, 200, 30);
        panelFormulario.add(txtNombre);
        
        labelMarca = new JLabel("Marca");
        labelMarca.setBounds(10, 120, 100, 30);
        panelFormulario.add(labelMarca); 
        
        txtMarca = new JTextField();
        txtMarca.setBounds(150, 120, 200, 30);
        panelFormulario.add(txtMarca);
        
        labelPresent = new JLabel("Presentación");
        labelPresent.setBounds(10, 170, 100, 30);
        panelFormulario.add(labelPresent); 
        
        txtPresent = new JTextField();
        txtPresent.setBounds(150, 170, 200, 30);
        panelFormulario.add(txtPresent);
        
        JLabel labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(10, 220, 100, 30);
        panelFormulario.add(labelTipo);
        
        comboTipo = new JComboBox(); //formato JComboBox para un dropdown
        comboTipo.addItem("Escoja");
        comboTipo.addItem("Aseo");
        comboTipo.addItem("Alimento");
        comboTipo.setBounds(150, 220, 200, 30);
        panelFormulario.add(comboTipo); 
        
        txtPresent = new JTextField();
        txtPresent.setBounds(150, 170, 200, 30);
        panelFormulario.add(txtPresent);
        
        labelCant = new JLabel("Cantidad");
        labelCant.setBounds(10, 270, 100, 30);
        panelFormulario.add(labelCant); 
        
        txtCant = new JTextField();
        txtCant.setBounds(150, 270, 200, 30);
        panelFormulario.add(txtCant);
        
        labelPrecio = new JLabel("Precio");
        labelPrecio.setBounds(10, 320, 100, 30);
        panelFormulario.add(labelPrecio); 
        
        txtPrecio = new JTextField();
        txtPrecio.setBounds(150, 320, 200, 30);
        panelFormulario.add(txtPrecio);
                
        setVisible(true); // va al final para que todo sea visible
    }
}




/** GUI
     * Frame/Ventana(nombre, botones, ancho, alto, ubicación)
         
         * Labels
         * Text field/text box
         * DropDown
         * Buttons
         * Layout: con coordenadas x, y, ancho, alto (n, n, n, n) || libre (null)
             * JFrame: panel general
             * Paneles: Divisiones dentro de un frame
                    * Panel bounds: con respecto al frame
             * Frame Bounds: alineación con respecto a la pantalla
         * Color: RGB (n, n, n) en donde n = 0-255

 * POE: Programación Orientada a Eventos
 * 
 */