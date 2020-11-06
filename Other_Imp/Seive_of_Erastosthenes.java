import java.util.* ;

public class Seive_of_Erastosthenes {
    
    public static void main(String args[])
    {
        int n = 248 ;

        HashMap<Integer,Integer> map = new HashMap<> () ;

        while (n%2==0) 
        { 
            n /= 2; 
            if(map.containsKey(2))
                    {
                        int val = map.get(2) ;
                        map.put(2,val + 1) ;
                    }
                    else 
                    map.put(2,1) ;
        } 

        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            // While i divides n, print i and divide n 
            while (n%i == 0) 
            { 
                System.out.print(i + " "); 
                n /= i; 
                if(map.containsKey(i))
                    {
                        int val = map.get(i) ;
                        map.put(i,val + 1) ;
                    }
                    else 
                    map.put(i,1) ;
            } 
        } 

        if (n > 2) 
        {
            if(map.containsKey(n))
                    {
                        int val = map.get(n) ;
                        map.put(n,val + 1) ;
                    }
                    else 
                    map.put(n,1) ;
        }

        Set<Integer> kset = map.keySet() ;
        for(int idx : kset)
        {
            System.out.println(idx + " " +  map.get(idx)) ;
        }
    }


}
