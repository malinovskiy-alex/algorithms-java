package part5;

public class ListElement
{
  private int value;
  private ListElement next;

  public ListElement(int value)
  {
    this.value = value;
  }

  public int getValue()
  {
    return value;
  }

  public ListElement getNext()
  {
    return next;
  }

  public void setNext(ListElement next)
  {
    this.next = next;
  }
}
