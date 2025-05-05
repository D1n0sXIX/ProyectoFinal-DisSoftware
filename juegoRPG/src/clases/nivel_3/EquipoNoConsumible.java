package clases.nivel_3;

import clases.nivel_2.enums.TipoItems;

public class EquipoNoConsumible extends Equipo{
    public EquipoNoConsumible(TipoItems tipo){
        super(tipo.name(), calcularDanio(tipo), tipo);
    }

    private static int calcularDanio(TipoItem tipo) {
        switch (tipo) {
            case ESPADA: return 20; // Hace 20 de daño
            case ARCO: return 30; // Hace 30 de Daño
            case BACULO: return 25; // Cura 25
            case ARMADURA: return 10; // Da 10 de armadura
        }
    }

    @Override
    public void usar() {
        switch (tipo) {
            case ESPADA:
                //System.out.println("Golpeas con la espada.");
                break;
            case ARCO:
                //System.out.println("Disparas con el arco.");
                break;
            case BACULO:
                //System.out.println("Lanzas magia con el báculo.");
                break;
            case ARMADURA:
                //System.out.println("Te proteges con la armadura.");
                break;
        }
    }

    @Override
    public boolean esConsumible() {
        return false;
    }
}
