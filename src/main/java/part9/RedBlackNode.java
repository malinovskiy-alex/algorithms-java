package part9;

import part8.Node;

public class RedBlackNode<T extends Comparable> extends Node<T>
{
  public RedBlackNode(T element)
  {
    super(element);
    this.isRed = true;
  }

  private RedBlackNode<T> parent;

  private boolean isRed;

  private boolean isLeft;

  public RedBlackNode<T> getParent()
  {
    return parent;
  }

  public void setParent(RedBlackNode<T> parent)
  {
    this.parent = parent;
  }

  public boolean isRed()
  {
    return isRed;
  }

  public void setRed(boolean red)
  {
    isRed = red;
  }

  public boolean isLeft()
  {
    return isLeft;
  }

  public void setLeft(boolean left)
  {
    isLeft = left;
  }

  @Override
  public RedBlackNode<T> getRightChild()
  {
    return (RedBlackNode<T>) super.getRightChild();
  }

  @Override
  public RedBlackNode<T> getLeftChild()
  {
    return (RedBlackNode<T>) super.getLeftChild();
  }
}
