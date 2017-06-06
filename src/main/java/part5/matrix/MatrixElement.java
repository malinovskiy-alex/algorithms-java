package part5.matrix;

public class MatrixElement
{
  private Integer value;
  private MatrixElement rightElement;
  private MatrixElement bottomElement;

  public MatrixElement()
  {
  }

  public MatrixElement(Integer value)
  {
    this.value = value;
  }

  public Integer getValue()
  {
    return value;
  }

  public void setValue(Integer value)
  {
    this.value = value;
  }

  public MatrixElement getRightElement()
  {
    return rightElement;
  }

  public void setRightElement(MatrixElement rightElement)
  {
    this.rightElement = rightElement;
  }

  public MatrixElement getBottomElement()
  {
    return bottomElement;
  }

  public void setBottomElement(MatrixElement bottomElement)
  {
    this.bottomElement = bottomElement;
  }
}
