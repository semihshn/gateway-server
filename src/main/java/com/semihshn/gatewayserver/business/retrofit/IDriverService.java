package com.semihshn.gatewayserver.business.retrofit;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

public interface IDriverService {

    @POST("/api/drivers")
    Call<JsonElement> saveDriver(@Body JsonElement requestBody);

    @DELETE("/api/drivers/{userId}")
    Call<Void> deleteDriver(@Path("userId") Long userId);

    @GET("/api/drivers/{driverId}")
    Call<JsonElement> getDriverById(@Path("driverId") Long driverId);

    @GET("/api/drivers/{userId}")
    Call<JsonElement> getDriverOfAuthorizedUser(@Path("userId") Long userId);
}
