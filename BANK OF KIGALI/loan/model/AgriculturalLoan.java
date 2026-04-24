package loan.model;

public class AgriculturalLoan extends LoanManager {
    private double farmSize;

    public AgriculturalLoan(String loanId, double loanAmount, double interestRate,
                            int duration, double farmSize) {
        super(loanId, "Agricultural", loanAmount, interestRate, duration, "Pending",
              "Officer", "Kigali");
        this.farmSize = farmSize;
    }

    @Override
    public boolean checkEligibility() {
        return farmSize >= 1.0;
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.09;
    }

    @Override
    public String generateLoanReport() {
        return "Agricultural Loan - Farm Size: " + farmSize + " hectares";
    }

    @Override
    public double calculateTotalRepayment() {
        return getLoanAmount() + calculateInterest() - 50000; // subsidy example
    }

    @Override
    public String toString() {
        return super.toString() + ", Farm Size: " + farmSize;
    }
}