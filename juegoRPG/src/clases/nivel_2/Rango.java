package clases.nivel_2;

public class Rango extends Jugador{
    //las estadísticas en mayúscula son las por defecto.
    public static final Integer vida = 75;
    public static final String nombre = "Rango";
    public static final Integer armadura = 10;
    
    public Rango() {
    super(vida, nombre, armadura);
    }

    @Override
    public void usarObjeto(Integer idObjeto) {

    }
}
