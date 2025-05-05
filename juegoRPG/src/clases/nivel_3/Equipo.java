package clases.nivel_3;

import enums.TipoItems;

public abstract class Equipo {
    protected String nombre;
    protected int danio;
    protected TipoItem tipo;

    public Equipo(String nombre, int danio, TipoItem tipo) {
        this.nombre = nombre;
        this.danio = danio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDanio() {
        return danio;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public abstract void usar();

    public abstract boolean esConsumible(); // importante para el personaje
}

