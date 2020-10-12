public class l001questionHeap{
    
    //Leetcode 215
    int findKthLargest(int[] nums, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: nums){
            pq.add(ele);
            if(pq.size() > k) pq.poll();
        }

        return pq.peek();
    }

        // Leetcode 703
        class KthLargest {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int size = 0;
            public KthLargest(int k, int[] nums) {
                this.size = k;
                for(int ele:nums){
                    pq.add(ele);
                    if(pq.size() > this.size) pq.poll();
                }
            }
            
            public int add(int val) {
                pq.add(val);
                if(pq.size() > this.size) pq.poll();
                return pq.peek();
            }
        }
    }
    
