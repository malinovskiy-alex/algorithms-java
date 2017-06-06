package part4;

public class MyDeque
{
  private int[] storage;
  private int front;
  private int rear;
  private int size;

  public MyDeque(int size)
  {
    this.storage = new int[size];
    this.front = 0;
    this.rear = -1;
    this.size = 0;
  }

  public void insertLeft(int element)
  {
    if (isFull())
    {
      throw new RuntimeException("Storage is full.");
    }
    if (front == -1)
    {
      front = storage.length - 1;
    }
    size++;
    storage[front--] = element;
  }

  public void insertRight(int element)
  {
    if (isFull())
    {
      throw new RuntimeException("Storage is full.");
    }
    if (rear == storage.length - 1)
    {
      rear = -1;
    }
    size++;
    storage[++rear] = element;
  }

  public int removeLeft()
  {
    if (isEmpty())
    {
      throw new RuntimeException("Storage is empty");
    }
    if (front == storage.length)
    {
      front = 0;
    }
    size--;
    return storage[front++];
  }

  public int removeRight()
  {
    if (isEmpty())
    {
      throw new RuntimeException("Storage is empty");
    }
    if (rear == 0)
    {
      rear = storage.length - 1;
    }
    size--;
    return storage[rear--];
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  public boolean isFull()
  {
    return size == storage.length;
  }

  protected int getRear()
  {
    return rear;
  }

  protected int getFront()
  {
    return front;
  }
}
