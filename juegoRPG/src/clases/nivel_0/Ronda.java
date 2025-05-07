package clases.nivel_0;

import enums.TipoRonda;
import patrones.state.RondaState;

public class Ronda {
  private TipoRonda tipoRonda;
  private RondaState estado;

  public Ronda() {

  }
  public void ejecutar() {
    this.estado.ejecutarTurno();
  }
  public TipoRonda getTipoRonda() {
      return this.tipoRonda;
  }
  public RondaState getEstado() {
      return estado;
  }
}
