import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class

public class ReadFile {
    public static String[][] getValuesFromFile(String filename) throws FileNotFoundException {
        String info = "" ;
        File text = new File(filename);
        Scanner input = new Scanner(text);
        ArrayList<String> values = new ArrayList<String>();

        while(input.hasNextLine()){
          String temp = input.nextLine();
          info += temp + "\n";
          values.add(temp);
        }
        String[][] holder = new String[values.size()][values.get(0).length()];
        for(int a =0; a < holder.length; a++){
          for(int b = 0; b < holder[a].length; b++){
              holder[a][b] = values.get(a).substring(b,b+1);
          }
        }
        return holder;
    }

    public static void main(String args[]) {
        String[][] nums = new String[0][0];
        try {
            nums = getValuesFromFile("maze3");
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
    }
  }
