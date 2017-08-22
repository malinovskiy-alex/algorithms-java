package part10;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

public class Tree23Test
{
  @Test
  public void insertedElementsShouldBeSortedInDataArray()
  {
    Tree23<Integer> tree234 = new Tree23<>();
    tree234.insert(5);
    tree234.insert(1);

    NodeMultiChild<Integer> root = tree234.getRoot();

    assertEquals(2, root.getExistingElements());
    assertEquals(1, (int) root.getDataArray()[0]);
    assertEquals(5, (int) root.getDataArray()[1]);
  }

  @Test
  public void insertShouldAllowToAddUpTo8Elements()
  {
    Tree23<Integer> tree234 = new Tree23<>();
    tree234.insert(15);
    tree234.insert(13);
    tree234.insert(10);
    tree234.insert(18);
    tree234.insert(4);
    tree234.insert(1);
    tree234.insert(2);
    tree234.insert(8);

    assertEquals(2, tree234.getRoot().getExistingElements());
    assertEquals(2, tree234.getRoot().getChildAt(0).getExistingElements());
    assertEquals(2, tree234.getRoot().getChildAt(1).getExistingElements());
    assertEquals(2, tree234.getRoot().getChildAt(2).getExistingElements());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void insertShouldThrowErrorOn9Elements()
  {
    Tree23<Integer> tree234 = new Tree23<>();
    tree234.insert(15);
    tree234.insert(13);
    tree234.insert(10);
    tree234.insert(18);
    tree234.insert(4);
    tree234.insert(1);
    tree234.insert(2);
    tree234.insert(8);
    tree234.insert(9);
  }
}
