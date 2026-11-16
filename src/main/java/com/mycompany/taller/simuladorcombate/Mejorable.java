
package com.mycompany.taller.simuladorcombate;


public interface Mejorable {
    void subirNivel();
    
    default void mostrarMensajeNivel(int nivel){
        System.out.println("Alcanzo el nivel " + nivel);
    }
}
