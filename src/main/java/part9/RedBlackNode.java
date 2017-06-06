package part9;

import part8.Node;

public class RedBlackNode<T extends Comparable> extends Node<T>
{
  public RedBlackNode(T element)
  {
    super(element);
    this.isRed = true;
  }

  private boolean isRed;

  public boolean isRed()
  {
    return isRed;
  }

  public void setRed(boolean red)
  {
    isRed = red;
  }
}
