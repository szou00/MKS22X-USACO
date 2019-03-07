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
    for (int i = 0; i<N; i++) {
      int row = sys.nextInt()-1;
      int col = sys.nextInt()-1;
      int down = sys.nextInt();
      int max = 0;
      System.out.println(down);
      for (int y = 0; y<3;y++) {
        for (int z = 0; z<3; z++) {
          if (max < pasture[row+y][col+z]) {
            max = pasture[row+y][col+z];
          }
        }
      }
      max -= down;
      for (int y = 0; y<3;y++) {
        for (int z = 0; z<3; z++) {
          if (pasture[row+y][col+z] > max) {
            pasture[row+y][col+z] = max;
          }
        }
      }
    }
    System.out.println("new board: ");
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
