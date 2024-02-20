package Java_backend.springstore.controller;

import Java_backend.springstore.model.Device;
import Java_backend.springstore.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService service;


    @GetMapping
    public ResponseEntity<List<Device>> showAll(){
        return new ResponseEntity<>(service.reedAll(),HttpStatus.OK);
    }

    @PostMapping("/{categories}")
    public ResponseEntity<Device> createDevice(@PathVariable String categories){
        return new ResponseEntity<>(service.build(categories),HttpStatus.OK);
    }
}
