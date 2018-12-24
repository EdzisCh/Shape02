package by.chebotar.bean;

import by.chebotar.controller.ShapeController;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeTest {

  @Test
  public void test(){
    ShapeController shapeController = new ShapeController();
    shapeController.putShapes(new Cube("e", new Point(0.0,0.0),9));
    Assert.assertEquals(shapeController.getSquareOfShapeByID(0l),81.0);
  }
}
