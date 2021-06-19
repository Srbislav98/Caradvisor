package com.sw.projekat.controller;

import com.sw.projekat.dto.AutomobilDTO;
import com.sw.projekat.dto.AutomobilQueryDTO;
import com.sw.projekat.dto.QueryDTO;
import com.sw.projekat.mapper.AutomobilDTOMapper;
import com.sw.projekat.model.Automobil;
import com.sw.projekat.service.AutomobilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value="/create")
    public ResponseEntity<AutomobilDTO> yourTopCarsBasedOnYou(@RequestBody AutomobilDTO autoDTO) throws Exception {
        automobilService.createCar(autoDTO);
        return new ResponseEntity<AutomobilDTO>(autoDTO, HttpStatus.OK);
    }
//    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @RequestMapping(value= "/by-page",method = RequestMethod.GET)
    public ResponseEntity<Page<AutomobilDTO>> getAllCars(Pageable pageable) {
        Page<Automobil> page = automobilService.findAll(pageable);
        List<AutomobilDTO> automobilDTOS = toAutomobilDTOList(page.toList());
        Page<AutomobilDTO> pageautomobilDTOS = new PageImpl<>(automobilDTOS,page.getPageable(),page.getTotalElements());

        return new ResponseEntity<>(pageautomobilDTOS, HttpStatus.OK);
    }
    //    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    @RequestMapping(value = "/filter-by-content-page/{content}", method = RequestMethod.GET)
    public ResponseEntity<Page<AutomobilDTO>> getAllCarsContent(@PathVariable String content, Pageable pageable) {
        Page<Automobil> page = automobilService.filterByContentPage(pageable,content);
        List<AutomobilDTO> automobilDTOS = toAutomobilDTOList(page.toList());
        Page<AutomobilDTO> pageautomobilDTOS = new PageImpl<>(automobilDTOS,page.getPageable(),page.getTotalElements());
        return new ResponseEntity<>(pageautomobilDTOS, HttpStatus.OK);
    }
    @RequestMapping(value = "/getCar/{naziv}", method = RequestMethod.GET)
    public ResponseEntity<AutomobilDTO> getCar(@PathVariable String naziv ) {
        Automobil a = automobilService.getCar(naziv);
        AutomobilDTO dto = AutomobilDTOMapper.toDTO(a);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/deleteCar/{naziv}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCar(@PathVariable String naziv){
        try {
            System.out.println("naziv1");
            automobilService.deleteCar(naziv);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private List<AutomobilDTO> toAutomobilDTOList(List<Automobil> automobils){
        List<AutomobilDTO> automobilDTOs = new ArrayList<>();
        for (Automobil a : automobils){
            automobilDTOs.add(AutomobilDTOMapper.toDTO(a));
        }
        return automobilDTOs;
    }
}