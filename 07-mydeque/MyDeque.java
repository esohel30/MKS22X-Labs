import java.util.*;

public class MyDeque<E> {

  public E[] data;
  public int size, f, b;
  // f for front. b for back

  public MyDeque(){
     @SuppressWarnings("unchecked")
     E[] d = (E[])new Object[16];
     this.data = d;
     f = -1;
     b = -1;
     size = 0;
  }

  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    this.data = d;
    f = -1;
    b = -1;
    size = 0;
  }

  public int size() {
    return size;
  }



}
