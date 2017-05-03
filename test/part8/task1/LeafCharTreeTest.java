package part8.task1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeafCharTreeTest
{

  private LeafCharTree test;

  @Test
  public void getDisplayStringShouldReturnRootWhereRightChildIsElementAndTwoCharsPluses()
  {
    test = new LeafCharTree('A');

    test.build();

    String result = test.getDisplayString();

    assertEquals("", result);
  }

  @Test
  public void getDisplayStringShouldReturn6thDepthsTreeWithAllCharsFromTest()
  {

    test = new LeafCharTree('A', 'B', 'C', 'D', 'E');

    test.build();

    String result = test.getDisplayString();

    assertEquals("", result);
  }
}