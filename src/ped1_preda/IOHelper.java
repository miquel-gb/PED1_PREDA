package ped1_preda;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Miquel Ginés Borràs
 */
public class IOHelper {

    public IOHelper() {
    }

    public SubsetSum readFromFile(File file) {
        Set<Integer> numSet = null;
        int sumGoal = 0, maxSubset = 0;
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String currentLine;
            if (((currentLine = br.readLine()) != null)) {
                numSet = readNumSet(currentLine);
            }
            if (((currentLine = br.readLine()) != null)) {
                sumGoal = Integer.parseInt(currentLine);
            }
            if (((currentLine = br.readLine()) != null)) {
                maxSubset = Integer.parseInt(currentLine);
            }

            br.close();
            fr.close();
            return  new SubsetSum(new ArrayList<Integer>(numSet), sumGoal, maxSubset);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("ERROR: Se ha introducido un valor duplicado en el conjunto de números de entrada.");
            return null;
        }
    }

    private Set readNumSet(String numSetString) throws Exception {
        Set<Integer> numSet = new HashSet<Integer>();
        for (String s : numSetString.split(" ")) {
            if (!numSet.add(Integer.parseInt(s))) {
                throw new Exception("Duplicated entry");
            }
        }
        return numSet;
    }

    public SubsetSum readFromKeyboard() {
        Set<Integer> numSet = null;
        int sumGoal = 0, maxSubset = 0;
        String input = readLineFromConsole("Introduce el conjunto principal de números (enteros, separados por espacio):");
        try {
            // Lee el conjunto principal de números
            numSet = readNumSet(input);

            // Lee la suma objetivo a alcanzas por los subconjuntos
            input = readLineFromConsole("Introduce la suma objetivo a alcanzar con los subconjuntos (entero):");
            sumGoal = Integer.parseInt(input);

            // Lee el máximo de números por subconjunto
            input = readLineFromConsole("Introduce el límite de números por subconjunto (entero):");
            maxSubset = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // Se ha introducido algo que no era un número, se parará la ejecución
            System.err.println("ERROR: Se ha introducido algún carácter no válido.");
            return null;
        } catch (Exception e) {
            System.err.println("ERROR: Se ha introducido un valor duplicado en el conjunto de números de entrada.");
            return null;
        }
        return new SubsetSum(new ArrayList<Integer>(numSet), sumGoal, maxSubset);
    }

    public void printResultsToFile(SubsetSum subsetSum, File file) {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
            String printString = "";
            for (int[] result : subsetSum.getResults()) {
                for (int num : result) {
                    printString += num + " ";
                }
                printString += "\r\n";
            }
            writer.write(printString);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printResultsToConsole(SubsetSum subsetSum) {
        System.out.println("\r\n---------------------------------------------------------------------------");
        System.out.println("\r\nConjunto original: " + subsetSum.getNumSet().toString());
        System.out.println("Suma objetivo: " + subsetSum.getSumGoal());
        System.out.println("Números por subconjunto solución: " + subsetSum.getMaxSubset());
        System.out.println("\n\rSubconjuntos solución:");
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
