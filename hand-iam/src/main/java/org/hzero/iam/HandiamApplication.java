package org.hzero.iam;

import org.hzero.autoconfigure.iam.EnableHZeroIam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableHZeroIam
@EnableDiscoveryClient
@SpringBootApplication

public class HandiamApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(HandiamApplication.class, args);
        }

}