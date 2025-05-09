package clases.nivel_2;

public class Luchador extends Jugador {
    //las estadísticas en mayúscula son las por defecto.
    public static final Integer vida = 100;
    public static final String nombre = "Luchador";
    public static final Integer armadura = 15;

    public Luchador() {
    super(vida, nombre, armadura);
}

    @Override
    public void usarObjeto(Integer idObjeto) {

    }
}
