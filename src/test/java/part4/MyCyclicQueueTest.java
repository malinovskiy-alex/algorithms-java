package part4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyCyclicQueueTest
{
  private MyCyclicQueue<Integer> queue;

  @Test
  public void shouldProperlyDisplayValuesInQueueWithoutShift()
  {
    queue = new MyCyclicQueue<>(4);
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    assertEquals("1,2,3,4", queue.display());
  }

  @Test
  public void shouldProperlyDisplayValuesInQueueWithShift()
  {
    queue = new MyCyclicQueue<>(4);
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    queue.pop();
    queue.pop();
    queue.push(5);
    queue.push(6);
    assertEquals("3,4,5,6", queue.display());
  }

  @Test
  public void toArrayShouldReturnArrayWithExactSizeAndWithoutShift()
  {
    queue = new MyCyclicQueue<>(4);
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    queue.pop();
    queue.pop();
    queue.push(5);
    queue.push(6);

    Integer[] result = new Integer[]{3, 4, 5, 6};
    assertEquals(result, queue.toArray());
  }
}
