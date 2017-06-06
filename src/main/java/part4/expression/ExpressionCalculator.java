package part4.expression;

import java.util.Arrays;
import java.util.List;

import part4.MyStack;

public class ExpressionCalculator
{
  public static final List<String> MATH_CHARS = Arrays.asList("+", "-", "*", "/");
  private InfixTransformer infixTransformer = new InfixTransformer();

  public String calculateResult(String input)
  {
    String infixForm = infixTransformer.transform(input);
    String[] parts = infixForm.split(" ");
    return calculateInfixForm(parts);
  }

  private String calculateInfixForm(String[] parts)
  {
    MyStack<String> stackForCalculation = new MyStack<>(parts.length);
    for (String part : parts)
    {
      if (!MATH_CHARS.contains(part))
      {
        stackForCalculation.push(part);
      }
      else
      {
        Integer second = Integer.valueOf(stackForCalculation.pop());
        Integer first = Integer.valueOf(stackForCalculation.pop());
        switch (part)
        {
          case "+":
            stackForCalculation.push(String.valueOf(first + second));
            break;
          case "-":
            stackForCalculation.push(String.valueOf(first - second));
            break;
          case "*":
            stackForCalculation.push(String.valueOf(first * second));
            break;
          case "/":
            stackForCalculation.push(String.valueOf(first / second));
            break;
          default:
            break;
        }
      }
    }
    return stackForCalculation.pop();
  }
}
