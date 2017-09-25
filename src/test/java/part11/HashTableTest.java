package part11;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class HashTableTest
{

  @Test
  public void insertShouldAddElementIntoTable()
  {
    //given
    HashTable temp = new HashTable(6);

    //when
    temp.insert(new DataItem(12));

    //then
    assertNotNull(temp.find(12));
  }

  @Test
  public void insertShouldCorrectlyUseQuadroHash()
  {
    //given
    HashTable temp = new
      HashTable(6);

    //when
    temp.insert(new DataItem(12));
    temp.insert(new DataItem(14));
    temp.insert(new DataItem(16));
    temp.insert(new DataItem(9));
    temp.insert(new DataItem(15));
    temp.insert(new DataItem(25));


    //then
    assertNotNull(temp.find(12));
  }


  @Test
  public void hashFuncShouldReturn6For10ArrayAnd16Key()
  {
    //given
    HashTable temp = new HashTable(10);

    //then
    assertEquals(6, temp.hashFunc(new DataItem(16)));
  }
}
