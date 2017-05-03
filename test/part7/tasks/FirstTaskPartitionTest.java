package part7.tasks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FirstTaskPartitionTest
{
  private FirstTaskPartition firstTaskPartition;

  @Test
  public void partitionShouldCorrecltyPartitionArrayIfElementIsPlacedInCenter()
  {
    firstTaskPartition = new FirstTaskPartition(7);
    firstTaskPartition.insert(7);
    firstTaskPartition.insert(11);
    firstTaskPartition.insert(1);
    firstTaskPartition.insert(3);
    firstTaskPartition.insert(20);
    firstTaskPartition.insert(5);
    firstTaskPartition.insert(7);

    firstTaskPartition.partition(0, firstTaskPartition.getElementsCount() - 1, 7);

    assertEquals("7,5,1,3,20,11,7", firstTaskPartition.display());
  }

  @Test
  public void partitionShouldCorrecltyPartitionArrayIfElementIsPlacedAtTheEnd()
  {
    firstTaskPartition = new FirstTaskPartition(7);
    firstTaskPartition.insert(7);
    firstTaskPartition.insert(11);
    firstTaskPartition.insert(1);
    firstTaskPartition.insert(3);
    firstTaskPartition.insert(5);
    firstTaskPartition.insert(7);
    firstTaskPartition.insert(20);

    firstTaskPartition.partition(0, firstTaskPartition.getElementsCount() - 1, 20);

    assertEquals("7,11,1,3,5,7,20", firstTaskPartition.display());
  }

  @Test
  public void partitionShouldCorrecltyPartitionArrayIfElementIsPlacedAtStart()
  {
    firstTaskPartition = new FirstTaskPartition(7);
    firstTaskPartition.insert(7);
    firstTaskPartition.insert(11);
    firstTaskPartition.insert(8);
    firstTaskPartition.insert(9);
    firstTaskPartition.insert(10);
    firstTaskPartition.insert(7);
    firstTaskPartition.insert(20);

    firstTaskPartition.partition(0, firstTaskPartition.getElementsCount() - 1, 7);

    assertEquals("7,11,8,9,10,7,20", firstTaskPartition.display());
  }

  @Test
  public void partitionShouldCorrecltyPartitionArrayIfElementIsNotInArray()
  {
    firstTaskPartition = new FirstTaskPartition(7);
    firstTaskPartition.insert(1);
    firstTaskPartition.insert(7);
    firstTaskPartition.insert(11);
    firstTaskPartition.insert(3);
    firstTaskPartition.insert(5);
    firstTaskPartition.insert(7);
    firstTaskPartition.insert(20);

    firstTaskPartition.partition(0, firstTaskPartition.getElementsCount() - 1, 10);

    assertEquals("1,7,7,3,5,11,20", firstTaskPartition.display());
  }

}