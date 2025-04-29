package clases.nivel_0;

import patrones.state.RondaState;

public class Ronda {
    private RondaState estado;
    private Party partyAliada;
    private Party partyEnemiga;
    private int numeroTurnos;

    public Ronda(Party partyAliada, Party partyEnemiga){
        this.partyAliada = partyAliada;
        this.partyEnemiga = partyEnemiga;
        this.numeroTurnos = 0;
    }

    public void cambiarEstado(RondaState nuevoEstado){
        this.estado = nuevoEstado;
        this.estado.setContexto(this);
    }

    public void ejecutarTurno() {
        estado.ejecutarTurno();
    }

    public void darItemATodos(TipoItem tipo) {
        partyAliada.darItemATodos(tipo);
        partyEnemiga.darItemATodos(tipo);
    }
    
    public void darItemsAleatoriosATodos() {
        partyAliada.darItemAleatorioATodos();
        partyEnemiga.darItemAleatorioATodos();
    }
    
}
