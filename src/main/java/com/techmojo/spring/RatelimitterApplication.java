package com.techmojo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;

@SpringBootApplication
public class RatelimitterApplication {

    static Logger logger = Logger.getLogger(RatelimitterApplication.class.getName());  
    
    public static void main(String[] args) {
        SpringApplication.run(RatelimitterApplication.class, args);
    }

}
