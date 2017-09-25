package part11;

class HashTable
{
  private DataItem<Integer>[] hashArray;
  private int arraySize;
  private DataItem<Integer> nonItem;
  private HashFunctionBuilder hashFunctionBuilder = new LinearHashBuilder();

  public HashTable(int size)
  {
    arraySize = size;
    hashArray = new DataItem[arraySize];
    nonItem = new DataItem<>(-1);
  }

  public void displayTable()
  {
    System.out.print("Table: ");
    for (int j = 0; j < arraySize; j++)
    {
      if (hashArray[j] != null)
        System.out.print(hashArray[j].getKey() + " ");
      else
        System.out.print("** ");
    }
    System.out.println("");
  }

  public int hashFunc(DataItem item)
  {
    return hashFunctionBuilder.getHashKey(item, arraySize);
  }

  public void insert(DataItem<Integer> item)
  {
    int hashVal = hashFunc(item);
    int index = 1;
    while (hashArray[hashVal] != null &&
      hashArray[hashVal].getKey() != -1)
    {
      hashVal += (index * index);
      hashVal %= arraySize;
      index++;
    }
    hashArray[hashVal] = item;
  }

  public DataItem delete(int key)
  {
    DataItem<Integer> item = new DataItem<>(key);
    int hashVal = hashFunc(item);
    while (hashArray[hashVal] != null)
    {
      if (hashArray[hashVal].getKey() == key)
      {
        DataItem temp = hashArray[hashVal];
        hashArray[hashVal] = nonItem;
        return temp;
      }
      ++hashVal;
      hashVal %= arraySize;
    }
    return null;
  }

  public DataItem find(int key)
  {
    DataItem<Integer> item = new DataItem<>(key);
    int hashVal = hashFunc(item);
    while (hashArray[hashVal] != null)
    {
      if (hashArray[hashVal].getKey() == key)
        return hashArray[hashVal];
      ++hashVal;
      hashVal %= arraySize;
    }
    return null;

  }
}