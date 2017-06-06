package part8;

public class Node<T extends Comparable>
{
  private T element;
  private Node<T> rightChild;
  private Node<T> leftChild;

  public Node(T element)
  {
    this.element = element;
  }

  public Node()
  {
  }

  public T getElement()
  {
    return element;
  }

  public void setElement(T element)
  {
    this.element = element;
  }

  public Node<T> getRightChild()
  {
    return rightChild;
  }

  public void setRightChild(Node<T> rightChild)
  {
    this.rightChild = rightChild;
  }

  public Node<T> getLeftChild()
  {
    return leftChild;
  }

  public void setLeftChild(Node<T> leftChild)
  {
    this.leftChild = leftChild;
  }

}
