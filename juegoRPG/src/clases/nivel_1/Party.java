package clases.nivel_1;

import clases.nivel_2.Jugador;
import java.util.ArrayList;
import java.util.List;
import patrones.obveserver.*;

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
          System.out.println("El jugador " + jugador.getNombre() + " no esta en " + nombre);
      }
  }
  public String getNombre() {
      return this.nombre;
  }
  public List<Jugador> getJugadores() {
      return this.jugadores;
  }

    public boolean isPartyEmpty() {
        return jugadores.isEmpty();
    }

    public void seleccionarJugadorAccion(int indice) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en la Party para realizar la acción.");
            return;
        }
        
        // Verificar si el índice está dentro de los límites de la lista
        if (indice < 0 || indice >= jugadores.size()) {
            System.out.println("Índice de jugador no válido.");
            return;
        }

        // Seleccionar al jugador basado en el índice proporcionado
        Jugador jugadorSeleccionado = jugadores.get(indice);

        System.out.println("El jugador seleccionado es: " + jugadorSeleccionado.getNombre());
        
        // Aquí podrías seleccionar un jugador aleatorio o el primero de la lista (por ejemplo)
        System.out.println("Es el turno de " + jugadorSeleccionado.getNombre());
        
        jugadorSeleccionado.usarObjeto();
    }
}
