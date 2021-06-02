# Rate Limitting Application 

### Description:

Rate Limiting Means ability to make sure your API can be used only for X number of times in a particular time period

### Requirements and Tools:

- Spring Boot
- Resilience4j     
- Apache Log4j
- Maven      
- VS Code

### Features:

- Used Resilience4j Rate Limiter feature to implement this usecase. Resilience4j is a lightweight fault tolerance library. Lightweight, because the library only uses Vavr, which does not have any other external library dependencies. 

The main purpose of Rate Limiter is to block too frequent requests and also we can configure parameters like 
- `the period of the limit refresh`
- `the permissions limit for the refresh period`
- `the default wait for permission duration`

Below is the `application.yml` file used for configuring the number of requests and the block period.

```
resilience4j:
    ratelimiter:
        configs:
            default:
                limitForPeriod: 15        # Number of requests within a period
                limitRefreshPeriod: 3600s # Time Period in seconds
                timeoutDuration: 0
        instances:
            apiRateLimit:
                baseConfig: default 
```
- #### Implemented Exception Handling and Logging using Apache Log4j

### Screenshots of the output for reference

| <p align="center"><img src="https://user-images.githubusercontent.com/37957322/120439607-54cf7d80-c3a0-11eb-8780-6b3f1ed21949.png"/><br/>Success Response</p> |<p align="center"><img src="https://user-images.githubusercontent.com/37957322/120439614-56994100-c3a0-11eb-9f9c-54ccc70f02ad.png"/><br/>Request limit reached</p> | 
|--|--|
                

| <p align="center"><img src="https://user-images.githubusercontent.com/37957322/120439899-aa0b8f00-c3a0-11eb-99ba-b72e0c182bc9.png"/><br/>`Configuration: 5 Requests per 1min(60s)`</p> |<p align="center"><img src="https://user-images.githubusercontent.com/37957322/120439907-abd55280-c3a0-11eb-9380-4a29d2b6629b.png"/><br/>`Configuration: 15 Requests per 1hr(3600s)`</p> | 
|--|--|

