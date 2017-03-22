package part4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class MyDequeTest
{
  private MyDeque myDeque;

  @Test
  public void insertLeftShouldInsertCorrectlyAndSetCorrectFront()
  {
    myDeque = new MyDeque(3);
    myDeque.insertLeft(1);
    myDeque.insertLeft(2);

    assertEquals(1, myDeque.getFront());
    assertEquals(-1, myDeque.getRear());
  }

  @Test
  public void insertRightShouldInsertCorrectlyAndSetCorrectRear()
  {
    myDeque = new MyDeque(3);
    myDeque.insertRight(1);
    myDeque.insertRight(2);

    assertEquals(0, myDeque.getFront());
    assertEquals(1, myDeque.getRear());
  }

  @Test
  public void removeLeftShouldRemoveCorrectValueAndUpdateFront()
  {
    myDeque = new MyDeque(3);
    myDeque.insertLeft(1);
    myDeque.insertLeft(2);

    assertEquals(2, myDeque.removeLeft());
    assertEquals(-1, myDeque.getFront());
    assertEquals(-1, myDeque.getRear());

  }

  @Test
  public void re()
  {
    Deque<Integer> deq = new ArrayDeque<>();
    deq.addFirst(1);
    deq.addFirst(2);
    System.out.println(deq.pollLast());
    deq.addLast(3);
    System.out.println(deq.pollFirst());

//    assertEquals(-1, myDeque.getFront());
//    assertEquals(-1, myDeque.getRear());

  }

}
