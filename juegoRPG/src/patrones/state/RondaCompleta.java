package patrones.state;

public class RondaCompleta implements RondaState {
    private Ronda ronda;

    @Override
    public void setContexto(Ronda ronda) {
        this.ronda = ronda;
    }

    @Override
    public void ejecutarTurno() {
        System.out.println("Ronda 4: Combate completo. Se da ítem aleatorio a cada personaje.");
        ronda.darItemsAleatoriosATodos();
    }
}
