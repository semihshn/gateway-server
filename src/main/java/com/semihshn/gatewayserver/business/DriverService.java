package com.semihshn.gatewayserver.business;

import com.semihshn.gatewayserver.business.openFeign.IDriverService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DriverService {

    @Autowired
    private IDriverService driverService;

    public Object saveDriver(Object driver) {
        return driverService.saveDriver(driver);

    }

    public void deleteDriver(Long driverId) {
        driverService.deleteDriver(driverId);
    }

    public Object getDriverById(Long driverId) {
        return driverService.getDriverById(driverId);
    }

    public Object getDriverOfAuthorizedUser(Long userId) {
        return driverService.getDriverOfAuthorizedUser(userId);
    }

}
