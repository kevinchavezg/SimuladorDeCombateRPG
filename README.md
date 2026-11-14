# Sistema de Combate RPG Interactivo en Java

Este proyecto es un simulador de combate por turnos en consola desarrollado en **Java**, diseñado para poner en práctica los fundamentos de la **Programación Orientada a Objetos (POO)**.

---


### Conceptos Aplicados
* **Clases y Objetos:** Modelado de entidades (`Personaje`) y clases de utilidad (`Batalla`).
* **Atributos de Instancia y de Clase:** Diferenciación entre el estado individual de cada objeto y las variables compartidas (`static`).
* **Constructores:** Sobrecarga mediante constructor predeterminado (sin parámetros) y constructor parametrizado.
* **Métodos de Instancia y Estáticos:** Encapsulamiento de comportamientos propios del personaje y utilidades globales de combate.
* **Control de Flujo y Validaciones:** Uso de estructuras condicionales (`if-else`, `switch`), ciclos (`do-while`, `while`).

---

## Estructura del Proyecto

El código fuente está organizado en tres archivos principales dentro del mismo paquete:

```text
├── Personaje.java   # Modelo de datos y lógica individual de cada combatiente
├── Batalla.java     # Clase de utilidad con métodos estáticos para mecánicas de combate
└── Main.java        # Punto de entrada de la aplicación y gestión del menú interactivo
```

---

## Arquitectura y Especificaciones Técnicas

### 1. `Personaje.java`
Representa a cada uno de los combatientes del sistema.

* **Atributos de Instancia:**
  * `nombre` (`String`): Identificador del personaje.
  * `puntosVida` (`double`): Salud actual en combate.
  * `puntosVidaMax` (`double`): Límite máximo de salud.
  * `puntosAtaque` (`double`): Capacidad ofensiva base.
  * `puntosDefensa` (`double`): Capacidad de mitigación de daño.
  * `nivel` (`int`): Nivel de experiencia del personaje.
* **Atributo Estático:**
  * `totalPersonajesCreados` (`int`): Contador global que registra cuántas instancias de `Personaje` se han creado durante la ejecución.
* **Constructores:**
  * `Personaje()`: Crea un *"Guerrero Novato"* con `100.0` de vida, `15.0` de ataque, `5.0` de defensa y nivel `1`.
  * `Personaje(String nombre, double puntosVidaMax, double puntosAtaque, double puntosDefensa)`: Crea un personaje personalizado a nivel `1` con su vida al máximo.
* **Métodos Principales:**
  * `atacar(Personaje objetivo)`: Calcula el daño ($\text{Ataque} - \text{Defensa}$, con un mínimo garantizado de `3.0`) y lo aplica al objetivo.
  * `recibirDano(double cantidad)`: Descuenta vida asegurando que nunca sea menor a `0.0`.
  * `curar()`: Restaura `25.0` puntos de vida sin exceder `puntosVidaMax`.
  * `estaVivo()`: Devuelve `true` si `puntosVida > 0.0`.
  * `subirNivel()`: Incrementa el nivel en `1`, mejora las estadísticas base (`+20.0` Vida Máx, `+5.0` Ataque, `+2.0` Defensa) y restaura toda la salud.
  * `mostrarEstado()`: Imprime la ficha técnica formateada en consola.
  * `getTotalPersonajesCreados()` *(estático)*: Retorna el total de instancias creadas.

### 2. `Batalla.java`
Clase de soporte con herramientas estáticas para gestionar enfrentamientos.

* `ejecutarAtaqueCritico(Personaje atacante, Personaje objetivo, double multiplicador)`: Multiplica el ataque base por el factor indicado, aplica *casting* explícito a `(int)` para redondear hacia abajo el daño resultante e inflige el golpe crítico al objetivo.
* `iniciarPeleaAutomatica(Personaje p1, Personaje p2)`: Ejecuta un bucle `while` donde `p1` y `p2` intercambian golpes por turnos hasta que uno de los dos cae derrotado, anunciando al ganador al finalizar.

### 3. `Main.java`
Gestiona la interfaz de usuario por consola mediante un ciclo `do-while` y mantiene las referencias `p1` y `p2` (inicializadas en `null`).

#### Opciones del Menú Interactivo:
1. **Crear Personaje 1:** Instancia `p1` usando el constructor predeterminado.
2. **Crear Personaje 2:** Solicita los datos por teclado e instancia `p2` usando el constructor parametrizado.
3. **Ver ficha técnica:** Muestra las estadísticas de `p1` y `p2` (advirtiendo si alguno aún es `null`).
4. **Subir de nivel:** Permite elegir entre `p1` o `p2` para evolucionar sus estadísticas.
5. **Curar personaje:** Permite elegir entre `p1` o `p2` para recuperar puntos de vida.
6. **Realizar ataque individual:** Permite ejecutar un ataque normal o crítico de un personaje hacia el otro, verificando si el objetivo es derrotado.
7. **Iniciar Batalla Automática:** Enfrenta a `p1` vs `p2` de forma automática si ambos existen y están con vida.
8. **Ver total de personajes creados:** Consulta el contador estático de la clase `Personaje`.
9. **Salir:** Termina la ejecución del programa.

---



## Ejemplo de Uso Rápido

1. Inicia el programa y selecciona la **Opción 1** para crear automáticamente a tu *Guerrero Novato* (`P1`).
2. Selecciona la **Opción 2** para crear un rival personalizado (`P2`), por ejemplo: *"Dragón Oscuro"*, Vida: `120`, Ataque: `18`, Defensa: `6`.
3. Selecciona la **Opción 3** para revisar la ficha técnica de ambos combatientes.
4. Selecciona la **Opción 7** para presenciar la batalla automática hasta que uno se alce con la victoria.
