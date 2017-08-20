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
    int elementIndex = 0;
    while (elementIndex < (dataElementsSize - 1) && element.compareTo(dataArray[elementIndex]) > 0)
    {
      elementIndex++;
    }
    if (element.compareTo(dataArray[elementIndex]) > 0)
    {
      elementIndex++;
      return childArray[elementIndex];
    }
    return childArray[elementIndex--];
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

  public Node234<T> getChildAt(int index)
  {
    return childArray[index];
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