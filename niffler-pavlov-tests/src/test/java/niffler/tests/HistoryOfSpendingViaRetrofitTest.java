package niffler.tests;

import niffler.BaseTest;
import niffler.api.client.NifflerSpendClient;
import niffler.api.client.NifflerSpendService;
import niffler.api.spend.dto.SpendDto;
import niffler.jupiter.spend.WithSpend;
import niffler.models.Category;
import niffler.models.Currency;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static niffler.models.Category.PRODUCTS;

public class HistoryOfSpendingViaRetrofitTest extends BaseTest {
    private NifflerSpendClient nsc = new NifflerSpendClient();
    private static NifflerSpendService service;
    private SpendDto spend;
    private Category category;
    private Currency currency;

    @BeforeAll
    public static void init() {
        service = NifflerSpendClient
                .createService(NifflerSpendService.class);
    }

    @WithSpend(amount = 2_500.13, username = "ipavlov") //todo Убрать Spend оставить SpendDto + DataFaker
    private SpendDto restaurantSpend;

    @WithSpend(category = PRODUCTS, amount = 1_000.01, description = "Спасибо Саше Кирееву", username = "ipavlov")
    private SpendDto productSpend;

    @BeforeEach
    void login() {
        landingPage.open()
                .clickLoginButton();
        loginPage.login("ipavlov", "12345");
    }
}