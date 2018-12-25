package by.chebotar.bean;

import by.chebotar.interfaces.Observable;
import by.chebotar.interfaces.Observer;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Cube extends Shape implements Observable{

  private static long staticID = 0;
  private final String name;
  private final long ID;
  private Point point;
  private double edgeOfTheCube;
  private Set<Observer> observers = new LinkedHashSet<Observer>();


  public Cube(String name, Point point, double edgeOfTheCube) {
    this.name = name;
    ID = staticID;
    this.point = point;
    this.edgeOfTheCube = edgeOfTheCube;
    staticID++;
    notifyObserver();/////////////////////////////////
  }

  public Cube() {
    this("CubeWithoutName",new Point(0,0),0);
  }

  public String getName() {
    return name;
  }

  public long getID() {
    return ID;
  }

  public Point getPoint() {
    return point;
  }

  public double getEdge() {
    return edgeOfTheCube;
  }

  public void setEdge(double edgeOfTheCube) {
    this.edgeOfTheCube = edgeOfTheCube;
    notifyObserver();
  }

  @Override
  public String toString() {
    return getName()+" "+getID();
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null){
      return false;
    }
    Cube cube = (Cube) obj;
    if (!this.name.equals(cube.getName())){
      return false;
    } else if(this.ID != cube.getID()){
      return false;
    } else if(!this.point.equals(cube.getPoint())){
      return false;
    } else if(this.edgeOfTheCube != cube.edgeOfTheCube){
      return false;
    }
    return true;
  }

  public void addObserver(Observer observer) {
    this.observers.add(observer);
  }

  public void notifyObserver() {
    this.observers.forEach(observer->observer.update(this));
  }

  public void removeObserver(Observer observer) {
    this.observers.remove(observer);
  }
}
