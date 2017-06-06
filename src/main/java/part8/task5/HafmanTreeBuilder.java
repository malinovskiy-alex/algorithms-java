package part8.task5;

import java.util.ArrayList;
import java.util.List;

import part4.MyPriorityQueue;
import part8.Node;
import part8.task1.LeafCharTree;

public class HafmanTreeBuilder extends LeafCharTree
{
  private HafmanPriorityQueueBuilder listBuilder = new HafmanPriorityQueueBuilder();
  private String sentence;

  public HafmanTreeBuilder(String sentence)
  {
    super(sentence.toCharArray());
    this.sentence = sentence;
  }

  @Override
  protected void buildTree()
  {
    MyPriorityQueue<HafmanNode> nodesByOccurrencesCount = listBuilder.build(sentence);
    while (nodesByOccurrencesCount.getSize() != 1)
    {
      HafmanNode right = nodesByOccurrencesCount.pop();
      HafmanNode left = nodesByOccurrencesCount.pop();
      HafmanNode localRoot = new HafmanNode();
      localRoot.setOccurrencesCount(right.getOccurrencesCount() + left.getOccurrencesCount());
      localRoot.setRightChild(right);
      localRoot.setLeftChild(left);
      nodesByOccurrencesCount.push(localRoot);
    }
    this.setRoot(nodesByOccurrencesCount.pop());
  }

  public List<HafmanTransformationNode> buildCodesTable()
  {
    List<HafmanTransformationNode> result = new ArrayList<>();
    populateTransformationNodes(result, "", this.getRoot());
    return result;
  }

  private void populateTransformationNodes(
    List<HafmanTransformationNode> result,
    String currentPath,
    Node<Character> currentNode)
  {
    if (currentNode == null)
    {
      return;
    }

    if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null)
    {
      HafmanTransformationNode leafNode = new HafmanTransformationNode(currentPath,
        currentNode.getElement());
      result.add(leafNode);
    }

    populateTransformationNodes(result, currentPath + "0", currentNode.getRightChild());

    populateTransformationNodes(result, currentPath + "1", currentNode.getLeftChild());
  }
}
