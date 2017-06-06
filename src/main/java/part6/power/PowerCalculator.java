package part6.power;

public class PowerCalculator
{
  public int powerUp(int number, int power)
  {
    if (power == 0)
    {
      return 1;
    }
    if (power == 1)
    {
      return number;
    }
    return number * powerUp(number, power - 1);
  }
}
