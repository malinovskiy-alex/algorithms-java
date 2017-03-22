package part5.cyclic;

import java.util.List;

import part5.ListElement;

public class CyclicList
{
  private ListElement current;

  public void step()
  {
    current = current.getNext();
  }

  public void insert(int value)
  {
    ListElement e = new ListElement(value);
    if (current == null)
    {
      current = e;
      current.setNext(e);
      return;
    }
    ListElement next = current.getNext();
    current.setNext(e);
    e.setNext(next);
    step();
  }

  public ListElement getCurrent()
  {
    return current;
  }

  public ListElement remove(int value)
  {
    if (current == null)
    {
      throw new RuntimeException("List is empty!");
    }
    ListElement result = null;
    ListElement breakingChainStart = current;
    ListElement breakingChainEnd = current.getNext();
    breakingChainStart.setNext(null);
    current = breakingChainEnd;
    if (current.getValue() == value)
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
      if (current.getNext().getValue() == value)
      {
        result = current.getNext();
        ListElement nextAfterTarget = result.getNext();
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

  public ListElement remove()
  {
    if (isEmpty())
    {
      throw new RuntimeException("List is empty!");
    }
    ListElement newEndOfList = current.getNext();
    current.setNext(null);
    current = newEndOfList;
    ListElement result = null;
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

  public ListElement find(int value)
  {
    if (current == null)
    {
      return null;
    }
    if (current.getValue() == value)
    {
      return current;
    }
    ListElement breakingStartChain = current;
    ListElement breakingEndChain = current.getNext();
    if (breakingEndChain.getValue() == value)
    {
      return breakingEndChain;
    }
    breakingStartChain.setNext(null);
    ListElement result = null;
    ListElement iterator = breakingEndChain;
    while (iterator.getNext() != null)
    {
      if (iterator.getValue() == value)
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
    ListElement nextChunkLink = current.getNext();
    if (nextChunkLink == null)
    {
      return result;
    }
    current.setNext(null);
    ListElement iterator = nextChunkLink;
    while (iterator.getNext() != null)
    {
      result += "," + iterator.getValue();
      iterator = iterator.getNext();
    }
    iterator.setNext(nextChunkLink);
    return result;
  }

  public ListElement resolveFlaviusIssue(int step, List<Integer> elements)
  {
    current = null;
    elements.forEach(this::insert);
    step();
    while (size() != 1)
    {
      ListElement previousElement = null;
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
    ListElement startOfChain = current;
    ListElement endOfChain = current.getNext();
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
