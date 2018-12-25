package by.chebotar.dao;

import by.chebotar.bean.Shape;
import by.chebotar.service.option.ShapePerimeter;
import by.chebotar.service.option.ShapeSquare;
import by.chebotar.service.option.ShapeVolume;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Warehouse{

  public static  Warehouse INSTANCE = null;
  private static final Logger LOGGER = LogManager.getLogger(Warehouse.class);

  private ShapeSquare shapeSquare = new ShapeSquare();
  private ShapeVolume shapeVolume = new ShapeVolume();
  private ShapePerimeter shapePerimeter = new ShapePerimeter();
  private static Map<Long, Double> square = new HashMap<Long, Double>();
  private static Map<Long, Double> volume = new HashMap<Long, Double>();
  private static Map<Long, Double> perimeter = new HashMap<Long, Double>();

  private Warehouse(){

  }

  public static Warehouse getInstance(){
    if(INSTANCE == null) {
      synchronized (Warehouse.class) {
        if(INSTANCE == null) {
          INSTANCE = new Warehouse();
        }
      }
    }
    return INSTANCE;
  }

  public Double getSquareByID(Long ID){
    return square.get(ID);
  }

  public Double getVolumeByID(Long ID){
    return volume.get(ID);
  }

  public Double getPerimeterByID(Long ID){
    return perimeter.get(ID);
  }

  public void addShape(Shape shape){
    square.put(shape.getID(), shapeSquare.calculateOption(shape));
    volume.put(shape.getID(), shapeVolume.calculateOption(shape));
    perimeter.put(shape.getID(), shapePerimeter.calculateOption(shape));
  }

  public boolean deleteShape(Long ID){
    boolean flag = false;
    if (square.get(ID) != null && volume.get(ID) != null && perimeter.get(ID) != null) {
      square.remove(ID);
      volume.remove(ID);
      perimeter.remove(ID);
      flag = true;
    } else {
      LOGGER.warn("Try to delete shape that does not exist in Warehouse");
      flag = false;
    }
    return flag;
  }

  public Map<Long, Double> getAllSquares(){
    return square;
  }

  public Map<Long, Double> getAllVolumes(){
    return volume;
  }

  public Map<Long, Double> getAllPerimeters(){
    return perimeter;
  }

  public void changeSquare(Long ID, Double square){
    this.square.replace(ID,square);
  }

  public void changeVolume(Long ID, Double volume){
    this.volume.replace(ID,volume);
  }
  public void changePerimeter(Long ID, Double perimeter){
    this.perimeter.replace(ID,perimeter);
  }
}
