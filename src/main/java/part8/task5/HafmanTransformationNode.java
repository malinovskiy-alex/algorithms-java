package part8.task5;

public class HafmanTransformationNode
{
  private String code;
  private char element;

  public HafmanTransformationNode(String code, char element)
  {
    this.code = code;
    this.element = element;
  }

  public String getCode()
  {
    return code;
  }

  public char getElement()
  {
    return element;
  }
}
