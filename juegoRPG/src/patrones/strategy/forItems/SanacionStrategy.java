package patrones.strategy.forItems;

import clases.nivel_2.Jugador;
import java.util.List;

public class SanacionStrategy implements usarItemStrategy{
    private final int cantidad;
    private final boolean curarseASiMismo;

    public SanacionStrategy(int cantidad, boolean curarseASiMismo) {
        this.cantidad = cantidad;
        this.curarseASiMismo = curarseASiMismo;
    }

    // Aqui haremos modificaciones respecto a como desarrollemos el tema de als partys y los observers
    @Override
    public void usarItem(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
      if (curarseASiMismo || aliados == null || aliados.isEmpty()) {
        personaje.recibirCuracion(cantidad);
        System.out.println(personaje.getNombre() + " se cura " + cantidad + " de vida.");
      } else {
        Jugador objetivo = aliados.get(0);
        objetivo.recibirCuracion(cantidad);
        System.out.println(personaje.getNombre() + " cura a "
            + objetivo.getNombre() + " con " + cantidad + " de vida.");
      }
    }
}
