package bank.cards;

import bank.AvailableCurrency;
import bank.Passport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CardTest {
    private Card card = new Card();
    @Mock
    private Passport passport;

    private double assertDelta = 0.01;

    private String testCardName = "Nika";

    @Before
    public void setUp() {
        card.setBalance(0.0);
        card.setCardName(testCardName);
    }

    @Test
    public void checkCardName() {
        String actualCardName = card.getCardName();
        String expectedCardName = testCardName;
        assertEquals("Вернулось некорректное имя карты!", expectedCardName, actualCardName);
    }

    @Test
    public void checkCardRefillTest() {
        Card card = Card.checkingPassport(passport);
        double actualMoneyDeposit = card.refillBalance(10.0);
        double expectedMoneyDeposit = 10.0;
        assertEquals(expectedMoneyDeposit, actualMoneyDeposit, assertDelta);
    }

    @Test
    public void addNewCurrency() {
        card.addNewCurrency("EUR");
        HashSet<AvailableCurrency> actualAvailableCurrencyHashSet = card.getCurrency();
        HashSet<AvailableCurrency> expectedAvailableCurrencyHashSet = new HashSet<AvailableCurrency>();
        for (AvailableCurrency oneCurency : AvailableCurrency.values()) {
            expectedAvailableCurrencyHashSet.add(oneCurency);
        }
        assertEquals(expectedAvailableCurrencyHashSet, actualAvailableCurrencyHashSet);
    }

    @Test
    public void addIncorrectCurrency() {
        card.addNewCurrency("weproi(*&2794");
        String actualIncorrectCurrencyAddingError = card.getBankDoesntWorkWithThisCurrency();
        String expectedIncorrectCurrencyAddingError = "Наш банк не работает с данной валютой";
        assertEquals("Неправильное сообщение об ошибке! (добавлена неподдерживаемая валюта)", expectedIncorrectCurrencyAddingError, actualIncorrectCurrencyAddingError);
    }

    @Test
    public void withdrawSumIsLessThanBalance() {
        card.refillBalance(22.7);
        card.withdrawCash(15);
        double actualBalanceAfterWithdraw = card.getBalance();
        double expectedBalanceAfterWithdraw = 7.7;
        assertEquals(expectedBalanceAfterWithdraw, actualBalanceAfterWithdraw, assertDelta);
    }

    @Test
    public void withdrawSumEqualsBalance() {
        card.refillBalance(22.7);
        card.withdrawCash(22.7);
        double actualBalanceAfterWithdraw = card.getBalance();
        double expectedBalanceAfterWithdraw = 0.0;
        assertEquals(expectedBalanceAfterWithdraw, actualBalanceAfterWithdraw, assertDelta);
    }

    @Test
    public void withdrawSumIsMoreThanBalance() {
        card.refillBalance(15);
        card.withdrawCash(22.7);
        String actualMessage = card.getWithdrawIsMoreThanBalance();
        String expectedMessage = "На вашем балансе недостаточно средств";
        assertEquals("Неправильное сообщение об ошибке! (попытка снятия бОльшего, чем имеется на счету, количества денег)", expectedMessage, actualMessage);
    }
}
