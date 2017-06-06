package part8.task4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PostfixTreeBuilderTest
{
  private PostfixTreeBuilder test;

  @Test
  public void getDisplayStringShouldReturn6thDepthsTreeWithAllCharsFromTest()
  {

    test = new PostfixTreeBuilder("ABC+*");

    test.build();

    String result = test.getDisplayString();

    assertEquals("", result);
  }

  @Test
  public void treeShouldBuildCorrectlyForCaseOfSimpleOperators()
  {

    test = new PostfixTreeBuilder("AB+C-");

    test.build();

    String result = test.getDisplayString();

    assertEquals("", result);
  }

  @Test
  public void treeShouldBuildCorrectlyForCaseOfComplexOperators()
  {

    test = new PostfixTreeBuilder("AB*CD*+");

    test.build();

    String result = test.getDisplayString();

    assertEquals("", result);
  }

  @Test
  public void treeShouldBuildCorrectlyForCaseOfBigComplexOperators()
  {

    test = new PostfixTreeBuilder("ABCDEF+/-*+");

    test.build();

    String result = test.getDisplayString();

    assertEquals("", result);
  }

  @Test
  public void getInfixStringShouldReturnCorrectExpressionForSimpleCase()
  {

    test = new PostfixTreeBuilder("AB*CD*+");

    test.build();

    String result = test.getInfixString();

    assertEquals("(((A)*(B))+((C)*(D)))", result);
  }

  @Test
  public void getPrefixStringShouldReturnCorrectExpressionForSimpleCase()
  {

    test = new PostfixTreeBuilder("AB*CD*+");

    test.build();

    String result = test.getPrefixString();

    assertEquals("+*AB*CD", result);
  }

  @Test
  public void getPostfixStringShouldReturnCorrectExpressionForSimpleCase()
  {

    test = new PostfixTreeBuilder("AB*CD*+");

    test.build();

    String result = test.getPostfixString();

    assertEquals("AB*CD*+", result);
  }

}