/*
 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

/**
 * @version 1.0
 * @author BECERRA TELLEZ ANYELA SOLIZBETH
 * @author GARCIA GUARIN LUIS GABRIEL
 * @author LEYVA CAMARGO LUIS ERNESTO
 * @author PERAZA LINARES DIANA PAOLA
 * @author ZAMBRANO AMEZQUITA LEONARDO
 * @since 1.0
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
* Clase para jugar
 */
public class juego
{
  //Lista de jugadas
    List<jugada> listaJugadas=new LinkedList<>();
   
    private final casilla[][] tablero = new casilla[8][8];
    private final jugador jugadores[]=new jugador[2];
    private int numTurno;
   //variables para lista de jugadas
    private int numJugada=0;

    /**
    * Asigna valores a los jugadores
    */
    public void asignarJugadores(){

        Random numeroRandom = new Random();
        int turno = numeroRandom.nextInt(10)%2;
        System.out.println("Ramdom: " + turno);

        String nombreJugador1,nombreJugador2;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce nombre jugador 1: ");
        nombreJugador1=entrada.next(); 
        System.out.println("Introduce nombre jugador 2: ");
        nombreJugador2=entrada.next(); 
        if(turno==0){
            jugador jugador1=new jugador(nombreJugador1,"blancas");
            jugador jugador2=new jugador(nombreJugador2,"negras");
            jugadores[0]=jugador1;
            jugadores[1]=jugador2;
            numTurno=0;
        }
        else{
            jugador jugador1=new jugador(nombreJugador1,"negras");
            jugador jugador2=new jugador(nombreJugador2,"blancas");
            jugadores[0]=jugador1;
            jugadores[1]=jugador2;
            numTurno=1;
        }
        System.out.println("El jugador 1 es: " + jugadores[0].getJugadorNombre() + " con fichas " + jugadores[0].getJugadorColor());
        System.out.println("El jugador 2 es: " + jugadores[1].getJugadorNombre() + " con fichas " + jugadores[1].getJugadorColor());
   }
    /**
    * Llena el tablero
    */
   public void llenarTablero(){
      String colorCampo="b";
      for(int i=0;i<8;i++){
            if("n".equals(colorCampo)){
               colorCampo="b";
            }
            else{
               colorCampo="n";
            }
         for(int j=0;j<8;j++){
            if("n".equals(colorCampo)){
               colorCampo="b";
            }
            else{
               colorCampo="n";
            }
            //casillaTablero[i][j]= colorCampo;
            tablero[i][j]=new casilla();
            tablero[i][j].setColorCasilla(colorCampo);
            tablero[i][j].setFichaCasilla(null);
         }
      }
   }
   /**
    * Muestra el tablero
    */
   public void mostrarTablero(){
      System.out.println("\t\tA\t\tB\t\tC\t\tD\t\tE\t\tF\t\tG\t\tH");  
      for(int i=0;i<8;i++){
         System.out.print(8-i+"\t");
         for(int j=0;j<8;j++){
            System.out.print(tablero[i][j].getFichaCasilla().getFichaNombre() + " ");
            System.out.print(tablero[i][j].getFichaCasilla().getFichaColor() + " ");
            System.out.print(tablero[i][j].getColorCasilla() + "\t");
         }
         System.out.println();
      }
   }
   /**
    * Inicializa el tablero con valores para cada casilla
    */
   public void iniciarTablero(){
       //INSTANCIAS
       //Ficha vacía
       ficha fichaVacia = new ficha("   ","     ");
       //Fichas negras
       ficha NegroRey = new ficha("rey","negras");
       ficha NegroReina = new ficha("rei","negras");
       ficha NegroTorre = new ficha("tor","negras");
       ficha NegroCaballo = new ficha("cab","negras");
       ficha NegroAlfil = new ficha("alf","negras");
       ficha NegroPeon = new ficha("peo","negras");
       //Fichas blancas
       ficha BlancoRey = new ficha("rey","blancas");
       ficha BlancoReina = new ficha("rei","blancas");
       ficha BlancoTorre = new ficha("tor","blancas");
       ficha BlancoCaballo = new ficha("cab","blancas");
       ficha BlancoAlfil = new ficha("alf","blancas");
       ficha BlancoPeon = new ficha("peo","blancas");
       
       tablero[0][0].setFichaCasilla(NegroTorre);
       tablero[0][1].setFichaCasilla(NegroCaballo);
       tablero[0][2].setFichaCasilla(NegroAlfil);
       tablero[0][3].setFichaCasilla(NegroReina);
       tablero[0][4].setFichaCasilla(NegroRey);
       tablero[0][5].setFichaCasilla(NegroAlfil);
       tablero[0][6].setFichaCasilla(NegroCaballo);
       tablero[0][7].setFichaCasilla(NegroCaballo);
       for(int j=0;j<8;j++){
           tablero[1][j].setFichaCasilla(NegroPeon);
       }
       for(int i=2;i<6;i++){
           for(int j=0;j<8;j++){
               tablero[i][j].setFichaCasilla(fichaVacia);
           }
       }
       for(int j=0;j<8;j++){
           tablero[6][j].setFichaCasilla(BlancoPeon);
       }
       tablero[7][0].setFichaCasilla(BlancoTorre);
       tablero[7][1].setFichaCasilla(BlancoCaballo);
       tablero[7][2].setFichaCasilla(BlancoAlfil);
       tablero[7][3].setFichaCasilla(BlancoReina);
       tablero[7][4].setFichaCasilla(BlancoRey);
       tablero[7][5].setFichaCasilla(BlancoAlfil);
       tablero[7][6].setFichaCasilla(BlancoCaballo);
       tablero[7][7].setFichaCasilla(BlancoCaballo);
   }
   /**
    * Corre el juego
    */
   public void jugar(){
        ficha fichaVacia = new ficha("   ","     ");
        Scanner entrada = new Scanner(System.in);
        String celdaOrigen;
        String celdaDestino;
        String opcion;
        boolean tablas=false;
        boolean ganador=false;
        boolean salir=false;
        boolean entradaValida;
        boolean movimientoValido;
        boolean destinoValido;
        long segundos;
        //Juego de un turno

        System.out.println("Turno de: " + jugadores[numTurno].getJugadorNombre() + " con fichas " + jugadores[numTurno].getJugadorColor() + " ");
        long tInicio, tFinal;
        tInicio = System.currentTimeMillis();
        do{
            //Ingreso de celda de origen
            do{
                entradaValida=false;
                System.out.println("celda de origen (fila(num) y col(Letra)) fichas "+jugadores[numTurno].getJugadorColor()+": ");
                celdaOrigen=entrada.next();
                if(procesaDatos.validaCelda(celdaOrigen)){
                    System.out.println("celda valida");
                    entradaValida=true;
                }
                else{
                    System.out.println("celda no valida");                           
                }
            }while(entradaValida==false);
            //ingreso de celda destino
            do{
                entradaValida=false;
                System.out.println("celda Destino (fila(num) y col(Letra)): ");
                celdaDestino=entrada.next();
                if(procesaDatos.validaCelda(celdaDestino)){
                    System.out.println("celda valida");
                    entradaValida=true;
                }
                else{
                    System.out.println("celda no valida");                            
                }
            }while(entradaValida==false);
            //jugada o rechazo de jugada
            movimientoValido=reglas.valMov(celdaOrigen, celdaDestino, tablero[procesaDatos.ncToI(celdaOrigen)][procesaDatos.ncToJ(celdaOrigen)].getFichaCasilla().getFichaNombre(), tablero[procesaDatos.ncToI(celdaOrigen)][procesaDatos.ncToJ(celdaOrigen)].getFichaCasilla().getFichaColor());
            destinoValido=this.valDest(celdaOrigen, celdaDestino, numTurno);
            if(movimientoValido&&destinoValido){
                numJugada++;
                tFinal = System.currentTimeMillis();
                segundos=(tFinal - tInicio)/1000;
                jugada instJugada = new jugada(numJugada,segundos,celdaOrigen,tablero[procesaDatos.ncToI(celdaOrigen)][procesaDatos.ncToJ(celdaOrigen)].getFichaCasilla().getFichaNombre(),tablero[procesaDatos.ncToI(celdaOrigen)][procesaDatos.ncToJ(celdaOrigen)].getFichaCasilla().getFichaColor(),celdaDestino,tablero[procesaDatos.ncToI(celdaDestino)][procesaDatos.ncToJ(celdaDestino)].getFichaCasilla().getFichaNombre(),tablero[procesaDatos.ncToI(celdaDestino)][procesaDatos.ncToJ(celdaDestino)].getFichaCasilla().getFichaColor()); 
                instJugada.setFichaOrigen(tablero[procesaDatos.ncToI(celdaOrigen)][procesaDatos.ncToJ(celdaOrigen)].getFichaCasilla());
                instJugada.setFichaDestino(tablero[procesaDatos.ncToI(celdaDestino)][procesaDatos.ncToJ(celdaDestino)].getFichaCasilla());
                listaJugadas.add(instJugada); 
                
                tablero[procesaDatos.ncToI(celdaDestino)][procesaDatos.ncToJ(celdaDestino)].setFichaCasilla(tablero[procesaDatos.ncToI(celdaOrigen)][procesaDatos.ncToJ(celdaOrigen)].getFichaCasilla());
                tablero[procesaDatos.ncToI(celdaOrigen)][procesaDatos.ncToJ(celdaOrigen)].setFichaCasilla(fichaVacia);
                System.out.println("La jugada duró: "+ ( segundos ) +" segundos");
                
            }
            else
            {
                System.out.println("Movimiento o destino invalido");
            }
            
            
            
            //ReallyHeavyTask(); // llamamos a la tarea
            
            
            
        }while(!movimientoValido||!destinoValido);
        //}while(!movimientoValido);
              
                           
          //Cambio de turno
          if(numTurno==0){
              numTurno=1;
          }
          else
          {
              numTurno=0;
          }
   }
   /**
    * Valida celda de destino
    * @param cOrig celda de origen
    * @param cDest celda de destino
    * @param turno turno al que corresponde la jugada
    * @return retorna la validez de la jugada
    */
   public boolean valDest(String cOrig, String cDest, int turno){
       boolean validez=true;
       if(tablero[procesaDatos.ncToI(cOrig)][procesaDatos.ncToJ(cOrig)].getFichaCasilla().getFichaColor() == null ? tablero[procesaDatos.ncToI(cDest)][procesaDatos.ncToJ(cDest)].getFichaCasilla().getFichaColor() == null : tablero[procesaDatos.ncToI(cOrig)][procesaDatos.ncToJ(cOrig)].getFichaCasilla().getFichaColor().equals(tablero[procesaDatos.ncToI(cDest)][procesaDatos.ncToJ(cDest)].getFichaCasilla().getFichaColor())){
          validez=false;
       }
       if(jugadores[numTurno].getJugadorColor() == null ? tablero[procesaDatos.ncToI(cOrig)][procesaDatos.ncToJ(cOrig)].getFichaCasilla().getFichaColor() != null : !jugadores[numTurno].getJugadorColor().equals(tablero[procesaDatos.ncToI(cOrig)][procesaDatos.ncToJ(cOrig)].getFichaCasilla().getFichaColor())){
          validez=false;
       }
       return validez;
   }
   
   /**
    * Muestra ganador actual
    * @return ganador actual
    */
   public String verGanador(){
       String Ganador="Ninguno aun";
       boolean estaReyBlanco=false;
       boolean estaReyNegro=false;
       for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               if("rey".equals(tablero[i][j].getFichaCasilla().getFichaNombre())&&"negras".equals(tablero[i][j].getFichaCasilla().getFichaColor())){
                   estaReyNegro=true;
               }
               if("blancas".equals(tablero[i][j].getFichaCasilla().getFichaColor())&&"rey".equals(tablero[i][j].getFichaCasilla().getFichaNombre())){
                   estaReyBlanco=true;
               }
           }
       }
       if(!estaReyBlanco||!estaReyNegro){
           if(estaReyBlanco){
               Ganador="blancas";
           }
           if(estaReyNegro){
               Ganador="negras";
           }
       }
       return Ganador;
   }
   
   /**
    * Muestra lista de jugadas
    */
   public void listarJugadas(){
       System.out.print("Numero\ttiempo\torigen\tficha\tcolor\tdestino\n");
       for(int i=0;i<listaJugadas.size();i++){           
           System.out.print(listaJugadas.get(i).getNumero()+"\t"+listaJugadas.get(i).getDuracion()+"\t"+listaJugadas.get(i).getCeldaOrigen()+"\t"+listaJugadas.get(i).getFichaOrigenNom()+"\t"+listaJugadas.get(i).getColorOrigen()+"\t"+listaJugadas.get(i).getCeldaDestino()+"\t"+listaJugadas.get(i).getFichaDestinoNom()+"\n");
       }
   }
   
   /**
    * Muestra tiempos por jugador
    */
   public void mostrarTiempos(){
       long tiempoJ1=0;
       long tiempoJ2=0;
       for(int i=0;i<listaJugadas.size();i++){           
           if(i%2==0){
               tiempoJ1+=listaJugadas.get(i).getDuracion();
           }
           else
           {
               tiempoJ2+=listaJugadas.get(i).getDuracion();
           }
       }
       System.out.println("Jugador 1: " + tiempoJ1);
       System.out.println("Jugador 2: " + tiempoJ2);    
   }
   
   /**
    * Elimina la ultima jugada de la lista de jugadas
    */
   public void quitarUltiJugada(){
       if(listaJugadas.size()==0){
            System.out.println("No hay elementos para borrar");
       }
       else
       {
            String origen=listaJugadas.get(listaJugadas.size()-1).getCeldaOrigen();      
            String destino=listaJugadas.get(listaJugadas.size()-1).getCeldaDestino();
            tablero[procesaDatos.ncToI(origen)][procesaDatos.ncToJ(origen)].setFichaCasilla(listaJugadas.get(listaJugadas.size()-1).getFichaOrigen());
            tablero[procesaDatos.ncToI(destino)][procesaDatos.ncToJ(destino)].setFichaCasilla(listaJugadas.get(listaJugadas.size()-1).getFichaDestino());  
            listaJugadas.remove(listaJugadas.size()-1);
            //Cambio de turno
            if(numTurno==0){
               numTurno=1;
            }
            else
            {
               numTurno=0;
            }
            numJugada--;
       }
   }
   
   /**
    * Muestra jugadas por ficha
    * @param ficha ficha a listar
    * @param color de la ficha a listar
    */
   public void listarJugadaFicha(String ficha, String color){
       for(int i=0;i<listaJugadas.size();i++){           
           if(listaJugadas.get(i).getFichaOrigen().getFichaColor()==color&&listaJugadas.get(i).getFichaOrigen().getFichaNombre()==ficha){
                System.out.print("Numero\ttiempo\torigen\tficha\tcolor\tdestino\n");
                System.out.print(listaJugadas.get(i).getNumero()+"\t"+listaJugadas.get(i).getDuracion()+"\t"+listaJugadas.get(i).getCeldaOrigen()+"\t"+listaJugadas.get(i).getFichaOrigenNom()+"\t"+listaJugadas.get(i).getColorOrigen()+"\t"+listaJugadas.get(i).getCeldaDestino()+"\t"+listaJugadas.get(i).getFichaDestinoNom()+"\n");
           }
       }
   }
}


