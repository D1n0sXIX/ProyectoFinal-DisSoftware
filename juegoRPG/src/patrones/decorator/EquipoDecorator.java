package patrones.decorator;

import clases.nivel_2.Jugador;
import clases.nivel_3.Equipo;
import java.util.List;

public class EquipoDecorator extends Equipo {

    protected Equipo equipoDecorado; // El objeto Equipo que se va a decorar
    protected Jugador jugador; // El personaje que va a ser envuelto

    public EquipoDecorator(Jugador jugador, Equipo equipoDecorado) {
        super(equipoDecorado.getNombre(), equipoDecorado.getDanio(), equipoDecorado.getTipo());
        this.jugador = jugador;
        this.equipoDecorado = equipoDecorado;
    }

    @Override
    public String getNombre() {
        return equipoDecorado.getNombre(); // Delegamos al equipo decorado
    }

    @Override
    public int getDanio() {
        return equipoDecorado.getDanio();
    }

    @Override
    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
        equipoDecorado.usar(personaje, aliados, enemigos); // Delegamos el uso al equipo decorado
    }

    @Override
    public boolean esConsumible() {
        return equipoDecorado.esConsumible(); // Delegamos si el equipo es consumible o no
    }
}
