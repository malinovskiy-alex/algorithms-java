package part4;

public class MyCyclicQueue
{
  int[] array;
  int front;
  int rear;
  int size;

  public MyCyclicQueue(int size)
  {
    array = new int[size];
    front = 0;
    rear = -1;
    size = 0;
  }

  public void push(int element)
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

  public int pop()
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
    return array[front++];
  }

  public int peek()
  {
    return array[front];
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
}
