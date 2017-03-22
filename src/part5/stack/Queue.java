package part5.stack;

import part5.ListElement;
import part5.cyclic.CyclicList;

public class Queue
{
  private CyclicList innerContainer = new CyclicList();

  public void push(int element)
  {
    innerContainer.insert(element);
  }

  public ListElement pop()
  {
    if (isEmpty())
    {
      return null;
    }
    int returningElement = innerContainer.getCurrent().getNext().getValue();
    return innerContainer.remove(returningElement);
  }

  public boolean isEmpty()
  {
    return innerContainer.isEmpty();
  }

  public ListElement peek()
  {
    if (isEmpty())
    {
      return null;
    }
    return innerContainer.getCurrent().getNext();
  }

  public int size()
  {
    return innerContainer.size();
  }
}
