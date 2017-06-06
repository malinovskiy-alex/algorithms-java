package part8.task2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BalancedLeafCharTreeTest
{
  private BalancedLeafCharTree test;

  @Test
  public void getDisplayStringShouldReturn6thDepthsTreeWithAllCharsFromTest()
  {

    test = new BalancedLeafCharTree('A', 'B', 'C', 'D', 'E');

    test.build();

    String result = test.getDisplayString();

    assertEquals("", result);
  }
}