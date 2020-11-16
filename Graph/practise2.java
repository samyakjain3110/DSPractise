import java.util.ArrayList ;
import java.util.LinkedList ;

public class practise2 {
    
    public static class Edge{
        int v ;
        int wt ;

        public Edge(int v, int wt )
        {
            this.v = v ;
            this.wt = wt ;
        }
    }

    static int N = 10 ;

    static ArrayList<Edge>[] graph = new ArrayList[N] ;

    public static void addEdge(int u, int v , int wt)
    {
        graph[u].add(new Edge(v, wt) ) ;
        graph[v].add(new Edge(u, wt) ) ;
    }


    public static void constructgraph()
    {
        for(int idx = 0 ;idx < N ;idx++ )
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
        addEdge(7,8,1);
        addEdge(9,8,1);
        addEdge(7,9,1);
 
        // display();
    }


    public static void display()
    {
        StringBuilder sb = new StringBuilder() ;

        for(int idx = 0 ; idx < N ;idx++ )
        {
            for(Edge e : graph[idx])
            {
                sb.append( "(" + e.v + "," + e.wt + ") ") ;
            }
            sb.append("\n") ;
        }
        System.out.println(sb) ;
    }

    public static void main(String args[] )
    {
        solve() ;
    }

    

    // public static void GCC()
    // {
    //     int components = 0 ;
    //     boolean vis[] = new boolean[N] ;
    //     int area[] = new int[N] ;
    //     // check each component
    //     for(int idx = 0 ; idx < N ;idx++ )
    //     {
    //         if(!vis[idx])
    //         {
    //             components++ ;
    //             area[idx] += dfs(idx, vis) ;
    //         }
    //     }
    //     System.out.println("No of components :" + components) ;
    //     for(int idx = 0 ; idx < N ; idx++ )
    //     {
    //         System.out.println(idx + " -> " + area[idx]) ;
    //     }
    // }

    // public static int dfs(int src, boolean vis[])
    // {
    //     vis[src] = true ;
    //     int area = 0 ;
    //     for(Edge e : graph[src])
    //     {
    //         if(!vis[e.v])
    //         area += dfs(e.v,vis) ;
    //     }
    //     return area + 1 ;
    // }

    public static void gcc()
    {
        int area[] = new int[N] ;
        int components = 0 ;
        boolean vis[] = new boolean[N] ;
        // make call to each component
        for(int idx = 0 ;idx < N ;idx++ )
        {
            if(!vis[idx])
            {
                vis[idx] = true ;
                components++ ;
                // travel dfs on each component
                System.out.println("Starting to search the component starting with :" + idx) ;
                area[idx] += dfs(idx,vis) ;
            }
        }
        System.out.println("No of Components are :" + components ) ;
        for(int ar : area)
        {
            System.out.println(ar) ; 
        }
    }

    public static int dfs(int src, boolean vis[])
    {
        int area = 0 ;
        // for all unvisited edge further apply dfs
        for(Edge e : graph[src])
        {
            if(!vis[e.v])
            {
                System.out.println("Searching edge :" + src + "->" + e.v) ;
                vis[e.v] = true ;
                area += dfs(e.v,vis) ;
                System.out.println("Edge " + src + "->" + " has " + area + " more connected vtx") ;
            }
        }
        return area + 1 ;
    }

    public static void BFS(int src,boolean vis[])
    {
        LinkedList<Integer> q = new LinkedList<> () ;
        q.addLast(src) ;

        while(q.size() > 0)
        {
            int vtx = q.removeFirst() ;

            if(vis[vtx])
            {
                System.out.println("Cycle found at :" + vtx) ;
                continue ;
            }

            // mark visited
            vis[vtx] = true ;
            System.out.println("Visited at : " + vtx) ;
            for(Edge e: graph[vtx])
            {
                if(!vis[e.v])
                q.addLast(e.v) ;
            }
        }
    }


    public static void bfs2(int src,boolean vis[])
    {
        LinkedList<Integer> q = new LinkedList<> () ;
        int level = 0 ;
        q.addLast(src) ;
        while(q.size() > 0)
        {
            int size = q.size() ;
            System.out.println(level) ;
            while(size-- > 0)
            {
                int vtx = q.removeFirst() ;

                if(vis[vtx])
                {
                    System.out.println("Cycle found at : " + vtx ) ;
                    continue ;
                }
                
                // mark visited
                vis[vtx] = true ;
                System.out.println("Visited at :" + vtx) ;
                for(Edge e : graph[vtx] )
                {
                    if(!vis[e.v])
                    {
                        q.addLast(e.v) ;
                    }
                }
            }
            level++ ;

        }
    }

    public static void bfs3(int src, boolean vis[])
    {
        LinkedList<Integer> q = new LinkedList<Integer> () ;

        q.addLast(src) ;
        vis[src] = true ;
        int level = 0 ;
        while(q.size() > 0)
        {
            int size = q.size() ;
            System.out.println(level) ;
            while(size-- > 0)
            {
                int vtx = q.removeFirst() ;
                System.out.println("Visited : " + vtx ) ;
                for(Edge e : graph[vtx])
                {
                    if(!vis[e.v])
                    {
                        q.addLast(e.v) ;
                        vis[e.v] = true ;
                    }
                }
            }
            level++ ;
        }
    }


// ======================================================================================

public static void solve()
    {
        constructgraph() ;

        // gcc() ;
        boolean vis[] = new boolean[N] ;
        for(int idx = 0 ;idx < N ;idx++ )
        {
            if(!vis[idx]) 
            // BFS(idx,vis) ;
            bfs3(idx,vis) ;
        }
        // GCC() ;
        // display() ;
    }



}