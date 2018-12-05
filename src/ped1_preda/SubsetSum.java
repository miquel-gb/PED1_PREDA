package ped1_preda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Miquel Ginés Borràs
 */
public class SubsetSum {
    
    // Conjunto de números      
    private ArrayList<Integer> numSet;

    private ArrayList<Boolean> boolSet = new ArrayList<>();
    // Suma objetivo para los subconjuntos
    private int sumGoal;
    // Máximo de números por subconjunto
    private int maxSubset;
    // Subconjuntos que cumplen los requisitos para ser solución
    private ArrayList<int[]> results = new ArrayList<>();
    
    private boolean trace = false;

    /**
     * Constructor principal
     * 
     * @param numSet Conjunto de números
     * @param sumGoal Suma objetivo para los subconjuntos
     * @param maxSubset Máximo de números por subconjunto
     */
    public SubsetSum(ArrayList<Integer> numSet, int sumGoal, int maxSubset) {
        this.numSet = numSet;
        this.sumGoal = sumGoal;
        this.maxSubset = maxSubset;
        for (int i = 0; i < numSet.size(); i++) {
            this.boolSet.add(false);
        }
    }
    
    public SubsetSum(ArrayList<Integer> numSet, int sumGoal, int maxSubset, boolean trace) {
        this.numSet = numSet;
        this.sumGoal = sumGoal;
        this.maxSubset = maxSubset;
        this.trace = trace;
    }

    /**
     * Método que inicia la búsqueda mediante backtracking recursivo de los
     * subconjuntos que cumplen los requisitos
     */
    public void computeSubsetSum() {
        compute(numSet, 0, boolSet, 0, 0);
    }

    /**
     * Realiza la búsqueda mediante backtracking recursivo de los
     * subconjuntos que cumplen los requisitos
     *
     * @param numSet
     * @param n
     * @param boolSet
     * @param maxSubset
     * @param sum
     */
    private void compute(ArrayList<Integer> numSet, int n, ArrayList<Boolean> boolSet, int maxSubset, int sum) {
        if (maxSubset == this.maxSubset) {
            if (sum == this.sumGoal) {
                storeSolution(boolSet);
            }
        } else {
            if (n < numSet.size()) {
                boolSet.set(n, false);
                compute(numSet, n + 1, boolSet, maxSubset, sum);
                if (sum + numSet.get(n) <= this.sumGoal) {
                    boolSet.set(n, true);
                    sum += numSet.get(n);
                    maxSubset++;
                    compute(numSet, n + 1, boolSet, maxSubset, sum);
                }
            }
        }
    }
    
    /**
     * Guarda como array de enteros el subconjunto recibido por parámetros
     */
    private void storeSolution(ArrayList<Boolean> boolSet) {
//        System.out.print("We got a solution --> ");
//        System.out.println(boolSet.toString());
        ArrayList<Integer> result = new ArrayList<>();
        int cont = 0;
        for (int i = 0; i < boolSet.size() && cont < maxSubset; i++) {
            if (boolSet.get(i)) {
                result.add(numSet.get(i));
                cont++;
            }
        }
        results.add(result.stream().mapToInt(i -> i).toArray());
    }
    
    public void printSolutions() {
        for (int[] resultSet : results) {
            for (int result : resultSet) {
                System.out.print("" + result + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Getter del conjunto principal de números
     * 
     * @return Conjunto principal de números
     */
    public ArrayList<Integer> getNumSet() {
        return numSet;
    }
    
    /**
     * Getter de la suma objetivo para el subconjunto
     * 
     * @return Suma objetivo para el subconjunto
     */
    public int getSumGoal() {
        return sumGoal;
    }

    /**
     * Getter del límite de números por subconjunto
     * 
     * @return Máximo de números por subconjunto
     */
    public int getMaxSubset() {
        return maxSubset;
    }

    /**
     * Getter de la lista de subconjuntos solución
     * 
     * @return Lista de subconjuntos solución
     */
    public ArrayList<int[]> getResults() {
        return results;
    }

    /**
     * Setter del boolean para mostrar o no mostrar los pasos que realiza
     * el algoritmo
     *
     * @param trace Valor del trace
     */
    public void setTrace(boolean trace) {
        this.trace = trace;
    }

    @Override
    public String toString() {
        return "SubsetSum{" +
                "numSet=" + numSet +
                '}';
    }
}
