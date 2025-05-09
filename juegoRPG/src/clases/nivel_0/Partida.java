package clases.nivel_0;

import clases.nivel_1.Party;

public class Partida {
  private Party partyJugador;
  private Party partyEnemiga;
  private static Partida instancia;

  private Partida(Party partyJugador, Party partyEnemiga) {
      this.partyJugador = partyJugador;
      this.partyEnemiga = partyEnemiga;
  }

  public static Partida getInstance(Party partyJugador, Party partyEnemiga) {
    if (instancia == null) {
        instancia = new Partida(partyJugador, partyEnemiga);
    }
    return instancia;
  }

  public void iniciarJuego() {
    Ronda ronda = new Ronda(partyJugador, partyEnemiga);
    while (!partyJugador.isPartyEmpty() && ronda.getNumeroRonda() <= 5) {
        ronda.ejecutarTurno();
        if(ronda.getNumeroRonda() == 5) {
          if (ronda.terminarJuego()) {
            break;
          }
        }
    }
}

  public Party getPartyJugador() {
      return partyJugador;
  }

  public Party getPartyEnemiga() {
      return partyEnemiga;
  }

}
