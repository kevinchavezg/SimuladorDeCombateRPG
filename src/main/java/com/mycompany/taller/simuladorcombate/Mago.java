/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller.simuladorcombate;

/**
 *
 * @author Chavez
 */
public class Mago extends Personaje implements Curable {
    private double mana;
    private double manaMax;

    public Mago(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa, double mana) {
        super(nombre, puntosVidaMax, puntosAtaque, puntosDefensa);
        this.mana = mana;
        this.manaMax = mana;
    }

    public Mago() {
        this("Mago Aprendiz", 80.0, 20.0, 2.0, 100.0);
    }

    @Override
    public void atacar(Personaje objetivo) {
        double danio = 3.0;
        if (this.mana >= 5.0) {
            this.mana -= 5.0;
            danio = this.puntosAtaque - (objetivo.puntosDefensa / 2.0);
            if (danio <= 0) {
                danio = 3.0;
            }
            System.out.println("RAYO ARCANO de " + this.nombre + " para " + objetivo.nombre + ", daño causado: " + danio);
            System.out.println("");
        } else {
            System.out.println("Mana insuficiente, ataque normal");
            System.out.println("");
        }            
        objetivo.recibirDanio(danio);
    }

    @Override
    public void habilidadEspecial(Personaje objetivo) {
        if (this.mana >= 30.0) {
            this.mana -= 30.0;
            double danio = this.puntosAtaque * 2.0;
            objetivo.recibirDanio(danio);
            System.out.println("BOLA DE FUEGO de " + this.nombre + " para " + objetivo.nombre + ", daño causado: " + danio);
            System.out.println("");
        } else {
            System.out.println("Mana insuficiente, ataque normal");
            System.out.println("");
            atacar(objetivo);
        }
    }

    @Override
    public void curar() {
        if (this.mana >= 20.0) {
            this.mana -= 20.0;
            double curacionTotal = CURACION_BASE + 5.0;
            this.puntosVida += curacionTotal;
            if (this.puntosVida > this.puntosVidaMax) {
                this.puntosVida = this.puntosVidaMax;
            }
            System.out.println("CURACION de " + this.nombre + ", vida actual: " + this.puntosVida );
            System.out.println("");
        } else {
            System.out.println("Mana insuficiente para curarte");
            System.out.println("");
        }
    }

    @Override
    public void subirNivel() {
        super.subirNivel();
        this.manaMax += 20.0;
        this.mana = this.manaMax;
        System.out.println("Mana maximo aumentado a: " + this.manaMax);
        System.out.println("");
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Mana: " + this.mana + " / " + this.manaMax);
        System.out.println("");
    }

    @Override
    public String getTipo() {
        return "Mago";
    }
}
