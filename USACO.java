import java.util.Scanner;
import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename) throws FileNotFoundException{
    File text = new File(filename);
    Scanner sys = new Scanner(text);
    int R = sys.nextInt();
    int C = sys.nextInt();
    int[][] pasture = new int[R][C];
    int E = sys.nextInt();
    int N = sys.nextInt();
    System.out.println(R+ " " + C + " " + E + " " + N);
    for (int i = 0; i<R; i++) {
      for (int x = 0; x<C;x++) {
        pasture[i][x] = sys.nextInt();
      }
    }
    for (int i = 0; i<R; i++) {
      for (int x = 0; x<C;x++) {
        System.out.print(pasture[i][x] + " ");
      }
      System.out.print("\n");
    }
    return 0;
  }

  public static void main(String[] args) {
    try {
      bronze("makelake.in");
    }
    catch (FileNotFoundException e){
      System.out.println("FileNotFoundException");
    }
  }
}
