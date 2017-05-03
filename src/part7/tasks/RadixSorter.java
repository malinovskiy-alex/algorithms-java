package part7.tasks;

import array.BasicIntArray;
import array.Sorter;
import part4.MyCyclicQueue;

public class RadixSorter extends BasicIntArray implements Sorter
{
  //by default we use numbers from 0 to 9
  private MyCyclicQueue[] numberGroups = new MyCyclicQueue[10];
  private int maxCypherCount = 0;

  public RadixSorter(int elementsCount)
  {
    super(elementsCount);
    for (int groupNumber = 0; groupNumber < numberGroups.length; groupNumber++)
    {
      numberGroups[groupNumber] = new MyCyclicQueue<Integer>(elementsCount);
    }
  }

  @Override
  public void insert(int e)
  {
    super.insert(e);
    int currentCypherCount = String.valueOf(e).length();
    if (currentCypherCount > maxCypherCount)
    {
      maxCypherCount = currentCypherCount;
    }
  }

  @Override
  public void sort()
  {
    for (int cypherIndex = 0; cypherIndex < maxCypherCount; cypherIndex++)
    {
      for (int elementIndex = 0; elementIndex < getElementsCount(); elementIndex++)
      {
        int element = getArray()[elementIndex];
        int elementCypher = getCypherByCurrentCypherIndex(element, cypherIndex);
        numberGroups[elementCypher].push(element);
      }

      elementsCount = 0;
      for (int groupIndex = 0; groupIndex < numberGroups.length; groupIndex++)
      {
        MyCyclicQueue<Integer> numbersStack = numberGroups[groupIndex];
        while (!numbersStack.isEmpty())
        {
          insert(numbersStack.pop());
        }
      }
    }
  }

  private Integer getCypherByCurrentCypherIndex(int element, int cypherIndex)
  {
    int elementCypherCount = String.valueOf(element).length();
    if (cypherIndex + 1 > elementCypherCount)
    {
      return 0;
    }
    return Integer.valueOf(String.valueOf(
      String.valueOf(String.valueOf(element).charAt(elementCypherCount - cypherIndex - 1))));
  }
}
