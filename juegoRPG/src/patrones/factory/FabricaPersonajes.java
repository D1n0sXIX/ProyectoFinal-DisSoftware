package patrones.factory;

import clases.nivel_2.*;
import enums.TipoPersonaje;

public class FabricaPersonajes {
    public static Jugador crearPersonaje(TipoPersonaje tipo, String nombre){
        switch(tipo){
            case LUCHADOR:
                return new Luchador(nombre);
            case RANGO:
                return new Rango(nombre);
            case APOYO:
                return new Apoyo(nombre);
            default:
                return null;
        }
    }
}
