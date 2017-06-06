package utils;

public class MatrixUtils
{
  public static void display(char[][] elements)
  {
    for (int i = 0; i < elements.length; i++)
    {
      for (int j = 0; j < elements[i].length; j++)
      {
        System.out.print(elements[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static int getHeightByWidthForTree(int width)
  {
    int count = 0;
    while (width >= 1)
    {
      count++;
      width /= 2;
    }
    return count;
  }
}
