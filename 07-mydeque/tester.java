import java.util.Arrays;

public class tester {
  public static void main(String[] args) {
    MyDeque<Integer> test = new MyDeque<Integer>(5);
    System.out.println(test);


    test.addFirst(12);
    System.out.println(test);

    test.addLast(12);
    test.addFirst(1);
    test.addFirst(1);
    test.removeLast();
    test.addLast(12);
    test.addLast(12);
    test.addLast(12);


    System.out.println(test);
    System.out.println(Arrays.toString(test.data));
  }
}
