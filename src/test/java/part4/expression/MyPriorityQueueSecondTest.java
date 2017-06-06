package part4.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import part4.MyPriorityQueueSecond;

public class MyPriorityQueueSecondTest
{
  private MyPriorityQueueSecond queue;

  @Test
  public void popShouldRemoveElementFromListAndReturnBiggestValue()
  {
    queue = new MyPriorityQueueSecond(4);
    queue.push(1);
    queue.push(5);
    queue.push(6);
    queue.push(2);

    assertEquals(6, queue.pop());
    assertEquals(3, queue.size());
  }

  @Test
  public void popShouldNotRemoveValueFromQueueAndReturnBiggestValue()
  {
    queue = new MyPriorityQueueSecond(4);
    queue.push(1);
    queue.push(5);
    queue.push(6);
    queue.push(2);

    assertEquals(6, queue.peek());
    assertEquals(4, queue.size());
  }

  @Test(expected = RuntimeException.class)
  public void peekShouldThrowExceptionIfQueueIsEmpty()
  {
    queue = new MyPriorityQueueSecond(4);

    queue.peek();
  }

  @Test(expected = RuntimeException.class)
  public void popShouldThrowExceptionIfQueueIsEmpty()
  {
    queue = new MyPriorityQueueSecond(4);

    queue.pop();
  }

  @Test
  public void displayShouldReturnStringWithNumbersFromMaxToMinForFullQueue()
  {
    queue = new MyPriorityQueueSecond(5);
    queue.push(1);
    queue.push(3);
    queue.push(-2);
    queue.push(6);
    queue.push(1);

    assertEquals("6,3,1,1,-2", queue.display());
  }

  @Test
  public void displayShouldReturnStringWithNumbersFromMaxToMinForNotFullQueue()
  {
    queue = new MyPriorityQueueSecond(5);
    queue.push(1);
    queue.push(3);
    queue.push(-2);
    queue.push(6);

    assertEquals("6,3,1,-2", queue.display());
  }
}
