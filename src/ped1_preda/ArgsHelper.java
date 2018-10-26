package ped1_preda;

/**
 *
 * @author Miquel Ginés Borràs  
 */
public class ArgsHelper {
    
    private boolean trace;
    
    private boolean help;
    
    private String fileIn, fileOut;
    
    public ArgsHelper(String[] args) throws NullPointerException {
        validateArgs(args);
    }
    
    private void validateArgs(String[] args) throws NullPointerException {
        if (args.length > 4) {
            throw new NullPointerException();
        }
    }

    public boolean isTrace() {
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
