package ped1_preda;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author Miquel Ginés Borràs  
 */
public class ArgsHelper {
    
    private boolean trace = false;
    
    private boolean help = false;
    
    private File fileIn = null, fileOut = null;
    
    public ArgsHelper(String[] args) throws Exception {
        validateArgs(args);
    }
    
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
            if (!fileIn.exists()) {
                System.out.println("No se ha encontrado el fichero, se procederá a la entrada de datos por consola.");
                fileIn = null;
            }
            if (fileOut != null && fileOut.exists()) {
                throw new Exception("El fichero de salida ya existe, eliminalo para continuar.");
            }
        }
    }

    public boolean showTrace() {
        return trace;
    }

    public boolean isHelp() {
        return help;
    }

    public File getFileIn() {
        return fileIn;
    }

    public File getFileOut() {
        return fileOut;
    }
}
