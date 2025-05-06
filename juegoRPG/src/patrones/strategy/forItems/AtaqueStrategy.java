package patrones.strategy.forItems;

import clases.nivel_2.Jugador;
import java.util.List;

public class AtaqueStrategy implements usarItemStrategy{
    private final boolean atacarATodos;

    public AtaqueStrategy(boolean atacarATodos) {
        this.atacarATodos = atacarATodos;
    }

    @Override
    public void usarItem(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
        if (enemigos == null || enemigos.isEmpty()) return;

        if (atacarATodos) {
            for (Jugador enemigo : enemigos) {
                enemigo.recibirDanio(personaje.getDanio());
                System.out.println(personaje.getNombre() + " ataca a " + enemigo.getNombre() + " con ataque en area");
            }
        } else {
            Jugador objetivo = enemigos.get(0); // Aquí podrías usar selección más avanzada después -> segun hagamos las partys y observers
            objetivo.recibirDanio(personaje.getDanio());
            System.out.println(personaje.getNombre() + " ataca a " + objetivo.getNombre());
        }
    }
}
