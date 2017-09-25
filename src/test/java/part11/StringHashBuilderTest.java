package part11;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringHashBuilderTest
{
  private StringHashBuilder hashBuilder = new StringHashBuilder();

  @Test
  public void hashFuncShouldReturnXForArrayOf10AndWordCats()
  {
    DataItem<String> item = new DataItem<>("cats");

    assertEquals(7, hashBuilder.getHashKey(item, 10));
  }

  @Test
  public void hashFuncShouldReturnXForArrayOf10AndWordDog()
  {
    DataItem<String> item = new DataItem<>("dog");

    assertEquals(4, hashBuilder.getHashKey(item, 10));
  }
}
