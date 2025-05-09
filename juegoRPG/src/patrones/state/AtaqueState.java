package patrones.state;
import clases.nivel_0.Ronda;
import enums.TipoItem;

public class AtaqueState implements RondaState{
  private Ronda ronda;

  public void setContexto(Ronda ronda) {
      this.ronda = ronda;
  }
  public void ejecutarTurno() {
    System.out.println("\n \033[34m**** Ronda 1(tutorial): -ATAQUE- ****\033[0m");
    ronda.darObjetoA(0, TipoItem.ESPADA);
    ronda.darObjetoA(1, TipoItem.ARCO);
  }
}
