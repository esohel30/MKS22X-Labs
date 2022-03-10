public class silver{
  private int N, M, T;
  private char[][] pasture;
  private int R1, C1, R2, C2;


  public pasture(String filename){
    File texter = new File(filename);
    Scanner input = new Scanner(texter);
    ArrayList < String > values = new ArrayList < String > ();

    while (input.hasNextLine()) {
        String temp = input.nextLine();
        if (!temp.equals("")) {
            values.add(temp);
        }
      }
      System.out.println(temp);
  }




  public static void main(String[] args) {

  }








}
