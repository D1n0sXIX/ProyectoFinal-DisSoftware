package patrones.decorator;

import clases.nivel_3.Equipo;
import clases.nivel_2.Jugador;
import java.util.List;
//import patrones.strategy.forItems.AtaqueStrategy;
//import patrones.strategy.forItems.SanacionStrategy;

public class DecoradorConsumible extends EquipoDecorator{

    public DecoradorConsumible(Jugador jugador, Equipo equipoDecorado) {
        super(jugador, equipoDecorado);

    }

    @Override
    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos){

        switch(tipo){
            case BOMBA:
                System.out.println(personaje.getNombre() + ": ALLAH AKBAR");
                this.estrategia.usarItem(personaje, aliados, enemigos);
                break;
            case POCION:
                System.out.println(personaje.getNombre() + " se ha tomado una xela");
                this.estrategia.usarItem(personaje, aliados, enemigos);
                break;
        }
    }

    @Override
    public boolean esConsumible() {
        return true;
    }
}
