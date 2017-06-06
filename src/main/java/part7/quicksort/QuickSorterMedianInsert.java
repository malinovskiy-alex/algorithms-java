package part7.quicksort;

import array.BasicIntArray;
import array.Sorter;

public class QuickSorterMedianInsert extends BasicIntArray implements Sorter
{
  public QuickSorterMedianInsert(int elementsCount)
  {
    super(elementsCount);
  }

  @Override
  public void sort()
  {
    recSort(0, getElementsCount() - 1);
  }

  private void recSort(int left, int right)
  {
    int size = right - left + 1;
    if (size < 10)
    {
      insertSort(left, right);
    }
    else
    {
      int median = getMedianOf3(left, right);
      int centerPoint = partitionIt(left, right, median);
      recSort(left, centerPoint - 1);
      recSort(centerPoint + 1, right);
    }
  }

  private int getMedianOf3(int left, int right)
  {
    int center = (right + left) / 2;
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
    swap(center, right - 1);
    return getArray()[right - 1];
  }

  private int partitionIt(int left, int right, int target)
  {
    int rightCorner = right - 1;
    while (rightCorner > left)
    {
      while (getArray()[++left] < target)
      {

      }
      while (getArray()[--rightCorner] > target)
      {

      }
      if (left >= rightCorner)
      {
        break;
      }
      else
      {
        swap(left, rightCorner);
      }
    }
    swap(left, right - 1);
    return left;
  }

  private void insertSort(int left, int right)
  {
    for (int start = left + 1; start <= right; start++)
    {
      int currentElement = getArray()[start];
      int currentIndex = start;
      while (currentIndex > left && currentElement < getArray()[currentIndex - 1])
      {
        swap(currentIndex, currentIndex - 1);
        currentIndex--;
      }
    }
  }
}
