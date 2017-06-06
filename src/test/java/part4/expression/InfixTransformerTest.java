package part4.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import part4.MyStack;

public class InfixTransformerTest
{
  private InfixTransformer transformer = new InfixTransformer();

  @Test
  public void testInfixTransformationSimpleOperators()
  {
    assertEquals("A B + C -", transformer.transform("A+B-C"));
  }

  @Test
  public void testInfixTransformationSimpleAndNotSimpleOperators()
  {
    assertEquals("A B C * -", transformer.transform("A-B*C"));
  }

  @Test
  public void testInfixTransformationSimpleAndNotSimpleAndBrackets()
  {
    assertEquals("A B - C D - +", transformer.transform("A-B+(C-D)"));
  }

  @Test
  public void handleInputOperatorShouldCorrectlyHandlePlusAndThenMinus()
  {
    MyStack<Character> plus = new MyStack<Character>(2);
    plus.push('+');
    assertEquals("+ ", transformer.handleInputOperator('-', plus, 1));
  }

  @Test
  public void handleInputOperatorShouldCorrectlyHandlePlusAndThenMultiply()
  {
    MyStack<Character> plus = new MyStack<Character>(2);
    plus.push('+');

    transformer.handleInputOperator('*', plus, 2);

    assertTrue('*' == plus.pop());
    assertTrue('+' == plus.pop());
  }

  @Test
  public void handleInputOperatorShouldCorrectlyHandleMultiplyAndThenPlus()
  {
    MyStack<Character> plus = new MyStack<Character>(2);
    plus.push('*');

    assertEquals("* ", transformer.handleInputOperator('+', plus, 2));

    assertTrue('+' == plus.pop());
  }

  @Test
  public void handleInputOperatorShouldCorrectlyHandleBracketAndThenPlus()
  {
    MyStack<Character> plus = new MyStack<Character>(3);
    plus.push('*');
    plus.push('(');

    assertEquals("", transformer.handleInputOperator('+', plus, 1));

    assertTrue('+' == plus.pop());
    assertTrue('(' == plus.pop());
    assertTrue('*' == plus.pop());
  }

  @Test
  public void testInfixTransformationShouldCorrectlyHandleComplexSentence()
  {
    assertEquals("AQ B C + * D E F + / -", transformer.transform("AQ*(B+C)-D/(E+F)"));
  }

}
