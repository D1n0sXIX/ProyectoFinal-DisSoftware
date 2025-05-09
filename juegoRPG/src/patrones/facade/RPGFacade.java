package patrones.facade;

import clases.nivel_0.*;
import clases.nivel_1.Party;
import clases.nivel_2.Apoyo;
import clases.nivel_2.Luchador;
import clases.nivel_2.Rango;
import clases.nivel_2.Jugador;

public class RPGFacade {
    private Ronda ronda;
    private Party partyJugador;
    private Party partyEnemiga;
    private Partida partida;

    public RPGFacade() {
      crearParties();
      this.partida = new Partida(this.partyJugador, this.partyEnemiga);
    }

    public void iniciarJuego() {
        this.partida.iniciarJuego();
    }

    private void crearParties() {
      this.partyJugador = new Party("Jugador Party");
      Jugador luchadorAliado = new Luchador();
      luchadorAliado.setNombre("Bárbaro Aliado");
      this.partyJugador.addJugador(luchadorAliado);
      Jugador rangoAliado = new Rango();
      rangoAliado.setNombre("Arquero Aliado");
      this.partyJugador.addJugador(rangoAliado);
      Jugador apoyoAliado = new Apoyo();
      apoyoAliado.setNombre("Sanador Aliado");
      this.partyJugador.addJugador(apoyoAliado);

      this.partyEnemiga = new Party("Enemigo Party");
      Jugador luchadorEnemigo = new Luchador();
      luchadorEnemigo.setNombre("Luchador Enemigo");
      this.partyEnemiga.addJugador(luchadorEnemigo);
      Jugador rangoEnemigo = new Rango();
      rangoEnemigo.setNombre("Tirador Enemigo");
      this.partyEnemiga.addJugador(rangoEnemigo);
      Jugador apoyoEnemigo = new Apoyo();
      apoyoEnemigo.setNombre("Curandero Enemigo");
      this.partyEnemiga.addJugador(apoyoEnemigo);
    }
}
