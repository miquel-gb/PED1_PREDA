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
    
    private String fileIn = null, fileOut = null;
    
    public ArgsHelper(String[] args) throws NullPointerException {
        validateArgs(args);
    }
    
    private void validateArgs(String[] args) throws NullPointerException {
        if (args.length > 4) {
            throw new NullPointerException();
        } else if (args.length > 0){
            if (Arrays.asList(args).contains("-t")) {
                trace = true;
            }
            if (Arrays.asList(args).contains("-h")) {
                help = true;
            }
            File f = new File("");
            f.exists();
        }
    }

    public boolean showTrace() {
        return trace;
    }

    public boolean isHelp() {
        return help;
    }

    public String getFileIn() {
        return fileIn;
    }

    public String getFileOut() {
        return fileOut;
    }
}
