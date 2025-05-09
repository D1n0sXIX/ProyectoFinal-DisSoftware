package patrones.state;
import clases.nivel_0.Ronda;
import enums.TipoItem;

public class ConsumiblesState implements RondaState {
    private Ronda ronda;

    public void setContexto(Ronda ronda) {
        this.ronda = ronda;
    }

    public void ejecutarTurno() {
      System.out.println("\n \033[34m**** Ronda 3(tutorial): -CONSUMIBLES- ****\033[0m");
        if (ronda.getPartyJugador().getJugadores().size() > 1 && ronda.getPartyJugador().getJugadores().get(1).getVida() > 0) {
            ronda.darObjetoA(1, TipoItem.BOMBA);
            System.out.println("Se ha dado la BOMBA");
        } else {
            System.out.println("El Arquero está muerto o no existe, no se le puede dar la BOMBA.");
        }
        if (ronda.getPartyJugador().getJugadores().size() > 2 && ronda.getPartyJugador().getJugadores().get(2).getVida() > 0) {
            ronda.darObjetoA(2, TipoItem.POCION);
            System.out.println("Se ha dado la POCION");
        } else {
            System.out.println("El Sanador está muerto o no existe, no se le puede dar la POCION.");
        }
    }
}
