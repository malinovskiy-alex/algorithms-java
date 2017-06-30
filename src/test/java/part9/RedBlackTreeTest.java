package part9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    assertTrue(tree.getRoot().getLeftChild().isLeft());


  }

  @Test
  public void insertShouldCorrectlyAddSecondStageAndChangeRootLeft()
  {
    tree = new RedBlackTree<>();

    tree.insert(3);

    tree.insert(2);

    tree.insert(1);

    assertEquals(2L, (long) tree.getRoot().getElement());
    assertTrue(tree.getRoot().getLeftChild().isLeft());
    assertFalse(tree.getRoot().getRightChild().isLeft());

  }

  @Test
  public void insertShouldCorrectlyAddSecondStageAndChangeRootRight()
  {
    tree = new RedBlackTree<>();

    tree.insert(1);

    tree.insert(2);

    assertEquals(1L, (long) tree.getRoot().getElement());

    tree.insert(3);

    assertEquals(2L, (long) tree.getRoot().getElement());
    assertFalse(tree.getRoot().isRed());

    assertEquals(1L, (long) tree.getRoot().getLeftChild().getElement());
    assertTrue(tree.getRoot().getLeftChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().isLeft());

    assertEquals(3L, (long) tree.getRoot().getRightChild().getElement());
    assertTrue(tree.getRoot().getRightChild().isRed());
    assertFalse(tree.getRoot().getRightChild().isLeft());

  }

  @Test
  public void insertShouldCreateBalancedTreeFrom3Elements()
  {
    tree = new RedBlackTree<>();

    tree.insert(2);

    tree.insert(1);

    tree.insert(3);

    assertEquals(1L, (long) tree.getRoot().getLeftChild().getElement());
    assertTrue(tree.getRoot().getLeftChild().isLeft());

    assertEquals(3L, (long) tree.getRoot().getRightChild().getElement());
    assertFalse(tree.getRoot().getRightChild().isLeft());

  }

  @Test
  public void colorOfTwoChildNodesShouldBeFlippedIfParentHasTwoRedNodesButRootShouldRemainBlack()
  {
    tree = new RedBlackTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    assertFalse(tree.getRoot().isRed());
    assertFalse(tree.getRoot().getLeftChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().isLeft());
    assertFalse(tree.getRoot().getRightChild().isRed());
    assertFalse(tree.getRoot().getRightChild().isLeft());
  }

  @Test
  public void colorOfTwoChildNodesShouldBeFlippedIfParentHasTwoRedNodes()
  {
    tree = new RedBlackTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(5);
    tree.insert(8);
    tree.insert(3);
    tree.insert(4);


    assertTrue(tree.getRoot().getRightChild().isRed());
    assertFalse(tree.getRoot().getRightChild().isLeft());

    assertFalse(tree.getRoot().getRightChild().getRightChild().isRed());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isLeft());

    assertFalse(tree.getRoot().getRightChild().getLeftChild().isRed());
    assertTrue(tree.getRoot().getRightChild().getLeftChild().isLeft());

  }

  @Test
  public void testForMovingNodesInCaseOfTwoRedNodesRightOuterGrandChild()
  {
    tree = new RedBlackTree<>();
    tree.insert(2);
    tree.insert(1);
    tree.insert(5);
    tree.insert(8);
    tree.insert(10);

    assertEquals(8, (long) tree.getRoot().getRightChild().getElement());
    assertFalse(tree.getRoot().getRightChild().isRed());

    assertEquals(10, (long) tree.getRoot().getRightChild().getRightChild().getElement());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isLeft());

    assertEquals(5, (long) tree.getRoot().getRightChild().getLeftChild().getElement());
    assertTrue(tree.getRoot().getRightChild().getLeftChild().isLeft());

    assertTrue(tree.getRoot().getRightChild().getRightChild().isRed());
    assertTrue(tree.getRoot().getRightChild().getLeftChild().isRed());

  }

  @Test
  public void testForMovingNodesInCaseOfTwoRedNodesLeftOuterGrandChild()
  {
    tree = new RedBlackTree<>();
    tree.insert(50);
    tree.insert(25);
    tree.insert(75);
    tree.insert(12);
    tree.insert(6);

    assertEquals(12, (long) tree.getRoot().getLeftChild().getElement());
    assertFalse(tree.getRoot().getLeftChild().isRed());

    assertEquals(6, (long) tree.getRoot().getLeftChild().getLeftChild().getElement());
    assertEquals(25, (long) tree.getRoot().getLeftChild().getRightChild().getElement());

    assertTrue(tree.getRoot().getLeftChild().getRightChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().getLeftChild().isRed());

  }

  @Test
  public void testForMovingNodesInCaseOfTwoRedNodesRightInnerGrandChild()
  {
    tree = new RedBlackTree<>();
    tree.insert(50);
    tree.insert(25);
    tree.insert(75);
    tree.insert(12);
    tree.insert(18);

    assertEquals(18, (long) tree.getRoot().getLeftChild().getElement());
    assertTrue(tree.getRoot().getLeftChild().isLeft());

    assertEquals(25, (long) tree.getRoot().getLeftChild().getRightChild().getElement());
    assertFalse(tree.getRoot().getLeftChild().getRightChild().isLeft());

    assertEquals(12, (long) tree.getRoot().getLeftChild().getLeftChild().getElement());
    assertTrue(tree.getRoot().getLeftChild().getLeftChild().isLeft());


  }

  @Test
  public void testForMovingNodesInCaseOfTwoRedNodesLeftInnerGrandChild()
  {
    tree = new RedBlackTree<>();
    tree.insert(50);
    tree.insert(25);
    tree.insert(75);
    tree.insert(95);
    tree.insert(80);

    assertEquals(80, (long) tree.getRoot().getRightChild().getElement());
    assertFalse(tree.getRoot().getRightChild().isLeft());

    assertEquals(95, (long) tree.getRoot().getRightChild().getRightChild().getElement());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isLeft());

    assertEquals(75, (long) tree.getRoot().getRightChild().getLeftChild().getElement());
    assertTrue(tree.getRoot().getRightChild().getLeftChild().isLeft());

  }

  @Test
  public void testForMovingNodesInCaseOfTwoRedNodesAfterFlipLeftOuterGrandChildShouldChangeRoot()
  {
    tree = new RedBlackTree<>();
    tree.insert(50);
    tree.insert(25);
    tree.insert(75);
    tree.insert(12);
    tree.insert(37);
    tree.insert(6);
    tree.insert(18);
    tree.insert(3);

    assertEquals(25, (long) tree.getRoot().getElement());
    assertEquals(12, (long) tree.getRoot().getLeftChild().getElement());
    assertEquals(6, (long) tree.getRoot().getLeftChild().getLeftChild().getElement());
    assertEquals(18, (long) tree.getRoot().getLeftChild().getRightChild().getElement());

    assertEquals(50, (long) tree.getRoot().getRightChild().getElement());
    assertEquals(37, (long) tree.getRoot().getRightChild().getLeftChild().getElement());
    assertEquals(75, (long) tree.getRoot().getRightChild().getRightChild().getElement());

    assertFalse(tree.getRoot().isRed());

    assertFalse(tree.getRoot().getLeftChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().isLeft());

    assertFalse(tree.getRoot().getRightChild().isRed());
    assertFalse(tree.getRoot().getRightChild().isLeft());

  }

  @Test
  public void testForMovingNodesInCaseOfTwoRedNodesAfterFlipLeftInnerGrandChildShouldChangeRoot()
  {
    tree = new RedBlackTree<>();
    tree.insert(50);
    tree.insert(25);
    tree.insert(75);
    tree.insert(12);
    tree.insert(37);
    tree.insert(43);
    tree.insert(31);
    tree.insert(28);

    assertEquals(37, (long) tree.getRoot().getElement());
    assertEquals(25, (long) tree.getRoot().getLeftChild().getElement());
    assertEquals(50, (long) tree.getRoot().getRightChild().getElement());

    assertEquals(75, (long) tree.getRoot().getRightChild().getRightChild().getElement());
    assertEquals(43, (long) tree.getRoot().getRightChild().getLeftChild().getElement());
    assertTrue(tree.getRoot().getRightChild().getLeftChild().isLeft());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isLeft());
    assertFalse(tree.getRoot().getRightChild().getLeftChild().isRed());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isRed());

    assertEquals(31, (long) tree.getRoot().getLeftChild().getRightChild().getElement());
    assertEquals(12, (long) tree.getRoot().getLeftChild().getLeftChild().getElement());
    assertFalse(tree.getRoot().getLeftChild().getLeftChild().isRed());
    assertFalse(tree.getRoot().getLeftChild().getRightChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().getLeftChild().isLeft());
    assertFalse(tree.getRoot().getLeftChild().getRightChild().isLeft());

    assertFalse(tree.getRoot().isRed());
    assertFalse(tree.getRoot().getLeftChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().isLeft());

    assertFalse(tree.getRoot().getRightChild().isRed());
    assertFalse(tree.getRoot().getRightChild().isLeft());

    assertEquals(28, (long) tree.getRoot().getLeftChild().getRightChild().getLeftChild().getElement());
  }

  @Test
  public void testForMovingNodesInCaseOfTwoRedNodesAfterFlipRightOuterGrandChildShouldChangeRoot()
  {
    tree = new RedBlackTree<>();
    tree.insert(50);
    tree.insert(25);
    tree.insert(75);
    tree.insert(85);
    tree.insert(65);
    tree.insert(95);
    tree.insert(80);
    tree.insert(100);

    assertEquals(75, (long) tree.getRoot().getElement());
    assertEquals(50, (long) tree.getRoot().getLeftChild().getElement());
    assertEquals(85, (long) tree.getRoot().getRightChild().getElement());

    assertEquals(95, (long) tree.getRoot().getRightChild().getRightChild().getElement());
    assertEquals(80, (long) tree.getRoot().getRightChild().getLeftChild().getElement());
    assertTrue(tree.getRoot().getRightChild().getLeftChild().isLeft());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isLeft());
    assertFalse(tree.getRoot().getRightChild().getLeftChild().isRed());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isRed());

    assertEquals(65, (long) tree.getRoot().getLeftChild().getRightChild().getElement());
    assertEquals(25, (long) tree.getRoot().getLeftChild().getLeftChild().getElement());
    assertFalse(tree.getRoot().getLeftChild().getLeftChild().isRed());
    assertFalse(tree.getRoot().getLeftChild().getRightChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().getLeftChild().isLeft());
    assertFalse(tree.getRoot().getLeftChild().getRightChild().isLeft());

    assertFalse(tree.getRoot().isRed());
    assertFalse(tree.getRoot().getLeftChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().isLeft());

    assertFalse(tree.getRoot().getRightChild().isRed());
    assertFalse(tree.getRoot().getRightChild().isLeft());

    assertEquals(100, (long) tree.getRoot().getRightChild().getRightChild().getRightChild().getElement());

  }

  @Test
  public void testForMovingNodesInCaseOfTwoRedNodesAfterFlipRightInnerGrandChildShouldChangeRoot()
  {
    tree = new RedBlackTree<>();
    tree.insert(50);
    tree.insert(25);
    tree.insert(75);
    tree.insert(86);
    tree.insert(65);
    tree.insert(60);
    tree.insert(67);
    tree.insert(55);

    assertEquals(65, (long) tree.getRoot().getElement());
    assertEquals(50, (long) tree.getRoot().getLeftChild().getElement());
    assertEquals(75, (long) tree.getRoot().getRightChild().getElement());

    assertEquals(86, (long) tree.getRoot().getRightChild().getRightChild().getElement());
    assertEquals(67, (long) tree.getRoot().getRightChild().getLeftChild().getElement());

    assertTrue(tree.getRoot().getRightChild().getLeftChild().isLeft());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isLeft());
    assertFalse(tree.getRoot().getRightChild().getLeftChild().isRed());
    assertFalse(tree.getRoot().getRightChild().getRightChild().isRed());

    assertEquals(60, (long) tree.getRoot().getLeftChild().getRightChild().getElement());
    assertEquals(25, (long) tree.getRoot().getLeftChild().getLeftChild().getElement());
    assertFalse(tree.getRoot().getLeftChild().getLeftChild().isRed());
    assertFalse(tree.getRoot().getLeftChild().getRightChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().getLeftChild().isLeft());
    assertFalse(tree.getRoot().getLeftChild().getRightChild().isLeft());

    assertFalse(tree.getRoot().isRed());
    assertFalse(tree.getRoot().getLeftChild().isRed());
    assertTrue(tree.getRoot().getLeftChild().isLeft());

    assertFalse(tree.getRoot().getRightChild().isRed());
    assertFalse(tree.getRoot().getRightChild().isLeft());

    assertEquals(55, (long) tree.getRoot().getLeftChild().getRightChild().getLeftChild().getElement());

  }

}