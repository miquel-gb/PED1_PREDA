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

    public void printResultsToFile() {

    }

    public void printResultsToConsole() {

    }

    private String readLineFromConsole(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\r" + msg);
        return sc.nextLine().trim().replaceAll(" +", " ");
    }

}
