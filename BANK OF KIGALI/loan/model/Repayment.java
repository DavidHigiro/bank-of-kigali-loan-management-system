package loan.model;

import java.time.LocalDate; 


public class Repayment {

    private String paymentId;
    private Loan loan;
    private double amountPaid;
    private LocalDate paymentDate;
    private double remainingBalance;

    
    public Repayment() {
    }

   
    public Repayment(String paymentId, Loan loan, double amountPaid, LocalDate paymentDate) {
        this.paymentId = paymentId;
        this.loan = loan;
        this.amountPaid = amountPaid;
        this.paymentDate = paymentDate;

        
        if (loan instanceof LoanManager) {
            this.remainingBalance = ((LoanManager) loan).calculateRemainingBalance();
        }
    }

    

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    
    public void updateRemainingBalance() {

        if (loan instanceof LoanManager) {
            LoanManager lm = (LoanManager) loan;

            
            lm.processPayment(amountPaid);

            
            this.remainingBalance = lm.calculateRemainingBalance();
        } else {
            System.out.println("❌ Invalid loan type for repayment.");
        }
    }

    
    @Override
    public String toString() {
        return "Payment ID: " + paymentId +
                ", Amount Paid: " + amountPaid +
                ", Date: " + paymentDate +
                ", Remaining Balance: " + remainingBalance;
    }
}