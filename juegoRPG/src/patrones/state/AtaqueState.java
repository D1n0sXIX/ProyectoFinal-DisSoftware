package patrones.state;
import clases.nivel_0.Ronda;
import enums.TipoItem;

public class AtaqueState implements RondaState{
  private Ronda ronda;

  public void setContexto(Ronda ronda) {
      this.ronda = ronda;
  }
  public void ejecutarTurno() {
    System.out.println("Ronda 1(tutorial): -ATAQUE-");
    ronda.darObjetoA(0, TipoItem.ESPADA);
    ronda.darObjetoA(1, TipoItem.ARCO);
  }
}
