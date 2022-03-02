import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class

public class ReadFile {
    public static char[][] getValuesFromFile(String filename) throws FileNotFoundException {
        String info = "" ;
        File text = new File(filename);
        Scanner input = new Scanner(text);
        ArrayList<String> values = new ArrayList<String>();

        while(input.hasNextLine()){
          String temp = input.nextLine();
          info += temp + "\n";
          values.add(temp);
        }
        char[][] holder = new char[values.size()][values.get(0).length()];
        for(int a =0; a < holder.length; a++){
          for(int b = 0; b < holder[a].length; b++){
              holder[a][b] = values.get(a).charAt(b);
          }
        }
        return holder;
    }

    public static void main(String args[]) {
        char[][] nums = new char[0][0];
        try {
            nums = getValuesFromFile("maze3");
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
    }
  }
