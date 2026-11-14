
package com.mycompany.taller.simuladorcombate;


public class Personaje {
    String nombre;
    double puntosVida;
    double puntosVidaMax;
    double puntosAtaque;
    double puntosDefensa;
    int nivel;
    
    static int totalPersonajesCreados = 0;

    public Personaje(){
        this.nombre = "Guerrero Novato";
        this.puntosVida = 100.0;
        this.puntosVidaMax = 100.0;
        this.puntosAtaque = 15.0;
        this.puntosDefensa = 5.0;
        this.nivel = 1;
        
        totalPersonajesCreados++;
    }
    
    public Personaje(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVidaMax;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.nivel = 1;
        
        totalPersonajesCreados++;
    }
    
    public void atacar(Personaje objetivo){
        double danio = this.puntosAtaque - objetivo.puntosDefensa;
        
        if (danio <= 0){
            danio = 3.0;
        }
        
        objetivo.recibirDanio(danio);
        
        System.out.println("ATAQUE de " + this.nombre + " para " + objetivo.nombre + ", daño causado: " + danio);
    }
    
    public void recibirDanio(double cantidad){
        this.puntosVida -= cantidad;
        
        if (this.puntosVida < 0){
            this.puntosVida = 0.0;
        }
    }
    
    public void curar(){
        this.puntosVida += 25.0;
        
        if (this.puntosVida > this.puntosVidaMax){
            this.puntosVida = this.puntosVidaMax;
        }
        
        System.out.println("CURACION de " + this.nombre + ", vida actual: " + this.puntosVida );
    }
    
    public boolean estaVivo(){
        return this.puntosVida > 0.0;
    }
    
    public void subirNivel(){
        this.nivel++;
        this.puntosVidaMax += 20.0;
        this.puntosAtaque += 5.0;
        this.puntosDefensa += 2.0;
        this.puntosVida = this.puntosVidaMax;
        
        System.out.println(this.nombre + " es nivel " + this.nivel + ". VidaMax: " + this.puntosVidaMax + " | Ataque: " + this.puntosAtaque + " | Defensa: " + this.puntosDefensa);
    }
    
    public void mostrarEstado(){
        System.out.println("ESTADO PERSONAJE");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Nivel: " + this.nivel);
        System.out.println("Vida Actual: " + this.puntosVida + "/" + this.puntosVidaMax);
        System.out.println("Ataque: " + this.puntosAtaque);
        System.out.println("Defensa: " + this.puntosDefensa);
    }
    
    public static int getTotalPersonajesCreados() {
        return totalPersonajesCreados;
    }
}
