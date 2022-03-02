import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {
    public static int[] getValuesFromFile(String filename) throws FileNotFoundException {
        String info = "" ;
        File text = new File(filename);
        Scanner input = new Scanner(text);

        while(input.hasNextLine()){
          String temp = input.nextLine();
          info += temp + "\n";
        }

        System.out.println(info);
        return new int[0];

    }

    public static void main(String args[]) {
        int[] nums = new int[0];
        try {
            nums = getValuesFromFile("");
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
    }
  }
