package part4;

public class MyPriorityQueue
{
  int[] array;
  int lastElement;

  public MyPriorityQueue(int size)
  {
    lastElement = -1;
    array = new int[size];
  }

  public void push(int element)
  {
    if (isFull())
    {
      throw new RuntimeException("Queue size is exceed!");
    }
    array[++lastElement] = element;
    int j = lastElement;
    while (j > 0 && array[j - 1] < element)
    {
      int temp = array[j];
      array[j] = array[j - 1];
      array[j - 1] = temp;
      j--;
    }
  }

  public int pop()
  {
    if (isEmpty())
    {
      throw new RuntimeException("There are no elements in stack!");
    }
    return array[lastElement--];
  }

  public int peek()
  {
    return array[lastElement];
  }

  public boolean isFull()
  {
    return lastElement == array.length - 1;
  }

  public boolean isEmpty()
  {
    return lastElement == -1;
  }
}
