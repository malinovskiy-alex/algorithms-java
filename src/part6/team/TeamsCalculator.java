package part6.team;

import utils.ArrayUtils;

public class TeamsCalculator
{
  private char[] players;
  private int teamSize;

  public TeamsCalculator(char[] players, int teamSize)
  {
    this.players = players;
    this.teamSize = teamSize;
  }

  public void showTeams()
  {
    showTeams(new char[0], players, teamSize);
  }

  private void showTeams(char[] currentTeam, char[] restOfThePlayers, int restSize)
  {
    if (restSize == 0)
    {
      ArrayUtils.display(currentTeam);
      return;
    }
    if (restOfThePlayers.length == 0 || restSize > restOfThePlayers.length)
    {
      return;
    }

    showTeams(increaseArray(currentTeam, restOfThePlayers[0]), reduceArray(restOfThePlayers),
      restSize - 1);

    showTeams(currentTeam, reduceArray(restOfThePlayers),
      restSize);
  }

  public char[] increaseArray(char[] array, char element)
  {
    char[] result = new char[array.length + 1];
    int i;
    for (i = 0; i < array.length; i++)
    {
      result[i] = array[i];
    }
    result[i] = element;
    return result;
  }

  public char[] reduceArray(char[] array)
  {
    char[] result = new char[array.length - 1];
    for (int i = 0; i < result.length; i++)
    {
      result[i] = array[i + 1];
    }
    return result;
  }
}
