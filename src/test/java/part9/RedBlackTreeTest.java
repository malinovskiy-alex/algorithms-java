package part9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RedBlackTreeTest
{
  private RedBlackTree<Integer> tree;

  @Test
  public void insertShouldAddNewElementInTree()
  {
    tree = new RedBlackTree<>();

    assertEquals(true, tree.isEmpty());

    tree.insert(2);

    assertEquals(false, tree.isEmpty());

  }

  @Test
  public void insertShouldAddTwoLeftChildren()
  {
    tree = new RedBlackTree<>();

    tree.insert(2);

    tree.insert(1);

    assertEquals(1L, (long) tree.getRoot().getLeftChild().getElement());

  }

  @Test
  public void insertShouldCorrectlyAddSecondStage()
  {
    tree = new RedBlackTree<>();

    tree.insert(3);

    tree.insert(2);

    tree.insert(1);

    assertEquals(1L, (long) tree.getRoot().getLeftChild().getLeftChild().getElement());

  }

  @Test
  public void insertShouldCreateBalancedTreeFrom3Elements()
  {
    tree = new RedBlackTree<>();

    tree.insert(2);

    tree.insert(1);

    tree.insert(3);

    assertEquals(1L, (long) tree.getRoot().getLeftChild().getElement());

    assertEquals(3L, (long) tree.getRoot().getRightChild().getElement());

  }

}