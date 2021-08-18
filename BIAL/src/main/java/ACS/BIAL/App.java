package ACS.BIAL;

import Methods.CommonMethods;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );

        CommonMethods cm = new CommonMethods();
        System.out.println("awbno:"+cm.Random_awbNo());
        System.out.println("awbno:"+cm.Random_awbNo());
        System.out.println("awbno:"+cm.Random_awbNo());
        System.out.println("awbno:"+cm.Random_awbNo());
        System.out.println("awbno:"+cm.Random_awbNo());
        System.out.println("awbno:"+cm.Random_awbNo());
        
        
        cm.Random_hawbNo();
        cm.GSTIN(); 
        String date = cm.SpecificDate(0);
        System.out.println(date);
       
        System.out.println( cm.RandomNo(7));
    }
}
