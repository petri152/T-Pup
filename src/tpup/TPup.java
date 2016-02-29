package tpup;

import org.jibble.pircbot.*;

/**
 *
 * @author petri
 */
public class TPup {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        TPuppy tpup = new TPuppy();
        tpup.setVerbose(true);
        tpup.connect("irc.randomsonicnet.org");
        tpup.joinChannel("#test");
    }
    
}
