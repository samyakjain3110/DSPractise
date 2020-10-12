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
    

    //378
public int kthSmallest(int[][] matrix, int k) {

    int n = matrix.length;
    int m = matrix[0].length;

    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return matrix[a/m][a%m] - matrix[b/m][b%m];
    });

    for(int i=0;i<n;i++) pq.add(i * m + 0);

    while(--k > 0){
        int idx = pq.poll();
        int r = idx / m;
        int c = idx % m;

        c++;
        if(c < m) pq.add(r * m + c);
    }

    int val = pq.peek();
    return Matrix[val/m][val%m];
}

