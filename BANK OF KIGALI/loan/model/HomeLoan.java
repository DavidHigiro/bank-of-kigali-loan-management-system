package loan.model;

public class HomeLoan extends LoanManager {
    private double propertyValue;

    public HomeLoan(String loanId, double loanAmount, double interestRate,
                    int duration, double propertyValue) {
        super(loanId, "Home", loanAmount, interestRate, duration, "Pending",
              "Officer", "Kigali");
        this.propertyValue = propertyValue;
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() <= propertyValue * 0.8;
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.10;
    }

    @Override
    public String generateLoanReport() {
        return "Home Loan - Property Value: " + propertyValue;
    }

    @Override
    public String toString() {
        return super.toString() + ", Property Value: " + propertyValue;
    }
}
