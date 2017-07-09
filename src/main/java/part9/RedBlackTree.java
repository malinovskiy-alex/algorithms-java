package part9;

public class RedBlackTree<T extends Comparable>
{
  private RedBlackNode<T> root;

  public void insert(T element)
  {
    if (this.root == null)
    {
      this.root = new RedBlackNode<>(element);
      this.root.setRed(false);
    }
    else
    {
      RedBlackNode<T> nodeForInsertion = new RedBlackNode<>(element);
      RedBlackNode<T> parentNode = null;
      RedBlackNode<T> currentNode = this.root;
      while (currentNode != null)
      {
        if (currentNode.flipColorRequired())
        {
          flipColor(currentNode);
        }
        if (twoRedNodesInRow(currentNode))
        {
          if (parentNode.isLeft())
          {
            if (currentNode.isLeft())
            {
              balanceOuterLeftNodeBeforeInsertion(currentNode);
            }
            else
            {
              balanceInnerLeftNodeBeforeInsertion(currentNode);
            }
          }
          else
          {
            if (currentNode.isLeft())
            {
              balanceInnerRightNodeBeforeInsertion(currentNode);
            }
            else
            {
              balanceOuterRightNodeBeforeInsertion(currentNode);
            }
          }
        }
        parentNode = currentNode;
        currentNode = currentNode.getNextChild(nodeForInsertion);
      }

      parentNode.insertNode(nodeForInsertion);

      if (parentNode.isRed())
      {
        RedBlackNode<T> grandParent = parentNode.getParent();
        parentNode.setRed(false);
        grandParent.setRed(true);
        if (!nodeForInsertion.isLeft())
        {
          if (parentNode.isLeft())
          {
            balanceInnerRightNodeAfterInsertion(nodeForInsertion);
            return;
          }

          balanceOuterRightNodeAfterInsertion(nodeForInsertion);
        }
        else
        {
          if (!parentNode.isLeft())
          {
            balanceInnerLeftNodeAfterInsertion(nodeForInsertion);
            return;
          }

          balanceOuterLeftNodeAfterInsertion(nodeForInsertion);
        }
      }
    }
  }

  private void balanceInnerLeftNodeBeforeInsertion(RedBlackNode<T> currentNode)
  {
    RedBlackNode<T> parentNode = currentNode.getParent();
    RedBlackNode<T> grandParent = parentNode.getParent();

    //left inner child
    currentNode.setRed(false);
    //unlink left child from parent
    RedBlackNode<T> unlinkedNode = currentNode.getLeftChild();
    grandParent.setLeftChild(currentNode);
    parentNode.setRightChild(unlinkedNode);
    unlinkedNode.setParent(parentNode);
    unlinkedNode.setLeft(false);
    currentNode.setParent(grandParent);
    currentNode.setLeftChild(parentNode);
    parentNode.setParent(currentNode);

    RedBlackNode<T> unlinkedParent = currentNode.getParent();
    if (this.root == unlinkedParent)
    {
      this.root = currentNode;
      currentNode.setParent(null);
    }
    //unlink right child from current
    RedBlackNode<T> unlinkedRightNode = currentNode.getRightChild();
    unlinkedRightNode.setLeft(true);
    unlinkedParent.setLeftChild(unlinkedRightNode);
    unlinkedRightNode.setParent(unlinkedParent);
    currentNode.setRightChild(unlinkedParent);
    unlinkedParent.setParent(currentNode);

    flipColor(currentNode);
  }

  private void balanceOuterLeftNodeBeforeInsertion(RedBlackNode<T> node)
  {
    RedBlackNode<T> parentNode = node.getParent();
    RedBlackNode<T> grandParent = parentNode.getParent();

    grandParent.setRed(true);
    parentNode.setRed(false);
    grandParent.setLeft(false);
    //unlink right node
    RedBlackNode<T> unlinkedNode = parentNode.getRightChild();
    parentNode.setRightChild(grandParent);
    grandParent.setLeftChild(unlinkedNode);
    unlinkedNode.setLeft(true);
    if (this.root == grandParent)
    {
      this.root = parentNode;
      parentNode.setParent(null);
    }
    flipColor(parentNode);
  }


  private void balanceOuterRightNodeBeforeInsertion(RedBlackNode<T> node)
  {
    RedBlackNode<T> parentNode = node.getParent();
    RedBlackNode<T> grandParent = parentNode.getParent();

    grandParent.setRed(true);
    parentNode.setRed(false);
    grandParent.setLeft(true);

    //unlink left node
    RedBlackNode<T> unlinkedNode = parentNode.getLeftChild();
    parentNode.setLeftChild(grandParent);
    grandParent.setRightChild(unlinkedNode);
    unlinkedNode.setLeft(false);
    if (this.root == grandParent)
    {
      this.root = parentNode;
      parentNode.setParent(null);
    }

    flipColor(parentNode);
  }

  private void balanceInnerRightNodeBeforeInsertion(RedBlackNode<T> currentNode)
  {
    RedBlackNode<T> parentNode = currentNode.getParent();
    RedBlackNode<T> grandParent = parentNode.getParent();

    //right inner child
    currentNode.setRed(false);
    //unlink right child from parent
    RedBlackNode<T> unlinkedNode = currentNode.getRightChild();
    grandParent.setRightChild(currentNode);
    parentNode.setLeftChild(unlinkedNode);
    unlinkedNode.setParent(parentNode);
    unlinkedNode.setLeft(true);
    currentNode.setParent(grandParent);
    currentNode.setRightChild(parentNode);
    parentNode.setParent(currentNode);

    RedBlackNode<T> unlinkedParent = currentNode.getParent();
    if (this.root == unlinkedParent)
    {
      this.root = currentNode;
      currentNode.setParent(null);
    }
    //unlink right child from current
    RedBlackNode<T> unlinkedLeftNode = currentNode.getLeftChild();
    unlinkedParent.setRightChild(unlinkedLeftNode);
    unlinkedLeftNode.setLeft(false);
    unlinkedLeftNode.setParent(unlinkedParent);
    currentNode.setLeftChild(unlinkedParent);
    unlinkedParent.setLeft(true);
    unlinkedParent.setParent(currentNode);

    flipColor(currentNode);
  }

  private void balanceInnerRightNodeAfterInsertion(RedBlackNode<T> nodeForInsertion)
  {
    RedBlackNode<T> parentNode = nodeForInsertion.getParent();
    RedBlackNode<T> grandParent = parentNode.getParent();
    nodeForInsertion.setParent(grandParent);
    nodeForInsertion.setLeftChild(parentNode);
    nodeForInsertion.setLeft(true);
    nodeForInsertion.setRed(false);
    nodeForInsertion.setRightChild(grandParent);
    nodeForInsertion.setParent(grandParent.getParent());
    parentNode.setRightChild(null);
    parentNode.setParent(nodeForInsertion);
    grandParent.setLeft(false);
    grandParent.getParent().setLeftChild(nodeForInsertion);
    grandParent.setParent(nodeForInsertion);
  }

  private void balanceInnerLeftNodeAfterInsertion(RedBlackNode<T> nodeForInsertion)
  {
    RedBlackNode<T> parentNode = nodeForInsertion.getParent();
    RedBlackNode<T> grandParent = parentNode.getParent();
    nodeForInsertion.setParent(grandParent);
    nodeForInsertion.setRightChild(parentNode);
    nodeForInsertion.setLeft(false);
    nodeForInsertion.setRed(false);
    nodeForInsertion.setLeftChild(grandParent);
    nodeForInsertion.setParent(grandParent.getParent());
    parentNode.setLeftChild(null);
    parentNode.setParent(nodeForInsertion);
    grandParent.setLeft(true);
    grandParent.getParent().setRightChild(nodeForInsertion);
    grandParent.setParent(null);
  }

  private void balanceOuterLeftNodeAfterInsertion(RedBlackNode<T> node)
  {
    RedBlackNode<T> parentNode = node.getParent();
    RedBlackNode<T> grandParent = parentNode.getParent();
    if (this.root == grandParent)
    {
      this.root = parentNode;
      parentNode.setParent(null);
      parentNode.setRightChild(grandParent);
      grandParent.setLeft(false);
      grandParent.setParent(parentNode);
    }
    else
    {
      grandParent.getParent().setLeftChild(parentNode);
      parentNode.setLeft(true);
      parentNode.setRightChild(grandParent);
      grandParent.setLeft(false);
    }
  }

  private void balanceOuterRightNodeAfterInsertion(RedBlackNode<T> node)
  {
    RedBlackNode<T> parentNode = node.getParent();
    RedBlackNode<T> grandParent = parentNode.getParent();
    if (this.root == grandParent)
    {
      this.root = parentNode;
      parentNode.setParent(null);
      parentNode.setLeftChild(grandParent);
      grandParent.setLeft(true);
      grandParent.setParent(parentNode);
    }
    else
    {
      grandParent.getParent().setRightChild(parentNode);
      parentNode.setLeft(false);
      parentNode.setLeftChild(grandParent);
      grandParent.setLeft(true);
    }
  }

  private boolean twoRedNodesInRow(RedBlackNode child)
  {
    return child.getParent() != null && child.getParent().isRed() && child.isRed();
  }

  private void flipColor(RedBlackNode<T> node)
  {
    if (node != this.root)
    {
      node.setRed(true);
    }
    node.getLeftChild().setRed(false);
    node.getRightChild().setRed(false);
  }

  public RedBlackNode<T> getRoot()
  {
    return root;
  }

  public boolean isEmpty()
  {
    return this.root == null;
  }
}
