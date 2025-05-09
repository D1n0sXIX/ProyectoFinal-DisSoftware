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
    configurarParties();
    Ronda ronda = new Ronda(partyJugador, partyEnemiga);
    while (!partyJugador.isPartyEmpty()) {
        ronda.ejecutarTurno();
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

        // Agregar enemigos a la party enemiga con un ítem de ataque adecuado
        Luchador luchadorEnemigo = new Luchador();
        luchadorEnemigo.recibirObjeto(new EquipoNoConsumible(TipoItem.ESPADA)); // Asegúrate de asignar un ítem de ataque
        partyEnemiga.addJugador(luchadorEnemigo);

        Rango rangoEnemigo = new Rango();
        rangoEnemigo.recibirObjeto(new EquipoNoConsumible(TipoItem.ARCO)); // Asegúrate de asignar un ítem de ataque
        partyEnemiga.addJugador(rangoEnemigo);

        Apoyo apoyoEnemigo = new Apoyo();
        apoyoEnemigo.recibirObjeto(new EquipoNoConsumible(TipoItem.BACULO)); // Si es un apoyo, un báculo
        partyEnemiga.addJugador(apoyoEnemigo);
    }

}
