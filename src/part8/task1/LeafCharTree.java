package part8.task1;

import part8.Node;
import part8.TreeOutputBuilder;
import utils.MatrixUtils;

public class LeafCharTree
{
  private Node root;

  protected Node[] characters;

  protected TreeOutputBuilder outputBuilder;

  public Node getRoot()
  {
    return root;
  }

  public void setRoot(Node root)
  {
    this.root = root;
  }

  public LeafCharTree(char... chars)
  {
    this.characters = new Node[chars.length];
    for (int i = 0; i < chars.length; i++)
    {
      Node n = new Node(chars[i]);
      characters[i] = n;
    }
    outputBuilder = new TreeOutputBuilder(chars.length);
  }

  public void build()
  {
    buildTree();
    outputBuilder.buildOutput(this.root);
    MatrixUtils.display(outputBuilder.getOutput());
  }

  protected void buildTree()
  {
    if (characters.length == 1)
    {
      Node localRoot = new Node('+');
      Node leftChild = characters[0];
      localRoot.setLeftChild(leftChild);
      this.root = localRoot;
    }
    else
    {
      for (int i = 1; i < characters.length; i++)
      {
        Node localRoot = new Node('+');
        Node leftChild = characters[i - 1];
        Node rightChild = characters[i];
        localRoot.setLeftChild(leftChild);
        localRoot.setRightChild(rightChild);
        characters[i] = localRoot;
      }
      this.root = characters[characters.length - 1];
    }
  }

  public String getDisplayString()
  {
    return "";
  }
}
