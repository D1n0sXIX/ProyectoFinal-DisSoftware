package patrones.strategy.forItems;

import clases.nivel_2.Jugador;
import java.util.List;

public interface usarItemStrategy {
    void usarItem(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos);
}
