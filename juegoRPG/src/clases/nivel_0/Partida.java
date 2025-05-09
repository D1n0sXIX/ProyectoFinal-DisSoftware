package clases.nivel_0;

import clases.nivel_1.Party;
import clases.nivel_2.Apoyo;
import clases.nivel_2.Luchador;
import clases.nivel_2.Rango;
import clases.nivel_3.EquipoNoConsumible;
import enums.TipoItem;

public class Partida {
  private Party partyJugador;
  private Party partyEnemiga;

  public Partida(Party partyJugador, Party partyEnemiga) {
      this.partyJugador = partyJugador;
      this.partyEnemiga = partyEnemiga;
  }

  public void iniciarJuego() {
    Ronda ronda = new Ronda(partyJugador, partyEnemiga);
    while (!partyJugador.isPartyEmpty() && ronda.getNumeroRonda() < 5) {
        ronda.ejecutarTurno();
    }
}

  public Party getPartyJugador() {
      return partyJugador;
  }

  public Party getPartyEnemiga() {
      return partyEnemiga;
  }

}
