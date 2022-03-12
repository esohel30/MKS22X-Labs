import java.util.*;
import java.io.*;

public class Bronze{
  private int R, C, E, N;
  private int[][] pasture;
  private int R_s, C_s, D_sl;


  public Bronze(String filename) throws FileNotFoundException{
    File texter = new File(filename);
    Scanner input = new Scanner(texter);
    R = input.nextInt();
    C = input.nextInt();
    E = input.nextInt();
    N = input.nextInt();

    pasture = new int [R][C];

    for(int i = 0; i < R; i++){
      for(int j = 0; j < C; j++){
        pasture[i][j] = input.nextInt();
      }
    }

  }

  public void stomp( int R_s, int C_s, int D_sl) {

    
  }



  public static void main(String[] args) {
    try{
      Bronze x = new Bronze ("sampleInput2");


    }catch(FileNotFoundException e){
        System.out.println(e);
    }
  }











}
