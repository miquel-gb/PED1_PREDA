package ped1_preda;

import java.util.ArrayList;

/**
 *
 * @author Miquel Ginés Borràs
 */
public class SubsetSum {
    
    private ArrayList<Integer> numSet;
    
    private int sumGoal;
    
    private int maxSubset;
    
    private ArrayList<int[]> results = new ArrayList<>();
    
    public SubsetSum() {
        
    }

    public SubsetSum(ArrayList<Integer> numSet, int sumGoal, int maxSubset) {
        this.numSet = numSet;
        this.sumGoal = sumGoal;
        this.maxSubset = maxSubset;
    }

    public void computeSubsetSum() {
        compute(sumGoal, new ArrayList<Integer>(), numSet, 0);
    }
    
    private void compute(int n, ArrayList<Integer> xs, ArrayList<Integer> array, int i) {
        
        if (n == 0 && xs.size() <= maxSubset) {
            storeSolution(xs);
            return;
        }
        
        if (n < 0 || i >= array.size() || xs.size() > maxSubset) {
            return;
        }
        
        xs.add(array.get(i));
        
        compute(n - array.get(i), xs, array, i + 1);
        
        xs.remove(xs.size() - 1);
        
        compute(n, xs, array, i + 1);
    }
    
    // Invoke by isSubsetSum(numSet, numSet.size(), sumGoal)
    // Lacks of maxSubset validation
    private boolean isSubsetSum(ArrayList<Integer> set, int n, int sum) {
        if (sum == 0)  {
            // Is a solution, store it
            return true;
        }
        if (n == 0 && sum != 0 {
             // No solution
             return false;   
        }
        
            // Last element is greater than the sum, ignore it
            if (set.get(n-1) > sum) {
                return isSubsetSum(set, n-1, sum);   
            }
            
            return isSubsetSum(set, n-1, sum) || isSubsetSum(set, n-1, sum-set.get(n-1));
    }
    
    private void storeSolution(ArrayList<Integer> xs) {
        results.add(xs.stream().mapToInt(i -> i).toArray());
    }
    
    public void printSolutions() {
        for (int[] resultSet : results) {
            for (int result : resultSet) {
                System.out.print("" + result + " ");
            }
            System.out.println(" ");
        }
    }
    
    public int getSumGoal() {
        return sumGoal;
    }

    public void setSumGoal(int sumGoal) {
        this.sumGoal = sumGoal;
    }

    public int getMaxSubset() {
        return maxSubset;
    }

    public void setMaxSubset(int maxSubset) {
        this.maxSubset = maxSubset;
    }
    
}
