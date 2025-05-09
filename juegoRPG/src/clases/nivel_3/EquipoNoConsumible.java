package clases.nivel_3;

import enums.TipoItem;
import patrones.strategy.forItems.SanacionStrategy;

public class EquipoNoConsumible extends Equipo {

    public EquipoNoConsumible(TipoItem tipo) {
        super(tipo.name(), calcularDanio(tipo), tipo);
        switch (tipo) {
            case POCION:
                this.estrategia = new SanacionStrategy(25, true);
                break;
        }
    }

    private static int calcularDanio(TipoItem tipo) {
        switch (tipo) {
            case POCION: return 0;
            default: return 0;
        }
    }

    @Override
    public boolean esConsumible() {
        return false;
    }
}
