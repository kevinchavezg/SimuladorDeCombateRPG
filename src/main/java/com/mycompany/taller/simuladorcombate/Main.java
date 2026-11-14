
package com.mycompany.taller.simuladorcombate;

import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Personaje p1 = null;
        Personaje p2 = null;
        
        int opcion = 0;
        do{
            System.out.println("--- SIMULADOR DE COMBATE RPG ---");
            System.out.println("");
            System.out.println("1. Crear Personaje 1");
            System.out.println("2. Crear Personaje 2");
            System.out.println("3. Ver ficha tecnica de los personajes");
            System.out.println("4. Subir de nivel a un personaje");
            System.out.println("5. Curar a un personaje");
            System.out.println("6. Realizar un ataque indivudual");
            System.out.println("7. Iniciar Batalla Automatica (P1 vs P2)");
            System.out.println("8. Ver total de personajes creados");
            System.out.println("9. Salir");
            System.out.println("");
            System.out.print("Ingrese la opción a realizar: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch (opcion){
                case 1:
                    p1 = new Personaje();
                    System.out.println("Personaje 1 creado exitosamente.");
                    System.out.println("");
                    break;
                    
                case 2:
                    System.out.print("Ingrese nombre de personaje: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese Vida Maxima de personaje: ");
                    double vidaMax = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ingrese Puntos de Ataque de personaje: ");
                    double ataque = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ingrese Puntos de Defensa de personaje: ");
                    double defensa = sc.nextDouble();
                    sc.nextLine();
                    p2 = new Personaje(nombre, vidaMax, ataque, defensa);
                    System.out.println("Personaje 2 creado exitosamente.");
                    System.out.println("");
                    break;
                case 3:
                    if (p1 == null){
                        System.out.println("El personaje 1 aun no ha sido creado!");
                        System.out.println("");
                    } else {
                        System.out.println("--- PERSONAJE 1 ---");
                        p1.mostrarEstado();
                        p1.estaVivo();
                        System.out.println("");
                    }
                    
                    if (p2 == null){
                        System.out.println("El personaje 2 aun no ha sido creado!");
                        System.out.println("");
                    } else {
                        System.out.println("--- PERSONAJE 2 ---");
                        p2.mostrarEstado();
                        p2.estaVivo();
                        System.out.println("");
                    }
                    break;
                
                case 4:
                    System.out.print("Que personaje desea subir de nivel? (1 o 2): ");
                    int perNivel = sc.nextInt();
                    sc.nextLine();
                    if (perNivel == 1){
                        if (p1 == null){
                            System.out.println("El personaje 1 aun no ha sido creado!");
                            System.out.println("");
                        } else {
                            p1.subirNivel();
                            System.out.println("");
                        }
                    } else if (perNivel == 2){
                        if (p2 == null){
                            System.out.println("El personaje 2 aun no ha sido creado!");
                            System.out.println("");
                        } else {
                            p2.subirNivel();
                            System.out.println("");
                        }
                    }else{
                        System.out.println("La opción ingresada no es valida");
                        System.out.println("");
                    }
                    break;
                
                case 5:
                    System.out.print("Que personaje desea curar? (1 o 2): ");
                    int perCurar = sc.nextInt();
                    sc.nextLine();
                    if (perCurar == 1){
                        if (p1 == null){
                            System.out.println("El personaje 1 aun no ha sido creado!");
                            System.out.println("");
                        } else {
                            if (p1.estaVivo()){
                                p1.curar();
                                System.out.println("");
                            } else {
                                System.out.println("El personaje 1 ya no tiene vida");
                                System.out.println("");
                            }
                        }
                    } else if (perCurar == 2){
                        if (p2 == null){
                            System.out.println("El personaje 2 aun no ha sido creado!");
                            System.out.println("");
                        } else {
                            if (p2.estaVivo()){
                                p2.curar();
                                System.out.println("");
                            } else {
                                System.out.println("El personaje 2 ya no tiene vida");
                                System.out.println("");
                            }
                        }
                    }else{
                        System.out.println("La opción ingresada no es valida");
                        System.out.println("");
                    }
                    break;
                    
                case 6:
                    System.out.print("Que personaje desea atacar? (1 o 2): ");
                    int perAtaque = sc.nextInt();
                    sc.nextLine();
                    if (perAtaque == 1){
                        if (p1 == null){
                            System.out.println("El personaje 1 aun no ha sido creado!");
                            System.out.println("");
                        } else {
                            p1.atacar(p2);
                            System.out.println("");
                        }                     
                    } else if (perAtaque == 2){
                        if (p2 == null){
                            System.out.println("El personaje 2 aun no ha sido creado!");
                            System.out.println("");
                        } else {
                            p2.atacar(p1);
                            System.out.println("");
                        }
                    }else{
                        System.out.println("La opción ingresada no es valida");
                        System.out.println("");
                    }
                    break;
                    
                case 7:
                    if (p1 == null || p2 == null){
                        System.out.println("Ambos personajes deben estar creados para la batalla automatica.");
                        System.out.println("");
                    }else {
                        if (p1.estaVivo() && p2.estaVivo()){
                            Batalla.iniciarPeleaAutomatica(p1, p2);
                            System.out.println("");
                        }else{
                            System.out.println("Ambos personajes deben estar vivos para la batalla automatica.");
                            System.out.println("");
                        }
                    }
                    break;
                    
                case 8:
                    System.out.println("Total acumulado de personajes creados: " + Personaje.getTotalPersonajesCreados());
                    System.out.println("");
                    break;
                    
                case 9:
                    System.out.println("Saliendo del simulador");
                    break;
                    
                default:
                    System.out.println("Opción invalida");
                    System.out.println("");
                    
            }
        } while (opcion != 9);
    }    
}
