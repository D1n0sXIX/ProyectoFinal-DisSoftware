package patrones.decorator;

import clases.nivel_2.Jugador;
import clases.nivel_3.Equipo;
import java.util.List;
import patrones.strategy.forItems.AtaqueStrategy;
import patrones.strategy.forItems.MejorarArmaduraStrategy;
import patrones.strategy.forItems.SanacionStrategy;

public class DecoradorNoConsumible extends EquipoDecorator {

    public DecoradorNoConsumible(Jugador jugador, Equipo equipoDecorado) {
        super(jugador, equipoDecorado);
    }

    @Override
    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
        switch (tipo) {
            case ESPADA:
                System.out.println("\n" + personaje.getNombre() + " ha usado la espada y a tomar por culo tontito");
                new AtaqueStrategy(false).usarItem(personaje, aliados, enemigos);
                break;
            case BACULO:
                System.out.println("\n" + personaje.getNombre() + " ha usado el baculo y le han chupado el pito");
                new SanacionStrategy(25,false).usarItem(personaje, aliados, enemigos);
                break;
            case ARCO:
                System.out.println("\n" + personaje.getNombre() + " ha cazado cual Clax en la cafe (ah no xd)");
                new AtaqueStrategy(false).usarItem(personaje, aliados, enemigos);
                break;
            case ARMADURA:
                System.out.println("\n" + personaje.getNombre() + ": Estoy más blindado");
                new MejorarArmaduraStrategy().usarItem(personaje, aliados, enemigos);
                break;
        }
    }

    @Override
    public boolean esConsumible() {
        return false;
    }
}
