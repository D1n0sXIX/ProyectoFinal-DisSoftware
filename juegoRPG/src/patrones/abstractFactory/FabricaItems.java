package patrones.abstractFactory;
import clases.nivel_3.*;
import enums.TipoItems;

public class FabricaItems {
    public static Equipo crearItem(TipoItems tipo) {
        switch (tipo) {
            case POCION:
            case BOMBA:
                return new EquipoNoConsumible(tipo);
            case ESPADA:
            case ARCO:
            case BACULO:
            case ARMADURA:
                return new EquipoConsumible(tipo);
        }
    }
}

