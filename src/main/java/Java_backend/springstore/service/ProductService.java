package Java_backend.springstore.service;

import Java_backend.springstore.model.Product;
import Java_backend.springstore.postman.DevicePostman;
import Java_backend.springstore.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final DeviceService deviceService;

    public Product create(DevicePostman deviceDto){

        return productRepository.save(Product.builder()
                .serial_number(deviceDto.getSerial_number())
                .color(deviceDto.getColor())
                .size(deviceDto.getSize())
                .price(deviceDto.getPrice())
                .county(deviceDto.getCounty())
                .company(deviceDto.getCompany())
                .online_order(deviceDto.isOnline_order())
                .credit(deviceDto.isCredit())
                .device(deviceService.findById(deviceDto.getId()))
                .build());
    }

    public List<Product> show(){
        return productRepository.findAll();
    }
    public List<Product> showByDeviceId(int id){
        return productRepository.findByDeviceId(id);
    }
}
