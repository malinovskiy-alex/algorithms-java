package part4;

public class MyCyclicQueue<T>
{
  private Object[] array;
  int front;
  int rear;
  int size;

  public MyCyclicQueue(int size)
  {
    array = new Object[size];
    front = 0;
    rear = -1;
    this.size = 0;
  }

  public void push(T element)
  {
    if (isFull())
    {
      throw new RuntimeException("Stack size is exceed!");

    }
    if (rear == array.length - 1)
    {
      rear = -1;
    }
    array[++rear] = element;
    size++;
  }

  public T pop()
  {
    if (isEmpty())
    {
      throw new RuntimeException("There are no elements in stack!");
    }
    if (front > array.length - 1)
    {
      front = 0;
    }
    size--;
    return (T) array[front++];
  }

  public T peek()
  {
    return (T) array[front];
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  public boolean isFull()
  {
    return size == array.length;
  }

  public String display()
  {
    int displaySize = size;
    String result = "";
    if (displaySize > 0)
    {
      int start = front;
      while (displaySize > 0)
      {
        displaySize--;
        if (start > array.length - 1)
        {
          start = 0;
        }
        if (result.equals(""))
        {
          result += array[start++];
        }
        else
        {
          result += "," + array[start++];
        }
      }
    }
    return result;
  }

  public T[] toArray()
  {
    Object[] result = new Object[size];
    int index = front;
    for (int i = 0; i < result.length; i++)
    {
      result[i] = array[index];
      index++;
      if (index > result.length - 1)
      {
        index = 0;
      }
    }
    return (T[]) result;
  }
}
