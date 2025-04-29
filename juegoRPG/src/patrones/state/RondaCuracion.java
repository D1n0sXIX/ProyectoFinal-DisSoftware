package patrones.state;

public class RondaCuracion implements RondaState {
    private Ronda ronda;

    @Override
    public void setContexto(Ronda ronda) {
        this.ronda = ronda;
    }

    @Override
    public void ejecutarTurno() {
        System.out.println("Ronda 2: Se da ítem que permite curar");
        ronda.darItemATodos(TipoItem.BACULO); // o uno que permita curar
    }
}
