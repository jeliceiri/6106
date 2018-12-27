/**
 * CPSC 6106
 * LockBoxDriver
 *
 * This project consists of a command line application which manages digital gun lock boxes for users.
 * It uses an example state, Connecticut, and illustrates that Connecticut has more stringent state gun
 * laws than federal regulations. The gun lock box will only unlock after specific measures are taken.
 *
 * @author Jill Eliceiri
 * @author Sonia Coile
 */
public class LockBoxDriver {

    /** Main method to run the Lock Box Manager application
     * The class will instantiate an instance of the project’s main processing class.
     * It will then call the main processing method of the main class.
     * @param args the command line arguments
     */

    public static void main (String [] args){
        LockBoxManager myManager = new LockBoxManager();
        myManager.run();
    }
}
