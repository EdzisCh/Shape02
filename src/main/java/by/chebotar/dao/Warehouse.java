package by.chebotar.dao;

import by.chebotar.bean.Shape;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {

  public static  Warehouse INSTANCE = null;
  private static Map<Long, Double> square = new HashMap<Long, Double>();
  private static Map<Long, Double> volume = new HashMap<Long, Double>();
  private static Map<Long, Double> perimetr = new HashMap<Long, Double>();

  private Warehouse(){

  }

  public static Warehouse getInstance(){
    if(INSTANCE == null) {
      INSTANCE = new Warehouse();
    }
    return INSTANCE;
  }

  public Shape getByOption(Double value){
    throw new UnsupportedOperationException();
  }

  public double addShape(Shape shape){
    throw new UnsupportedOperationException();
  }
}
