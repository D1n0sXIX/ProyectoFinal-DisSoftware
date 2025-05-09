package patrones.decorator;

import clases.nivel_2.Jugador;
import clases.nivel_3.Equipo;
import java.util.List;

public class EquipoDecorator extends Equipo {

    protected Equipo equipoDecorado;
    protected Jugador jugador;

    public EquipoDecorator(Jugador jugador, Equipo equipoDecorado) {
        super(equipoDecorado.getNombre(), equipoDecorado.getDanio(), equipoDecorado.getTipo());
        this.jugador = jugador;
        this.equipoDecorado = equipoDecorado;
    }

    @Override
    public String getNombre() {
        return equipoDecorado.getNombre();
    }

    @Override
    public int getDanio() {
        return equipoDecorado.getDanio();
    }

    @Override
    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
        equipoDecorado.usar(personaje, aliados, enemigos);
    }

    @Override
    public boolean esConsumible() {
        return equipoDecorado.esConsumible();
    }
}
