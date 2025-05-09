package clases.nivel_0;

import clases.nivel_1.Party;
import clases.nivel_2.Apoyo;
import clases.nivel_2.Luchador;
import clases.nivel_2.Rango;

public class Partida {
  private Party partyJugador;
  private Party partyEnemiga;

  public Partida(Party partyJugador, Party partyEnemiga) {
      this.partyJugador = partyJugador;
      this.partyEnemiga = partyEnemiga;
  }

  public void iniciarJuego() {
    configurarParties();
    Ronda ronda = new Ronda(partyJugador, partyEnemiga);
    while (!partyJugador.isPartyEmpty()) {
        ronda.ejecutarTurno();
        if (partyEnemiga.isPartyEmpty()) {
            System.out.println("La party enemiga ha sido derrotada.");
            ronda.pasarSiguienteFase();
        }
        if (partyJugador.isPartyEmpty()) {
            System.out.println("La party del jugador ha sido derrotada. Fin del juego.");
            break;
        }
    }
    ronda.terminarJuego();
}

  public Party getPartyJugador() {
      return partyJugador;
  }

  public Party getPartyEnemiga() {
      return partyEnemiga;
  }

  private void configurarParties() {
        // Agregar jugadores a la party del jugador
        partyJugador.addJugador(new Luchador());
        partyJugador.addJugador(new Rango());
        partyJugador.addJugador(new Apoyo());

        // Agregar enemigos a la party enemiga
        partyEnemiga.addJugador(new Luchador());
        partyEnemiga.addJugador(new Rango());
        partyEnemiga.addJugador(new Apoyo());
    }
}
