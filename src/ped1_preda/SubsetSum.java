package ped1_preda;

/**
 *
 * @author Miquel Ginés Borràs
 */
public class SubsetSum {
    
    private int[] numSet;
    
    private int sumGoal;
    
    private int maxSubset;
    
    public SubsetSum() {
        
    }

    public SubsetSum(int[] numSet, int sumGoal, int maxSubset) {
        this.numSet = numSet;
        this.sumGoal = sumGoal;
        this.maxSubset = maxSubset;
    }

    public int[][] computeSubsetSum() {
        return null;
    }
    
    public int[] getNumSet() {
        return numSet;
    }

    public void setNumSet(int[] numSet) {
        this.numSet = numSet;
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
