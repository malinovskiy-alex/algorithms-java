package part8.task3;

import part8.Node;
import part8.task1.LeafCharTree;

public class SimpleCharTreeBuilder extends LeafCharTree
{

  public SimpleCharTreeBuilder(char... characters)
  {
    super(characters);
  }

  @Override
  public void buildTree()
  {
    int startIndex = 1;
    setRoot(characters[startIndex - 1]);
    Node leftChild = characters[startIndex * 2 - 1];
    Node rightChild = characters[startIndex * 2];
    getRoot().setLeftChild(leftChild);
    getRoot().setRightChild(rightChild);

    populate(leftChild, startIndex * 2);
    populate(rightChild, startIndex * 2 + 1);
  }

  private void populate(Node node, int nodeIndex)
  {
    if (node == null)
    {
      return;
    }
    Node leftChild = null;
    int newLeftIndex = nodeIndex * 2;
    Node rightChild = null;
    int newRightIndex = nodeIndex * 2 + 1;
    if (newLeftIndex - 1 < characters.length)
    {
      leftChild = characters[newLeftIndex - 1];
    }
    if (newRightIndex - 1 < characters.length)
    {
      rightChild = characters[newRightIndex - 1];
    }

    node.setLeftChild(leftChild);
    node.setRightChild(rightChild);

    populate(leftChild, newLeftIndex);
    populate(rightChild, newRightIndex);
  }

  public String getDisplayString()
  {
    return "";
  }
}
