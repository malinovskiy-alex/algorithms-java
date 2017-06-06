package part5.matrix;

public class Main
{

  public static void main(String[] args)
  {
    Matrix m = new Matrix(5, 7);
    m.display();
    System.out.println();
    System.out.println();
    m.insert(2, 2, 10);
    m.insert(4, 1, 5);
    m.display();
  }
}
