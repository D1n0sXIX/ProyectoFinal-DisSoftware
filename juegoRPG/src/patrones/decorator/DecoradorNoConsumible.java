package patrones.decorator;

import clases.nivel_3.Equipo;
import clases.nivel_2.Jugador;
import java.util.List;

public class DecoradorNoConsumible extends EquipoDecorator{

    public DecoradorNoConsumible(Jugador jugador, Equipo equipoDecorado) {
        super(jugador, equipoDecorado);

    }

    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos){
        switch(tipo){
            case ESPADA:
                System.out.println(personaje.getNombre() + "Toma por el culo tontito");
                this.estrategia.usarItem(personaje, aliados, enemigos);
                break;
            case BACULO:
                System.out.println("a " + personaje.getNombre() + " le han chupado el pito");
                this.estrategia.usarItem(personaje, aliados, enemigos);
                break;
            case ARCO:
                System.out.println(personaje.getNombre() + " ha cazado");
                this.estrategia.usarItem(personaje, aliados, enemigos);
                break;
            case ARMADURA:
                System.out.println("a " + personaje.getNombre() + ": Estoy mas blindado que el Wak en el chapan");
                this.estrategia.usarItem(personaje, aliados, enemigos);
                break;
        }
    }

    @Override
    public boolean esConsumible() {
        return false;
    }

}
