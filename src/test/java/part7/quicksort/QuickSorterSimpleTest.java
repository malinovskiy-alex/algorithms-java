package part7.quicksort;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class QuickSorterSimpleTest
{
  private QuickSorterSimple sorter;

  @Test
  @Ignore
  public void partitionShouldCorrecltyPartitionArrayIfElementIsPlacedInCenter()
  {
    sorter = new QuickSorterSimple(7);
    sorter.insert(7);
    sorter.insert(11);
    sorter.insert(1);
    sorter.insert(3);
    sorter.insert(20);
    sorter.insert(5);
    sorter.insert(7);

    sorter.partition(7);

    assertEquals("5,3,1,11,20,7,7", sorter.display());
  }

  @Test
  @Ignore
  public void partitionShouldCorrecltyPartitionArrayIfElementIsPlacedAtTheEnd()
  {
    sorter = new QuickSorterSimple(7);
    sorter.insert(7);
    sorter.insert(11);
    sorter.insert(1);
    sorter.insert(3);
    sorter.insert(5);
    sorter.insert(7);
    sorter.insert(20);

    sorter.partition(20);

    assertEquals("7,11,1,3,5,7,20", sorter.display());
  }

  @Test
  @Ignore
  public void partitionShouldCorrecltyPartitionArrayIfElementIsPlacedAtStart()
  {
    sorter = new QuickSorterSimple(7);
    sorter.insert(7);
    sorter.insert(11);
    sorter.insert(8);
    sorter.insert(9);
    sorter.insert(10);
    sorter.insert(7);
    sorter.insert(20);

    sorter.partition(7);

    assertEquals("7,11,8,9,10,7,20", sorter.display());
  }

  @Test
  @Ignore
  public void partitionShouldCorrecltyPartitionArrayIfElementIsNotInArray()
  {
    sorter = new QuickSorterSimple(7);
    sorter.insert(1);
    sorter.insert(7);
    sorter.insert(11);
    sorter.insert(3);
    sorter.insert(5);
    sorter.insert(7);
    sorter.insert(20);

    sorter.partition(10);

    assertEquals("1,7,7,3,5,11,20", sorter.display());
  }

  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCall()
  {
    sorter = new QuickSorterSimple(7);
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
  public void sorterShouldReturnSortedArrayAfterSortingCallWithArrayOf13Elements()
  {
    sorter = new QuickSorterSimple(13);
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


  @Test
  public void sorterShouldReturnSortedArrayAfterSortingCallWithArrayOf11Elements()
  {
    sorter = new QuickSorterSimple(11);
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
}