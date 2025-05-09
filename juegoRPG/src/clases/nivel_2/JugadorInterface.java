package clases.nivel_2;
import clases.nivel_1.Party;
import clases.nivel_3.Equipo;
import java.util.List;

public interface JugadorInterface {
    void usarObjeto(Integer idObjeto,Party partyAliada, Party partyEnemiga);

    String getNombre();
    void recibirDanio(Integer catidad);
    void recibirObjeto(Equipo equipo);
    void usarObjeto(Integer idObjeto);
    public List<Equipo> getItems();
    public void setArmadura(Integer cantidad);
    public Integer getArmadura();
    public void recibirCuracion(Integer cantidad);
    public Integer getVida();
    public void setNombre(String nombre);
}
