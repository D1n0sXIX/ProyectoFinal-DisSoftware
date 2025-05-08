package patrones.decorator;

import clases.nivel_3.Equipo;
import clases.nivel_2.Jugador;
import java.util.List;
import enums.TipoItem;
import patrones.strategy.forItems.AtaqueStrategy;
import patrones.strategy.forItems.SanacionStrategy;

public class EquipoConsumible extends EquipoDecorator{

    public EquipoConsumible(Jugador jugador, Equipo equipoDecorado) {
        super(jugador, equipoDecorado);

    }

    @Override
    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos){
        if(getTipo() == TipoItem.BOMBA){
            System.out.println(personaje.getNombre() + "ALLAH AKBAR");
            this.estrategia.usarItem(personaje, aliados, enemigos);
        }else if(getTipo() == TipoItem.POCION){
            System.out.println("a" + personaje.getNombre() + " le han chupado el pito");
            this.estrategia.usarItem(personaje, aliados, enemigos);

        }
    }

    @Override
    public boolean esConsumible() {
        return true;
    }
}
