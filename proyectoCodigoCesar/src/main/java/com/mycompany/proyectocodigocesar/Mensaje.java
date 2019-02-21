/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectocodigocesar;

import java.util.Scanner;

/**
 * Lo que hace la clase ???
 * @author JuanCamilo
 * @version 1.0
 */
public final class Mensaje {
    
    private String abecedario = "abcdefghijklmnñopqrstuvwxyz";
    private String nuevoMensaje;
    private String mensaje;
    private int clave;
    private int opcion;
    
    
    /**
     * Metodo constructor donde se inicializa y segun la opcion encripta o desencripta el mensaje original 
     */
    public Mensaje(){
        this.nuevoMensaje = "";
        leerMensaje();
        elegirOpcion();
        
        switch(opcion){
            case 1:
                encriptarMensaje();
                mostrarMensaje();
                break;
            case 2:
                desencriptarMensaje();
                mostrarMensaje();
                break;
            default:System.out.println("Valor no valido como opcion");
                break;
        }
    }

    /**
     * Este metodo pide el mensaje y la clave al usuario
     */
    public void leerMensaje() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Bienvenido al Cifrado Cesar");
        
        System.out.print("Escriba el mensaje:");
        mensaje = entrada.nextLine();
        
        System.out.print("Digite la clave: ");
        clave = entrada.nextInt();
        clave = clave%abecedario.length();
    }
    
    /**
     * Este metodo muesta el menu y pide una opcion 
     */
    public void elegirOpcion(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("   1. Encriptar mensaje");
        System.out.println("   2. Desencriptar mensaje");
        System.out.print("Digite una opcion: ");
        opcion = entrada.nextInt();
        
    }
    
    /**
     * Este metodo toma el mensaje y lo encripta sumando la clave 
     */
    public void encriptarMensaje(){
        for(int i=0; i<mensaje.length();i++){
            if(mensaje.charAt(i) == ' '){
                nuevoMensaje = nuevoMensaje + ' ';
            }
            else{
                int posicion = abecedario.indexOf(mensaje.charAt(i));
                if((posicion + clave) < abecedario.length()){
                    nuevoMensaje = nuevoMensaje + abecedario.charAt(posicion + clave);
                }
                else{
                    nuevoMensaje = nuevoMensaje + abecedario.charAt((posicion + clave)- abecedario.length());
                }                            
            }
        }
    }
    
    /**
     * Este metodo toma el mensaje y lo desencripta restando la clave
     */
    public void desencriptarMensaje(){
        for(int i=0; i<mensaje.length();i++){
            if(mensaje.charAt(i) == ' '){
                nuevoMensaje = nuevoMensaje + ' ';
            }
            else{
                int posicion = abecedario.indexOf(mensaje.charAt(i));
                if((posicion - clave) < 0){
                    nuevoMensaje = nuevoMensaje + abecedario.charAt((posicion - clave)+ abecedario.length());
                }
                else{
                    nuevoMensaje = nuevoMensaje + abecedario.charAt((posicion - clave) );
                }                            
            }
        }
    }
    
    /**
     * Este metodo imprime el mensaje 
     */
    public void mostrarMensaje(){
        System.out.println("El mensaje final es: "+nuevoMensaje);
    }
    
}
