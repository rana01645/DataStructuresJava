package Queue;

public class ListQueue implements Queue{
    int size;
    Node front;
    Node rear;
    
    
    public ListQueue(){
        size = 0;
        front = null;
        rear = null;
    }


	@Override
	public int size() {
		
		return size;
	}


	@Override
	public boolean isEmpty() {
		if (front==null) {
			return true;
		}else {
			return false;
		}
	}


	@Override
	public void enqueue(Object o) throws QueueOverflowException {
		if(front==null){
	        front = new Node(o,null);
	        rear =front;
	        size++;
	      }else{
	        Node n = new Node(o,null);
	        rear.next = n;
	        rear =n;
	        size++;
	      }
		
	}


	@Override
	public Object dequeue() throws QueueUnderflowException {
	      if(front!=null){
	          if(front.next == null){
	            Node temp = front;
	            front = null;
	            size--;
	            return temp.val;
	          }else{
	            Node temp = front;
	            front = front.next;
	            size--;
	            return temp.val;
	          }
	        }else{
	          throw new QueueUnderflowException();
	        }
	}


	@Override
	public Object peek() throws QueueUnderflowException {
		if(size!=0){
	        return front.val;
	      }else{
	        throw new QueueUnderflowException();
	      }
	}


	@Override
	public Object[] toArray() {
		Object st[] = new Object[size];
	      int j=0;
	        for(Node i = front; i!=null; j++,i=i.next){
	          st[j] = i.val;
	        }
	      return st;
	}


	@Override
	public int search(Object o) {
		int d = 0;
	      if(size!=0){
	        for(Node i = front; i!=null; i=i.next,d++){
	          if(o.equals(i.val)){
	            return d;
	          }
	        }
	      }
	      return -1;
	}
    
    public String toString(){
        String s = "";
        if(size!=0){
          for(Node i = front; i!=null; i = i.next){
            s+=i.val+" ";
          }
        }
        
        return "[ "+s+ " ]";
      }
//TO DO
}