import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Driver{
      public static void main(String[]args){

        //files do not require an extension like .txt or .dat,
        //but if they have them, you must include them in your filename String.
        String filename = "maze5";

        try{
          Maze f;
          f = new Maze(filename);
          f.setAnimate(false);
          System.out.println(f.solve()+" steps");
          System.out.println(f);
        }catch(FileNotFoundException e){
          System.out.println("Invalid filename: "+filename);
        }
      }
    }
