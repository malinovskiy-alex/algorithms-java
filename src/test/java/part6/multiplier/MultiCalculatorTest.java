package part6.multiplier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiCalculatorTest
{
  private MultiCalculator test = new MultiCalculator();

  @Test
  public void multShouldReturn9For3MultipliedBy3()
  {
    assertEquals(9, test.mult(3, 3));
  }

  @Test
  public void multShouldReturnFor10MultipliedBy1()
  {
    assertEquals(10, test.mult(10, 1));
  }

  @Test
  public void multShouldReturn0For10MultipliedBy0()
  {
    assertEquals(0, test.mult(10, 0));
  }
}
