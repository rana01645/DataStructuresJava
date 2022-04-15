package Linkedlist;

public class LinkedList {
    public Node head;


    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public LinkedList(Object[] a) {
        // TO DO

        head = new Node(a[0], null);
        Node tail = head;
        for (int i = 1; i < a.length; i++) {
            Node b = new Node(a[i], null);
            tail.next = b;
            tail = tail.next;
        }
    }

    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public LinkedList(Node h) {
        // TO DO

        head = new Node(h.element, h.next);
    }

    /* Counts the number of Nodes in the list */
    public int countNode() {
        int c = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            c++;
        }
        return c; // please remove this line!
    }

    /* prints the elements in the list */
    public void printList() {
        // TO DO

        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.element + " ");
        }
        System.out.println();
    }

    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx) {
        int c = 0;

        for (Node temp = head; temp != null; c++, temp = temp.next) {
            if (c == idx) {
                return temp;
            }
        }
        return null;
        // please remove this line!
    }


    // returns the element of the Node at the given index. For invalid idx return null.
    public Object get(int idx) {
        int c = 0;

        for (Node temp = head; temp != null; c++, temp = temp.next) {
            if (c == idx) {
                return temp.element;
            }
        }
        return null; // please remove this line!
    }


    /* updates the element of the Node at the given index.
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    public Object set(int idx, Object elem) {
        // TO DO
        if (idx < 0 || idx >= countNode()) {
            return null;
        }
        Node node = nodeAt(idx);
        Object object = node.element;
        node.element = elem;
        return object; // please remove this line!
    }


    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem) {
        // TO DO
        int c = 0;

        for (Node temp = head; temp != null; c++, temp = temp.next) {
            if (temp.element == elem) {
                return c;
            }
        }
        return -1; // please remove this line!
    }

    // returns true if the element exists in the List, return false otherwise.
    public boolean contains(Object elem) {
        // TO DO

        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.element == elem) {
                return true;
            }
        }
        return false; // please remove this line!
    }

    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public Node copyList() {
        // TO DO

        Node newHead = new Node(head.element, null);
        Node tail = newHead;
        for (Node temp = head.next; temp != null; temp = temp.next) {
            Node b = new Node(temp.element, null);
            tail.next = b;
            tail = tail.next;
        }

        return newHead; // please remove this line!
    }

    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
    public Node reverseList() {

        Node revh = head;
        int c = 0;
        for (Node temp = head.next; temp != null; c++, temp = temp.next) {
            Node b = new Node(temp.element, null);
            b.next = revh;
            if (c == 0) {
                revh.next = null;
            }
            revh = b;
        }
        // TO DO
        return revh; // please remove this line!
    }

    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx) {
        // TO DO
        if (idx < 0 || idx > countNode()) {

        } else {
            if (idx == 0) {
                Node node = new Node(elem, head);
                head = node;
            } else {
                Node node = nodeAt(idx - 1);
                Node node2 = new Node(elem, node.next);
                node.next = node2;
            }
        }
    }


    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index) {
        if (index < 0 || index >= countNode()) {

            return null;
        } else {
            if (index == 0) {
                Node headold = head;
                head = head.next;
                return headold.element;
            } else {
                Node node = nodeAt(index - 1);
                Node oldn = node.next;
                node.next = node.next.next;
                return oldn.element;
            }
        } // please remove this line!
    }

    // Rotates the list to the left by 1 position.
    public void rotateLeft() {
        // TO DO
        Node b = head;

        head = head.next;
        Node tail = null;
        for (Node temp = head.next; temp != null; temp = temp.next) {
            tail = temp;
        }
        tail.next = b;
        b.next = null;
    }

    // Rotates the list to the right by 1 position.
    public void rotateRight() {
        // TO DO

        Node b = nodeAt(countNode() - 1);
        nodeAt(countNode() - 2).next = null;

        b.next = head;
        head = b;
    }

}
