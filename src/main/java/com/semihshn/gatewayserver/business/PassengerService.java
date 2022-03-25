package com.semihshn.gatewayserver.business;

import com.google.gson.JsonElement;
import com.semihshn.gatewayserver.business.retrofit.IPassengerService;
import com.semihshn.gatewayserver.core.utilities.RetrofitUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PassengerService {

    @Autowired
    private IPassengerService passengerService;

    public JsonElement savePassenger(JsonElement requestBody)
    {
        return RetrofitUtil.executeInBlock(passengerService.savePassenger(requestBody));
    }

    public void deletePassenger(Long passengerId)
    {
        RetrofitUtil.executeInBlock(passengerService.deletePassenger(passengerId));
    }

    public JsonElement getPassengerById(Long passengerId)
    {
        return RetrofitUtil.executeInBlock(passengerService.getPassengerById(passengerId));
    }
}
