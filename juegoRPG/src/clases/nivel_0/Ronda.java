package clases.nivel_0;

import clases.nivel_1.Party;
import clases.nivel_2.*;
import clases.nivel_3.*;
import enums.*;
import patrones.abstractFactory.*;
import patrones.state.*;
import java.util.Scanner;
import java.util.Random;

public class Ronda {
    private RondaState estadoActual;
    private Party partyJugador;
    private Party partyEnemiga;
    private Integer turno;
    private Integer numeroRonda;
    private boolean esTurnoJugador;

    public Ronda(Party partyJugador, Party partyEnemiga) {
        this.partyJugador = partyJugador;
        this.partyEnemiga = partyEnemiga;
        this.turno = 0;
        this.numeroRonda = 1;
        this.estadoActual = new AtaqueState();
        this.estadoActual.setContexto(this);
        this.esTurnoJugador = true;
        this.estadoActual.ejecutarTurno();

    }

    public void ejecutarTurno() {
      if (esTurnoJugador) {
        System.out.print("Es el turno de TU party!." + "-Turno: " + this.turno + "\n");
        for (Jugador jugador : partyJugador.getJugadores()) {
            System.out.println("Turno de: " + jugador.getNombre());
            esTurnoDe(jugador);
        }
        esTurnoJugador = false;
      } else {
        System.out.println("Es el turno de la Party Enemiga." + "-Turno: " + this.turno);
        for (Jugador enemigo : partyEnemiga.getJugadores()) {
            System.out.println("Turno de: " + enemigo.getNombre());
            turnoAleatorioEnemigo(enemigo);
        }
        esTurnoJugador = true;
    }
      this.turno++;
      verificarEliminacion();
    }

    private void verificarEliminacion() {

        //voy a verificar que las partys esten muertas
        partyJugador.getJugadores().removeIf(jugador -> jugador.getVida() <= 0);
        partyEnemiga.getJugadores().removeIf(enemigo -> enemigo.getVida() <= 0);

        if (this.partyJugador.isPartyEmpty()) {
            System.out.println("La party del jugador ha sido eliminada.");
            terminarJuego();
        } else if (this.partyEnemiga.isPartyEmpty()) {
            System.out.println("La party enemiga ha sido eliminada.");
            pasarSiguienteFase();
        }
    }

    public void pasarSiguienteFase() {
      if (this.numeroRonda.equals(5)) {
          System.out.println("¡La batalla ha terminado! El juego ha finalizado.");
          return;
      }

      if (this.numeroRonda.equals(4)) {
        this.estadoActual = new CompletaState();
      } else if (this.estadoActual instanceof AtaqueState) {
        this.estadoActual = new CuracionState();
      } else if (this.estadoActual instanceof CuracionState) {
        this.estadoActual = new ConsumiblesState();
      } else if (this.estadoActual instanceof ConsumiblesState) {
        this.estadoActual = new CompletaState();
      }
      this.estadoActual.ejecutarTurno();
      this.numeroRonda++;
      this.estadoActual.setContexto(this);
      this.turno = 0;
      System.out.println("Pasando a la siguiente fase: Ronda " + this.numeroRonda);
      if (this.partyEnemiga.isPartyEmpty()) {
        System.out.println("Generando enemigos...");
        reiniciarPartyEnemiga();
      }
    }

    private void reiniciarPartyEnemiga() {
        partyEnemiga.getJugadores().clear();
        Luchador luchadorEnemigo = new Luchador();
        luchadorEnemigo.recibirObjeto(new EquipoConsumible(TipoItem.ESPADA));
        partyEnemiga.addJugador(luchadorEnemigo);

        Rango rangoEnemigo = new Rango();
        rangoEnemigo.recibirObjeto(new EquipoConsumible(TipoItem.ARCO));
        partyEnemiga.addJugador(rangoEnemigo);

        Apoyo apoyoEnemigo = new Apoyo();
        apoyoEnemigo.recibirObjeto(new EquipoConsumible(TipoItem.BACULO));
        partyEnemiga.addJugador(apoyoEnemigo);
    }


    public void terminarJuego() {
        System.out.println("¡Juego terminado! La *party* enemiga ha sido derrotada.");
    }

    public Party getPartyEnemiga() {
        return partyEnemiga;
    }

    public Party getPartyJugador() {
        return partyJugador;
    }

    public void darObjetoA(Integer id, TipoItem tipo) {
        // Crear el equipo según el tipo de objeto
        Equipo item = FabricaItems.crearItem(tipo);

        // Obtener el jugador correspondiente en la party por su ID
        Jugador jugador = partyJugador.getJugadores().get(id); // Obtener jugador de la party

        // El jugador recibe el objeto decorador
        jugador.recibirObjeto(item);

        System.out.println("Se ha dado el objeto: " + item.getNombre() + " a " + jugador.getNombre());
    }


    public int getTurno() {
        return turno;
    }
    public int getNumeroRonda() {
        return this.numeroRonda;
    }

    public void esTurnoDe(Jugador jugador) {
        Scanner escaner = new Scanner(System.in);  // Deja el Scanner abierto
        Integer opcion = null;

        // Bucle para garantizar que se ingrese una opción válida
        do {
            System.out.println("Estado de los jugadores:");

            // Imprimir la vida de los jugadores de la party del jugador
            System.out.println("Party del Jugador:");
            for (Jugador j : partyJugador.getJugadores()) {
                System.out.println(j.getNombre() + " - Vida: " + j.getVida());
            }

            // Imprimir la vida de los jugadores de la party enemiga
            System.out.println("Party Enemiga:");
            for (Jugador e : partyEnemiga.getJugadores()) {
                System.out.println(e.getNombre() + " - Vida: " + e.getVida());
            }

            System.out.println("1. Usar item  -  2. Cambiar objeto  -  3. Pasar turno");

            if (escaner.hasNextInt()) {  // Si la entrada es un número entero
                opcion = escaner.nextInt();  // Leer el número ingresado
                if (escaner.hasNextLine()) {
                    escaner.nextLine();  // Consumir la nueva línea sobrante
                }

                if (opcion >= 1 && opcion <= 3) {
                    // Validar que la opción esté entre 1 y 3
                    seleccionarAccion(opcion, jugador);  // Ejecutar la acción seleccionada
                } else {
                    System.out.println("Opción inválida. Por favor, ingresa un número entre 1 y 3.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                escaner.next();  // Descartar la entrada no válida
            }
        } while (opcion == null || opcion < 1 || opcion > 3);  // Repetir hasta que se ingrese una opción válida
        // No cerramos el scanner aquí, se cerrará cuando termine toda la interacción del programa
    }



    private void turnoAleatorioEnemigo(Jugador enemigo) {
        Random random = new Random();
        int accion = random.nextInt(3) + 1;

        if (enemigo.getItems().size() > 0) {
            System.out.println(enemigo.getNombre() + " está atacando...");
            enemigo.usarObjeto(0, partyJugador);
        } else {
            System.out.println(enemigo.getNombre() + " ha pasado el turno.");
        }
    }


    public void cambiarObjeto(Jugador jugador) {
        if (jugador.getItems().isEmpty()) {
            System.out.println(jugador.getNombre() + " no tiene ítems para cambiar.");
            return;
        }

        if (jugador.getItems().size() > 1) {
            Equipo primerItem = jugador.getItems().get(0);
            Equipo segundoItem = jugador.getItems().get(1);
            jugador.getItems().set(0, segundoItem);
            jugador.getItems().set(1, primerItem);
            System.out.println(jugador.getNombre() + " ha cambiado el objeto activo a " + jugador.getItems().get(0).getNombre());
        } else {
            System.out.println("No hay suficientes ítems para cambiar.");
        }
    }


    public void seleccionarAccion(Integer opcion, Jugador jugador) {
      switch (opcion) {
        case 1:
            jugador.usarObjeto(0, this.partyEnemiga);
          break;
        case 2:
          cambiarObjeto(jugador);
          break;
        case 3:
          System.out.println(jugador.getNombre() + " ha pasado el turno.");
          break;
        default:
          System.out.println("ERROR al estilo doro(eso no es válido)");
      }
    }
}
