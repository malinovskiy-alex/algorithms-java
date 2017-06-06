package part6.power;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerCalculatorTest
{
  private PowerCalculator test = new PowerCalculator();

  @Test
  public void powerUpShouldReturn81For3In3Power()
  {
    assertEquals(27, test.powerUp(3, 3));
  }

  @Test
  public void powerUpShouldReturn3For3In1Power()
  {
    assertEquals(3, test.powerUp(3, 1));
  }

  @Test
  public void powerUpShouldReturn1For3In0Power()
  {
    assertEquals(1, test.powerUp(3, 0));
  }
}
