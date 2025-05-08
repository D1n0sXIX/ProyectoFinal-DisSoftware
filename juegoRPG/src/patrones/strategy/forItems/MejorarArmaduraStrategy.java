package patrones.strategy.forItems;

import clases.nivel_2.Jugador;
import java.util.List;

public class MejorarArmaduraStrategy implements usarItemStrategy{
    @Override
    public void usarItem(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
        if (!aliados.isEmpty()) {
            Jugador aliado = aliados.get(0);
            personaje.setArmadura(personaje.getArmadura() + personaje.getItems().get(0).getDanio());
            System.out.println(personaje.getNombre() + " mejora la armadura de " + aliado.getNombre());
        }
    }

}
