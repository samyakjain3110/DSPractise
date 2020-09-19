import java.util.ArrayList ;

public class practise {


    public class Edge {
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

        display();
    }

    public void solve() 
    {
        constructgraph() ; 
        display() ; 
    }

    // **************************************************************************
   
   

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

    public static void removeVtx(int v)
    {
        int n = graph[v].size() ;

        for(int idx = n - 1 ; idx >= 0 ; idx-- )
        {
            /// get its neighbour
            Edge e = graph[v].remove(idx) ;
            // remove yourself from neighbour
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
