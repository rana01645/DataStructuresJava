package OrderList;

public class MyOrderList implements OrderList {
    Node cursor;

    public MyOrderList() {
        cursor = null;
    }

    public void insert(Node newElement) {
        if (cursor == null) {
            cursor = newElement;

            cursor.next = cursor;
        } else if (cursor.next == cursor) {
            if (newElement.key < cursor.key) {
                newElement.next = cursor;
                cursor.next = newElement;
                cursor = newElement;
            } else if (newElement.key > cursor.key) {
                cursor.next = newElement;
                newElement.next = cursor;
            }

        } else {
            if (newElement.key < cursor.key) {
                Node end = End();
                newElement.next = cursor;
                cursor = newElement;
                end.next = cursor;
            } else {
                if (newElement.key > cursor.key && newElement.key < cursor.next.key) {
                    newElement.next = cursor.next;
                    cursor.next = newElement;
                } else {
                    for (Node i = cursor.next; i != cursor; i = i.next) {
                        if (newElement.key > i.key && newElement.key < i.next.key) {
                            newElement.next = i.next;
                            i.next = newElement;
                            break;
                        } else if (newElement.key > i.key && newElement.key > i.next.key && i.next == cursor) {
                            newElement.next = i.next;
                            i.next = newElement;
                            break;
                        }
                    }
                }
            }
        }

    }

    public Node retrieve(int key) {
        if (cursor.key == key) {
            return cursor;
        } else {

            for (Node temp = cursor.next; temp != cursor; temp = temp.next) {
                if (key == temp.key) {
                    cursor = temp;
                    return temp;
                }
            }
        }

        System.out.println("This key not found");
        return null;

    }

    public Node remove() {
        Node removed = null;
        Node c = null;
        for (Node temp = cursor.next; temp != cursor; temp = temp.next) {
            c = temp;
        }
        c.next = cursor.next;
        removed = cursor;
        cursor = cursor.next;

        return removed;

    }

    public Node remove(int key) {
        Node removed = null;
        if (cursor.key == key) {
            Node c = null;
            for (Node temp = cursor.next; temp != cursor; temp = temp.next) {
                c = temp;
            }
            c.next = cursor.next;
            removed = cursor;
            cursor = cursor.next;
        } else {
            for (Node temp = cursor.next; temp != cursor; temp = temp.next) {
                if (temp.key == key) {
                    Node c = null;
                    for (Node i = temp.next; i != temp; i = i.next) {
                        c = i;
                    }
                    c.next = temp.next;
                    removed = cursor;
                    cursor = temp.next;
                }
            }
        }

        return removed;


    }

    public void clear() {
        cursor = null;

    }

    public boolean isEmpty() {
        if (cursor == null) {
            return true;
        }

        return false;
    }

    public Node End() {
        Node temp = null;
        if (cursor.next == cursor) {
            return cursor;
        }
        if (cursor.key > cursor.next.key) {
            return cursor;
        } else {
            for (Node i = cursor.next; i != cursor; i = i.next) {
                if (i.key > i.next.key) {
                    temp = i;
                }
            }
        }

        return temp;


    }

    public Node gotoEnd() {
        if (cursor == null) {
            return null;
        }
        if (cursor.next == cursor) {
            return cursor;
        }
        if (cursor.key > cursor.next.key) {
            return cursor;
        } else {
            for (Node i = cursor.next; i != cursor; i = i.next) {
                if (i.key > i.next.key) {
                    cursor = i;
                }
            }
        }

        return cursor;


    }

    public Node gotoBeginning() {
        if (cursor == null) {
            return cursor;
        }
        if (cursor.next == cursor) {
            return cursor;
        }
        if (cursor.key > cursor.next.key) {
            cursor = cursor.next;
            return cursor;
        } else {
            for (Node i = cursor.next; i != cursor; i = i.next) {
                if (i.key > i.next.key) {
                    cursor = i.next;
                }
            }
        }

        return cursor;


    }

    public Node gotoNext() {
        if (cursor == null) {
            return cursor;
        }
        cursor = cursor.next;
        return cursor;

    }

    public Node gotoPrior() {
        Node temp = null;
        if (cursor == null) {
            return cursor;
        }
        for (Node i = cursor.next; i != cursor; i = i.next) {
            temp = i;
        }
        cursor = temp;
        return cursor;

    }

    public Node getCursor() {
        return cursor;
    }

    public void showList() {
        if (cursor != null) {
            System.out.println(cursor.key);
            for (Node i = cursor.next; i != cursor; i = i.next) {
                System.out.println(i.key);
            }
        } else {
            System.out.println("List is empty");
        }

    }
}
