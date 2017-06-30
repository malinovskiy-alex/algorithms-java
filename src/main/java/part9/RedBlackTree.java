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
      RedBlackNode<T> parentNode = null;
      RedBlackNode<T> currentNode = this.root;
      while (currentNode != null)
      {
        if (!currentNode.isRed() && hasTwoRedChildren(currentNode))
        {
          flipColor(currentNode);
          if (twoRedNodesInRow(parentNode, currentNode))
          {
            if (parentNode.isLeft())
            {
              parentNode.getParent().setRed(true);
              //left outer child
              if (currentNode.isLeft())
              {
                parentNode.setRed(false);
                //unlink right node
                RedBlackNode<T> unlinkedNode = parentNode.getRightChild();
                parentNode.getParent().setLeft(false);
                parentNode.setRightChild(parentNode.getParent());
                parentNode.getParent().setLeftChild(unlinkedNode);
                unlinkedNode.setLeft(true);
                if (parentNode.getParent() == this.root)
                {
                  this.root = parentNode;
                  parentNode.setParent(null);
                }
                flipColor(parentNode);
              }
              else
              {
                //left inner child
                currentNode.setRed(false);
                //unlink left child from parent
                RedBlackNode<T> unlinkedNode = currentNode.getLeftChild();
                parentNode.getParent().setLeftChild(currentNode);
                parentNode.setRightChild(unlinkedNode);
                unlinkedNode.setParent(parentNode);
                unlinkedNode.setLeft(false);
                currentNode.setParent(parentNode.getParent());
                currentNode.setLeftChild(parentNode);
                parentNode.setParent(currentNode);

                RedBlackNode<T> unlinkedParent = currentNode.getParent();
                if (currentNode.getParent() == this.root)
                {
                  this.root = currentNode;
                  currentNode.setParent(null);
                }else {
                  //
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
            }
            else
            {
              if (currentNode.isLeft())
              {
                //right inner child
                currentNode.setRed(false);
                //unlink right child from parent
                RedBlackNode<T> unlinkedNode = currentNode.getRightChild();
                parentNode.getParent().setRightChild(currentNode);
                parentNode.setLeftChild(unlinkedNode);
                unlinkedNode.setParent(parentNode);
                unlinkedNode.setLeft(true);
                currentNode.setParent(parentNode.getParent());
                currentNode.setRightChild(parentNode);
                parentNode.setParent(currentNode);

                RedBlackNode<T> unlinkedParent = currentNode.getParent();
                if (currentNode.getParent() == this.root)
                {
                  this.root = currentNode;
                  currentNode.setParent(null);
                }else {
                  //
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
              else
              {
                parentNode.getParent().setRed(true);
                //right outer child
                parentNode.setRed(false);
                //unlink right node
                RedBlackNode<T> unlinkedNode = parentNode.getLeftChild();
                parentNode.getParent().setLeft(true);
                parentNode.setLeftChild(parentNode.getParent());
                parentNode.getParent().setRightChild(unlinkedNode);
                unlinkedNode.setLeft(false);
                if (parentNode.getParent() == this.root)
                {
                  this.root = parentNode;
                  parentNode.setParent(null);
                }

                flipColor(parentNode);
              }
            }
          }
        }
        parentNode = currentNode;
        if (element.compareTo(currentNode.getElement()) < 0)
        {
          currentNode = currentNode.getLeftChild();
        }
        else
        {
          currentNode = currentNode.getRightChild();
        }
      }
      RedBlackNode<T> nodeForInsertion = new RedBlackNode<>(element);
      nodeForInsertion.setParent(parentNode);
      if (element.compareTo(parentNode.getElement()) < 0)
      {
        nodeForInsertion.setLeft(true);
        parentNode.setLeftChild(nodeForInsertion);
      }
      else
      {
        nodeForInsertion.setLeft(false);
        parentNode.setRightChild(nodeForInsertion);
      }
      if (parentNode.isRed())
      {
        RedBlackNode<T> grandParent = parentNode.getParent();
        parentNode.setRed(false);
        grandParent.setRed(true);
        if (!nodeForInsertion.isLeft())
        {
          if (parentNode.isLeft())
          {
            parentNode.setRed(true);
            nodeForInsertion.setParent(grandParent);
            nodeForInsertion.setLeftChild(parentNode);
            nodeForInsertion.setLeft(true);
            nodeForInsertion.setRed(false);
            parentNode.setRightChild(null);
            parentNode.setParent(nodeForInsertion);
            nodeForInsertion.setRightChild(grandParent);
            grandParent.setLeft(false);
            nodeForInsertion.setParent(grandParent.getParent());
            grandParent.getParent().setLeftChild(nodeForInsertion);
            grandParent.setParent(null);

            return;
          }

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
        else
        {
          if (!parentNode.isLeft())
          {
            parentNode.setRed(true);
            nodeForInsertion.setParent(grandParent);
            nodeForInsertion.setRightChild(parentNode);
            nodeForInsertion.setRed(false);
            nodeForInsertion.setLeft(false);
            parentNode.setLeft(false);
            parentNode.setLeftChild(null);
            parentNode.setParent(nodeForInsertion);
            nodeForInsertion.setLeftChild(grandParent);
            nodeForInsertion.setParent(grandParent.getParent());
            grandParent.setLeft(true);
            grandParent.getParent().setRightChild(nodeForInsertion);
            grandParent.setParent(null);

            return;
          }

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
      }
    }
  }

  private boolean twoRedNodesInRow(RedBlackNode parent, RedBlackNode child)
  {
    return parent != null && parent.isRed() && child.isRed();
  }

  private boolean hasTwoRedChildren(RedBlackNode<T> node)
  {
    boolean isLeftChildRed = node.getLeftChild() != null && node.getLeftChild().isRed();
    boolean isRightChildRed = node.getRightChild() != null && node.getRightChild().isRed();
    return isLeftChildRed && isRightChildRed;
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
