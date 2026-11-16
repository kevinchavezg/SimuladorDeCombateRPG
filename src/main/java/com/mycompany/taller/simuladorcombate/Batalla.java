
package com.mycompany.taller.simuladorcombate;


public class Batalla {
    public static void ejecutarAtaqueCritico(Personaje atacante, Personaje objetivo, double multiplicador){
        double ataquePotenciado = atacante.puntosAtaque * multiplicador;
        double calculoDanio = ataquePotenciado - objetivo.puntosDefensa;
        
        int danioEntero = (int) calculoDanio;
                      
        objetivo.recibirDanio(danioEntero);
        
        System.out.println("GOLPE CRITICO de " + atacante.nombre + " a " + objetivo.nombre);
        
    }
    
    public static void iniciarPeleaAutomatica(Personaje p1, Personaje p2){
        int turno = 1;
        while (p1.estaVivo() && p2.estaVivo()){
            System.out.println("Turno " + turno);
            if (turno % 3 == 0){
                p1.habilidadEspecial(p2);
            } else {
                p1.atacar(p2);
            }
            
            if (p2.estaVivo()){
                if (turno % 3 == 0){
                    p2.habilidadEspecial(p1);
                } else {
                    p2.atacar(p1);
                }
            }
            System.out.println(p1.nombre + " - " + p1.puntosVida + " VRS " + p2.nombre + " - " + p2.puntosVida);
            turno++;
        }
        
        if (p1.estaVivo() && !p2.estaVivo()){
            System.out.println("PELEA FINALIZADA el ganador es : " + p1.nombre);
        } else if (p2.estaVivo() && !p1.estaVivo()){
            System.out.println("PELEA FINALIZADA el ganador es : " + p2.nombre);
        } else {
            System.out.println("PELEA FINALIZADA ha sido un empate");
        }
            
    }
    
    public static void intentarCurar(Personaje p) {
        if (p instanceof Curable) {
            Curable curador = (Curable) p;
            curador.curar();
        } else {
            System.out.println("Los personajes tipo " + p.getTipo() + " no pueden ser curados");
        }
    }
}
