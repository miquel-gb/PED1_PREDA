package ped1_preda;

import java.util.ArrayList;

/**
 *
 * @author Miquel Ginés Borràs
 */
public class PED1_PREDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PED1_PREDA(args);
    }
    
    public PED1_PREDA(String[] args) {
        System.out.println("Loading...");
        
        ArrayList<Integer> a = new ArrayList<>();
        
        a.add(5);
        a.add(2);
        a.add(7);
        a.add(10);
        a.add(3);
        a.add(8);
        a.add(9);
        a.add(12);
        a.add(15);
        a.add(1);
        a.add(4);
        a.add(6);
        a.add(11);
        a.add(13);
        a.add(14);
        
        SubsetSum subsetSum =  new SubsetSum(a, 11, 4);
        
        subsetSum.computeSubsetSum();
        
        subsetSum.printSolutions();
        
        try {
            //ArgsHelper argsHelper = new ArgsHelper(args);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
