package part4;

public class MyStack<T>
{
  Object[] array;
  int lastElement;

  public MyStack(int s)
  {
    array = new Object[s];
    lastElement = -1;
  }

  public void push(T element)
  {
    if (isFull())
    {
      throw new RuntimeException("Stack size is exceed!");
    }
    array[++lastElement] = element;
  }

  public T pop()
  {
    if (isEmpty())
    {
      throw new RuntimeException("There are no elements in stack!");
    }
    return (T) array[lastElement--];
  }

  public boolean isEmpty()
  {
    return lastElement == -1;
  }

  public T peek()
  {
    return (T) array[lastElement - 1];
  }

  public boolean isFull()
  {
    return lastElement + 1 == array.length;
  }

  public void display()
  {
    System.out.println("Printing stack from start: ");
    for (int i = 0; i <= lastElement; i++)
    {
      System.out.print(array[i] + " ,");
    }
  }
}
