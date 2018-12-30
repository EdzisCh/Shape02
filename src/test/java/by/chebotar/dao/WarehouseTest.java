package by.chebotar.dao;

import by.chebotar.bean.Cube;
import by.chebotar.bean.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WarehouseTest {

  private ShapeDAOImpl shapeDAO = null;
  private static Warehouse warehouse = null;

  @BeforeClass
  private void setUp(){
    shapeDAO = ShapeDAOImpl.getINSTANCE();
    warehouse = Warehouse.getInstance();
  }

  @Test
  public void calculateOptionsWhileSupplementationNewShape(){
    shapeDAO.put(new Cube("Cube", new Point(0.0,1.0),9.0));
    double[] shapeOptions = {warehouse.getVolumeByID(0l),warehouse.getSquareByID(0l),warehouse.getPerimeterByID(0l)};
    Assert.assertEquals(shapeOptions,new double[]{729.0,486,108.0});
  }

  @Test
  public void removeShapeThatDoesNotExist(){
    Assert.assertEquals(warehouse.deleteShape(78l),false);
  }
}
