package loan.main;


import java.util.Scanner;
import loan.model.*;
import loan.util.InputValidator;
import loan.service.*;


public class LoanSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANK OF KIGALI LOAN SYSTEM =====");

    
        String loanType;
        while (true) {
            System.out.print("Enter Loan Type (personal, home, car, business, student, agricultural): ");
            loanType = sc.nextLine().toLowerCase();

            if (loanType.matches("personal|home|car|business|student|agricultural")) {
                break;
            } else {
                System.out.println("❌ Invalid loan type. Try again.");
            }
        }

        
        String loanId;
        while (true) {
            System.out.print("Enter Loan ID: ");
            loanId = sc.nextLine();

            if (!loanId.isEmpty()) break;
            System.out.println("❌ Loan ID cannot be empty.");
        }

    
        double amount;
        while (true) {
            try {
                System.out.print("Enter Loan Amount: ");
                amount = Double.parseDouble(sc.nextLine());

                if (InputValidator.isValidAmount(amount)) break;

            } catch (Exception e) {
                System.out.println("❌ Invalid number. Try again.");
            }
        }

    
        double rate;
        while (true) {
            try {
                System.out.print("Enter Interest Rate (%): ");
                rate = Double.parseDouble(sc.nextLine());

                if (rate > 0 && rate < 100) break;

                System.out.println("❌ Invalid interest rate.");

            } catch (Exception e) {
                System.out.println("❌ Invalid input.");
            }
        }

    
        int duration;
        while (true) {
            try {
                System.out.print("Enter Duration (months): ");
                duration = Integer.parseInt(sc.nextLine());

                if (duration > 0) break;

                System.out.println("❌ Duration must be positive.");

            } catch (Exception e) {
                System.out.println("❌ Invalid input.");
            }
        }

        
        Object extraParam = null;

        switch (loanType) {
            case "personal":
                System.out.print("Enter Loan Purpose: ");
                extraParam = sc.nextLine();
                break;

            case "home":
                while (true) {
                    try {
                        System.out.print("Enter Property Value: ");
                        extraParam = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("❌ Invalid value.");
                    }
                }
                break;

            case "car":
                System.out.print("Enter Car Model: ");
                extraParam = sc.nextLine();
                break;

            case "business":
                System.out.print("Enter Business Type: ");
                extraParam = sc.nextLine();
                break;

            case "student":
                System.out.print("Enter University Name: ");
                extraParam = sc.nextLine();
                break;

            case "agricultural":
                while (true) {
                    try {
                        System.out.print("Enter Farm Size (hectares): ");
                        extraParam = Double.parseDouble(sc.nextLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("❌ Invalid value.");
                    }
                }
                break;
        }

    
        LoanManager loan = LoanFactory.createLoan(
                loanType, loanId, amount, rate, duration, extraParam
        );

    
        if (loan.checkEligibility()) {
            loan.approveLoan();
        } else {
            loan.rejectLoan();
        }

    
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        String phone;
        while (true) {
            System.out.print("Enter Phone Number: ");
            phone = sc.nextLine();

            if (InputValidator.isValidPhone(phone)) break;
            System.out.println("❌ Invalid phone number.");
        }

        Customer customer = new Customer("C001", name, "NID123", phone);

    
        double payment;
        while (true) {
            try {
                System.out.print("Enter Payment Amount: ");
                payment = Double.parseDouble(sc.nextLine());

                if (payment > 0) break;

                System.out.println("❌ Payment must be positive.");

            } catch (Exception e) {
                System.out.println("❌ Invalid input.");
            }
        }

        loan.processPayment(payment);

    
        System.out.println("\n===== LOAN DETAILS =====");
        System.out.println(loan);

        System.out.println("\n===== CUSTOMER DETAILS =====");
        System.out.println(customer);

        System.out.println("\n===== REPAYMENT =====");
        System.out.println("Remaining Balance: " + loan.calculateRemainingBalance());
        System.out.println(loan.generatePaymentReceipt());

        System.out.println("\n===== THANK YOU =====");
        sc.close();
    }
}