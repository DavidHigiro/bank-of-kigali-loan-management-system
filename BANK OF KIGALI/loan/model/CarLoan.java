package loan.model;

public class CarLoan extends LoanManager {
    private String carModel;

    public CarLoan(String loanId, double loanAmount, double interestRate,
                   int duration, String carModel) {
        super(loanId, "Car", loanAmount, interestRate, duration, "Pending",
              "Officer", "Kigali");
        this.carModel = carModel;
    }

    @Override
    public boolean checkEligibility() {
        return getLoanAmount() <= 20000000;
    }

    @Override
    public double calculateInterest() {
        return getLoanAmount() * 0.11;
    }

    @Override
    public String generateLoanReport() {
        return "Car Loan for model: " + carModel;
    }

    @Override
    public String toString() {
        return super.toString() + ", Car Model: " + carModel;
    }
}