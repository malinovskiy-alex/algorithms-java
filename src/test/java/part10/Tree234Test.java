package part10;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

public class Tree234Test
{
  @Test
  public void insertedElementsShouldBeSortedInDataArray()
  {
    Tree234<Integer> tree234 = new Tree234<>();
    tree234.insert(5);
    tree234.insert(1);
    tree234.insert(10);

    NodeMultiChild<Integer> root = tree234.getRoot();

    assertEquals(3, root.getExistingElements());
    assertEquals(1, (int) root.getDataArray()[0]);
    assertEquals(5, (int) root.getDataArray()[1]);
    assertEquals(10, (int) root.getDataArray()[2]);
  }

  @Test
  public void splitShouldCreateNewRootFromFirstElementWith2Children()
  {
    Tree234<Integer> tree234 = new Tree234<>();
    tree234.insert(5);
    tree234.insert(1);
    tree234.insert(10);
    tree234.insert(4);

    assertEquals(5, tree234.getRoot().getDataArray()[0]);
  }

  @Test
  public void shouldCorrectlyReturnMinValue()
  {
    Tree234<Integer> tree234 = new Tree234<>();
    tree234.insert(5);
    tree234.insert(13);
    tree234.insert(10);
    tree234.insert(15);
    tree234.insert(8);
    tree234.insert(12);
    tree234.insert(1);

    assertEquals(1, (int) tree234.getMin());
  }

  @Test
  public void shouldPrintValuesByOrder()
  {
    Tree234<Integer> tree234 = new Tree234<>();
    tree234.insert(5);
    tree234.insert(13);
    tree234.insert(10);
    tree234.insert(15);
    tree234.insert(8);
    tree234.insert(12);
    tree234.insert(1);

    tree234.symmetricPrint();
  }
}
