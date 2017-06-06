package part5.cyclic;

import java.util.List;

import part5.ListElement;

public class CyclicList<T>
{
  private ListElement<T> current;

  public void step()
  {
    current = current.getNext();
  }

  public void insert(T value)
  {
    ListElement<T> e = new ListElement<>(value);
    if (current == null)
    {
      current = e;
      current.setNext(e);
      return;
    }
    ListElement<T> next = current.getNext();
    current.setNext(e);
    e.setNext(next);
    step();
  }

  public ListElement<T> getCurrent()
  {
    return current;
  }

  public ListElement<T> remove(T value)
  {
    if (current == null)
    {
      throw new RuntimeException("List is empty!");
    }
    ListElement<T> result = null;
    ListElement<T> breakingChainStart = current;
    ListElement<T> breakingChainEnd = current.getNext();
    breakingChainStart.setNext(null);
    current = breakingChainEnd;
    if (current.getValue().equals(value))
    {
      result = current;
      if (current.getNext() == null)
      {
        current = null;
      }
      else
      {
        breakingChainStart.setNext(current.getNext());
        current = breakingChainStart;
      }
      return result;
    }
    while (current.getNext() != null)
    {
      if (current.getNext().getValue().equals(value))
      {
        result = current.getNext();
        ListElement<T> nextAfterTarget = result.getNext();
        if (nextAfterTarget == null)
        {
          breakingChainStart = current;
        }
        else
        {
          current.setNext(nextAfterTarget);
        }
        break;
      }
      step();
    }
    breakingChainStart.setNext(breakingChainEnd);
    return result;
  }

  public ListElement<T> remove()
  {
    if (isEmpty())
    {
      throw new RuntimeException("List is empty!");
    }
    ListElement<T> newEndOfList = current.getNext();
    current.setNext(null);
    current = newEndOfList;
    ListElement<T> result = null;
    if (current.getNext() == null)
    {
      result = current;
      current = null;
      return result;
    }
    while (current.getNext().getNext() != null)
    {
      step();
    }
    result = current.getNext();
    current.setNext(newEndOfList);
    return result;
  }

  public boolean isEmpty()
  {
    return current == null;
  }

  public ListElement<T> find(T value)
  {
    if (current == null)
    {
      return null;
    }
    if (current.getValue().equals(value))
    {
      return current;
    }
    ListElement<T> breakingStartChain = current;
    ListElement<T> breakingEndChain = current.getNext();
    if (breakingEndChain.getValue().equals(value))
    {
      return breakingEndChain;
    }
    breakingStartChain.setNext(null);
    ListElement<T> result = null;
    ListElement<T> iterator = breakingEndChain;
    while (iterator.getNext() != null)
    {
      if (iterator.getValue().equals(value))
      {
        result = iterator;
      }
      iterator = iterator.getNext();
    }
    breakingStartChain.setNext(breakingEndChain);
    return result;
  }

  public String display()
  {
    String result = "";
    if (current == null)
    {
      return result;
    }
    result += current.getValue();
    ListElement<T> nextChunkLink = current.getNext();
    if (nextChunkLink == null)
    {
      return result;
    }
    current.setNext(null);
    ListElement<T> iterator = nextChunkLink;
    while (iterator.getNext() != null)
    {
      result += "," + iterator.getValue();
      iterator = iterator.getNext();
    }
    iterator.setNext(nextChunkLink);
    return result;
  }

  public ListElement<T> resolveFlaviusIssue(int step, List<T> elements)
  {
    current = null;
    elements.forEach(this::insert);
    step();
    while (size() != 1)
    {
      ListElement<T> previousElement = null;
      for (int i = 0; i < step; i++)
      {
        previousElement = current;
        current = current.getNext();
      }
      previousElement.setNext(current.getNext());
      current = current.getNext();
    }
    return current;
  }

  public int size()
  {
    int size = 0;
    if (current == null)
    {
      return size;
    }
    ListElement<T> startOfChain = current;
    ListElement<T> endOfChain = current.getNext();
    startOfChain.setNext(null);
    size += 1;
    current = endOfChain;
    while (current.getNext() != null)
    {
      size += 1;
      step();
    }
    current.setNext(endOfChain);
    return size;
  }
}
