package com.semihshn.gatewayserver.business;

import com.semihshn.gatewayserver.business.openFeign.IPassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PassengerService {

    @Autowired
    private IPassengerService passengerService;

    public Object savePassenger(Object requestBody)
    {
        return passengerService.savePassenger(requestBody);
    }

    public void deletePassenger(Long passengerId)
    {
        passengerService.deletePassenger(passengerId);
    }

    public Object getPassengerById(Long passengerId)
    {
        return passengerService.getPassengerById(passengerId);
    }

    public Object getPassengerOfAuthorizedUser(Long userId)
    {
        return passengerService.getPassengerOfAuthorizedUser(userId);
    }

}
