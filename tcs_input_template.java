import java.io.*;
import java.util.* ;
public class tcs_input_template {
    
    
    
    public class MyClass{

        public static void main(String args[])
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
            String line ;
            ArrayList<String> arr = new ArrayList<> () ;

            while( (line = br.readLine() ) != null && line.length() > 0 )
            {
                arr.add(line) ;
            }

            // String str = String.format("%.3f", num) ;
        }

    }


}
