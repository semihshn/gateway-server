package com.semihshn.gatewayserver.business.openFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "driver-service"//Name of driver-service application
        , path = "/api/drivers"//Pre-path for driver-service
        , url = "${driver.service.url}"
        , configuration = FeignConfiguration.class
)
public interface IDriverService {

    @PostMapping
    Object saveDriver(@RequestBody Object requestBody);

    @DeleteMapping("{userId}")
    void deleteDriver(@PathVariable("userId") Long userId);


    @GetMapping("{driverId}")
    Object getDriverById(@PathVariable("driverId") Long driverId);


    @GetMapping("/users/{userId}")
    Object getDriverOfAuthorizedUser(@PathVariable("userId") Long userId);

}
