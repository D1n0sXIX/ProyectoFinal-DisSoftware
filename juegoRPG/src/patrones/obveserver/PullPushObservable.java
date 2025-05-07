package patrones.obveserver;

public interface PullPushObservable {
  void attach(PullPushObserver observer);
  void detach(PullPushObserver observer);
  void updateObservers();
}
