package part6.multiplier;

public class MultiCalculator
{
  public int mult(int x, int y)
  {
    if (y == 0)
    {
      return 0;
    }
    if (y == 1)
    {
      return x;
    }
    return x + mult(x, y - 1);
  }
}
