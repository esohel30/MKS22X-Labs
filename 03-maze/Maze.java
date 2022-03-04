import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze = new char[0][0];
    private boolean animate; //false by default
    private int startRow, startCol;

    /*Constructor loads a maze text file, and sets animate to false by default.
    When the file is not found then:
    throw a FileNotFoundException

    You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
    '#' - Walls - locations that cannot be moved onto
    ' ' - Empty Space - locations that can be moved onto
    'E' - the location of the goal if any (0 or more per file)
    'S' - the location of the start(exactly 1 per file)

    You may also assume the maze has a border of '#' around the edges.
    So you don't have to check for out of bounds!
    Some text editors always include a newline at the end of a file, but that is not always present.
    Make sure your file reading is able to handle this.
    */
    public Maze(String filename) throws FileNotFoundException {
        String info = "" ;
        File text = new File(filename);
        Scanner input = new Scanner(text);
        ArrayList<String> values = new ArrayList<String>();

        while(input.hasNextLine()){
          String temp = input.nextLine();
          info += temp + "\n";
          values.add(temp);
        }
        maze = new char[values.size()][values.get(0).length()];
        for(int a =0; a < maze.length; a++){
          for(int b = 0; b < maze[a].length; b++){
              maze[a][b] = values.get(a).charAt(b);
          }
         setAnimate(false);
    }
  }

    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

    public void setAnimate(boolean b) {
        animate = b;
    }

    public static void clearTerminal() {
        //erase terminal
        System.out.println("\033[2J");
    }
    public static void gotoTop() {
        //go to top left of screen
        System.out.println("\033[1;1H");
    }

    /*Return the string that represents the maze.
    It should look like the text file with some characters replaced.
    */
    public String toString() {
        String temp = "";
        for(int i =0; i < maze.length; i ++){
          for(int j =0; j < maze[i].length; j++){
              temp += (maze[i][j]);
          }
          temp += ("\n");
        }

        return temp;
    }

    /*Wrapper Solve Function returns the helper function
    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve() {
        //only clear the terminal if you are running animation
        if (animate) {
            clearTerminal();
        }
        //start solving at the location of the s.
        return solve(startRow, startCol);

    }

    /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.

    Postcondition:
    The 'S' is replaced with '@'
    The 'E' remain the same
    All visited spots that were not part of the solution are changed to '.'
    All visited spots that are part of the solution are changed to '@'
    */

    private boolean goodSpace(int row, int col){
      if(maze[row + 1][col] == ' ' || maze[row][col + 1] == ' ' ||
         maze[row - 1][col] == ' ' || maze[row][col -1 ] == ' '){
           return true;
      }else{
        return false;
      }
    }

    private int solve(int row, int col) { //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if (animate) {
            gotoTop();
            System.out.println(this);
            wait(50);
        }

        maze[row][col] = '@';

        if(maze[row][col] == 'e'){
          return 0;
        }
        if(!goodSpace(row, col)){
          return -1;
        }

        else{
          if(goodSpace(row, col)){



          }




        }



        //COMPLETE SOLVE
        return -1; //so it compiles
    }


    public static void main(String[] args) {
      try {
        Maze x = new Maze("maze1");
        x.solve(5,1);
        System.out.print(x);
      }
      catch(FileNotFoundException e){
        System.out.print(e);
      }
    }
}
