//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1907403
//Date: 07.08.2022





import java.io.*;

import java.util.Scanner;

public class FuelQueue {
    public static int total_income=0;

    public static Scanner input = new Scanner(System.in);
    public static void initialise(Passenger[][] array1) {  //Initialise an Array
        for (int pumpNumber = 1; pumpNumber < array1.length; pumpNumber++) {
            for (int pumpData = 1; pumpData < array1[pumpNumber].length; pumpData++) {
                array1[pumpNumber][pumpData].setFirstName("empty");
                array1[pumpNumber][pumpData].setSecondName("empty");
                array1[pumpNumber][pumpData].setVehicleNo("empty");
                array1[pumpNumber][pumpData].setNoLiters(0);

            }
        }
    }
    public static void ViewAllQueue(Passenger[][] array1) {  // View all fuel queus

        System.out.println("-------------------------------------");
        System.out.println("    View all Fuel Queue              ");
        System.out.println("------------------------------------");
        for (int pumpNumber = 1; pumpNumber < array1.length; pumpNumber++) {
            System.out.println("------------- Pump Number " + pumpNumber + "-------------");
            for (int CustomerNumber = 1; CustomerNumber < array1[pumpNumber].length; CustomerNumber++) {

                if (array1[pumpNumber][CustomerNumber].getFirstName().equals("empty")) {   // Check pump is empty or not
                    System.out.println("Customer " + CustomerNumber + " empty");
                } else {
                    System.out.println("Customer " + CustomerNumber + " details: ");
                    System.out.println("    * First name: " + array1[pumpNumber][CustomerNumber].getFirstName());
                    System.out.println("    * Last name: " + array1[pumpNumber][CustomerNumber].getSecondName());
                    System.out.println("    * vehicle no : " + array1[pumpNumber][CustomerNumber].getVehicleNo());
                    System.out.println("    * Liters : " + array1[pumpNumber][CustomerNumber].getNoliters());
                }
            }
            System.out.println();
        }
    }

    public static void ViewEmpQueue(Passenger[][] array1) {
        System.out.println("-------------------------------------");
        System.out.println("    View  Empty Queue              ");
        System.out.println("------------------------------------");
        for (int pumpNumber = 1; pumpNumber < array1.length; pumpNumber++) {
            System.out.println("------------- Pump Number " + pumpNumber + " -------------");
            for (int CustomerNumber = 1; CustomerNumber < array1[pumpNumber].length; CustomerNumber++) {
                if (array1[pumpNumber][CustomerNumber].getFirstName().equals("empty")) {   // Check  selected pump is empty
                    System.out.println("Customer " + CustomerNumber + " is empty");
                }
            }
            System.out.println();
        }
    }

    public static void AddCustomer(Passenger[][] array1) {    //Add passenger to cabin

        try {
            int pumpNumber = 0;
            int CustomerNumber = 0;

            while (true) {
                System.out.println();
                System.out.println("         Add passenger to a Pump");
                System.out.println("------------------------------------");
                System.out.println();
                System.out.print("Select Pump number 1 to 5 and 6 to go to main menu: ");
                pumpNumber = input.nextInt();
                if (pumpNumber == 6) {
                    Main.Mainmenu(array1);
                } else {
                    if (pumpNumber >= array1.length) {
                        System.err.println("Out of range\n");
                        AddCustomer(array1);
                        break;
                    }
                    for (; pumpNumber < array1.length; pumpNumber++) {
                        for (CustomerNumber = 1; CustomerNumber < array1[pumpNumber].length; CustomerNumber++) {
                            if (array1[pumpNumber][CustomerNumber].getFirstName().equals("empty")) {
                                if (array1[pumpNumber][CustomerNumber].getFirstName().equals("empty")) {   //Check selected pump is empty
                                    System.out.print("Enter first name: ");
                                    if (input.hasNext()) {
                                        String firstName = input.next().toUpperCase();
                                        array1[pumpNumber][CustomerNumber].setFirstName(firstName);
                                    } else {
                                        System.out.println("Please enter valid name as your first name");
                                    }
                                    System.out.print("Enter last name: ");
                                    if (input.hasNext()) {
                                        String lastName = input.next().toUpperCase();
                                        array1[pumpNumber][CustomerNumber].setSecondName(lastName);
                                    } else {
                                        System.out.println("Please enter valid name as your last name");
                                    }
                                    System.out.print("Enter Your vehicle Number: ");
                                    if (input.hasNext()) {
                                        String vehicleNo = input.next();
                                        array1[pumpNumber][CustomerNumber].setVehicleNo(vehicleNo);
                                    } else {
                                        System.out.println("Please enter valid number ");
                                    }
                                    System.out.println("Enter the number of liters you want?");
                                    if (input.hasNextInt()) {
                                        int Noliters = input.nextInt();
                                        array1[pumpNumber][CustomerNumber].setNoLiters(Noliters);
                                    } else {
                                        System.out.println("Please enter valid values");
                                    }

                                    System.out.println("\nPump number: " + pumpNumber + " Customer" + CustomerNumber + " details: ");
                                    System.out.println("1. First name: " + array1[pumpNumber][CustomerNumber].getFirstName());
                                    System.out.println("2. Last name: " + array1[pumpNumber][CustomerNumber].getSecondName());
                                    System.out.println("3. Vehicle number : " + array1[pumpNumber][CustomerNumber].getVehicleNo());
                                    System.out.println("3. No of liters you want : " + array1[pumpNumber][CustomerNumber].getNoliters());

                                } else {
                                    System.out.println();
                                }
                                AddCustomer(array1);
                            }
                        }
                        System.err.println("\nPump " + pumpNumber + " Customers capacity exceeded... Select a new pump");
                        System.err.println("Maximum pump capacity for each pump is only 6passengers\n\n");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Invalid Input\n");
            input.nextLine();
        }
    }
    public static void RemoveCustomer(Passenger[][] array1) { // Delete selected customer from Queue

        System.out.println("------------------------------------");
        System.out.println("   Remove customers    ");
        System.out.println("------------------------------------");
        System.out.print("Enter Customer's name for remove: ");
        String removeName = input.next().toUpperCase();     //Input passenger name and convert upper case
        boolean CustomerFound = false;
        for (int pumpNumber = 1; pumpNumber < array1.length; pumpNumber++) {
            for (int CustomerNumber = 1; CustomerNumber < array1[pumpNumber].length; CustomerNumber++) {
                if (array1[pumpNumber][CustomerNumber].getFirstName().equals(removeName)) {   //Check entered name is available in queue
                    array1[pumpNumber][CustomerNumber].setFirstName("empty");
                    System.out.println("Cabin " + pumpNumber + " Customer " + CustomerNumber + " : " + removeName + " removed successfully");
                    CustomerFound = true;
                    break;
                }

            }

        }
        if (!CustomerFound) {  //If user not available in pump
            System.out.println("There is no customer found with the name " + removeName);
        }

    }

    public static void ViewCustomerSort(Passenger[][] array1) {  //View Customers ordered alphabetically by name

        System.out.println("----------------------------------------");
        System.out.println("        Customers in alphabetical order");
        System.out.println("------------------------------------");
        // creating new array with first names form main 2d array
        String sortArr[] = new String[30];
        int pointer = 0;
        for (int pumpNumber = 1; pumpNumber < array1.length; pumpNumber++) {
            for (int CustomerNumber = 1; CustomerNumber < array1[pumpNumber].length; CustomerNumber++) {
                sortArr[pointer++] = array1[pumpNumber][CustomerNumber].getFirstName();
            }
        }
        // Sorting Starts Here
        String temp;
        for (int j = 0; j < sortArr.length; j++) {
            for (int i = j + 1; i < sortArr.length; i++) {
                // comparing adjacent strings
                if (sortArr[i].compareTo(sortArr[j]) < 0) {
                    temp = sortArr[j];
                    sortArr[j] = sortArr[i];
                    sortArr[i] = temp;
                }
            }
            if (!sortArr[j].equals("empty")) {
                System.out.println(sortArr[j]);
            }
        }
    }


    public static void StoreProgram(Passenger[][] array1) throws IOException { //Save array data to Demo.txt file

        FileWriter write = new FileWriter("Demo.txt");
        for (int pumpNumber = 1; pumpNumber < array1.length; pumpNumber++) {
            for (int CustomerNumber = 1; CustomerNumber < array1[pumpNumber].length; CustomerNumber++) {
                write.write("\n Customer " + CustomerNumber + "-" + "Full Name :  " + array1[pumpNumber][CustomerNumber].getFirstName() + "");
                write.write(array1[pumpNumber][CustomerNumber].getSecondName());
                write.write("\n Customer " + CustomerNumber + "-" + "Vehicle NO:" + array1[pumpNumber][CustomerNumber].getVehicleNo());
                write.write("\n Customer" + CustomerNumber + "-" + "Fuel:" + array1[pumpNumber][CustomerNumber].getVehicleNo() + "l");

            }
        }
        System.out.println();
        write.close();
        System.out.println("Program data saved successfully");
    }

    public static void LoadProgram() throws FileNotFoundException { // Load data
        File load = new File("Demo.txt");
        Scanner input = new Scanner(load);

        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }

    }


    public static int RemoveSerCustomer(Passenger[][] array1) { //Remove a served customer
        System.out.println("----------------------------------------------------------");
        System.out.println("Remove served customer");
        System.out.println("------------------------------------------------------");


        for (int pumpNumber = 1; pumpNumber < array1.length; pumpNumber++) {
            for (int CustomerNumber = 1; CustomerNumber < array1[pumpNumber].length; CustomerNumber++) {
                if (!array1[pumpNumber][CustomerNumber].getFirstName().equals("empty")) {
                    Main.totalfuel = Main.totalfuel - array1[pumpNumber][CustomerNumber].getNoliters();
                    total_income=total_income+array1[pumpNumber][CustomerNumber].getNoliters()*430;
                    array1[pumpNumber][CustomerNumber].setFirstName("empty");
                    array1[pumpNumber][CustomerNumber].setSecondName("empty");
                    array1[pumpNumber][CustomerNumber].setVehicleNo("empty");
                    array1[pumpNumber][CustomerNumber].setNoLiters(0);





                    break;
                }
            }
        }


        return Main.totalfuel;
    }




    public static void RemainFuel(int totalfuel)  {

        // can checked remaining fuel liters

        System.out.println("-------------------------------------------------------------------");
        System.out.println(" View Remaining Fuel Stock                        ");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Remaining Fuel=" + totalfuel);
        if (totalfuel <= Main.warning) {
            System.out.println("You don't have enough fuel!!!");
        } else {
            System.out.println("You have remainig" + totalfuel + "liters");

        }


    }

    public static void AddFuel(int totalfuel) { // add fuel

        System.out.println("-------------------------------------------------------------------");
        System.out.println("         Add Fuel Stock.                ");
        System.out.println("---------------------------------------------------------------");
        int emptyfuel = 6600 - totalfuel;
        System.out.println("liters that you want to add :" + emptyfuel);
        totalfuel += emptyfuel;
        System.out.println("New Fuel Stock:" + totalfuel);
    }

    public static void incomeFuel(Passenger[][] array1) { //calculate the income of fuel

        System.out.println("-------------------------------------------------------------------");
        System.out.println("             Income of fuel        ");
        System.out.println("---------------------------------------------------------------");

        System.out.println("Income of fuel is  :"+"Rs" +total_income);


    }

    public static void Exit() {
        System.exit(0);
    }
}










