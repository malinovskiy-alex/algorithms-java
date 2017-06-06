package part8.task5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import part4.MyPriorityQueue;

public class HafmanPriorityQueueBuilderTest
{

  private HafmanPriorityQueueBuilder test = new HafmanPriorityQueueBuilder();

  @Test
  public void shouldReturnListWithOneElementIfInputIsOneChar()
  {
    MyPriorityQueue<HafmanNode> result = test.build("A");

    assertEquals(1, result.getSize());
    HafmanNode firstNode = result.pop();
    assertEquals('A', firstNode.getElement());
  }

  @Test
  public void shouldReturnListWithTwoElementsIfInputIsTwoChars()
  {
    MyPriorityQueue<HafmanNode> result = test.build("AB");

    assertEquals(2, result.getSize());
    assertEquals('A', result.pop().getElement());
    assertEquals('B', result.pop().getElement());
  }

  @Test
  public void shouldReturnFirstElementWhereOccurrencesCountSmaller()
  {
    MyPriorityQueue<HafmanNode> result = test.build("ABB");

    assertEquals(2, result.getSize());
    assertEquals('A', result.pop().getElement());
    assertEquals('B', result.pop().getElement());
  }

  @Test
  public void shouldCorrectlyHandleBigString()
  {
    MyPriorityQueue<HafmanNode> result = test.build("I love my job.");

    assertEquals(11, result.getSize());
    assertEquals('I', result.pop().getElement());
  }
}