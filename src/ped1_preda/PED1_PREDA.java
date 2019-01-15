package ped1_preda;

/**
 * @author Miquel Ginés Borràs
 */
public class PED1_PREDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new PED1_PREDA(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método principal, realiza las llamadas a las clases auxiliares para el correcto funcionamiento
     * del proyecto
     *
     * @param args
     * @throws Exception
     */
    public PED1_PREDA(String[] args) throws Exception {

        System.out.println("Iniciando aplicación...");
        /**
         * Llama al validador de argumentos de entrada pasando la lista de argumentos a ser tratados
         */
        ArgsHelper params = new ArgsHelper(args);

        /**
         * Crea el gestor de entrada/salida de datos
         */
        IOHelper ioHelper = new IOHelper();

        /**
         * Si se ha especificado el argumento de mostrar ayuda, la muestra
         */
        if (params.showHelp()) {
            params.printHelp();
        } else {
            /**
             * Gestiona la entrada de datos mediante fichero o consola
             */
            SubsetSum subsetSum;
            if (params.getFileIn() != null) {
                subsetSum = ioHelper.readFromFile(params.getFileIn());
            } else {
                subsetSum = ioHelper.readFromKeyboard();
            }

            /**
             * Asigna la salida o no de traza
             */
            subsetSum.setTrace(params.showTrace());

            if (subsetSum != null) {
                /**
                 * Llama al método de computación del algoritmo principal
                 */
                subsetSum.computeSubsetSum();

                /**
                 * Muestra el resultado de la ejecución en fichero o consola
                 */
                if (params.getFileOut() != null) {
                    ioHelper.printResultsToFile(subsetSum, params.getFileOut());
                } else {
                    ioHelper.printResultsToConsole(subsetSum);
                }
            }


            System.out.println("\n\rFinalizando aplicación...");
        }


    }

}
