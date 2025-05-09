package patrones.factory;

import clases.nivel_2.*;
import clases.nivel_3.*;
import enums.TipoPersonaje;
import enums.TipoItem;
import patrones.decorator.DecoradorNoConsumible;

public class FabricaPersonajes {
    public static Jugador crearPersonaje(TipoPersonaje tipo, TipoItem tipoItem) {
        Jugador personaje;

        // Crear el personaje según el tipo
        switch(tipo) {
            case LUCHADOR:
                personaje = new Luchador();  // Creamos un luchador
                break;
            case RANGO:
                personaje = new Rango();  // Creamos un rango
                break;
            case APOYO:
                personaje = new Apoyo();  // Creamos un apoyo
                break;
            default:
                return null;
        }

        // Crear el ítem según el tipo (esto puede ser consumible o no consumible)
        Equipo item = new EquipoConsumible(tipoItem);  // Creamos el ítem correspondiente (como ESPADA, BACULO, etc.)

        // Decoramos al personaje con el ítem (esto aplica el comportamiento del ítem al jugador)
        // Aquí se pasa el jugador y el ítem al decorador, no otro decorador
        DecoradorNoConsumible decorador = new DecoradorNoConsumible(personaje, item);  // Ahora pasamos el jugador y el ítem

        return personaje;  // Retornamos el decorador que envuelve al personaje
    }
}


