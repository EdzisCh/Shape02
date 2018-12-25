package by.chebotar.service;

import by.chebotar.dao.ShapeDAOImpl;
import by.chebotar.dao.Warehouse;
import by.chebotar.bean.Shape;
import by.chebotar.service.option.ShapeSquare;
import java.util.Map;

public class ShapeService {

  private static final Warehouse warehouse = Warehouse.getInstance();
  private static final ShapeDAOImpl shapeDAO = ShapeDAOImpl.getINSTANCE();
  private final ShapeSquare shapeSquare = new ShapeSquare();

  public void addShapes(Shape... shapes){
    for (Shape shape : shapes) {
      shapeDAO.put(shape);
      warehouse.addShape(shape);
      shape.addObserver(shapeSquare);
    }
  }

  public boolean deleteShape(Shape shape){
    boolean flag = false;
    flag = shapeDAO.delete(shape.getID());
    warehouse.deleteShape(shape.getID());
    return flag;
  }

  public Shape getShapeByID(Long ID){
    return shapeDAO.getEntityById(ID);
  }

  public Shape getShapeByName(String name){
    Map<Long, Shape> tempMap = shapeDAO.getAll();
    Shape neededShape = null;
    for (long i = 0; i < tempMap.size(); i++) {
      if (tempMap.get(i).getName().equals(name)){
        neededShape = tempMap.get(i);
      }
    }
    return neededShape;
  }

  public Shape getShapeBySquare(double square){
    Map<Long, Double> tempMap = warehouse.getAllSquares();
    Shape neededShape = null;
    for (long i = 0; i < tempMap.size(); i++) {
      if (tempMap.get(i) == square){
        neededShape = shapeDAO.getEntityById(i);
      }
    }
    return neededShape;
  }
}
