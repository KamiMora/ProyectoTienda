public class Inicio 
{
    public static void main(String [] args) 
    {
        Menu m = new Menu(); //** creo un objeto de tipo Menu para que presente el menuPrincipal
        m.presentarMenuPrincipal(); 
    }
        
}

/**Pruebas unitarias
   se usan para verificar que el código está funcionando bien sin haber creado un menú de arranque */
   
/** Para trabajar el menú de arranque desde la clase main debo crear métodos estáticos compatibles, 
   o se puede crear una clase para hacer las preguntas/pedir el ingreso de datos desde el menú */