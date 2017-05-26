package part5.unidirection;

import part5.ListElement;

public class PriorityLinkedList<T extends Comparable>
{
  private ListElement<T> first;

  public int size;

  public void add(T e)
  {
    size++;
    ListElement<T> element = new ListElement<>(e);
    if (first == null)
    {
      first = element;
      return;
    }
    ListElement<T> currentElement = first;
    ListElement<T> previousElement = currentElement;
    while (currentElement != null && currentElement.getValue().compareTo(e) < 0)
    {
      previousElement = currentElement;
      currentElement = currentElement.getNext();
    }
    if (first == currentElement)
    {
      element.setNext(first);
      first = element;
    }
    else
    {
      previousElement.setNext(element);
      element.setNext(currentElement);
    }
  }

  public void reverse()
  {
    if (first == null || first.getNext() == null)
    {
      return;
    }
    ListElement previous = first;
    ListElement current = first.getNext();
    previous.setNext(null);
    while (current != null)
    {
      ListElement temp = current.getNext();
      current.setNext(previous);
      previous = current;
      current = temp;
    }
    first = previous;
  }

  public ListElement<T> removeLast()
  {
    size--;
    ListElement currentElement = first;
    ListElement previousElement = currentElement;
    if (currentElement == null)
    {
      return null;
    }
    while (currentElement.getNext() != null)
    {
      previousElement = currentElement;
      currentElement = currentElement.getNext();
    }
    previousElement.setNext(null);
    return currentElement;
  }

  public String getDisplayString()
  {
    String result = "";
    if (first == null)
    {
      return result;
    }
    ListElement element = first;
    while (element != null)
    {
      if (!result.equals(""))
      {
        result += ",";
      }
      result += element.getValue().toString();
      element = element.getNext();
    }
    return result;
  }

  public int getSize()
  {
    return size;
  }

  public ListElement<T> getFirst()
  {
    return first;
  }

  public void setFirst(ListElement first)
  {
    this.first = first;
  }
}
