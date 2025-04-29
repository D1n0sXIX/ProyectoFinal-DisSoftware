package patrones.state;

public class RondaConsumibles implements RondaState {
    private Ronda ronda;

    @Override
    public void setContexto(Ronda ronda) {
        this.ronda = ronda;
    }

    @Override
    public void ejecutarTurno() {
        System.out.println("Ronda 3: Se dan consumibles (pociones, bombas)");
        ronda.darItemATodos(TipoItem.POCION);
    }
}
