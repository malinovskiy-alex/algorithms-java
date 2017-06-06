package part6.tree;

import utils.MatrixUtils;

public class TreeBuilder
{

  private char[][] resultingArray;

  public void branches(int branchesCount)
  {
    int height = MatrixUtils.getHeightByWidthForTree(branchesCount);
    resultingArray = new char[height][branchesCount];
    branches(resultingArray, 0, resultingArray[0].length, 0);
  }

  private void branches(char[][] resultingArray, int leftCorner, int rightCorner, int currentHeight)
  {
    if (currentHeight > MatrixUtils.getHeightByWidthForTree(resultingArray[0].length - 1))
    {
      return;

    }
    int mid = (rightCorner - leftCorner) / 2;
    for (int i = leftCorner; i < rightCorner; i++)
    {
      if (i == leftCorner + mid)
      {
        resultingArray[currentHeight][i] = 'x';
      }
      else
      {
        resultingArray[currentHeight][i] = '-';
      }
    }

    //for left corner
    branches(resultingArray, leftCorner, leftCorner + mid, currentHeight + 1);

    //for right corner
    branches(resultingArray, leftCorner + mid, rightCorner, currentHeight + 1);

  }

  public void display()
  {
    MatrixUtils.display(resultingArray);
  }
}
