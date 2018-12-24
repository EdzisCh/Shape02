package by.chebotar.bean;

import by.chebotar.service.Observer;

public interface Observable {

  void addObserver(Observer observer);
  void notifyObserver();
  void removeObserver(Observer observer);
}
