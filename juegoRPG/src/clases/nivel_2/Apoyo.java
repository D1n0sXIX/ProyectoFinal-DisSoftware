package clases.nivel_2;

public class Apoyo extends Jugador {
    //las estadísticas en mayúscula son las por defecto.
    public static final Integer VIDA = 50;
    public static final String NOMBRE = "";
    public static final Integer ESTAMINA = 100;
    public static final Integer DANIO = 10;
    public static final Integer ARMADURA = 0;
    /*constructor
    quiero que aqui los parametros de vida, estamina, danio y armadura esten ya predefinidos por ser un luchador.
     */
    public Apoyo(String nombre, Integer vida, Integer estamina, Integer danio, Integer armadura) {
        super(vida, nombre, estamina, danio, armadura);
    }
    public Apoyo(){
        this(NOMBRE);
    }
    public Apoyo(String nombre) {
        this(nombre, VIDA);
    }
    public Apoyo(String nombre, Integer vida) {
        this(nombre, vida, ESTAMINA);
    }
    public Apoyo(String nombre, Integer vida, Integer estamina) {
        this(nombre, vida, estamina, DANIO);
    }
    public Apoyo(String nombre, Integer vida, Integer estamina, Integer danio) {
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

    @Override
    public String getNombre() {
        return "";
    }

    @Override
    public void subirArmadura(int cantidad) {

    }

    @Override
    public int getDanio() {
        return 0;
    }

    @Override
    public void recibirDanio(int catidad) {

    }
}
