package clases.nivel_2;

import clases.nivel_1.Party;
import clases.nivel_3.Equipo;
import enums.TipoItem;
import patrones.decorator.DecoradorConsumible;
import patrones.decorator.DecoradorNoConsumible;
import java.util.ArrayList;
import java.util.List;

public abstract class Jugador implements JugadorInterface {
    private Integer vida;
    private String nombre;
    private Integer armadura;
    private List<Equipo> items;

    public Jugador(Integer vida, String nombre, Integer armadura) {
        this.vida = vida;
        this.nombre = nombre;
        this.armadura = armadura;
        this.items = new ArrayList<>();
    }

    @Override

    public void recibirObjeto(Equipo itemNuevo) {
      if (itemNuevo != null) {
        if (itemNuevo.getTipo() == TipoItem.ESPADA || itemNuevo.getTipo() == TipoItem.ARCO || itemNuevo.getTipo() == TipoItem.BACULO) {
            itemNuevo = new DecoradorNoConsumible(this, itemNuevo);
        } else if (itemNuevo.getTipo() == TipoItem.POCION || itemNuevo.getTipo() == TipoItem.BOMBA) {
            itemNuevo = new DecoradorConsumible(this, itemNuevo);
        }
        this.items.add(itemNuevo);
        System.out.println(this.nombre + " ha recibido el objeto: " + itemNuevo.getNombre());
      }
    }

    @Override
    public void usarObjeto(Integer idObjeto, Party partyAliada, Party partyEnemiga) {
      if (idObjeto >= 0 && idObjeto < items.size()) {
          Equipo equipo = items.get(idObjeto);
          if (equipo.getTipo() == TipoItem.ESPADA || equipo.getTipo() == TipoItem.ARCO) {
              equipo.usar(this, null, partyEnemiga.getJugadores());
          } else if (equipo.getTipo() == TipoItem.BACULO || equipo.getTipo() == TipoItem.ARMADURA) {
              equipo.usar(this, partyAliada.getJugadores(), null);
          } else if (equipo.getTipo() == TipoItem.BOMBA || equipo.getTipo() == TipoItem.POCION) {
              equipo.usar(this, partyAliada.getJugadores(), partyEnemiga.getJugadores());
              items.remove(0);
              System.out.println(this.nombre + " ha eliminado el consumible: " + equipo.getNombre());
          }
          else {
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
        return this.items;
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
