package by.chebotar.bean;

import java.util.Objects;

public class Point {
  private double x;
  private double y;

  public Point(){
    this(0,0);
  }

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public int hashCode() {
    return Objects.hash();
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == null){
      return false;
    }
    Point point = (Point) obj;
    if(this.x != point.getX()){
      return false;
    } else if(this.y != point.getY()){
      return false;
    }
    return true;
  }
}
