package patrones.state;
import clases.nivel_0.Ronda;
import enums.TipoItem;

public class ConsumiblesState implements RondaState{
  private Ronda ronda;

  public void setContexto(Ronda ronda) {
      this.ronda = ronda;
  }
  public void ejecutarTurno() {
    System.out.println("Ronda 3(tutorial): -CONSUMIBLES-");
    ronda.darObjetoA(2, TipoItem.POCION);
    ronda.darObjetoA(1, TipoItem.BOMBA);
  }
}
