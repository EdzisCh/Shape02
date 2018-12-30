package by.chebotar.dao;

import by.chebotar.bean.Cube;
import by.chebotar.bean.Point;
import by.chebotar.bean.Shape;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShapeDAOImplTest {

  private ShapeDAOImpl shapeDAO = null;
  private static Warehouse warehouse = null;

  @BeforeClass
  private void setUp(){
    shapeDAO = ShapeDAOImpl.getINSTANCE();
    warehouse = Warehouse.getInstance();
  }

  @Test
  public void shouldReturnEmptyMapAtTheBeginning(){
    Assert.assertEquals(shapeDAO.getAll().isEmpty(),true);
  }

  @Test
  public void shouldReturnFalseIfTryToDeleteNotExistingShape(){
    Assert.assertEquals(shapeDAO.delete(1l),false);
  }

  @Test
  public void shouldPutShapeOptionsIntoWarehouse(){
    Cube cube = new Cube();
    shapeDAO.put(cube);
    Assert.assertEquals(warehouse.getVolumeByID(0l),0.0);
  }

  @Test
  public void shouldReturnNewMapIfWeUseCreateNewMap(){
    List<Shape> list = new ArrayList<>();
    list.add(new Cube());
    list.add(new Cube("SecCube",new Point(0.0,0.0),9.0));
    shapeDAO.createNewMap(list);
    Assert.assertEquals(shapeDAO.getEntityById(1l).getName(),"SecCube");
  }
}
