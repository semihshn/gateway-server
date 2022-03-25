package com.semihshn.gatewayserver.ws;

import com.google.gson.JsonElement;
import com.semihshn.gatewayserver.business.DriverService;
import com.semihshn.gatewayserver.business.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<?> saveDriver(@RequestBody JsonElement driver)
    {
        return ResponseEntity.ok(driverService.saveDriver(driver));
    }

    @DeleteMapping("{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long driverId)
    {
        driverService.deleteDriver(driverId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{driverId}")
    public ResponseEntity<?> getDriverById(@PathVariable Long driverId)
    {
        return ResponseEntity.ok(driverService.getDriverById(driverId));
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getDriverOfAuthorizedUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(driverService.getDriverOfAuthorizedUser(userId));
    }
}
