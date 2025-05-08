package patrones.decorator;

import clases.nivel_2.Jugador;
import clases.nivel_3.Equipo;
import java.util.List;
import patrones.strategy.forItems.AtaqueStrategy;
import patrones.strategy.forItems.MejorarArmaduraStrategy;

public class DecoradorNoConsumible extends EquipoDecorator {

    public DecoradorNoConsumible(Jugador jugador, Equipo equipoDecorado) {
        super(jugador, equipoDecorado);
    }

    @Override
    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
        switch (tipo) {
            case ESPADA:
                System.out.println(personaje.getNombre() + " Toma por el culo tontito");
                // Usamos la estrategia de ataque
                new AtaqueStrategy(false).usarItem(personaje, aliados, enemigos);
                break;
            case BACULO:
                System.out.println("a " + personaje.getNombre() + " le han chupado el pito");
                // Usamos la estrategia de ataque
                new AtaqueStrategy(false).usarItem(personaje, aliados, enemigos);
                break;
            case ARCO:
                System.out.println(personaje.getNombre() + " ha cazado");
                // Usamos la estrategia de ataque
                new AtaqueStrategy(false).usarItem(personaje, aliados, enemigos);
                break;
            case ARMADURA:
                System.out.println(personaje.getNombre() + ": Estoy más blindado");
                // Usamos la estrategia de mejorar armadura
                new MejorarArmaduraStrategy().usarItem(personaje, aliados, enemigos);
                break;
        }
    }

    @Override
    public boolean esConsumible() {
        return false;
    }
}
