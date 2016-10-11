/*
 * Ajedrez - Estructura de datos
 * Clase para ingresar y utilizar el juego de ajedrez
 */

package ajedrez;
import java.util.Scanner;
import java.util.*;
/**
 * @version 1.0
 * @author BECERRA TELLEZ ANYELA SOLIZBETH
 * @author GARCIA GUARIN LUIS GABRIEL
 * @author LEYVA CAMARGO LUIS ERNESTO
 * @author PERAZA LINARES DIANA PAOLA
 * @author ZAMBRANO AMEZQUITA LEONARDO
 * @since 1.0
 */
public class Ajedrez
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {

       List<jugada> listaJugadas=new LinkedList<jugada>();
       //String ficha="rey",color="blancas";
       String ficha,color;
       String opcion,opColFicha,opFicha;
       Scanner entrada = new Scanner(System.in);
       juego instJuego = new juego();
       
       System.out.println("BIENVENIDO A AJEDREZ");
       instJuego.llenarTablero();
       instJuego.iniciarTablero();
       instJuego.asignarJugadores();
       do{
           System.out.println("Por favor seleccione una opcion:");
           System.out.println("0. Salir:");
           System.out.println("1. Mostrar tablero:");
           System.out.println("2. Realizar jugada:");
           System.out.println("3. Mostrar ganador:");
           System.out.println("4. Listar jugadas:");
           System.out.println("5. Tiempo por jugador:");
           System.out.println("6. Eliminar jugada");
           System.out.println("7. Mostrar movimientos por ficha");
           opcion=entrada.next(); 
           switch(opcion){
               case "0":
                   System.out.println("Salida del juego");
                   opcion="0";
                   break;
               case "1":
                   instJuego.mostrarTablero();
                   break;
               case "2":
                   instJuego.jugar();
                   listaJugadas.add(null);  
                   break;
               case "3":
                   System.out.println("Ganador: " + instJuego.verGanador() );
                   break;
               case "4":
                   System.out.println("Jugadas: ");
                   instJuego.listarJugadas();
                   break;
               case "5":
                   System.out.println("Tiempos acumulados: ");
                   instJuego.mostrarTiempos();
                   break;
               case "6":
                   System.out.println("Eliminar ultima jugada");
                   instJuego.quitarUltiJugada();
                   break;
               case "7":
                   System.out.println("Listar movimiento por ficha");
                   do{
                       System.out.println("Por favor seleccione una opcion:");
                       System.out.println("1. Blancas:");
                       System.out.println("2. Negras:");
                       opColFicha=entrada.next(); 
                       switch(opColFicha){
                           case "1":
                               color="blancas";
                               break;
                           case "2":
                               color="negras";
                               break;
                           default:
                               color="blancas";
                               System.out.println("Dato no valido:");
                               break;
                       }
                   }while(!"1".equals(opColFicha)&&!"2".equals(opColFicha));
                   do{
                       System.out.println("Por favor seleccione una opcion:");
                       System.out.println("1. Peon:");
                       System.out.println("2. Torre:");
                       System.out.println("3. Alfil:");
                       System.out.println("4. Caballo:");
                       System.out.println("5. Reina:");
                       System.out.println("6. Rey:");
                       opFicha=entrada.next(); 
                       switch(opFicha){
                           case "1":
                               ficha="peo";
                               break;
                           case "2":
                               ficha="tor";
                               break;
                           case "3":
                               ficha="alf";
                               break;
                           case "4":
                               ficha="cab";
                               break;
                           case "5":
                               ficha="rei";
                               break;
                           case "6":
                               ficha="rey";
                               break;
                           default:
                               ficha="peo";
                               System.out.println("Dato no valido:");
                               break;
                       }
                   }while(!"1".equals(opFicha)&&!"2".equals(opFicha)&&!"3".equals(opFicha)&&!"4".equals(opFicha)&&!"5".equals(opFicha)&&!"6".equals(opFicha));
                   instJuego.listarJugadaFicha(ficha,color);
                   break;
               default:
                   System.out.println("Seleccion no valida");
                   break;  
           }
       }while(!"0".equals(opcion));
       entrada.close();
   }
}
