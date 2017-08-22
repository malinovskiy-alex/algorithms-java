package part10;

public class Tree23<T extends Comparable>
{
  private NodeMultiChild<T> root;

  public void insert(T element)
  {
    if (this.root == null)
    {
      NodeMultiChild<T> root = new NodeMultiChild<>(2);
      root.insertInDataArray(element);
      this.root = root;
    }
    else
    {
      NodeMultiChild<T> currentNode = this.root;
      while (!currentNode.isLeaf())
      {
        currentNode = currentNode.getNextChildNode(element);
      }
      if (currentNode.isFull())
      {
        split(currentNode, element);
      }
      else
      {
        currentNode.insertInDataArray(element);
      }
    }
  }

  private void split(NodeMultiChild<T> nodeToSplit, T elementForInsertion)
  {
    if (nodeToSplit.getParent() != null && nodeToSplit.getParent().isFull())
    {
      throw new UnsupportedOperationException("2 levels split is not supported!");
    }

    T firstElement = nodeToSplit.getDataElementAt(0);
    T secondElement = nodeToSplit.getDataElementAt(1);
    if (elementForInsertion.compareTo(firstElement) > 0 &&
      elementForInsertion.compareTo(secondElement) < 0)
    {
      createNewNode(nodeToSplit, nodeToSplit.extractDataElement(1),
        elementForInsertion);
    }
    else if (elementForInsertion.compareTo(firstElement) > 0 &&
      elementForInsertion.compareTo(secondElement) > 0)
    {
      createNewNode(nodeToSplit, elementForInsertion,
        nodeToSplit.extractDataElement(1));
    }
    else if (elementForInsertion.compareTo(firstElement) < 0 &&
      elementForInsertion.compareTo(secondElement) < 0)
    {
      createNewNode(nodeToSplit, nodeToSplit.extractDataElement(1),
        nodeToSplit.extractDataElement(0));
      nodeToSplit.insertInDataArray(elementForInsertion);
    }
  }

  private void createNewNode(NodeMultiChild<T> leftNode, T rightElement, T newRootElement)
  {
    NodeMultiChild<T> secondChild = new NodeMultiChild<>(2);
    secondChild.insertInDataArray(rightElement);
    if (this.root == leftNode)
    {
      NodeMultiChild<T> localRoot = new NodeMultiChild<>(2);
      localRoot.insertInDataArray(newRootElement);

      secondChild.setParent(localRoot);
      leftNode.setParent(localRoot);

      localRoot.insertChild(leftNode, 0);
      localRoot.insertChild(secondChild, 1);

      this.root = localRoot;
    }
    else
    {
      NodeMultiChild<T> newRoot = leftNode.getParent();
      int insertionIndex = newRoot.insertInDataArray(newRootElement);
      secondChild.setParent(newRoot);
      if (insertionIndex > 0)
      {
        newRoot.insertChild(secondChild, 2);
      }
      else
      {
        newRoot.insertChild(newRoot.extractChild(1), 2);
        newRoot.insertChild(secondChild, 1);
      }
    }
  }

  public NodeMultiChild<T> getRoot()
  {
    return root;
  }
}
