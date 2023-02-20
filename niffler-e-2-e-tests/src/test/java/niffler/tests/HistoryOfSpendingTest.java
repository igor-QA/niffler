package niffler.tests;

import niffler.api.spend.dto.SpendDto;
import niffler.jupiter.spend.WithSpend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static niffler.models.Category.PRODUCTS;

class HistoryOfSpendingTest extends BaseTest {

    @WithSpend(amount = 2_500.0, username = "ipavlov")
    private SpendDto restaurantSpend;

    @WithSpend(category = PRODUCTS, amount = 1_000.0, description = "Пятерочка", username = "ipavlov")
    private SpendDto productSpend;

    @BeforeEach
    void login() {
        landingPage.open()
                .clickLoginButton();
        loginPage.login("ipavlov", "12345");
    }
    @Test
    void historyOfSpendingTableContainsSpending() {
        homePage.getSpendingTable()
                .checkContainsSpending(restaurantSpend, productSpend);
    }
}