package part8.task5;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class HafmanTreeBuilderTest
{

  private HafmanTreeBuilder test;

  @Test
  @Ignore
  public void shouldBuildCorrectTree()
  {
    test = new HafmanTreeBuilder("I love my job.");

    test.build();

    List<HafmanTransformationNode> codeTable = test.buildCodesTable();

    assertEquals(11, codeTable.size());
  }
}