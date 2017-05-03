package part7.quicksort;

import array.BasicIntArray;
import array.Sorter;

public class QuickSorterSimple extends BasicIntArray implements Sorter
{
  public QuickSorterSimple(int elementsCount)
  {
    super(elementsCount);
  }

  public void sort()
  {
    sort(0, getElementsCount() - 1);
  }

  private void sort(int left, int right)
  {
    if (right - left <= 0)
    {
      return;
    }
    int target = getArray()[right];
    int separatingIndex = partition(left, right, target);
    sort(left, separatingIndex - 1);
    sort(separatingIndex + 1, right);
  }

  private int partition(int left, int right, int target)
  {
    int rightCorner = right;
    while (left < right)
    {
      //finding element from left to swap
      while (left < right && getArray()[left] < target)
      {
        left++;
      }

      //finding element from right to swap
      while (right > left && getArray()[right] >= target)
      {
        right--;
      }

      if (left == right)
      {
        break;
      }
      else
      {
        swap(left, right);
      }
    }
    swap(left, rightCorner);
    return left;
  }

  public void partition(int target)
  {
    partition(0, getElementsCount() - 1, target);
  }

}
