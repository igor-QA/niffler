package niffler.api.spend;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import niffler.api.base.BaseApi;
import niffler.api.spend.endpoint.SpendEndpoint;
import niffler.api.spend.dto.SpendDto;

public final class SpendApi extends BaseApi {

    @Step("Spend api: add new spend")
    public static SpendDto add(SpendDto spendDto) {
        Allure.addAttachment("New spend", spendDto.toString());
        return RestAssured.given().spec(SPEND_APP_REQUEST_SPEC)
                .body(spendDto.toJson())
                .when()
                .post(SpendEndpoint.ADD_SPEND)
                .then().spec(DEFAULT_RESPONSE_SPEC)
                .statusCode(201)
                .extract().as(SpendDto.class);
    }
}