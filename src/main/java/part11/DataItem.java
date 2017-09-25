package part11;

class DataItem<T>
{
  private T iData;

  public DataItem(T ii)
  {
    iData = ii;
  }

  public T getKey()
  {
    return iData;
  }

}
