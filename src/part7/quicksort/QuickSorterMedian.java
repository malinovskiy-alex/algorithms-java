package part7.quicksort;

import array.BasicIntArray;
import array.Sorter;

public class QuickSorterMedian extends BasicIntArray implements Sorter
{

  private int comparisonsCount = 0;
  private int copyingCount = 0;
  private int replacingCount = 0;

  public QuickSorterMedian(int elementsCount)
  {
    super(elementsCount);
  }

  @Override
  public void sort()
  {
    recQuickSort(0, getElementsCount() - 1);
  }

  private void recQuickSort(int left, int right)
  {
    int size = right - left + 1;
    if (size <= 3)
    {
      manualSort(left, right, size);
    }
    else
    {
      int target = getMedianOf3(left, right);
      int middle = partitionIt(left, right, target);
      recQuickSort(left, middle - 1);
      recQuickSort(middle + 1, right);
    }
  }

  private int partitionIt(int left, int right, int target)
  {
    int leftCorner = left;
    int rightCorner = right - 1;
    int initialComparisonsCount = comparisonsCount;
    while (rightCorner > left)
    {
      int leftBeforeCompare = leftCorner;

      while (getArray()[++leftCorner] < target)
      {
      }

      comparisonsCount += leftCorner - leftBeforeCompare;

      int rightBeforeCompare = rightCorner;

      while (getArray()[--rightCorner] > target)
      {
      }

      comparisonsCount += rightBeforeCompare - rightCorner;

      //comparisonsCount += 1;
      if (leftCorner >= rightCorner)
      {
        break;
      }
      else
      {
        swap(leftCorner, rightCorner);
      }
    }

    System.err.println(
      "Comparisons count for " + (right - left + 1) + " elements is: " +
        (comparisonsCount - initialComparisonsCount));

    swap(leftCorner, right - 1);
    return leftCorner;
  }

  protected int getMedianOf3(int left, int right)
  {
    int center = (left + right) / 2;
    sortOf3(left, center, right);
    swap(center, right - 1);
    return getArray()[right - 1];
  }

  private void manualSort(int index1, int index2, int size)
  {
    if (size <= 1)
    {
      return;
    }
    else if (size == 2)
    {
      if (getArray()[index1] > getArray()[index2])
      {
        swap(index1, index2);
      }
      comparisonsCount += 1;
    }
    else
    {
      sortOf3(index1, index2 - 1, index2);
    }
  }

  private void sortOf3(int left, int center, int right)
  {
    if (getArray()[left] > getArray()[center])
    {
      swap(left, center);
    }
    if (getArray()[center] > getArray()[right])
    {
      swap(center, right);
    }
    if (getArray()[left] > getArray()[center])
    {
      swap(left, center);
    }
    comparisonsCount += 3;
  }

  public int getComparisonsCount()
  {
    return comparisonsCount;
  }

  public int getCopyingCount()
  {
    return copyingCount;
  }

  public int getReplacingCount()
  {
    return replacingCount;
  }

  @Override
  public void swap(int index1, int index2)
  {
    super.swap(index1, index2);
    copyingCount += 3;
    replacingCount += 1;
  }
}
