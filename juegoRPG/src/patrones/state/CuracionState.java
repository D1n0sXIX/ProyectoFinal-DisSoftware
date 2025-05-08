package patrones.state;
import clases.nivel_0.Ronda;
import enums.TipoItem;

public class CuracionState implements RondaState{
  private Ronda ronda;

  public void setContexto(Ronda ronda) {
      this.ronda = ronda;
  }
  public void ejecutarTurno() {
    System.out.println("Ronda 2(tutorial): -CURACIONES-");
    ronda.darObjetoA(2, TipoItem.BACULO);
    ronda.darObjetoA(0, TipoItem.ARMADURA);
  }
}
