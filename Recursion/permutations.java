public class permutations {
    public static void main(String args[])
    {
        String qsf = "abcd" ;
        String asf = "" ;
        permutation(qsf,asf);
    }

    public static void permutation(String qsf,String asf)
    {
        int len = qsf.length() ;
        if(len == 0)
        {
            System.out.println(asf) ;
            return ;
        }
        for( int idx = 0 ; idx < len ; idx++ )
        {
            String ch = qsf.charAt(idx) + "" ;
            String newasf = asf + ch ;
            String newqsf = qsf.substring(0, idx) + qsf.substring(idx+1, len) ;
            permutation(newqsf, newasf);
        }
    }
    public static void unique_permutations(String qsf,String asf)
    {
        int len = qsf.length() ;
        if(len == 0)
        {
            System.out.println(asf) ;
            return ;
        }
        for( int idx = 0 ; idx < len ; idx++ )
        {
            boolean same = false ;
            for( int i = idx ; i < len ; i++ )
            {
                if(qsf.charAt(idx) == qsf.charAt(i))
                {
                    same = true ;
                }
            }
            String ch = qsf.charAt(idx) + "" ;
            String newasf = asf + ch ;
            String newqsf = qsf.substring(0, idx) + qsf.substring(idx+1, len) ;
            // if(same != true)
            // // permutations(newqsf, newasf);
        }
    }
}