package patrones.factory;

import clases.nivel_2.*;
import enums.TipoPersonaje;


public class FabricaPersonajes {
    public static Jugador crearPersonaje(TipoPersonaje tipo) {
        Jugador personaje;
        switch(tipo) {
            case LUCHADOR:
                personaje = new Luchador();
                break;
            case RANGO:
                personaje = new Rango();
                break;
            case APOYO:
                personaje = new Apoyo();
                break;
            default:
                return null;
        }
        return personaje;
    }
}
