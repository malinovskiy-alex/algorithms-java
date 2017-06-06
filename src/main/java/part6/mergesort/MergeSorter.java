package part6.mergesort;

import array.BasicIntArray;

public class MergeSorter extends BasicIntArray
{
  public MergeSorter(int elementsCount)
  {
    super(elementsCount);
  }

  public void mergeSort()
  {
    int[] workspace = new int[getElementsCount()];
    recMergeSort(workspace, 0, getElementsCount() - 1);
  }

  private void recMergeSort(int[] workspace, int lowerBound, int upperBound)
  {
    if (lowerBound == upperBound)
    {
      return;
    }
    else
    {
      int mid = (lowerBound + upperBound) / 2;

      recMergeSort(workspace, lowerBound, mid);

      recMergeSort(workspace, mid + 1, upperBound);

      merge(workspace, lowerBound, mid + 1, upperBound);
    }
  }

  private void merge(int[] workspace, int lowPtr, int highPtr, int upperBound)
  {
    int j = 0;
    int lowerBound = lowPtr;
    int mid = highPtr - 1;
    int n = upperBound - lowerBound + 1;

    while (lowPtr <= mid && highPtr <= upperBound)
    {
      if (getArray()[lowPtr] < getArray()[highPtr])
      {
        workspace[j++] = getArray()[lowPtr++];
      }
      else
      {
        workspace[j++] = getArray()[highPtr++];
      }
    }

    while (lowPtr <= mid)
    {
      workspace[j++] = getArray()[lowPtr++];
    }

    while (highPtr <= upperBound)
    {
      workspace[j++] = getArray()[highPtr++];
    }

    for (j = 0; j < n; j++)
    {
      getArray()[lowerBound + j] = workspace[j];
    }
  }
}
