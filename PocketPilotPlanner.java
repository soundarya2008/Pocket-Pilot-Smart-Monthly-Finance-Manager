import java.util.Scanner;

public class PocketPilotPlanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double salary, fixedExpenses, savePercent;
        double protectedSavings, spendable;

        System.out.println("===== POCKETPILOT SMART SALARY PLANNER =====");

        // Taking Inputs
        System.out.print("Enter Monthly Salary: ");
        salary = sc.nextDouble();

        System.out.print("Enter Fixed Expenses (Rent, EMI, Bills): ");
        fixedExpenses = sc.nextDouble();

        System.out.print("Enter Savings Percentage (%): ");
        savePercent = sc.nextDouble();

        // Validation
        if (salary <= 0 || fixedExpenses < 0 || savePercent < 0) {
            System.out.println("⚠ Invalid Input! Please enter valid values.");
            return;
        }

        // Calculations
        protectedSavings = salary * savePercent / 100;
        spendable = salary - fixedExpenses - protectedSavings;

        if (spendable < 0) {
            System.out.println("⚠ Expenses exceed salary! Adjust your values.");
            return;
        }

        System.out.println("\n===== PLAN SUMMARY =====");
        System.out.println("Fixed Expenses: ₹" + fixedExpenses);
        System.out.println("Protected Savings: ₹" + protectedSavings);
        System.out.println("Spendable Budget: ₹" + spendable);

        // Daily Expense Tracking
        while (true) {
            System.out.println("\n1. Add Daily Expense");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Expense Amount: ");
                double expense = sc.nextDouble();

                if (expense > spendable) {
                    System.out.println("⚠ Overspending! Not enough balance.");
                } else {
                    spendable -= expense;
                    System.out.println("✅ Expense Added: ₹" + expense);
                    System.out.println("💰 Remaining Balance: ₹" + spendable);
                }

                if (spendable == 0) {
                    System.out.println("⚠ Spendable balance exhausted!");
                    break;
                }

            } else if (choice == 2) {
                System.out.println("Exiting PocketPilot. Stay financially smart! 💡");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}