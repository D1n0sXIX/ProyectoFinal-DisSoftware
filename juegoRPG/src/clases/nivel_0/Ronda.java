package clases.nivel_0;

import clases.nivel_1.Party;
import clases.nivel_2.*;
import clases.nivel_3.*;
import enums.*;
import patrones.abstractFactory.*;
import patrones.factory.FabricaPersonajes;
import patrones.state.*;
import java.util.Scanner;
import java.util.List;
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
      System.out.println("\n========================================");
      System.out.printf("        \033[35mRONDA %d — Turno\033[0m %d%n", numeroRonda, turno);
      System.out.println("========================================\n");
      if (esTurnoJugador) {
        System.out.println("\n>>> TURNO: \033[32mTU PARTY\033[0m <<<");
        System.out.print("Es el turno de TU party!." + "-Turno: " + this.turno + "\n");
        for (Jugador jugador : partyJugador.getJugadores()) {
          System.out.println("\n--- Turno de: \033[32m" + jugador.getNombre() + "\033[0m ---");
          esTurnoDe(jugador);
          verificarEliminacion();
          if (partyEnemiga.isPartyEmpty()) break;
        }
        esTurnoJugador = false;
      } else {
        System.out.println("\n>>> TURNO: \033[35mPARTY ENEMIGA\033[0m <<<");
        System.out.println("Es el turno de la Party Enemiga." + "-Turno: " + this.turno);
        for (Jugador enemigo : partyEnemiga.getJugadores()) {
          System.out.println("\n--- Turno de: \033[35m" + enemigo.getNombre() + "\033[0m ---");
          turnoAleatorioEnemigo(enemigo);
          verificarEliminacion();
          if (partyJugador.isPartyEmpty()) break;
        }
        esTurnoJugador = true;
    }
      this.turno++;
      verificarEliminacion();
    }

    private void verificarEliminacion() {

      this.partyJugador.getJugadores().removeIf(j -> j.getVida() <= 0);
      this.partyEnemiga.getJugadores().removeIf(e -> e.getVida() <= 0);
      if (this.partyJugador.isPartyEmpty()) {
        System.out.println("\n💀 Has sido derrotado. ¡Game Over!");
        terminarJuego();
        return;
      }
      if (partyEnemiga.isPartyEmpty()) {
          if (this.numeroRonda >= 5) {
            System.out.println("\n🏆 ¡Enhorabuena! Has completado las 5 rondas y ganado la partida.");
              terminarJuego();
          } else {
              pasarSiguienteFase();
          }
      }
      else if (this.numeroRonda > 5) {
          terminarJuego();
      }
    }

    public void pasarSiguienteFase() {
      if (this.numeroRonda.equals(5)) {
          return;
      }
      this.turno = 0;
      esTurnoJugador = true;
      if (this.numeroRonda.equals(4)) {
        this.estadoActual = new CompletaState();
      } else if (this.estadoActual instanceof AtaqueState) {
        this.estadoActual = new CuracionState();
      } else if (this.estadoActual instanceof CuracionState) {
        this.estadoActual = new ConsumiblesState();
      } else if (this.estadoActual instanceof ConsumiblesState) {
        this.estadoActual = new CompletaState();
      }
      this.numeroRonda++;
      System.out.println("\n ---------- Pasando a la siguiente fase: Ronda ---------- " + this.numeroRonda);
      this.estadoActual.setContexto(this);
      this.estadoActual.ejecutarTurno();
      if (this.partyEnemiga.isPartyEmpty()) {
        System.out.println("---------- Generando enemigos... ---------- ");
        reiniciarPartyEnemiga();
      }
    }

    private void reiniciarPartyEnemiga() {
      partyEnemiga.getJugadores().clear();
      Jugador luchadorEnemigo = FabricaPersonajes.crearPersonaje(TipoPersonaje.LUCHADOR);
      luchadorEnemigo.setNombre("Luchador Enemigo");
      luchadorEnemigo.recibirObjeto(new EquipoConsumible(TipoItem.ESPADA));
      partyEnemiga.addJugador(luchadorEnemigo);
      Jugador rangoEnemigo = FabricaPersonajes.crearPersonaje(TipoPersonaje.RANGO);
      rangoEnemigo.setNombre("Rango Enemigo");
      rangoEnemigo.recibirObjeto(new EquipoConsumible(TipoItem.ARCO));
      partyEnemiga.addJugador(rangoEnemigo);
      Jugador apoyoEnemigo = FabricaPersonajes.crearPersonaje(TipoPersonaje.APOYO);
      apoyoEnemigo.setNombre("Apoyo Enemigo");
      apoyoEnemigo.recibirObjeto(new EquipoConsumible(TipoItem.BACULO));
      partyEnemiga.addJugador(apoyoEnemigo);
    }

    public boolean terminarJuego() {
      if (this.partyJugador.isPartyEmpty()) {
          return true;
      } else if(this.partyEnemiga.isPartyEmpty()){
          return true;
      }
      return false;
    }

    public Party getPartyEnemiga() {
        return partyEnemiga;
    }

    public Party getPartyJugador() {
        return partyJugador;
    }

    public void darObjetoA(Integer id, TipoItem tipo) {
        Equipo item = FabricaItems.crearItem(tipo);
        Jugador jugador = partyJugador.getJugadores().get(id);
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
        Integer opcion = null;
        do {
          System.out.println("\n--- ESTADO DE LOS JUGADORES ---");
          System.out.printf("%-30s %s%n", "Party Jugador", "Party Enemiga");
          int max = Math.max(partyJugador.getJugadores().size(), partyEnemiga.getJugadores().size());
          for (int i = 0; i < max; i++) {
              String izq = i < partyJugador.getJugadores().size()
                  ? partyJugador.getJugadores().get(i).getNombre() + " - HP: " + partyJugador.getJugadores().get(i).getVida()
                  : "";
              String der = i < partyEnemiga.getJugadores().size()
                  ? partyEnemiga.getJugadores().get(i).getNombre() + " - HP: " + partyEnemiga.getJugadores().get(i).getVida()
                  : "";
              System.out.printf("%-30s %s%n", izq, der);
          }
            System.out.println("\n1. Usar item  -  2. Cambiar objeto  -  3. Pasar turno  -  4. Listar objetos");
            if (escaner.hasNextInt()) {
                opcion = escaner.nextInt();
                if (escaner.hasNextLine()) {
                    escaner.nextLine();
                }

                if (opcion >= 1 && opcion <= 4) {
                    seleccionarAccion(opcion, jugador);
                } else {
                    System.out.println("Opción inválida. Por favor, ingresa un número entre 1 y 3.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                escaner.next();
            }
        } while (opcion == null || (opcion != 3 && opcion != 1));
    }



    private void turnoAleatorioEnemigo(Jugador enemigo) {
      Random random = new Random();
      int probabilidad = random.nextInt(100);
      if (probabilidad < 50) {
          System.out.println(enemigo.getNombre() + " ha pasado el turno.");
      } else {
          System.out.println(enemigo.getNombre() + " está atacando...");
          if (enemigo.getItems().size() > 0) {
              enemigo.usarObjeto(0, this.partyEnemiga, this.partyJugador);
          } else {
              System.out.println(enemigo.getNombre() + " no tiene ítems para usar.");
          }
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
          jugador.usarObjeto(0, this.partyJugador, this.partyEnemiga);
          break;
        case 2:
          cambiarObjeto(jugador);
          opcion = null;
          break;
        case 3:
          System.out.println(jugador.getNombre() + " ha pasado el turno.");
          break;
        case 4:
          listarObjetos(jugador);
          opcion = null;
          break;
        default:
          System.out.println("ERROR al estilo doro(eso no es válido)");
      }
    }

    private void listarObjetos(Jugador jugador) {
      List<Equipo> items = jugador.getItems();
      System.out.println("\n--- Objetos de " + jugador.getNombre() + " ---");
      if (items.isEmpty()) {
          System.out.println("No tienes ningún objeto.");
      } else {
          for (int i = 0; i < items.size(); i++) {
              Equipo item = items.get(i);
              if(i==0) {
                System.out.printf("**EQUIPADO** %s (Tipo: %s, Daño/Valor: %d)%n",
                                  item.getNombre(), item.getTipo(), item.getDanio());
              } else {
                System.out.printf("%d) %s (Tipo: %s, Daño/Valor: %d)%n",
                                  i, item.getNombre(), item.getTipo(), item.getDanio());
              }
          }
      }
    }
}
