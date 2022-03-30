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

  public String toString() {
    String temp = "{";
    int front = this.f;
    boolean swit = false;
    int len = data.length;

   if (this.size == 0){
     return temp + "}";
   }

   // keep going until a null pops up
   while (this.data[front] != null) {

     if (front == this.f && swit){
       return temp + "}";
     }

     //obtains front and palces
     temp += this.data[front];
     front = front + 1;
     temp += ", ";
     swit = true;

     if (front == len){
       front = 0;
     }

   }

   int l = temp.length();

   if (swit){
     temp = temp.substring(0, l - 2) + "}";
   }

   return temp;
 }



}
