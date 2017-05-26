package part8;

public class TreeOutputBuilder
{
  private char[][] output;

  public TreeOutputBuilder(int height)
  {
    if (height == 1)
    {
      this.output = new char[2][2];
    }
    else
    {
      this.output = new char[height][height * height];
    }
    for (int i = 0; i < output.length; i++)
    {
      for (int j = 0; j < output[i].length; j++)
      {
        output[i][j] = '-';
      }
    }
  }

  public void buildOutput(Node<Character> root)
  {
    int mid = 1;
    if ((output[0].length - 1) > 1)
    {
      mid = (output[0].length - 1) / 2;
    }
    inOrder(root.getRightChild(), mid, output[0].length - 1, 1);
    output[0][mid] = root.getElement();
    inOrder(root.getLeftChild(), 0, mid, 1);
  }

  private void inOrder(Node<Character> node, int start, int end, int height)
  {
    if (node != null)
    {
      int mid = (end + start) / 2;
      inOrder(node.getRightChild(), mid, end, height + 1);
      output[height][mid] = node.getElement();
      inOrder(node.getLeftChild(), start, mid, height + 1);
    }
  }

  public char[][] getOutput()
  {
    return this.output;
  }
}
