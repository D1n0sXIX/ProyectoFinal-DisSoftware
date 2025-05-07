package patrones.obveserver;

import java.util.ArrayList;

import clases.nivel_2.Jugador;

public class JugadorAlarm implements PullPushObservable {
  private ArrayList<PullPushObserver> observers;
  private Jugador jugador;
  public JugadorAlarm() {
      this.observers = new ArrayList<>();
  }
  public void setJugador(Jugador jugador) {
      this.jugador = jugador;
      updateObservers();
  }
  public void attach(PullPushObserver observer) {
      observers.add(observer);
  }
  public void detach(PullPushObserver observer) {
      observers.remove(observer);
  }
  public void updateObservers() {
      for (PullPushObserver observer : observers) {
          observer.update(this, this.jugador);
      }
  }
}
