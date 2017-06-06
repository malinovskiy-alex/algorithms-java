package part6;

import java.util.TimeZone;

import part6.anagram.AnagramBuilder;

public class Main
{
  public static void main(String[] args)
  {
    AnagramBuilder a = new AnagramBuilder("cat");
    a.doAnagram();
    System.err.println(TimeZone.getDefault());
//    int[] array = new int[]{11, 8, 7, 6, 5, 2, 4};
//    BagCalculator bg = new BagCalculator(array, 23);
//    bg.checkSizes();

//    char[] players = new char[]{'A', 'B', 'C', 'D', 'E'};
//    TeamsCalculator tc = new TeamsCalculator(players, 3);
//    tc.showTeams();

//    TreeBuilder bld = new TreeBuilder();
//
//    bld.branches(32);
//
//    bld.display();
  }
}
