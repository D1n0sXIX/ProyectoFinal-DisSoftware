package patrones.abstractFactory;
import clases.nivel_3.*;
import enums.TipoItem;

public class FabricaItems {
    public static Equipo crearItem(TipoItem tipo) {
        switch (tipo) {
            case POCION:
            case BOMBA:
                return new EquipoConsumible(tipo);
            case ESPADA:
            case ARCO:
            case BACULO:
            case ARMADURA:
                return new EquipoConsumible(tipo);
            
            default: return null;
        }
    }
}

