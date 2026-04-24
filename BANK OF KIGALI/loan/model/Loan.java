package loan.model;

public abstract class Loan {

   
    private String loanId;
    private String loanType;
    private double loanAmount;
    private double interestRate;
    private int loanDuration; 
    private String loanStatus;

   
    public Loan() {
    }

    
    public Loan(String loanId, String loanType, double loanAmount,
                double interestRate, int loanDuration, String loanStatus) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanDuration = loanDuration;
        this.loanStatus = loanStatus;
    }

    

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    

    public abstract double calculateInterest();

    public abstract double calculateMonthlyInstallment();

    public abstract boolean checkEligibility();

    public abstract void approveLoan();

    public abstract void rejectLoan();

    public abstract double calculateTotalRepayment();

    public abstract String generateLoanReport();

    public abstract boolean validateLoanDetails();

    
    @Override
    public String toString() {
        return "Loan ID: " + loanId +
                ", Type: " + loanType +
                ", Amount: " + loanAmount +
                ", Interest Rate: " + interestRate +
                ", Duration: " + loanDuration +
                ", Status: " + loanStatus;
    }
}