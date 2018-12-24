package by.chebotar.service.entity;

import by.chebotar.bean.Cube;
import by.chebotar.dao.Warehouse;
import by.chebotar.service.Observer;
import by.chebotar.bean.Shape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeSquare extends ShapeOption implements Observer {

  private static final Logger LOGGER = LogManager.getLogger(ShapeSquare.class);
  private static final Warehouse warehouse = Warehouse.getInstance();

  @Override
  public void update(Shape shape) {
     warehouse.changeSquare(shape.getID(),calculateOption(shape));
  }

  @Override
  public double calculateOption(Shape shape) {
    if (shape instanceof Cube){
      return Math.pow(shape.getEdge(),2);
    } else {
      LOGGER.warn("No operation realized for this type of Shape");
    }
    return -1;
  }
}
