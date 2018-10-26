/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ped1_preda;

/**
 *
 * @author gines
 */
public class ArgsHelper {
    
    private boolean trace;
    
    private boolean help;
    
    private String fileIn, fileOut;
    
    public ArgsHelper(String[] args) {
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
