class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        
        for(int num:arr){
            pq.offer(num);
            
            if(pq.size()>k){
                pq.poll();
                
            }
        }
        
        for(int i = 0; i<k; i++){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
