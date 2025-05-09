package patrones.facade;

import clases.nivel_0.Ronda;
import clases.nivel_1.Party;

public class RPGFacade {
    private Ronda ronda;

    public RPGFacade(Party partyJugador, Party partyEnemiga) {
        this.ronda = new Ronda(partyJugador, partyEnemiga);
    }

    public void iniciarJuego() {
        while (!ronda.getPartyJugador().isPartyEmpty() && !ronda.getPartyEnemiga().isPartyEmpty()) {
            ronda.ejecutarTurno();
        }
    }
}
