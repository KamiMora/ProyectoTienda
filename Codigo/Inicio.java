public class Inicio 
{
    public static void main(String [] args) 
    {
        Menu m = new Menu(); //** creo un objeto de tipo Menu para que presente el menuPrincipal
        m.presentarMenuPrincipal(); 
        
        /* Esto lo utilizamos para hacer la prueba de como se guardan los datos en el archivo "productos.csv"
        ArchivoProductos a = new ArchivoProductos();
        a.guardarArchivo("Ejemplo de datos guardados");
        Sytem.out.println("Archivo guardado");
         */
    }
        
}

/**Pruebas unitarias
   se usan para verificar que el c�digo est� funcionando bien sin haber creado un men� de arranque */
   
/** Para trabajar el men� de arranque desde la clase main debo crear m�todos est�ticos compatibles, 
   o se puede crear una clase para hacer las preguntas/pedir el ingreso de datos desde el men� */