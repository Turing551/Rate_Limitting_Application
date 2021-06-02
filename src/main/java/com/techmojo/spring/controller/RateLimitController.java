package com.techmojo.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import java.util.Date;

import com.techmojo.spring.exception.RateCheckException;

@RestController
public class RateLimitController {
    static Logger logger = Logger.getLogger(RateLimitController.class.getName());

    @GetMapping("/tenant")
    @RateLimiter(name = "apiRateLimit", fallbackMethod = "tenantWithdraw")
    public ResponseEntity tenant(@RequestParam(value = "name", defaultValue = "tenant") String name) {
        logger.info("Your request is processed successfully " + new Date());
        return ResponseEntity.ok().body("Your requested is processed and Response is successfull: " + name);        
    }

    public ResponseEntity tenantWithdraw(String name, io.github.resilience4j.ratelimiter.RequestNotPermitted ex) {
        logger.info("Max Request limit reached. Try again " + new Date());
        throw new RateCheckException("Requests limit is reached. Try again after the block period");
    }
}
