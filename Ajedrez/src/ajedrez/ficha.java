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
public class ficha
{
   private String nombre;
   private String color;
   /**
    * Costructor de ficha
    * @param pNombre Nombre de la ficha
    * @param pColor Color de la ficha
    */
   public ficha(String pNombre,String pColor){
    nombre=pNombre;
    color=pColor;
   }
   /**
    * Retorna nombre de la ficha
    * @return nombre de la ficha
    */
   public String getFichaNombre(){
       return nombre;
   }
   /**
    * Retorna color de la ficha
    * @return color de la ficha
    */
   public String getFichaColor(){
       return color;
   }
}
