package OrderList;

public class TestMyOrderList {

    public static void main(String[] args) {
        MyOrderList list = new MyOrderList();
        list.insert(new Node(10, null));
        list.insert(new Node(15, null));
        list.insert(new Node(20, null));
        list.insert(new Node(50, null));
        list.insert(new Node(30, null));
        list.insert(new Node(-1, null));
        list.insert(new Node(-110, null));
        list.insert(new Node(15, null));
        list.insert(new Node(150, null));
        list.insert(new Node(100, null));
        list.insert(new Node(25, null));
        list.showList();
        System.out.println("Empty list:  " + list.isEmpty());
        System.out.println("After remove");
        list.remove();
        list.showList();
        System.out.println("After remove 100");
        list.remove(100);
        list.showList();
        System.out.println("Go to begining");
        list.gotoBeginning();
        list.showList();

        System.out.println("Go to End");
        list.gotoEnd();
        list.showList();

        System.out.println("Go to Next");
        list.gotoNext();
        list.showList();

        System.out.println("Go to Prior");
        list.gotoPrior();
        list.showList();

        System.out.println("Retrieve ");
        list.retrieve(15);
        list.showList();
        System.out.println("Clear");
        list.clear();
        list.showList();
        System.out.println("Empty list:  " + list.isEmpty());

    }

}
