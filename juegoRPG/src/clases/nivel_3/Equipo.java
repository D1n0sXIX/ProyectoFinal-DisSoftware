package clases.nivel_3;

import clases.nivel_2.Jugador;
import enums.TipoItem;
import java.util.List;
import patrones.strategy.forItems.usarItemStrategy;

public abstract class Equipo implements EquipoInterface{
    protected String nombre;
    protected int danio;
    protected TipoItem tipo;
    protected usarItemStrategy estrategia;

    public Equipo(String nombre, int danio, TipoItem tipo) {
        this.nombre = nombre;
        this.danio = danio;
        this.tipo = tipo;
    }
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public int getDanio() {
        return danio;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setStrategia(usarItemStrategy estrategia){
        this.estrategia = estrategia;
    }

    @Override
    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
    if (estrategia != null) {
        estrategia.usarItem(personaje, aliados, enemigos);
    }
}


    public abstract boolean esConsumible(); // importante para el personaje
}
