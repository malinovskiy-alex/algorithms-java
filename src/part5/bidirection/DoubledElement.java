package part5.bidirection;

public class DoubledElement
{
  private int value;
  private DoubledElement previous;
  private DoubledElement next;

  public DoubledElement(int value)
  {
    this.value = value;
  }

  public int getValue()
  {
    return value;
  }

  public void setValue(int value)
  {
    this.value = value;
  }

  public DoubledElement getPrevious()
  {
    return previous;
  }

  public void setPrevious(DoubledElement previous)
  {
    this.previous = previous;
  }

  public DoubledElement getNext()
  {
    return next;
  }

  public void setNext(DoubledElement next)
  {
    this.next = next;
  }
}
