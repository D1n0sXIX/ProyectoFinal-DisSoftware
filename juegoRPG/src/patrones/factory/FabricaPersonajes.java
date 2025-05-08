package patrones.factory;

import clases.nivel_2.*;
import enums.TipoPersonaje;

public class FabricaPersonajes {
    public static Jugador crearPersonaje(TipoPersonaje tipo){
        switch(tipo){
            case LUCHADOR:
                return new Luchador();
            case RANGO:
                return new Rango();
            case APOYO:
                return new Apoyo();
            default:
                return null;
        }
    }
}
