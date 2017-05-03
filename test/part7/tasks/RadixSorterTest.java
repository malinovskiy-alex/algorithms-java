package part7.tasks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RadixSorterTest
{
  private RadixSorter sorter;

  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCall()
  {
    sorter = new RadixSorter(7);
    sorter.insert(7);
    sorter.insert(11);
    sorter.insert(1);
    sorter.insert(3);
    sorter.insert(20);
    sorter.insert(5);
    sorter.insert(7);

    sorter.sort();

    assertEquals("1,3,5,7,7,11,20", sorter.display());
  }

  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCallWithArrayOf11Elements()
  {
    sorter = new RadixSorter(11);
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

    assertEquals("1,3,4,5,7,7,10,11,17,18,20", sorter.display());
  }

  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCallWithArrayOf13Elements()
  {
    sorter = new RadixSorter(13);
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

    assertEquals("1,3,4,5,7,7,10,11,13,17,18,20,21", sorter.display());
  }
}