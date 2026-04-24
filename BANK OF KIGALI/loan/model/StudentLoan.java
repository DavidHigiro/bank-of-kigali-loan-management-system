package loan.model;

public class StudentLoan extends LoanManager {
    private String universityName;

    public StudentLoan(String loanId, double loanAmount, double interestRate,
                       int duration, String universityName) {
        super(loanId, "Student", loanAmount, interestRate, duration, "Pending",
              "Officer", "Kigali");
        this.universityName = universityName;
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() <= 10000000;
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.08;
    }

    @Override
    public String generateLoanReport() {
        return "Student Loan - University: " + universityName;
    }

    @Override
    public void rejectLoan() {
        setLoanStatus("Rejected (Student criteria not met)");
    }

    @Override
    public String toString() {
        return super.toString() + ", University: " + universityName;
    }
}
