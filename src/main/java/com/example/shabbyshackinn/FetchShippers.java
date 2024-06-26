package com.example.shabbyshackinn;

import com.example.shabbyshackinn.configuration.IntegrationProperties;
import com.example.shabbyshackinn.models.Shippers;
import com.example.shabbyshackinn.repos.ShipperRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.net.URL;

@ComponentScan
public class FetchShippers implements CommandLineRunner {

    @Autowired
    IntegrationProperties integrationProperties;

    ShipperRepo shipperRepo;


    public FetchShippers(ShipperRepo shipperRepo) {
        this.shipperRepo = shipperRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Run FetchShippers");
        ObjectMapper objectMapper = new ObjectMapper();
        Shippers[] shippers = objectMapper.readValue(new URL(integrationProperties.getShippersProperties().getUrl()),
                Shippers[].class);

        for (Shippers s : shippers) {
            shipperRepo.save(s);
        }
    }
}
