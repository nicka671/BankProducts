package bank;

import java.util.Arrays;
import java.util.HashSet;

import static bank.AvailableCurrency.*;

public abstract class BankProduct {
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double refillBalance(double money) {
        balance = balance + money;
        return balance;
    }

    public HashSet<AvailableCurrency> getCurrency() {
        return currency;
    }

    public void addNewCurrency(String newCurrency)
    {
        if (Arrays.stream(AvailableCurrency.values()).anyMatch(s->s.toString().equals(newCurrency))) //смотрим, работает ли наш банк с желаемой валютой
        {
            currency.add(AvailableCurrency.valueOf(newCurrency));
            System.out.println("Валюта добавлена");
        } else
        {
            bankDoesntWorkWithThisCurrency = "Наш банк не работает с данной валютой";
            System.out.println(bankDoesntWorkWithThisCurrency);
        }

    }
    protected String cardName;
    protected double balance;
    protected HashSet<AvailableCurrency> currency = new HashSet<>(Arrays.asList(RUB, USD));

    public String getBankDoesntWorkWithThisCurrency() {
        return bankDoesntWorkWithThisCurrency;
    }

    private String bankDoesntWorkWithThisCurrency;

}
