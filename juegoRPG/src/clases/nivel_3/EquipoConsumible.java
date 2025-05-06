package clases.nivel_3;

import clases.nivel_2.Jugador;
import enums.TipoItem;
import java.util.List;
import patrones.strategy.forItems.*;

public class EquipoConsumible extends Equipo{
    public EquipoConsumible(TipoItem tipo) {
        super(tipo.name(), calcularDanio(tipo), tipo);

        // Asignamos la estrategia según el tipo
        switch (tipo) {
            case POCION:
                this.estrategia = new SanacionStrategy(30, true); // cura a sí mismo
                break;
            case BOMBA:
                this.estrategia = new AtaqueStrategy(true); // ataque en área
                break;
        }
    }

    private static int calcularDanio(TipoItem tipo) {
        switch (tipo) {
            case POCION: return 0;  // cura, no hace daño
            case BOMBA: return 50;  // hace daño a todos
            default: return 0;
        }
    }

    @Override
    public void usar(Jugador personaje, List<Jugador> aliados, List<Jugador> enemigos) {
        if (estrategia != null) {
            estrategia.usarItem(personaje, aliados, enemigos);
        }
    }

    @Override
    public boolean esConsumible() {
        return true;
    }
}
