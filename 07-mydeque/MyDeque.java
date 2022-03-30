import java.util.*;

public class MyDeque < E > {

    public E[] data;
    public int size,
    f,
    b;
    // f for front. b for back

    public MyDeque() {
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[16];
        this.data = d;
        f = -1;
        b = -1;
        size = 0;
    }

    public MyDeque(int initialCapacity) {
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[initialCapacity];
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

        if (this.size == 0) {
            return temp + "}";
        }

        // keep going until a null pops up
        while (this.data[front] != null) {

            if (front == this.f && swit) {
                return temp + "}";
            }

            //obtains front and palces
            temp += this.data[front];
            front = front + 1;
            temp += ", ";
            swit = true;

            if (front == len) {
                front = 0;
            }

        }

        int l = temp.length();

        if (swit) {
            temp = temp.substring(0, l - 2) + "}";
        }

        return temp;
    }

    private void changeSize() {
        int l = data.length;
        boolean full = (size == l);

        if (l == 0) {
            @SuppressWarnings("unchecked")
            E[] temp = (E[]) new Object[20];
            data = temp;
        }

        else if (full) {
            @SuppressWarnings("unchecked")
            E[] temp = (E[]) new Object[l + l];

            temp[0] = data[this.f];
            int counter = 0;
            int counter1 = f;
            counter ++;

            for(int j = counter; j < l; j++) {
                counter1++;
                if (counter1 == l) {
                counter1 = 0;
                }
                temp[counter] = this.data[counter1];
                counter++;
            }

            this.f = 0;
            this.data = temp;
            this.b = counter - 1;
        }
    }



}
