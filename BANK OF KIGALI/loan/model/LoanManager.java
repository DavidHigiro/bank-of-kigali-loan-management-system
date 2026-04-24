package loan.model;

import loan.service.Payable;

public class LoanManager extends Loan implements Payable {

    private String officerName;
    private String branchLocation;
    private double remainingBalance;

   
    public LoanManager() {
        super();
    }

    
    public LoanManager(String loanId, String loanType, double loanAmount,
                       double interestRate, int loanDuration, String loanStatus,
                       String officerName, String branchLocation) {

        super(loanId, loanType, loanAmount, interestRate, loanDuration, loanStatus);

        this.officerName = officerName;
        this.branchLocation = branchLocation;
        this.remainingBalance = loanAmount;
    }

    
    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    

    @Override
    public double calculateInterest() {
        return getLoanAmount() * getInterestRate() / 100;
    }

    @Override
    public double calculateMonthlyInstallment() {
        return calculateTotalRepayment() / getLoanDuration();
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() > 0;
    }

    @Override
    public void approveLoan() {
        setLoanStatus("Approved");
    }

    @Override
    public void rejectLoan() {
        setLoanStatus("Rejected");
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest();
    }

    @Override
    public String generateLoanReport() {
        return "Loan Report: " + toString();
    }

    @Override
    public boolean validateLoanDetails() {
        return getLoanAmount() > 0 && getInterestRate() > 0;
    }

    // 🔷 IMPLEMENT INTERFACE METHODS

    @Override
    public void processPayment(double amount) {
        if (amount > 0 && amount <= remainingBalance) {
            remainingBalance -= amount;
        }
    }

    @Override
    public double calculateRemainingBalance() {
        return remainingBalance;
    }

    @Override
    public String generatePaymentReceipt() {
        return "Payment processed. Remaining Balance: " + remainingBalance;
    }

    
    @Override
    public String toString() {
        return super.toString()
                + ", Officer: " + officerName
                + ", Branch: " + branchLocation
                + ", Remaining Balance: " + remainingBalance;
    }
}