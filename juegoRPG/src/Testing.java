import clases.nivel_1.Party;
import clases.nivel_2.*;
import patrones.facade.RPGFacade;

public class Testing {
    public static void main(String[] args) {
        RPGFacade juego = new RPGFacade();
        juego.iniciarJuego();
    }
}
