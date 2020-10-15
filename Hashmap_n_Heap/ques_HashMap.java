public class ques_HashMap{
    //349
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> map = new HashSet<>();
        for(int ele: nums1) map.add(ele);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele: nums2){
            if(map.contains(ele)){
                list.add(ele);
                map.remove(ele);
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i=0;i<ans.length;i++) ans[i] = list.get(i);
        
        return ans;
    }
 
     //350
     public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele: nums1) map.put(ele,map.getOrDefault(ele,0)+1);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int ele: nums2){
            if(map.containsKey(ele)){
                map.put(ele,map.get(ele) - 1);
                list.add(ele);
                
                if(map.get(ele) == 0) map.remove(ele);
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i=0;i<ans.length;i++) ans[i] = list.get(i);
        
        return ans;
        
    }

    
    return true;
}

/** Get a random element from the set. */
public int getRandom() {
    int idx = rand.nextInt(list.size()); 
    return list.get(idx);
}
}   

// https://www.geeksforgeeks.org/maximum-consecutive-ones-or-zeros-in-a-binary-array/

class FreqStack {

HashMap<Integer,Integer> freq = new HashMap<>();
HashMap<Integer,Stack<Integer>> map = new HashMap<>();
int maxFreq = 0;

public FreqStack() {
    
}

public void push(int x) {
    freq.put(x,freq.getOrDefault(x,0) + 1);
    maxFreq = Math.max(maxFreq,freq.get(x));
    
    map.putIfAbsent(freq.get(x),new Stack<>());
    map.get(freq.get(x)).push(x);
}

public int pop() {
    int rv = map.get(maxFreq).pop();
    freq.put(rv,maxFreq - 1);
    if(map.get(maxFreq).size() == 0) {
        map.remove(maxFreq);
        maxFreq--;
    }
    return rv;
    
}
}