package part10;

public class Tree234<T extends Comparable>
{
  private NodeMultiChild<T> root;

  public T getMin()
  {
    if (this.root == null)
    {
      return null;
    }
    NodeMultiChild<T> minLeaf = this.root;
    while (!minLeaf.isLeaf())
    {
      minLeaf = minLeaf.getChildAt(0);
    }
    return (T) minLeaf.getDataArray()[0];
  }

  public void insert(T element)
  {
    if (this.root == null)
    {
      NodeMultiChild<T> root = new NodeMultiChild<>(3);
      root.insertInDataArray(element);
      this.root = root;
    }
    else
    {
      NodeMultiChild<T> nodeForInsertion = this.root;
      while (!nodeForInsertion.isLeaf())
      {
        if (nodeForInsertion.isFull())
        {
          split(nodeForInsertion);
          nodeForInsertion = nodeForInsertion.getParent().getNextChildNode(element);
        }
        nodeForInsertion = nodeForInsertion.getNextChildNode(element);
      }
      if (nodeForInsertion.isFull())
      {
        split(nodeForInsertion);
        nodeForInsertion = nodeForInsertion.getParent().getNextChildNode(element);
      }
      nodeForInsertion.insertInDataArray(element);
    }
  }

  private void split(NodeMultiChild<T> node)
  {
    NodeMultiChild<T> root = node.getParent();
    T nodeToMoveUp = node.extractDataElement(1);
    T leftElement = node.extractDataElement(2);
    NodeMultiChild<T> newLeftNode = new NodeMultiChild<>(3);
    newLeftNode.insertInDataArray(leftElement);
    if (root != null)
    {
      int indexForRootInsertion = root.insertInDataArray(nodeToMoveUp);
      NodeMultiChild<T> child1 = node.extractChild(2);
      NodeMultiChild<T> child2 = node.extractChild(3);
      newLeftNode.insertChild(child1, 0);
      newLeftNode.insertChild(child2, 1);
      child1.setParent(newLeftNode);
      child2.setParent(newLeftNode);
      for (int i = indexForRootInsertion; i < root.getExistingElements() + 1; i++)
      {
        root.insertChild(root.extractChild(i), i + 1);
      }
      root.insertChild(newLeftNode, indexForRootInsertion + 1);
      newLeftNode.setParent(root);
    }
    else
    {
      NodeMultiChild<T> newRoot = new NodeMultiChild<>(3);
      newRoot.insertInDataArray(nodeToMoveUp);
      newRoot.insertChild(node, 0);
      newRoot.insertChild(newLeftNode, 1);
      newLeftNode.setParent(newRoot);
      node.setParent(newRoot);
      this.root = newRoot;
    }
  }

  public void symmetricPrint()
  {
    symmetricPrint(this.root);
  }

  private void symmetricPrint(NodeMultiChild<T> node)
  {
    if (node == null)
    {
      return;
    }
    for (int i = 0; i < node.getExistingElements(); i++)
    {
      if (i == 0)
      {
        symmetricPrint(node.getChildAt(i));
      }
      System.out.println(node.getDataArray()[i]);
      symmetricPrint(node.getChildAt(i + 1));
    }
  }

  public NodeMultiChild<T> getRoot()
  {
    return root;
  }
}
