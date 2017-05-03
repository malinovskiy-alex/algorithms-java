package utils;

public class ArrayUtils
{
  public static void display(int[] array)
  {
    System.out.println(getString(array));
  }

  public static String getString(int[] array)
  {
    String result = "";
    for (int anArray : array)
    {
      if (!result.equals(""))
      {
        result += ",";
      }
      result += anArray;
    }
    return result;
  }

  public static void display(char[] array)
  {
    String result = "";
    for (char anArray : array)
    {
      if (!result.equals(""))
      {
        result += ",";
      }
      result += anArray;
    }
    System.out.println(result);
  }
}
