package clases.nivel_2;

public class Rango extends Jugador{
    //las estadísticas en mayúscula son las por defecto.
    public static final Integer VIDA = 50;
    public static final String NOMBRE = "";
    public static final Integer ESTAMINA = 100;
    public static final Integer DANIO = 10;
    public static final Integer ARMADURA = 0;
    /*constructor
    quiero que aqui los parametros de vida, estamina, danio y armadura esten ya predefinidos por ser un luchador.
     */
    public Rango(String nombre, Integer vida, Integer estamina, Integer danio, Integer armadura) {
        super(vida, nombre, estamina, danio, armadura);
    }
    public Rango(){
        this(NOMBRE);
    }
    public Rango(String nombre) {
        this(nombre, VIDA);
    }
    public Rango(String nombre, Integer vida) {
        this(nombre, vida, ESTAMINA);
    }
    public Rango(String nombre, Integer vida, Integer estamina) {
        this(nombre, vida, estamina, DANIO);
    }
    public Rango(String nombre, Integer vida, Integer estamina, Integer danio) {
        this(nombre, vida, estamina, danio, ARMADURA);
    }

    @Override
    public void atacar(int cantidad) {

    }

    @Override
    public void curar(int cantidad) {

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
