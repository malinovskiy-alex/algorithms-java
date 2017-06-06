package part7.quicksort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuickSorterMedianTest
{
  private QuickSorterMedian sorter;

  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCall()
  {
    sorter = new QuickSorterMedian(8);
    sorter.insert(20);
    sorter.insert(17);
    sorter.insert(13);
    sorter.insert(12);
    sorter.insert(11);
    sorter.insert(8);
    sorter.insert(7);
    sorter.insert(5);

    sorter.sort();

    System.out
      .println("Comparisons count for " + sorter.getElementsCount() + " elements sorting: " +
        sorter.getComparisonsCount());

    System.out
      .println("Replaces count for " + sorter.getElementsCount() + " elements sorting: " +
        sorter.getReplacingCount());

    assertEquals("5,7,8,11,12,13,17,20", sorter.display());
  }

  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCallWithArrayOf13Elements()
  {
    sorter = new QuickSorterMedian(13);
    sorter.insert(7);
    sorter.insert(11);
    sorter.insert(1);
    sorter.insert(3);
    sorter.insert(20);
    sorter.insert(5);
    sorter.insert(7);
    sorter.insert(4);
    sorter.insert(10);
    sorter.insert(17);
    sorter.insert(18);
    sorter.insert(21);
    sorter.insert(13);

    sorter.sort();

    System.out
      .println("Comparisons count for " + sorter.getElementsCount() + " elements sorting: " +
        sorter.getComparisonsCount());

    System.out
      .println("Replaces count for " + sorter.getElementsCount() + " elements sorting: " +
        sorter.getReplacingCount());

    assertEquals("1,3,4,5,7,7,10,11,13,17,18,20,21", sorter.display());
  }

  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCallWithArrayOf11Elements()
  {
    sorter = new QuickSorterMedian(11);
    sorter.insert(7);
    sorter.insert(11);
    sorter.insert(1);
    sorter.insert(3);
    sorter.insert(20);
    sorter.insert(5);
    sorter.insert(7);
    sorter.insert(4);
    sorter.insert(10);
    sorter.insert(17);
    sorter.insert(18);

    sorter.sort();

    System.out
      .println("Comparisons count for " + sorter.getElementsCount() + " elements sorting: " +
        sorter.getComparisonsCount());

    System.out
      .println("Replaces count for " + sorter.getElementsCount() + " elements sorting: " +
        sorter.getReplacingCount());

    assertEquals("1,3,4,5,7,7,10,11,17,18,20", sorter.display());
  }

  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCallWithArrayOf12ElementsSortedInReverseOrder()
  {
    sorter = new QuickSorterMedian(12);
    sorter.insert(13);
    sorter.insert(12);
    sorter.insert(11);
    sorter.insert(10);
    sorter.insert(9);
    sorter.insert(8);
    sorter.insert(7);
    sorter.insert(6);
    sorter.insert(5);
    sorter.insert(4);
    sorter.insert(3);
    sorter.insert(2);

    sorter.sort();

    System.out
      .println("Comparisons count for " + sorter.getElementsCount() + " elements sorting: " +
        sorter.getComparisonsCount());

    System.out
      .println("Replaces count for " + sorter.getElementsCount() + " elements sorting: " +
        sorter.getReplacingCount());

    assertEquals("2,3,4,5,6,7,8,9,10,11,12,13", sorter.display());
  }
}