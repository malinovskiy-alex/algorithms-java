package part4.expression;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExpressionCalculatorTest
{
  private ExpressionCalculator expressionCalculator = new ExpressionCalculator();

  @Test
  public void shouldCorrectlyCalculateSimpleExpression()
  {
    assertEquals("8", expressionCalculator.calculateResult("3+6-1"));
  }

}
