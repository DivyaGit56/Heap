class MinHeap {


   ArrayList<Integer>heap;
    // Constructor
    public MinHeap() {
        // Initialize your data members
        heap = new ArrayList<>();
        
    }

    public void push(int x) {
        // Insert x into the heap
        heap.add(x);
        
       int i = heap.size()-1;
        
        // now , we need to heapify elment of above 
        while(i>0){
            int parent = (i-1)/2;
            
            
            if(heap.get(parent) <= heap.get(i)){
                break;
            }
            
            int temp = heap.get(i);
            heap.set(i,heap.get(parent));
            heap.set(parent,temp);
            
            i=parent;
        }
    }

    public void pop() {
        // Remove the top (minimum) element
        
        if (heap.isEmpty()) {
                    return;
                }

                int last = heap.remove(heap.size() - 1);

                if (heap.isEmpty()) {
                    return;
                }

                heap.set(0, last);
        int i = 0;
        int n = heap.size();
        
        while(true){
            int smallest = i;
            int left = 2*i+1;
            int right = 2*i+2;
            
            if(left<n && heap.get(left)< heap.get(smallest)){
                smallest = left;
            }
            
            if(right<n && heap.get(right) < heap.get(smallest)){
                smallest = right;
            }
            
            if(smallest == i){
                break;
            }
            int temp = heap.get(i);
            heap.set(i,heap.get(smallest));
            heap.set(smallest, temp);
            
            i= smallest;
        }
    }

    public int peek() {
        // Return the top element or -1 if empty
        if (heap.isEmpty()) {
                   return -1;
               }

               return heap.get(0);
           }
    

    public int size() {
        // Return the number of elements in the heap
       return  heap.size();
    }
}
