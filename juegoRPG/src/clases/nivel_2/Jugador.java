package clases.nivel_2;

import clases.nivel_1.Party;
import clases.nivel_3.Equipo;
import enums.TipoItem;
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
    public void usarObjeto(Integer idObjeto, Party partyAliada, Party partyEnemiga) {
    System.out.println("Se ha recogido bien");

    if (idObjeto >= 0 && idObjeto < items.size()) {
        Equipo equipo = items.get(idObjeto);  // Obtener el objeto por su ID

        // Verificamos si el ítem es de tipo ataque (por ejemplo, espada o arco)
        if (equipo.getTipo() == TipoItem.ESPADA || equipo.getTipo() == TipoItem.ARCO) {
            // Si es un ítem de ataque, usamos la estrategia de ataque
            System.out.println(this.nombre + " ha usado el ítem de ataque: " + equipo.getNombre());
            equipo.usar(this, null, partyEnemiga.getJugadores());  // Aplica el daño al enemigo seleccionado

            // Eliminar el objeto de la lista de items después de usarlo (si es no consumible)
            items.remove(idObjeto);
            System.out.println(this.nombre + " ha eliminado el ítem: " + equipo.getNombre());

        } else if (equipo.getTipo() == TipoItem.BACULO || equipo.getTipo() == TipoItem.ARMADURA) {
            // Si es un ítem de tipo curación o mejora de armadura
            System.out.println(this.nombre + " ha usado el ítem de curación o armadura: " + equipo.getNombre());
            equipo.usar(this, partyAliada.getJugadores(), null);  // En este caso no afecta a los enemigos, solo a los aliados o al propio jugador

        } else if (equipo.getTipo() == TipoItem.BOMBA || equipo.getTipo() == TipoItem.POCION) {
            // Si es un consumible
            System.out.println(this.nombre + " ha usado el consumible: " + equipo.getNombre());
            equipo.usar(this, partyAliada.getJugadores(), partyEnemiga.getJugadores());

            // Eliminar el objeto consumible después de usarlo (esto debería funcionar ahora)
            items.remove(idObjeto); // Eliminamos el consumible correctamente
            System.out.println(this.nombre + " ha eliminado el consumible: " + equipo.getNombre());
        }
        else {
            // Si el ítem no es un tipo de ataque o curación conocido
            System.out.println("ERROR: Tipo de ítem desconocido.");
        }
    } else {
        System.out.println("ERROR: No se encontró el objeto con ID: " + idObjeto);
    }
}




    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void recibirDanio(Integer cantidad) {
      int danioReducido = cantidad - this.armadura;
      int danioFinal = Math.max(danioReducido, 1);
      this.vida -= danioFinal;
      if (this.vida < 0) {
          this.vida = 0;
      }
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

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

}
