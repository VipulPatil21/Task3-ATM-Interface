 
package internship;
import java.util.Scanner;

public class ATM {

	  private static double balance = 10000.0; 
	    private static String transactionHistory = ""; 

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        int choice;

	        do {
	            
	            System.out.println("\nATM MENU:");
	            System.out.println("1. View Balance");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Deposit");
	            System.out.println("4. Transfer");
	            System.out.println("5. Transaction History");
	            System.out.println("6. Quit");
	            System.out.print("Enter choice: ");
	            choice = input.nextInt();

	            
	            switch (choice) {
	                case 1:
	                    viewBalance();
	                    break;
	                case 2:
	                    withdraw();
	                    break;
	                case 3:
	                    deposit();
	                    break;
	                case 4:
	                    transfer();
	                    break;
	                case 5:
	                    transactionHistory();
	                    break;
	                case 6:
	                    System.out.println("Thank you for using this ATM. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 6);
	    }

	    private static void viewBalance() {
	        System.out.printf("Current balance: $%.2f%n", balance);
	    }

	    private static void withdraw() {
	        Scanner input = new Scanner(System.in);
	        System.out.print("Enter amount to withdraw: ");
	        double amount = input.nextDouble();
	        if (amount > balance) {
	            System.out.println("Insufficient funds. Withdrawal cancelled.");
	        } else {
	            balance -= amount;
	            System.out.printf("Withdrawn $%.2f. Current balance: $%.2f%n", amount, balance);
	            transactionHistory += "Withdrawn $" + amount + "\n";
	        }
	    }

	    private static void deposit() {
	        Scanner input = new Scanner(System.in);
	        System.out.print("Enter amount to deposit: ");
	        double amount = input.nextDouble();
	        balance += amount;
	        System.out.printf("Deposited $%.2f. Current balance: $%.2f%n", amount, balance);
	        transactionHistory += "Deposited $" + amount + "\n";
	    }

	    private static void transfer() {
	        Scanner input = new Scanner(System.in);
	        System.out.print("Enter amount to transfer: ");
	        double amount = input.nextDouble();
	        if (amount > balance) {
	            System.out.println("Insufficient funds. Transfer cancelled.");
	        } else {
	            System.out.print("Enter recipient's account number: ");
	            int accountNumber = input.nextInt();
	            System.out.printf("Transferred $%.2f to account %d. Current balance: $%.2f%n", amount, accountNumber, balance - amount);
	            balance -= amount;
	            transactionHistory += "Transferred $" + amount + " to account " + accountNumber + "\n";
	        }
	    }

	    private static void transactionHistory() {
	        System.out.println("Transaction history:\n" + transactionHistory);
	    }
	}

