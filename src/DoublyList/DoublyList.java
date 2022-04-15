package DoublyList;

public class DoublyList {
    public Node head;


    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public DoublyList(Object[] a) {
        head = new Node(null, null, null);
        Node tail = head;

        for (int i = 0; i < a.length; i++) {
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev = tail;
            tail = tail.next;
        }
        tail.next = head; // Making it circular
        head.prev = tail;
    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h) {
        head = h;
    }

    /* Counts the number of Nodes in the list */
    public int countNode() {
        // TO DO
        int count = 0;

        for (Node s = head.next; s != head; s = s.next) {
            count++;
        }

        return count; // please remove this line!
    }

    /* prints the elements in the list */
    public void forwardprint() {
        for (Node temp = head.next; temp != head; temp = temp.next) {
            System.out.print(temp.element + " ");
        }
        System.out.println();
        // TO DO    
    }

    public void backwardprint() {
        // TO DO  
        Node t = null;
        for (Node s = head.next; s != head; s = s.next) {
            t = s;
        }

        for (Node s = t; s != head; s = s.prev) {
            System.out.print(s.element + " ");
        }
        System.out.println();
    }


    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx) {
        // TO DO
        Node node = null;

        if (idx < -1 || idx >= countNode()) {
            return null;
        } else {
            if (idx == -1) {
                return head;
            }
            int count = 0;
            for (Node s = head.next; s != head; s = s.next) {
                if (count == idx) {
                    return s;
                }
                count++;
            }
        }
        return null;
    }


    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem) {
        // TO DO
        Node node = null;
        int count = 0;

        for (Node s = head.next; s != head; s = s.next) {
            if (s.element == elem) {
                return count;
            }
            count++;
        }
        return -1;
    }


    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx) {
        // TO DO6

        Node node = nodeAt(idx - 1);
        Node node2 = new Node(elem, node.next, node);
        node2.next.prev = node2;
        node.next = node2;

    }


    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index) {
        // TO DO
        if (index < 0 || index >= countNode()) {
            return null;
        } else {
            Node node = nodeAt(index - 1);
            Node r = node.next;
            node.next = node.next.next;
            node.next.prev = node;
            return r.element;
        }
    }


}