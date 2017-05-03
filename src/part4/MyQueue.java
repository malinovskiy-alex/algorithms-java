package part4;

public class MyQueue<T>
{
  private Object[] array;
  int front;
  int rear;

  public MyQueue(int s)
  {
    array = new Object[s];
    front = 0;
    rear = -1;
  }

  public void push(T element)
  {

  }

  public T pop()
  {
    return (T) array[front++];
  }

  public T peek()
  {
    return (T) array[front];
  }

  public int size()
  {
    return 0;
  }

  public boolean isEmpty()
  {
    return size() == 0;
  }
}
