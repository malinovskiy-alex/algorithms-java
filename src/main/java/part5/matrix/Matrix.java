package part5.matrix;

public class Matrix
{
  private int height;
  private int width;
  private MatrixElement topCorner;

  public Matrix(int height, int width)
  {
    this.height = height;
    this.width = width;
    initializeMatrix();
  }

  private void initializeMatrix()
  {
    MatrixElement previousTopCorner = null;
    MatrixElement tempTopCorner = null;
    for (int i = 0; i < height; i++)
    {
      MatrixElement rightElement = null;
      for (int j = 0; j < width; j++)
      {
        MatrixElement element = new MatrixElement();
        if (j == 0)
        {
          tempTopCorner = element;
        }
        if (topCorner == null)
        {
          topCorner = element;
        }
        if (previousTopCorner != null)
        {
          previousTopCorner.setBottomElement(element);
          previousTopCorner = previousTopCorner.getRightElement();
        }
        if (rightElement != null)
        {
          rightElement.setRightElement(element);
        }
        rightElement = element;
      }
      previousTopCorner = tempTopCorner;
    }
  }

  public void insert(int row, int column, Integer value)
  {
    if (row - 1 > height || column - 1 > width)
    {
      throw new RuntimeException("Invalid column/row");
    }
    int currentRow = 0;
    MatrixElement iterator = topCorner;
    while ((row - 1) - currentRow > 0)
    {
      iterator = iterator.getBottomElement();
      currentRow++;
    }
    int currentColumn = 0;
    while ((column - 1) - currentColumn > 0)
    {
      iterator = iterator.getRightElement();
      currentColumn++;
    }
    iterator.setValue(value);
  }

  public void display()
  {
    MatrixElement rowIterator = topCorner;
    for (int i = 0; i < height; i++)
    {
      MatrixElement columnIterator = rowIterator;
      for (int j = 0; j < width; j++)
      {
        String result =
          columnIterator.getValue() == null ? "null" : columnIterator.getValue().toString();
        System.out.print(result + " ");
        columnIterator = columnIterator.getRightElement();
      }
      rowIterator = rowIterator.getBottomElement();
      System.out.println();
    }
  }
}
