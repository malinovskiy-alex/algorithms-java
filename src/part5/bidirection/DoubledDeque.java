package part5.bidirection;

public class DoubledDeque
{
  private DoubledElement first;

  public void insertRight(int value)
  {
    DoubledElement e = new DoubledElement(value);
    if (first == null)
    {
      first = e;
      return;
    }
    DoubledElement lastElement = first;
    while (lastElement.getNext() != null)
    {
      lastElement = lastElement.getNext();
    }
    lastElement.setNext(e);
    e.setPrevious(lastElement);
  }

  public void insertLeft(int value)
  {
    DoubledElement e = new DoubledElement(value);
    if (first == null)
    {
      first = e;
      return;
    }
    DoubledElement lastElement = first;
    while (lastElement.getPrevious() != null)
    {
      lastElement = lastElement.getPrevious();
    }
    lastElement.setPrevious(e);
    e.setNext(lastElement);
    first = e;
  }

  public int removeRight()
  {
    DoubledElement lastElement = first;
    while (lastElement.getNext() != null)
    {
      lastElement = lastElement.getNext();
    }
    int result = lastElement.getValue();
    DoubledElement previous = lastElement.getPrevious();
    if (previous != null)
    {
      previous.setNext(null);
    }
    else
    {
      first = null;
    }
    return result;
  }

  public int removeLeft()
  {
    int result = first.getValue();
    DoubledElement nextFirstElement = first.getNext();
    if (nextFirstElement != null)
    {
      nextFirstElement.setPrevious(null);
    }
    first = nextFirstElement;
    return result;
  }

  public boolean isEmpty()
  {
    return first == null;
  }

  public boolean isFull()
  {
    return false;
  }

  public DoubledElement getFirst()
  {
    return first;
  }

  public void setFirst(DoubledElement first)
  {
    this.first = first;
  }
}
