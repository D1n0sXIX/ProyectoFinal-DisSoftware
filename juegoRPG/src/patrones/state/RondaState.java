package patrones.state;

import clases.nivel_0.Ronda;

public interface RondaState {
    void setContexto(Ronda ronda);
    void ejecutarTurno();
}
