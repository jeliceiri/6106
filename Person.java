/**
 *  Person Class
 *  This is an abstract base class for a Person and implements the IPerson interface.
 *  Because it is abstract, it can not be instantiated.
 *
 * @author Jill Eliceiri
 * @author Sonia Coile
 */

public abstract class Person implements IPerson {

    //instance variables
    private String name;
    private int age;
    private BackgroundCheck background;
    private boolean isLockBoxOpen;

    //accessors and mutators
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BackgroundCheck getBackground() {
        return background;
    }

    public void setBackground(BackgroundCheck background) {
        this.background = background;
    }

    public boolean isLockBoxOpen() {
        return isLockBoxOpen;
    }

    public void setLockBox(boolean lockBox) {
        isLockBoxOpen = lockBox;
    }

    //default constructor
    public Person(){
        this.name = "";
        this.age = 0;
        this.background = new BackgroundCheck();
        this.isLockBoxOpen = false;
    }
    //constructor with two parameters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.background = new BackgroundCheck();
        this.isLockBoxOpen = false;
    }
    //constructor with one parameter
    public Person(String name) {
        this.setName(name);
        this.background = new BackgroundCheck();
        this.isLockBoxOpen = false;
    }
    /**
     * This method displays the status of an individual.
     * It checks to see if the lock box is open for the specified person.
     * It also displays the name, age, and background check information.
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
        System.out.println();
    }
    /**
     * The method edits the background check information for the specified person.
     *
     * @param hasCriminalHistory whether the person has a criminal history
     * @param isDanger whether the person is dangerous
     * @param affairs   whether the person can handle their own affairs
     */
    public void editBackground(String hasCriminalHistory, String isDanger, String affairs, String gunClass, int cert){
       this.getBackground().setCriminalHistory(hasCriminalHistory);
       this.getBackground().setDangerToSelfOrOthers(isDanger);
       this.getBackground().setCanHandleOwnAffairs(affairs);
       this.processStatus();
    }
    /**
     * The method processes an individual's status.
     * If all conditions are met, then the digital gun lockbox is opened.
     * (i.e. a code is sent to the gun owner, where they can successfully open their physical locked gun box)
     */
    public void processStatus(){
        if (this.getBackground().getCanHandleOwnAffairs().equals("yes") &&
                this.getBackground().getDangerToSelfOrOthers().equals("no") &&
                this.getBackground().getCriminalHistory().equals("no") &&
                (this.getAge() > 18)) {
            this.setLockBox(true);
        }
    }
    /**
     * The method checks to see if an individual is over the age of 18
     * @param age the age to be checked
     * @return boolean whether the person is older than 18
     */
    public boolean checkAge(int age){
        if (this.getAge() > 18){
            return true;
        }
        return false;
    }
}
