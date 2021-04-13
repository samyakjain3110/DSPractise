import java.util.Scanner;
import java.io.BufferedReader ;
import java.io.InputStreamReader ;
import java.lang.Exception ;

/* Name of the class has to be "Main" only if the class is public. */
class ccAprilChallenge {
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in) ;
		int t = scn.nextInt() ;
		int facesCovered[] = {21 , 20 , 18 , 15 , 11 , 6 , 0} ;
		
		for(int idx = 0 ; idx < t ;idx++)
		{
		    long n = scn.nextLong() ;
		    int layers = n/4 ;
		    
		    long pips = 0 ;
		    if(layers < 1)
		    {
		        if(n == 1)
		            pips = facesCovered[1] ;
		        else if(n == 2)
		            pips = 2*facesCovered[2] ;
		        else
		            pips = 2*facesCovered[2] + facesCovered[3] ;
		        
		    }
		    if( layers >=1 )
		    {
		        if(n % 4 == 0)
		            pips = (layers - 1)*facesCovered[4] + facesCovered[3] ;
		            sum = 4*4 + (levels)*4*11;
		        else if(n % 4 == 1)
		            pips = (layers - 1)*facesCovered[4] + facesCovered[3] - 1*4 + facesCovered[1]  ;
		            sum = (levels)*4*11+ 4*4 + 21 -1 -4;
		        else if(n % 4 == 2)
		            pips = (layers - 1)*facesCovered[4] + facesCovered[3] - 2*4 +  2*facesCovered[2]
		            (levels)*4*11 + 4*4 + 21 -1 -4 + 21 - 1 -4 -2 -2;
		        else
		            pips = (layers - 1)*facesCovered[4] + facesCovered[3] - 3*4 + (2*facesCovered[2] + facesCovered[3])
		            sum = (levels)*4*11 + 4*4                         -4  -4 -4 + (21 -1  + 21 - 1  -2 -2 )+ (21 -1 -3 -2);
		    }
		}
	}
}


/*
public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in) ;
		
	
		int t = scn.nextInt();
		for(int i=0;i<t;i++)
		{
			scn.nextLine();
			long n = scn.nextLong();
		    long layers = n/4 ;
		    
		    long pips = 0 ;
		    if(layers < 1)
		    {
		        if(n == 1)
		            pips = facesCovered[1] ;
		        else if(n == 2)
		            pips = 2*facesCovered[2] ;
		        else
		            pips = 2*facesCovered[2] + facesCovered[3] ;
		        
		    }
		    if( layers >=1 )
		    {
		        if(n % 4 == 0)
		            pips = (layers - 1)*facesCovered[4] + 4*facesCovered[3] ;
		        else if(n % 4 == 1)
		            pips = (layers - 1)*facesCovered[4] + 4*facesCovered[3] - 1*4 + facesCovered[1]  ;
		        else if(n % 4 == 2)
		            pips = (layers - 1)*facesCovered[4] + 4*facesCovered[3] - 2*4 +  2*facesCovered[2] ;
		        else
		            pips = (layers - 1)*facesCovered[4] + 4*facesCovered[3] - 3*4 + (2*facesCovered[2] + facesCovered[3]) ; 
		    }
		    System.out.println(pips) ;
		}
	}










































    /* package codechef; // don't place package name! */

import java.util.Scanner  ;
import java.io.BufferedReader ;
import java.io.InputStreamReader ;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
 
	public static void main (String[] args) throws java.lang.Exception
	{
	    int facesCovered[] = {21 , 20 , 18 , 15 , 11 , 6 , 0} ;
	//	Scanner scn = new Scanner(System.in) ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
	    String line ;
	
		int t = Integer.parseInt(br.readLine()) ; // scn.nextInt();
		for(int i=0;i<t;i++)
		{
			long n = Long.parseLong(br.readLine()) ; // scn.nextLong();
		    long layers = n/4 ;
		    
		    long pips = 0 ;
		    if(layers < 1)
		    {
		        if(n == 1)
		            pips = facesCovered[1] ;
		        else if(n == 2)
		            pips = 2*facesCovered[2] ;
		        else
		            pips = 2*facesCovered[2] + facesCovered[3] ;
		        
		    }
		    if( layers >=1 )
		    {
		        if(n % 4 == 0)
		            pips = (layers - 1)*facesCovered[4] + 4*facesCovered[3] ;
		        else if(n % 4 == 1)
		            pips = (layers - 1)*facesCovered[4] + 4*facesCovered[3] - 1*4 + facesCovered[1]  ;
		        else if(n % 4 == 2)
		            pips = (layers - 1)*facesCovered[4] + 4*facesCovered[3] - 2*4 +  2*facesCovered[2] ;
		        else
		            pips = (layers - 1)*facesCovered[4] + 4*facesCovered[3] - 3*4 + (2*facesCovered[2] + facesCovered[3]) ; 
		    }
		    System.out.println(pips) ;
		}
	}
	
}

















