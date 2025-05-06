package patrones.abstractFactory;
<<<<<<< Updated upstream
=======
import clases.nivel_3.*;
import enums.TipoItem;
>>>>>>> Stashed changes

public class FabricaItems {
    public static Equipo crearItem(TipoItem tipo) {
        switch (tipo) {
            case POCION:
            case BOMBA:
                return new ItemConsumible(tipo);
            case ESPADA:
            case ARCO:
            case BACULO:
            case ARMADURA:
<<<<<<< Updated upstream
                return new ItemNoConsumible(tipo);
=======
                return new EquipoConsumible(tipo);
            
            default: return null;
>>>>>>> Stashed changes
        }
    }
}

