package bank.cards;

import bank.BankProduct;
import bank.Passport;

public class Card extends BankProduct {

    public static Card checkingPassport(Passport passport)
    {
        Card card = null;
        if (!(passport.equals(null)))
        {
            card = new Card();
        }
        else {
            System.out.println("Паспорта нет в базе");
        }
        return card;
    }

    public String getWithdrawIsMoreThanBalance() {
        return withdrawIsMoreThanBalance;
    }

    private String withdrawIsMoreThanBalance;

    public double withdrawCash(double money)
    {
        if(getBalance() >= money)
        {
            setBalance(getBalance() - money);
        } else {
            withdrawIsMoreThanBalance = "На вашем балансе недостаточно средств";
            System.out.println(withdrawIsMoreThanBalance);
        }

        return money;
    }
}
