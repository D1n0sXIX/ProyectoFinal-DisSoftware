import clases.nivel_1.Party;
import clases.nivel_2.*;
import patrones.facade.RPGFacade;

public class Testing {
    public static void main(String[] args) {
        Party partyJugador = new Party("Manolo");
        partyJugador.addJugador(new Luchador());
        partyJugador.addJugador(new Apoyo());

        // Crear la party enemiga
        Party partyEnemiga = new Party("Pakito");
        partyEnemiga.addJugador(new Rango());
        partyEnemiga.addJugador(new Luchador());
        partyEnemiga.addJugador(new Apoyo());

        // Crear el juego y comenzar
        RPGFacade juego = new RPGFacade(partyJugador, partyEnemiga);
        juego.iniciarJuego();
    }
}
