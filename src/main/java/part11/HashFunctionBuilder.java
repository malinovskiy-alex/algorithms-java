package part11;

public interface HashFunctionBuilder<T>
{
  int getHashKey(DataItem<T> item, int arraySize);
}
