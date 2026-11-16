/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.simuladorcombate;

/**
 *
 * @author Chavez
 */
public class Arquero extends Personaje {
    public Arquero(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa) {
        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        
    }

    public Arquero() {
        this("Mago Aprendiz", 80.0, 20.0, 2.0);
    }
    
     @Override
    public void atacar(Personaje objetivo){
        double danio = calcularDanioBase(objetivo);
        objetivo.recibirDanio(danio);
        System.out.println("ATAQUE de " + this.nombre + " para " + objetivo.nombre + ", daño causado: " + danio);
        System.out.println("");
    }
    
    @Override
    public void habilidadEspecial(Personaje objetivo) {
        double danio = (this.puntosAtaque * 1.5) - objetivo.puntosDefensa;
        if (danio <= 0) {
            danio = 3.0;
        }
        objetivo.recibirDanio(danio);
        
        this.puntosVida -= 10.0;
        if (this.puntosVida < 1.0) {
            this.puntosVida = 1.0;
        }
        
    }
    
    @Override
    public void subirNivel() {
        super.subirNivel(); 
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        
    }
    @Override
    public String getTipo() {
        return "Arquero";
    }
}
