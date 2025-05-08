package clases.nivel_0;

import clases.nivel_1.Party;
import clases.nivel_2.*;
import clases.nivel_3.*;
import enums.*;
import patrones.abstractFactory.*;
import patrones.state.*;
public class Ronda {
    private RondaState estadoActual;
    private Party partyJugador;
    private Party partyEnemiga;
    private Integer turno;
    private Integer numeroRonda;

    public Ronda(Party partyJugador, Party partyEnemiga) {
        this.partyJugador = partyJugador;
        this.partyEnemiga = partyEnemiga;
        this.turno = 0;
        this.numeroRonda = 1;
        this.estadoActual = new AtaqueState();
        this.estadoActual.setContexto(this);
    }

    public void ejecutarTurno() {
        this.estadoActual.ejecutarTurno();
        this.turno++;
        verificarEliminacion();
    }
    private void verificarEliminacion() {
        if (this.partyJugador.isPartyEmpty()) {
            System.out.println("La party del jugador ha sido eliminada.");
            terminarJuego();
        } else if (this.partyEnemiga.isPartyEmpty()) {
            System.out.println("La party enemiga ha sido eliminada.");
            pasarSiguienteFase();
        }
    }

    public void pasarSiguienteFase() {
        if (this.numeroRonda.equals(5)) {
            System.out.println("¡La batalla ha terminado! El juego ha finalizado.");
            return;
        }

        if (this.numeroRonda.equals(4)) {
            this.estadoActual = new CompletaState();
        } else if (this.estadoActual instanceof AtaqueState) {
            this.estadoActual = new CuracionState();
        } else if (this.estadoActual instanceof CuracionState) {
            this.estadoActual = new ConsumiblesState();
        } else if (this.estadoActual instanceof ConsumiblesState) {
            this.estadoActual = new CompletaState();
        }
        this.numeroRonda++;
        this.estadoActual.setContexto(this);
        System.out.println("Pasando a la siguiente fase: Ronda " + this.numeroRonda);
    }

    public void terminarJuego() {
        System.out.println("¡Juego terminado! La *party* enemiga ha sido derrotada.");
    }

    public Party getPartyEnemiga() {
        return partyEnemiga;
    }

    public Party getPartyJugador() {
        return partyJugador;
    }

    public void darObjetoA(Integer id, TipoItem tipo) {
        // Crear el equipo según el tipo de objeto
        Equipo item = FabricaItems.crearItem(tipo);
    
        // Obtener el jugador correspondiente en la party por su ID
        Jugador jugador = partyJugador.getJugadores().get(id); // Obtener jugador de la party
    
        // El jugador recibe el objeto decorador
        jugador.recibirObjeto(item);
    
        System.out.println("Se ha dado el objeto: " + item.getNombre() + " a " + jugador.getNombre());
    }
    
    
    public int getTurno() {
        return turno;
    }
    public int getNumeroRonda() {
        return this.numeroRonda;
    }
}
