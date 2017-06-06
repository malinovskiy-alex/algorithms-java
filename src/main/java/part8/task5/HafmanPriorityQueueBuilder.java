package part8.task5;

import part4.MyPriorityQueue;
import part5.ListElement;
import part5.cyclic.CyclicList;

public class HafmanPriorityQueueBuilder
{
  public MyPriorityQueue<HafmanNode> build(String sentence)
  {
    CyclicList<HafmanNode> characters = new CyclicList<>();
    for (Character ch : sentence.toCharArray())
    {
      HafmanNode node = new HafmanNode(ch);
      ListElement<HafmanNode> nodeInList = characters.find(node);
      if (nodeInList != null)
      {
        nodeInList.getValue().incrementOccurrencesCount();
      }
      else
      {
        characters.insert(node);
      }
    }
    MyPriorityQueue<HafmanNode> result = new MyPriorityQueue<>(characters.size());
    while (!characters.isEmpty())
    {
      result.push(characters.remove().getValue());
    }
    return result;
  }
}
