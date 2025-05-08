package patrones.state;
import clases.nivel_0.Ronda;

public class CompletaState implements RondaState{
  private Ronda ronda;

  public void setContexto(Ronda ronda) {
      this.ronda = ronda;
  }
  public void ejecutarTurno() {
    System.out.println("Ronda: -COMPLETA-");
  }
}
