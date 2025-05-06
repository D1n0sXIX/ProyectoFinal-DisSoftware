package clases.nivel_3;

import clases.nivel_2.Jugador;
import enums.TipoItem;
import java.util.List;
import patrones.strategy.forItems.*;

public class EquipoNoConsumible extends Equipo {

    public EquipoNoConsumible(TipoItem tipo) {
        super(tipo.name(), calcularDanio(tipo), tipo);

        // Asignamos la estrategia según el tipo
        switch (tipo) {
            case ESPADA:
            case ARCO:
                this.estrategia = new AtaqueStrategy(false);
                break;
            case BACULO:
                this.estrategia = new SanacionStrategy(25, false);
                break;
            case ARMADURA:
                this.estrategia = new MejorarArmaduraStrategy();
                break;
        }
    }

    private static int calcularDanio(TipoItems tipo) {
        switch (tipo) {
            case ESPADA: return 20;
            case ARCO: return 30;
            case BACULO: return 0; // Cura, no daño
            case ARMADURA: return 0; // Da armadura, no daño
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
        return false;
    }
}
