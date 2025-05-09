package clases.nivel_3;

import enums.TipoItem;
import patrones.strategy.forItems.AtaqueStrategy;
import patrones.strategy.forItems.MejorarArmaduraStrategy;
import patrones.strategy.forItems.SanacionStrategy;

public class EquipoConsumible extends Equipo {

    public EquipoConsumible(TipoItem tipo) {
        super(tipo.name(), calcularDanio(tipo), tipo);

        // Asignamos la estrategia según el tipo
        switch (tipo) {
            case ESPADA:
            case ARCO:
                this.estrategia = new AtaqueStrategy(false);  // Estrategia de ataque para espadas y arcos
                break;
            case BACULO:
                this.estrategia = new SanacionStrategy(25, false);  // Estrategia de sanación para báculos
                break;
            case ARMADURA:
                this.estrategia = new MejorarArmaduraStrategy();  // Estrategia de mejora de armadura
                break;

            case BOMBA:
                this.estrategia = new AtaqueStrategy(true);
            break;
        }
    }

    private static int calcularDanio(TipoItem tipo) {
        switch (tipo) {
            case ESPADA: return 20;
            case ARCO: return 30;
            case BACULO: return 0; // Cura, no daño
            case ARMADURA: return 0; // Da armadura, no daño
            case BOMBA: return 35;
            default: return 0;
        }
    }

    @Override
    public boolean esConsumible() {
        return false;
    }
}
