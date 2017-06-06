package part6.bagpack;

import utils.ArrayUtils;

public class BagCalculator
{
  private int[] things;
  private int maxSum;

  public BagCalculator(int[] things, int maxSum)
  {
    this.things = things;
    this.maxSum = maxSum;
  }

  public void checkSizes()
  {
    checkSizes(things, new int[0], 0, maxSum);
  }

  private void checkSizes(int[] things, int[] resultArray, int sum, int requiredSum)
  {
    if (sum == requiredSum)
    {
      ArrayUtils.display(resultArray);
      return;
    }
    if (sum > requiredSum)
    {
      return;
    }
    for (int i = 0; i < things.length; i++)
    {
      checkSizes(reduceArray(things, i + 1), sumArray(resultArray, things[i]), sum + things[i],
        requiredSum);
    }
  }

  private int[] reduceArray(int[] initialArray, int startPoint)
  {
    int[] result = new int[initialArray.length - startPoint];
    int i;
    for (i = 0; i < result.length; i++)
    {
      result[i] = initialArray[i + startPoint];
    }
    return result;
  }

  private int[] sumArray(int[] initialArray, int newThing)
  {
    int[] result = new int[initialArray.length + 1];
    int i;
    for (i = 0; i < initialArray.length; i++)
    {
      result[i] = initialArray[i];
    }
    result[i] = newThing;
    return result;
  }
}
