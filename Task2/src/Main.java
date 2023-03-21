



//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1907403
//Date: 07.08.2022



import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static int totalfuel = 6600;

    final static int warning = 500;


    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Passenger[][] array1 = new Passenger[6][7];    //initializing 2D array with
        for (int pumpNumber = 1; pumpNumber < array1.length; pumpNumber++) {
            for (int CustomerNumber = 1; CustomerNumber <array1[pumpNumber].length; CustomerNumber++) {
                array1[pumpNumber][CustomerNumber] = new Passenger();
            }
        }
        Main main = new Main();
        FuelQueue.initialise(array1);
        main.Mainmenu(array1);
    }
    static String choice;

    public static void Mainmenu(Passenger[][] array1) throws IOException {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Welcome to the Aradhana Fuel Center");
        System.out.println("--------------------------------------------------------------------");
        System.out.println
                ("""
                        [100 or VFQ]:  View all Fuel Queue                   [101 or VEQ] : View all empty Queues.  \s
                        [102 or ACQ]: Add customer to a Queue                [103 or RCQ] : Remove a customer form a Queue
                        [104 or PCQ]: Remove a served customer               [105 or VCS] : View Customers Sorted in alphabetical order\s
                        [106 or SPD]: Store Program Data into file.          [107 or LPD] : Load Program Data from file\s
                        [108 or STK]: View Remaining Fuel Stock.             [109 or AFS] : Add Fuel Stock.
                        [110 or IFQ]: Income of Fuel                         [999 or EXT]: Exit""");
        while (true) {
            System.out.print("Enter and option to continue > ");
            choice = input.next();
            switch (choice) {
                case "100", "VFQ" -> FuelQueue.ViewAllQueue(array1);
                case "101", "VEQ" -> FuelQueue.ViewEmpQueue(array1);
                case "102", "ACQ" -> FuelQueue.AddCustomer(array1);
                case "103", "RCQ" -> FuelQueue.RemoveCustomer(array1);
                case "104", "PCQ" -> FuelQueue.RemoveSerCustomer(array1);
                case "105", "VCS" -> FuelQueue.ViewCustomerSort(array1);
                case "106", "SPD" -> FuelQueue.StoreProgram(array1);
                case "107", "LPD" -> FuelQueue.LoadProgram();
                case "108", "STK" -> FuelQueue.RemainFuel(totalfuel);
                case "109", "AFS" -> FuelQueue.AddFuel(totalfuel);
               case "110", "IFQ" -> FuelQueue.incomeFuel(array1);
                case "999", "EXT"->   FuelQueue.Exit();
                 //break;
                default -> System.out.println("Enter valid option ");
            }
        }
    }


}
