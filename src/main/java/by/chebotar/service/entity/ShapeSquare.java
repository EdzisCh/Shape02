package by.chebotar.service.entity;

import by.chebotar.bean.Cube;
import by.chebotar.dao.ShapeDAOImpl;
import by.chebotar.service.Observer;
import by.chebotar.bean.Shape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeSquare extends ShapeOption implements Observer {

  private static final Logger LOGGER = LogManager.getLogger(ShapeSquare.class);
  private ShapeDAOImpl shapeDAO = ShapeDAOImpl.getINSTANCE();

  @Override
  public void update(Long ID) {

  }

  @Override
  public double calculateOption(Shape shape) {
    if (shape instanceof Cube){
      return shapeDAO.getEntityById(shape.getID()).getEdge()*shapeDAO.getEntityById(shape.getID()).getEdge();
    } else {

    }
    return -1;
  }
}
