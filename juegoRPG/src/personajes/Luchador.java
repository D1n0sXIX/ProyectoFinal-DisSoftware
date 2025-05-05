package personajes;

public class Luchador extends Jugador {
    //las estadísticas en mayúscula son las por defecto.
    public static final Integer VIDA = 50;
    public static final String NOMBRE = "";
    public static final Integer ESTAMINA = 100;
    public static final Integer DANIO = 10;
    public static final Integer ARMADURA = 0;
    /*constructor
    quiero que aqui los parametros de vida, estamina, danio y armadura esten ya predefinidos por ser un luchador.
     */
    public Luchador(String nombre, Integer vida, Integer estamina, Integer danio, Integer armadura) {
        super(vida, nombre, estamina, danio, armadura);
    }
    public Luchador(){
        this(NOMBRE);
    }
    public Luchador(String nombre) {
        this(nombre, VIDA);
    }
    public Luchador(String nombre, Integer vida) {
        this(nombre, vida, ESTAMINA);
    }
    public Luchador(String nombre, Integer vida, Integer estamina) {
        this(nombre, vida, estamina, DANIO);
    }
    public Luchador(String nombre, Integer vida, Integer estamina, Integer danio) {
        this(nombre, vida, estamina, danio, ARMADURA);
    }

    @Override
    public void atacar() {

    }

    @Override
    public void curar() {

    }

    @Override
    public void usarObjeto() {

    }
}
