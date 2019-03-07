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

    for (int i = 0; i<R; i++) {
      for (int x = 0; x<C;x++) {
        pasture[i][x] = sys.nextInt();
      }
    }

    for (int i = 0; i<N; i++) {
      int row = sys.nextInt()-1;
      int col = sys.nextInt()-1;
      int down = sys.nextInt();
      int max = 0;

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

    int depth = 0;
    for (int i = 0; i<R; i++) {
      for (int x = 0; x<C;x++) {
        if (pasture[i][x] < E) {
          pasture[i][x] = E-pasture[i][x];
          depth += pasture[i][x];
        }
        else {
          pasture[i][x] = 0;
        }
      }
    }

    return (depth * 72 * 72);
  }

  public static void main(String[] args) {
    try {
      System.out.println(bronze("makelake.5.in"));
    }
    catch (FileNotFoundException e){
      System.out.println("FileNotFoundException");
    }
  }
}
