package by.chebotar.dao;

import by.chebotar.bean.Shape;
import by.chebotar.service.entity.ShapeSquare;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {

  ShapeSquare shapeSquare = new ShapeSquare();

  public static  Warehouse INSTANCE = null;
  private static Map<Long, Double> square = new HashMap<Long, Double>();
  private static Map<Long, Double> volume = new HashMap<Long, Double>();
  private static Map<Long, Double> perimeter = new HashMap<Long, Double>();

  private Warehouse(){

  }

  public static Warehouse getInstance(){
    if(INSTANCE == null) {
      INSTANCE = new Warehouse();
    }
    return INSTANCE;
  }

  public Double getSquareByID(Long ID){
    return square.get(ID);
  }

  public void addShape(Shape shape){
    square.put(shape.getID(), shapeSquare.calculateOption(shape));
    volume.put(shape.getID(), shapeSquare.calculateOption(shape));///////////////////////
    perimeter.put(shape.getID(), shapeSquare.calculateOption(shape));
  }

  public void deleteShape(Long ID){
    square.remove(ID);
    volume.remove(ID);
    perimeter.remove(ID);
  }
}
