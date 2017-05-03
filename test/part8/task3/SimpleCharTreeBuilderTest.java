package part8.task3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleCharTreeBuilderTest
{

  private SimpleCharTreeBuilder test;

  @Test
  public void getDisplayStringShouldReturn6thDepthsTreeWithAllCharsFromTest()
  {

    test = new SimpleCharTreeBuilder('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');

    test.build();

    String result = test.getDisplayString();

    assertEquals("", result);
  }

}