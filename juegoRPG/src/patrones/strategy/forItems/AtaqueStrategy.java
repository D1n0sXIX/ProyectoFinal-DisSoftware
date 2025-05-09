package patrones.strategy.forItems;

import clases.nivel_2.Jugador;
import java.util.List;
import java.util.Random;

public class AtaqueStrategy implements usarItemStrategy {
    private final boolean atacarATodos;

    public AtaqueStrategy(boolean atacarATodos) {
        this.atacarATodos = atacarATodos;
    }

    @Override
    public void usarItem(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
        if (enemigos == null || enemigos.isEmpty()) return;

        // Obtener el daño del ítem (decorador) que está siendo usado por el jugador
        int danio = personaje.getItems().get(0).getDanio(); // El daño lo toma del primer ítem en la lista de items

        if (atacarATodos) {
            for (Jugador enemigo : enemigos) {
                enemigo.recibirDanio(danio);  // Aplica el daño
                System.out.println(personaje.getNombre() + " ataca a " + enemigo.getNombre() + " con ataque en área");
            }
        } else {
            Random rnd = new Random();
            int idx = rnd.nextInt(enemigos.size());
            Jugador objetivo = enemigos.get(idx);
            objetivo.recibirDanio(danio);
            System.out.println(personaje.getNombre() + " ataca a " + objetivo.getNombre());
        }
    }
}
