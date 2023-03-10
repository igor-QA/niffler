package niffler.api.client;

import niffler.models.Spend;
import retrofit2.Call;
import retrofit2.http.*;

import static niffler.api.spend.endpoint.SpendEndpoint.ADD_SPEND;

public interface NifflerSpendService {
    @POST(ADD_SPEND)
    Call<Spend> addSpend(@Body Spend spend);
}
