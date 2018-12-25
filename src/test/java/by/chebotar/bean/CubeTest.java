package by.chebotar.bean;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeTest {
  @Test
  public void test(){
    Map<Long, Double> map = new HashMap<>();
    map.put(0l,12.0);
    map.put(0l,98.0);
    Assert.assertEquals(map.get(0l),98.0);
  }
}
