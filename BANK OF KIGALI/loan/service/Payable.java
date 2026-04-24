package loan.service;

public interface Payable {
    void processPayment(double amount);
    double calculateRemainingBalance();
    String generatePaymentReceipt();
}