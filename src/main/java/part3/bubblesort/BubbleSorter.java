package part3.bubblesort;

import array.BasicIntArray;
import array.Sorter;

public class BubbleSorter extends BasicIntArray implements Sorter
{
  public BubbleSorter(int elementsCount)
  {
    super(elementsCount);
  }

  @Override
  public void sort()
  {
    for (int i = getElementsCount() - 1; i > 0; i--)
    {
      for (int j = 0; j < i; j++)
      {
        if (getArray()[j] > getArray()[j + 1])
        {
          swap(j, j + 1);
        }
      }
    }
  }
}
