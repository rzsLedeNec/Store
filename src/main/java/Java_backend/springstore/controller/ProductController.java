package Java_backend.springstore.controller;

import Java_backend.springstore.model.Product;
import Java_backend.springstore.postman.DevicePostman;
import Java_backend.springstore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> show(){
        return new ResponseEntity<>(service.show(),HttpStatus.OK);
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<List<Product>> reedById(@PathVariable int id){
        return new ResponseEntity<>(service.showByDeviceId(id),HttpStatus.OK);
    }
}
