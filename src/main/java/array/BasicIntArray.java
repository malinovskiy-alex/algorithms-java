package array;

import utils.ArrayUtils;

public class BasicIntArray
{
  private int[] array;
  protected int elementsCount;

  public BasicIntArray(int elementsCount)
  {
    this.elementsCount = 0;
    this.array = new int[elementsCount];
  }

  public void insert(int e)
  {
    array[elementsCount++] = e;
  }

  public void swap(int index1, int index2)
  {
    int temp = getArray()[index1];
    getArray()[index1] = getArray()[index2];
    getArray()[index2] = temp;
  }

  public String display()
  {
    return ArrayUtils.getString(array);
  }

  public int[] getArray()
  {
    return array;
  }

  public int getElementsCount()
  {
    return elementsCount;
  }
}
