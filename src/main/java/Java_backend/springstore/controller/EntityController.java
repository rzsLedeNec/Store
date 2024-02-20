package Java_backend.springstore.controller;

import Java_backend.springstore.entity.*;
import Java_backend.springstore.postman.DevicePostman;
import Java_backend.springstore.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class EntityController {

    EntityService service;

    @GetMapping
    public ResponseEntity<List<ArrayList>> showEntity(){
        return new ResponseEntity<>(service.entity(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Object>> showEntityById(@PathVariable int id){
        return new ResponseEntity<>(service.listEntity(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<List<Object>> createEntityById(@PathVariable int id,@RequestBody DevicePostman devise){
        return new ResponseEntity<>(service.createEntity(id,devise),HttpStatus.OK);
    }

    @PutMapping("/1")
    public ResponseEntity<Pc> updatePc(@RequestBody Pc pc){
        return new  ResponseEntity<>(service.updatePc(pc),HttpStatus.OK);
    }
    @PutMapping("/2")
    public ResponseEntity<Tv> updateTv(@RequestBody Tv tv){
        return new  ResponseEntity<>(service.updateTv(tv),HttpStatus.OK);
    }
    @PutMapping("/3")
    public ResponseEntity<Hoover> updateHoover(@RequestBody Hoover hoover){
        return new  ResponseEntity<>(service.updateHoover(hoover),HttpStatus.OK);
    }
    @PutMapping("/4")
    public ResponseEntity<Refrigerator> updateRefrigerator(@RequestBody Refrigerator refrigerator){
        return new  ResponseEntity<>(service.updateRefrigerator(refrigerator),HttpStatus.OK);
    }
    @PutMapping("/5")
    public ResponseEntity<Smartphone> updateSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(service.updateSmartphone(smartphone),HttpStatus.OK);
    }

    @DeleteMapping("/{number}/{id}")
    public HttpStatus deleteEntityById(@PathVariable int number, @PathVariable int id){
        service.deleteEntity(number,id);
        return HttpStatus.OK;
    }
}
