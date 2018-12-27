import java.util.*;
/**
 * Term Project CPSC 6106
 * Lock Box Manager
 * The main controlling class for the project
 *
 * @author Jill Eliceiri
 * @author Sonia Coile
 */

public class LockBoxManager {

    //instance variables
    private List <Person> persons;
    char userChoice;
    static Scanner scnr = new Scanner(System.in);

    //accessor
    private List<Person> getPersons() {
        return persons;
    }

    /**
     *  This method will call other methods to perform the following:
     *  populate the application with starter data and
     *  print the user option menu.
     */

    public void run(){
        populateProgramWithData();
        System.out.println("Welcome to the digital gun lock box manager!");
        printMenu();
    }

    /**
     * This method will print a menu of options for the user to choose from.
     * It will then perform one of the following depending on user choice:
     * quit the program, add a new user, display an individual status,
     * edit an existing individual, or view all individuals.
     *
     * The Big O performance of the ArrayList get(int index) is O(1).
     * This is one of the main benefits of using ArrayList
     */

    public void printMenu() {
        boolean isMenuOn = true;
        do {
            System.out.println();
            System.out.println("What would you like to do? Please choose from an option below: \n");
            System.out.println("MENU");
            System.out.println();
            System.out.println("a - add a new person");
            System.out.println("d - display individual status");
            System.out.println("e - edit an existing individual");
            System.out.println("v - view all individuals");
            System.out.println("q - quit");
            System.out.println();
            System.out.println("Enter an option: ");
            char userChoice = scnr.next().charAt(0);
            if (userChoice == 'q') {
                isMenuOn = false;
                break;
                //return;
            }
            while (userChoice != 'q' && userChoice != 'a' && userChoice != 'd' && userChoice != 'e' && userChoice != 'v') {
                System.out.println("Choose an option: ");
                userChoice = scnr.next().charAt(0);
                if (userChoice == 'q') {
                    isMenuOn = false;
                    return;
                }
            }
            switch (userChoice) {
                case 'a': {
                    System.out.println();
                    System.out.println("ADD A NEW PERSON\n");
                    System.out.println("Enter the name: (i.e. \"John Smith\")");
                    scnr.nextLine();

                    String name = scnr.nextLine();
                    System.out.println("Enter the age: (i.e. \"25\")");
                    int age = scnr.nextInt();
                    addPerson(name, age);
                    break;
                }
                case 'd': {
                    System.out.println();
                    System.out.println("DISPLAY INDIVIDUAL STATUS");
                    scnr.nextLine();

                    System.out.println("Enter the person's id: ");
                    int index = scnr.nextInt();

                    if (index > persons.size()) {
                        System.out.println("The person you entered was not found.");
                    } else {
                        persons.get(index).displayStatus();
                    }
                    break;
                }
                case 'e': {
                    System.out.println("EDIT AN EXISTING INDIVIDUAL");
                    scnr.nextLine();
                    System.out.println("Enter the person's id: ");
                    int index = scnr.nextInt();
                    scnr.nextLine();
                    System.out.println("Does the person have a violent criminal history? ('yes' or 'no')");
                    String hasCriminalHistory = scnr.nextLine();

                    System.out.println("Is the person a danger to self or others? ('yes' or 'no')");
                    String isDanger = scnr.nextLine();

                    System.out.println("Is this person capable of handling their own affairs? ('yes' or 'no')");
                    String affairs = scnr.nextLine();

                    System.out.println("Has this person passed the gun safety class for their state? ('yes' or 'no')");
                    String gunClass = scnr.nextLine();

                    System.out.println("What is their gun class certification number? ('123')");
                    int certNumber = scnr.nextInt();

                    editPerson(index, hasCriminalHistory, isDanger, affairs, gunClass, certNumber);

                    break;
                }
                case 'v': {
                    System.out.println();
                    System.out.println("VIEW ALL INDIVIDUALS");
                    displayAll();
                    break;
                }
            }
        } while (isMenuOn);
    }
    /**
     * This method will create a new person and add it to the persons ArrayList.
     * Big O performance of the ArrayList add function: O(1)
     *
     * @param name the name of the person to be added
     * @param age the age of the person to be added
     */

    public void addPerson(String name, int age){
        Person person = new Connecticut(name, age);
        persons.add(person);
    }

    /**
     * This method will populate the program with initial data.
     * First, it instantiates an ArrayList of persons.
     * Then it creates three objects and adds it to the persons list.
     * Big O performance of the ArrayList add function: O(1)
     */

    public void populateProgramWithData(){
        //instantiate new persons object
        persons = new ArrayList<Person>();

        //create three objects of type Connecticut
        Person person1 = new Connecticut("Brian Jones", 17);
        Person person2 = new Connecticut("Kevin Anderson", 42);
        Person person3 = new Connecticut("Cherise Manford", 29);

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
    }

    /**
     * This method displays the status of all individuals in the application.
     * Polymorphism is involved in this method, as the correct method is invoked for each object type
     */

    public void displayAll(){

        for (int i = 0; i < persons.size(); i ++) {
            System.out.println();
            System.out.print("ID: " + i + ", ");
            persons.get(i).displayStatus();
        }
    }

    /**
     * This method first checks if the person at specified index is within the application
     * If so, it calls the editBackground method on the specified person type
     *
     * @param index the index to get
     * @param hasCriminalHistory the criminal history
     * @param isDanger whether the person is dangerous
     * @param affairs persons ability to handle affairs
     * @param gunClass whether the person has passed the gun safety class
     */

    public void editPerson(int index, String hasCriminalHistory, String isDanger, String affairs, String gunClass, int certNumber){

        if (index > persons.size()) {
            System.out.println("The person you entered was not found.");
        } else {
                persons.get(index).editBackground(hasCriminalHistory, isDanger, affairs, gunClass, certNumber);
        }
    }
}

