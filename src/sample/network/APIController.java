package sample.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sample.ui.dashboard.acc.BankResponse;
import sample.ui.dashboard.student.response.StudentCompleteResponse;
import sample.ui.login.LoginRequest;
import sample.ui.login.LoginResponse;

public interface APIController {

    @POST("user/login")
    Call<LoginResponse> login(@Body LoginRequest tokenRequest);

    @GET("user/")
    Call<StudentCompleteResponse> getAllUsers();

    @GET("user/banks")
    Call<BankResponse> getAllBanks();

}
