package loan.model;

public class BusinessLoan extends LoanManager {
    private String businessType;

    public BusinessLoan(String loanId, double loanAmount, double interestRate,
                        int duration, String businessType) {
        super(loanId, "Business", loanAmount, interestRate, duration, "Pending",
              "Officer", "Kigali");
        this.businessType = businessType;
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() <= 50000000;
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.13;
    }

    @Override
    public String generateLoanReport() {
        return "Business Loan - Type: " + businessType;
    }

    @Override
    public void approveLoan() {
        setLoanStatus("Approved for Business");
    }

    @Override
    public String toString() {
        return super.toString() + ", Business Type: " + businessType;
    }
}