package com.semihshn.gatewayserver.business;

import com.google.gson.JsonElement;
import com.semihshn.gatewayserver.business.retrofit.IDriverService;
import com.semihshn.gatewayserver.core.utilities.RetrofitUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DriverService {

    @Autowired
    private IDriverService driverService;

    public JsonElement saveDriver(JsonElement driver)
    {
        return RetrofitUtil.executeInBlock(driverService.saveDriver(driver));
    }

    public void deleteDriver(Long driverId)
    {
        RetrofitUtil.executeInBlock(driverService.deleteDriver(driverId));
    }

    public JsonElement getDriverById(Long driverId)
    {
        return RetrofitUtil.executeInBlock(driverService.getDriverById(driverId));
    }

}
