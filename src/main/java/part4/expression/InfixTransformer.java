package part4.expression;

import part4.MyStack;

public class InfixTransformer
{
  public String transform(String input)
  {
    MyStack<Character> operators = new MyStack<Character>(input.length());
    String output = "";
    for (int i = 0; i < input.length(); i++)
    {
      Character ch = input.charAt(i);
      switch (ch)
      {
        case '+':
        case '-':
          output += " " + handleInputOperator(ch, operators, 1);
          break;
        case '*':
        case '/':
          output += " " + handleInputOperator(ch, operators, 2);
          break;
        case '(':
          operators.push(ch);
          break;
        case ')':
          output += handleClosingBracket(operators);
          break;
        default:
          output += ch;
      }
    }
    while (!operators.isEmpty())
    {
      output += " " + operators.pop();
    }
    return output;
  }

  protected String handleInputOperator(
    Character operator,
    MyStack<Character> operators,
    int currentOperatorPriority)
  {
    String result = "";
    while (!operators.isEmpty())
    {
      Character topChar = operators.pop();
      if (topChar == '(')
      {
        operators.push(topChar);
        break;
      }
      else
      {
        int topOperatorPriority = 1;
        if (topChar == '/' || topChar == '*')
        {
          topOperatorPriority = 2;
        }
        if (topOperatorPriority >= currentOperatorPriority)
        {
          result += topChar + " ";
        }
        else
        {
          operators.push(topChar);
          break;
        }
      }
    }
    operators.push(operator);
    return result;
  }

  private String handleClosingBracket(
    MyStack<Character> operators)
  {
    String result = "";
    while (!operators.isEmpty())
    {
      Character topChar = operators.pop();
      if (topChar == '(')
      {
        break;
      }
      result += " " + topChar;
    }
    return result;
  }
}


