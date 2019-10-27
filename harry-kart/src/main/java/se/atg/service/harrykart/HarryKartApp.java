package se.atg.service.harrykart;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import se.atg.entity.harrykart.HarryKart;

@SpringBootApplication
public class HarryKartApp {
    public static void main(String ... args) {
        SpringApplication.run(HarryKartApp.class, args);
        
    }
} 
