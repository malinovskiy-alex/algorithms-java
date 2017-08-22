package part10;

public class NodeMultiChild<T extends Comparable>
{
  private NodeMultiChild<T> parent;
  private int existingElements = 0;
  private int dataElementsMaxSize;
  private Object[] dataArray;
  private NodeMultiChild[] childArray;

  public NodeMultiChild(int dataElementsMaxSize)
  {
    this.dataArray = new Object[dataElementsMaxSize];
    this.childArray = new NodeMultiChild[dataElementsMaxSize + 1];
    this.dataElementsMaxSize = dataElementsMaxSize;
  }

  public int insertInDataArray(T element)
  {
    int elementIndex = getExistingElements();
    if (elementIndex != 0)
    {
      while (elementIndex > 0 && ((T) dataArray[elementIndex - 1]).compareTo(element) > 0)
      {
        dataArray[elementIndex] = (T) dataArray[elementIndex - 1];
        elementIndex--;
      }
    }
    dataArray[elementIndex] = element;
    existingElements++;
    return elementIndex;
  }

  public NodeMultiChild<T> getNextChildNode(T element)
  {
    int elementIndex = 0;
    while (elementIndex < (existingElements - 1) && element.compareTo(dataArray[elementIndex]) > 0)
    {
      elementIndex++;
    }
    if (element.compareTo(dataArray[elementIndex]) > 0)
    {
      return childArray[++elementIndex];
    }
    return childArray[elementIndex];
  }

  public void insertChild(NodeMultiChild<T> child, int index)
  {
    childArray[index] = child;
  }

  public NodeMultiChild<T> extractChild(int index)
  {
    NodeMultiChild result = childArray[index];
    childArray[index] = null;
    return result;
  }

  public T extractDataElement(int index)
  {
    T result = (T) dataArray[index];
    dataArray[index] = null;
    existingElements--;
    return result;
  }

  public NodeMultiChild<T> getChildAt(int index)
  {
    return childArray[index];
  }

  public T getDataElementAt(int index)
  {
    return (T) dataArray[index];
  }

  public int getExistingElements()
  {
    return existingElements;
  }

  public boolean isFull()
  {
    return existingElements == dataElementsMaxSize;
  }

  public boolean isEmpty()
  {
    return existingElements == 0;
  }

  public boolean isLeaf()
  {
    return childArray[0] == null;
  }

  public NodeMultiChild<T> getParent()
  {
    return parent;
  }

  public void setParent(NodeMultiChild<T> parent)
  {
    this.parent = parent;
  }

  protected Object[] getDataArray()
  {
    return dataArray;
  }
}