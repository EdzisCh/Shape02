package by.chebotar.dao;

import by.chebotar.bean.Cube;
import by.chebotar.bean.Observable;
import by.chebotar.bean.Shape;
import by.chebotar.service.Observer;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeDAOImpl implements ShapeDAO{

  private static final Logger LOGGER = LogManager.getLogger(ShapeDAOImpl.class);
  private static final Warehouse warehouse = Warehouse.getInstance();
  private Map<Long, Shape> data = new HashMap<Long, Shape>();

  public Map<Long, Shape> getAll() {
    return this.data;
  }

  @Override
  public void put(Shape entity) {
    this.data.put(entity.getID(), entity);

  }

  @Override
  public Shape getEntityById(Long id) {
    return this.data.get(id);
  }

  @Override
  public Shape delete(Long id) {
    return this.data.remove(id);
  }

  @Override
  public Map<Long, Shape> createNewMap(List<Shape> list) {
    data = new HashMap<Long, Shape>();
    for (Shape shape : list) {
      data.computeIfAbsent(shape.getID(), k -> data.put(shape.getID(),shape));
    }
    return data;
  }
}
