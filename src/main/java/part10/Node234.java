package part10;

public class Node234<T extends Comparable>
{
  public static final int CHILD_SIZE = 4;
  private Node234<T> parent;
  private int dataElementsSize = 0;
  private Object[] dataArray = new Object[CHILD_SIZE - 1];
  private Node234[] childArray = new Node234[CHILD_SIZE];

  public Node234()
  {
  }

  public int insertInDataArray(T element)
  {
    int elementIndex = getDataElementsSize();
    if (elementIndex != 0)
    {
      while (elementIndex > 0 && ((T) dataArray[elementIndex - 1]).compareTo(element) > 0)
      {
        dataArray[elementIndex] = (T) dataArray[elementIndex - 1];
        elementIndex--;
      }
    }
    dataArray[elementIndex] = element;
    dataElementsSize++;
    return elementIndex;
  }

  public Node234<T> getNextChildNode(T element)
  {
    int elementsCount = 0;
    while (elementsCount < dataElementsSize && element.compareTo(dataArray[elementsCount]) > 0)
    {
      elementsCount++;
    }
    if (element.compareTo(dataArray[elementsCount]) > 0)
    {
      return childArray[elementsCount++];
    }
    return childArray[elementsCount--];
  }

  public Node234<T> getMinChild()
  {
    return childArray[0];
  }

  public void insertChild(Node234<T> child, int index)
  {
    childArray[index] = child;
  }

  public Node234<T> extractChild(int index)
  {
    Node234 result = childArray[index];
    childArray[index] = null;
    return result;
  }

  public T extractDataElement(int index)
  {
    T result = (T) dataArray[index];
    dataArray[index] = null;
    dataElementsSize--;
    return result;
  }

  public int getDataElementsSize()
  {
    return dataElementsSize;
  }

  public boolean isFull()
  {
    return dataElementsSize == CHILD_SIZE - 1;
  }

  public boolean isEmpty()
  {
    return dataElementsSize == 0;
  }

  public boolean isLeaf()
  {
    return childArray[0] == null;
  }

  public Node234<T> getParent()
  {
    return parent;
  }

  public void setParent(Node234<T> parent)
  {
    this.parent = parent;
  }

  protected Object[] getDataArray()
  {
    return dataArray;
  }
}