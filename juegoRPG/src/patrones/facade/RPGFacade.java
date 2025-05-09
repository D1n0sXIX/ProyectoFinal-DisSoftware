package patrones.facade;

import clases.nivel_0.*;
import clases.nivel_1.Party;
import enums.TipoPersonaje;
import patrones.factory.FabricaPersonajes;
import clases.nivel_2.Jugador;

public class RPGFacade {
    private Ronda ronda;
    private Party partyJugador;
    private Party partyEnemiga;
    private Partida partida;

    public RPGFacade() {
      crearParties();
      this.partida = Partida.getInstance(partyJugador, partyEnemiga);
    }

    public void iniciarJuego() {
        this.partida.iniciarJuego();
    }

    private void crearParties() {
      this.partyJugador = new Party("Jugador Party");
      Jugador luchadorAliado = FabricaPersonajes.crearPersonaje(TipoPersonaje.LUCHADOR);
      luchadorAliado.setNombre("Bárbaro Aliado");
      this.partyJugador.addJugador(luchadorAliado);
      Jugador rangoAliado = FabricaPersonajes.crearPersonaje(TipoPersonaje.RANGO);
      rangoAliado.setNombre("Arquero Aliado");
      this.partyJugador.addJugador(rangoAliado);
      Jugador apoyoAliado = FabricaPersonajes.crearPersonaje(TipoPersonaje.APOYO);
      apoyoAliado.setNombre("Sanador Aliado");
      this.partyJugador.addJugador(apoyoAliado);
      this.partyEnemiga = new Party("Enemigo Party");
      Jugador luchadorEnemigo = FabricaPersonajes.crearPersonaje(TipoPersonaje.LUCHADOR);
      luchadorEnemigo.setNombre("Luchador Enemigo");
      this.partyEnemiga.addJugador(luchadorEnemigo);
      Jugador rangoEnemigo = FabricaPersonajes.crearPersonaje(TipoPersonaje.RANGO);
      rangoEnemigo.setNombre("Tirador Enemigo");
      this.partyEnemiga.addJugador(rangoEnemigo);
      Jugador apoyoEnemigo = FabricaPersonajes.crearPersonaje(TipoPersonaje.APOYO);
      apoyoEnemigo.setNombre("Curandero Enemigo");
      this.partyEnemiga.addJugador(apoyoEnemigo);
    }
}
