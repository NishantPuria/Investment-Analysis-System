import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Driver {

    private static TheSystem theSystem;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        theSystem = new TheSystem();

        System.out.println("\n--Welcome to the Investment Analysis and Management System--\n");

        boolean exit = false;

        while (!exit) {
          try {
              showActions();
              int userInput = input.nextInt();
              input.nextLine();
              System.out.println();
              switch (userInput) {
                  case 0:
                      System.out.println("Program exit");
                      exit = true;
                      break;
                  case 1:
                      Bond newBond = define_new_bond();
                      theSystem.add_bond(newBond);
                      break;
                  case 2:
                      display_system_bonds();
                      break;
                  case 3:
                      display_system_bonds();
                      calculate_payout();
                      break;
                  case 4:
                      display_system_bonds();
                      calculate_value();
                      break;
                  case 5:
                      display_system_bonds();
                      calculate_macaulay_duration();
                      break;
                  case 6:
                      display_system_bonds();
                      calculate_irr();
                      break;
                  case 7:
                      display_system_bonds();
                      print_one();
                      break;
                  case 8:
                      display_system_bonds();
                      print_all();
              }
            } catch (Exception e) {
              System.out.println("Your input was not recognized. Please try again.\n");
              input.nextLine();
            }
        }
    }

    public static void showActions() {

        System.out.println("Press:\n" +
                "0 - to exit\n" +
                "1 - to create a new bond \n" +
                "2 - to display all bonds in your portfolio (" + theSystem.getPortfolio().size() + " bond(s) in your portfolio)\n" +
                "3 - to calculate the payout of a bond\n" +
                "4 - to calculate the value of a bond\n" +
                "5 - to calculate the macaulay duration of a bond\n" +
                "6 - to calculate the irr of a bond\n"+
                "7 - to calculate all the values for a specific bond \n"+
                "8 - calculate all the values for all the existing bond\n"
                );
    }


    public static void display_system_bonds() {

        ArrayList<Bond> bonds = theSystem.getPortfolio();
        if (bonds.size() == 0) {
          System.out.println("You have no bonds in your portfolio. Please purchase a bond.\n");
        }
        else {
          System.out.println("A list of the bonds in your portfolio: ");
          for (Bond temp : bonds) {
            System.out.println(temp);
          }
          System.out.println("End of list.\n");
        }
    }

    public static void calculate_payout() {

      ArrayList<Bond> bonds = theSystem.getPortfolio();
      System.out.println("Please type the ID number of bond you wish to find the payout for:\n");
      Scanner input = new Scanner(System.in);
      int userInput = 0;
      while (true) {
        userInput = input.nextInt();
        if (userInput > bonds.size() || userInput < 1) {
          System.out.println("Please enter a valid ID:");
        }
        else {
          break;
        }
      }
      Bond bondFound = bonds.get(userInput-1);
      double result = theSystem.payout(bondFound);
      System.out.println(Math.round(result*10000)/10000f + "\n");
    }

    public static void calculate_value() {

      ArrayList<Bond> bonds = theSystem.getPortfolio();
      System.out.println("Please type the ID number of bond you wish to find the value for:\n");
      Scanner input = new Scanner(System.in);
      int userInput = 0;
      while (true) {
        userInput = input.nextInt();
        if (userInput > bonds.size() || userInput < 1) {
          System.out.println("Please enter a valid ID:");
        }
        else {
          break;
        }
      }
      Bond bondFound = bonds.get(userInput-1);
      System.out.println("Please enter the rate of the value:\n");
      double rate = input.nextDouble();
      double result = theSystem.value(bondFound, rate);
      System.out.println("value(" + rate + ") = " + Math.round(result*10000)/10000f + "\n");
    }

    public static void calculate_macaulay_duration() {

      ArrayList<Bond> bonds = theSystem.getPortfolio();
      System.out.println("Please type the ID number of bond you wish to find the macaulay duration for:\n");
      Scanner input = new Scanner(System.in);
      int userInput = 0;
      while (true) {
        userInput = input.nextInt();
        if (userInput > bonds.size() || userInput < 1) {
          System.out.println("Please enter a valid ID:");
        }
        else {
          break;
        }
      }
      Bond bondFound = bonds.get(userInput-1);
      System.out.println("Please enter the rate of the macaulay duration:\n");
      double rate = input.nextDouble();
      double result = theSystem.macaulayDuration(bondFound, rate);
      System.out.println("macaulayDuration(" + rate + ") = " + Math.round(result*10000)/10000f + "\n");
    }

    public static void calculate_irr() {

      ArrayList<Bond> bonds = theSystem.getPortfolio();
      System.out.println("Please type the ID number of bond you wish to find the irr for:\n");
      Scanner input = new Scanner(System.in);
      int userInput = 0;
      while (true) {
        userInput = input.nextInt();
        if (userInput > bonds.size() || userInput < 1) {
          System.out.println("Please enter a valid ID:");
        }
        else {
          break;
        }
      }
      Bond bondFound = bonds.get(userInput-1);
      double result = theSystem.irr(bondFound);
      System.out.println(Math.round(result*10000)/10000f + "\n");
    }
    public static void print_one(){

      ArrayList<Bond> bonds = theSystem.getPortfolio();
      System.out.println("Please type the ID number of bond you wish to print all the calculations result for:\n");
      Scanner input = new Scanner(System.in);
      int userInput = 0;
      while (true) {
        userInput = input.nextInt();
        if (userInput > bonds.size() || userInput < 1) {
          System.out.println("Please enter a valid ID:");
        }
        else {
          break;
        }
      }
      Bond bondFound = bonds.get(userInput-1);
      System.out.println("Please enter the rate:\n");
      double rate = input.nextDouble();
      double result = theSystem.macaulayDuration(bondFound, rate);
      double result1 = theSystem.irr(bondFound);
      double result2 = theSystem.value(bondFound, rate);
      double result3 = theSystem.payout(bondFound);
      System.out.println("Payout :"+ " " + Math.round(result3*10000)/10000f +" "+"value(" + rate + ") = " +
        Math.round(result2*10000)/10000f +" "+"macaulayDuration(" + rate + ") = " + Math.round(result*10000)/10000f + " " +
        "Internal rate return is of: "+ Math.round(result1*10000)/10000f+ "\n");
    }


    public static void print_all(){
      int i = 1;
      Scanner input = new Scanner(System.in);
      ArrayList<Bond> bonds = theSystem.getPortfolio();
      // System.out.println("Please type the ID number of bond you wish to print all the calculations result for:\n");
      System.out.println("Please enter the rate:\n");
      double rate = input.nextDouble();
      for(Bond bondFound : bonds){
      double result = theSystem.macaulayDuration(bondFound, rate);
      double result1 = theSystem.irr(bondFound);
      double result2 = theSystem.value(bondFound, rate);
      double result3 = theSystem.payout(bondFound);
      System.out.println("Bond"+ i + ": "+ bondFound.getName() + "-> "+ "Payout :"+ " " +
        Math.round(result3*10000)/10000f +" "+"value(" + rate + ") = " + Math.round(result2*10000)/10000f +
        " "+"macaulayDuration(" + rate + ") = " + Math.round(result*10000)/10000f + " " + "Internal rate return is of: "+
        Math.round(result1*10000)/10000f+ "\n");
      i+=1;
      }
    }


    public static Bond define_new_bond() {

        Scanner input = new Scanner(System.in);
        System.out.println("--New Bond creation--\n");

        System.out.println("Enter the name of the bond: ");
        String name = input.nextLine();

        double price = 0.0;
        boolean exit0 = false;
        while (exit0 == false) {
          System.out.println("Enter the price of the bond:");
          try {
            price = input.nextDouble();
            while (price < 0) {
              System.out.println("Please enter a positive double.");
              System.out.println("Enter the price of the bond:");
              price = input.nextDouble();
            }
            exit0 = true;
          }
          catch (InputMismatchException e) {
            System.out.println("Please enter a positive double.");
            input.next();
          }
        }
        if (price > theSystem.getBalance()) {
          System.out.println("This bond costs more than your balance (" +
            theSystem.getBalance() +
            "). Therefore, you can only partially purchase this bond.");
        }

        boolean errors = false;

        double coupon = 0.0;
        System.out.println("Enter the coupon of the bond (in %): ");
        do {
          errors = false;
          try {
            coupon = input.nextInt();
            if (coupon <= 0){
              System.out.println("Please enter a positive double.");
              errors = true;
            }
          } catch (InputMismatchException e) {
            System.out.println("Non numerics are not permitted. Please try again.");
            input.nextLine();
            errors = true;
          }
        } while (errors) ;

        errors = false;

        int term = 0;
        System.out.println("Enter the term of the bond (in years):");
        do {
          errors = false;
          try {
            term = input.nextInt();
            if (term <= 0){
              System.out.println("Please enter a positive integer.");
              errors = true;
            }
          } catch (InputMismatchException e) {
            System.out.println("Non integers are not permitted. Please try again.");
            input.nextLine();
            errors = true;
          }
        } while (errors) ;

        int frequency = 1;

        Bond bond = new Bond(name,term,coupon,frequency,price);
        System.out.println();
        System.out.println("You have created a new bond!\n");

        return bond;
    }
}
