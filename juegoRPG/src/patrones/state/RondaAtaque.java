public class RondaAtaque implements RondaState {
    private Ronda ronda;

    @Override
    public void setContexto(Ronda ronda) {
        this.ronda = ronda;
    }

    @Override
    public void ejecutarTurno() {
        System.out.println("Ronda 1: Solo se da ítem de ataque (Espada/Arco/Báculo)");
        ronda.darItemATodos(TipoItem.ESPADA); // o aleatorio entre armas de ataque
    }
}
