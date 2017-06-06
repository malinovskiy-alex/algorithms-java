package part5.unidirection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PriorityLinkedListTest
{
  @Test(timeout = 100)
  public void removeLastShouldAddElementInNegativeOrder()
  {
    PriorityLinkedList<Integer> test = new PriorityLinkedList<>();
    test.add(5);
    test.add(3);
    test.add(1);
    test.add(2);

    assertEquals(5, (long)test.removeLast().getValue());
  }

  @Test(timeout = 100)
  public void reverseShouldMoveSmallestElementOnLastPosition()
  {
    PriorityLinkedList<Integer> test = new PriorityLinkedList<>();
    test.add(5);
    test.add(3);
    test.add(1);
    test.add(2);

    assertEquals("1,2,3,5", test.getDisplayString());

    test.reverse();

    assertEquals("5,3,2,1", test.getDisplayString());
  }

  @Test(timeout = 100)
  public void reverseShouldWorkCorrectlyForOneElement()
  {
    PriorityLinkedList<Integer> test = new PriorityLinkedList<>();
    test.add(5);

    assertEquals("5", test.getDisplayString());

    test.reverse();

    assertEquals("5", test.getDisplayString());
  }

  @Test(timeout = 100)
  public void reverseShouldWorkCorrectlyEmptyList()
  {
    PriorityLinkedList test = new PriorityLinkedList();

    assertEquals("", test.getDisplayString());

    test.reverse();

    assertEquals("", test.getDisplayString());
  }

  @Test(timeout = 100)
  public void getDisplayStringShouldReturnStringInNegativeOrder()
  {
    PriorityLinkedList<Integer> test = new PriorityLinkedList<>();
    test.add(3);
    test.add(1);
    test.add(2);
    test.add(5);

    assertEquals("1,2,3,5", test.getDisplayString());
  }
}
