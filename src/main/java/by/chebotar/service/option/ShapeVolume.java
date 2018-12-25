package by.chebotar.service.option;

import by.chebotar.bean.Cube;
import by.chebotar.bean.Shape;
import by.chebotar.dao.Warehouse;
import by.chebotar.interfaces.Observer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeVolume extends ShapeOption implements Observer {

  private static final Logger LOGGER = LogManager.getLogger(ShapeSquare.class);
  private static final Warehouse warehouse = Warehouse.getInstance();

  @Override
  public void update(Shape shape) {
    warehouse.changeVolume(shape.getID(),calculateOption(shape));
  }

  @Override
  public double calculateOption(Shape shape) {
    if (shape instanceof Cube){
      return Math.pow(shape.getEdge(),3);
    } else {
      LOGGER.warn("No operation realized for this type of Shape");
    }
    return -1;
  }
}
