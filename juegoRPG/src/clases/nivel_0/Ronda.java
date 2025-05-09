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
      partyEnemiga.addJugador(new Luchador());
      partyEnemiga.addJugador(new Rango());
      partyEnemiga.addJugador(new Apoyo());
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
      Scanner escaner = new Scanner(System.in);
      Integer opcion;
      do {
        System.out.println("1. Usar item  -  2. Cambiar objeto  -  3. Pasar turno");
        opcion = escaner.nextInt();
        escaner.nextLine();
        seleccionarAccion(opcion, jugador);
      }while(opcion > 3 || opcion < 1);
      escaner.close();
    }

    private void turnoAleatorioEnemigo(Jugador enemigo) {
      Random random = new Random();
      int accion = random.nextInt(3) + 1;
      seleccionarAccion(accion, enemigo);
    }

    public void cambiarObjeto(Jugador jugador) {
      if (jugador.getItems().isEmpty()) {
        System.out.println(jugador.getNombre() + " no tiene ítems para cambiar. Eres tonto al estilo doro!");
        return;
      }

      if (jugador.getItems().size() > 1) {
        Equipo primerItem = jugador.getItems().get(0);
        Equipo segundoItem = jugador.getItems().get(1);
        jugador.getItems().set(0, segundoItem);
        jugador.getItems().set(1, primerItem);
        System.out.println(jugador.getNombre() + " ha cambiado el objeto activo a "+ jugador.getItems().get(0).getNombre());
      } else {
          System.out.println("No hay suficientes ítems para cambiar.");
      }
    }

    public void seleccionarAccion(Integer opcion, Jugador jugador) {
      switch (opcion) {
        case 1:
          jugador.usarObjeto(0);
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
