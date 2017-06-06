package part5.stack;

import part5.ListElement;
import part5.cyclic.CyclicList;

public class Queue<T>
{
  private CyclicList<T> innerContainer = new CyclicList<>();

  public void push(T element)
  {
    innerContainer.insert(element);
  }

  public ListElement<T> pop()
  {
    if (isEmpty())
    {
      return null;
    }
    T returningElement = innerContainer.getCurrent().getNext().getValue();
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
