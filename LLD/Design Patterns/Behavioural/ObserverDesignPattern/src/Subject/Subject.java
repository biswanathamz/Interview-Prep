package Subject;

import Observer.Observer;

public interface Subject {
    public void add(Observer observer);
    public void remove(Observer observer);
    public void notifyObservers(String weather);
}
