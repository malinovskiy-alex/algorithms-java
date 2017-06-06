package part7.tasks;

import array.BasicIntArray;

public class FirstTaskPartition extends BasicIntArray
{
  public FirstTaskPartition(int elementsCount)
  {
    super(elementsCount);
  }

  public int partition(int left, int right, int target)
  {
    int leftPtr = left - 1;
    int rightPtr = right + 1;
    while (true)
    {
      while (leftPtr < right &&
        getArray()[++leftPtr] < target);

      while (rightPtr > left &&
        getArray()[--rightPtr] > target);

      if (leftPtr >= rightPtr)
        break;
      else
        swap(leftPtr, rightPtr);
    }
    return leftPtr;
  }
}
