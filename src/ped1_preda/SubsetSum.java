package ped1_preda;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Miquel Ginés Borràs
 */
public class SubsetSum {
    
    // Conjunto de números      
    private Set<Integer> numSet;
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
    public SubsetSum(Set<Integer> numSet, int sumGoal, int maxSubset) {
        this.numSet = numSet;
        this.sumGoal = sumGoal;
        this.maxSubset = maxSubset;
    }
    
    public SubsetSum(Set<Integer> numSet, int sumGoal, int maxSubset, boolean trace) {
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
        compute(sumGoal, new ArrayList<Integer>(), numSet, 0);
    }
    
    /**
     * Realiza la búsqueda mediante backtracking recursivo de los
     * subconjuntos que cumplen los requisitos
     * 
     * @param n
     * @param xs
     * @param array
     * @param i 
     */
    private void compute(int n, ArrayList<Integer> xs, Set<Integer> array, int i) {
//        if (trace && xs.size() > 0) {
//            System.out.println("Comprobando subconjunto: " + xs);
//        }
//        if (n == 0 && xs.size() <= maxSubset) {
//            storeSolution(xs);
//            return;
//        }
//
//        if (n < 0 || i >= array.size() || xs.size() > maxSubset) {
//            if(trace && xs.size() > 0) {
//                System.out.println("El subconjunto " + xs + " no es una solución válida. Volviendo atrás.");
//            }
//            return;
//        }
//
//        xs.add(array.get(i));
//
//        compute(n - array.get(i), xs, array, i + 1);
//
//        xs.remove(xs.size() - 1);
//
//        compute(n, xs, array, i + 1);
    }
    
    /**
     * Guarda como array de enteros el subconjunto recibido por parámetros
     * 
     * @param xs Subconjunto de números a guardar como solución
     */
    private void storeSolution(ArrayList<Integer> xs) {
        if (trace) {
            System.out.println(" --- Hallado subconjunto solución: " + xs);
        }
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

    /**
     * Getter del conjunto principal de números
     * 
     * @return Conjunto principal de números
     */
    public Set<Integer> getNumSet() {
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
