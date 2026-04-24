package loan.service;

import loan.model.*;

public class LoanFactory {

    public static LoanManager createLoan(
            String type,
            String loanId,
            double loanAmount,
            double interestRate,
            int duration,
            Object extraParam
    ) {

        switch (type.toLowerCase()) {

            case "personal":
                return new PersonalLoan(
                        loanId, loanAmount, interestRate, duration,
                        (String) extraParam   
                );

            case "home":
                return new HomeLoan(
                        loanId, loanAmount, interestRate, duration,
                        (Double) extraParam   
                );

            case "car":
                return new CarLoan(
                        loanId, loanAmount, interestRate, duration,
                        (String) extraParam   
                );

            case "business":
                return new BusinessLoan(
                        loanId, loanAmount, interestRate, duration,
                        (String) extraParam  
                );

            case "student":
                return new StudentLoan(
                        loanId, loanAmount, interestRate, duration,
                        (String) extraParam   
                );

            case "agricultural":
                return new AgriculturalLoan(
                        loanId, loanAmount, interestRate, duration,
                        (Double) extraParam   
                );

            default:
                throw new IllegalArgumentException(
                        "Invalid loan type. Choose: personal, home, car, business, student, agricultural"
                );
        }
    }
}