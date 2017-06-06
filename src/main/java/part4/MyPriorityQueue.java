package part4;

public class MyPriorityQueue<T extends Comparable>
{
  private Object[] array;
  private int lastElement;
  private int size;

  public MyPriorityQueue(int size)
  {
    lastElement = -1;
    array = new Object[size];
  }

  public void push(T element)
  {
    if (isFull())
    {
      throw new RuntimeException("Queue size is exceed!");
    }
    array[++lastElement] = element;
    size++;
    int j = lastElement;
    while (j > 0 && ((T) array[j - 1]).compareTo(element) < 0)
    {
      T temp = (T) array[j];
      array[j] = array[j - 1];
      array[j - 1] = temp;
      j--;
    }
  }

  public T pop()
  {
    if (isEmpty())
    {
      throw new RuntimeException("There are no elements in stack!");
    }
    size--;
    return (T) array[lastElement--];
  }

  public int getSize()
  {
    return size;
  }

  public T peek()
  {
    return (T) array[lastElement];
  }

  public boolean isFull()
  {
    return lastElement == array.length - 1;
  }

  public boolean isEmpty()
  {
    return getSize() == 0;
  }
}
