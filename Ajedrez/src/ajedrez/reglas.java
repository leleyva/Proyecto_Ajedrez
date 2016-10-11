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
public class reglas
{
    /**
     *Valida moviemto de ficha
     * @param celOri Celda de origen del movimiento
     * @param celDes Celda de destino en el movimiento
     * @param ficha Ficha a la que aplica la regla
     * @param color Color de la ficha a la que aplica la regla - para peones
     * @return boolean validez del movimiento
     */
    public static boolean valMov(String celOri, String celDes, String ficha, String color){
        boolean validezMovimiento=false;
        int iO=procesaDatos.ncToI(celOri);
        int jO=procesaDatos.ncToJ(celOri);
        int iD=procesaDatos.ncToI(celDes);
        int jD=procesaDatos.ncToJ(celDes);
        if (celOri==celDes){
            validezMovimiento=false;
        }
        else{
            //valida movimiento según la ficha y color
           switch(ficha){
                case "   ":
                    break;
                case "rey":
                    if((iO==iD+1||iO==iD-1||iO==iD)&&((jO==jD+1||jO==jD-1||jO==jD))){
                       validezMovimiento=true; 
                    }
                    break;
                case "tor":
                    if(iO==iD||jO==jD){
                       validezMovimiento=true; 
                    }
                    break;
                case "alf":
                    for(int i=1;i<8;i++){
                        if( (iO==iD+i&&jO==jD+i) || (iO==iD-i&&jO==jD+i) || (iO==iD+i&&jO==jD-i) || (iO==iD-i&&jO==jD-i)){
                            validezMovimiento=true; 
                        }
                    }
                    break;
                case "rei":
                    for(int i=1;i<8;i++){
                        if( (iO==iD+i&&jO==jD+i) || (iO==iD-i&&jO==jD+i) || (iO==iD+i&&jO==jD-i) || (iO==iD-i&&jO==jD-i)){
                            validezMovimiento=true; 
                        }
                    }
                    if(iO==iD||jO==jD){
                       validezMovimiento=true; 
                    }
                    break;
                case "cab":
                    if( (iO==iD+2&&jO==jD+1) || (iO==iD+1&&jO==jD+2) || (iO==iD-2&&jO==jD+1)|| (iO==iD-1&&jO==jD+2) || (iO==iD+2&&jO==jD-1) || (iO==iD+1&&jO==jD-2) || (iO==iD-1&&jO==jD-2) || (iO==iD-2&&jO==jD-1)){
                       validezMovimiento=true; 
                    }
                    break;
                case "peo":
                    if(color=="negras"){
                        if(iO==1){
                            if( (jD==jO||jD==jO+1||jD==jO-1) && (iD==iO+1||iD==iO+2) ){
                                validezMovimiento=true; 
                            }
                        }
                        else
                        {
                            if( (jD==jO||jD==jO+1||jD==jO-1) && (iD==iO+1) ){
                                validezMovimiento=true; 
                            }
                        }
                    }
                    else{
                        if(iO==6){
                            if( (jD==jO||jD==jO+1||jD==jO-1) && (iD==iO-1||iD==iO-2) ){
                                validezMovimiento=true; 
                            }
                        }
                        else
                        {
                            if( (jD==jO||jD==jO+1||jD==jO-1) && (iD==iO-1) ){
                                validezMovimiento=true; 
                            }
                        }
                    }   
                    break;
                default:
                    validezMovimiento=false;
                    break;
            }
        }
        return validezMovimiento;
    }
}
