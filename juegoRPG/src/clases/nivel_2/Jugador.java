package clases.nivel_2;

public abstract class Jugador implements Personaje{
    private Integer vida = 50;
    private String nombre = "";
    private Integer estamina = 100;
    private Integer danio = 10;
    private Integer armadura = 0;

    public Jugador(Integer vida, String nombre, Integer estamina, Integer danio, Integer armadura) {
        this.vida = vida;
        this.nombre = nombre;
        this.estamina = estamina;
        this.danio = danio;
        this.armadura = armadura;
    }
}
