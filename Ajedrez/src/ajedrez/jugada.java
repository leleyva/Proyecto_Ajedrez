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
public class jugada
{
    private int numero;
    private long duracion;
    private String celdaOrigen;
    private String fichaOrigen;
    private String colorOrigen;
    private String celdaDestino;
    private String fichaDestino;
    private String colorDestino;
    private ficha fichaOr;
    private ficha fichaDest;
    
     /**
     * Constructor de jugada
     * @param pNumero Número de la jugada desde el inicio de la partida
     * @param pDuracion Duración de la jugada
     * @param pCeldaOrigen cadena con celda de origen de la jugada
     * @param pFichaOrigen ficha ubicada en la celda de origen
     * @param pColorOrigen color de la ficha ubicada en la celda de origen
     * @param pCeldaDestino cadena con celda de destino de la jugada
     * @param pFichaDestino ficha que sería remplazada
     * @param pColorDestino color de la ficha ubicada en la celda destino (solo sería posible si es de color distinto)
     */
    
    public jugada(int pNumero, long pDuracion, String pCeldaOrigen, String pFichaOrigen, String pColorOrigen, String pCeldaDestino, String pFichaDestino, String pColorDestino){
        numero = pNumero;
        duracion = pDuracion;
        celdaOrigen = pCeldaOrigen;
        fichaOrigen = pFichaOrigen;
        colorOrigen = pColorOrigen; 
        celdaDestino = pCeldaDestino; 
        fichaDestino = pFichaDestino; 
        colorDestino = pColorDestino;
    }
    /**
     * Establece la ficha de origen
     * @param pFichaOr Ficha de origen
     */
    public void setFichaOrigen(ficha pFichaOr){
        fichaOr=pFichaOr;
    }
    
    /**
     * Establece la ficha de destino
     * @param pFichaDest Ficha de destino (vacia u otro color, válida)
     */
    public void setFichaDestino(ficha pFichaDest){
        fichaDest=pFichaDest;
    }
   
    /**
     * Retorna ficha de origen
     * @return ficha de origen
     */
    public ficha getFichaOrigen(){
        return fichaOr;
    }
    /**
    * Retorna ficha de destino
    * @return ficha de destino
    */
    public ficha getFichaDestino(){
        return fichaDest;
    }
    /**
    * Retorna numero de la jugada
    * @return numero de la jugada
    */
    public int getNumero(){
        return numero;
    }
    /**
    * Retorna duración de la jugada
    * @return duración de la jugada
    */
    public long getDuracion(){
        return duracion;
    }
    /**
    * Retorna celda de origen
    * @return celda de origen
    */
    public String getCeldaOrigen(){
        return celdaOrigen; 
    }
    /**
    * Retorna nombre de la ficha de origen
    * @return nombre de la ficha de origen
    */
    public String getFichaOrigenNom(){
        return fichaOrigen;
    }
    /**
    * Retorna color de la ficha de origen
    * @return color de la ficha de origen
    */
    public String getColorOrigen(){
        return colorOrigen;
    }
    /**
    * Retorna celda de destino
    * @return celda de destino
    */
    public String getCeldaDestino(){
        return celdaDestino; 
    }
     /**
    * Retorna nombre de la ficha de destino
    * @return nombre de la ficha de destino
    */
    public String getFichaDestinoNom(){
        return fichaDestino;
    }
     /**
    * Retorna color de destino
    * @return color de destino
    */
    public String getColorDestino(){
        return colorDestino;
    }
}