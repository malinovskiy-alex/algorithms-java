package part3.insertsort;

import array.BasicIntArray;

public class InsertSorter extends BasicIntArray
{
  public InsertSorter(int elementsCount)
  {
    super(elementsCount);
  }

  public void sort()
  {
    for (int outer = 1; outer < getElementsCount(); outer++)
    {
      int currentElement = getArray()[outer];
      int inner = outer;
      while (inner > 0 && getArray()[inner - 1] > currentElement)
      {
        int temp = getArray()[inner - 1];
        getArray()[inner - 1] = currentElement;
        getArray()[inner] = temp;
        inner--;
      }
    }
  }
}
