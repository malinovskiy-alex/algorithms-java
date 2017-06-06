package part8.task5;

import part8.Node;

public class HafmanNode extends Node implements Comparable<HafmanNode>
{
  private int occurrencesCount;

  public HafmanNode(char element)
  {
    super(element);
    this.occurrencesCount = 1;
  }

  public HafmanNode()
  {
  }

  public int getOccurrencesCount()
  {
    return occurrencesCount;
  }

  public void setOccurrencesCount(int occurrencesCount)
  {
    this.occurrencesCount = occurrencesCount;
  }

  public void incrementOccurrencesCount()
  {
    this.occurrencesCount++;
  }

  @Override
  public int compareTo(HafmanNode o)
  {
    return occurrencesCount - o.getOccurrencesCount();
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof HafmanNode)
    {
      return ((HafmanNode) obj).getElement() == this.getElement();
    }
    return false;
  }
}
