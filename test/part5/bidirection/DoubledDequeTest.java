package part5.bidirection;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DoubledDequeTest
{
  @Test(timeout = 100)
  public void isEmptyShouldReturnTrueForNewDeque()
  {
    DoubledDeque test = new DoubledDeque();

    assertTrue(test.isEmpty());
  }

  @Test(timeout = 100)
  public void isEmptyShouldReturnTrueIfElementAddedAndRemoved()
  {
    DoubledDeque test = new DoubledDeque();

    test.insertLeft(2);
    test.removeLeft();

    assertTrue(test.isEmpty());
  }

  @Test(timeout = 100)
  public void isEmptyShouldReturnFalseIfElementAdded()
  {
    DoubledDeque test = new DoubledDeque();

    test.insertLeft(2);

    assertFalse(test.isEmpty());
  }

  @Test
  public void insertLeftShouldAddElementToLeftCorner()
  {
    DoubledDeque test = new DoubledDeque();

    test.insertLeft(1);
    test.insertLeft(5);

    assertEquals(5, test.removeLeft());
    assertEquals(1, test.removeLeft());
    assertTrue(test.isEmpty());
  }

  @Test
  public void insertRightShouldAddElementToRightCorner()
  {
    DoubledDeque test = new DoubledDeque();

    test.insertRight(5);
    test.insertRight(1);

    assertEquals(1, test.removeRight());
    assertEquals(5, test.removeRight());
    assertTrue(test.isEmpty());

  }

  @Test
  public void insertLeftShouldShiftFirstElement()
  {
    DoubledDeque test = new DoubledDeque();

    test.insertLeft(5);
    test.insertLeft(1);

    assertEquals(1, test.getFirst().getValue());
  }
}
