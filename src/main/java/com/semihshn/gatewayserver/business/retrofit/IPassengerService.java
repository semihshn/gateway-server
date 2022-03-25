package com.semihshn.gatewayserver.business.retrofit;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

public interface IPassengerService {

    @POST("/api/passengers")
    Call<JsonElement> savePassenger(@Body JsonElement requestBody);

    @DELETE("/api/passengers/{userId}")
    Call<Void> deletePassenger(@Path("userId") Long userId);

    @GET("/api/passengers/{passengerId}")
    Call<JsonElement> getPassengerById(@Path("passengerId") Long passengerId);

    @GET("/api/passengers/{userId}")
    Call<JsonElement> getPassengerOfAuthorizedUser(@Path("userId") Long userId);
}
