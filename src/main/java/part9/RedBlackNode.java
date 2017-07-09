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

  public RedBlackNode<T> getNextChild(RedBlackNode<T> nodeForInsertion)
  {
    if (nodeForInsertion.greater(this))
    {
      return this.getRightChild();
    }
    else
    {
      return this.getLeftChild();
    }
  }

  public void insertNode(RedBlackNode<T> nodeForInsertion)
  {
    nodeForInsertion.setParent(this);
    if (nodeForInsertion.greater(this))
    {
      nodeForInsertion.setLeft(false);
      this.setRightChild(nodeForInsertion);
    }
    else
    {
      nodeForInsertion.setLeft(true);
      this.setLeftChild(nodeForInsertion);
    }
  }

  public boolean greater(RedBlackNode<T> node)
  {
    return getElement().compareTo(node.getElement()) > 0;
  }

  public boolean flipColorRequired()
  {
    if (this.isRed())
    {
      return false;
    }
    boolean isLeftChildRed = this.getLeftChild() != null && this.getLeftChild().isRed();
    boolean isRightChildRed = this.getRightChild() != null && this.getRightChild().isRed();
    return isLeftChildRed && isRightChildRed;
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
