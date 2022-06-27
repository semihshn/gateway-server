package com.semihshn.gatewayserver.ws;

import com.semihshn.gatewayserver.business.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public ResponseEntity<?> savePassenger(@RequestBody Object passenger)
    {
        return ResponseEntity.ok(passengerService.savePassenger(passenger));
    }

    @DeleteMapping("{passengerId}")
    public ResponseEntity<?> deletePassenger(@PathVariable Long passengerId)
    {
        passengerService.deletePassenger(passengerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{passengerId}")
    public ResponseEntity<?> getPassengerById(@PathVariable Long passengerId)
    {
        return ResponseEntity.ok(passengerService.getPassengerById(passengerId));
    }

    @GetMapping("authed/{userId}")
    public ResponseEntity<?> getPassengerOfAuthorizedUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(passengerService.getPassengerOfAuthorizedUser(userId));
    }
}
