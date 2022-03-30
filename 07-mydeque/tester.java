import java.util.Arrays;

public class tester {
  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<Integer>(5);
    System.out.println(test);


    test.addFirst(5);
    test.addFirst(4);
    test.addFirst(3);
    test.addFirst(2);
    test.addFirst(1);




    System.out.println(test);
    System.out.println(Arrays.toString(test.data));
  }
}
