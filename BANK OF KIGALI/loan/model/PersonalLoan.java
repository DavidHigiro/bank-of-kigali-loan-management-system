package loan.model;

public class PersonalLoan extends LoanManager {
    private String purpose;

    public PersonalLoan(String loanId, double loanAmount, double interestRate,
                        int duration, String purpose) {
        super(loanId, "Personal", loanAmount, interestRate, duration, "Pending",
              "Officer", "Kigali");
        this.purpose = purpose;
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() <= 5000000;
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.12;
    }

    @Override
    public String generateLoanReport() {
        return "Personal Loan for: " + purpose;
    }

    @Override
    public String toString() {
        return super.toString() + ", Purpose: " + purpose;
    }
}