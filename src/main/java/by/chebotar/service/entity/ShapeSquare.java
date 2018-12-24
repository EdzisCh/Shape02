package by.chebotar.service.entity;

import by.chebotar.bean.Cube;
import by.chebotar.dao.ShapeDAOImpl;
import by.chebotar.dao.Warehouse;
import by.chebotar.service.Observer;
import by.chebotar.bean.Shape;

public class ShapeSquare extends ShapeOption implements Observer {
  private ShapeDAOImpl shapeDAO = new ShapeDAOImpl();

  @Override
  public void update(Long ID) {

  }

  @Override
  public double calculateOption(Shape shape) {
    if (shape instanceof Cube){
      return shapeDAO.getEntityById(shape.getID()).getEdge()*shapeDAO.getEntityById(shape.getID()).getEdge();
    } else {

    }
    return 0;
  }
}
