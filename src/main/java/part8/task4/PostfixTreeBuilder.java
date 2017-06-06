package part8.task4;

import part4.MyStack;
import part8.Node;
import part8.task1.LeafCharTree;

public class PostfixTreeBuilder extends LeafCharTree
{
  public PostfixTreeBuilder(String postfixExpression)
  {
    super(postfixExpression.toCharArray());
  }

  @Override
  protected void buildTree()
  {
    MyStack<Node<Character>> postfixNodes = new MyStack<>(characters.length);
    for (Node<Character> node : characters)
    {
      if (node.getElement() == '+' || node.getElement() == '-' || node.getElement() == '*' ||
        node.getElement() == '/')
      {
        Node right = postfixNodes.pop();
        Node left = postfixNodes.pop();
        node.setRightChild(right);
        node.setLeftChild(left);

        postfixNodes.push(node);
      }
      else
      {
        postfixNodes.push(node);
      }
    }
    setRoot(postfixNodes.pop());
  }

  public String getInfixString()
  {
    StringBuilder result = new StringBuilder();
    inOrder(result, this.getRoot());
    return result.toString();
  }

  public String getPrefixString()
  {
    StringBuilder result = new StringBuilder();
    preOrder(result, this.getRoot());
    return result.toString();
  }

  public String getPostfixString()
  {
    StringBuilder result = new StringBuilder();
    postOrder(result, this.getRoot());
    return result.toString();
  }

  private void postOrder(StringBuilder result, Node node)
  {
    if (node == null)
    {
      return;
    }
    postOrder(result, node.getLeftChild());
    postOrder(result, node.getRightChild());
    result.append(node.getElement());

  }

  private void preOrder(StringBuilder result, Node node)
  {
    if (node == null)
    {
      return;
    }
    result.append(node.getElement());
    preOrder(result, node.getLeftChild());
    preOrder(result, node.getRightChild());
  }

  private void inOrder(StringBuilder result, Node node)
  {
    if (node == null)
    {
      return;
    }
    result.append("(");
    inOrder(result, node.getLeftChild());
    result.append(node.getElement());
    inOrder(result, node.getRightChild());
    result.append(")");
  }
}
