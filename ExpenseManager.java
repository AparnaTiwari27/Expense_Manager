import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    double amount;
    String category;
    String description;

    // Constructor
    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    // Display expense details
    public String toString() {
        return "Amount: ₹" + amount + ", Category: " + category + ", Description: " + description;
    }
}

public class ExpenseManager {
    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nExpense Manager Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add an expense
    public static void addExpense() {
        System.out.print("Enter amount: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter category (e.g., Food, Travel, Shopping): ");
        String category = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        expenses.add(new Expense(amount, category, description));
        System.out.println("Expense added successfully!");
    }

    // Method to view all expenses
    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\nYour Expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    // Method to delete an expense
    public static void deleteExpense() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to delete.");
            return;
        }

        viewExpenses();
        System.out.print("Enter the number of the expense to delete: ");
        int index = scanner.nextInt();

        if (index > 0 && index <= expenses.size()) {
            expenses.remove(index - 1);
            System.out.println("Expense deleted successfully!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}