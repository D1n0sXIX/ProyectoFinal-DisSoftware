package patrones.state;
import clases.nivel_0.Ronda;

public class CompletaState implements RondaState{
  private Ronda ronda;

  public void setContexto(Ronda ronda) {
      this.ronda = ronda;
  }
  public void ejecutarTurno() {
    System.out.println("\n \033[34m**** Ronda: -COMPLETA- ****\033[0m");
  }
}
