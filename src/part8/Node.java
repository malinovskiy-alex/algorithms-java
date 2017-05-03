package part8;

public class Node
{
  private char element;
  private Node rightChild;
  private Node leftChild;

  public Node(char element)
  {
    this.element = element;
  }

  public char getElement()
  {
    return element;
  }

  public void setElement(char element)
  {
    this.element = element;
  }

  public Node getRightChild()
  {
    return rightChild;
  }

  public void setRightChild(Node rightChild)
  {
    this.rightChild = rightChild;
  }

  public Node getLeftChild()
  {
    return leftChild;
  }

  public void setLeftChild(Node leftChild)
  {
    this.leftChild = leftChild;
  }
}
