package tpup;

import java.util.Random;
import org.jibble.pircbot.*;
/**
 *
 * @author petri
 */
public class TPuppy extends PircBot{
    String owner;
    public TPuppy(){
        this.setName("T-Pup");
        this.owner = "Spinic";
    }
    public void onMessage(String channel, String sender,
        String login, String hostname, String message) {
        String messageStripped = Colors.removeFormattingAndColors(message);
        String messageLower = messageStripped.toLowerCase();
        
        if (messageLower.contains(this.getName().toLowerCase()) && messageLower.contains("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }else if (messageLower.contains(this.getName().toLowerCase()) && messageLower.contains("love you") 
                && !messageLower.contains("don't") && !messageLower.contains("do not") && 
                !messageLower.contains("nobody")){
            sendMessage(channel, "Aww, I love you too, " + sender);
            Random rand = new Random();
            int cute = rand.nextInt(4) + 1;
            String cuteString = null;
            switch (cute) {
                case 1 : cuteString = "nuzzles";
                    break;
                case 2 : cuteString = "cuddles";
                    break;
                case 3 : cuteString = "licks";
                    break;
                case 4 : cuteString = "boops";
                    break;              
            }
            sendAction(channel, cuteString + " " + sender);
        }else if (messageLower.contains(this.getName().toLowerCase()) && messageLower.contains("commands")) {
            sendMessage(channel, "Arf! Arf! Oh boy, "+sender+", I do a bunch of "
                    + "cool stuff. You can ask me what the time is and give me love. "
                    + "TODO: ADD MORE FUNCTIONALITY");
        }else if (messageLower.contains(this.getName().toLowerCase()) && (messageLower.contains("created") || messageLower.contains("creator"))){
            if (sender.equalsIgnoreCase("Spinic")){
                sendMessage(channel, sender + ": You did, silly!");
            }else{
                sendMessage(channel, sender + ": I was created by Petri Trebilcock"
                        + " for no reason at all other than to kill time."
                        + " I am based off of the PircBot Java Framework created"
                        + " by Paul Mutton (http://jibble.org/) and used under"
                        + " the GNU General Public License. My source code is"
                        + " available here: https://github.com/petri152/T-Pup"
                        + " Thanks for asking! ^.^");
            }
        }else if (messageLower.contains(this.getName().toLowerCase()) && messageLower.contains("quit") && sender.equalsIgnoreCase(this.owner)){
            this.quitServer("Arf! Arf!");
            System.exit(0);
        }
        
    }
}
 