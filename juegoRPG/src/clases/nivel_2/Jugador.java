package clases.nivel_2;

import clases.nivel_3.Equipo;
import java.util.ArrayList;
import java.util.List;

public abstract class Jugador implements JugadorInterface {
    private Integer vida;
    private String nombre;
    private Integer armadura;
    private List<Equipo> items;  // Lista de objetos (decoradores) que el jugador tiene

    public Jugador(Integer vida, String nombre, Integer armadura) {
        this.vida = vida;
        this.nombre = nombre;
        this.armadura = armadura;
        this.items = new ArrayList<>();  // Aseguramos que la lista esté inicializada
    }

    @Override
    public void recibirObjeto(Equipo itemNuevo) {
        if (itemNuevo != null) {
            // Si el jugador ya tiene un equipo, lo decoramos con el nuevo objeto
            this.items.add(itemNuevo);  // Añadimos el nuevo equipo a la lista
            System.out.println(this.nombre + " ha recibido el objeto: " + itemNuevo.getNombre());
        }
    }

    @Override
    public void usarObjeto(Integer idObjeto) {
        if (idObjeto >= 0 && idObjeto < items.size()) {
            Equipo equipo = items.get(idObjeto);  // Obtenemos el objeto por su ID (índice)
            equipo.usar(this, null, null);  // Usamos el objeto (enviamos el jugador y sus aliados/enemigos si es necesario)
            System.out.println(this.nombre + " ha usado: " + equipo.getNombre());
        } else {
            System.out.println("ERROR: No se encontró el objeto");
        }
    }


    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void recibirDanio(Integer cantidad) {
        this.vida -= cantidad;  // Aplica el daño recibido
    }

    @Override
    public List<Equipo> getItems() {
        return this.items;  // Retorna la lista completa de ítems (decoradores)
    }

    @Override
    public void setArmadura(Integer cantidad){
        this.armadura = cantidad;
    }

    @Override
    public Integer getArmadura(){
        return this.armadura;
    }

    public Integer getVida() {
      return this.vida;
    }

    public void recibirCuracion(Integer cantidad) {
      this.vida += cantidad;
    }


}
