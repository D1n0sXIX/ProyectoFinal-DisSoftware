package patrones.abstractFactory;

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
                return new ItemNoConsumible(tipo);
        }
    }
}

