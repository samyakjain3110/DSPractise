import java.util.ArrayList ;

public class practise {


    public static class Edge {
        int v;
        int wt ;
        
        Edge(int v , int wt)
        {
            this.v = v ;
            this.wt = wt ;
        }
    }

    static int N = 7 ;
    static ArrayList<Edge>[] graph = new ArrayList[N] ;

    public static void addEdge(int u, int v, int w)
    {
        graph[u].add(new Edge(v,w)) ;
        graph[v].add(new Edge(u,w)) ;
    }

    public static void constructgraph()
    {
        for(int idx = 0 ; idx < N ;idx++ )
        {
            graph[idx] = new ArrayList<Edge> () ;
        }

          
        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(5,6,3);
        addEdge(4,6,8);

        // addEdge(0,1,10);
        // addEdge(1,2,10);
        // addEdge(2,3,10);
        // addEdge(3,0,10);
        // addEdge(0,4,10);

        display();
    }

    public static void solve() 
    {
        constructgraph() ; 
        // removeEdge(1, 0);
        // display() ; 
        int noOfPaths = allPath(0 ,6 ,new boolean[N] ,0 ,"") ;
        System.out.println(noOfPaths) ;
    }

    // **************************************************************************
   
    public static class Pair{
        int wt ;
        String path ;
        Pair(int wt , String path)
        {
            this.wt = wt ;
            this.path = path ;
        }
    }

    public static Pair heavyWeightPath(int src , int dest, boolean vis[])
    {
        // if u are already at destination return 0 wt and only yourself in path 
        if(src == dest)
        {
            return new Pair(0,src+ "") ;
        }
    }

    public static int allPath(int src ,int dest, boolean[] vis,int wt, String path)
    {
        if(src == dest)
        {
            System.out.println(path + " " + src + " @ " + wt ) ;
            return 1 ;
        }
        vis[src] = true ;

        int count = 0 ; 
        for(Edge e : graph[src] )
        {
            if( !vis[e.v] )
            {
                count += allPath(e.v , dest, vis , wt + e.wt , path + src ) ;
            }
        }
        vis[src] = false ;

        return count ;
    }

    public static boolean hasPath(int src,int dest,boolean[] vis)
    {
        if(src == dest) return true ;

        boolean found = false ;
        // move to each edge and ask nbr to get path
        for(Edge e : graph[src])
        {
           if(!vis[e.v])
           {
                vis[e.v] = true ;
                found = found || hasPath(e.v, dest,vis) ;
           } 
        }
        return found ;
    }
   

    // **************************************************************************

    public static int findEdge(int u,int v)
    {
        int idx = -1 ;
        for( idx = 0 ; idx < graph[u].size() ; idx++ )
        {
            Edge e = graph[u].get(idx) ;
            if(e.v == v) return idx ;
        }
        return idx ;
    }

    public static void removeEdge(int u,int v)
    {
        // find idx of v in u
        int idx = findEdge(u,v) ;
        // remove v fronm u
        graph[u].remove(idx) ;

        // find idx of u in v 
        idx = findEdge(v,u) ;
        // remove u from v
        graph[v].remove(idx) ;
    }

    public static void removeVtx(int u)
    {
        while(graph[u].size() > 0)
        {
            // remove all your edges // from last to first to avoid shifting
            Edge e = graph[u].get(graph[u].size() - 1) ;
            removeEdge(u, e.v) ;
        }
    }

    public static void display()
    {
        StringBuilder sb = new StringBuilder() ;
        // get each vtx
        for(int idx = 0 ; idx < N ; idx++ )
        {
            sb.append(idx + " -> ") ;
            // get all neighbours of each vtx
            for(Edge e : graph[idx])
            {
                sb.append( "(" + e.v+ "," + e.wt + ") ") ;
            }
            sb.append("\n") ;
        }

        System.out.println(sb) ;
    }

    public static void main(String args[])
    {
        solve() ;
    }
}
