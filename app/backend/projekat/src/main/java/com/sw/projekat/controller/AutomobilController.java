package com.sw.projekat.controller;

import com.sw.projekat.dto.AutomobilDTO;
import com.sw.projekat.dto.AutomobilQueryDTO;
import com.sw.projekat.dto.QueryDTO;
import com.sw.projekat.service.AutomobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutomobilController {

    @Autowired
    private AutomobilService automobilService;


//    @RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
//    public TestModel getQuestions(@RequestParam(required = true) String type) {
//
//        TestModel product = new TestModel();
//        product.setType(type);
//        automobilService.getProductDiscount(product);
//        return product;
//    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value="/yourTopCars")
    public ResponseEntity<List<AutomobilDTO>> yourTopCars(@RequestBody AutomobilQueryDTO autoQuery){
        List<AutomobilDTO> topCars=automobilService.getYourTopCars(autoQuery);
        return new ResponseEntity<List<AutomobilDTO>>(topCars, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(value="/yourTopCarsBasedOnYou")
    public ResponseEntity<List<AutomobilDTO>> yourTopCarsBasedOnYou(@RequestBody QueryDTO autoQuery){
        List<AutomobilDTO> topCars=automobilService.getYourTopCarsBasedOnYou(autoQuery);
        return new ResponseEntity<List<AutomobilDTO>>(topCars, HttpStatus.OK);
    }
}