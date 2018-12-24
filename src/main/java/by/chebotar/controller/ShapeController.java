package by.chebotar.controller;

import by.chebotar.dao.ShapeDAOImpl;
import by.chebotar.dao.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.chebotar.bean.Shape;


public class ShapeController {

  private ShapeDAOImpl shapeDAO = ShapeDAOImpl.getINSTANCE();
  private Warehouse warehouse = Warehouse.getInstance();
  private static final Logger LOGGER = LogManager.getLogger(ShapeController.class);

  public void putShapes(Shape... shapes){
    for (Shape shape : shapes) {
      shapeDAO.put(shape);
    }
  }

  public Shape getShape(Long ID){
    return shapeDAO.getEntityById(ID);
  }

  public Double getSquareOfShapeByID(Long ID){
    return warehouse.getSquareByID(ID);
  }
}
