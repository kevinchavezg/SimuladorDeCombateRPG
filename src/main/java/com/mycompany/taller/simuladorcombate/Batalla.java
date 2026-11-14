
package com.mycompany.taller.simuladorcombate;


public class Batalla {
    public static void ejecutarAtaqueCritico(Personaje atacante, Personaje objetivo, double multiplicador){
        double ataquePotenciado = atacante.puntosAtaque * multiplicador;
        double calculoDanio = ataquePotenciado - objetivo.puntosDefensa;
        
        int danioEntero = (int) calculoDanio;
        double danioFinal = (double) danioEntero;
                      
        objetivo.recibirDanio(danioFinal);
        
        System.out.println("GOLPE CRITICO! de " + atacante.nombre + " a " + objetivo.nombre);
        
    }
    
    public static void iniciarPeleaAutomatica(Personaje p1, Personaje p2){
        while (p1.estaVivo() && p2.estaVivo()){
            p1.atacar(p2);
            
            if (p2.estaVivo()){
                p2.atacar(p1);
            }
            System.out.println(p1.nombre + " - " + p1.puntosVida + " versus " + p2.nombre + " - " + p2.puntosVida);
        }
        
        if (p1.estaVivo() && !p2.estaVivo()){
            System.out.println("PELEA FINALIZADA el ganador es : " + p1.nombre);
        } else if (p2.estaVivo() && !p1.estaVivo()){
            System.out.println("PELEA FINALIZADA el ganador es : " + p2.nombre);
        } else {
            System.out.println("PELEA FINALIZADA ha sido un empate!");
        }
            
    }
}
