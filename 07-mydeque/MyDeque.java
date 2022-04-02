import java.util.*;

public class MyDeque < E > {

    @SuppressWarnings("unchecked")
    public E[] data;
    public int size,
    f,
    b;
    // f for front. b for back

    public MyDeque() {
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[16];
        this.data = d;
        this.size = 0;
        this.f = -1;
        this.b = -1;
    }

    public MyDeque(int initialCapacity) {
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[initialCapacity];
        this.data = d;
        this.size = 0;
        this.f = -1;
        this.b = -1;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String temp = "[";
        int front = this.f;
        boolean swit = false;
        int len = data.length;

        if (this.size == 0) {
            return temp + "]";
        }
        // keep going until a null pops up
        while (this.data[front] != null) {
            int l = temp.length();
            if (front == this.f && swit == true) {

                // return temp without the additional space and comma
                return temp.substring(0, l - 2) + "]";
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
        int s = temp.length() + 1;

        if (front == this.f && swit == true) {
            temp = temp.substring(0, s - 3) + "]";
        }
        return temp;
    }

    @SuppressWarnings("unchecked")
    private void changeSize() {
        int l = data.length;
        int front = this.f; // no accidental changes
        boolean full = (size == l);
        if (l == 0) {
            @SuppressWarnings("unchecked")
            E[] temp = (E[]) new Object[20];
            data = temp;
            // change adress of array after copying
        } else if (full) {
            @SuppressWarnings("unchecked")
            E[] temp = (E[]) new Object[l + l];
            temp[0] = data[front];
            int counter = 0;
            int counter1 = f;
            counter++;
            for (int j = counter; j < l; j++) {
                counter1++;
                if (counter1 == l) {
                    counter1 -= counter1;
                }
                temp[counter] = this.data[counter1];
                counter += 1;
            }
            counter -= 1;
            this.f -= front;
            this.data = temp;
            this.b = counter;
        }
    }



    public void addFirst(E element) {
        if (element == null) {
            throw new NullPointerException("must enter a value for this method");
        }
        changeSize();
        int s = data.length;
        boolean inbounds = true;
        if (f == 0) {
            this.data[s - 1] = element;
            s--;
            this.f = s;
        } else if (this.f == -1) {
            this.data[this.f + 1] = element;
            this.f++;
            this.b++;
        } else if (this.f != 0 || this.f != -1) {
            this.data[this.f - 1] = element;
            this.f = f - 1;
        }
        this.size = this.size + 1;
    }

    public void addLast(E element) {
        if (element == null) {
            throw new NullPointerException("must enter a value for this method");
        }
        changeSize();
        int s = data.length;
        if (this.b == -1) {
            this.f = this.b;
            this.data[0] = element;
            this.f = this.f - this.b;
            this.b = this.f;
        } else if (this.b + 1 == s) {
            b -= b;
            data[0] = element;
        } else {
            b += 1;
            data[b] = element;
        }
        this.size += 1; // increment size by one because of the added element
    }

    public E getFirst() {
        boolean temp = this.f == -1;
        if (this.f - this.b == 0) {
            throw new NoSuchElementException("this element does not exist");
        }
        if (temp || this.data[this.f] == null) {
            throw new NoSuchElementException("this element does not exist");
        }
        return this.data[this.f];
    }

    public E getLast() {
        boolean temp = this.f - this.b == 0;
        if (this.f == -1) {
            throw new NoSuchElementException("this element does not exist");
        }
        if (this.data[f] == null && temp) {
            throw new NoSuchElementException("this element does not exist");
        }
        return this.data[this.b];
    }

    public E removeFirst() {
        int l = data.length;
        int s = this.size;

        if (this.data[f] == null) {
            throw new NoSuchElementException("this element does not exist");
        }
        if (this.f == -1) {
            throw new NoSuchElementException("this element does not exist");
        }
        s--;
        this.size = s;
        E temp = this.data[this.f];
        // holds value that will be removed
        data[this.f] = null;
        this.f = this.f + 1;
        if (this.f == l) {
            this.f = this.f - l;
        }
        return temp;
    }

    public E removeLast() {
        int l = data.length - 1;
        int s = this.size;
        if (this.data[b] == null) {
            throw new NoSuchElementException("this element does not exist");
        }
        if (this.f == -1) {
            throw new NoSuchElementException("this element does not exist");
        }
        s--;
        this.size = s;
        E temp = this.data[this.b];
        // holds value that will be removed
        this.data[b] = null;
        this.b = this.b - 1;
        if (this.b < 0 && this.b == -1) {
            this.b = l;
        }
        return temp;
    }
}
