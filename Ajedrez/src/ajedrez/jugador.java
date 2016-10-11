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


public class jugador
{

    private final String nombre;
    private final String colorFichas;
    /**
     * Constructor de jugador
     * @param pNombre Nombre del jugador
     * @param pColorFichas Color de las fichas que corresponden al jugador
     */
    public jugador(String pNombre, String pColorFichas){
        nombre=pNombre;
        colorFichas=pColorFichas;
    }
    /**
     * Retorna el nombre del jugador
     * @return Nombre del jugador
     */
    public String getJugadorNombre(){
        return nombre;
    }
    /**
     * Retorna el color del jugador
     * @return Color del jugador
     */
    public String getJugadorColor(){
        return colorFichas;
    }
}
