package bank.cards;

import bank.BankProduct;

public class CreditCard extends Card {

    private double interestRate;

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    private double totalDebt;
}
