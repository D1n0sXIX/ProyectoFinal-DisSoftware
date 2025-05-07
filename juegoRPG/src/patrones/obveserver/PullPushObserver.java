package patrones.obveserver;

public interface PullPushObserver {
  public void update(PullPushObservable observable, Object object);
}
