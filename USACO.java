import java.util.Scanner;
import java.util.*;
import java.io.*;

public class USACO {

  public static int bronze(String filename) throws FileNotFoundException{

    //opening a new file
    File text = new File(filename);
    Scanner sys = new Scanner(text);

    //taking in the first line and creating a 2D array
    int R = sys.nextInt();
    int C = sys.nextInt();
    int[][] pasture = new int[R][C];
    int E = sys.nextInt();
    int N = sys.nextInt();

    //filling in the 2D array with corresponding values
    for (int i = 0; i<R; i++) {
      for (int x = 0; x<C;x++) {
        pasture[i][x] = sys.nextInt();
      }
    }

    //changing values due to stomping
    for (int i = 0; i<N; i++) {
      int row = sys.nextInt()-1;
      int col = sys.nextInt()-1;
      int down = sys.nextInt();
      int max = 0;

      //looking for the max value in each set of cows
      for (int y = 0; y<3;y++) {
        for (int z = 0; z<3; z++) {
          if (max < pasture[row+y][col+z]) {
            max = pasture[row+y][col+z];
          }
        }
      }
      //subtract the total number of stomps from the cow with the highest elevation
      max -= down;
      for (int y = 0; y<3;y++) {
        for (int z = 0; z<3; z++) {
          //if there are any cows higher than that cow after, those cow all become the same, new level
          if (pasture[row+y][col+z] > max) {
            pasture[row+y][col+z] = max;
          }
        }
      }
    }

    //finding the final elevation
    int depth = 0;
    for (int i = 0; i<R; i++) {
      for (int x = 0; x<C;x++) {
        if (pasture[i][x] < E) {
          pasture[i][x] = E-pasture[i][x];
          //add everything to get the depth
          depth += pasture[i][x];
        }
        else {
          pasture[i][x] = 0;
        }
      }
    }

    //return the depth
    return (depth * 72 * 72);
  }

  //----------------------------------------------------------------------------

  public static int silver(String filename) throws FileNotFoundException{

    //opening a new file
    File text = new File(filename);
    Scanner sys = new Scanner(text);

    //reading in the file
    String line = sys.nextLine();
    int rows = Integer.parseInt(line.substring(0,1));
    int cols = Integer.parseInt(line.substring(2,3));
    int t = Integer.parseInt(line.substring(4,5));
    // System.out.println("rows: " + rows + " cols: " + cols + " time: " + t);

    //creating a 2D array to represent pasture
    int[][] pasture = new int[rows][cols];
    for (int r=0;r<rows;r++) {
      line = sys.nextLine();
      for (int c=0;c<cols;c++) {
        if (line.charAt(c) != '*') {
          pasture[r][c] = 0;
        }
        else {
          pasture[r][c] = -1;
        }
      }
    }

    //getting the last line (start and end)
    line = sys.nextLine();
    int startr = Integer.parseInt(line.substring(0,1))-1;
    int startc = Integer.parseInt(line.substring(2,3))-1;
    int endr = Integer.parseInt(line.substring(4,5))-1;
    int endc = Integer.parseInt(line.substring(6,7))-1;
    System.out.println(startr + " " + startc + " " + endr + " " + endc + " ");

    //figuring out the moves
    pasture[startr][startc] = 1;
    while (t!=0) {
      pasture = silver(pasture);
    }

    //printing for debugging purposes
    System.out.println("pasture: ");
    for (int i = 0; i<rows; i++) {
      for (int x = 0; x<cols;x++) {
        System.out.print(pasture[i][x] + " ");
      }
      System.out.print("\n");
    }

    return pasture[endr][endc];
  }

  public static int[][] silver(int[][] pasture) {
    int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}}; //possible ways the cow can move
    int[][] field = new int[pasture.length][pasture[0].length];
    int sum=0; int newR = 0; int newC = 0;
    for (int r = 0; r<pasture.length;r++) {
        for (int c= 0; c<pasture[0].length;c++) {
          if(pasture[r][c] == -1){//if a tree, copy over
            field[r][c] = -1;
          }
          else {
            sum = 0;
            for (int m = 0; m<moves.length;m++) {
              newR = r + moves[m][0];
              newC = c + moves[m][1];
              if (newR < pasture.length && newC < pasture[0].length && newR >= 0 && newC >= 0 && pasture[newR][newC] != -1) {
                // System.out.println("went thru: row is " + newR + " col is " + newC);
                sum+=pasture[newR][newC];
              }
              field[r][c] = sum;
            }
          }
        }
      }
      return field;
  }

    // int sum = 0;
    // if ()
    // if (r == er && c == ec) {
    //   return 1;
    // }
    // if (r == field.length || c == field[0].length || r < 0 || c < 0) {
    //   return 0;
    // }
    // for (int m = 0; m<moves.length;m++) {
    //   sum+=findSolutions(field,r+moves[m][0],c+moves[m][1],er,ec);
    // }
    // return sum;


  //----------------------------------------------------------------------------

  public static void main(String[] args) {
    try {
      //System.out.println(bronze("makelake.5.in"));
        silver("ctravel.1.in");
    }
    catch (FileNotFoundException e){
      System.out.println("FileNotFoundException");
    }
  }
}
