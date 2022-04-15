package CircularArray;

public class CircularArray {

    private int start;
    private int size;
    private Object[] cir;

    /*
     * if Object [] lin = {10, 20, 30, 40, null}
     * then, CircularArray(lin, 2, 4) will generate
     * Object [] cir = {40, null, 10, 20, 30}
     */
    public CircularArray(Object[] lin, int st, int sz) {
        //TO DO
        cir = new Object[lin.length];
        start = st;
        size = sz;
        int k = st;

        for (int i = 0; i < size; i++) {
            cir[k] = lin[i];
            k = (k + 1) % cir.length;
        }
    }

    //Prints from index --> 0 to cir.length-1
    public void printFullLinear() {

        for (int i = 0; i < cir.length; i++) {
            System.out.print(cir[i] + " ");
        }
        System.out.println();


        //TO DO
    }

    // Starts Printing from index start. Prints a total of size elements
    public void printForward() {
        //To DO
        for (int i = start, c = 0; c < size; i = (i + 1) % cir.length, c++) {
            System.out.print(cir[i] + " ");

        }

        System.out.println();
    }


    public void printBackward() {
        //TO DO
        for (int c = size, i = (start + size - 1) % cir.length; c > 0; c--) {
            System.out.print(cir[i] + " ");
            i = (i - 1) % cir.length;
            if (i == -1) {
                i = cir.length - 1;
            }

        }
        System.out.println();
    }

    // With no null cells
    public void linearize() {
        //TO DO
        Object lin[] = new Object[size];
        for (int i = start, j = 0; j < size; j++, i = (i + 1) % cir.length) {
            lin[j] = cir[i];
        }
        cir = lin;
    }

    // Do not change the Start index
    public void resizeStartUnchanged(int newcapacity) {
        //TO DO
        Object temp[] = new Object[newcapacity];

        for (int i = start, j = start, c = 0; c < cir.length; j = (j + 1) % temp.length, i = (i + 1) % cir.length, c++) {
            temp[j] = cir[i];
        }

        cir = temp;
    }

    // Start index becomes zero
    public void resizeByLinearize(int newcapacity) {
        //TO DO

        Object temp[] = new Object[newcapacity];

        for (int i = start, j = 0, c = 0; c < cir.length; j = (j + 1) % temp.length, i = (i + 1) % cir.length, c++) {
            temp[j] = cir[i];
        }

        cir = temp;
    }

    /* pos --> position relative to start. Valid range of pos--> 0 to size.
     * Increase array length by 3 if size==cir.length
     * use resizeStartUnchanged() for resizing.
     */
    public void insertByRightShift(Object elem, int pos) {
        //TO DO
        if (size == cir.length) {
            resizeStartUnchanged(size + 3);
            for (int i = (start + size) % cir.length, c = 0; c < size - pos; c++, i = (i - 1) % cir.length) {
                cir[i] = cir[(i - 1) % cir.length];
            }
            cir[start + pos] = elem;
            size++;
        } else {
            for (int i = (start + size) % cir.length, c = 0; c < size - pos; c++, i = (i - 1) % cir.length) {
                cir[i] = cir[(i - 1) % cir.length];
            }
            cir[start + pos] = elem;
            size++;
        }
    }

    public void insertByLeftShift(Object elem, int pos) {
        //TO DO
        if (size == cir.length) {
            resizeStartUnchanged(size + 3);
            for (int i = (start + cir.length - 1) % cir.length, c = 0; c < start + pos; c++, i = (i + 1) % cir.length) {
                cir[i] = cir[(i + 1) % cir.length];
            }
            cir[start + pos] = elem;
            size++;
            start--;
            if (start == -1) {
                start = cir.length - 1;
            }
        } else {
            for (int i = (start + cir.length - 1) % cir.length, c = 0; c < start + pos; c++, i = (i + 1) % cir.length) {
                cir[i] = cir[(i + 1) % cir.length];
            }

            cir[start + pos] = elem;
            size++;
            start--;

            if (start == -1) {
                start = cir.length - 1;
            }
        }

    }

    /* parameter--> pos. pos --> position relative to start.
     * Valid range of pos--> 0 to size-1
     */
    public void removeByLeftShift(int pos) {
        //TO DO
        for (int i = (start + size - 2) % cir.length, c = 0; c < size - pos; c++, i = (i + 1) % cir.length) {
            cir[i] = cir[(i + 1) % cir.length];
            cir[(i + 1) % cir.length] = null;

        }
        size--;
    }

    /* parameter--> pos. pos --> position relative to start.
     * Valid range of pos--> 0 to size-1
     */
    public void removeByRightShift(int pos) {
        //TO DO
        for (int i = (start + pos % cir.length), c = 0; c < pos; c++) {
            cir[i] = cir[i - 1];
            cir[i - 1] = null;
            i--;
        }
        start = (start + 1) % cir.length;
        size--;
    }


    //This method will check whether the array is palindrome or not
    public void palindromeCheck() {
        int last = (start + size - 1) % cir.length;
        int s = start;
        boolean flag = false;
        for (int i = 0; i < size / 2; i++) {
            if (cir[s] == cir[last]) {
                flag = true;
            } else {
                flag = false;
                break;
            }
            last--;
            if (last == -1) {
                last = cir.length - 1;
            }
            s = (s + 1) % cir.length;

        }
        if (flag) {
            System.out.println("This array is a palindrome");
        } else {

            System.out.println("This array is not a palindrome");
        }
    }


    //This method will sort the values by keeping the start unchanged
    public void sort() {

        for (int i = 0, j = start % cir.length; i < size - 1; i++, j = (j + 1) % cir.length) {
            int l = (j + 1) % cir.length;
            for (int k = 0; k < size - 1 - i; k++, l = (l + 1) % cir.length) {
                int m = (Integer) cir[j];
                int n = (Integer) cir[l];
                if (n < m) {
                    int temp = (Integer) cir[j];
                    cir[j] = cir[l];
                    cir[l] = temp;
                }
            }
        }
    }

    //This method will check the given array across the base array and if they are equivalent interms of values return true, or else return false
    public boolean equivalent(CircularArray k) {
        //TO DO
        boolean flag = false;
        if (size == k.size) {
            int s1 = start % cir.length;
            int s2 = k.start % k.cir.length;
            for (int i = 0; i < size; i++) {
                if (cir[s1].equals(k.cir[s2])) {
                    flag = true;
                } else {
                    return false;
                }
                s1 = (s1 + 1) % cir.length;
                s2 = (s2 + 1) % k.cir.length;
            }


            return flag;
        } else {

            return false;
        }

    }
}
