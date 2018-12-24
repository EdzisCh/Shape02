package by.chebotar.controller;

import by.chebotar.service.ShapeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.chebotar.bean.Shape;


public class ShapeController {

  private  final ShapeService shapeService = new ShapeService();
  private static final Logger LOGGER = LogManager.getLogger(ShapeController.class);

  public void putShapes(Shape... shapes){
    shapeService.addShapes(shapes);
  }

  public Shape getShape(Long ID){
    return shapeService.getShapeByID(ID);
  }


}
