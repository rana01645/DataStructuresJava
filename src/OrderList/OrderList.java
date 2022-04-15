package OrderList;

public interface OrderList {

    public void insert(Node newElement);

    public Node retrieve(int key);

    public Node remove();

    public Node remove(int key);

    public void clear();

    public boolean isEmpty();

    public Node gotoEnd();

    public Node gotoBeginning();

    public Node gotoNext();

    public Node gotoPrior();

    public Node getCursor();

    public void showList();

}
