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

    /**
     * Lee los datos desde un fichero
     *
     * @param file Fichero de entrada
     * @return SubsetSum con los datos leídos
     */
    public SubsetSum readFromFile(File file) {
        System.out.println("\r\n---------------------------------------------------------------------------");
        Set<Integer> numSet = null;
        int sumGoal = 0, maxSubset = 0;
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String currentLine;
            if (((currentLine = br.readLine()) != null)) {
                System.out.println("\r\nConjunto original: " + currentLine);
                numSet = readNumSet(currentLine.trim());
            }
            if (((currentLine = br.readLine()) != null)) {
                System.out.println("Suma objetivo: " + currentLine);
                sumGoal = Integer.parseInt(currentLine.trim());
            }
            if (((currentLine = br.readLine()) != null)) {
                System.out.println("Números por subconjunto solución: " + currentLine);
                maxSubset = Integer.parseInt(currentLine.trim());
            }

            br.close();
            fr.close();
            return  new SubsetSum(new ArrayList<Integer>(numSet), sumGoal, maxSubset);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Convierte un conjunto de números en forma de string en un objeto tipo Set
     *
     * @param numSetString Lista de números
     * @return Set de números
     * @throws Exception
     */
    private Set readNumSet(String numSetString) throws Exception {
        Set<Integer> numSet = new HashSet<Integer>();
        for (String s : numSetString.split(" ")) {
            if (!numSet.add(Integer.parseInt(s))) {
                throw new Exception("Número duplicado en el conjunto de entrada");
            }
        }
        return numSet;
    }

    /**
     * Lee los datos desde la consola
     *
     * @return SubsetSum con los datos leídos
     */
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

    /**
     * Imprime los resultados en un fichero
     *
     * @param subsetSum SubsetSum con los resultados
     * @param file Fichero donde escribir los resultados
     */
    public void printResultsToFile(SubsetSum subsetSum, File file) {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false)));
            String printString = "";
            if (subsetSum.getResults().size() == 0) {
                printString = "No existe solución";
            } else {
                for (int[] result : subsetSum.getResults()) {
                    for (int num : result) {
                        printString += num + " ";
                    }
                    printString += "\r\n";
                }
            }
            writer.write(printString);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Imprime los resultados por consola
     *
     * @param subsetSum SubsetSum con los resultados
     */
    public void printResultsToConsole(SubsetSum subsetSum) {
        if (subsetSum.getResults().size() == 0) {
            System.out.println("No existe solución");
        } else {
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
    }

    /**
     * Lee una línea de texto entrada por teclado por consola
     *
     * @param msg Mensaje a mostrar antes de leer
     * @return Cadena de texto leída
     */
    private String readLineFromConsole(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\r" + msg);
        return sc.nextLine().trim().replaceAll(" +", " ");
    }

}
