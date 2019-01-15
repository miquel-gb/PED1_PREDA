package ped1_preda;

import java.io.File;

/**
 *
 * @author Miquel Ginés Borràs  
 */
public class ArgsHelper {

    /**
     * Flag para mostrar o no la traza
     */
    private boolean trace = false;
    /**
     * Flag para mostrar o no la ayuda
     */
    private boolean help = false;
    /**
     * Ficheros de entrada y salida (null si se usa la consola)
     */
    private File fileIn = null, fileOut = null;

    /**
     * Constructor principal, recibe los argumentos y llama al método validador
     *
     * @param args Listado de argumentos
     * @throws Exception Posibles errores en los argumentos
     */
    public ArgsHelper(String[] args) throws Exception {
        validateArgs(args);
    }

    /**
     * Realiza la validación de la lista de argumentos
     *
     * @param args Listado de argumentos
     * @throws Exception Posibles errores en los argumentos
     */
    private void validateArgs(String[] args) throws Exception {
        if (args.length > 4) {
            throw new Exception("La llamada acepta sólo de 0 a 4 parámetros.");
        } else if (args.length > 0){
            for (String arg : args) {
                if (arg.equals("-t")) {
                    trace = true;
                } else if (arg.equals("-h")) {
                    help = true;
                } else if (fileIn == null ) {
                    fileIn = new File(arg);
                } else {
                    fileOut = new File(arg);
                }
            }
            if (fileIn != null && !fileIn.exists()) {
                System.out.println("No se ha encontrado el fichero, se procederá a la entrada de datos por consola.");
                fileIn = null;
            }
            if (fileOut != null && fileOut.exists()) {
                throw new Exception("El fichero de salida ya existe, eliminalo para continuar.");
            }
        }
    }

    /**
     * Muestra la ayuda por consola
     */
    public void printHelp() {
        System.out.println("\r\nsuma [-t][-h][fichero_entrada] [fichero_salida]");
        System.out.println("\t-t\tTraza la selección de subconjuntos ");
        System.out.println("\t-h\tMuestra esta ayuda");
        System.out.println("\tfichero_entrada\tNombre del fichero de entrada");
        System.out.println("\tfichero_salida\tNombre del fichero de salida");
    }

    public boolean showTrace() {
        return trace;
    }

    public boolean showHelp() {
        return help;
    }

    public File getFileIn() {
        return fileIn;
    }

    public File getFileOut() {
        return fileOut;
    }
}
