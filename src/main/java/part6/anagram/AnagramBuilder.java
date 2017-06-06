package part6.anagram;

import utils.ArrayUtils;

public class AnagramBuilder
{
  private char[] word;

  public AnagramBuilder(String word)
  {
    this.word = new char[word.length()];
    for (int i = 0; i < word.length(); i++)
    {
      this.word[i] = word.charAt(i);
    }
  }

  public void doAnagram()
  {
    doAnagram(word.length);
  }

  private void doAnagram(int currentSize)
  {
    if (currentSize == 1)
    {
      return;
    }
    for (int i = 0; i < currentSize; i++)
    {
      doAnagram(currentSize - 1);
      if (currentSize == 2)
      {
        ArrayUtils.display(word);
      }
      rotate(currentSize);
    }
  }

  private void rotate(int currentSize)
  {
    int i;
    int position = word.length - currentSize;
    char temp = word[position];
    for (i = position + 1; i < word.length; i++)
    {
      word[i - 1] = word[i];
    }
    word[i - 1] = temp;
  }

}
