package by.chebotar.bean;

import by.chebotar.interfaces.Observable;

public abstract class Shape implements Observable{
  private String name;
  private long ID;
  private Point xPoint;
  private Point yPoint;
  private double edge;

  public long getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public double getEdge() {
    return edge;
  }

  public abstract void setEdge(double edge);
}
