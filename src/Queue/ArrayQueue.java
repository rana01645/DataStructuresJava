package Queue;

public class ArrayQueue implements Queue{
    int size;
    int front;
    int rear;
    Object [] data;
    
    public ArrayQueue(){
        size=0;
        front = -1;
        rear = -1;
        data = new Object[5];
    }

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size==0) {
			return true;
		}
		return false;
	}

	@Override
	public void enqueue(Object o) throws QueueOverflowException {
		 if(size<data.length){
		        data[size] = o;
		        rear++;
		        front = 0;
		        size++;
		      }else{
		        throw new QueueOverflowException();
		      }
		
	}

	@Override
	public Object dequeue() throws QueueUnderflowException {
		if(size==0){
	        throw new QueueUnderflowException();
	      }else{
	        Object temp = data[front];
	        for (int i = 0; i < data.length-1; i++) {
				data[i] = data[i+1];
			}
	        rear--;
	        size--;
	        return temp;
	      }
	}

	@Override
	public Object peek() throws QueueUnderflowException {
		 if(size!=0){
		        return data[front];
		      }else{
		        throw new QueueUnderflowException();
		      }
	}

	@Override
	public Object[] toArray() {
		Object st[] = new Object[size];
        for(int i = front,j=0;i<=rear;j++,i++){
          st[j] = data[i];
        }
      return st;
	}

	@Override
	public int search(Object o) {
		 if(size!=0){
			 int c =0;
		        for(int i = front;i<=rear;i++,c++){
		          if(o.equals(data[i])){
		            return c;
		          }
		        }
		      }
		      return -1;
	}
	
	public String toString(){
	      String s = "";
	      if(size!=0){
	        for(int i = front;i<=rear;i++){
	          s+=data[i]+" ";
	        }
	      }
	      
	      return "[ "+s+ " ]";
	    }
    

    
}