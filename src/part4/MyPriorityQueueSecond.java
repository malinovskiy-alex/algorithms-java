package part4;

import java.util.Arrays;

public class MyPriorityQueueSecond
{
  int[] array;
  int lastElement;

  public MyPriorityQueueSecond(int size)
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
  }

  public int pop()
  {
    if (isEmpty())
    {
      throw new RuntimeException("There are no elements in stack!");
    }
    if (lastElement == 0)
    {
      return array[lastElement--];
    }
    int maxElementIndex = 0;
    for (int i = 1; i <= lastElement; i++)
    {
      if (array[maxElementIndex] < array[i])
      {
        maxElementIndex = i;
      }
    }
    int result = array[maxElementIndex];
    for (int i = maxElementIndex; i < lastElement; i++)
    {
      array[i] = array[i + 1];
    }
    lastElement--;
    return result;
  }

  public int size()
  {
    return lastElement + 1;
  }

  public int peek()
  {
    if (isEmpty())
    {
      throw new RuntimeException("There are no elements in stack!");
    }
    if (lastElement == 0)
    {
      return array[lastElement--];
    }
    int maxElementIndex = 0;
    for (int i = 1; i <= lastElement; i++)
    {
      if (array[maxElementIndex] < array[i])
      {
        maxElementIndex = i;
      }
    }
    return array[maxElementIndex];
  }

  public String display()
  {
    if (isEmpty())
    {
      throw new RuntimeException("Queue is empty!");
    }
    String result = "";
    int[] displayArray = Arrays.copyOfRange(array, 0, lastElement + 1);
    for (int i = 0; i < displayArray.length; i++)
    {
      int max = i;
      for (int j = i; j < displayArray.length; j++)
      {
        if (displayArray[max] < displayArray[j])
        {
          max = j;
        }
      }
      int temp = displayArray[max];
      if (!result.equals(""))
      {
        result += ",";
      }
      result += temp;
      displayArray[max] = displayArray[i];
      displayArray[i] = temp;
    }
    return result;
  }

  public boolean isFull()
  {
    return lastElement == array.length - 1;
  }

  public boolean isEmpty()
  {
    return size() == 0;
  }
}
