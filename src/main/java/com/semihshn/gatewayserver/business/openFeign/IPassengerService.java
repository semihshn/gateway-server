package com.semihshn.gatewayserver.business.openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "passenger-service"//Name of passenger-service application
        , path = "api/passengers"//Pre-path for passenger-service
        , url = "${passenger.service.url}"
        , configuration = FeignConfiguration.class
)
public interface IPassengerService {


    @PostMapping
    Object savePassenger(@RequestBody Object requestBody);


    @DeleteMapping("{userId}")
    void deletePassenger(@PathVariable("userId") Long userId);


    @GetMapping("{passengerId}")
    Object getPassengerById(@PathVariable("passengerId") Long passengerId);


    @GetMapping("/users/{userId}")
    Object getPassengerOfAuthorizedUser(@PathVariable("userId") Long userId);
}
