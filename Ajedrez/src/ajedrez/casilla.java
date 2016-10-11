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
public class casilla
{
   //ATRIBUTOS
   private String colorCasilla;
   private ficha fichaCasilla;
   /**
    * Costructor de casilla
    * @param pColorCasilla color de la casilla
    */
   public void setColorCasilla(String pColorCasilla){
      colorCasilla=pColorCasilla;
   }
   /**
    * Retorna color de la casilla
    * @return color de la casilla
    */
   public String getColorCasilla(){
      return colorCasilla;
   }
   /**
    * Retorna establece ficha en la casilla
    * @param pFichaCasilla ficha a establecer en la casilla
    */
   public void setFichaCasilla(ficha pFichaCasilla){
      fichaCasilla=pFichaCasilla;
   }
   /**
    * Retorna ficha presente en la casilla
    * @return ficha presente en la casilla
    */
   public ficha getFichaCasilla(){
      return fichaCasilla;
   }
}
