package by.chebotar.interfaces;

import by.chebotar.interfaces.Observer;

public interface Observable {

  void addObserver(Observer observer);
  void notifyObserver();
  void removeObserver(Observer observer);
}
