package part8.task2;

import part4.MyCyclicQueue;
import part8.Node;
import part8.task1.LeafCharTree;

public class BalancedLeafCharTree extends LeafCharTree
{
  public BalancedLeafCharTree(char... chars)
  {
    super(chars);
  }

  @Override
  protected void buildTree()
  {
    while (characters.length != 1)
    {
      Node[] resultStorage;
      if (characters.length % 2 == 0)
      {
        resultStorage = new Node[characters.length / 2];
      }
      else
      {
        resultStorage = new Node[(characters.length / 2) + 1];
      }
      MyCyclicQueue<Node> tempStorage = new MyCyclicQueue<>(characters.length);
      for (int i = 0; i < characters.length; i++)
      {
        tempStorage.push(characters[i]);
      }
      int arrayIndex = 0;
      while (!tempStorage.isEmpty())
      {
        Node rightChild = tempStorage.pop();
        Node leftChild = null;
        if (!tempStorage.isEmpty())
        {
          leftChild = tempStorage.pop();
        }
        Node localRoot = new Node('+');
        localRoot.setRightChild(rightChild);
        localRoot.setLeftChild(leftChild);
        resultStorage[arrayIndex++] = localRoot;
      }
      characters = resultStorage;
    }

    setRoot(characters[0]);
  }
}
