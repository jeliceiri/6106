/**
 *  Connecticut Class
 *  This class extends the Person class and implements the IPerson interface
 *  It represents a particular state's (Connecticut) additional laws and regulations, which may be more
 *  stringent than the federal regulations. This Class inherits class members and methods from the Person class.
 *
 * @author Jill Eliceiri
 * @author Sonia Coile
 */

public class Connecticut extends Person implements IPerson {


    //this state has a different age (more stringent) required to buy guns than the federal law
    private int age;

    //this particular stat has a high standards gun safety class and certification number
    private String connecticutGunSafetyClass;
    private int certificationNumber;

    //accessors and mutators
    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    private int getCertificationNumber() {
        return certificationNumber;
    }

    private void setCertificationNumber(int certificationNumber) {
        this.certificationNumber = certificationNumber;
    }

    private String getConnecticutGunSafetyClass() {
        return connecticutGunSafetyClass;
    }

    private void setConnecticutGunSafetyClass(String connecticutGunSafetyClass) {
        this.connecticutGunSafetyClass = connecticutGunSafetyClass;
    }

    //constructor with two paramaters
    public Connecticut(String name, int age) {
        super(name);
        this.age = age;
        this.setConnecticutGunSafetyClass("no");
        this.setCertificationNumber(0);
    }
    /**
     * This method displays the status of an individual from the state of Connecticut
     */

    public void displayStatus(){
        System.out.print("Name: " + this.getName());
        if (this.isLockBoxOpen()){
            System.out.println(" - lock box status is: unlocked");
        } else {
            System.out.println(" - lock box status is: locked");
        }
        System.out.print("Age: " + this.getAge() + ", ");
        System.out.print(this.getBackground().toString());
        if (this.getConnecticutGunSafetyClass().equals("no")){
            System.out.print("No, has not passed the Connecticut gun safety class. ");
        } else {
            System.out.print("Yes, has passed the Connecticut gun safety class. ");
        }
        if (this.getCertificationNumber() != 0){
            System.out.print("The gun class certification number is: " + this.getCertificationNumber());
        } else {
            System.out.print("There is not a gun class certification number on record.");
        }

        System.out.println();
    }
    /**
     * The method edits the background check information for the specified person.
     *
     * @param hasCriminalHistory whether the person has a criminal history
     * @param isDanger whether the person is dangerous
     * @param affairs   whether the person can handle their own affairs
     * @param connecticutGunSafetyClass  whether the person has passed the state1 gun safety class
     * @param certificationNumber the individuals gun certification number
     */
    public void editBackground(String hasCriminalHistory, String isDanger, String affairs, String connecticutGunSafetyClass, int certificationNumber){
        this.getBackground().setCriminalHistory(hasCriminalHistory);
        this.getBackground().setDangerToSelfOrOthers(isDanger);
        this.getBackground().setCanHandleOwnAffairs(affairs);
        this.setConnecticutGunSafetyClass(connecticutGunSafetyClass);
        this.setCertificationNumber(certificationNumber);
        this.processStatus();
    }
    /**
     * The method checks to see if an individual is over the age of 21
     * @param age the age to be checked
     * @return boolean whether the person is older than 21
     */
    public boolean checkAge(int age){
        if (this.getAge() > 21){
            return true;
        }
        return false;
    }
    /**
     * The method processes an individual's status from Connecticut.
     * If all conditions are met, then an individual's digital gun lock box is opened.
     * (i.e. a code is sent to the gun owner, where they can successfully open their physical locked gun box)
     * In this case, the Connecticut standards are more stringent than the federal standards.
     */
    public void processStatus(){
        if (this.getBackground().getCanHandleOwnAffairs().equals("yes") &&
                this.getBackground().getDangerToSelfOrOthers().equals("no") &&
                this.getBackground().getCriminalHistory().equals("no") &&
                checkAge(this.getAge()) &&
                this.getConnecticutGunSafetyClass().equals("yes") &&
                this.getCertificationNumber() != 0) {
                    this.setLockBox(true);
        }
    }
}
