package part5.cyclic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import part5.ListElement;

public class CyclicListTest
{
  @Test(timeout = 100)
  public void insertLeftShouldInsertCorrectlyAndSetCorrectFront()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(2);
    test.insert(4);
    test.insert(1);

    assertEquals(1, (long)test.getCurrent().getValue());
    assertEquals(2, (long)test.getCurrent().getNext().getValue());
  }

  @Test(timeout = 100)
  public void displayShouldDisplayCorrectValueIfOneElement()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(2);

    assertEquals("2", test.display());
  }

  @Test(timeout = 100)
  public void displayShouldDisplayCorrectValueForEmptyList()
  {
    CyclicList test = new CyclicList();

    assertEquals("", test.display());
  }

  @Test(timeout = 100)
  public void displayShouldDisplayCorrectValueFor5Elements()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(2);
    test.insert(3);
    test.insert(5);
    test.insert(11);
    test.insert(-1);

    assertEquals("-1,2,3,5,11", test.display());
  }

  @Test(timeout = 100, expected = RuntimeException.class)
  public void removeShouldThrowExceptionIfListIsEmpty()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.remove(5);
  }

  @Test(timeout = 100)
  public void removeShouldWorkCorrectlyRemovingLastElementFromList()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(10);

    assertEquals("10", test.display());

    test.remove(10);

    assertTrue(test.isEmpty());
  }

  @Test(timeout = 100)
  public void removeShouldChangeNothingWhenNoSuchElementForRemovingInList()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(10);
    test.insert(1);
    test.insert(5);

    assertEquals("5,10,1", test.display());

    test.remove(7);

    assertEquals("5,10,1", test.display());
  }

  @Test(timeout = 100)
  public void removeShouldCorrectlyRemoveExistingElementFromList()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(10);
    test.insert(1);
    test.insert(5);
    test.insert(6);
    test.insert(3);

    test.remove(5);

    assertEquals("1,6,3,10", test.display());
  }

  @Test(timeout = 100)
  public void removeShouldCorrectlyRemoveCurrentElementFromList()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(10);
    test.insert(1);
    test.insert(5);
    test.insert(6);
    test.insert(3);

    test.remove(3);

    assertEquals("6,10,1,5", test.display());
  }

  @Test(timeout = 100)
  public void removeShouldCorrectlyRemoveNextAfterCurrentElementFromList()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(10);
    test.insert(1);
    test.insert(5);
    test.insert(6);
    test.insert(3);

    test.remove(10);

    assertEquals("3,1,5,6", test.display());
  }

  @Test
  public void findShouldReturnNullIfElementDoesntExist()
  {
    CyclicList<Integer> test = new CyclicList<>();

    test.insert(10);
    test.insert(1);
    test.insert(5);
    test.insert(6);
    test.insert(3);

    assertNull(test.find(11));
  }

  @Test
  public void findShouldReturnNullIfListIsEmpty()
  {
    CyclicList test = new CyclicList();

    assertNull(test.find(11));
  }

  @Test
  public void findShouldReturnCorrectElementIfItsInTheList()
  {
    CyclicList test = new CyclicList();

    test.insert(10);
    test.insert(1);
    test.insert(5);
    test.insert(6);
    test.insert(3);

    ListElement result = test.find(5);

    assertNotNull(result);
    assertEquals(6, result.getNext().getValue());
  }

  @Test
  public void findShouldReturnCorrectElementIfItsInTheListAndItsCurrent()
  {
    CyclicList test = new CyclicList();

    test.insert(10);
    test.insert(1);
    test.insert(5);
    test.insert(6);
    test.insert(3);

    ListElement result = test.find(3);

    assertNotNull(result);
    assertEquals(10, result.getNext().getValue());
  }

  @Test
  public void removeShouldCorrectlyRemoveCurrentElementAndMoveCurrentToPrevious()
  {
    CyclicList test = new CyclicList();

    test.insert(10);
    test.insert(1);
    test.insert(5);
    test.insert(6);
    test.insert(3);

    test.remove();

    assertEquals(6, test.getCurrent().getValue());
  }

  @Test
  public void removeShouldRemoveCurrentElementAndMakeListEmptyIfThereWasOneElement()
  {
    CyclicList test = new CyclicList();

    test.insert(10);

    test.remove();

    assertTrue(test.isEmpty());
  }

  @Test
  public void removeShouldRemoveCurrentElementLeaveOneElementInList()
  {
    CyclicList test = new CyclicList();

    test.insert(10);
    test.insert(4);

    test.remove();

    assertEquals(10, test.getCurrent().getValue());
    assertEquals(10, test.getCurrent().getNext().getValue());
  }

  @Test(expected = RuntimeException.class)
  public void removeCurrentShouldThrowExceptionIfListIsEmpty()
  {
    CyclicList test = new CyclicList();

    test.remove();
  }

  @Test(timeout = 100)
  public void sizeShouldReturnZeroForEmptyList()
  {
    CyclicList test = new CyclicList();

    assertEquals(0, test.size());
  }

  @Test(timeout = 100)
  public void sizeShouldReturnOneIfAddedOneElement()
  {
    CyclicList test = new CyclicList();
    test.insert(10);

    assertEquals(1, test.size());
  }

  @Test(timeout = 100)
  public void sizeShouldReturnOneIfAddedTwoElementsAndThenRemovedOneElement()
  {
    CyclicList test = new CyclicList();
    test.insert(10);
    test.insert(15);
    test.remove();

    assertEquals(1, test.size());
  }

  @Test(timeout = 100)
  public void resolveFlaviusIssueShouldReturnCorrectValueForPredefinedInput()
  {
    CyclicList test = new CyclicList();
    ListElement result = test.resolveFlaviusIssue(3, Arrays.asList(1, 2, 3, 4, 5, 6, 7));

    assertEquals(2, result.getValue());
    assertEquals(1, test.size());
  }

}
