package part9;

public class RedBlackTree<T extends Comparable>
{
  private RedBlackNode<T> root;

  public void insert(T element)
  {
    if (this.root == null)
    {
      this.root = new RedBlackNode<>(element);
    }
    else
    {
      RedBlackNode<T> currentNode = this.root;
      RedBlackNode<T> parentNode = null;
      while (currentNode != null)
      {
        parentNode = currentNode;
        if (element.compareTo(currentNode.getElement()) < 0)
        {
          currentNode = (RedBlackNode<T>) currentNode.getLeftChild();
        }
        else
        {
          currentNode = (RedBlackNode<T>) currentNode.getRightChild();
        }
      }
      if (element.compareTo(parentNode.getElement()) < 0)
      {
        parentNode.setLeftChild(new RedBlackNode<>(element));
      }
      else
      {
        parentNode.setRightChild(new RedBlackNode<>(element));
      }
    }
  }

  private void changeColor(RedBlackNode<T> node)
  {
    node.setRed(!node.isRed());
  }

  private void moveLeft(RedBlackNode<T> parent, RedBlackNode<T> child)
  {

  }

  private void moveRight(RedBlackNode<T> parent, RedBlackNode<T> child)
  {

  }

  public RedBlackNode<T> getRoot()
  {
    return root;
  }

  public boolean isEmpty()
  {
    return this.root == null;
  }
}
