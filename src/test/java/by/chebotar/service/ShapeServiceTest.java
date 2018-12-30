package by.chebotar.service;

import by.chebotar.bean.Cube;
import by.chebotar.bean.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShapeServiceTest {

  private ShapeService shapeService = new ShapeService();
  private final Cube testCube = new Cube("TestCube", new Point(8.9,0.6),4.2);

  @Test
  public void checkForAddingObservers(){
    shapeService.addShapes(new Cube("new Cube", new Point(0.0,0.0),2.0));
    Assert.assertEquals(shapeService.getOptions(1l),"Options of new Cube; Square: 24.0; Volume: 8.0; Perimeter: 24.0");
  }

  @Test
  public void checkFirstSearcher(){
    shapeService.addShapes(testCube);
    Assert.assertEquals(shapeService.getShapeByID(0l),testCube);
  }

  @Test
  public void checkSecondSearcher(){
    shapeService.addShapes(testCube);
    Assert.assertEquals(shapeService.getShapeByName("TestCube"),testCube);
  }
}
