# Diagram

<img src="img.png"/>

- As Gateway server monolith, I used the SOA architecture infrastructure because it didn't have much room to grow, so we can say that SOA is a layered architecture, but it does give us strength, if the project grows, not as much as a hexagonal and DDD-enhanced structure

<br/>

# Documentation

## basicAuthentication for Sign In and Sign Up end points: 
Username: "randomSecureKeyUsername!", Password: "randomSecureKeyPassword!"

### Request(Sign Up)

#### URI: http://localhost:5555/api/authentication/sign-up
<span style="color:orange">POST</span>
```json
{
  "username":"Test_username",
  "password":"Test_pasw",
  "name":"Test_name"
}
```
<hr/>

### Request(Sign In)
#### URI: http://localhost:5555/api/authentication/sign-in
<span style="color:orange">POST</span>

<span style="color:yellow">It return a jwt</span>
```json
{
  "username":"Test_username",
  "password":"Test_pasw",
  "name":"Test_name"
}
```

or

```json
{
  "username":"Test_username",
  "password":"Test_pasw"
}
```

<hr/>

### Request(Add Driver)
#### URI: http://localhost:5555/gateway/driver
<span style="color:orange">POST</span>

<span style="color:red">Require JWT</span>
```json
{
  "userId":1,
  "firstName":"Test_name",
  "lastName":"Test_last_name",
  "birthDate":"2014-04-29"
}
```

<hr/>

### Request(Get Driver)
#### URI: http://localhost:5555/gateway/driver/{driverId}
<span style="color:green">GET</span>

<span style="color:red">Require JWT</span>

<hr/>

### Request(Get Driver According To Auth)
#### URI: http://localhost:5555/gateway/driver/authed/{userId}
<span style="color:green">GET</span>

<span style="color:red">Require JWT</span>

<hr/>

### Request(Delete Driver By driverId)
#### URI: http://localhost:5555/gateway/driver/{driverId}
<span style="color:red">DELETE</span>

<span style="color:red">Require JWT</span>

<hr/>

### Request(Add Passenger)
#### URI: http://localhost:5555/gateway/passenger
<span style="color:orange">POST</span>

<span style="color:red">Require JWT</span>
```json
{
  "userId":1,
  "firstName":"Test_name",
  "lastName":"Test_last_name",
  "birthDate":"2014-04-29"
}
```

<hr/>

### Request(Get Passenger)
#### URI: http://localhost:5555/gateway/passenger/{passengerId}
<span style="color:green">GET</span>

<span style="color:red">Require JWT</span>

<hr/>

### Request(Get Passenger)
#### URI: http://localhost:5555/gateway/passenger/authed/{userId}
<span style="color:green">GET</span>

<span style="color:red">Require JWT</span>

<hr/>

### Request(Delete Passenger By passengerId)
#### URI: http://localhost:5555/gateway/passenger/{passengerId}
<span style="color:red">DELETE</span>

<span style="color:red">Require JWT</span>

<hr/>

# Docker

- Open terminal
- Go to gateway-server directory
- Run command that ``` docker run build -t gateway-server-image .```
- Run command that ``` docker run --name gateway-server-container -p 5555:5555 gateway-server-image ```