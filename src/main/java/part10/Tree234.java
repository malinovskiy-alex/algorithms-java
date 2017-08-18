package part10;

public class Tree234<T extends Comparable>
{
  private Node234<T> root;

  public T getMin()
  {
    if (this.root == null)
    {
      return null;
    }
    Node234<T> minLeaf = this.root;
    while (!minLeaf.isLeaf())
    {
      minLeaf = minLeaf.getMinChild();
    }
    return (T) minLeaf.getDataArray()[0];
  }

  public void insert(T element)
  {
    if (this.root == null)
    {
      Node234<T> root = new Node234<>();
      root.insertInDataArray(element);
      this.root = root;
    }
    else
    {
      Node234<T> nodeForInsertion = this.root;
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

  private void split(Node234<T> node)
  {
    Node234<T> root = node.getParent();
    T nodeToMoveUp = node.extractDataElement(1);
    T leftElement = node.extractDataElement(2);
    Node234<T> newLeftNode = new Node234<>();
    newLeftNode.insertInDataArray(leftElement);
    if (root != null)
    {
      int indexForRootInsertion = root.insertInDataArray(nodeToMoveUp);
      Node234<T> child1 = root.extractChild(2);
      Node234<T> child2 = root.extractChild(3);
      newLeftNode.insertChild(child1, 0);
      newLeftNode.insertChild(child2, 1);
      for (int i = indexForRootInsertion; i < root.getDataElementsSize() + 1; i++)
      {
        root.insertChild(root.extractChild(i), i + 1);
      }
      root.insertChild(newLeftNode, indexForRootInsertion + 1);
      newLeftNode.setParent(root);
    }
    else
    {
      Node234<T> newRoot = new Node234<>();
      newRoot.insertInDataArray(nodeToMoveUp);
      newRoot.insertChild(node, 0);
      newRoot.insertChild(newLeftNode, 1);
      node.setParent(newRoot);
      this.root = newRoot;
    }
  }

  public Node234<T> getRoot()
  {
    return root;
  }

  public void setRoot(Node234<T> root)
  {
    this.root = root;
  }
}
