package ped1_preda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Miquel Ginés Borràs
 */
public class IOHelper {

    public IOHelper() {
    }

    public SubsetSum readFromFile() {
        return null;
    }

    public SubsetSum readFromKeyboard() {
        List<Integer> numSet = null;
        int sumGoal = 0, maxSubset = 0;
        String input = readLineFromConsole("Introduce el conjunto principal de números (enteros, separados por espacio):");
        try {
            // Lee el conjunto principal de números
            numSet = Arrays
                    .stream(
                            Arrays.stream(input.split(" "))
                                    .mapToInt(Integer::parseInt).toArray()
                    ).boxed()
                    .collect(Collectors.toList());
            
            // Lee la suma objetivo a alcanzas por los subconjuntos
            input = readLineFromConsole("Introduce la suma objetivo a alcanzar con los subconjuntos (entero):");
            sumGoal = Integer.parseInt(input);
            
            // Lee el máximo de números por subconjunto
            input = readLineFromConsole("Introduce el límite de números por subconjunto (entero):");
            maxSubset = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Se ha introducido algo que no era un número, se parará la ejecución
            System.out.println("ERROR: Se ha introducido algún carácter no válido.");
            return null;
        }
        return new SubsetSum(numSet, sumGoal, maxSubset);
    }

    public void printResultsToFile(SubsetSum subsetSum) {

    }

    public void printResultsToConsole(SubsetSum subsetSum) {
        System.out.println("\r\n---------------------------------------------------------------------------");
        /*System.out.println("\r\nConjunto original: " + subsetSum.getNumSet().toString().replaceAll(",", ""));
        System.out.println("Suma objetivo: " + subsetSum.getSumGoal());
        System.out.println("Máximo de números por subconjunto solución: " + subsetSum.getMaxSubset());
        System.out.println("\n\rSubconjuntos solución:");*/
        subsetSum.getResults().forEach(
                (result) -> {
                    for (int num : result) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
        );
    }

    private String readLineFromConsole(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\r" + msg);
        return sc.nextLine().trim().replaceAll(" +", " ");
    }

}
