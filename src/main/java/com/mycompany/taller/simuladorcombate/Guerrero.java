
package com.mycompany.taller.simuladorcombate;


public class Guerrero extends Personaje implements Curable{
    private double escudo;

    public Guerrero(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa, double escudo) {
        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        this.escudo = escudo;
    }

    public Guerrero() {
        this("Guerrero Novato", 120.0, 15.0, 8.0, 20.0);
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
    public void recibirDanio(double cantidad) {
        if (this.escudo >= cantidad) {
            this.escudo -= cantidad;
        } else {
            double danioRestante = cantidad - this.escudo;
            this.escudo = 0.0;
            super.recibirDanio(danioRestante);
        }
    }

    @Override
    public void curar() {
        this.puntosVida += CURACION_BASE;
        if (this.puntosVida > this.puntosVidaMax) {
            this.puntosVida = this.puntosVidaMax;
        }
        System.out.println("CURACION de " + this.nombre + ", vida actual: " + this.puntosVida );
    }

    @Override
    public void subirNivel() {
        super.subirNivel(); 
        this.escudo += 10.0;
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Escudo: " + this.escudo);
        System.out.println("");
    }

    @Override
    public String getTipo() {
        return "Guerrero";
    }
}
