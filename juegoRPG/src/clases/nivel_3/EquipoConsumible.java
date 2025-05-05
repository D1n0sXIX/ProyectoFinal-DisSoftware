package clases.nivel_3;

import enums.TipoItems;

public class EquipoConsumible extends Equipo{
    public EquipoConsumible(TipoItems tipo){
        super(tipo.name(), calcularDanio(tipo), tipo);
    }

    private static int calcularDanio(TipoItems tipo){
        switch (tipo) {
            case POCION: return 0;
            case BOMBA: return 50;
        }
    }

    @Override
    public void usar() {
        switch (tipo) {
            case POCION:
                //System.out.println("Usas una poción y te curas.");
                break;
            case BOMBA:
                //System.out.println("Lanzas una bomba. BOOM.");
                break;
        }
    }

    @Override
    public boolean esConsumible(){
        return true;
    }
}
