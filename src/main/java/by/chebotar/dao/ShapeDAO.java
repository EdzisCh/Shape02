package by.chebotar.dao;

import java.util.List;
import java.util.Map;
import by.chebotar.bean.Shape;

public interface ShapeDAO {
  Map<Long, Shape> getAll();
  void put(Shape entity);
  Shape getEntityById(Long id);
  boolean delete(Long id);
  Map<Long, Shape> createNewMap(List<Shape> list);
}
