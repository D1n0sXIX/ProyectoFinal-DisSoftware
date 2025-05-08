package clases.nivel_2;
import clases.nivel_3.Equipo;
import java.util.List;

public interface JugadorInterface {
    String getNombre();
    void recibirDanio(int catidad);
    void recibirObjeto(Equipo equipo);
    void usarObjeto(Integer idObjeto);
    public List<Equipo> getItems();
    public void setArmadura(Integer cantidad);
    public Integer getArmadura();
}
