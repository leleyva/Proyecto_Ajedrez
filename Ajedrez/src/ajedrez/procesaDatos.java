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
public class procesaDatos
{
    /**
     * Valida si una celda está escrita correctamente
     * @param celda cadena de caracteres que representa una celda
     * @return boolean valides de la cadena de caracteres para representar una celda
     */
    public static boolean validaCelda(String celda){
        boolean validez=true;
        char caracter0;
        char caracter1;
        celda=celda.toUpperCase();
        if(celda.length()!=2){
            validez=false;
        }
        caracter0=celda.charAt(0);
        caracter1=celda.charAt(1);
        if(caracter0<48||caracter0>55){
            validez=false;
        }
        if(caracter1<65||caracter1>72){
            validez=false;
        }
        return validez;
    }
    
    /**
     *Obtiene la coordenada j de una matriz nc (número caracter)
     * @param cordNC cadena de caracteres valida con coordenada
     * @return posición j de la matriz
     */
    public static int ncToJ(String cordNC){
        char columna;
        int numColumna;
        cordNC=cordNC.toUpperCase();
        columna=cordNC.charAt(1);
        switch(columna){
            case 'A':
                numColumna =  0;
                break;
            case 'B':
                numColumna =  1;
                break;
            case 'C':
                numColumna =  2;
                break;
            case 'D':
                numColumna =  3;
                break;
            case 'E':
                numColumna =  4;
                break;
            case 'F':
                numColumna =  5;
                break;
            case 'G':
                numColumna =  6;
                break;
            default:
                numColumna =  7;
        }
        return numColumna;
    }
     
    /**
     *Obtiene la coordenada i de una matriz nc (número caracter)
     * @param cordNC cadena de caracteres valida con coordenada
     * @return posición i de la matriz
     */
    public static int ncToI(String cordNC){
        char fila;
        int numFila;
        cordNC=cordNC.toUpperCase();
        fila=cordNC.charAt(0);
        numFila = 8-(fila - 48); /* 48 es el valor ascii del 0 */
        return numFila;
    }
}
