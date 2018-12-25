package by.chebotar.dao;

import by.chebotar.bean.Shape;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeDAOImpl implements ShapeDAO{

  private static final Logger LOGGER = LogManager.getLogger(ShapeDAOImpl.class);
  private static final Warehouse warehouse = Warehouse.getInstance();
  public static ShapeDAOImpl INSTANCE = null;
  private static Map<Long, Shape> data = new HashMap<Long, Shape>();

  private ShapeDAOImpl(){

  }

  public static ShapeDAOImpl getINSTANCE() {
    if(INSTANCE == null){
      synchronized (ShapeDAOImpl.class) {
        if (INSTANCE == null) {
          INSTANCE = new ShapeDAOImpl();
        }
      }
    }
    return INSTANCE;
  }

  public Map<Long, Shape> getAll() {
    return this.data;
  }

  @Override
  public void put(Shape entity) {
    this.data.put(entity.getID(), entity);
    warehouse.addShape(entity);
  }

  @Override
  public Shape getEntityById(Long id) {
    return this.data.get(id);
  }

  @Override
  public Shape delete(Long id) {
    warehouse.deleteShape(id);
    return this.data.remove(id);
  }

  @Override
  public Map<Long, Shape> createNewMap(List<Shape> list) {
    data = new HashMap<Long, Shape>();
    for (Shape shape : list) {
      data.computeIfAbsent(shape.getID(), k -> data.put(shape.getID(),shape));
      warehouse.addShape(shape);
    }
    return data;
  }
}
