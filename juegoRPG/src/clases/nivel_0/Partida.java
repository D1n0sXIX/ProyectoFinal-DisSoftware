package clases.nivel_0;

import clases.nivel_1.Party;

public class Partida {
  private Party partyJugador;
  private Party partyEnemiga;

  public Partida(Party partyJugador, Party partyEnemiga) {
      this.partyJugador = partyJugador;
      this.partyEnemiga = partyEnemiga;
  }

  public void iniciarJuego() {
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
}
