package part11;

public class StringHashBuilder implements HashFunctionBuilder<String>
{
  public static final int DEFAULT_MULTIPLIER = 26;

  @Override
  public int getHashKey(DataItem<String> item, int arraySize)
  {
    int hash = 0;
    for (int charIndex = item.getKey().length() - 1; charIndex >= 0; charIndex--)
    {
      hash += (item.getKey().charAt(charIndex));
      if (charIndex > 0)
      {
        hash *= DEFAULT_MULTIPLIER;
      }
      hash %= arraySize;
    }
    return hash;
  }
}
