package part5.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest
{
  private Queue test;

  @Test
  public void isEmptyShouldReturnTrueForNewlyCreatedStack()
  {
    test = new Queue();

    assertTrue(test.isEmpty());
  }

  @Test
  public void isEmptyShouldReturnFalseAfterAddingOneElement()
  {
    test = new Queue();
    test.push(5);

    assertFalse(test.isEmpty());
  }

  @Test
  public void peekShouldReturnNullForEmptyList()
  {
    test = new Queue();

    assertNull(test.peek());
  }

  @Test
  public void peekShouldReturnFirstAddedElementAndDoesntChangeSize()
  {
    test = new Queue();
    test.push(5);
    test.push(11);
    test.push(1);

    assertEquals(5, test.peek().getValue());
    assertEquals(3, test.size());
  }

  @Test
  public void popShouldReturnFirstAddedElementAndReduceStackSize()
  {
    test = new Queue();
    test.push(5);
    test.push(11);
    test.push(1);

    assertEquals(5, test.pop().getValue());
    assertEquals(2, test.size());
    assertEquals(11, test.peek().getValue());
  }

  @Test
  public void popShouldReturnNullIfStackIsEmpty()
  {
    test = new Queue();

    assertNull(test.pop());
    assertEquals(0, test.size());
  }

  @Test
  public void pushShouldIncreaseStackSizeAndMakeLastAddedElementOnTop()
  {
    test = new Queue();
    test.push(6);

    assertEquals(1, test.size());
    assertEquals(6, test.peek().getValue());
  }
}
