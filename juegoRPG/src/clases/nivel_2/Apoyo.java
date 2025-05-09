package clases.nivel_2;

public class Apoyo extends Jugador {
    //las estadísticas en mayúscula son las por defecto.
    public static final Integer vida = 50;
    public static final String nombre = "Apoyo";
    public static final Integer armadura = 0;

    public Apoyo() {
    super(vida, nombre, armadura);
    }

    @Override
    public void usarObjeto(Integer idObjeto) {

    }
}
