package clases.nivel_3;

import clases.nivel_2.Jugador;
import java.util.List;

public interface EquipoInterface {
    String getNombre();
    int getDanio();
    void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos);
    boolean esConsumible();
}
