package bank.deposits;

import bank.BankProduct;

public class Deposit extends BankProduct {
    public void closeDeposit() {
        System.out.println("Со счёта выведено " + getBalance() + " рублей");
        setBalance(0.0);
    }


}
