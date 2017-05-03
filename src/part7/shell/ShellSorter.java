package part7.shell;

import array.BasicIntArray;

public class ShellSorter extends BasicIntArray
{
  public ShellSorter(int elementsCount)
  {
    super(elementsCount);
  }

  public void sort()
  {
    int outer, inner;
    int h = 1;
    while (h <= getElementsCount() / 3)
    {
      h = h * 3 + 1;
    }
    while (h > 0)
    {
      for (outer = h; outer < getElementsCount(); outer++)
      {
        inner = outer;
        int currentElement = getArray()[outer];
        while (inner > h - 1 && getArray()[inner - h] > currentElement)
        {
          int temp = getArray()[inner - h];
          getArray()[inner - h] = currentElement;
          getArray()[inner] = temp;
          inner -= h;
        }
      }
      h = (h - 1) / 3;
    }
  }
}
