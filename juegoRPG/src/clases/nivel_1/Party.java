package clases.nivel_1;

import patrones.obveserver.*;
import clases.nivel_2.Jugador;
import java.util.List;
import java.util.ArrayList;

public class Party {
  private String nombre;
  private List<Jugador> jugadores;
  private JugadorAlarm jugadorAlarm;

  public Party(String nombre) {
    this.nombre = nombre;
    this.jugadores = new ArrayList<>();
    this.jugadorAlarm = new JugadorAlarm();
  }

  public void addJugador(Jugador jugador) {
    if (!jugadores.contains(jugador)) {
        jugadores.add(jugador);
        System.out.println("El jugador " + jugador.getNombre() + " ha sido añadido a " + nombre);
    } else {
        System.out.println("ERROR: El jugador " + jugador.getNombre() + " ya está en " + nombre);
    }
}
  public void removeJugador(Jugador jugador) {
      if (jugadores.contains(jugador)) {
          jugadores.remove(jugador);
          System.out.println("El jugador " + jugador.getNombre() + " ha sido removido de " + nombre);
      } else {
          System.out.println("El jugador " + jugador.getNombre() + " no está en " + nombre);
      }
  }
  public String getNombre() {
      return this.nombre;
  }
  public List<Jugador> getJugadores() {
      return this.jugadores;
  }
}
