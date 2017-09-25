package part11;

public class LinearHashBuilder implements HashFunctionBuilder<Integer>
{
  public int getHashKey(DataItem<Integer> item, int arraySize)
  {
    return item.getKey() % arraySize;
  }
}
