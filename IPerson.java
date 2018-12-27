/**
 *  IPerson Interface
 *  This interface is named IPerson and is implemented by the Connecticut and Person class.
 *  It has three methods.
 *
 *  An interface was chosen to provide a list of functions that forces classes which implement it to use
 *
 * @author Jill Eliceiri
 * @author Sonia Coile
 */

public interface IPerson {

    /**
     * The method to display the status of a person
     */
    void displayStatus();

    /**
     * The method to check the age of a person
     */
    boolean checkAge(int age);

    /**
     * The method to process the status of a person
     */
    void processStatus();

}
